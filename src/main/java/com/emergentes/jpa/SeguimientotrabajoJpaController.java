/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.emergentes.jpa;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.emergentes.entidades.Area1;
import com.emergentes.entidades.Area2;
import com.emergentes.entidades.Seguimientotrabajo;
import com.emergentes.entidades.Usuario;
import com.emergentes.jpa.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author HP VICTUS
 */
public class SeguimientotrabajoJpaController implements Serializable {

    public SeguimientotrabajoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Seguimientotrabajo seguimientotrabajo) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Area1 area1Id = seguimientotrabajo.getArea1Id();
            if (area1Id != null) {
                area1Id = em.getReference(area1Id.getClass(), area1Id.getId());
                seguimientotrabajo.setArea1Id(area1Id);
            }
            Area2 area2Id = seguimientotrabajo.getArea2Id();
            if (area2Id != null) {
                area2Id = em.getReference(area2Id.getClass(), area2Id.getId());
                seguimientotrabajo.setArea2Id(area2Id);
            }
            Usuario usuarioId = seguimientotrabajo.getUsuarioId();
            if (usuarioId != null) {
                usuarioId = em.getReference(usuarioId.getClass(), usuarioId.getId());
                seguimientotrabajo.setUsuarioId(usuarioId);
            }
            em.persist(seguimientotrabajo);
            if (area1Id != null) {
                area1Id.getSeguimientotrabajoList().add(seguimientotrabajo);
                area1Id = em.merge(area1Id);
            }
            if (area2Id != null) {
                area2Id.getSeguimientotrabajoList().add(seguimientotrabajo);
                area2Id = em.merge(area2Id);
            }
            if (usuarioId != null) {
                usuarioId.getSeguimientotrabajoList().add(seguimientotrabajo);
                usuarioId = em.merge(usuarioId);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Seguimientotrabajo seguimientotrabajo) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Seguimientotrabajo persistentSeguimientotrabajo = em.find(Seguimientotrabajo.class, seguimientotrabajo.getId());
            Area1 area1IdOld = persistentSeguimientotrabajo.getArea1Id();
            Area1 area1IdNew = seguimientotrabajo.getArea1Id();
            Area2 area2IdOld = persistentSeguimientotrabajo.getArea2Id();
            Area2 area2IdNew = seguimientotrabajo.getArea2Id();
            Usuario usuarioIdOld = persistentSeguimientotrabajo.getUsuarioId();
            Usuario usuarioIdNew = seguimientotrabajo.getUsuarioId();
            if (area1IdNew != null) {
                area1IdNew = em.getReference(area1IdNew.getClass(), area1IdNew.getId());
                seguimientotrabajo.setArea1Id(area1IdNew);
            }
            if (area2IdNew != null) {
                area2IdNew = em.getReference(area2IdNew.getClass(), area2IdNew.getId());
                seguimientotrabajo.setArea2Id(area2IdNew);
            }
            if (usuarioIdNew != null) {
                usuarioIdNew = em.getReference(usuarioIdNew.getClass(), usuarioIdNew.getId());
                seguimientotrabajo.setUsuarioId(usuarioIdNew);
            }
            seguimientotrabajo = em.merge(seguimientotrabajo);
            if (area1IdOld != null && !area1IdOld.equals(area1IdNew)) {
                area1IdOld.getSeguimientotrabajoList().remove(seguimientotrabajo);
                area1IdOld = em.merge(area1IdOld);
            }
            if (area1IdNew != null && !area1IdNew.equals(area1IdOld)) {
                area1IdNew.getSeguimientotrabajoList().add(seguimientotrabajo);
                area1IdNew = em.merge(area1IdNew);
            }
            if (area2IdOld != null && !area2IdOld.equals(area2IdNew)) {
                area2IdOld.getSeguimientotrabajoList().remove(seguimientotrabajo);
                area2IdOld = em.merge(area2IdOld);
            }
            if (area2IdNew != null && !area2IdNew.equals(area2IdOld)) {
                area2IdNew.getSeguimientotrabajoList().add(seguimientotrabajo);
                area2IdNew = em.merge(area2IdNew);
            }
            if (usuarioIdOld != null && !usuarioIdOld.equals(usuarioIdNew)) {
                usuarioIdOld.getSeguimientotrabajoList().remove(seguimientotrabajo);
                usuarioIdOld = em.merge(usuarioIdOld);
            }
            if (usuarioIdNew != null && !usuarioIdNew.equals(usuarioIdOld)) {
                usuarioIdNew.getSeguimientotrabajoList().add(seguimientotrabajo);
                usuarioIdNew = em.merge(usuarioIdNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = seguimientotrabajo.getId();
                if (findSeguimientotrabajo(id) == null) {
                    throw new NonexistentEntityException("The seguimientotrabajo with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Seguimientotrabajo seguimientotrabajo;
            try {
                seguimientotrabajo = em.getReference(Seguimientotrabajo.class, id);
                seguimientotrabajo.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The seguimientotrabajo with id " + id + " no longer exists.", enfe);
            }
            Area1 area1Id = seguimientotrabajo.getArea1Id();
            if (area1Id != null) {
                area1Id.getSeguimientotrabajoList().remove(seguimientotrabajo);
                area1Id = em.merge(area1Id);
            }
            Area2 area2Id = seguimientotrabajo.getArea2Id();
            if (area2Id != null) {
                area2Id.getSeguimientotrabajoList().remove(seguimientotrabajo);
                area2Id = em.merge(area2Id);
            }
            Usuario usuarioId = seguimientotrabajo.getUsuarioId();
            if (usuarioId != null) {
                usuarioId.getSeguimientotrabajoList().remove(seguimientotrabajo);
                usuarioId = em.merge(usuarioId);
            }
            em.remove(seguimientotrabajo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Seguimientotrabajo> findSeguimientotrabajoEntities() {
        return findSeguimientotrabajoEntities(true, -1, -1);
    }

    public List<Seguimientotrabajo> findSeguimientotrabajoEntities(int maxResults, int firstResult) {
        return findSeguimientotrabajoEntities(false, maxResults, firstResult);
    }

    private List<Seguimientotrabajo> findSeguimientotrabajoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Seguimientotrabajo.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Seguimientotrabajo findSeguimientotrabajo(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Seguimientotrabajo.class, id);
        } finally {
            em.close();
        }
    }

    public int getSeguimientotrabajoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Seguimientotrabajo> rt = cq.from(Seguimientotrabajo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

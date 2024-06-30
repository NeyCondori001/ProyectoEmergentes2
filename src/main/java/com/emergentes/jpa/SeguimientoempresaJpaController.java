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
import com.emergentes.entidades.Empresa;
import com.emergentes.entidades.Seguimientoempresa;
import com.emergentes.entidades.Usuario;
import com.emergentes.jpa.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author HP VICTUS
 */
public class SeguimientoempresaJpaController implements Serializable {

    public SeguimientoempresaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Seguimientoempresa seguimientoempresa) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Empresa empresaId = seguimientoempresa.getEmpresaId();
            if (empresaId != null) {
                empresaId = em.getReference(empresaId.getClass(), empresaId.getId());
                seguimientoempresa.setEmpresaId(empresaId);
            }
            Usuario usuarioId = seguimientoempresa.getUsuarioId();
            if (usuarioId != null) {
                usuarioId = em.getReference(usuarioId.getClass(), usuarioId.getId());
                seguimientoempresa.setUsuarioId(usuarioId);
            }
            em.persist(seguimientoempresa);
            if (empresaId != null) {
                empresaId.getSeguimientoempresaList().add(seguimientoempresa);
                empresaId = em.merge(empresaId);
            }
            if (usuarioId != null) {
                usuarioId.getSeguimientoempresaList().add(seguimientoempresa);
                usuarioId = em.merge(usuarioId);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Seguimientoempresa seguimientoempresa) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Seguimientoempresa persistentSeguimientoempresa = em.find(Seguimientoempresa.class, seguimientoempresa.getId());
            Empresa empresaIdOld = persistentSeguimientoempresa.getEmpresaId();
            Empresa empresaIdNew = seguimientoempresa.getEmpresaId();
            Usuario usuarioIdOld = persistentSeguimientoempresa.getUsuarioId();
            Usuario usuarioIdNew = seguimientoempresa.getUsuarioId();
            if (empresaIdNew != null) {
                empresaIdNew = em.getReference(empresaIdNew.getClass(), empresaIdNew.getId());
                seguimientoempresa.setEmpresaId(empresaIdNew);
            }
            if (usuarioIdNew != null) {
                usuarioIdNew = em.getReference(usuarioIdNew.getClass(), usuarioIdNew.getId());
                seguimientoempresa.setUsuarioId(usuarioIdNew);
            }
            seguimientoempresa = em.merge(seguimientoempresa);
            if (empresaIdOld != null && !empresaIdOld.equals(empresaIdNew)) {
                empresaIdOld.getSeguimientoempresaList().remove(seguimientoempresa);
                empresaIdOld = em.merge(empresaIdOld);
            }
            if (empresaIdNew != null && !empresaIdNew.equals(empresaIdOld)) {
                empresaIdNew.getSeguimientoempresaList().add(seguimientoempresa);
                empresaIdNew = em.merge(empresaIdNew);
            }
            if (usuarioIdOld != null && !usuarioIdOld.equals(usuarioIdNew)) {
                usuarioIdOld.getSeguimientoempresaList().remove(seguimientoempresa);
                usuarioIdOld = em.merge(usuarioIdOld);
            }
            if (usuarioIdNew != null && !usuarioIdNew.equals(usuarioIdOld)) {
                usuarioIdNew.getSeguimientoempresaList().add(seguimientoempresa);
                usuarioIdNew = em.merge(usuarioIdNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = seguimientoempresa.getId();
                if (findSeguimientoempresa(id) == null) {
                    throw new NonexistentEntityException("The seguimientoempresa with id " + id + " no longer exists.");
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
            Seguimientoempresa seguimientoempresa;
            try {
                seguimientoempresa = em.getReference(Seguimientoempresa.class, id);
                seguimientoempresa.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The seguimientoempresa with id " + id + " no longer exists.", enfe);
            }
            Empresa empresaId = seguimientoempresa.getEmpresaId();
            if (empresaId != null) {
                empresaId.getSeguimientoempresaList().remove(seguimientoempresa);
                empresaId = em.merge(empresaId);
            }
            Usuario usuarioId = seguimientoempresa.getUsuarioId();
            if (usuarioId != null) {
                usuarioId.getSeguimientoempresaList().remove(seguimientoempresa);
                usuarioId = em.merge(usuarioId);
            }
            em.remove(seguimientoempresa);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Seguimientoempresa> findSeguimientoempresaEntities() {
        return findSeguimientoempresaEntities(true, -1, -1);
    }

    public List<Seguimientoempresa> findSeguimientoempresaEntities(int maxResults, int firstResult) {
        return findSeguimientoempresaEntities(false, maxResults, firstResult);
    }

    private List<Seguimientoempresa> findSeguimientoempresaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Seguimientoempresa.class));
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

    public Seguimientoempresa findSeguimientoempresa(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Seguimientoempresa.class, id);
        } finally {
            em.close();
        }
    }

    public int getSeguimientoempresaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Seguimientoempresa> rt = cq.from(Seguimientoempresa.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

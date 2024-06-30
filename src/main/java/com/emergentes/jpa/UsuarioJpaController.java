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
import com.emergentes.entidades.Seguimientoempresa;
import java.util.ArrayList;
import java.util.List;
import com.emergentes.entidades.Seguimientotrabajo;
import com.emergentes.entidades.Usuario;
import com.emergentes.jpa.exceptions.NonexistentEntityException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author HP VICTUS
 */
public class UsuarioJpaController implements Serializable {

    public UsuarioJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Usuario usuario) {
        if (usuario.getSeguimientoempresaList() == null) {
            usuario.setSeguimientoempresaList(new ArrayList<Seguimientoempresa>());
        }
        if (usuario.getSeguimientotrabajoList() == null) {
            usuario.setSeguimientotrabajoList(new ArrayList<Seguimientotrabajo>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Seguimientoempresa> attachedSeguimientoempresaList = new ArrayList<Seguimientoempresa>();
            for (Seguimientoempresa seguimientoempresaListSeguimientoempresaToAttach : usuario.getSeguimientoempresaList()) {
                seguimientoempresaListSeguimientoempresaToAttach = em.getReference(seguimientoempresaListSeguimientoempresaToAttach.getClass(), seguimientoempresaListSeguimientoempresaToAttach.getId());
                attachedSeguimientoempresaList.add(seguimientoempresaListSeguimientoempresaToAttach);
            }
            usuario.setSeguimientoempresaList(attachedSeguimientoempresaList);
            List<Seguimientotrabajo> attachedSeguimientotrabajoList = new ArrayList<Seguimientotrabajo>();
            for (Seguimientotrabajo seguimientotrabajoListSeguimientotrabajoToAttach : usuario.getSeguimientotrabajoList()) {
                seguimientotrabajoListSeguimientotrabajoToAttach = em.getReference(seguimientotrabajoListSeguimientotrabajoToAttach.getClass(), seguimientotrabajoListSeguimientotrabajoToAttach.getId());
                attachedSeguimientotrabajoList.add(seguimientotrabajoListSeguimientotrabajoToAttach);
            }
            usuario.setSeguimientotrabajoList(attachedSeguimientotrabajoList);
            em.persist(usuario);
            for (Seguimientoempresa seguimientoempresaListSeguimientoempresa : usuario.getSeguimientoempresaList()) {
                Usuario oldUsuarioIdOfSeguimientoempresaListSeguimientoempresa = seguimientoempresaListSeguimientoempresa.getUsuarioId();
                seguimientoempresaListSeguimientoempresa.setUsuarioId(usuario);
                seguimientoempresaListSeguimientoempresa = em.merge(seguimientoempresaListSeguimientoempresa);
                if (oldUsuarioIdOfSeguimientoempresaListSeguimientoempresa != null) {
                    oldUsuarioIdOfSeguimientoempresaListSeguimientoempresa.getSeguimientoempresaList().remove(seguimientoempresaListSeguimientoempresa);
                    oldUsuarioIdOfSeguimientoempresaListSeguimientoempresa = em.merge(oldUsuarioIdOfSeguimientoempresaListSeguimientoempresa);
                }
            }
            for (Seguimientotrabajo seguimientotrabajoListSeguimientotrabajo : usuario.getSeguimientotrabajoList()) {
                Usuario oldUsuarioIdOfSeguimientotrabajoListSeguimientotrabajo = seguimientotrabajoListSeguimientotrabajo.getUsuarioId();
                seguimientotrabajoListSeguimientotrabajo.setUsuarioId(usuario);
                seguimientotrabajoListSeguimientotrabajo = em.merge(seguimientotrabajoListSeguimientotrabajo);
                if (oldUsuarioIdOfSeguimientotrabajoListSeguimientotrabajo != null) {
                    oldUsuarioIdOfSeguimientotrabajoListSeguimientotrabajo.getSeguimientotrabajoList().remove(seguimientotrabajoListSeguimientotrabajo);
                    oldUsuarioIdOfSeguimientotrabajoListSeguimientotrabajo = em.merge(oldUsuarioIdOfSeguimientotrabajoListSeguimientotrabajo);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Usuario usuario) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Usuario persistentUsuario = em.find(Usuario.class, usuario.getId());
            List<Seguimientoempresa> seguimientoempresaListOld = persistentUsuario.getSeguimientoempresaList();
            List<Seguimientoempresa> seguimientoempresaListNew = usuario.getSeguimientoempresaList();
            List<Seguimientotrabajo> seguimientotrabajoListOld = persistentUsuario.getSeguimientotrabajoList();
            List<Seguimientotrabajo> seguimientotrabajoListNew = usuario.getSeguimientotrabajoList();
            List<Seguimientoempresa> attachedSeguimientoempresaListNew = new ArrayList<Seguimientoempresa>();
            for (Seguimientoempresa seguimientoempresaListNewSeguimientoempresaToAttach : seguimientoempresaListNew) {
                seguimientoempresaListNewSeguimientoempresaToAttach = em.getReference(seguimientoempresaListNewSeguimientoempresaToAttach.getClass(), seguimientoempresaListNewSeguimientoempresaToAttach.getId());
                attachedSeguimientoempresaListNew.add(seguimientoempresaListNewSeguimientoempresaToAttach);
            }
            seguimientoempresaListNew = attachedSeguimientoempresaListNew;
            usuario.setSeguimientoempresaList(seguimientoempresaListNew);
            List<Seguimientotrabajo> attachedSeguimientotrabajoListNew = new ArrayList<Seguimientotrabajo>();
            for (Seguimientotrabajo seguimientotrabajoListNewSeguimientotrabajoToAttach : seguimientotrabajoListNew) {
                seguimientotrabajoListNewSeguimientotrabajoToAttach = em.getReference(seguimientotrabajoListNewSeguimientotrabajoToAttach.getClass(), seguimientotrabajoListNewSeguimientotrabajoToAttach.getId());
                attachedSeguimientotrabajoListNew.add(seguimientotrabajoListNewSeguimientotrabajoToAttach);
            }
            seguimientotrabajoListNew = attachedSeguimientotrabajoListNew;
            usuario.setSeguimientotrabajoList(seguimientotrabajoListNew);
            usuario = em.merge(usuario);
            for (Seguimientoempresa seguimientoempresaListOldSeguimientoempresa : seguimientoempresaListOld) {
                if (!seguimientoempresaListNew.contains(seguimientoempresaListOldSeguimientoempresa)) {
                    seguimientoempresaListOldSeguimientoempresa.setUsuarioId(null);
                    seguimientoempresaListOldSeguimientoempresa = em.merge(seguimientoempresaListOldSeguimientoempresa);
                }
            }
            for (Seguimientoempresa seguimientoempresaListNewSeguimientoempresa : seguimientoempresaListNew) {
                if (!seguimientoempresaListOld.contains(seguimientoempresaListNewSeguimientoempresa)) {
                    Usuario oldUsuarioIdOfSeguimientoempresaListNewSeguimientoempresa = seguimientoempresaListNewSeguimientoempresa.getUsuarioId();
                    seguimientoempresaListNewSeguimientoempresa.setUsuarioId(usuario);
                    seguimientoempresaListNewSeguimientoempresa = em.merge(seguimientoempresaListNewSeguimientoempresa);
                    if (oldUsuarioIdOfSeguimientoempresaListNewSeguimientoempresa != null && !oldUsuarioIdOfSeguimientoempresaListNewSeguimientoempresa.equals(usuario)) {
                        oldUsuarioIdOfSeguimientoempresaListNewSeguimientoempresa.getSeguimientoempresaList().remove(seguimientoempresaListNewSeguimientoempresa);
                        oldUsuarioIdOfSeguimientoempresaListNewSeguimientoempresa = em.merge(oldUsuarioIdOfSeguimientoempresaListNewSeguimientoempresa);
                    }
                }
            }
            for (Seguimientotrabajo seguimientotrabajoListOldSeguimientotrabajo : seguimientotrabajoListOld) {
                if (!seguimientotrabajoListNew.contains(seguimientotrabajoListOldSeguimientotrabajo)) {
                    seguimientotrabajoListOldSeguimientotrabajo.setUsuarioId(null);
                    seguimientotrabajoListOldSeguimientotrabajo = em.merge(seguimientotrabajoListOldSeguimientotrabajo);
                }
            }
            for (Seguimientotrabajo seguimientotrabajoListNewSeguimientotrabajo : seguimientotrabajoListNew) {
                if (!seguimientotrabajoListOld.contains(seguimientotrabajoListNewSeguimientotrabajo)) {
                    Usuario oldUsuarioIdOfSeguimientotrabajoListNewSeguimientotrabajo = seguimientotrabajoListNewSeguimientotrabajo.getUsuarioId();
                    seguimientotrabajoListNewSeguimientotrabajo.setUsuarioId(usuario);
                    seguimientotrabajoListNewSeguimientotrabajo = em.merge(seguimientotrabajoListNewSeguimientotrabajo);
                    if (oldUsuarioIdOfSeguimientotrabajoListNewSeguimientotrabajo != null && !oldUsuarioIdOfSeguimientotrabajoListNewSeguimientotrabajo.equals(usuario)) {
                        oldUsuarioIdOfSeguimientotrabajoListNewSeguimientotrabajo.getSeguimientotrabajoList().remove(seguimientotrabajoListNewSeguimientotrabajo);
                        oldUsuarioIdOfSeguimientotrabajoListNewSeguimientotrabajo = em.merge(oldUsuarioIdOfSeguimientotrabajoListNewSeguimientotrabajo);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = usuario.getId();
                if (findUsuario(id) == null) {
                    throw new NonexistentEntityException("The usuario with id " + id + " no longer exists.");
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
            Usuario usuario;
            try {
                usuario = em.getReference(Usuario.class, id);
                usuario.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The usuario with id " + id + " no longer exists.", enfe);
            }
            List<Seguimientoempresa> seguimientoempresaList = usuario.getSeguimientoempresaList();
            for (Seguimientoempresa seguimientoempresaListSeguimientoempresa : seguimientoempresaList) {
                seguimientoempresaListSeguimientoempresa.setUsuarioId(null);
                seguimientoempresaListSeguimientoempresa = em.merge(seguimientoempresaListSeguimientoempresa);
            }
            List<Seguimientotrabajo> seguimientotrabajoList = usuario.getSeguimientotrabajoList();
            for (Seguimientotrabajo seguimientotrabajoListSeguimientotrabajo : seguimientotrabajoList) {
                seguimientotrabajoListSeguimientotrabajo.setUsuarioId(null);
                seguimientotrabajoListSeguimientotrabajo = em.merge(seguimientotrabajoListSeguimientotrabajo);
            }
            em.remove(usuario);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Usuario> findUsuarioEntities() {
        return findUsuarioEntities(true, -1, -1);
    }

    public List<Usuario> findUsuarioEntities(int maxResults, int firstResult) {
        return findUsuarioEntities(false, maxResults, firstResult);
    }

    private List<Usuario> findUsuarioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Usuario.class));
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

    public Usuario findUsuario(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Usuario.class, id);
        } finally {
            em.close();
        }
    }

    public int getUsuarioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Usuario> rt = cq.from(Usuario.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

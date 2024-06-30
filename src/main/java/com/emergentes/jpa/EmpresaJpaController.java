/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.emergentes.jpa;

import com.emergentes.entidades.Empresa;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.emergentes.entidades.Seguimientoempresa;
import com.emergentes.jpa.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author HP VICTUS
 */
public class EmpresaJpaController implements Serializable {

    public EmpresaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Empresa empresa) {
        if (empresa.getSeguimientoempresaList() == null) {
            empresa.setSeguimientoempresaList(new ArrayList<Seguimientoempresa>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Seguimientoempresa> attachedSeguimientoempresaList = new ArrayList<Seguimientoempresa>();
            for (Seguimientoempresa seguimientoempresaListSeguimientoempresaToAttach : empresa.getSeguimientoempresaList()) {
                seguimientoempresaListSeguimientoempresaToAttach = em.getReference(seguimientoempresaListSeguimientoempresaToAttach.getClass(), seguimientoempresaListSeguimientoempresaToAttach.getId());
                attachedSeguimientoempresaList.add(seguimientoempresaListSeguimientoempresaToAttach);
            }
            empresa.setSeguimientoempresaList(attachedSeguimientoempresaList);
            em.persist(empresa);
            for (Seguimientoempresa seguimientoempresaListSeguimientoempresa : empresa.getSeguimientoempresaList()) {
                Empresa oldEmpresaIdOfSeguimientoempresaListSeguimientoempresa = seguimientoempresaListSeguimientoempresa.getEmpresaId();
                seguimientoempresaListSeguimientoempresa.setEmpresaId(empresa);
                seguimientoempresaListSeguimientoempresa = em.merge(seguimientoempresaListSeguimientoempresa);
                if (oldEmpresaIdOfSeguimientoempresaListSeguimientoempresa != null) {
                    oldEmpresaIdOfSeguimientoempresaListSeguimientoempresa.getSeguimientoempresaList().remove(seguimientoempresaListSeguimientoempresa);
                    oldEmpresaIdOfSeguimientoempresaListSeguimientoempresa = em.merge(oldEmpresaIdOfSeguimientoempresaListSeguimientoempresa);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Empresa empresa) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Empresa persistentEmpresa = em.find(Empresa.class, empresa.getId());
            List<Seguimientoempresa> seguimientoempresaListOld = persistentEmpresa.getSeguimientoempresaList();
            List<Seguimientoempresa> seguimientoempresaListNew = empresa.getSeguimientoempresaList();
            List<Seguimientoempresa> attachedSeguimientoempresaListNew = new ArrayList<Seguimientoempresa>();
            for (Seguimientoempresa seguimientoempresaListNewSeguimientoempresaToAttach : seguimientoempresaListNew) {
                seguimientoempresaListNewSeguimientoempresaToAttach = em.getReference(seguimientoempresaListNewSeguimientoempresaToAttach.getClass(), seguimientoempresaListNewSeguimientoempresaToAttach.getId());
                attachedSeguimientoempresaListNew.add(seguimientoempresaListNewSeguimientoempresaToAttach);
            }
            seguimientoempresaListNew = attachedSeguimientoempresaListNew;
            empresa.setSeguimientoempresaList(seguimientoempresaListNew);
            empresa = em.merge(empresa);
            for (Seguimientoempresa seguimientoempresaListOldSeguimientoempresa : seguimientoempresaListOld) {
                if (!seguimientoempresaListNew.contains(seguimientoempresaListOldSeguimientoempresa)) {
                    seguimientoempresaListOldSeguimientoempresa.setEmpresaId(null);
                    seguimientoempresaListOldSeguimientoempresa = em.merge(seguimientoempresaListOldSeguimientoempresa);
                }
            }
            for (Seguimientoempresa seguimientoempresaListNewSeguimientoempresa : seguimientoempresaListNew) {
                if (!seguimientoempresaListOld.contains(seguimientoempresaListNewSeguimientoempresa)) {
                    Empresa oldEmpresaIdOfSeguimientoempresaListNewSeguimientoempresa = seguimientoempresaListNewSeguimientoempresa.getEmpresaId();
                    seguimientoempresaListNewSeguimientoempresa.setEmpresaId(empresa);
                    seguimientoempresaListNewSeguimientoempresa = em.merge(seguimientoempresaListNewSeguimientoempresa);
                    if (oldEmpresaIdOfSeguimientoempresaListNewSeguimientoempresa != null && !oldEmpresaIdOfSeguimientoempresaListNewSeguimientoempresa.equals(empresa)) {
                        oldEmpresaIdOfSeguimientoempresaListNewSeguimientoempresa.getSeguimientoempresaList().remove(seguimientoempresaListNewSeguimientoempresa);
                        oldEmpresaIdOfSeguimientoempresaListNewSeguimientoempresa = em.merge(oldEmpresaIdOfSeguimientoempresaListNewSeguimientoempresa);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = empresa.getId();
                if (findEmpresa(id) == null) {
                    throw new NonexistentEntityException("The empresa with id " + id + " no longer exists.");
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
            Empresa empresa;
            try {
                empresa = em.getReference(Empresa.class, id);
                empresa.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The empresa with id " + id + " no longer exists.", enfe);
            }
            List<Seguimientoempresa> seguimientoempresaList = empresa.getSeguimientoempresaList();
            for (Seguimientoempresa seguimientoempresaListSeguimientoempresa : seguimientoempresaList) {
                seguimientoempresaListSeguimientoempresa.setEmpresaId(null);
                seguimientoempresaListSeguimientoempresa = em.merge(seguimientoempresaListSeguimientoempresa);
            }
            em.remove(empresa);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Empresa> findEmpresaEntities() {
        return findEmpresaEntities(true, -1, -1);
    }

    public List<Empresa> findEmpresaEntities(int maxResults, int firstResult) {
        return findEmpresaEntities(false, maxResults, firstResult);
    }

    private List<Empresa> findEmpresaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Empresa.class));
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

    public Empresa findEmpresa(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Empresa.class, id);
        } finally {
            em.close();
        }
    }

    public int getEmpresaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Empresa> rt = cq.from(Empresa.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

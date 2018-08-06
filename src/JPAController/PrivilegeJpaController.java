/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPAController;

import JPAController.exceptions.NonexistentEntityException;
import Model.Privilege;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author abouf
 */
public class PrivilegeJpaController implements Serializable {

    public PrivilegeJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Privilege privilege) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(privilege);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Privilege privilege) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            privilege = em.merge(privilege);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = privilege.getIDSousPrivilege();
                if (findPrivilege(id) == null) {
                    throw new NonexistentEntityException("The privilege with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Privilege privilege;
            try {
                privilege = em.getReference(Privilege.class, id);
                privilege.getIDSousPrivilege();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The privilege with id " + id + " no longer exists.", enfe);
            }
            em.remove(privilege);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Privilege> findPrivilegeEntities() {
        return findPrivilegeEntities(true, -1, -1);
    }

    public List<Privilege> findPrivilegeEntities(int maxResults, int firstResult) {
        return findPrivilegeEntities(false, maxResults, firstResult);
    }

    private List<Privilege> findPrivilegeEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Privilege.class));
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
    
    public List<Privilege> findPrivilegeByRoot(int id){
         EntityManager em = getEntityManager();
         try {
            CriteriaQuery cq = (CriteriaQuery) em.createNamedQuery("Privilege.findByIDPrivilegeFK").setParameter("iDPrivilegeFK", id);
            cq.select(cq.from(Privilege.class));
            Query q = em.createQuery(cq);
            
            return q.getResultList();
        } finally {
            em.close();
        }
    }
    
    
    public Privilege findPrivilege(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Privilege.class, id);
        } finally {
            em.close();
        }
    }

    public int getPrivilegeCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Privilege> rt = cq.from(Privilege.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    
}

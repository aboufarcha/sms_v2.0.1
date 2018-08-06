/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPAController;

import JPAController.exceptions.NonexistentEntityException;
import Model.PrivilegeManagement;
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
public class PrivilegeManagementJpaController implements Serializable {

    public PrivilegeManagementJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PrivilegeManagement privilegeManagement) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(privilegeManagement);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PrivilegeManagement privilegeManagement) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            privilegeManagement = em.merge(privilegeManagement);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = privilegeManagement.getIDPrivilegeM();
                if (findPrivilegeManagement(id) == null) {
                    throw new NonexistentEntityException("The privilegeManagement with id " + id + " no longer exists.");
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
            PrivilegeManagement privilegeManagement;
            try {
                privilegeManagement = em.getReference(PrivilegeManagement.class, id);
                privilegeManagement.getIDPrivilegeM();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The privilegeManagement with id " + id + " no longer exists.", enfe);
            }
            em.remove(privilegeManagement);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PrivilegeManagement> findPrivilegeManagementEntities() {
        return findPrivilegeManagementEntities(true, -1, -1);
    }

    public List<PrivilegeManagement> findPrivilegeManagementEntities(int maxResults, int firstResult) {
        return findPrivilegeManagementEntities(false, maxResults, firstResult);
    }

    private List<PrivilegeManagement> findPrivilegeManagementEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PrivilegeManagement.class));
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

    public PrivilegeManagement findPrivilegeManagement(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PrivilegeManagement.class, id);
        } finally {
            em.close();
        }
    }

    public int getPrivilegeManagementCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PrivilegeManagement> rt = cq.from(PrivilegeManagement.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

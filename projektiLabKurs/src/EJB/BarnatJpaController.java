/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import EJB.exceptions.NonexistentEntityException;
import EJB.exceptions.PreexistingEntityException;
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
 * @author Edmond
 */
public class BarnatJpaController implements Serializable {

    public BarnatJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Barnat barnat) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Farmacisti farmacistiID = barnat.getFarmacistiID();
            if (farmacistiID != null) {
                farmacistiID = em.getReference(farmacistiID.getClass(), farmacistiID.getId());
                barnat.setFarmacistiID(farmacistiID);
            }
            FaturaPacientit faturaID = barnat.getFaturaID();
            if (faturaID != null) {
                faturaID = em.getReference(faturaID.getClass(), faturaID.getId());
                barnat.setFaturaID(faturaID);
            }
            em.persist(barnat);
            if (farmacistiID != null) {
                farmacistiID.getBarnatCollection().add(barnat);
                farmacistiID = em.merge(farmacistiID);
            }
            if (faturaID != null) {
                faturaID.getBarnatCollection().add(barnat);
                faturaID = em.merge(faturaID);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findBarnat(barnat.getId()) != null) {
                throw new PreexistingEntityException("Barnat " + barnat + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Barnat barnat) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Barnat persistentBarnat = em.find(Barnat.class, barnat.getId());
            Farmacisti farmacistiIDOld = persistentBarnat.getFarmacistiID();
            Farmacisti farmacistiIDNew = barnat.getFarmacistiID();
            FaturaPacientit faturaIDOld = persistentBarnat.getFaturaID();
            FaturaPacientit faturaIDNew = barnat.getFaturaID();
            if (farmacistiIDNew != null) {
                farmacistiIDNew = em.getReference(farmacistiIDNew.getClass(), farmacistiIDNew.getId());
                barnat.setFarmacistiID(farmacistiIDNew);
            }
            if (faturaIDNew != null) {
                faturaIDNew = em.getReference(faturaIDNew.getClass(), faturaIDNew.getId());
                barnat.setFaturaID(faturaIDNew);
            }
            barnat = em.merge(barnat);
            if (farmacistiIDOld != null && !farmacistiIDOld.equals(farmacistiIDNew)) {
                farmacistiIDOld.getBarnatCollection().remove(barnat);
                farmacistiIDOld = em.merge(farmacistiIDOld);
            }
            if (farmacistiIDNew != null && !farmacistiIDNew.equals(farmacistiIDOld)) {
                farmacistiIDNew.getBarnatCollection().add(barnat);
                farmacistiIDNew = em.merge(farmacistiIDNew);
            }
            if (faturaIDOld != null && !faturaIDOld.equals(faturaIDNew)) {
                faturaIDOld.getBarnatCollection().remove(barnat);
                faturaIDOld = em.merge(faturaIDOld);
            }
            if (faturaIDNew != null && !faturaIDNew.equals(faturaIDOld)) {
                faturaIDNew.getBarnatCollection().add(barnat);
                faturaIDNew = em.merge(faturaIDNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = barnat.getId();
                if (findBarnat(id) == null) {
                    throw new NonexistentEntityException("The barnat with id " + id + " no longer exists.");
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
            Barnat barnat;
            try {
                barnat = em.getReference(Barnat.class, id);
                barnat.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The barnat with id " + id + " no longer exists.", enfe);
            }
            Farmacisti farmacistiID = barnat.getFarmacistiID();
            if (farmacistiID != null) {
                farmacistiID.getBarnatCollection().remove(barnat);
                farmacistiID = em.merge(farmacistiID);
            }
            FaturaPacientit faturaID = barnat.getFaturaID();
            if (faturaID != null) {
                faturaID.getBarnatCollection().remove(barnat);
                faturaID = em.merge(faturaID);
            }
            em.remove(barnat);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Barnat> findBarnatEntities() {
        return findBarnatEntities(true, -1, -1);
    }

    public List<Barnat> findBarnatEntities(int maxResults, int firstResult) {
        return findBarnatEntities(false, maxResults, firstResult);
    }

    private List<Barnat> findBarnatEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Barnat.class));
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

    public Barnat findBarnat(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Barnat.class, id);
        } finally {
            em.close();
        }
    }

    public int getBarnatCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Barnat> rt = cq.from(Barnat.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

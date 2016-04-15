/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import EJB.exceptions.NonexistentEntityException;
import EJB.exceptions.PreexistingEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Edmond
 */
public class DhomaPacientitJpaController implements Serializable {

    public DhomaPacientitJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(DhomaPacientit dhomaPacientit) throws PreexistingEntityException, Exception {
        if (dhomaPacientit.getPacientiCollection() == null) {
            dhomaPacientit.setPacientiCollection(new ArrayList<Pacienti>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Sektori sektoriID = dhomaPacientit.getSektoriID();
            if (sektoriID != null) {
                sektoriID = em.getReference(sektoriID.getClass(), sektoriID.getId());
                dhomaPacientit.setSektoriID(sektoriID);
            }
            Collection<Pacienti> attachedPacientiCollection = new ArrayList<Pacienti>();
            for (Pacienti pacientiCollectionPacientiToAttach : dhomaPacientit.getPacientiCollection()) {
                pacientiCollectionPacientiToAttach = em.getReference(pacientiCollectionPacientiToAttach.getClass(), pacientiCollectionPacientiToAttach.getId());
                attachedPacientiCollection.add(pacientiCollectionPacientiToAttach);
            }
            dhomaPacientit.setPacientiCollection(attachedPacientiCollection);
            em.persist(dhomaPacientit);
            if (sektoriID != null) {
                sektoriID.getDhomaPacientitCollection().add(dhomaPacientit);
                sektoriID = em.merge(sektoriID);
            }
            for (Pacienti pacientiCollectionPacienti : dhomaPacientit.getPacientiCollection()) {
                DhomaPacientit oldIDdhomaOfPacientiCollectionPacienti = pacientiCollectionPacienti.getIDdhoma();
                pacientiCollectionPacienti.setIDdhoma(dhomaPacientit);
                pacientiCollectionPacienti = em.merge(pacientiCollectionPacienti);
                if (oldIDdhomaOfPacientiCollectionPacienti != null) {
                    oldIDdhomaOfPacientiCollectionPacienti.getPacientiCollection().remove(pacientiCollectionPacienti);
                    oldIDdhomaOfPacientiCollectionPacienti = em.merge(oldIDdhomaOfPacientiCollectionPacienti);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findDhomaPacientit(dhomaPacientit.getId()) != null) {
                throw new PreexistingEntityException("DhomaPacientit " + dhomaPacientit + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(DhomaPacientit dhomaPacientit) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            DhomaPacientit persistentDhomaPacientit = em.find(DhomaPacientit.class, dhomaPacientit.getId());
            Sektori sektoriIDOld = persistentDhomaPacientit.getSektoriID();
            Sektori sektoriIDNew = dhomaPacientit.getSektoriID();
            Collection<Pacienti> pacientiCollectionOld = persistentDhomaPacientit.getPacientiCollection();
            Collection<Pacienti> pacientiCollectionNew = dhomaPacientit.getPacientiCollection();
            if (sektoriIDNew != null) {
                sektoriIDNew = em.getReference(sektoriIDNew.getClass(), sektoriIDNew.getId());
                dhomaPacientit.setSektoriID(sektoriIDNew);
            }
            Collection<Pacienti> attachedPacientiCollectionNew = new ArrayList<Pacienti>();
            for (Pacienti pacientiCollectionNewPacientiToAttach : pacientiCollectionNew) {
                pacientiCollectionNewPacientiToAttach = em.getReference(pacientiCollectionNewPacientiToAttach.getClass(), pacientiCollectionNewPacientiToAttach.getId());
                attachedPacientiCollectionNew.add(pacientiCollectionNewPacientiToAttach);
            }
            pacientiCollectionNew = attachedPacientiCollectionNew;
            dhomaPacientit.setPacientiCollection(pacientiCollectionNew);
            dhomaPacientit = em.merge(dhomaPacientit);
            if (sektoriIDOld != null && !sektoriIDOld.equals(sektoriIDNew)) {
                sektoriIDOld.getDhomaPacientitCollection().remove(dhomaPacientit);
                sektoriIDOld = em.merge(sektoriIDOld);
            }
            if (sektoriIDNew != null && !sektoriIDNew.equals(sektoriIDOld)) {
                sektoriIDNew.getDhomaPacientitCollection().add(dhomaPacientit);
                sektoriIDNew = em.merge(sektoriIDNew);
            }
            for (Pacienti pacientiCollectionOldPacienti : pacientiCollectionOld) {
                if (!pacientiCollectionNew.contains(pacientiCollectionOldPacienti)) {
                    pacientiCollectionOldPacienti.setIDdhoma(null);
                    pacientiCollectionOldPacienti = em.merge(pacientiCollectionOldPacienti);
                }
            }
            for (Pacienti pacientiCollectionNewPacienti : pacientiCollectionNew) {
                if (!pacientiCollectionOld.contains(pacientiCollectionNewPacienti)) {
                    DhomaPacientit oldIDdhomaOfPacientiCollectionNewPacienti = pacientiCollectionNewPacienti.getIDdhoma();
                    pacientiCollectionNewPacienti.setIDdhoma(dhomaPacientit);
                    pacientiCollectionNewPacienti = em.merge(pacientiCollectionNewPacienti);
                    if (oldIDdhomaOfPacientiCollectionNewPacienti != null && !oldIDdhomaOfPacientiCollectionNewPacienti.equals(dhomaPacientit)) {
                        oldIDdhomaOfPacientiCollectionNewPacienti.getPacientiCollection().remove(pacientiCollectionNewPacienti);
                        oldIDdhomaOfPacientiCollectionNewPacienti = em.merge(oldIDdhomaOfPacientiCollectionNewPacienti);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = dhomaPacientit.getId();
                if (findDhomaPacientit(id) == null) {
                    throw new NonexistentEntityException("The dhomaPacientit with id " + id + " no longer exists.");
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
            DhomaPacientit dhomaPacientit;
            try {
                dhomaPacientit = em.getReference(DhomaPacientit.class, id);
                dhomaPacientit.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The dhomaPacientit with id " + id + " no longer exists.", enfe);
            }
            Sektori sektoriID = dhomaPacientit.getSektoriID();
            if (sektoriID != null) {
                sektoriID.getDhomaPacientitCollection().remove(dhomaPacientit);
                sektoriID = em.merge(sektoriID);
            }
            Collection<Pacienti> pacientiCollection = dhomaPacientit.getPacientiCollection();
            for (Pacienti pacientiCollectionPacienti : pacientiCollection) {
                pacientiCollectionPacienti.setIDdhoma(null);
                pacientiCollectionPacienti = em.merge(pacientiCollectionPacienti);
            }
            em.remove(dhomaPacientit);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<DhomaPacientit> findDhomaPacientitEntities() {
        return findDhomaPacientitEntities(true, -1, -1);
    }

    public List<DhomaPacientit> findDhomaPacientitEntities(int maxResults, int firstResult) {
        return findDhomaPacientitEntities(false, maxResults, firstResult);
    }

    private List<DhomaPacientit> findDhomaPacientitEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(DhomaPacientit.class));
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

    public DhomaPacientit findDhomaPacientit(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(DhomaPacientit.class, id);
        } finally {
            em.close();
        }
    }

    public int getDhomaPacientitCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<DhomaPacientit> rt = cq.from(DhomaPacientit.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

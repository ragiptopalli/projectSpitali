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
public class AdresaJpaController implements Serializable {

    public AdresaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Adresa adresa) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Doktori doktoriID = adresa.getDoktoriID();
            if (doktoriID != null) {
                doktoriID = em.getReference(doktoriID.getClass(), doktoriID.getId());
                adresa.setDoktoriID(doktoriID);
            }
            Farmacisti farmacistiID = adresa.getFarmacistiID();
            if (farmacistiID != null) {
                farmacistiID = em.getReference(farmacistiID.getClass(), farmacistiID.getId());
                adresa.setFarmacistiID(farmacistiID);
            }
            Motra motraID = adresa.getMotraID();
            if (motraID != null) {
                motraID = em.getReference(motraID.getClass(), motraID.getId());
                adresa.setMotraID(motraID);
            }
            Pacienti pacientiID = adresa.getPacientiID();
            if (pacientiID != null) {
                pacientiID = em.getReference(pacientiID.getClass(), pacientiID.getId());
                adresa.setPacientiID(pacientiID);
            }
            Puntori puntoriID = adresa.getPuntoriID();
            if (puntoriID != null) {
                puntoriID = em.getReference(puntoriID.getClass(), puntoriID.getId());
                adresa.setPuntoriID(puntoriID);
            }
            Rescepsionisti rescepsionistiID = adresa.getRescepsionistiID();
            if (rescepsionistiID != null) {
                rescepsionistiID = em.getReference(rescepsionistiID.getClass(), rescepsionistiID.getId());
                adresa.setRescepsionistiID(rescepsionistiID);
            }
            em.persist(adresa);
            if (doktoriID != null) {
                doktoriID.getAdresaCollection().add(adresa);
                doktoriID = em.merge(doktoriID);
            }
            if (farmacistiID != null) {
                farmacistiID.getAdresaCollection().add(adresa);
                farmacistiID = em.merge(farmacistiID);
            }
            if (motraID != null) {
                motraID.getAdresaCollection().add(adresa);
                motraID = em.merge(motraID);
            }
            if (pacientiID != null) {
                pacientiID.getAdresaCollection().add(adresa);
                pacientiID = em.merge(pacientiID);
            }
            if (puntoriID != null) {
                puntoriID.getAdresaCollection().add(adresa);
                puntoriID = em.merge(puntoriID);
            }
            if (rescepsionistiID != null) {
                rescepsionistiID.getAdresaCollection().add(adresa);
                rescepsionistiID = em.merge(rescepsionistiID);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findAdresa(adresa.getId()) != null) {
                throw new PreexistingEntityException("Adresa " + adresa + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Adresa adresa) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Adresa persistentAdresa = em.find(Adresa.class, adresa.getId());
            Doktori doktoriIDOld = persistentAdresa.getDoktoriID();
            Doktori doktoriIDNew = adresa.getDoktoriID();
            Farmacisti farmacistiIDOld = persistentAdresa.getFarmacistiID();
            Farmacisti farmacistiIDNew = adresa.getFarmacistiID();
            Motra motraIDOld = persistentAdresa.getMotraID();
            Motra motraIDNew = adresa.getMotraID();
            Pacienti pacientiIDOld = persistentAdresa.getPacientiID();
            Pacienti pacientiIDNew = adresa.getPacientiID();
            Puntori puntoriIDOld = persistentAdresa.getPuntoriID();
            Puntori puntoriIDNew = adresa.getPuntoriID();
            Rescepsionisti rescepsionistiIDOld = persistentAdresa.getRescepsionistiID();
            Rescepsionisti rescepsionistiIDNew = adresa.getRescepsionistiID();
            if (doktoriIDNew != null) {
                doktoriIDNew = em.getReference(doktoriIDNew.getClass(), doktoriIDNew.getId());
                adresa.setDoktoriID(doktoriIDNew);
            }
            if (farmacistiIDNew != null) {
                farmacistiIDNew = em.getReference(farmacistiIDNew.getClass(), farmacistiIDNew.getId());
                adresa.setFarmacistiID(farmacistiIDNew);
            }
            if (motraIDNew != null) {
                motraIDNew = em.getReference(motraIDNew.getClass(), motraIDNew.getId());
                adresa.setMotraID(motraIDNew);
            }
            if (pacientiIDNew != null) {
                pacientiIDNew = em.getReference(pacientiIDNew.getClass(), pacientiIDNew.getId());
                adresa.setPacientiID(pacientiIDNew);
            }
            if (puntoriIDNew != null) {
                puntoriIDNew = em.getReference(puntoriIDNew.getClass(), puntoriIDNew.getId());
                adresa.setPuntoriID(puntoriIDNew);
            }
            if (rescepsionistiIDNew != null) {
                rescepsionistiIDNew = em.getReference(rescepsionistiIDNew.getClass(), rescepsionistiIDNew.getId());
                adresa.setRescepsionistiID(rescepsionistiIDNew);
            }
            adresa = em.merge(adresa);
            if (doktoriIDOld != null && !doktoriIDOld.equals(doktoriIDNew)) {
                doktoriIDOld.getAdresaCollection().remove(adresa);
                doktoriIDOld = em.merge(doktoriIDOld);
            }
            if (doktoriIDNew != null && !doktoriIDNew.equals(doktoriIDOld)) {
                doktoriIDNew.getAdresaCollection().add(adresa);
                doktoriIDNew = em.merge(doktoriIDNew);
            }
            if (farmacistiIDOld != null && !farmacistiIDOld.equals(farmacistiIDNew)) {
                farmacistiIDOld.getAdresaCollection().remove(adresa);
                farmacistiIDOld = em.merge(farmacistiIDOld);
            }
            if (farmacistiIDNew != null && !farmacistiIDNew.equals(farmacistiIDOld)) {
                farmacistiIDNew.getAdresaCollection().add(adresa);
                farmacistiIDNew = em.merge(farmacistiIDNew);
            }
            if (motraIDOld != null && !motraIDOld.equals(motraIDNew)) {
                motraIDOld.getAdresaCollection().remove(adresa);
                motraIDOld = em.merge(motraIDOld);
            }
            if (motraIDNew != null && !motraIDNew.equals(motraIDOld)) {
                motraIDNew.getAdresaCollection().add(adresa);
                motraIDNew = em.merge(motraIDNew);
            }
            if (pacientiIDOld != null && !pacientiIDOld.equals(pacientiIDNew)) {
                pacientiIDOld.getAdresaCollection().remove(adresa);
                pacientiIDOld = em.merge(pacientiIDOld);
            }
            if (pacientiIDNew != null && !pacientiIDNew.equals(pacientiIDOld)) {
                pacientiIDNew.getAdresaCollection().add(adresa);
                pacientiIDNew = em.merge(pacientiIDNew);
            }
            if (puntoriIDOld != null && !puntoriIDOld.equals(puntoriIDNew)) {
                puntoriIDOld.getAdresaCollection().remove(adresa);
                puntoriIDOld = em.merge(puntoriIDOld);
            }
            if (puntoriIDNew != null && !puntoriIDNew.equals(puntoriIDOld)) {
                puntoriIDNew.getAdresaCollection().add(adresa);
                puntoriIDNew = em.merge(puntoriIDNew);
            }
            if (rescepsionistiIDOld != null && !rescepsionistiIDOld.equals(rescepsionistiIDNew)) {
                rescepsionistiIDOld.getAdresaCollection().remove(adresa);
                rescepsionistiIDOld = em.merge(rescepsionistiIDOld);
            }
            if (rescepsionistiIDNew != null && !rescepsionistiIDNew.equals(rescepsionistiIDOld)) {
                rescepsionistiIDNew.getAdresaCollection().add(adresa);
                rescepsionistiIDNew = em.merge(rescepsionistiIDNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = adresa.getId();
                if (findAdresa(id) == null) {
                    throw new NonexistentEntityException("The adresa with id " + id + " no longer exists.");
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
            Adresa adresa;
            try {
                adresa = em.getReference(Adresa.class, id);
                adresa.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The adresa with id " + id + " no longer exists.", enfe);
            }
            Doktori doktoriID = adresa.getDoktoriID();
            if (doktoriID != null) {
                doktoriID.getAdresaCollection().remove(adresa);
                doktoriID = em.merge(doktoriID);
            }
            Farmacisti farmacistiID = adresa.getFarmacistiID();
            if (farmacistiID != null) {
                farmacistiID.getAdresaCollection().remove(adresa);
                farmacistiID = em.merge(farmacistiID);
            }
            Motra motraID = adresa.getMotraID();
            if (motraID != null) {
                motraID.getAdresaCollection().remove(adresa);
                motraID = em.merge(motraID);
            }
            Pacienti pacientiID = adresa.getPacientiID();
            if (pacientiID != null) {
                pacientiID.getAdresaCollection().remove(adresa);
                pacientiID = em.merge(pacientiID);
            }
            Puntori puntoriID = adresa.getPuntoriID();
            if (puntoriID != null) {
                puntoriID.getAdresaCollection().remove(adresa);
                puntoriID = em.merge(puntoriID);
            }
            Rescepsionisti rescepsionistiID = adresa.getRescepsionistiID();
            if (rescepsionistiID != null) {
                rescepsionistiID.getAdresaCollection().remove(adresa);
                rescepsionistiID = em.merge(rescepsionistiID);
            }
            em.remove(adresa);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Adresa> findAdresaEntities() {
        return findAdresaEntities(true, -1, -1);
    }

    public List<Adresa> findAdresaEntities(int maxResults, int firstResult) {
        return findAdresaEntities(false, maxResults, firstResult);
    }

    private List<Adresa> findAdresaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Adresa.class));
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

    public Adresa findAdresa(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Adresa.class, id);
        } finally {
            em.close();
        }
    }

    public int getAdresaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Adresa> rt = cq.from(Adresa.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

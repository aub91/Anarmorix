package fr.afcepf.anarmorix.data.impl;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.afcepf.anarmorix.data.api.IDaoPackaging;
import fr.afcepf.anarmorix.entity.Packaging;
import fr.afcepf.anarmorix.exception.AnarmorixException;
import fr.afcepf.anarmorix.exception.AnarmorixExceptionEnum;

/**
 * Classe implémentant les méthodes de l'{@link IDaoPackaging}.
 */
@Remote(IDaoPackaging.class)
@Stateless
public class DaoPackaging implements IDaoPackaging {

    /**
     * Entity manager.
     */
    @PersistenceContext(unitName = "Anarmorix_Data_Impl")
    private EntityManager em;

    /**
     * Requête permettant de trouver l'ensemble des {@link Catalogue}s d'une exploitation.
     */
    private static final String REQ_RECHERCHE =
            "SELECT p FROM Packaging p WHERE p.libelle LIKE :pLibelle";

    /**
     * Requête permettant de récupérer un catalogue en fonction de son Id.
     */
    private static final String REQ_PACK_ID = "SELECT p FROM Packaging p WHERE p.id = :pId";

    /**
     * Default constructor.
     */
    public DaoPackaging() {
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Packaging> rechercher(String paramLibelle) throws AnarmorixException {
        try {
            List<Packaging> liste =  em.createQuery(REQ_RECHERCHE).setParameter("pLibelle", paramLibelle).getResultList();
            if (liste.size() == 0) {
                AnarmorixException exc = new AnarmorixException("Le libellé n'existe pas.", AnarmorixExceptionEnum.ARGUMENT_INEXISTANT);
                throw exc;
            }
            return liste;
        } catch (Exception e) {
            if (e.getMessage() == "Le libellé n'existe pas.") {
                throw e;
            } else {
                AnarmorixException exc = new AnarmorixException("Message : " + e.getMessage(), AnarmorixExceptionEnum.ERREUR_NON_IDENTIFIEE);
                throw exc;
            }
        }
    }

    @Override
    public Packaging ajouter(Packaging paramPackaging) throws AnarmorixException {
        try {
            em.persist(paramPackaging);
            return paramPackaging;
        } catch (Exception e) {
            AnarmorixException exc =  new AnarmorixException(e.getMessage(), AnarmorixExceptionEnum.ERREUR_NON_IDENTIFIEE);
            throw exc;
        }
    }

    @Override
    public Boolean supprimer(Integer paramId) throws AnarmorixException {
        try {
            Packaging packaging = (Packaging) em.createQuery(REQ_PACK_ID).setParameter("pId", paramId).getSingleResult();
            em.remove(packaging);
            return true;
        } catch (Exception e) {
            AnarmorixException exc =  new AnarmorixException(e.getMessage(), AnarmorixExceptionEnum.ERREUR_NON_IDENTIFIEE);
            throw exc;
        }
    }

    @Override
    public Packaging mettreAJour(Integer paramId) throws AnarmorixException {
        try {
            Packaging packaging = (Packaging) em.createQuery(REQ_PACK_ID).setParameter("pId", paramId).getSingleResult();
            Packaging updated = em.merge(packaging);
            return updated;
        } catch (Exception e) {
            AnarmorixException exc =  new AnarmorixException(e.getMessage(), AnarmorixExceptionEnum.ERREUR_NON_IDENTIFIEE);
            throw exc;
        }
    }

}
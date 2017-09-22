package fr.afcepf.anarmorix.data.impl;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.afcepf.anarmorix.data.api.IDaoCatalogue;
import fr.afcepf.anarmorix.entity.Alea;
import fr.afcepf.anarmorix.entity.Catalogue;
import fr.afcepf.anarmorix.entity.Exploitation;
import fr.afcepf.anarmorix.exception.AnarmorixException;
import fr.afcepf.anarmorix.exception.AnarmorixExceptionEnum;

/**
 * Classe Data permettant la gestion des aleas.
 */
@Remote(IDaoCatalogue.class)
@Stateless
public class DaoCatalogue implements IDaoCatalogue {

    /**
     * Entity manager.
     */
    @PersistenceContext(unitName = "Anarmorix_Data_Impl")
    private EntityManager em;

    /**
     * Requête permettant de trouver l'ensemble des {@link Catalogue}s d'une exploitation.
     */
    private static final String REQ_RECHERCHE =
            "SELECT e.cataloguess FROM Exploitation e WHERE e.id = :pId";

    /**
     * Requête permettant de récupérer un catalogue en fonction de son Id.
     */
    private static final String REQ_CATALOGUE_ID = "Select c FROM Catalogue c WHERE c.id = :pId";

    /**
     * Default constructor.
     */
    public DaoCatalogue() {
    }

    @Override
    public Catalogue ajouter(Catalogue paramCatalogue) throws AnarmorixException {
        try {
            em.persist(paramCatalogue);
            return paramCatalogue;
        } catch (Exception e) {
            AnarmorixException exc =  new AnarmorixException(e.getMessage(), AnarmorixExceptionEnum.ERREUR_NON_IDENTIFIEE);
            throw exc;
        }
    }

    @Override
    public Boolean supprimer(Integer paramId) throws AnarmorixException {
        try {
            Catalogue catalogue = (Catalogue) em.createQuery(REQ_CATALOGUE_ID).setParameter("pId", paramId).getSingleResult();
            em.remove(catalogue);
            return true;
        } catch (Exception e) {
            AnarmorixException exc =  new AnarmorixException(e.getMessage(), AnarmorixExceptionEnum.ERREUR_NON_IDENTIFIEE);
            throw exc;
        }
    }

    @Override
    public Catalogue mettreAJour(Integer paramId) throws AnarmorixException {
        try {
            Catalogue catalogue = (Catalogue) em.createQuery(REQ_CATALOGUE_ID).setParameter("pId", paramId).getSingleResult();
            Catalogue updated = em.merge(catalogue);
            return updated;
        } catch (Exception e) {
            AnarmorixException exc =  new AnarmorixException(e.getMessage(), AnarmorixExceptionEnum.ERREUR_NON_IDENTIFIEE);
            throw exc;
        }
    }

    @Override
    public List<Catalogue> rechercher(Exploitation paramExploitation) throws AnarmorixException {
        try {
            List<Catalogue> liste =  em.createQuery(REQ_RECHERCHE).setParameter("pId", paramExploitation.getId()).getResultList();
            if (liste.size() == 0) {
                AnarmorixException exc = new AnarmorixException("L'exploitation n'existe pas.", AnarmorixExceptionEnum.ARGUMENT_INEXISTANT);
                throw exc;
            }
            return liste;
        } catch (Exception e) {
            if (e.getMessage() == "L'exploitation n'existe pas.") {
                throw e;
            } else {
                AnarmorixException exc = new AnarmorixException("Message : " + e.getMessage(), AnarmorixExceptionEnum.ERREUR_NON_IDENTIFIEE);
                throw exc;
            }
        }
    }

}
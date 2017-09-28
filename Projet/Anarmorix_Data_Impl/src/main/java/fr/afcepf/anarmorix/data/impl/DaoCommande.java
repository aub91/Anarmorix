package fr.afcepf.anarmorix.data.impl;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.afcepf.anarmorix.data.api.IDaoCommande;
import fr.afcepf.anarmorix.entity.Adherent;
import fr.afcepf.anarmorix.entity.Commande;
import fr.afcepf.anarmorix.exception.AnarmorixException;
import fr.afcepf.anarmorix.exception.AnarmorixExceptionEnum;

/**
 * Classe implémentant les méthodes de l'{@link IDaoCommande}.
 */
@Remote(IDaoCommande.class)
@Stateless
public class DaoCommande implements IDaoCommande {

    /**
     * Entity manager.
     */
    @PersistenceContext(unitName = "Anarmorix_Data_Impl")
    private EntityManager em;

    /**
     * Requête permettant de trouver l'ensemble des {@link Catalogue}s d'une exploitation.
     */
    private static final String REQ_RECHERCHE =
            "SELECT c.commandes  FROM Client c WHERE c.id = :pId ";

    /**
     * Requête permettant de récupérer un catalogue en fonction de son Id.
     */
    private static final String REQ_COMMANDE_ID = "Select c FROM Commande c WHERE c.id = :pId ";

    /**
     * Default constructor.
     */
    public DaoCommande() {
    }

    @Override
    public List<Commande> rechercher(Adherent paramClient) throws AnarmorixException {
        try {
            @SuppressWarnings("unchecked")
            List<Commande> liste =  em.createQuery(REQ_RECHERCHE).setParameter("pId", paramClient.getId()).getResultList();
            if (liste.size() == 0) {
                AnarmorixException exc = new AnarmorixException("Le client n'existe pas.", AnarmorixExceptionEnum.ARGUMENT_INEXISTANT);
                throw exc;
            }
            return liste;
        } catch (Exception e) {
            if (e.getMessage() == "Le client n'existe pas.") {
                throw e;
            } else {
                AnarmorixException exc = new AnarmorixException("Message : " + e.getMessage(), AnarmorixExceptionEnum.ERREUR_NON_IDENTIFIEE);
                throw exc;
            }
        }
    }

    @Override
    public Boolean supprimer(Integer paramId) throws AnarmorixException {
        try {
            Commande commande = (Commande) em.createQuery(REQ_COMMANDE_ID).setParameter("pId", paramId).getSingleResult();
            em.remove(commande);
            return true;
        } catch (Exception e) {
            AnarmorixException exc =  new AnarmorixException(e.getMessage(), AnarmorixExceptionEnum.ERREUR_NON_IDENTIFIEE);
            throw exc;
        }
    }

    @Override
    public Commande ajouter(Commande paramCommande)  throws AnarmorixException {
        try {
            em.persist(paramCommande);
            return paramCommande;
        } catch (Exception e) {
            AnarmorixException exc =  new AnarmorixException(e.getMessage(), AnarmorixExceptionEnum.ERREUR_NON_IDENTIFIEE);
            throw exc;
        }
    }

    @Override
    public Commande mettreAJour(Commande paramCommande) throws AnarmorixException {
        try {
            Commande updated = em.merge(paramCommande);
            return updated;
        } catch (Exception e) {
            AnarmorixException exc =  new AnarmorixException(e.getMessage(), AnarmorixExceptionEnum.ERREUR_NON_IDENTIFIEE);
            throw exc;
        }
    }
}
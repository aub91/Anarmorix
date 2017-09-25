package fr.afcepf.anarmorix.data.impl;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.afcepf.anarmorix.data.api.IDaoLigneCommande;
import fr.afcepf.anarmorix.entity.Commande;
import fr.afcepf.anarmorix.entity.LigneCommande;
import fr.afcepf.anarmorix.entity.Tournee;
import fr.afcepf.anarmorix.exception.AnarmorixException;
import fr.afcepf.anarmorix.exception.AnarmorixExceptionEnum;

/**
 * Classe Data permettant la gestion des lignes commandes.
 */
@Remote(IDaoLigneCommande.class)
@Stateless
public class DaoLigneCommande implements IDaoLigneCommande {

    /**
     * Entity manager.
     */
    @PersistenceContext(unitName = "Anarmorix_Data_Impl")
    private EntityManager em;

    /**
     * Requête permettant de trouver l'ensemble des lignes d'une {@link Commande}.
     */
    private static final String REQ_RECHERCHE =
            "SELECT c.lignesCommande FROM Commande c WHERE c.id = :pId";
    /**
     * Requête permettant de récupérer une ligne commande en fonction de son Id.
     */
    private static final String REQ_LIGNE_ID = "Select l FROM LigneCommande l WHERE l.id = :pId";

    /**
     * Default constructor.
     */
    public DaoLigneCommande() {
    }

//Attention, l'exception argument inexistant devrait sans doute être côté business.
    /**
     * Méthode retournant l'ensemble des lignes d'une {@link Commande}.
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<LigneCommande> rechercher(Commande commande) throws AnarmorixException {
       try {
           List<LigneCommande> liste =  em.createQuery(REQ_RECHERCHE).setParameter("pId", commande.getId()).getResultList();
//           return liste;
           if (liste.size() == 0) {
               AnarmorixException exc = new AnarmorixException("La commande n'existe pas.", AnarmorixExceptionEnum.ARGUMENT_INEXISTANT);
               throw exc;
           }
           return liste;
       } catch (Exception e) {
           if (e.getMessage() == "La commande n'existe pas.") {
               throw e;
           } else {
               AnarmorixException exc = new AnarmorixException("Message : " + e.getMessage(), AnarmorixExceptionEnum.ERREUR_NON_IDENTIFIEE);
               throw exc;
           }
       }
    }
    @Override
    public LigneCommande rechercher(Integer paramId) throws AnarmorixException {
        try {
            LigneCommande ligne = (LigneCommande) em.createQuery(REQ_LIGNE_ID).setParameter("pId", paramId).getSingleResult();
            return ligne;
        } catch (Exception e) {
            AnarmorixException exc =  new AnarmorixException(e.getMessage(), AnarmorixExceptionEnum.ERREUR_NON_IDENTIFIEE);
            throw exc;
        }
    }

    @Override
    public LigneCommande ajouter(LigneCommande paramLigneCommande) throws AnarmorixException {
        try {
            em.persist(paramLigneCommande);
            return paramLigneCommande;
        } catch (Exception e) {
            AnarmorixException exc =  new AnarmorixException(e.getMessage(), AnarmorixExceptionEnum.ERREUR_NON_IDENTIFIEE);
            throw exc;
        }
    }

    @Override
    public Boolean supprimer(Integer paramId) throws AnarmorixException {
        try {
            LigneCommande ligne = (LigneCommande) em.createQuery(REQ_LIGNE_ID).setParameter("pId", paramId).getSingleResult();
            em.remove(ligne);
            return true;
        } catch (Exception e) {
            AnarmorixException exc =  new AnarmorixException(e.getMessage(), AnarmorixExceptionEnum.ERREUR_NON_IDENTIFIEE);
            throw exc;
        }
    }

    @Override
    public LigneCommande mettreAJour(Integer paramId) throws AnarmorixException {
        try {
            LigneCommande ligne = (LigneCommande) em.createQuery(REQ_LIGNE_ID).setParameter("pId", paramId).getSingleResult();
            LigneCommande updated = em.merge(ligne);
            return updated;
        } catch (Exception e) {
            AnarmorixException exc = new AnarmorixException(e.getMessage(), AnarmorixExceptionEnum.ERREUR_NON_IDENTIFIEE);
            throw exc;
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public Tournee rechercherByTournee(Tournee paramTournee) throws AnarmorixException {
        List<LigneCommande> liste = null;
        try {
            String hql = "SELECT to.lignesCmd FROM Tournee to WHERE to.id = :paramId";
            Query queryHql = em.createQuery(hql).setParameter("paramId", paramTournee.getId());
            liste = queryHql.getResultList();
            paramTournee.setLignesCmd(liste);
        } catch (Exception e) {
            AnarmorixException exc = new AnarmorixException(e.getMessage(), AnarmorixExceptionEnum.MYSQL_HS);
            throw exc;
        }
        return paramTournee;
    }

}
package fr.afcepf.anarmorix.data.impl;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.afcepf.anarmorix.data.api.IDaoLigneCommande;
import fr.afcepf.anarmorix.entity.Commande;
import fr.afcepf.anarmorix.entity.LigneCommande;
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
     * Default constructor.
     */
    public DaoLigneCommande() {
    }

    /**
     * Méthode retournant l'ensemble des lignes d'une {@link Commande}.
     */
    @Override
    public List<LigneCommande> rechercher(Commande commande) throws AnarmorixException {
       try {
           return em.createQuery(REQ_RECHERCHE).setParameter("pId", commande.getId()).getResultList();
       } catch (Exception e) {
           if (e.getMessage().contains("NullPointer")) {
               AnarmorixException exc = new AnarmorixException("", AnarmorixExceptionEnum.ARGUMENT_INEXISTANT);
           } else {
               AnarmorixException exc = new AnarmorixException("", AnarmorixExceptionEnum.MYSQL_HS);
           }
           return null;
       }
    }

    @Override
    public LigneCommande ajouter(LigneCommande paramLigneCommande) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Boolean supprimer(Integer paramId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public LigneCommande mettreAJour(Integer paramId) {
        // TODO Auto-generated method stub
        return null;
    }

}
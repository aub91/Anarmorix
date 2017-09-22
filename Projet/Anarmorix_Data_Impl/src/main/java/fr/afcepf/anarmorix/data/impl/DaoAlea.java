package fr.afcepf.anarmorix.data.impl;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.afcepf.anarmorix.data.api.IDaoAlea;
import fr.afcepf.anarmorix.data.api.IDaoLigneCommande;
import fr.afcepf.anarmorix.entity.Alea;
import fr.afcepf.anarmorix.entity.Commande;
import fr.afcepf.anarmorix.entity.LigneCommande;
import fr.afcepf.anarmorix.exception.AnarmorixException;
import fr.afcepf.anarmorix.exception.AnarmorixExceptionEnum;

/**
 * Classe Data permettant la gestion des aleas.
 */
@Remote(IDaoAlea.class)
@Stateless
public class DaoAlea implements IDaoAlea {

    /**
     * Entity manager.
     */
    @PersistenceContext(unitName = "Anarmorix_Data_Impl")
    private EntityManager em;

    /**
     * Requête permettant de trouver l'ensemble des lignes d'une {@link Commande}.
     */
    private static final String REQ_RECHERCHE =
            "SELECT l.aleas FROM LigneCommande l WHERE l.id = :pId";
    
    /**
     * Requête permettant de récupérer une ligne commande en fonction de son Id.
     */
    private static final String REQ_ALEA_ID = "Select l FROM LigneCommande l WHERE l.id = :pId";


    /**
     * Default constructor.
     */
    public DaoAlea() {
    }

    @Override
    public List<Alea> rechercher(LigneCommande paramLigne) throws AnarmorixException {
        try {
            List<LigneCommande> liste =  em.createQuery(REQ_RECHERCHE).setParameter("pId", commande.getId()).getResultList();
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
    public Boolean supprimer(Integer paramId) throws AnarmorixException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Alea ajouter(Alea paramAlea) throws AnarmorixException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Alea mettreAJour(Integer paramId) throws AnarmorixException {
        // TODO Auto-generated method stub
        return null;
    }

}
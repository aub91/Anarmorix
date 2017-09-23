package fr.afcepf.anarmorix.data.impl;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.afcepf.anarmorix.data.api.IDaoCommerce;
import fr.afcepf.anarmorix.entity.Commerce;
import fr.afcepf.anarmorix.entity.Exploitation;
import fr.afcepf.anarmorix.entity.PointRelais;
import fr.afcepf.anarmorix.entity.SocieteDeLivraison;
import fr.afcepf.anarmorix.entity.Ville;
import fr.afcepf.anarmorix.exception.AnarmorixException;
import fr.afcepf.anarmorix.exception.AnarmorixExceptionEnum;

/**
 * Classe implémentant les méthodes de l'{@link IDaoCommande}.
 */
@Remote(IDaoCommerce.class)
@Stateless
public class DaoCommerce implements IDaoCommerce {

    /**
     * Entity manager.
     */
    @PersistenceContext(unitName = "Anarmorix_Data_Impl")
    private EntityManager em;

    /**
     * Requête permettant de trouver l'ensemble des {@link Catalogue}s d'une exploitation.
     */
    private static final String REQ_RECHERCHE_COMMERCE =
            "SELECT a.commerces FROM Adresse a AND Ville v WHERE a.ville = v AND v.id = :pId";

    /**
     * Requête permettant de récupérer un catalogue en fonction de son Id.
     */
    private static final String REQ_COMMERCE_ID = "Select c FROM Commerce c WHERE c.id = :pId";

    /**
     * Default constructor
     */
    public DaoCommerce() {
    }

    @Override
    public List<Commerce> rechercherCommerces(Ville paramVille) throws AnarmorixException {
        try {
            List<Commerce> liste =  em.createQuery(REQ_RECHERCHE_COMMERCE).setParameter("pId", paramVille.getCodeInsee()).getResultList();
            if (liste.size() == 0) {
                AnarmorixException exc = new AnarmorixException("La ville n'existe pas.", AnarmorixExceptionEnum.ARGUMENT_INEXISTANT);
                throw exc;
            }
            return liste;
        } catch (Exception e) {
            if (e.getMessage() == "La ville n'existe pas.") {
                throw e;
            } else {
                AnarmorixException exc = new AnarmorixException("Message : " + e.getMessage(), AnarmorixExceptionEnum.ERREUR_NON_IDENTIFIEE);
                throw exc;
            }
        }
    }

    @Override
    public List<Exploitation> rechercherExploitations(Ville paramVille) throws AnarmorixException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<PointRelais> rechercherPointsRelais(Ville paramVille) throws AnarmorixException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<SocieteDeLivraison> rechercherSocietesDeLivraison(Ville paramVille) throws AnarmorixException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Commerce ajouter(Commerce paramCommerce) throws AnarmorixException {
        try {
            em.persist(paramCommerce);
            return paramCommerce;
        } catch (Exception e) {
            AnarmorixException exc =  new AnarmorixException(e.getMessage(), AnarmorixExceptionEnum.ERREUR_NON_IDENTIFIEE);
            throw exc;
        }
    }

    @Override
    public Boolean supprimer(Integer paramId) throws AnarmorixException {
        try {
            Commerce commande = (Commerce) em.createQuery(REQ_COMMERCE_ID).setParameter("pId", paramId).getSingleResult();
            em.remove(commande);
            return true;
        } catch (Exception e) {
            AnarmorixException exc =  new AnarmorixException(e.getMessage(), AnarmorixExceptionEnum.ERREUR_NON_IDENTIFIEE);
            throw exc;
        }
    }

    @Override
    public Commerce mettreAJour(Integer paramId) throws AnarmorixException {
        try {
            Commerce commande = (Commerce) em.createQuery(REQ_COMMERCE_ID).setParameter("pId", paramId).getSingleResult();
            Commerce updated = em.merge(commande);
            return updated;
        } catch (Exception e) {
            AnarmorixException exc =  new AnarmorixException(e.getMessage(), AnarmorixExceptionEnum.ERREUR_NON_IDENTIFIEE);
            throw exc;
        }
    }
}
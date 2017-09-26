package fr.afcepf.anarmorix.data.impl;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.afcepf.anarmorix.data.api.IDaoCommerce;
import fr.afcepf.anarmorix.entity.Catalogue;
import fr.afcepf.anarmorix.entity.Commerce;
import fr.afcepf.anarmorix.entity.Exploitation;
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
     * Requête permettant de trouver l'ensemble des {@link Commerce}s d'une ville.
     */
    private static final String REQ_RECHERCHE_COMMERCE =
            "SELECT a.commerces FROM Adresse a AND Ville v WHERE a.ville = :vId";

    /**
     * Requête permettant de trouver l'ensemble des {@link PointRelais} d'une ville.
     */
    private static final String REQ_PT_REL =
            "SELECT pr FROM PointRelais pr, Adresse a WHERE pr.adresse = a AND a.ville = :pV";

    /**
     * Requête permettant de trouver l'ensemble des {@link Exploitation}s d'une ville.
     */
    private static final String REQ_EXPLOITATION =
            "SELECT e FROM Exploitation e, Adresse a WHERE e.adresse = a AND a.ville = :pV";

    /**
     * Requête permettant de trouver l'ensemble des {@link PointRelais} d'une ville.
     */
    private static final String REQ_SOCIETE =
            "SELECT se FROM SocieteDeLivraison s, Adresse a WHERE s.adresse = a AND a.ville = :pV";

    /**
     * Requête permettant de récupérer un commerce en fonction de son Id.
     */
    private static final String REQ_COMMERCE_ID = "Select c FROM Commerce c WHERE c.id = :pId";

    /**
     * Default constructor.
     */
    public DaoCommerce() {
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Commerce> rechercherCommerces(Ville paramVille) throws AnarmorixException {
        try {
            List<Commerce> liste =  em.createQuery(REQ_RECHERCHE_COMMERCE).setParameter("vId", paramVille).getResultList();
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
<<<<<<< HEAD
    public List<Exploitation> rechercherExploitations(Ville paramVille) throws AnarmorixException {
        try {
            List<Exploitation> liste =  em.createQuery(REQ_EXPLOITATION).setParameter("pV", paramVille).getResultList();
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
    public List<PointRelais> rechercherPointsRelais(Ville paramVille) throws AnarmorixException {
        try {
            List<PointRelais> liste =  em.createQuery(REQ_PT_REL).setParameter("pV", paramVille).getResultList();
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
=======
>>>>>>> aubin
    public List<SocieteDeLivraison> rechercherSocietesDeLivraison(Ville paramVille) throws AnarmorixException {
        try {
            List<SocieteDeLivraison> liste =  em.createQuery(REQ_SOCIETE).setParameter("pV", paramVille).getResultList();
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

    @Override
    public Catalogue rechercherExploitationByCatalogue(Catalogue paramCatalogue) throws AnarmorixException {
        Exploitation retour = null;
        try {
            String hql = "SELECT c.exploitation FROM Catalogue c WHERE c.id = :pid";
            retour = (Exploitation) em.createQuery(hql).setParameter("pid", paramCatalogue.getId()).getSingleResult();
            paramCatalogue.setExploitation(retour);
        } catch (Exception e) {
            AnarmorixException exc = new AnarmorixException("", AnarmorixExceptionEnum.ERREUR_NON_IDENTIFIEE);
            throw exc;
        }
        return paramCatalogue;
    }
}
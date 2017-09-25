package fr.afcepf.anarmorix.data.impl;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.afcepf.anarmorix.data.api.IDaoUnitePackaging;
import fr.afcepf.anarmorix.entity.UnitePackaging;
import fr.afcepf.anarmorix.exception.AnarmorixException;
import fr.afcepf.anarmorix.exception.AnarmorixExceptionEnum;

/**
 * Classe implementant l'{@link IDaoUnitePackaging}.
 */
@Remote(IDaoUnitePackaging.class)
@Stateless
public class DaoUnitePackaging implements IDaoUnitePackaging {

    /**
     * Entity manager.
     */
    @PersistenceContext(unitName = "Anarmorix_Data_Impl")
    private EntityManager em;

    /**
     * Requête permettant de trouver des {@link Recette}s en fonction d'un nom.
     */
    private static final String REQ_RECHERCHE =
            "SELECT u FROM UnitePackaging u WHERE u.libelle LIKE :pLibelle";

    /**
     * Requête permettant de récupérer une recette en fonction de son Id.
     */
    private static final String REQ_UNITE_ID = "SELECT u FROM UnitePackaging u WHERE u.id = :pId";

    /**
     * Default constructor.
     */
    public DaoUnitePackaging() {
    }

    @Override
    public List<UnitePackaging> rechercher(String paramUnite) throws AnarmorixException {
        try {
            List<UnitePackaging> liste =  em.createQuery(REQ_RECHERCHE).setParameter("pLibelle", paramUnite).getResultList();
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
    public UnitePackaging ajouter(UnitePackaging paramUnitePackaging) throws AnarmorixException {
        try {
            em.persist(paramUnitePackaging);
            return paramUnitePackaging;
        } catch (Exception e) {
            AnarmorixException exc =  new AnarmorixException(e.getMessage(), AnarmorixExceptionEnum.ERREUR_NON_IDENTIFIEE);
            throw exc;
        }
    }

    @Override
    public Boolean supprimer(Integer paramId) throws AnarmorixException {
        try {
            UnitePackaging unitePackaging= (UnitePackaging) em.createQuery(REQ_UNITE_ID).setParameter("pId", paramId).getSingleResult();
            em.remove(unitePackaging);
            return true;
        } catch (Exception e) {
            AnarmorixException exc =  new AnarmorixException(e.getMessage(), AnarmorixExceptionEnum.ERREUR_NON_IDENTIFIEE);
            throw exc;
        }
    }

    @Override
    public UnitePackaging mettreAJour(Integer paramId) throws AnarmorixException {
        try {
            UnitePackaging unitePackaging= (UnitePackaging) em.createQuery(REQ_UNITE_ID).setParameter("pId", paramId).getSingleResult();
            UnitePackaging updated = em.merge(unitePackaging);
            return updated;
        } catch (Exception e) {
            AnarmorixException exc =  new AnarmorixException(e.getMessage(), AnarmorixExceptionEnum.ERREUR_NON_IDENTIFIEE);
            throw exc;
        }
    }

}
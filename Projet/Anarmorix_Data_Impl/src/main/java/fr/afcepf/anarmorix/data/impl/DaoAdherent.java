package fr.afcepf.anarmorix.data.impl;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.afcepf.anarmorix.data.api.IDaoAdherent;
import fr.afcepf.anarmorix.entity.Adherent;
import fr.afcepf.anarmorix.exception.AnarmorixException;

/**
 * classe gérant l'accès aux données de l'{@link Adherent}.
 * @author Stagiaire
 *
 */
@Remote(IDaoAdherent.class)
@Stateless
public class DaoAdherent implements IDaoAdherent {

    /**
     * Entity manager.
     */
    @PersistenceContext(unitName = "Anarmorix_Data_Impl")
    private EntityManager em;

    /**
     * Requête utilisée pour la connexion d'un {@link Adherent}.
     */
    private static final String REQ_CNX = "SELECT a FROM adherent a WHERE a.username = pusername AND a.password = ppassword";

    /**
     * Default constructor.
     */
    public DaoAdherent() {
    }

    @Override
    public Adherent seConnecter(String paramUsername, String paramPassword) throws AnarmorixException {
        Adherent adherent = null;
        try {
            adherent = em.createQuery(REQ_CNX, Adherent.class)  .setParameter("pusername", paramUsername)
                                                                .setParameter("ppassword", paramPassword).getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Adherent ajouter(Adherent paramAdherent) throws AnarmorixException {
        //TODO: Vérifier que le mail ou l'userame ne soient pas déjà pris.
        em.persist(paramAdherent);
        return paramAdherent;
    }

    @Override
    public void supprimer(Adherent paramAdherent) throws AnarmorixException {
        em.remove(paramAdherent);
    }

    @Override
    public Adherent mettreAJour(Adherent paramAdherent) throws AnarmorixException {
        Adherent updatedAdherent = em.merge(paramAdherent);
        return updatedAdherent;
    }

}

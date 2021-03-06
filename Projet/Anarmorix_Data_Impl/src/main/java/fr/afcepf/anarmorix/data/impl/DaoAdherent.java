package fr.afcepf.anarmorix.data.impl;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.afcepf.anarmorix.data.api.IDaoAdherent;
import fr.afcepf.anarmorix.entity.Adherent;
import fr.afcepf.anarmorix.entity.Client;
import fr.afcepf.anarmorix.entity.Commande;
import fr.afcepf.anarmorix.exception.AnarmorixException;
import fr.afcepf.anarmorix.exception.AnarmorixExceptionEnum;

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
    private static final String REQ_CNX = "SELECT a FROM Adherent a WHERE a.username = :pusername AND a.password = :ppassword";
    /**
     * Requête utilisé pour vérifier si l'adhérent est déjà présent dans la base de données.
     */
    private static final String REQ_REGISTER = "SELECT a FROM Adherent a WHERE a.username = :pusername OR a.mail = :pmail";

    private static final String REQ_AFFADHERENT = "SELECT ad.client FROM Commande ad WHERE ad.id = :pid"  ;


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
            AnarmorixException exc = new AnarmorixException("", AnarmorixExceptionEnum.ERREUR_IDENTIFIANTS_CONNEXION);
            throw exc;
        }
        return adherent;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Adherent ajouter(Adherent paramAdherent) throws AnarmorixException {
        List<Adherent> verifListe = em.createQuery(REQ_REGISTER).setParameter("pusername", paramAdherent.getUsername())
                                    .setParameter("pmail", paramAdherent.getMail()).getResultList();
        if (verifListe.isEmpty()) {
            try {
                em.persist(paramAdherent);
            } catch (Exception e) {
                if (e.getMessage().contains("DataException")) {
                    AnarmorixException exc = new AnarmorixException("", AnarmorixExceptionEnum.TOO_LONG_DATA);
                    throw exc;
                }
                if (e.getMessage().contains("ConstraintViolationException")) {
                    AnarmorixException exc = new AnarmorixException("", AnarmorixExceptionEnum.VIOLATION_DE_CONTRAINTE);
                    throw exc;
                }
            }
            em.persist(paramAdherent);
        } else {
            AnarmorixException exc = new AnarmorixException("", AnarmorixExceptionEnum.MAIL_EXISTANT);
            throw exc;
        }
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

    @Override
    public Adherent afficherAdherent(Commande commande) throws AnarmorixException {
        Client adherent = null;
        try {
            adherent = (Client) em.createQuery(REQ_AFFADHERENT, Client.class)
                    .setParameter("pid", commande.getId()).getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return adherent;
    }



    @Override
    public List<Adherent> rechercher(Commande commande) throws AnarmorixException {
        return null;
    }
}

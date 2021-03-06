package fr.afcepf.anarmorix.data.impl;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.afcepf.anarmorix.data.api.IDaoCategorie;
import fr.afcepf.anarmorix.entity.Categorie;
import fr.afcepf.anarmorix.exception.AnarmorixException;
import fr.afcepf.anarmorix.exception.AnarmorixExceptionEnum;

/**
 * Implémentation des méthodes de {@link IDaoCategorie}.
 */
@Remote(IDaoCategorie.class)
@Stateless
public class DaoCategorie implements IDaoCategorie {
    /**
     * Le contexte de persisntence.
     */
    @PersistenceContext(unitName = "Anarmorix_Data_Impl")
    private EntityManager em;
    /**
     * Default constructor.
     */
    public DaoCategorie() {
    }

    /**
     * recupere les categorie par id.
     * @param idCategorie l'id dune categorie.
     * @return une liste categories.
     * @throws AnarmorixException exception serveur.
     */
    public List<Categorie> rechercherParId(Integer idCategorie) throws AnarmorixException {
        List<Categorie> categories = null;
        try {
            categories = em.createQuery(
                    "SELECT c FROM Categorie c "
                            + "WHERE c.id = :cid", Categorie.class)
                    .setParameter("cid", idCategorie)
                    .getResultList();
        } catch (Exception e) {
            AnarmorixException exc = new AnarmorixException("", AnarmorixExceptionEnum.MYSQL_HS);
            throw exc;
        }
        return categories;
    }
    /**
     * recupere les categorie par libelle.
     * @param libelleCategorie le libelle dune categorie.
     * @return une liste categories.
     * @throws AnarmorixException exception serveur.
     */
    public List<Categorie> rechercherCategorieParLibelle (String libelleCategorie) throws AnarmorixException {
        List<Categorie> categories = null;
        try {
            categories = em.createQuery(
                    "SELECT c FROM Categorie c WHERE c.libelle = :plibelle", Categorie.class)
                    .setParameter("plibelle", libelleCategorie)
                    .getResultList();
        } catch (Exception e) {
            AnarmorixException exc = new AnarmorixException("", AnarmorixExceptionEnum.MYSQL_HS);
            throw exc;
        }
        return categories;
    }
    /**
     * Implémentation méthode recherche toutes les catégories.
     * @return une liste de catégorie.
     * @throws AnarmorixException Le serveur ne répond pas.
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<Categorie> rechercherTous() throws AnarmorixException {
        List<Categorie> categories = null;
        try {
            categories = em.createQuery("SELECT c FROM Categorie c").getResultList();
        } catch (Exception e) {
            AnarmorixException exc = new AnarmorixException("", AnarmorixExceptionEnum.MYSQL_HS);
            throw exc;
        }
        return categories;
    }
    @Override
    public Categorie ajouter() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void supprimer(Categorie paramCategorie) {
        // TODO Auto-generated method stub
    }

    @Override
    public Categorie mettreAJour(Categorie paramCategorie) {
        // TODO Auto-generated method stub
        return null;
    }

}
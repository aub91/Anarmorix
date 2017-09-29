package fr.afcepf.anarmorix.business.test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import fr.afcepf.anarmorix.business.api.IBusinessClient;
import fr.afcepf.anarmorix.business.impl.BusinessClient;
import fr.afcepf.anarmorix.data.api.IDaoCategorie;
import fr.afcepf.anarmorix.data.api.IDaoCommande;
import fr.afcepf.anarmorix.data.api.IDaoCommerce;
import fr.afcepf.anarmorix.data.api.IDaoLigneCommande;
import fr.afcepf.anarmorix.data.api.IDaoProduit;
import fr.afcepf.anarmorix.data.impl.DaoCategorie;
import fr.afcepf.anarmorix.data.impl.DaoCommande;
import fr.afcepf.anarmorix.data.impl.DaoCommerce;
import fr.afcepf.anarmorix.data.impl.DaoLigneCommande;
import fr.afcepf.anarmorix.data.impl.DaoProduit;
import fr.afcepf.anarmorix.entity.Categorie;
import fr.afcepf.anarmorix.entity.Commande;
import fr.afcepf.anarmorix.entity.LigneCommande;
import fr.afcepf.anarmorix.entity.PointRelais;
import fr.afcepf.anarmorix.entity.Produit;
import fr.afcepf.anarmorix.entity.Statut;
import fr.afcepf.anarmorix.entity.Ville;
import fr.afcepf.anarmorix.exception.AnarmorixException;

/**
 * Classe de test de {@link IBusinessClient}.
 * @author Aubin
 *
 */
public class TestBusinessClient {
    /**
     * La classe contenant les méthodes à tester.
     */
    private IBusinessClient busClient = new BusinessClient();
    /**
     * Taille de la liste des produits attendus.
     */
    private static final int TAILLE_LISTE_PRODUIT = 25;
    /**
     * Taille de la liste point-relais avec recherche ville.
     */
    private static final int TAILLE_LISTE_POINT_RELAIS = 2;
    /**
     * Taille de la liste point-relais avec recherche ville.
     */
    private static final int TAILLE_LISTE_CATEGORIE = 25;
    /**
     * Ville pour test nominale recherche par ville.
     */
    private Ville villeNominale = new Ville("22162", "Paimpol");
    /**
     * Commande nominale.
     */
    private Commande commandeNominale = new Commande(null, null, null, null, null, null, Statut.CREEE);
    /**
     * ID de la commande créé.
     */
    private static final int ID_COMMANDE = 99;
    /**
     * Test nominal recupererTousLesProduits.
     * @throws AnarmorixException exception non attendue
     */
    @Test
    public void testNominalRecupererTousLesProduits() throws AnarmorixException {
        List<Produit> retour = busClient.recupererTousLesProduits();
        Assert.assertEquals(TAILLE_LISTE_PRODUIT, retour.size());
    }
    /**
     * Test nominal rechercherPointRelais.
     * @throws AnarmorixException exception non attendue
     */
    @Test
    public void testNominalRechercherPointRelais() throws AnarmorixException {
        List<PointRelais> retour = busClient.rechercherPointRelais(villeNominale);
        Assert.assertEquals(TAILLE_LISTE_POINT_RELAIS, retour.size());
    }
    /**
     * Test nominal ajouterListeLigneCommande.
     * @throws AnarmorixException exception non attendue
     */
    @Test
    public void testNominalAjouterListeLigneCommande() throws AnarmorixException {
        Commande retour = busClient.ajouterListeLigneCommande(commandeNominale);
        Assert.assertNotNull(retour);
        Assert.assertEquals(ID_COMMANDE, retour.getId().intValue());
        Assert.assertEquals(Statut.CREEE, retour.getStatut());
    }
    /**
     * Test nominal recupererLesProduitsParType.
     * @throws AnarmorixException exception non attendue
     */
    @Test
    public void testNominalRecupererLesProduitsParType() throws AnarmorixException {
        List<Produit> retour = busClient.recupererLesProduitsParType(1);
        Assert.assertNotNull(retour);
        Assert.assertEquals(1, retour.size());
    }
    /**
     * Test nominal recupererLesProduitsParCategorie.
     * @throws AnarmorixException exception non attendue
     */
    @Test
    public void testNominalRecupererToutesLesCategories() throws AnarmorixException {
        List<Categorie> retour = busClient.recupererToutesLesCategories();
        Assert.assertNotNull(retour);
        Assert.assertEquals(TAILLE_LISTE_CATEGORIE, retour.size());
    }
    /**
     * Default constructor avec injection de mock.
     */
    public TestBusinessClient() {
        IDaoProduit mockDaoProduit = new DaoProduit() {
            @Override
            public List<Produit> rechercherTousLesProduits() throws AnarmorixException {
                List<Produit> retour = new ArrayList<>();
                for (int i = 0; i < TAILLE_LISTE_PRODUIT; i++) {
                    retour.add(new Produit());
                }
                return retour;
            }
            @Override
            public List<Produit> rechercherParIDTypeProduit(Integer paramId) throws AnarmorixException {
                List<Produit> retour = new ArrayList<>();
                if (paramId == 1) {
                    retour.add(new Produit());
                }
                return retour;
            }
        };
        IDaoCommerce mockDaoCommerce = new DaoCommerce() {
            @Override
            public List<PointRelais> rechercherPointsRelais(Ville paramVille) throws AnarmorixException {
                List<PointRelais> retour = new ArrayList<>();
                if (paramVille.getCodeInsee() == villeNominale.getCodeInsee()) {
                    for (int i = 0; i < TAILLE_LISTE_POINT_RELAIS; i++) {
                        retour.add(new PointRelais());
                    }
                }
                return retour;
            }
        };
        IDaoCommande mockDaoCommande = new DaoCommande() {
            @Override
            public Commande ajouter(Commande paramCommande) throws AnarmorixException {
                paramCommande.setId(ID_COMMANDE);
                paramCommande.setLignesCommande(new ArrayList<LigneCommande>());
                return paramCommande;
            }
        };
        IDaoLigneCommande mockDaoLigneCommande = new DaoLigneCommande() {
            @Override
            public LigneCommande ajouter(LigneCommande paramLigneCommande) throws AnarmorixException {
                return paramLigneCommande;
            }
        };
        IDaoCategorie mockDaoCategorie = new DaoCategorie() {
            @Override
            public List<Categorie> rechercherTous() throws AnarmorixException {
                List<Categorie> retour = new ArrayList<>();
                for (int i = 0; i < TAILLE_LISTE_CATEGORIE; i++) {
                    retour.add(new Categorie());
                }
                return retour;
            }
        };
        try {
            Class<?> clazz = busClient.getClass();
            Field attDaoProduit = clazz.getDeclaredField("daoProduit");
            attDaoProduit.setAccessible(true);
            attDaoProduit.set(busClient, mockDaoProduit);

            Field attDaoCommerce = clazz.getDeclaredField("daoCommerce");
            attDaoCommerce.setAccessible(true);
            attDaoCommerce.set(busClient, mockDaoCommerce);

            Field attDaoCommande = clazz.getDeclaredField("daoCommande");
            attDaoCommande.setAccessible(true);
            attDaoCommande.set(busClient, mockDaoCommande);

            Field attDaoLigneCommande = clazz.getDeclaredField("daoLignecommande");
            attDaoLigneCommande.setAccessible(true);
            attDaoLigneCommande.set(busClient, mockDaoLigneCommande);

            Field attDaoCategorie = clazz.getDeclaredField("daoCategorie");
            attDaoCategorie.setAccessible(true);
            attDaoCategorie.set(busClient, mockDaoCategorie);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

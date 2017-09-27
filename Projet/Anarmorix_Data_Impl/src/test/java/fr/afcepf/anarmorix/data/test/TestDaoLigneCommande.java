package fr.afcepf.anarmorix.data.test;

import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fr.afcepf.anarmorix.data.api.IDaoLigneCommande;
import fr.afcepf.anarmorix.entity.Adresse;
import fr.afcepf.anarmorix.entity.Categorie;
import fr.afcepf.anarmorix.entity.Client;
import fr.afcepf.anarmorix.entity.CodePostal;
import fr.afcepf.anarmorix.entity.Commande;
import fr.afcepf.anarmorix.entity.Image;
import fr.afcepf.anarmorix.entity.LigneCommande;
import fr.afcepf.anarmorix.entity.Livreur;
import fr.afcepf.anarmorix.entity.Packaging;
import fr.afcepf.anarmorix.entity.PointRelais;
import fr.afcepf.anarmorix.entity.Produit;
import fr.afcepf.anarmorix.entity.SocieteDeLivraison;
import fr.afcepf.anarmorix.entity.Statut;
import fr.afcepf.anarmorix.entity.TauxTVA;
import fr.afcepf.anarmorix.entity.Tournee;
import fr.afcepf.anarmorix.entity.TypeProduit;
import fr.afcepf.anarmorix.entity.UnitePackaging;
import fr.afcepf.anarmorix.entity.Ville;
import fr.afcepf.anarmorix.exception.AnarmorixException;
import fr.afcepf.anarmorix.exception.AnarmorixExceptionEnum;

/**
 * Test des méthodes du {@link DaoLigneCommande}.
 * @author Stagiaire
 *
 */
public class TestDaoLigneCommande {

    /**
     * Classe contenant les services à tester.
     */
    private IDaoLigneCommande dao = (IDaoLigneCommande) CreateProxyEJB.getProxy(
            "Anarmorix_EAR-1.0/Anarmorix_Data_Impl-1.0/DaoLigneCommande!fr.afcepf.anarmorix.data.api.IDaoLigneCommande");

    /**
     * {@link CodePostal} du client.
     */
    private static final CodePostal CODEPOSTAL = new CodePostal(1, "22500");

    /**
     *Ville du client.
     */
    private static final Ville VILLE = new Ville("22162", "Paimpol");

    /**
     * ID d'une commande inexistante.
     */
    private static final Integer ID_INEXISTANT = 2227272;

    /**
     * ID d'une commande existante.
     */
    private static final Integer ID_EXISTANT = 1;

    /**
     *  {@link Adresse} du {@link Client} utilisé pour les tests.
     */
    private static final Adresse ADRESSE = new Adresse(3, 15, null, "rue Becot", CODEPOSTAL,
                                            VILLE, "-3.051375", "48.779062");

    /**
     *  {@link Adresse} du {@link PointRelais} utilisé pour les tests.
     */
    private static final Adresse ADRESSE_RELAIS = new Adresse(4, 1, null, "Rue Gardenn Toul Ar Verzhid", CODEPOSTAL,
                                            VILLE, "-3.059167", "48.782303");

    /**
     * Point relais entré dans les commandes test.
     */
    private static final PointRelais RELAIS =
            new PointRelais(4, "422260208", "00026", "4711D", null, "Kantbuymelove SARL", ADRESSE_RELAIS, null);

    /**
     * Client entré dans les commandes test.
     */
    @SuppressWarnings("deprecation")
    private static final Client CLIENT =  new Client(15, new Date(117, 9, 18), "Scarlatti",
                                        "Gustave", new Date(117, 8, 17), ADRESSE,
                        "épanorthose@ovh.fr", "0666666666", null, "Wildcatgalileo", "aaa", null);

    /**
     * Commande pour le test du cas d'une commande inexistante.
     */
    private static final Commande COMMANDE_INEXISTANTE =
            new Commande(ID_INEXISTANT, new Date(), new Date(), null, RELAIS, CLIENT, Statut.EN_ATTENTE_DE_PREPARATION);

    /**
     * Commande pour le test du cas nominal.
     */
    @SuppressWarnings("deprecation")
    private static final Commande COMMANDE =
            new Commande(ID_EXISTANT, new Date(117, 9, 7), new Date(117, 9, 8), "12345", RELAIS, CLIENT, Statut.TERMINEE);

    /**
     * Catégorie la plus générale de produits.
     */
    private static final Categorie CATEGORIE_1 = new Categorie(1, "Fruits, légumes et féculents", null);

    /**
     * Catégorie intermédiaire de produits.
     */
    private static final Categorie CATEGORIE_2 = new Categorie(1, "Fruits, légumes et féculents", CATEGORIE_1);

    /**
     * Catégorie intermédiaire de produits.
     */
    private static final Categorie CATEGORIE_3 = new Categorie(1, "Fruits, légumes et féculents", CATEGORIE_2);

    /**
     * Catégorie la plus spécifique de produits.
     */
    private static final Categorie CATEGORIE_4 = new Categorie(1, "Fruits, légumes et féculents", CATEGORIE_3);

    /**
     * {@link TauxTVA} du produit.
     */
    private static final TauxTVA TVA = new TauxTVA(1, 5.50);

    /**
     * {@link Image} du {@link Produit}.
     */
    private static final Image IMAGE = new Image(1, "test", null, null, null);

    /**
     * {@link TypeProduit} du {@link Produit}.
     */
    private static final TypeProduit TYPE = new TypeProduit(1, "Fraise gariguette", null, TVA, CATEGORIE_4, null, IMAGE);

    /**
     * {@link UnitePackaging} du {@link Produit}.
     */
    private static final UnitePackaging UNITE_PACK = new UnitePackaging(1, "kilogramme");

    /**
     * {@link Packaging} du {@link Produit}.
     */
    private static final Packaging PACK = new Packaging(2, null, "Vrac", UNITE_PACK, null);

    /**
     * Produit attaché à la ligne de commande.
     */
    private static final Produit PRODUIT =
            new Produit(1, TYPE, null, 25D, 50D, IMAGE, PACK);

    /**
     * Ville de l'adresse de la societe de livraison.
     */
    private static final Ville VILLE_1 = new Ville("22070", "Guingamp");

    /**
     * Ville de l'adresse du livreur.
     */
    private static final Ville VILLE_2 = new Ville("22195", "Pleubian");

    /**
     * CodePostal de l'adresse de la societe de livraison.
     */
    private static final CodePostal CP_1 = new CodePostal(4, "22200");

    /**
     * Code postal de l'adresse du livreur.
     */
    private static final CodePostal CP_2 = new CodePostal(5, "22610");

    /**
     * Aresse de la societe de livraison.
     */
    private static final Adresse ADRESSE_SOCIETE =
            new Adresse(7, 15, null, "rue Paul Girard", CP_1, VILLE_1, "-3.157254", "48.565012");

    /**
     * Adresse du livreur.
     */
    private static final Adresse ADRESSE_LIVREUR =
            new Adresse(8, 7, null, "rue Saint-Andtoine", CP_2, VILLE_2, "-3.121430", "48.851137");

    /**
     * Société de livraison prenant en charge la tournée.
     */
    private static final SocieteDeLivraison SOCIETE =
            new SocieteDeLivraison(13, "422260208", "00026", "47111D", null, "Michel SARL", ADRESSE_SOCIETE, null);

    /**
     * Livreur effectuant la tournée.
     */
    @SuppressWarnings("deprecation")
    private static final Livreur LIVREUR = new Livreur(8, new Date(117, 6, 23), "Bakounine", "Mouloud", new Date(117, 8, 17),
                    ADRESSE_LIVREUR, "patrickdewaere@mailoo.org", "0666666666", null, "Onnyvoitgoethe", "aaa", null, SOCIETE);

    /**
     * Tournée prenant en charge la ligne de commande.
     */
    private static final Tournee TOURNEE = new Tournee(1, new Date(/*debut*/), new Date(/*fin*/), SOCIETE, LIVREUR);
    /**
     * ID de tournée non existant en base de données.
     */
    private static final int ID_TOURNEE_NON_EXISTANT = 999;
    /**
     * Tournée non existante en base.
     */
    private static final Tournee TOURNEE_NON_EXISTANTE = new Tournee(ID_TOURNEE_NON_EXISTANT, new Date(/*debut*/), new Date(/*fin*/), SOCIETE, LIVREUR);

    /**
     * Ligne commande retournée.
     */
    @SuppressWarnings("deprecation")
    private static final LigneCommande LIGNE =
                    new LigneCommande(1, 1D, 1D, 1D, 1D, new Date(117, 9, 8), new Date(117, 9, 9), new Date(117, 9, 10),
                    new Date(117, 9, 10), new Date(117, 9, 11), PRODUIT, TOURNEE);
    /**
     * Ligne commande updatée.
     */
    @SuppressWarnings("deprecation")
    private static final LigneCommande LIGNE_UPDATE =
                    new LigneCommande(1, 2D, 2D, 2D, 2D, new Date(117, 9, 8), new Date(117, 9, 9), new Date(117, 9, 10),
                    new Date(117, 9, 10), new Date(117, 9, 11), PRODUIT, TOURNEE);

    /**
     * Test du cas d'un argument inexistant en base.
     * @throws AnarmorixException l'exception attendue, argument inexistant.
     */
    @Test
    public void testEchecRechercherByCommandeArgumentInexistant() throws AnarmorixException {
        try {
            List<LigneCommande> retour = dao.rechercher(COMMANDE_INEXISTANTE);
            System.out.println("Size echec :");
            System.out.println(retour.size());
            Assert.fail("Test d'echec (Argument invalide), mais ça marche. Il y a un petit problème... !");
        } catch (AnarmorixException e) {
            System.out.println("Erreur :");
            System.out.println(e.getMessage());
            Assert.assertEquals(AnarmorixExceptionEnum.ARGUMENT_INEXISTANT, e.getCodeErreur());
        }
    }

    /**
     * Test du cas nominal rechercherByCommande.
     * @throws AnarmorixException une exception que l'on ne doit pas avoir dans le test nominal.
     */
    @Test
    public void testRechercheByCommandeNominal() throws AnarmorixException {
        List<LigneCommande> retour = dao.rechercher(COMMANDE);
        Assert.assertEquals(1, retour.size());
        Assert.assertEquals(LIGNE.getId(), retour.get(0).getId());
//        Assert.assertEquals(LIGNE.getDateDebutPreparation(), retour.get(0).getDateDebutPreparation());
//        Assert.assertEquals(LIGNE.getDateFinPreparation(), retour.get(0).getDateFinPreparation());
//        Assert.assertEquals(LIGNE.getDateLivraisonPtRel(), retour.get(0).getDateLivraisonPtRel());
//        Assert.assertEquals(LIGNE.getDateRetraitProducteur(), retour.get(0).getDateRetraitProducteur());
//        Assert.assertEquals(LIGNE.getDateRetraitPtRel(), retour.get(0).getDateRetraitPtRel());
        Assert.assertEquals(LIGNE.getQuantiteCommandee(), retour.get(0).getQuantiteCommandee());
        Assert.assertEquals(LIGNE.getQuantiteDelivree(), retour.get(0).getQuantiteDelivree());
        Assert.assertEquals(LIGNE.getQuantiteLivree(), retour.get(0).getQuantiteLivree());
        Assert.assertEquals(LIGNE.getQuantitePreparee(), retour.get(0).getQuantitePreparee());
    }
    /**
     * Test nominal de la méthode rechercherByTournee.
     * @throws AnarmorixException exception non attendue
     */
    @Test
    public void testNominalRechercherByTournee() throws AnarmorixException {
        Tournee retour = dao.rechercherByTournee(TOURNEE);
        Assert.assertNotNull(retour);
        Assert.assertEquals(TOURNEE.getId(), retour.getId());
        Assert.assertEquals(1, retour.getLignesCmd().size());
        Assert.assertEquals(LIGNE.getId(), retour.getLignesCmd().get(0).getId());
        Assert.assertEquals(LIGNE.getQuantiteCommandee(), retour.getLignesCmd().get(0).getQuantiteCommandee());
        Assert.assertEquals(LIGNE.getQuantiteDelivree(), retour.getLignesCmd().get(0).getQuantiteDelivree());
        Assert.assertEquals(LIGNE.getQuantiteLivree(), retour.getLignesCmd().get(0).getQuantiteLivree());
        Assert.assertEquals(LIGNE.getQuantitePreparee(), retour.getLignesCmd().get(0).getQuantitePreparee());
    }
    /**
     * Test échec rechercherByTournee avec tournee non existante.
     * @throws AnarmorixException exception non attendue
     */
    @Test
    public void testEchecRechercherByTournee() throws AnarmorixException {
        Tournee retour = dao.rechercherByTournee(TOURNEE_NON_EXISTANTE);
        Assert.assertEquals(0, retour.getLignesCmd().size());
    }
    /**
     * Test nominal de mettreAJour.
     * @throws AnarmorixException exception non attendue
     */
    @Test
    public void testNominalMettreAJour() throws AnarmorixException {
        LIGNE_UPDATE.setCommande(COMMANDE);
        LigneCommande retour = dao.mettreAJour(LIGNE_UPDATE);
        Assert.assertNotNull(retour);
        Assert.assertEquals(LIGNE_UPDATE.getId(), retour.getId());
        Assert.assertEquals(LIGNE_UPDATE.getQuantiteCommandee(), retour.getQuantiteCommandee());
        Assert.assertEquals(LIGNE_UPDATE.getQuantiteDelivree(), retour.getQuantiteDelivree());
        Assert.assertEquals(LIGNE_UPDATE.getQuantiteLivree(), retour.getQuantiteLivree());
        Assert.assertEquals(LIGNE_UPDATE.getQuantitePreparee(), retour.getQuantitePreparee());
    }
    /**
     * Reset de la base de données.
     */
    @Before
    public void resetDataBase() {
        String path = Thread.currentThread().getContextClassLoader().getResource("creabase.bat").getPath();
        path = path.replaceAll("%20", " ");
        try {
            Process proc = Runtime.getRuntime().exec(path);
            proc.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

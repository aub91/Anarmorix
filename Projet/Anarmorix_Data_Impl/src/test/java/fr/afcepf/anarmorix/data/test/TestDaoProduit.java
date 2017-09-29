package fr.afcepf.anarmorix.data.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import fr.afcepf.anarmorix.data.api.IDaoCategorie;
import fr.afcepf.anarmorix.data.api.IDaoProduit;
import fr.afcepf.anarmorix.data.api.IDaoTypeProduit;
import fr.afcepf.anarmorix.entity.Catalogue;
import fr.afcepf.anarmorix.entity.Categorie;
import fr.afcepf.anarmorix.entity.LigneCommande;
import fr.afcepf.anarmorix.entity.Produit;
import fr.afcepf.anarmorix.entity.TypeProduit;
import fr.afcepf.anarmorix.exception.AnarmorixException;
import fr.afcepf.anarmorix.exception.AnarmorixExceptionEnum;
/**
 * classe permettant de tester les methodes du dao produit.
 * @author joel
 *
 */
public class TestDaoProduit {
    /**
     * dao créé par proxy.
     */
    private IDaoProduit daoProduit = (IDaoProduit) CreateProxyEJB.getProxy(
            "Anarmorix_EAR-1.0/Anarmorix_Data_Impl-1.0/DaoProduit!fr.afcepf.anarmorix.data.api.IDaoProduit");

    /**
     * ID du produit a tester.
     */
    private static final int ID_PRODUIT = 1;
    /**
     * Quantite en stock.
     */
    private static final int QUANTITE_EN_STOCK = 50;
    /**
     * prix unitaire.
     */
    private static final int PRIX_UNITAIRE = 3;
    /**
     * methde rechercher produit par ID.
     */
    @Test
    public void testRechercheProduitParID() {
        try {
            List<Produit> produits = daoProduit.rechercherParID(ID_PRODUIT);
            Assert.assertEquals(produits.size(), 1);
            Assert.assertEquals(produits.get(0).getId().intValue(), 1);
            Assert.assertEquals(produits.get(0).getQuantiteEnStock().intValue(), QUANTITE_EN_STOCK);
           // Assert.assertEquals(produits.get(0).getPackaging().getLibelle(), "Vrac");
            Assert.assertEquals(produits.get(0).getPrixUnitaire().intValue(), PRIX_UNITAIRE);
        } catch (AnarmorixException e) {
            Assert.assertEquals(AnarmorixExceptionEnum.MYSQL_HS, e.getCodeErreur());
        }
    }
    /**
     * dao créé par proxy.
     */
    private IDaoCategorie daoCategorie = (IDaoCategorie) CreateProxyEJB.getProxy(
            "Anarmorix_EAR-1.0/Anarmorix_Data_Impl-1.0/DaoCategorie!fr.afcepf.anarmorix.data.api.IDaoCategorie");
    /**
     * Test de recuperation des categories.
     */
    @Test
    public void testGetCategories() {
        try {
            List<Categorie> categories = daoCategorie.rechercherCategorieParLibelle("Fraise");
            Assert.assertEquals(categories.size(), 1);
        } catch (AnarmorixException e) {
            Assert.assertEquals(AnarmorixExceptionEnum.MYSQL_HS, e.getCodeErreur());
        }
    }
    /**
     * dao créé par proxy.
     */
    private IDaoTypeProduit daoTypeProduit = (IDaoTypeProduit) CreateProxyEJB.getProxy(
            "Anarmorix_EAR-1.0/Anarmorix_Data_Impl-1.0/DaoTypeProduit!fr.afcepf.anarmorix.data.api.IDaoTypeProduit");
    /**
     * Test de recuperation des typeProduits.
     */
    @Test
    public void testTypeProduits() {
        try {
            Categorie cat = new Categorie(11, "Fraise", daoCategorie.rechercherParId(8).get(0));
            System.out.println("categorie : " + cat.getTypesProduits());
            /*List<TypeProduit> typeProduits = daoTypeProduit.rechercher(cat);
            for (TypeProduit typeProduit : typeProduits) {
            System.out.println("type " + typeProduit.getLibelle());
            }*/
            // Assert.assertEquals(categories.size(), 1);
        } catch (AnarmorixException e) {
            Assert.assertEquals(AnarmorixExceptionEnum.MYSQL_HS, e.getCodeErreur());
        }
    }
    /**
     * ID du  type produit.
     */
    private static final int ID_TYPE_PRODUIT = 2;
    /**
     * ID du produit a tester.
     */
    private static final int ID_PRODUIT2 = 2;
    /**
     * prix unitaire.
     */
    private static final int PRIX_UNITAIRE2 = 25;
    /**
     * methode rechercher produit par ID du type produit.
     */
    @Test
    public void testRechercheProduitParTypeDeProduit() {
        try {
            List<Produit> produits = daoProduit.rechercherParIDTypeProduit(ID_TYPE_PRODUIT);
            Assert.assertEquals(produits.size(), 1);
            Assert.assertEquals(produits.get(0).getId().intValue(), ID_PRODUIT2);
            Assert.assertEquals(produits.get(0).getQuantiteEnStock().intValue(), QUANTITE_EN_STOCK);
            Assert.assertEquals(produits.get(0).getPrixUnitaire().intValue(), PRIX_UNITAIRE2);
        } catch (AnarmorixException e) {
            Assert.assertEquals(AnarmorixExceptionEnum.MYSQL_HS, e.getCodeErreur());
        }
    }
    /**
     * le nombre de produits dans la liste.
     */
    private static final int TAILLE_LISTE = 44;
    /**
     * test de recherche de tous les produits.
     */
    @Test
    public void testRechercheTousLesProduits() {
        try {
            List<Produit> produits = daoProduit.rechercherTousLesProduits();
            Assert.assertNotNull(produits);
            Assert.assertEquals(TAILLE_LISTE, produits.size());
        } catch (AnarmorixException e) {
            Assert.assertEquals(AnarmorixExceptionEnum.MYSQL_HS, e.getCodeErreur());
        }
    }
    /**
     * Ligne de commande pour test nominal.
     */
    private LigneCommande ligneNominal = new LigneCommande(1, 1d, 1d, 1d, 1d, null, null, null, null, null, null, null);
    /**
     * Type du produit attendu.
     */
    private TypeProduit typeProduitNominal = new TypeProduit(1, "Fraise gariguette", null, null, null, null, null);
    /**
     * Prix unitaire attendu pour produit nominal.
     */
    private static final double PRIX_PRODUIT_NOMINAL = 3;
    /**
     * Quantité en stock attendu pour produit nominal.
     */
    private static final double QUANTITE_PRODUIT_NOMINAL = 50;
    /**
     * Produit attendu pour test nominal.
     */
    private Produit produitNominal = new Produit(1, typeProduitNominal, null, PRIX_PRODUIT_NOMINAL, QUANTITE_PRODUIT_NOMINAL, null, null);
    /**
     * ID ligne catalogue non existant pour test échec.
     */
    private static final int ID_LIGNE_NON_EXISTANT = 999;
    /**
     * Ligne de commande non existante pour test échec.
     */
    private LigneCommande ligneNonExistante = new LigneCommande(ID_LIGNE_NON_EXISTANT, 1d, 1d, 1d, 1d, null, null, null, null, null, null, null);
    /**
     * Test nominal pour méthode rechercherByLigneCommande.
     * @throws AnarmorixException exception non attendue
     */
    @Test
    public void testNominalRechercherByLigneCommande() throws AnarmorixException {
        LigneCommande retour = daoProduit.rechercherByLigneCommande(ligneNominal);
        Assert.assertNotNull(retour);
        Assert.assertEquals(ligneNominal.getId(), retour.getId());
        Assert.assertEquals(ligneNominal.getQuantiteCommandee(), retour.getQuantiteCommandee());
        Assert.assertEquals(ligneNominal.getQuantiteDelivree(), retour.getQuantiteDelivree());
        Assert.assertEquals(ligneNominal.getQuantiteLivree(), retour.getQuantiteLivree());
        Assert.assertEquals(ligneNominal.getQuantitePreparee(), retour.getQuantitePreparee());
        Assert.assertNotNull(retour.getProduit());
        Assert.assertEquals(produitNominal.getId(), retour.getProduit().getId());
        Assert.assertEquals(produitNominal.getPrixUnitaire(), retour.getProduit().getPrixUnitaire());
        Assert.assertEquals(produitNominal.getQuantiteEnStock(), retour.getProduit().getQuantiteEnStock());
        Assert.assertNotNull(retour.getProduit().getType());
        Assert.assertEquals(typeProduitNominal.getId(), retour.getProduit().getType().getId());
        Assert.assertEquals(typeProduitNominal.getLibelle(), retour.getProduit().getType().getLibelle());
    }
    /**
     * Test d'échec avec ligne de commande non existante.
     * @throws AnarmorixException une exception
     */
    @Test
    public void testEchecRechercheByLigneCommande() throws AnarmorixException {
        try {
            daoProduit.rechercherByLigneCommande(ligneNonExistante);
            Assert.fail("Test d'échec qui ne devrait pas réussir");
        } catch (AnarmorixException e) {
            Assert.assertEquals(AnarmorixExceptionEnum.ERREUR_NON_IDENTIFIEE, e.getCodeErreur());
        }
    }
    private Catalogue catalogueNominal = new Catalogue(1, null, null, null, null);
    @Test
    public void testNominalRechercherByCatalogue() throws AnarmorixException {
        Catalogue retour = daoProduit.rechercherByCatalogue(catalogueNominal);
        Assert.assertEquals(42, retour.getProduits().size());
    }
}

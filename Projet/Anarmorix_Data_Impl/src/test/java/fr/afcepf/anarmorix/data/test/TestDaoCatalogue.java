package fr.afcepf.anarmorix.data.test;

import org.junit.Assert;
import org.junit.Test;

import fr.afcepf.anarmorix.data.api.IDaoCatalogue;
import fr.afcepf.anarmorix.entity.Produit;
import fr.afcepf.anarmorix.entity.TypeProduit;
import fr.afcepf.anarmorix.exception.AnarmorixException;

/**
 * Classe contenant les test des méthodes du {@link DaoCatalogue}.
 * @author Aubin
 *
 */
public class TestDaoCatalogue {
    /**
     * Classe contenant les services à tester.
     */
    private IDaoCatalogue dao = (IDaoCatalogue) CreateProxyEJB.getProxy(
            "Anarmorix_EAR-1.0/Anarmorix_Data_Impl-1.0/DaoCatalogue!fr.afcepf.anarmorix.data.api.IDaoCatalogue");
    /**
     * Type du produit attendu.
     */
    private TypeProduit typeProduitNominal = new TypeProduit(1, "Fraise gariguette", null, null, null, null, null);
    /**
     * Prix unitaire attendu pour produit nominal.
     */
    private static final double PRIX_PRODUIT_NOMINAL = 25;
    /**
     * Quantité en stock attendu pour produit nominal.
     */
    private static final double QUANTITE_PRODUIT_NOMINAL = 50;
    /**
     * Produit pour test nominal.
     */
    private Produit produitNominal = new Produit(1, typeProduitNominal, null, PRIX_PRODUIT_NOMINAL, QUANTITE_PRODUIT_NOMINAL, null, null);
    /**
     * Taille de la liste de catalogues attendu en retour de la méthode rechercherByProduit.
     */
    private static final int TAILLE_LISTE_CATALOGUE = 1;
    /**
     * Id produit non existant.
     */
    private static final int ID_PRODUIT_NON_EXISTANT = 999;
    /**
     * Produit pour test échec.
     */
    private Produit produitNonExistant = new Produit(ID_PRODUIT_NON_EXISTANT, typeProduitNominal,
            null, PRIX_PRODUIT_NOMINAL, QUANTITE_PRODUIT_NOMINAL, null, null);
    /**
     * Test nominal pour méthode rechercherByProduit.
     * @throws AnarmorixException exception non attendue
     */
    @Test
    public void testNominalRechercherByProduit() throws AnarmorixException {
        Produit retour = dao.rechercherByProduit(produitNominal);
        Assert.assertNotNull(retour);
        Assert.assertEquals(produitNominal.getId(), retour.getId());
        Assert.assertEquals(produitNominal.getPrixUnitaire(), retour.getPrixUnitaire());
        Assert.assertEquals(produitNominal.getQuantiteEnStock(), retour.getQuantiteEnStock());
        Assert.assertNotNull(retour.getType());
        Assert.assertEquals(produitNominal.getType().getId(), retour.getType().getId());
        Assert.assertEquals(produitNominal.getType().getLibelle(), retour.getType().getLibelle());
        Assert.assertEquals(TAILLE_LISTE_CATALOGUE, retour.getCatalogues().size());
    }
    /**
     * Test échec avec produit non existant pour méthode rechercherByProduit.
     * @throws AnarmorixException une exception
     */
    @Test
    public void testEchecRechercherByProduit() throws AnarmorixException {
        Produit retour = dao.rechercherByProduit(produitNonExistant);
        Assert.assertEquals(0, retour.getCatalogues().size());
    }
}

package fr.afcepf.anarmorix.data.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import fr.afcepf.anarmorix.data.api.IDaoProduit;
import fr.afcepf.anarmorix.entity.Produit;
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
    private static final int PRIX_UNITAIRE = 25;

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
            Assert.assertEquals(produits.get(0).getPackaging().getLibelle(), "Vrac");
            Assert.assertEquals(produits.get(0).getPrixUnitaire().intValue(), PRIX_UNITAIRE);
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
    private static final int ID_PRODUIT2 = 3;
    /**
     * prix unitaire.
     */
    private static final int PRIX_UNITAIRE2 = 10;
    /**
     * methode rechercher produit par ID du type produit.
     */
    @Test
    public void testRechercheProduitParCatalogue() {
        try {
            List<Produit> produits = daoProduit.rechercherParIDTypeProduit(ID_TYPE_PRODUIT);
            Assert.assertEquals(produits.size(), 1);
            Assert.assertEquals(produits.get(0).getId().intValue(), ID_PRODUIT2);
            Assert.assertEquals(produits.get(0).getQuantiteEnStock().intValue(), QUANTITE_EN_STOCK);
            Assert.assertEquals(produits.get(0).getPackaging().getLibelle(), "Vrac");
            Assert.assertEquals(produits.get(0).getPrixUnitaire().intValue(), PRIX_UNITAIRE2);
        } catch (AnarmorixException e) {
            Assert.assertEquals(AnarmorixExceptionEnum.MYSQL_HS, e.getCodeErreur());
        }
    }
}

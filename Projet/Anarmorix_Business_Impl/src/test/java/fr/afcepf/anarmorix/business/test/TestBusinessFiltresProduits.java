package fr.afcepf.anarmorix.business.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import fr.afcepf.anarmorix.business.api.IBusinessClient;
import fr.afcepf.anarmorix.entity.Produit;
import fr.afcepf.anarmorix.exception.AnarmorixException;
import fr.afcepf.anarmorix.exception.AnarmorixExceptionEnum;
/**
 * classe permettant de tester les methodes du dao produit.
 * @author joel
 *
 */
public class TestBusinessFiltresProduits {
    /**
     * Business client créé par proxy car test Junit n'a pas de conteneur.
     */
    private IBusinessClient businessCLient = (IBusinessClient) CreateProxyEJB.getProxy(
            "Anarmorix_EAR-1.0/Anarmorix_Business_Impl-1.0/BusinessClient!fr.afcepf.anarmorix.business.api.IBusinessClient");

    /**
     * le nombre de produits dans la liste.
     */
    private static final int TAILLE_LISTE = 3;
    /**
     * test de recherche de tous les produits.
     */
    @Test
    public void testRecupererTousLesProduits() {
        List<Produit> produits = new ArrayList<>();
        try {
           // produits = daoProduit.rechercherTousLesProduits();
            produits = businessCLient.choisirCategorieProduit();
            for (Produit p : produits) {
                System.out.println("test prix " + p.getPrixUnitaire().intValue());
            }
            Assert.assertNotNull(produits);
            Assert.assertEquals(TAILLE_LISTE, produits.size());
        } catch (AnarmorixException e) {
            Assert.assertEquals(AnarmorixExceptionEnum.MYSQL_HS, e.getCodeErreur());
        }
    }
}

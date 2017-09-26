package fr.afcepf.anarmorix.business.test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import fr.afcepf.anarmorix.business.api.IBusinessClient;
import fr.afcepf.anarmorix.business.impl.BusinessClient;
import fr.afcepf.anarmorix.data.api.IDaoProduit;
import fr.afcepf.anarmorix.data.impl.DaoProduit;
import fr.afcepf.anarmorix.entity.Produit;
import fr.afcepf.anarmorix.exception.AnarmorixException;
/**
 * classe permettant de tester les methodes du dao produit.
 * @author joel
 *
 */
public class TestBusinessFiltresProduits {
    /**
     * Business client créé par proxy car test Junit n'a pas de conteneur.
     */
   // private IBusinessClient businessCLient = (IBusinessClient) CreateProxyEJB.getProxy(
     //       "Anarmorix_EAR-1.0/Anarmorix_Business_Impl-1.0/BusinessClient!fr.afcepf.anarmorix.business.api.IBusinessClient");

    private IBusinessClient businessCLient = new BusinessClient();
    /**
     * le nombre de produits dans la liste.
     */
    private static final int TAILLE_LISTE = 3;
    /**
     * test de recherche de tous les produits.
     * @throws AnarmorixException une exception non attendue
     */
    @Test
    public void testNominal() throws AnarmorixException {
        List<Produit> produits = businessCLient.recupererTousLesProduits();
        Assert.assertNotNull(produits);
        Assert.assertEquals(TAILLE_LISTE, produits.size());
     }
    /**
     * Default constructor avec injection mock.
     */
    public TestBusinessFiltresProduits() {
        IDaoProduit mockDaoProduit = new DaoProduit() {
            @Override
            public List<Produit> rechercherTousLesProduits() throws AnarmorixException {
                List<Produit> liste = new ArrayList<>();
                for (int i = 0; i < TAILLE_LISTE; i++) {
                    Produit pdt = new Produit(i, null, null, null, null, null, null);
                    liste.add(pdt);
                }
                return liste;
            }
        };
        try {
            Class<?> clazz = businessCLient.getClass();
            Field attDaoProduit = clazz.getDeclaredField("daoProduit");
            attDaoProduit.setAccessible(true);
            attDaoProduit.set(businessCLient, mockDaoProduit);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

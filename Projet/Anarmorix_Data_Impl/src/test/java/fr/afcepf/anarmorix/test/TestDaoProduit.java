package fr.afcepf.anarmorix.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import fr.afcepf.anarmorix.data.api.IDaoProduit;
import fr.afcepf.anarmorix.data.impl.DaoProduit;
import fr.afcepf.anarmorix.entity.Produit;

public class TestDaoProduit {
    private IDaoProduit daoProduit = new DaoProduit();
    
    
    @Test
    public void testDao() {
        List<Produit> produits = daoProduit.rechercher(1);
        Assert.assertEquals(produits, null);
    }
  

}

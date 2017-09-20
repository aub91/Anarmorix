package fr.afcepf.anarmorix.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import fr.afcepf.anarmorix.data.api.IDaoAdherent;
import fr.afcepf.anarmorix.data.api.IDaoProduit;
import fr.afcepf.anarmorix.data.impl.DaoProduit;
import fr.afcepf.anarmorix.data.test.CreateProxyEJB;
import fr.afcepf.anarmorix.entity.Produit;

public class TestDaoProduit {
   // private IDaoProduit daoProduit = new DaoProduit();
    
    private IDaoProduit daoProduit = (IDaoProduit) CreateProxyEJB.getProxy(
            "Anarmorix_EAR-1.0/Anarmorix_Data_Impl-1.0/DaoProduit!fr.afcepf.anarmorix.data.api.IDaoProduit");

    @Test
    public void testDao() {
        List<Produit> produits = daoProduit.rechercher(1);
        Assert.assertEquals(0, produits.size());
    }
  

}

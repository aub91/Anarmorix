package fr.afcepf.anarmorix.business.test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import fr.afcepf.anarmorix.business.api.IBusinessPanier;
import fr.afcepf.anarmorix.business.impl.BusinessPanier;
import fr.afcepf.anarmorix.data.api.IDaoLigneCommande;
import fr.afcepf.anarmorix.data.impl.DaoLigneCommande;
import fr.afcepf.anarmorix.entity.Commande;
import fr.afcepf.anarmorix.entity.LigneCommande;
import fr.afcepf.anarmorix.exception.AnarmorixException;
/**
 * Classe contenant les méthodes de test de {@link IBusinessPanier}.
 * @author Aubin
 *
 */
public class TestBusinessPanier {
    /**
     * La classe contenant la méthode à tester.
     */
    private IBusinessPanier busPanier = new BusinessPanier();
    /**
     * La taille de liste de ligne de commande attendue.
     */
    private static final int TAILLE_LIST = 12;

    /**
     * Commande pour test nominal.
     */
    private Commande com = new Commande();
    /**
     * test nominal afficherLigneCommandePanier.
     * @throws AnarmorixException exception non attendue.
     */
    @Test
    public void testAfficherLigneCommandePanier() throws AnarmorixException {
        com.setId(1);

        List<LigneCommande> ligneCommandes = busPanier.rechercher(com);
        Assert.assertNotNull(ligneCommandes);
        Assert.assertEquals(TAILLE_LIST, ligneCommandes.size());
    }
    /**
     * Default Constructor.
     */
    public TestBusinessPanier() {
        IDaoLigneCommande mockLigneCommande = new DaoLigneCommande() {
            @Override
            public List<LigneCommande> rechercher(Commande commande) throws AnarmorixException {
                List<LigneCommande> liste = new ArrayList<>();
                for (int i = 0; i < TAILLE_LIST; i++) {
                    LigneCommande lc = new LigneCommande(i, null, null, null, null, null, null, null, null, null, null, null);
                    liste.add(lc);
                }
                return liste;
            };
        };
        try {
            Class<?> clazz = busPanier.getClass();
            Field attDaoLigneCommande = clazz.getDeclaredField("daoLigneCommande");
            attDaoLigneCommande.setAccessible(true);
            attDaoLigneCommande.set(busPanier, mockLigneCommande);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}

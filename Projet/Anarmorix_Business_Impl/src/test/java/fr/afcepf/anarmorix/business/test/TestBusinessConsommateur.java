package fr.afcepf.anarmorix.business.test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import fr.afcepf.anarmorix.business.api.IBusinessConsommateur;
import fr.afcepf.anarmorix.business.impl.BusinessConsommateur;
import fr.afcepf.anarmorix.data.api.IDaoLigneCommande;
import fr.afcepf.anarmorix.data.impl.DaoLigneCommande;
import fr.afcepf.anarmorix.entity.Commande;
import fr.afcepf.anarmorix.entity.LigneCommande;
import fr.afcepf.anarmorix.entity.Statut;
import fr.afcepf.anarmorix.exception.AnarmorixException;
import fr.afcepf.anarmorix.exception.AnarmorixExceptionEnum;

/**
 * Classe de test pour les méthodes de {@link IBusinessConsommateur}.
 * @author Aubin
 *
 */
public class TestBusinessConsommateur {
    /**
     * La classe contenant les méthodes à tester.
     */
    private IBusinessConsommateur busConsommateur = new BusinessConsommateur();
    /**
     * Commande pour test nominal afficherLigneCommande.
     */
    private Commande commandeNominal = new Commande(1, null, null, "12345", null, null, Statut.TERMINEE);
    /**
     * ID inexistant.
     */
    private static final int ID_INEXISTANT = 999;
    /**
     * Commande inexistante.
     */
    private Commande commandeInexistante = new Commande(ID_INEXISTANT, null, null, "12345", null, null, Statut.TERMINEE);
    /**
     * Taille liste attendue.
     */
    private static final int TAILLE_LISTE = 1;
    /**
     * Test nominal méthode afficherLigneCommande.
     * @throws AnarmorixException exception non attendue
     */
    @Test
    public void testNominalAfficherLigneCommande() throws AnarmorixException {
        List<LigneCommande> retour = busConsommateur.afficherLigneCommande(commandeNominal);
        Assert.assertEquals(TAILLE_LISTE, retour.size());
    }
    /**
     * Test échec avec commande inexistante.
     */
    @Test
    public void testEchecAfficherLigneCommande() {
        try {
            busConsommateur.afficherLigneCommande(commandeInexistante);
            Assert.fail("Ca ne devrait pas fonctionner.");
        } catch (AnarmorixException e) {
            Assert.assertEquals(AnarmorixExceptionEnum.ARGUMENT_INEXISTANT, e.getCodeErreur());
            e.printStackTrace();
        }
    }
    /**
     * Default constructor avec injection mock.
     */
    public TestBusinessConsommateur() {
        IDaoLigneCommande mockDaoLigneCommande = new DaoLigneCommande() {
          @Override
        public List<LigneCommande> rechercher(Commande paramCommande) throws AnarmorixException {
              List<LigneCommande> retour = new ArrayList<>();
              if (paramCommande.getId() == commandeNominal.getId()) {
                for (int i = 0; i < TAILLE_LISTE; i++) {
                    retour.add(new LigneCommande(i, null, null, null, null, null, null, null, null, null, null, null));
                }
              } else {
                  throw new AnarmorixException("", AnarmorixExceptionEnum.ARGUMENT_INEXISTANT);
              }
            return retour;
        }
       };
       try {
           Class<?> clazz = busConsommateur.getClass();
           Field attDaoLigneCommande = clazz.getDeclaredField("daoLignecommande");
           attDaoLigneCommande.setAccessible(true);
           attDaoLigneCommande.set(busConsommateur, mockDaoLigneCommande);
       } catch (Exception e) {
           e.printStackTrace();
       }
    }

}

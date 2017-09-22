package fr.afcepf.anarmorix.data.test;

import org.junit.Assert;
import org.junit.Test;

import fr.afcepf.anarmorix.data.api.IDaoHoraire;
import fr.afcepf.anarmorix.entity.JourOuverture;
import fr.afcepf.anarmorix.exception.AnarmorixException;


/**
 * Classe contenant les méthode de test de la méthode getHoraireByJourOuverture de {@link DaoHoraire}.
 * @author Aubin
 *
 */
public class TestGetHoraireByJourOuvertureDaoHoraire {
    /**
     * Classe contenant les services à tester.
     */
    private IDaoHoraire daoTest = (IDaoHoraire) CreateProxyEJB.getProxy(
            "Anarmorix_EAR-1.0/Anarmorix_Data_Impl-1.0/DaoHoraire!fr.afcepf.anarmorix.data.api.IDaoHoraire");
    /**
     * Taille atendue de la liste pour le test nominal.
     */
    private static final int TAILLE_LISTE = 1;
    /**
     * {@link JourOuverture} pour test nominal.
     */
    private JourOuverture jourOuvertureNominal = new JourOuverture(1, "Lundi", null);
    /**
     * ID non existant pour test échec.
     */
    private static final int ID_NON_EXISTANT = 16;
    /**
     * {@link JourOuverture} inexistant dans base de données pour test échec.
     */
    private JourOuverture jourOuvertureNonExistant = new JourOuverture(ID_NON_EXISTANT, "Dimanche", null);
    /**
     * Test avec point-relais non existant en base de données.
     * @throws AnarmorixException exception
     */
    @Test
    public void testEchecJourOuvertureNonExistant() throws AnarmorixException {
        JourOuverture retour = daoTest.getHoraireByJourOuverture(jourOuvertureNonExistant);
        Assert.assertEquals(0, retour.getHorairesOuverture().size());
    }
    /**
     * Test nominal.
     * @throws AnarmorixException exception
     */
    @Test
    public void testNominal() throws AnarmorixException {
        JourOuverture retour = daoTest.getHoraireByJourOuverture(jourOuvertureNominal);
        Assert.assertNotNull(retour);
        Assert.assertNotNull(retour.getHorairesOuverture());
        Assert.assertEquals(TAILLE_LISTE, retour.getHorairesOuverture().size());
        Assert.assertEquals(jourOuvertureNominal.getClass(), retour.getClass());
        Assert.assertEquals(jourOuvertureNominal.getId(), retour.getId());
        Assert.assertEquals(jourOuvertureNominal.getLibelle(), retour.getLibelle());
    }

}

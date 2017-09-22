package fr.afcepf.anarmorix.data.test;

import org.junit.Assert;
import org.junit.Test;

import fr.afcepf.anarmorix.data.api.IDaoJourOuverture;
import fr.afcepf.anarmorix.entity.PointRelais;
import fr.afcepf.anarmorix.exception.AnarmorixException;

/**
 * Classe de test de la méthode getAllByPointRelais de {@link DaoJourOuverture}.
 * @author Aubin
 *
 */
public class TestGetAllByPointRelaisDaoJourOuverture {
    /**
     * Classe contenant les services à tester.
     */
    private IDaoJourOuverture daoTest = (IDaoJourOuverture) CreateProxyEJB.getProxy(
            "Anarmorix_EAR-1.0/Anarmorix_Data_Impl-1.0/DaoJourOuverture!fr.afcepf.anarmorix.data.api.IDaoJourOuverture");
    /**
     * Taille atendue de la liste pour le test nominal.
     */
    private static final int TAILLE_LISTE = 5;
    /**
     * Id point relais nominal.
     */
    private static final int ID_NOMINAL = 4;
    /**
     * {@link PointRelais} pour test nominal.
     */
    private PointRelais relaisNominal = new PointRelais(ID_NOMINAL, "422260208", "00026", "4711D", null, "Kantbuymelove SARL", null, null);
    /**
     * Id point relais non existant.
     */
    private static final int ID_NON_EXISTANT = 14;
    /**
     * {@link PointRelais} non existant dans bdd pour test échec.
     */
    private PointRelais relaisNonExistant = new PointRelais(ID_NON_EXISTANT, "422260208", "00026", "4711D", null, "Kantbuymelove SARL", null, null);
    /**
     * Test avec point-relais non existant en base de données.
     * @throws AnarmorixException exception
     */
    @Test
    public void testEchecPointRelaisNonExistant() throws AnarmorixException {
        PointRelais retour = daoTest.getAllByPointRelais(relaisNonExistant);
        Assert.assertEquals(0, retour.getJoursOuverture().size());
    }
    /**
     * Test nominal.
     * @throws AnarmorixException exception
     */
    @Test
    public void testNominal() throws AnarmorixException {
        PointRelais retour = daoTest.getAllByPointRelais(relaisNominal);
        Assert.assertNotNull(retour);
        Assert.assertNotNull(retour.getJoursOuverture());
        Assert.assertEquals(TAILLE_LISTE, retour.getJoursOuverture().size());
        Assert.assertEquals(relaisNominal.getClass(), retour.getClass());
        Assert.assertEquals(relaisNominal.getId(), retour.getId());
        Assert.assertEquals(relaisNominal.getCodeApe(), retour.getCodeApe());
        Assert.assertEquals(relaisNominal.getNumNic(), retour.getNumNic());
        Assert.assertEquals(relaisNominal.getNumSiren(), retour.getNumSiren());
        Assert.assertEquals(relaisNominal.getRaisonSociale(), retour.getRaisonSociale());
    }
}

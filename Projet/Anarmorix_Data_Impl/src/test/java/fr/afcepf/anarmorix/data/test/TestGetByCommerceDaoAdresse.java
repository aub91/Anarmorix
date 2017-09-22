package fr.afcepf.anarmorix.data.test;

import org.junit.Assert;
import org.junit.Test;

import fr.afcepf.anarmorix.data.api.IDaoAdresse;
import fr.afcepf.anarmorix.entity.Adresse;
import fr.afcepf.anarmorix.entity.Commerce;
import fr.afcepf.anarmorix.entity.Exploitation;
import fr.afcepf.anarmorix.exception.AnarmorixException;
import fr.afcepf.anarmorix.exception.AnarmorixExceptionEnum;

/**
 * Classe contenant les méthode de test de la méthode getByCommerce de {@link DaoAdresse}.
 * @author Aubin
 *
 */
public class TestGetByCommerceDaoAdresse {
    /**
     * Classe contenant les services à tester.
     */
    private IDaoAdresse daoTest = (IDaoAdresse) CreateProxyEJB.getProxy(
            "Anarmorix_EAR-1.0/Anarmorix_Data_Impl-1.0/DaoAdresse!fr.afcepf.anarmorix.data.api.IDaoAdresse");
    /**
     * Commerce pour test nominal.
     */
    private Commerce commerceNominal = new Exploitation(1, "422260208", "00026", "4711D", null, "Dyomedea SARL", null, null);
    /**
     * ID non existant pour commerce test d'échec.
     */
    private static final int ID_NON_EXISTANT = 14;
    /**
     * Commerce non existant dans bdd pour test échec.
     */
    private Commerce commerceNonExistant = new Exploitation(ID_NON_EXISTANT, null, null, null, null, null, null, null);
    /**
     * Numéro de voie pour adresse attendu.
     */
    private static final int NUM_NOMINAL = 35;
    /**
     * Adresse attendu pour test nominal.
     */
    private Adresse adresseNominale = new Adresse(1, NUM_NOMINAL, null, "Chemin de Kerpuns", null, null, "-3.036797", "48.772258");
    /**
     * Test du cas où le commerce en paramètre n'est pas en base de données.
     * @throws AnarmorixException non attendu
     */
    @Test
    public void testEchecCommerceNonExistant() throws AnarmorixException {
        try {
            daoTest.getByCommerce(commerceNonExistant);
            Assert.fail("Test d'échec qui ne devrait pas réussir");
        } catch (AnarmorixException e) {
            Assert.assertEquals(AnarmorixExceptionEnum.ERREUR_NON_IDENTIFIEE, e.getCodeErreur());
        }
    }
    /**
     * Test nominal.
     * @throws AnarmorixException exception non attendue
     */
    @Test
    public void testNominal() throws AnarmorixException {
        Commerce retour = daoTest.getByCommerce(commerceNominal);
        Assert.assertNotNull(retour);
        Assert.assertNotNull(retour.getAdresse());
        Assert.assertEquals(commerceNominal.getClass(), retour.getClass());
        Assert.assertEquals(commerceNominal.getId(), retour.getId());
        Assert.assertEquals(commerceNominal.getCodeApe(), retour.getCodeApe());
        Assert.assertEquals(commerceNominal.getNumNic(), retour.getNumNic());
        Assert.assertEquals(commerceNominal.getNumSiren(), retour.getNumSiren());
        Assert.assertEquals(commerceNominal.getRaisonSociale(), retour.getRaisonSociale());
        Assert.assertEquals(adresseNominale.getId(), retour.getAdresse().getId());
        Assert.assertEquals(adresseNominale.getNumero(), retour.getAdresse().getNumero());
        Assert.assertEquals(adresseNominale.getVoie(), retour.getAdresse().getVoie());
        Assert.assertEquals(adresseNominale.getLatitude(), retour.getAdresse().getLatitude());
        Assert.assertEquals(adresseNominale.getLongitude(), retour.getAdresse().getLongitude());
    }

}

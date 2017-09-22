package fr.afcepf.anarmorix.data.test;

import org.junit.Assert;
import org.junit.Test;

import fr.afcepf.anarmorix.data.api.IDaoVille;
import fr.afcepf.anarmorix.entity.Adresse;
import fr.afcepf.anarmorix.entity.Ville;
import fr.afcepf.anarmorix.exception.AnarmorixException;
import fr.afcepf.anarmorix.exception.AnarmorixExceptionEnum;

/**
 * Classe de test de la méthode getByAdress de {@link DaoVille}.
 * @author Aubin
 *
 */
public class TestGetByAdressDaoVille {
    /**
     * Classe contenant les services à tester.
     */
    private IDaoVille daoTest = (IDaoVille) CreateProxyEJB.getProxy(
            "Anarmorix_EAR-1.0/Anarmorix_Data_Impl-1.0/DaoVille!fr.afcepf.anarmorix.data.api.IDaoVille");
    /**
     * Numéro de voie pour adresse nominal.
     */
    private static final int NUM_NOMINAL = 35;
    /**
     * Adresse pour test nominal.
     */
    private Adresse adresseNominale = new Adresse(1, NUM_NOMINAL, null, "Chemin de Kerpuns", null, null, "-3.036797", "48.772258");
    /**
     * ID non existant pour test adresse non existante.
     */
    private static final int ID_NON_EXISTANT = 20;
    /**
     * Adresse n'existant pas dans la base.
     */
    private Adresse adresseNonExistante = new Adresse(ID_NON_EXISTANT, 1, null, "test", null, null, "1.00", "-3.00");
    /**
     * Ville attendu pour test nominal.
     */
    private Ville villeNominale = new Ville("22162", "Paimpol");
    /**
     * Test du cas où l'adresse en paramètre n'est pas en base de données.
     * @throws AnarmorixException non attendu
     */
    @Test
    public void testEchecAdresseNonExistante() throws AnarmorixException {
        try {
            daoTest.getByAdress(adresseNonExistante);
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
        Adresse retour = daoTest.getByAdress(adresseNominale);
        Assert.assertNotNull(retour);
        Assert.assertNotNull(retour.getVille());
        Assert.assertEquals(adresseNominale.getId(), retour.getId());
        Assert.assertEquals(adresseNominale.getNumero(), retour.getNumero());
        Assert.assertEquals(adresseNominale.getVoie(), retour.getVoie());
        Assert.assertEquals(adresseNominale.getLatitude(), retour.getLatitude());
        Assert.assertEquals(adresseNominale.getLongitude(), retour.getLongitude());
        Assert.assertEquals(villeNominale.getCodeInsee(), retour.getVille().getCodeInsee());
        Assert.assertEquals(villeNominale.getNomVille(), retour.getVille().getNomVille());
    }

}

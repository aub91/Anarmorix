package fr.afcepf.anarmorix.data.test;


import org.junit.Assert;
import org.junit.Test;

import fr.afcepf.anarmorix.data.api.IDaoCodePostal;
import fr.afcepf.anarmorix.entity.Adresse;
import fr.afcepf.anarmorix.entity.CodePostal;
import fr.afcepf.anarmorix.exception.AnarmorixException;
import fr.afcepf.anarmorix.exception.AnarmorixExceptionEnum;
/**
 * Classe de test pour la méthode getByAdress du Dao Code Postal.
 * @author Aubin
 *
 */
public class TestGetByAdressDaoCodePostal {
    /**
     * Classe contenant les services à tester.
     */
    private IDaoCodePostal daoTest = (IDaoCodePostal) CreateProxyEJB.getProxy(
            "Anarmorix_EAR-1.0/Anarmorix_Data_Impl-1.0/DaoCodePostal!fr.afcepf.anarmorix.data.api.IDaoCodePostal");
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
     * Code postal attendu pour test nominal.
     */
    private CodePostal codePostalNominal = new CodePostal(1, "22500");
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
        Assert.assertNotNull(retour.getCodePostal());
        Assert.assertEquals(adresseNominale.getId(), retour.getId());
        Assert.assertEquals(adresseNominale.getNumero(), retour.getNumero());
        Assert.assertEquals(adresseNominale.getVoie(), retour.getVoie());
        Assert.assertEquals(adresseNominale.getLatitude(), retour.getLatitude());
        Assert.assertEquals(adresseNominale.getLongitude(), retour.getLongitude());
        Assert.assertEquals(codePostalNominal.getId(), retour.getCodePostal().getId());
        Assert.assertEquals(codePostalNominal.getCodePostal(), retour.getCodePostal().getCodePostal());
    }
}

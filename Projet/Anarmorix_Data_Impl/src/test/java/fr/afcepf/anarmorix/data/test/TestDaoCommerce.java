package fr.afcepf.anarmorix.data.test;


import org.junit.Assert;
import org.junit.Test;

import fr.afcepf.anarmorix.data.api.IDaoCommerce;
import fr.afcepf.anarmorix.entity.Catalogue;
import fr.afcepf.anarmorix.entity.Exploitation;
import fr.afcepf.anarmorix.exception.AnarmorixException;
import fr.afcepf.anarmorix.exception.AnarmorixExceptionEnum;

/**
 * Classe contenant les tests des méthodes de la classe {@link DaoCommerce}.
 * @author Aubin
 *
 */
public class TestDaoCommerce {
    /**
     * Classe contenant les services à tester.
     */
    private IDaoCommerce dao = (IDaoCommerce) CreateProxyEJB.getProxy(
            "Anarmorix_EAR-1.0/Anarmorix_Data_Impl-1.0/DaoCommerce!fr.afcepf.anarmorix.data.api.IDaoCommerce");
    /**
     * Catalogue pour test nominal.
     */
    private Catalogue catalogueNominal = new Catalogue(1, null, null, null, null);
    /**
     * Exploitation attendue du test nominal de rechercherExploitationByCatalogue.
     */
    private Exploitation exploitationNominal = new Exploitation(1, "422260208", "00026", "4711D", null, "Dyomedea SARL", null, null);
    /**
     * Id catalogue non existant en base de données.
     */
    private static final int ID_CATALOGUE_NON_EXISTANT = 999;
    /**
     * Catalogue non existant pour test échec.
     */
    private Catalogue catalogueNonExistant = new Catalogue(ID_CATALOGUE_NON_EXISTANT, null, null, null, null);
    /**
     * Méthode de test nominal pour la méthode rechercherExploitationByCatalogue.
     * @throws AnarmorixException exception non attendue
     */
    @Test
    public void testNominalRechercherExploitationByCatalogue() throws AnarmorixException {
        Catalogue retour = dao.rechercherExploitationByCatalogue(catalogueNominal);
        Assert.assertNotNull(retour);
        Assert.assertEquals(catalogueNominal.getId(), retour.getId());
        Assert.assertNotNull(retour.getExploitation());
        Assert.assertEquals(exploitationNominal.getId(), retour.getExploitation().getId());
        Assert.assertEquals(exploitationNominal.getCodeApe(), retour.getExploitation().getCodeApe());
        Assert.assertEquals(exploitationNominal.getNumNic(), retour.getExploitation().getNumNic());
        Assert.assertEquals(exploitationNominal.getNumSiren(), retour.getExploitation().getNumSiren());
        Assert.assertEquals(exploitationNominal.getRaisonSociale(), retour.getExploitation().getRaisonSociale());
        Assert.assertNull(retour.getExploitation().getIban());
    }
    /**
     * Méthode de test échec avec catalogue non existant de rechercherExploitationByCatalogue.
     */
    @Test
    public void testEchecRechercherExploitationByCatalogue() {
        try {
            dao.rechercherExploitationByCatalogue(catalogueNonExistant);
            Assert.fail("Test d'échec qui ne devrait pas réussir");
        } catch (AnarmorixException e) {
            Assert.assertEquals(AnarmorixExceptionEnum.ERREUR_NON_IDENTIFIEE, e.getCodeErreur());
        }
    }
}

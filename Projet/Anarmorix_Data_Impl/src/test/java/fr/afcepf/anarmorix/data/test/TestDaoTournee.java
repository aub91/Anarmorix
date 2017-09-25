package fr.afcepf.anarmorix.data.test;

import org.junit.Assert;
import org.junit.Test;

import fr.afcepf.anarmorix.data.api.IDaoTournee;
import fr.afcepf.anarmorix.entity.Adresse;
import fr.afcepf.anarmorix.entity.CodePostal;
import fr.afcepf.anarmorix.entity.SocieteDeLivraison;
import fr.afcepf.anarmorix.entity.Tournee;
import fr.afcepf.anarmorix.entity.Ville;
import fr.afcepf.anarmorix.exception.AnarmorixException;

/**
 * Classe de test pour les méthodes de DaoTournee.
 * @author Aubin
 *
 */
public class TestDaoTournee {
    /**
     * Classe contenant les services à tester.
     */
    private IDaoTournee daoTest = (IDaoTournee) CreateProxyEJB.getProxy(
            "Anarmorix_EAR-1.0/Anarmorix_Data_Impl-1.0/DaoTournee!fr.afcepf.anarmorix.data.api.IDaoTournee");
    /**
     * Id pour adresseSocieteNominal.
     */
    private static final int ID_ADRESSE_SOCIETE_NOMINAL = 7;
    /**
     * Numéro voie pour adresseSocieteNominal.
     */
    private static final int NUMERO_ADRESSE_SOCIETE_NOMINAL = 7;
    /**
     * ID code postal adresse nominal.
     */
    private static final int ID_CODEPOSTAL_SOCIETE_NOMINAL = 7;
    /**
     * Adresse de société de livraison pour test nominal.
     */
    private Adresse adresseSocieteNominal = new Adresse(ID_ADRESSE_SOCIETE_NOMINAL, NUMERO_ADRESSE_SOCIETE_NOMINAL,
            null, "rue Paul Girard", new CodePostal(ID_CODEPOSTAL_SOCIETE_NOMINAL, "22200"), new Ville("22070", "Guingamp"), "-3.157254", "48.565012");
    /**
     * ID société de livraison nominal.
     */
    private static final int ID_SOCIETE_NOMINAL = 13;
    /**
     * Société de livraison pour test nominal.
     */
    private SocieteDeLivraison societeNominal =
            new SocieteDeLivraison(ID_SOCIETE_NOMINAL, "422260208", "00026", "4711D", null, "Michel SARL", adresseSocieteNominal, null);
    /**
     * ID société de livraison échec.
     */
    private static final int ID_SOCIETE_ECHEC = 14;
    /**
     * Société de livraison non existante en base de données.
     */
    private SocieteDeLivraison societeEchec =
            new SocieteDeLivraison(ID_SOCIETE_ECHEC, "422260208", "00026", "4711D", null, "Michel SARL", adresseSocieteNominal, null);
    /**
     * Tournée attendue pour test nominal.
     */
    private Tournee tourneeNominal = new Tournee(1, null, null, null, null);
    /**
     * Test avec société de livraison non existant en base de données.
     * @throws AnarmorixException exception
     */
    @Test
    public void testEchecRechercheSocieteLivraisonNonExistant() throws AnarmorixException {
        SocieteDeLivraison retour = daoTest.rechercherBySocieteDeLivraison(societeEchec);
        Assert.assertEquals(0, retour.getTournees().size());
    }
    /**
     * Test nominal.
     * @throws AnarmorixException exception
     */
    @Test
    public void testRechercheNominal() throws AnarmorixException {
        SocieteDeLivraison retour = daoTest.rechercherBySocieteDeLivraison(societeNominal);
        Assert.assertNotNull(retour);
        Assert.assertEquals(1, retour.getTournees().size());
        Assert.assertEquals(tourneeNominal.getClass(), retour.getTournees().get(0).getClass());
        Assert.assertEquals(tourneeNominal.getId(), retour.getTournees().get(0).getId());
        Assert.assertEquals(societeNominal.getClass(), retour.getClass());
        Assert.assertEquals(societeNominal.getId(), retour.getId());
        Assert.assertEquals(societeNominal.getCodeApe(), retour.getCodeApe());
        Assert.assertEquals(societeNominal.getNumNic(), retour.getNumNic());
        Assert.assertEquals(societeNominal.getNumSiren(), retour.getNumSiren());
        Assert.assertEquals(societeNominal.getRaisonSociale(), retour.getRaisonSociale());
        Assert.assertEquals(societeNominal.getAdresse().getId(), retour.getAdresse().getId());
        Assert.assertEquals(societeNominal.getAdresse().getComplementNumero(), retour.getAdresse().getComplementNumero());
        Assert.assertEquals(societeNominal.getAdresse().getLatitude(), retour.getAdresse().getLatitude());
        Assert.assertEquals(societeNominal.getAdresse().getLongitude(), retour.getAdresse().getLongitude());
        Assert.assertEquals(societeNominal.getAdresse().getNumero(), retour.getAdresse().getNumero());
        Assert.assertEquals(societeNominal.getAdresse().getVoie(), retour.getAdresse().getVoie());
        Assert.assertEquals(societeNominal.getAdresse().getVille().getCodeInsee(), retour.getAdresse().getVille().getCodeInsee());
        Assert.assertEquals(societeNominal.getAdresse().getVille().getNomVille(), retour.getAdresse().getVille().getNomVille());
        Assert.assertEquals(societeNominal.getAdresse().getCodePostal().getId(), retour.getAdresse().getCodePostal().getId());
        Assert.assertEquals(societeNominal.getAdresse().getCodePostal().getCodePostal(), retour.getAdresse().getCodePostal().getCodePostal());
    }
}

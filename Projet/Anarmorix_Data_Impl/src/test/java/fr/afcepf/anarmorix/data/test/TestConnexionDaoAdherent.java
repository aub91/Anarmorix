package fr.afcepf.anarmorix.data.test;

import org.junit.Assert;
import org.junit.Test;

import fr.afcepf.anarmorix.data.api.IDaoAdherent;
import fr.afcepf.anarmorix.entity.Adherent;
import fr.afcepf.anarmorix.exception.AnarmorixException;
import fr.afcepf.anarmorix.exception.AnarmorixExceptionEnum;

/**
 * Test de la méthode supprimer du DAO Adhérent.
 * @author Stagiaire
 *
 */
public class TestConnexionDaoAdherent {

    /**
     * Classe contenant les services à tester.
     */
    private IDaoAdherent daoTest = (IDaoAdherent) CreateProxyEJB.getProxy(
            "Anarmorix_EAR-1.0/Anarmorix_Data_Impl-1.0/DaoAdherent!fr.afcepf.anarmorix.data.api.IDaoAdherent");

    /**
     * Username pour le test du cas d'un username non répertorié.
     */
    private String usernameInexistant = "test";

    /**
     * Username valide.
     */
    private String usernameExistant = "grandarbre";

    /**
     * Password pour le test du cas d'un mauvais password.
     */
    private String passwordInvalide = "test";

    /**
     * Password valide correspondant à l'username valide.
     */
    private String passwordValide = "aaa";

    /**
     * Id de l'adhérent utilisé pour le test de connexion.
     */
    private static final int ID_ADHERENT_CNX = 1;

    /**
     * Test du cas où la connexion de l'{@link Adherent } est empêché par un mauvais username.
     */
    @Test
    public void testEchecUsernameInexistantConnexion() {
        System.out.println("UsernameInexistant");
        try {
            daoTest.seConnecter(usernameInexistant, passwordValide);
            System.out.println("try de la méthode");
            Assert.fail("Test d'echec (username inexistant), mais ça marche. Il y a un petit problème... !");
        } catch (AnarmorixException e) {
            System.out.println("*************************************************************************************");
            System.out.println(e.getCodeErreur());
            Assert.assertEquals(AnarmorixExceptionEnum.ERREUR_IDENTIFIANTS_CONNEXION, e.getCodeErreur());
            System.out.println("*************************************************************************************");
            System.out.println(e.getCodeErreur());
        }
    }

    /**
     * Test du cas où la connexion de l'{@link Adherent} est empêchée par un mot de passe invalide.
     */
    @Test
    public void testEchecPasswordInvalideConnexion() {
        System.out.println("Password invalide");
        try {
            daoTest.seConnecter(usernameExistant, passwordInvalide);
            System.out.println("try de la méthode");
            Assert.fail("Test d'echec (Mot de passe invalide), mais ça marche. Il y a un petit problème... !");
        } catch (AnarmorixException e) {
            System.out.println("*************************************************************************************");
            System.out.println(e.getCodeErreur());
            Assert.assertEquals(AnarmorixExceptionEnum.ERREUR_IDENTIFIANTS_CONNEXION, e.getCodeErreur());
            System.out.println("*************************************************************************************");
            System.out.println(e.getCodeErreur());
        }
    }

    /**
     * Test du cas nominal.
     * @throws AnarmorixException qui ne doit jamais apparaître dans le test nominal
     */
    @Test
    public void testNominalAjout() throws AnarmorixException {
        Adherent retour = daoTest.seConnecter(usernameExistant, passwordValide);
        System.out.println("*************************************************************************************");
        System.out.println(retour);
        System.out.println("*************************************************************************************");
        Assert.assertNotNull(retour.getId());
        Assert.assertNotNull(retour.getNom());
        Assert.assertNotNull(retour.getPrenom());
        Assert.assertNotNull(retour.getTelephone1());
        Assert.assertNotNull(retour.getMail());
        Assert.assertNotNull(retour.getUsername());
        Assert.assertNotNull(retour.getPassword());
        Assert.assertEquals("Grandarbre", retour.getNom());
        Assert.assertEquals("Jean-Jacques", retour.getPrenom());
        Assert.assertEquals("0666666666", retour.getTelephone1());
        Assert.assertEquals("jj.grandarbre@mail.fr", retour.getMail());
        Assert.assertEquals("grandarbre", retour.getUsername());
        Assert.assertEquals("aaa", retour.getPassword());
        Assert.assertEquals(ID_ADHERENT_CNX, retour.getId().intValue());
    }
}

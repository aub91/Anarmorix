package fr.afcepf.anarmorix.data.test;

import java.sql.Date;

import org.junit.Assert;
import org.junit.Test;

import fr.afcepf.anarmorix.data.impl.DaoAdherent;
import fr.afcepf.anarmorix.entity.Adherent;
import fr.afcepf.anarmorix.entity.Adresse;
import fr.afcepf.anarmorix.entity.Client;
import fr.afcepf.anarmorix.entity.CodePostal;
import fr.afcepf.anarmorix.entity.Ville;
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
    private DaoAdherent daoTest = new DaoAdherent();

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
     * Test du cas où la connexion de l'{@link Adherent } est empêché par un mauvais username.
     */
    @Test
    public void testEchecAttributNullConnexion() {
        try {
            daoTest.seConnecter(usernameInexistant, passwordValide);
            Assert.fail("Test d'echec (attribut null), mais ça marche. Il y a un petit problème... !");
        } catch (AnarmorixException e) {
            Assert.assertEquals(AnarmorixExceptionEnum.NULL_DATA, e.getCodeErreur());
        }
    }

    /**
     * Test du cas où une String est trop longue.
     */
    @Test
    public void testEchecTropLongAjout() {
        try {
            daoTest.ajouter(adherentTropLong);
            Assert.fail("Test d'echec (String trop longue), mais ça marche. Il y a un petit problème... !");
        } catch (AnarmorixException e) {
            Assert.assertEquals(AnarmorixExceptionEnum.TOO_LONG_DATA, e.getCodeErreur());
        }
    }

    /**
     * Test du cas où on a une violation de contrainte d'intégrité.
     */
    @Test
    public void testEchecViolationContrainteAjout() {
        try {
            daoTest.ajouter(adherentViolationContrainte);
            Assert.fail("Test d'echec (Violation de contrainte d'intégrité), mais ça marche. Il y a un petit problème... !");
        } catch (AnarmorixException e) {
            Assert.assertEquals(AnarmorixExceptionEnum.VIOLATION_DE_CONTRAINTE, e.getCodeErreur());
        }
    }

    /**
     * Test du cas nominal.
     * @throws AnarmorixException qui ne doit jamais apparaître dans le test nominal
     */
    @Test
    public void testNominalAjout() throws AnarmorixException {
        Adherent retour = daoTest.ajouter(adherentNominal);
        Assert.assertNotNull(retour.getId());
        Assert.assertNotNull(retour.getNom());
        Assert.assertNotNull(retour.getPrenom());
        Assert.assertNotNull(retour.getDateInscription());
        Assert.assertNotNull(retour.getTelephone1());
        Assert.assertNotNull(retour.getMail());
        Assert.assertNotNull(retour.getUsername());
        Assert.assertNotNull(retour.getPassword());
        Assert.assertNotNull(retour.getDateNaissance());
        Assert.assertEquals("Petitbuisson", retour.getNom());
        Assert.assertEquals("Jean-Marc", retour.getPrenom());
        Assert.assertEquals("0123456789", retour.getTelephone1());
        Assert.assertEquals("jm.petitbuisson@mail.fr", retour.getMail());
        Assert.assertEquals("jmpetitbuisson", retour.getUsername());
        Assert.assertEquals("aaa", retour.getPassword());
        Assert.assertEquals(ID_ADHERENT_FICTIF, retour.getId().intValue());
        
    }
}

package fr.afcepf.anarmorix.business.test;

import java.lang.reflect.Field;

import org.junit.Assert;
import org.junit.Test;

import fr.afcepf.anarmorix.business.api.IBusinessConnexion;
import fr.afcepf.anarmorix.business.impl.BusinessConnexion;
import fr.afcepf.anarmorix.data.api.IDaoAdherent;
import fr.afcepf.anarmorix.data.impl.DaoAdherent;
import fr.afcepf.anarmorix.entity.Adherent;
import fr.afcepf.anarmorix.entity.Client;
import fr.afcepf.anarmorix.exception.AnarmorixException;
import fr.afcepf.anarmorix.exception.AnarmorixExceptionEnum;

/**
 * Test des méthodes de {@link IBusinessConnexion}.
 * @author Aubin
 *
 */
public class TestBusinessConnexion {
    /**
     * Classe avec les méthodes à utiliser.
     */
    private IBusinessConnexion busCnx = new BusinessConnexion();
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
     * Test nominal seConnecter.
     * @throws AnarmorixException exception non attendue.
     */
    @Test
    public void testNominalSeConnecter() throws AnarmorixException {
        Adherent retour = busCnx.seConnecter(usernameExistant, passwordValide);
        Assert.assertNotNull(retour);
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
    /**
     * Test du cas où la connexion de l'{@link Adherent } est empêché par un mauvais username.
     */
    @Test
    public void testEchecUsernameInexistantConnexion() {
        try {
            busCnx.seConnecter(usernameInexistant, passwordValide);
            Assert.fail("Test d'echec (username inexistant), mais ça marche. Il y a un petit problème... !");
        } catch (AnarmorixException e) {
            Assert.assertEquals(AnarmorixExceptionEnum.ERREUR_IDENTIFIANTS_CONNEXION, e.getCodeErreur());
        }
    }

    /**
     * Test du cas où la connexion de l'{@link Adherent} est empêchée par un mot de passe invalide.
     */
    @Test
    public void testEchecPasswordInvalideConnexion() {
        try {
            busCnx.seConnecter(usernameExistant, passwordInvalide);
            Assert.fail("Test d'echec (Mot de passe invalide), mais ça marche. Il y a un petit problème... !");
        } catch (AnarmorixException e) {
            Assert.assertEquals(AnarmorixExceptionEnum.ERREUR_IDENTIFIANTS_CONNEXION, e.getCodeErreur());
        }
    }
    /**
     * Default constructor avec injection de mock.
     */
    public TestBusinessConnexion() {
        IDaoAdherent mockDaoAdherent = new DaoAdherent() {
            @Override
            public Adherent seConnecter(String paramUsername, String paramPassword) throws AnarmorixException {
                if (!(paramUsername.equals(usernameExistant) && paramPassword.equals(passwordValide))) {
                    throw new AnarmorixException("", AnarmorixExceptionEnum.ERREUR_IDENTIFIANTS_CONNEXION);
                }
                return new Client(ID_ADHERENT_CNX, null, "Grandarbre", "Jean-Jacques", null, null,
                        "jj.grandarbre@mail.fr", "0666666666", null, "grandarbre", "aaa", null);
            }
        };
        try {
            Class<?> clazz = busCnx.getClass();
            Field attDaoAdherent = clazz.getDeclaredField("dao");
            attDaoAdherent.setAccessible(true);
            attDaoAdherent.set(busCnx, mockDaoAdherent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

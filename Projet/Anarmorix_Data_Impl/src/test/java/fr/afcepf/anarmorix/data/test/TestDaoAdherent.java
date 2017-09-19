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
 * Test des méthodes du DAO Adhérent.
 * @author Stagiaire
 *
 */
public class TestDaoAdherent {

    /**
     * Id d'une adresse n'existant pas en base.
     */
    private static final int ID_ADRESSE_INEXISTANTE = 818418168;

    /**
     * Classe contenant les services à tester.
     */
    private DaoAdherent daoTest = new DaoAdherent();

    /**
     * Ville de l'adresse de l'adhérent.
     */
    private Ville ville = new Ville("1", "Guingamp");

    /**
     * Code postal de l'adresse de l'adhérent.
     */
    private CodePostal cp = new CodePostal(1, "22200");

    /**
     * Adresse de l'adhérent.
     */
    private Adresse adresse = new Adresse(1, 1, null, "rue Hun", cp, ville, "0.0001", "0.0001");

    /**
     * Adresse n'existant pas en base.
     */
    private Adresse adresseInexistante = new Adresse(ID_ADRESSE_INEXISTANTE, 1, null, "rue Hun", cp, ville, "0.0001", "0.0001");

    /**
     * Adherent pour test nominal.
     */
    private Adherent adherentNominal = new Client(1, new Date(0), "Petitbuisson", "Jean-Marc", new Date(0), adresse,
                                                  "jm.petitbuisson@mail.fr", "0123456789", null, "jmpetitbuisson", "aaa", null);

    /**
     * Adhérent pour test de non nullable null.
     */
    private Adherent adherentAttributNull = new Client(1, new Date(0), "Petitbuisson", "Jean-Marc", new Date(0), adresse,
            "jm.petitbuisson@mail.fr", "0123456789", null, "jmpetitbuisson", "aaa", null);

    /**
     * Adhérent pour test nom trop long.
     */
    private Adherent adherentTropLong = new Client(1, new Date(0),
                                                  "Petitbuisson-presquelarbrequicahelaforêt-maisquandmêmepastoutàfait-ceseraitexagéré-nestcepas",
                                                  "Jean-Marc", new Date(0), adresse,
                                                  "jm.petitbuisson@mail.fr", "0123456789", null, "jmpetitbuisson", "aaa", null);

    /**
     * Adhérent pour test de violation de contrainte d'intégrité.
     */
    private Adherent adherentViolationContrainte = new Client(1, new Date(0), "Petitbuisson", "Jean-Marc", new Date(0), adresseInexistante,
                                                  "jm.petitbuisson@mail.fr", "0123456789", null, "jmpetitbuisson", "aaa", null);

    /**
     * Test du cas où l'ajout de l'{@link Adherent } à la base est empêché par une valeur null.
     */
    @Test
    public void testEchecAttributNullAjout() {
        try {
            daoTest.ajouter(adherentAttributNull);
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
     */
    @Test
    public void TestNominalAjout() {
        
    }
}

package fr.afcepf.anarmorix.business.test;

import java.lang.reflect.Field;

import org.junit.Assert;
import org.junit.Test;

import fr.afcepf.anarmorix.business.api.IBusinessMap;
import fr.afcepf.anarmorix.business.impl.BusinessMap;
import fr.afcepf.anarmorix.data.api.IDaoCodePostal;
import fr.afcepf.anarmorix.data.api.IDaoVille;
import fr.afcepf.anarmorix.data.impl.DaoCodePostal;
import fr.afcepf.anarmorix.data.impl.DaoVille;
import fr.afcepf.anarmorix.entity.Adresse;
import fr.afcepf.anarmorix.entity.CodePostal;
import fr.afcepf.anarmorix.entity.Ville;
import fr.afcepf.anarmorix.exception.AnarmorixException;
import fr.afcepf.anarmorix.exception.AnarmorixExceptionEnum;

/**
 * Classe de test pour la méthode alimenterJourOuverture de {@link BusinessMap}.
 * @author Aubin
 *
 */
public class TestAlimenterAdresseBusinessMap {
    /**
     * La classe contenant la méthode à tester.
     */
    private IBusinessMap busMap = new BusinessMap();
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
            busMap.alimenterAdresse(adresseNonExistante);
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
        Adresse retour = busMap.alimenterAdresse(adresseNominale);
        Assert.assertNotNull(retour);
        Assert.assertNotNull(retour.getVille());
        Assert.assertEquals(adresseNominale.getId(), retour.getId());
        Assert.assertEquals(adresseNominale.getNumero(), retour.getNumero());
        Assert.assertEquals(adresseNominale.getVoie(), retour.getVoie());
        Assert.assertEquals(adresseNominale.getLatitude(), retour.getLatitude());
        Assert.assertEquals(adresseNominale.getLongitude(), retour.getLongitude());
        Assert.assertEquals(villeNominale.getCodeInsee(), retour.getVille().getCodeInsee());
        Assert.assertEquals(villeNominale.getNomVille(), retour.getVille().getNomVille());
        Assert.assertEquals(codePostalNominal.getId(), retour.getCodePostal().getId());
        Assert.assertEquals(codePostalNominal.getCodePostal(), retour.getCodePostal().getCodePostal());
    }
    /**
     * Default constructor avec injection mock.
     */
    public TestAlimenterAdresseBusinessMap() {
        IDaoVille mockDaoVille = new DaoVille() {
            @Override
            public Adresse getByAdress(Adresse paramAdresse) throws AnarmorixException {
                if (paramAdresse.getId().equals(1)) {
                    paramAdresse.setVille(villeNominale);
                } else {
                    throw new AnarmorixException("", AnarmorixExceptionEnum.ERREUR_NON_IDENTIFIEE);
                }
                return paramAdresse;
            }
        };
        IDaoCodePostal mockDaoCodePostal = new DaoCodePostal() {
            @Override
            public Adresse getByAdress(Adresse paramAdresse) throws AnarmorixException {
                if (paramAdresse.getId().equals(1)) {
                    paramAdresse.setCodePostal(codePostalNominal);
                } else {
                    throw new AnarmorixException("", AnarmorixExceptionEnum.ERREUR_NON_IDENTIFIEE);
                }
                return paramAdresse;
            }
        };
        try {
            Class<?> clazz = busMap.getClass();
            Field attDaoVille = clazz.getDeclaredField("daoVille");
            attDaoVille.setAccessible(true);
            attDaoVille.set(busMap, mockDaoVille);
            Field attDaoCodePostal = clazz.getDeclaredField("daoCodePostal");
            attDaoCodePostal.setAccessible(true);
            attDaoCodePostal.set(busMap, mockDaoCodePostal);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

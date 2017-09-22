package fr.afcepf.anarmorix.business.test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import fr.afcepf.anarmorix.business.api.IBusinessMap;
import fr.afcepf.anarmorix.business.impl.BusinessMap;
import fr.afcepf.anarmorix.data.api.IDaoAdresse;
import fr.afcepf.anarmorix.data.api.IDaoJourOuverture;
import fr.afcepf.anarmorix.data.impl.DaoAdresse;
import fr.afcepf.anarmorix.data.impl.DaoJourOuverture;
import fr.afcepf.anarmorix.entity.Adresse;
import fr.afcepf.anarmorix.entity.Commerce;
import fr.afcepf.anarmorix.entity.JourOuverture;
import fr.afcepf.anarmorix.entity.PointRelais;
import fr.afcepf.anarmorix.exception.AnarmorixException;
import fr.afcepf.anarmorix.exception.AnarmorixExceptionEnum;

/**
 * Classe de test pour la méthode alimenterPointRelais de {@link BusinessMap}.
 * @author Aubin
 *
 */
public class TestAlimenterPointRelaisBusinessMap {
    /**
     * La classe contenant la méthode à tester.
     */
    private IBusinessMap busMap = new BusinessMap();
    /**
     * Taille atendue de la liste de jour d'ouverture pour le test nominal.
     */
    private static final int TAILLE_LISTE = 5;
    /**
     * Id point relais nominal.
     */
    private static final int ID_RELAIS_NOMINAL = 4;
    /**
     * {@link PointRelais} pour test nominal.
     */
    private PointRelais relaisNominal = new PointRelais(ID_RELAIS_NOMINAL, "422260208", "00026", "4711D", null, "Kantbuymelove SARL", null, null);
    /**
     * Id point relais non existant.
     */
    private static final int ID_RELAIS_NON_EXISTANT = 14;
    /**
     * {@link PointRelais} non existant dans bdd pour test échec.
     */
    private PointRelais relaisNonExistant = new PointRelais(ID_RELAIS_NON_EXISTANT, "422260208", "00026", "4711D", null, "Kantbuymelove SARL", null, null);
    /**
     * ID pour adresse attendu.
     */
    private static final int ID_ADRESSE_NOMINAL = 4;
    /**
     * Adresse attendu pour test nominal.
     */
    private Adresse adresseNominale = new Adresse(ID_ADRESSE_NOMINAL, 1, null, "Chemin de Kerpuns", null, null, "-3.059167", "48.782303");
    /**
     * Test avec point-relais non existant en base de données.
     * @throws AnarmorixException exception
     */
    @Test
    public void testEchecPointRelaisNonExistant() throws AnarmorixException {
        try {
            busMap.alimenterPointRelais(relaisNonExistant);
            Assert.fail("Test d'échec qui ne devrait pas réussir");
        } catch (AnarmorixException e) {
            Assert.assertEquals(AnarmorixExceptionEnum.ERREUR_NON_IDENTIFIEE, e.getCodeErreur());
        }
    }
    /**
     * Test nominal.
     * @throws AnarmorixException exception
     */
    @Test
    public void testNominal() throws AnarmorixException {
        PointRelais retour = busMap.alimenterPointRelais(relaisNominal);
        Assert.assertNotNull(retour);
        Assert.assertNotNull(retour.getJoursOuverture());
        Assert.assertEquals(TAILLE_LISTE, retour.getJoursOuverture().size());
        Assert.assertEquals(relaisNominal.getClass(), retour.getClass());
        Assert.assertEquals(relaisNominal.getId(), retour.getId());
        Assert.assertEquals(relaisNominal.getCodeApe(), retour.getCodeApe());
        Assert.assertEquals(relaisNominal.getNumNic(), retour.getNumNic());
        Assert.assertEquals(relaisNominal.getNumSiren(), retour.getNumSiren());
        Assert.assertEquals(relaisNominal.getRaisonSociale(), retour.getRaisonSociale());
        Assert.assertEquals(adresseNominale.getId(), retour.getAdresse().getId());
        Assert.assertEquals(adresseNominale.getNumero(), retour.getAdresse().getNumero());
        Assert.assertEquals(adresseNominale.getVoie(), retour.getAdresse().getVoie());
        Assert.assertEquals(adresseNominale.getLatitude(), retour.getAdresse().getLatitude());
        Assert.assertEquals(adresseNominale.getLongitude(), retour.getAdresse().getLongitude());
    }
    /**
     * Default constructor avec injection mock.
     */
    public TestAlimenterPointRelaisBusinessMap() {
        IDaoAdresse mockDaoAdresse = new DaoAdresse() {
            @Override
            public Commerce getByCommerce(Commerce paramCommerce) throws AnarmorixException {
                if (paramCommerce.getId().equals(ID_RELAIS_NOMINAL)) {
                    paramCommerce.setAdresse(adresseNominale);
                } else {
                    throw new AnarmorixException("", AnarmorixExceptionEnum.ERREUR_NON_IDENTIFIEE);
                }
                return paramCommerce;
            }
        };
        IDaoJourOuverture mockDaoJourOuverture = new DaoJourOuverture() {
            @Override
            public PointRelais getAllByPointRelais(PointRelais paramPointRelais) throws AnarmorixException {
                List<JourOuverture> liste = new ArrayList<>();
                if (paramPointRelais.getId().equals(ID_RELAIS_NOMINAL)) {
                    for (int i = 0; i < TAILLE_LISTE; i++) {
                        liste.add(new JourOuverture(i, null, null));
                    }
                }
                paramPointRelais.setJoursOuverture(liste);
                return paramPointRelais;
            }
        };
        try {
            Class<?> clazz = busMap.getClass();
            Field attDaoAdresse = clazz.getDeclaredField("daoAdresse");
            attDaoAdresse.setAccessible(true);
            attDaoAdresse.set(busMap, mockDaoAdresse);
            Field attDaoJourOuverture = clazz.getDeclaredField("daoJourOuverture");
            attDaoJourOuverture.setAccessible(true);
            attDaoJourOuverture.set(busMap, mockDaoJourOuverture);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

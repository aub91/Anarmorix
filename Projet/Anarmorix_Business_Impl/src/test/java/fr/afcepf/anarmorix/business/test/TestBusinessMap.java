package fr.afcepf.anarmorix.business.test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import fr.afcepf.anarmorix.business.api.IBusinessMap;
import fr.afcepf.anarmorix.business.impl.BusinessMap;
import fr.afcepf.anarmorix.data.api.IDaoAdresse;
import fr.afcepf.anarmorix.data.api.IDaoCodePostal;
import fr.afcepf.anarmorix.data.api.IDaoHoraire;
import fr.afcepf.anarmorix.data.api.IDaoJourOuverture;
import fr.afcepf.anarmorix.data.api.IDaoPointRelais;
import fr.afcepf.anarmorix.data.api.IDaoVille;
import fr.afcepf.anarmorix.data.impl.DaoAdresse;
import fr.afcepf.anarmorix.data.impl.DaoCodePostal;
import fr.afcepf.anarmorix.data.impl.DaoHoraire;
import fr.afcepf.anarmorix.data.impl.DaoJourOuverture;
import fr.afcepf.anarmorix.data.impl.DaoPointRelais;
import fr.afcepf.anarmorix.data.impl.DaoVille;
import fr.afcepf.anarmorix.entity.Adresse;
import fr.afcepf.anarmorix.entity.CodePostal;
import fr.afcepf.anarmorix.entity.Commerce;
import fr.afcepf.anarmorix.entity.Horaire;
import fr.afcepf.anarmorix.entity.JourOuverture;
import fr.afcepf.anarmorix.entity.PointRelais;
import fr.afcepf.anarmorix.entity.Ville;
import fr.afcepf.anarmorix.exception.AnarmorixException;
import fr.afcepf.anarmorix.exception.AnarmorixExceptionEnum;

/**
 * Classe de test pour la méthode alimenterPointRelais de {@link BusinessMap}.
 * @author Aubin
 *
 */
public class TestBusinessMap {
    /**
     * La classe contenant la méthode à tester.
     */
    private IBusinessMap busMap = new BusinessMap();
    /**
     * Taille atendue de la liste de jour d'ouverture pour le test nominal.
     */
    private static final int TAILLE_LISTE_JOUR_OUVERTURE = 5;
    /**
     * La taille de liste de point-relais attendue.
     */
    private static final int TAILLE_LISTE_POINT_RELAIS = 9;
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
     * ID non existant pour test adresse non existante.
     */
    private static final int ID_ADRESSE_NON_EXISTANT = 20;
    /**
     * Adresse n'existant pas dans la base.
     */
    private Adresse adresseNonExistante = new Adresse(ID_ADRESSE_NON_EXISTANT, 1, null, "test", null, null, "1.00", "-3.00");
    /**
     * Code postal attendu pour test nominal.
     */
    private CodePostal codePostalNominal = new CodePostal(1, "22500");
    /**
     * Ville attendu pour test nominal.
     */
    private Ville villeNominale = new Ville("22162", "Paimpol");
    /**
     * Taille atendue de la liste pour le test nominal.
     */
    private static final int TAILLE_LISTE_HORAIRE = 1;
    /**
     * {@link JourOuverture} pour test nominal.
     */
    private JourOuverture jourOuvertureNominal = new JourOuverture(1, "Lundi", null);
    /**
     * ID horaire non existant pour test échec alimenterJourOuverture.
     */
    private static final int ID_HORAIRE_NON_EXISTANT = 16;
    /**
     * {@link JourOuverture} inexistant dans base de données pour test échec.
     */
    private JourOuverture jourOuvertureNonExistant = new JourOuverture(ID_HORAIRE_NON_EXISTANT, "Dimanche", null);
    /**
     * Test getAllPointRelais Nominal.
     * @throws AnarmorixException non attendue.
     */
    @Test
    public void testGetAllPointRelaisNominal() throws AnarmorixException {
        List<PointRelais> retour = busMap.getAllPointRelais();
        Assert.assertNotNull(retour);
        Assert.assertEquals(TAILLE_LISTE_POINT_RELAIS, retour.size());
     }
    /**
     * Test alimenterPointRelais avec point-relais non existant en base de données.
     * @throws AnarmorixException exception
     */
    @Test
    public void testEchecAlimenterPointRelaisNonExistant() throws AnarmorixException {
        try {
            busMap.alimenterPointRelais(relaisNonExistant);
            Assert.fail("Test d'échec qui ne devrait pas réussir");
        } catch (AnarmorixException e) {
            Assert.assertEquals(AnarmorixExceptionEnum.ERREUR_NON_IDENTIFIEE, e.getCodeErreur());
        }
    }
    /**
     * Test nominal alimenterPointRelais.
     * @throws AnarmorixException exception
     */
    @Test
    public void testAlimenterPointRelaisNominal() throws AnarmorixException {
        PointRelais retour = busMap.alimenterPointRelais(relaisNominal);
        Assert.assertNotNull(retour);
        Assert.assertNotNull(retour.getJoursOuverture());
        Assert.assertEquals(TAILLE_LISTE_JOUR_OUVERTURE, retour.getJoursOuverture().size());
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
     * Test alimenterAdresse nominal.
     * @throws AnarmorixException exception non attendue
     */
    @Test
    public void testAlimenterAdresseNominal() throws AnarmorixException {
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
     * Test alimenterJourOuverture avec jour ouverture non existant en base de données.
     * @throws AnarmorixException exception
     */
    @Test
    public void testEchecJourOuvertureNonExistant() throws AnarmorixException {
        JourOuverture retour = busMap.alimenterJourOuverture(jourOuvertureNonExistant);
        Assert.assertEquals(0, retour.getHorairesOuverture().size());
    }
    /**
     * Test alimenterJourOuverture nominal.
     * @throws AnarmorixException exception
     */
    @Test
    public void testAlimenterJourOuvertureNominal() throws AnarmorixException {
        JourOuverture retour = busMap.alimenterJourOuverture(jourOuvertureNominal);
        Assert.assertNotNull(retour);
        Assert.assertNotNull(retour.getHorairesOuverture());
        Assert.assertEquals(TAILLE_LISTE_HORAIRE, retour.getHorairesOuverture().size());
        Assert.assertEquals(jourOuvertureNominal.getClass(), retour.getClass());
        Assert.assertEquals(jourOuvertureNominal.getId(), retour.getId());
        Assert.assertEquals(jourOuvertureNominal.getLibelle(), retour.getLibelle());
    }
    /**
     * Default constructor avec injection mock.
     */
    public TestBusinessMap() {
        IDaoPointRelais mockDaoPointRelais = new DaoPointRelais() {
            @Override
            public List<PointRelais> getAll() throws AnarmorixException {
                List<PointRelais> liste = new ArrayList<>();
                for (int i = 0; i < TAILLE_LISTE_POINT_RELAIS; i++) {
                    PointRelais pr = new PointRelais(ID_RELAIS_NOMINAL, "422260208", "00026", "4711D", null, "Kantbuymelove SARL", null, null);
                    liste.add(pr);
                }
                return liste;
            }
        };
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
                    for (int i = 0; i < TAILLE_LISTE_JOUR_OUVERTURE; i++) {
                        liste.add(new JourOuverture(i, null, null));
                    }
                }
                paramPointRelais.setJoursOuverture(liste);
                return paramPointRelais;
            }
        };
        IDaoHoraire mockDaoHoraire = new DaoHoraire() {
            @Override
            public JourOuverture getHoraireByJourOuverture(JourOuverture paramJourOuverture) throws AnarmorixException {
                List<Horaire> liste = new ArrayList<>();
                if (paramJourOuverture.getId().equals(1)) {
                    liste.add(new Horaire(1, "Matinée", "9h00", "12h30", null));
                }
                paramJourOuverture.setHorairesOuverture(liste);
                return paramJourOuverture;
            }
        };
        IDaoVille mockDaoVille = new DaoVille() {
            @Override
            public Adresse getByAdress(Adresse paramAdresse) throws AnarmorixException {
                if (paramAdresse.getId().equals(ID_ADRESSE_NOMINAL)) {
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
                if (paramAdresse.getId().equals(ID_ADRESSE_NOMINAL)) {
                    paramAdresse.setCodePostal(codePostalNominal);
                } else {
                    throw new AnarmorixException("", AnarmorixExceptionEnum.ERREUR_NON_IDENTIFIEE);
                }
                return paramAdresse;
            }
        };
        try {
            Class<?> clazz = busMap.getClass();
            Field attDaoPointRelais = clazz.getDeclaredField("daoPointRelais");
            attDaoPointRelais.setAccessible(true);
            attDaoPointRelais.set(busMap, mockDaoPointRelais);

            Field attDaoAdresse = clazz.getDeclaredField("daoAdresse");
            attDaoAdresse.setAccessible(true);
            attDaoAdresse.set(busMap, mockDaoAdresse);

            Field attDaoJourOuverture = clazz.getDeclaredField("daoJourOuverture");
            attDaoJourOuverture.setAccessible(true);
            attDaoJourOuverture.set(busMap, mockDaoJourOuverture);

            Field attDaoHoraire = clazz.getDeclaredField("daoHoraire");
            attDaoHoraire.setAccessible(true);
            attDaoHoraire.set(busMap, mockDaoHoraire);

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

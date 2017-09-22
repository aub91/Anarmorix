package fr.afcepf.anarmorix.business.test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import fr.afcepf.anarmorix.business.api.IBusinessMap;
import fr.afcepf.anarmorix.business.impl.BusinessMap;
import fr.afcepf.anarmorix.data.api.IDaoHoraire;
import fr.afcepf.anarmorix.data.impl.DaoHoraire;
import fr.afcepf.anarmorix.entity.Horaire;
import fr.afcepf.anarmorix.entity.JourOuverture;
import fr.afcepf.anarmorix.exception.AnarmorixException;

/**
 * Classe de test pour la méthode alimenterJourOuverture de {@link BusinessMap}.
 * @author Aubin
 *
 */
public class TestAlimenterJourOuvertureBusinessMap {
    /**
     * La classe contenant la méthode à tester.
     */
    private IBusinessMap busMap = new BusinessMap();
    /**
     * Taille atendue de la liste pour le test nominal.
     */
    private static final int TAILLE_LISTE = 1;
    /**
     * {@link JourOuverture} pour test nominal.
     */
    private JourOuverture jourOuvertureNominal = new JourOuverture(1, "Lundi", null);
    /**
     * ID non existant pour test échec.
     */
    private static final int ID_NON_EXISTANT = 16;
    /**
     * {@link JourOuverture} inexistant dans base de données pour test échec.
     */
    private JourOuverture jourOuvertureNonExistant = new JourOuverture(ID_NON_EXISTANT, "Dimanche", null);
    /**
     * Test avec jour ouverture non existant en base de données.
     * @throws AnarmorixException exception
     */
    @Test
    public void testEchecJourOuvertureNonExistant() throws AnarmorixException {
        JourOuverture retour = busMap.alimenterJourOuverture(jourOuvertureNonExistant);
        Assert.assertEquals(0, retour.getHorairesOuverture().size());
    }
    /**
     * Test nominal.
     * @throws AnarmorixException exception
     */
    @Test
    public void testNominal() throws AnarmorixException {
        JourOuverture retour = busMap.alimenterJourOuverture(jourOuvertureNominal);
        Assert.assertNotNull(retour);
        Assert.assertNotNull(retour.getHorairesOuverture());
        Assert.assertEquals(TAILLE_LISTE, retour.getHorairesOuverture().size());
        Assert.assertEquals(jourOuvertureNominal.getClass(), retour.getClass());
        Assert.assertEquals(jourOuvertureNominal.getId(), retour.getId());
        Assert.assertEquals(jourOuvertureNominal.getLibelle(), retour.getLibelle());
    }
    /**
     * Default constructor avec injection de mock.
     */
    public TestAlimenterJourOuvertureBusinessMap() {
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
        try {
            Class<?> clazz = busMap.getClass();
            Field attDaoHoraire = clazz.getDeclaredField("daoHoraire");
            attDaoHoraire.setAccessible(true);
            attDaoHoraire.set(busMap, mockDaoHoraire);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

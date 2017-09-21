package fr.afcepf.anarmorix.business.test;
/**
 * Classe de test de la méthode getAllPointRelais de la classe BusinessMap.
 * @author Aubin
 *
 */

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import fr.afcepf.anarmorix.business.api.IBusinessMap;
import fr.afcepf.anarmorix.business.impl.BusinessMap;
import fr.afcepf.anarmorix.data.api.IDaoPointRelais;
import fr.afcepf.anarmorix.data.impl.DaoPointRelais;
import fr.afcepf.anarmorix.entity.PointRelais;
import fr.afcepf.anarmorix.exception.AnarmorixException;
/**
 * Classe de test de la méthode getAllPointRelais de la classe BusinessMap.
 * @author Aubin
 *
 */
public class TestGetAllPointRelaisBusinessMap {
    /**
     * La classe contenant la méthode à tester.
     */
    private IBusinessMap busMap = new BusinessMap();
    /**
     * La taille de liste de point-relais attendue.
     */
    private static final int TAILLE_LISTE = 9;
    /**
     * Test Nominal.
     * @throws AnarmorixException non attendue.
     */
    @Test
    public void testNominal() throws AnarmorixException {
        List<PointRelais> retour = busMap.getAllPointRelais();
        Assert.assertNotNull(retour);
        Assert.assertEquals(TAILLE_LISTE, retour.size());
     }
    /**
     * Default constructor.
     */
    public TestGetAllPointRelaisBusinessMap() {
        IDaoPointRelais mockDaoPointRelais = new DaoPointRelais() {
            @Override
            public List<PointRelais> getAll() throws AnarmorixException {
                List<PointRelais> liste = new ArrayList<>();
                for (int i = 0; i < TAILLE_LISTE; i++) {
                    PointRelais pr = new PointRelais(i, null, null, null, null, null, null, null);
                    liste.add(pr);
                }
                return liste;
            }
        };
        try {
            Class<?> clazz = busMap.getClass();
            Field attDaoPointRelais = clazz.getDeclaredField("dao");
            attDaoPointRelais.setAccessible(true);
            attDaoPointRelais.set(busMap, mockDaoPointRelais);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

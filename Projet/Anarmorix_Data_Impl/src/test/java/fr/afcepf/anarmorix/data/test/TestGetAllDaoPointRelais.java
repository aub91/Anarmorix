package fr.afcepf.anarmorix.data.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import fr.afcepf.anarmorix.data.api.IDaoPointRelais;
import fr.afcepf.anarmorix.entity.PointRelais;
import fr.afcepf.anarmorix.exception.AnarmorixException;
/**
 * Classe de test de la méthode getAll de {@link DaoPointRelais}.
 * @author Aubin
 *
 */
public class TestGetAllDaoPointRelais {
    /**
     * Classe contenant les services à tester.
     */
    private IDaoPointRelais daoTest = (IDaoPointRelais) CreateProxyEJB.getProxy(
            "Anarmorix_EAR-1.0/Anarmorix_Data_Impl-1.0/DaoPointRelais!fr.afcepf.anarmorix.data.api.IDaoPointRelais");
    /**
     * Taille atendue de la liste pour le test nominal.
     */
    private static final int TAILLE_LISTE = 9;
    /**
     * Test du cas nominal.
     * @throws AnarmorixException lblakfl aklfaz laz.
     */
    @Test
    public void testNominalGetAll() throws AnarmorixException  {
        List<PointRelais> retour = daoTest.getAll();
        Assert.assertNotNull(retour);
        Assert.assertEquals(TAILLE_LISTE, retour.size());
    }
}

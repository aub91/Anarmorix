package fr.afcepf.anarmorix.data.test;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import fr.afcepf.anarmorix.data.api.IDaoLigneCommande;
import fr.afcepf.anarmorix.entity.Adresse;
import fr.afcepf.anarmorix.entity.Client;
import fr.afcepf.anarmorix.entity.CodePostal;
import fr.afcepf.anarmorix.entity.Commande;
import fr.afcepf.anarmorix.entity.PointRelais;
import fr.afcepf.anarmorix.entity.Statut;
import fr.afcepf.anarmorix.entity.Ville;
import fr.afcepf.anarmorix.exception.AnarmorixException;
import fr.afcepf.anarmorix.exception.AnarmorixExceptionEnum;

/**
 * Test des méthodes du {@link DaoLigneCommande}.
 * @author Stagiaire
 *
 */
public class TestDaoLigneProduit {

    /**
     * Classe contenant les services à tester.
     */
    private IDaoLigneCommande dao = (IDaoLigneCommande) CreateProxyEJB.getProxy(
            "Anarmorix_EAR-1.0/Anarmorix_Data_Impl-1.0/DaoLigneCommande!fr.afcepf.anarmorix.data.api.IDaoLigneCommande");

    /**
     * {@link CodePostal} du client.
     */
    private static final CodePostal CODEPOSTAL = new CodePostal(1, "22500");

    /**
     *Ville du client.
     */
    private static final Ville VILLE = new Ville("22162", "Paimpol");

    /**
     * ID d'une commande inexistante.
     */
    private static final Integer ID_INEXISTANT = -1;

    /**
     * ID d'une commande existante.
     */
    private static final Integer ID_EXISTANT = 1;

    /**
     *  {@link Adresse} du {@link Client} utilisé pour les tests.
     */
    private static final Adresse ADRESSE = new Adresse(3, 15, null, "rue Becot", CODEPOSTAL,
                                            VILLE, "3.051375", "48.779062");

    /**
     *  {@link Adresse} du {@link PointRelais} utilisé pour les tests.
     */
    private static final Adresse ADRESSE_RELAIS = new Adresse(4, 1, null, "Rue Gardenn Toul Ar Verzhid", CODEPOSTAL,
                                            VILLE, "3.059167", "48.782303");

    /**
     * Point relais entré dans les commandes test.
     */
    private static final PointRelais RELAIS =
            new PointRelais(4, "422260208", "00026", "4711D", null, "Kantbuymelove SARL", ADRESSE_RELAIS, null);

    /**
     * Client entré dans les commandes test.
     */
    private static final Client CLIENT =  new Client(15, new Date(117, 9, 18) , "Scarlatti",
                                        "Gustave", new Date(117, 8, 17), ADRESSE,
                        "épanorthose@ovh.fr", "0666666666", null, "Wildcatgalileo", "aaa", null);

    /**
     * Commande pour le test du cas d'une commande inexistante.
     */
    private static final Commande COMMANDE_INEXISTANTE =
            new Commande(ID_INEXISTANT, new Date(), new Date(), null, RELAIS, CLIENT, Statut.EN_ATTENTE_DE_PREPARATION);

    /**
     * Commande pour le test du cas nominal.
     */
    private static final Commande COMMANDE =
            new Commande(ID_EXISTANT, new Date(117, 9, 7), new Date(117, 9, 8), "12345", RELAIS, CLIENT, Statut.TERMINEE);

    /**
     * Test du cas d'un argument inexistant en base.
     * @throws AnarmorixException l'exception attendue, argument inexistant.
     */
    @Test
    public void testEchecArgumentInexistant() throws AnarmorixException {
        try {
            dao.rechercher(COMMANDE_INEXISTANTE);
            Assert.fail("Test d'echec (Argument invalide), mais ça marche. Il y a un petit problème... !");
        } catch (AnarmorixException e) {
            Assert.assertEquals(AnarmorixExceptionEnum.ARGUMENT_INEXISTANT, e.getCodeErreur());
        }
    }
    
    /**
     * Test du cas nominal.
     */
    @Test
    public void testNominal() {
    }
}

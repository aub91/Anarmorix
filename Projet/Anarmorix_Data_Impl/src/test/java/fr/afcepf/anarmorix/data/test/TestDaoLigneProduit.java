package fr.afcepf.anarmorix.data.test;

import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import fr.afcepf.anarmorix.data.api.IDaoLigneCommande;
import fr.afcepf.anarmorix.entity.Adresse;
import fr.afcepf.anarmorix.entity.Categorie;
import fr.afcepf.anarmorix.entity.Client;
import fr.afcepf.anarmorix.entity.CodePostal;
import fr.afcepf.anarmorix.entity.Commande;
import fr.afcepf.anarmorix.entity.Image;
import fr.afcepf.anarmorix.entity.LigneCommande;
import fr.afcepf.anarmorix.entity.PointRelais;
import fr.afcepf.anarmorix.entity.Produit;
import fr.afcepf.anarmorix.entity.Statut;
import fr.afcepf.anarmorix.entity.TauxTVA;
import fr.afcepf.anarmorix.entity.TypeProduit;
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
    private static final Client CLIENT =  new Client(15, new Date(117, 9, 18), "Scarlatti",
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
     * Catégorie la plus générale de produits.
     */
    private static final Categorie CATEGORIE_1 = new Categorie(1, "Fruits, légumes et féculents", null);

    /**
     * Catégorie intermédiaire de produits.
     */
    private static final Categorie CATEGORIE_2 = new Categorie(1, "Fruits, légumes et féculents", CATEGORIE_1);

    /**
     * Catégorie intermédiaire de produits.
     */
    private static final Categorie CATEGORIE_3 = new Categorie(1, "Fruits, légumes et féculents", CATEGORIE_2);

    /**
     * Catégorie la plus spécifique de produits.
     */
    private static final Categorie CATEGORIE_4 = new Categorie(1, "Fruits, légumes et féculents", CATEGORIE_3);

    /**
     * {@link TauxTVA} du produit.
     */
    private static final TauxTVA TVA = new TauxTVA(1, 5.50);

    /**
     * {@link Image} du {@link Produit}.
     */
    private static final Image IMAGE = new Image(1, "test", null, null, null);

    /**
     * {@link TypeProduit} du {@link Produit}.
     */
    private static final TypeProduit TYPE = new TypeProduit(1, "Fraise gariguette", null, TVA, null, IMAGE/*, 8*/);

    /**
     * Ligne commande retournée.
     */
    private static final LigneCommande LIGNE = 
                    new LigneCommande()/*(1, 1, 1, 1, 1, new Date(117, 9, 8), new Date(117, 9, 9), new Date(117, 9, 10),
                    new Date(117, 9, 10), new Date(117, 9, 11), PRODUIT, TOURNEE)*/;

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
     * @throws AnarmorixException une exception que l'on ne doit pas avoir dans le test nominal.
     */
    @Test
    public void testNominal() throws AnarmorixException {
        List<LigneCommande> retour = dao.rechercher(COMMANDE);
        Assert.assertEquals(1, retour.size());
        Assert.assertEquals(LIGNE,  retour.toArray()[0]);
    }
}

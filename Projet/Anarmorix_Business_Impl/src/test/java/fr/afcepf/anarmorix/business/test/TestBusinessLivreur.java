package fr.afcepf.anarmorix.business.test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import fr.afcepf.anarmorix.business.api.IBusinessLivreur;
import fr.afcepf.anarmorix.business.impl.BusinessLivreur;
import fr.afcepf.anarmorix.data.api.IDaoCatalogue;
import fr.afcepf.anarmorix.data.api.IDaoCommerce;
import fr.afcepf.anarmorix.data.api.IDaoLigneCommande;
import fr.afcepf.anarmorix.data.api.IDaoProduit;
import fr.afcepf.anarmorix.data.api.IDaoTournee;
import fr.afcepf.anarmorix.data.impl.DaoCatalogue;
import fr.afcepf.anarmorix.data.impl.DaoCommerce;
import fr.afcepf.anarmorix.data.impl.DaoLigneCommande;
import fr.afcepf.anarmorix.data.impl.DaoProduit;
import fr.afcepf.anarmorix.data.impl.DaoTournee;
import fr.afcepf.anarmorix.entity.Adresse;
import fr.afcepf.anarmorix.entity.Catalogue;
import fr.afcepf.anarmorix.entity.CodePostal;
import fr.afcepf.anarmorix.entity.Exploitation;
import fr.afcepf.anarmorix.entity.LigneCommande;
import fr.afcepf.anarmorix.entity.Livreur;
import fr.afcepf.anarmorix.entity.Produit;
import fr.afcepf.anarmorix.entity.SocieteDeLivraison;
import fr.afcepf.anarmorix.entity.Tournee;
import fr.afcepf.anarmorix.entity.TypeProduit;
import fr.afcepf.anarmorix.entity.Ville;
import fr.afcepf.anarmorix.exception.AnarmorixException;

/**
 * Classe contenant les tests des méthodes de {@link IBusinessLivreur}.
 * @author Aubin
 *
 */
public class TestBusinessLivreur {
    /**
     * La classe contenant la méthode à tester.
     */
    private IBusinessLivreur busLivreur = new BusinessLivreur();
    /**
     * {@link TypeProduit} du {@link Produit}.
     */
    private static final TypeProduit TYPE = new TypeProduit(1, "Fraise gariguette", null, null, null, null, null);
    /**
     * Produit attaché à la ligne de commande.
     */
    private static final Produit PRODUIT =
            new Produit(2, TYPE, null, 25D, 50D, null, null);
    /**
     * Id pour adresseSocieteNominal.
     */
    private static final int ID_ADRESSE_SOCIETE_NOMINAL = 7;
    /**
     * Numéro voie pour adresseSocieteNominal.
     */
    private static final int NUMERO_ADRESSE_SOCIETE_NOMINAL = 7;
    /**
     * ID code postal adresse nominal.
     */
    private static final int ID_CODEPOSTAL_SOCIETE_NOMINAL = 7;
    /**
     * Adresse de société de livraison pour test nominal.
     */
    private Adresse adresseSocieteNominal = new Adresse(ID_ADRESSE_SOCIETE_NOMINAL, NUMERO_ADRESSE_SOCIETE_NOMINAL,
            null, "rue Paul Girard", new CodePostal(ID_CODEPOSTAL_SOCIETE_NOMINAL, "22200"), new Ville("22070", "Guingamp"), "-3.157254", "48.565012");
    /**
     * ID société de livraison nominal.
     */
    private static final int ID_SOCIETE_NOMINAL = 13;
    /**
     * Société de livraison pour test nominal.
     */
    private SocieteDeLivraison societeNominal =
            new SocieteDeLivraison(ID_SOCIETE_NOMINAL, "422260208", "00026", "4711D", null, "Michel SARL", adresseSocieteNominal, null);
    /**
     * ID société de livraison échec.
     */
    private static final int ID_SOCIETE_ECHEC = 99;
    /**
     * Société de livraison non existante en base de données.
     */
    private SocieteDeLivraison societeEchec =
            new SocieteDeLivraison(ID_SOCIETE_ECHEC, "422260208", "00026", "4711D", null, "Michel SARL", adresseSocieteNominal, null);
    /**
     * ID du livreur.
     */
    private static final int ID_LIVREUR = 8;
    /**
     * Livreur effectuant la tournée.
     */
    private Livreur livreur = new Livreur(ID_LIVREUR, null, "Bakounine", "Mouloud", null,
                    adresseSocieteNominal, "patrickdewaere@mailoo.org", "0666666666", null, "Onnyvoitgoethe", "aaa", null, societeNominal);

    /**
     * Tournée prenant en charge la ligne de commande.
     */
    private Tournee tourneeNominal = new Tournee(1, new Date(/*debut*/), new Date(/*fin*/), societeNominal, livreur);
    /**
     * ID de tournée non existant en base de données.
     */
    private static final int ID_TOURNEE_NON_EXISTANT = 999;
    /**
     * Tournée non existante en base.
     */
    private Tournee tourneeNonExistante = new Tournee(ID_TOURNEE_NON_EXISTANT, new Date(/*debut*/), new Date(/*fin*/), societeNominal, livreur);
    /**
     * Ligne commande retournée.
     */
    private LigneCommande ligne =
                    new LigneCommande(1, 1D, 1D, 1D, 1D, null, null, null,
                    null, null, PRODUIT, tourneeNominal);
    /**
     * Taille de la liste de catalogues attendu en retour de la méthode rechercherByProduit.
     */
    private static final int TAILLE_LISTE_CATALOGUE = 1;
    /**
     * Taille de la collection d'exploitation attendu en retour de la méthode setExploitationAVisiter.
     */
    private static final int TAILLE_SET_EXPLOITATION = 1;
    /**
     * Exploitation attendue du test nominal de rechercherExploitationByCatalogue.
     */
    private Exploitation exploitationNominal = new Exploitation(1, "422260208", "00026", "4711D", null, "Dyomedea SARL", null, null);

    /**
     * Test nominal de la méthode setTournees.
     * @throws AnarmorixException exception non attendue
     */
    @Test
    public void testNominalSetTournees() throws AnarmorixException {
        SocieteDeLivraison retour = busLivreur.setTournees(societeNominal);
        Assert.assertNotNull(retour);
        Assert.assertEquals(1, retour.getTournees().size());
        Assert.assertEquals(tourneeNominal.getClass(), retour.getTournees().get(0).getClass());
        Assert.assertEquals(tourneeNominal.getId(), retour.getTournees().get(0).getId());
        Assert.assertEquals(societeNominal.getClass(), retour.getClass());
        Assert.assertEquals(societeNominal.getId(), retour.getId());
        Assert.assertEquals(societeNominal.getCodeApe(), retour.getCodeApe());
        Assert.assertEquals(societeNominal.getNumNic(), retour.getNumNic());
        Assert.assertEquals(societeNominal.getNumSiren(), retour.getNumSiren());
        Assert.assertEquals(societeNominal.getRaisonSociale(), retour.getRaisonSociale());
        Assert.assertEquals(societeNominal.getAdresse().getId(), retour.getAdresse().getId());
        Assert.assertEquals(societeNominal.getAdresse().getComplementNumero(), retour.getAdresse().getComplementNumero());
        Assert.assertEquals(societeNominal.getAdresse().getLatitude(), retour.getAdresse().getLatitude());
        Assert.assertEquals(societeNominal.getAdresse().getLongitude(), retour.getAdresse().getLongitude());
        Assert.assertEquals(societeNominal.getAdresse().getNumero(), retour.getAdresse().getNumero());
        Assert.assertEquals(societeNominal.getAdresse().getVoie(), retour.getAdresse().getVoie());
        Assert.assertEquals(societeNominal.getAdresse().getVille().getCodeInsee(), retour.getAdresse().getVille().getCodeInsee());
        Assert.assertEquals(societeNominal.getAdresse().getVille().getNomVille(), retour.getAdresse().getVille().getNomVille());
        Assert.assertEquals(societeNominal.getAdresse().getCodePostal().getId(), retour.getAdresse().getCodePostal().getId());
        Assert.assertEquals(societeNominal.getAdresse().getCodePostal().getCodePostal(), retour.getAdresse().getCodePostal().getCodePostal());
    }
    /**
     * Test échec méthode setTournees.
     * @throws AnarmorixException une exception
     */
    @Test
    public void testEchecSetTournees() throws AnarmorixException {
        SocieteDeLivraison retour = busLivreur.setTournees(societeEchec);
        Assert.assertEquals(0, retour.getTournees().size());
    }
    /**
     * Test nominal pour la méthode setLignesCommande.
     * @throws AnarmorixException exception non attendue
     */
    @Test
    public void testNominalSetLignesCommandes() throws AnarmorixException {
        tourneeNominal.setLignesCmd(new ArrayList<>());
        Tournee retour = busLivreur.setLignesCommandes(tourneeNominal);
        Assert.assertNotNull(retour);
        Assert.assertEquals(tourneeNominal.getId(), retour.getId());
        Assert.assertEquals(1, retour.getLignesCmd().size());
        Assert.assertEquals(ligne.getId(), retour.getLignesCmd().get(0).getId());
        Assert.assertEquals(ligne.getQuantiteCommandee(), retour.getLignesCmd().get(0).getQuantiteCommandee());
        Assert.assertEquals(ligne.getQuantiteDelivree(), retour.getLignesCmd().get(0).getQuantiteDelivree());
        Assert.assertEquals(ligne.getQuantiteLivree(), retour.getLignesCmd().get(0).getQuantiteLivree());
        Assert.assertEquals(ligne.getQuantitePreparee(), retour.getLignesCmd().get(0).getQuantitePreparee());
        Assert.assertNotNull(retour.getLignesCmd().get(0).getProduit());
        Assert.assertEquals(PRODUIT.getId(), retour.getLignesCmd().get(0).getProduit().getId());
        Assert.assertEquals(PRODUIT.getPrixUnitaire(), retour.getLignesCmd().get(0).getProduit().getPrixUnitaire());
        Assert.assertEquals(PRODUIT.getQuantiteEnStock(), retour.getLignesCmd().get(0).getProduit().getQuantiteEnStock());
        Assert.assertNotNull(retour.getLignesCmd().get(0).getProduit().getType());
        Assert.assertEquals(TYPE.getId(), retour.getLignesCmd().get(0).getProduit().getType().getId());
        Assert.assertEquals(TYPE.getLibelle(), retour.getLignesCmd().get(0).getProduit().getType().getLibelle());
        Assert.assertEquals(TAILLE_LISTE_CATALOGUE, retour.getLignesCmd().get(0).getProduit().getCatalogues().size());
    }
    /**
     * Test échec pour méthode setLignesCommandes.
     * @throws AnarmorixException une exception
     */
    @Test
    public void testEchecSetLignesCommandes() throws AnarmorixException {
            tourneeNonExistante.setLignesCmd(new ArrayList<>());
            Tournee retour = busLivreur.setLignesCommandes(tourneeNonExistante);
            Assert.assertEquals(0, retour.getLignesCmd().size());
    }
    /**
     * Test nominal pour méthode setExploitationAVisiter.
     * @throws AnarmorixException exception non attendue
     */
    @Test
    public void testNominalSetExploitationAVisiter() throws AnarmorixException {
        Tournee tourneeTemp = tourneeNominal;
        tourneeTemp.setLignesCmd(new ArrayList<>());
        tourneeTemp = busLivreur.setLignesCommandes(tourneeTemp);
        List<Exploitation> retour = busLivreur.setExploitationAVisiter(tourneeTemp);
        Assert.assertNotNull(retour);
        Assert.assertEquals(TAILLE_SET_EXPLOITATION, retour.size());
        Assert.assertNotNull(retour.iterator().next());
        Assert.assertEquals(exploitationNominal.getId(), retour.iterator().next().getId());
        Assert.assertEquals(exploitationNominal.getCodeApe(), retour.iterator().next().getCodeApe());
        Assert.assertEquals(exploitationNominal.getIban(), retour.iterator().next().getIban());
        Assert.assertEquals(exploitationNominal.getNumNic(), retour.iterator().next().getNumNic());
        Assert.assertEquals(exploitationNominal.getNumSiren(), retour.iterator().next().getNumSiren());
        Assert.assertEquals(exploitationNominal.getRaisonSociale(), retour.iterator().next().getRaisonSociale());
    }
    /**
     * Test échec de la méthode setExploitationAVisiter.
     * @throws AnarmorixException une exception
     */
    @Test
    public void testEchecSetExploitationAVisiter() throws AnarmorixException {
        Tournee tourneeTemp = tourneeNonExistante;
        tourneeTemp.setLignesCmd(new ArrayList<>());
        List<Exploitation> retour = busLivreur.setExploitationAVisiter(tourneeNonExistante);
        Assert.assertEquals(0, retour.size());
    }
    /**
     * Default constructor avec injection mock.
     */
    public TestBusinessLivreur() {
        IDaoTournee mockDaoTournee = new DaoTournee() {
            @Override
            public SocieteDeLivraison rechercherBySocieteDeLivraison(SocieteDeLivraison paramSocieteDeLivraison)
                    throws AnarmorixException {
                List<Tournee> liste = new ArrayList<>();
                if (paramSocieteDeLivraison.getId() == ID_SOCIETE_NOMINAL) {
                    liste.add(tourneeNominal);
                }
                paramSocieteDeLivraison.setTournees(liste);
                return paramSocieteDeLivraison;
            }
        };
        IDaoLigneCommande mockDaoLigneCommande = new DaoLigneCommande() {
            @Override
            public Tournee rechercherByTournee(Tournee paramTournee) throws AnarmorixException {
                if (paramTournee.getId() == 1) {
                    paramTournee.getLignesCmd().add(ligne);
                }
                return paramTournee;
            }
        };
        IDaoProduit mockDaoProduit = new DaoProduit() {
            @Override
            public LigneCommande rechercherByLigneCommande(LigneCommande paramLigneCommande) throws AnarmorixException {
                if (paramLigneCommande.getId() == 1) {
                    paramLigneCommande.setProduit(PRODUIT);
                }
                return paramLigneCommande;
            }
        };
        IDaoCatalogue mockDaoCatalogue = new DaoCatalogue() {
            @Override
            public Produit rechercherByProduit(Produit paramProduit) throws AnarmorixException {
                List<Catalogue> liste = new ArrayList<>();
                if (paramProduit.getId() == PRODUIT.getId()) {
                    Catalogue catag = new Catalogue();
                    catag.setId(1);
                    liste.add(catag);
                }
                paramProduit.setCatalogues(liste);
                return paramProduit;
            }
        };
        IDaoCommerce mockDaoCommerce = new DaoCommerce() {
            @Override
            public Catalogue rechercherExploitationByCatalogue(Catalogue paramCatalogue) throws AnarmorixException {
                if (paramCatalogue.getId() == 1) {
                    paramCatalogue.setExploitation(exploitationNominal);
                }
                return paramCatalogue;
            }
        };
        try {
            Class<?> clazz = busLivreur.getClass();
            Field attDaoTournee = clazz.getDeclaredField("daoTournee");
            attDaoTournee.setAccessible(true);
            attDaoTournee.set(busLivreur, mockDaoTournee);

            Field attDaoLigneCommande = clazz.getDeclaredField("daoLigneCommande");
            attDaoLigneCommande.setAccessible(true);
            attDaoLigneCommande.set(busLivreur, mockDaoLigneCommande);

            Field attDaoProduit = clazz.getDeclaredField("daoProduit");
            attDaoProduit.setAccessible(true);
            attDaoProduit.set(busLivreur, mockDaoProduit);

            Field attDaoCatalogue = clazz.getDeclaredField("daoCatalogue");
            attDaoCatalogue.setAccessible(true);
            attDaoCatalogue.set(busLivreur, mockDaoCatalogue);

            Field attDaoCommerce = clazz.getDeclaredField("daoCommerce");
            attDaoCommerce.setAccessible(true);
            attDaoCommerce.set(busLivreur, mockDaoCommerce);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

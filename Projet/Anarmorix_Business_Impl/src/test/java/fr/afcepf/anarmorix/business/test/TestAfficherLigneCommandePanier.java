package fr.afcepf.anarmorix.business.test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import fr.afcepf.anarmorix.business.api.IBusinessPanier;
import fr.afcepf.anarmorix.business.impl.BusinessPanier;
import fr.afcepf.anarmorix.data.api.IDaoLigneCommande;
import fr.afcepf.anarmorix.data.impl.DaoLigneCommande;
import fr.afcepf.anarmorix.data.test.CreateProxyEJB;
import fr.afcepf.anarmorix.entity.Adresse;
import fr.afcepf.anarmorix.entity.Client;
import fr.afcepf.anarmorix.entity.CodePostal;
import fr.afcepf.anarmorix.entity.Commande;
import fr.afcepf.anarmorix.entity.LigneCommande;
import fr.afcepf.anarmorix.entity.PointRelais;
import fr.afcepf.anarmorix.entity.Statut;
import fr.afcepf.anarmorix.entity.Ville;
import fr.afcepf.anarmorix.exception.AnarmorixException;

public class TestAfficherLigneCommandePanier {
	private IDaoLigneCommande dao = (IDaoLigneCommande) CreateProxyEJB.getProxy(
            "Anarmorix_EAR-1.0/Anarmorix_Data_Impl-1.0/DaoLigneCommande!fr.afcepf.anarmorix.data.api.IDaoLigneCommande");

	/**
	 * La classe contenant la méthode à tester.
	 */
	private IBusinessPanier busPanier = new BusinessPanier();
	/**
	 * La taille de liste de ligne de commande attendue.
	 */
	private static final int TAILLE_LISTE = 2;
	/**
	 * Test Nominal.
	 * @throws AnarmorixException non attendue.
	 */
	

    private static final CodePostal CODEPOSTAL = new CodePostal(1, "22500");

    /**
     *Ville du client.
     */
    private static final Ville VILLE = new Ville("22162", "Paimpol");

    /**
     * ID d'une commande inexistante.
     */
    private static final Integer ID_INEXISTANT = 2227272;

    /**
     * ID d'une commande existante.
     */
    private static final Integer ID_EXISTANT = 1;

    /**
     *  {@link Adresse} du {@link Client} utilisé pour les tests.
     */
    private static final Adresse ADRESSE = new Adresse(3, 15, null, "rue Becot", CODEPOSTAL,
                                            VILLE, "-3.051375", "48.779062");

    /**
     *  {@link Adresse} du {@link PointRelais} utilisé pour les tests.
     */
    private static final Adresse ADRESSE_RELAIS = new Adresse(4, 1, null, "Rue Gardenn Toul Ar Verzhid", CODEPOSTAL,
                                            VILLE, "-3.059167", "48.782303");

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

	//private Commande com = new Commande();
	@Test
	public void testAfficherLigneCommandePanier() throws AnarmorixException{
		//com.setId(1);
		List<LigneCommande> mesLignes = busPanier.rechercher(COMMANDE);
		System.out.println("tesst");
		Assert.assertNotNull(mesLignes);
		Assert.assertEquals(TAILLE_LISTE, mesLignes.size());	
	}
	/* --> Default Constructor <-- */
	public TestAfficherLigneCommandePanier() {
		IDaoLigneCommande mockLigneCommande = new DaoLigneCommande() {
			@Override
			public List<LigneCommande> rechercher(Commande commande) throws AnarmorixException {
				List<LigneCommande> liste = new ArrayList<>();
				for (int i = 0; i < TAILLE_LISTE;i++) {
					LigneCommande lc = new LigneCommande(i, null, null, null, null, null, null, null, null, null, null, null);
					liste.add(lc);
				}
				return liste;
			};
		};
		try {
			Class<?> clazz = busPanier.getClass();
			Field attDaoLigneCommande = clazz.getDeclaredField("dao");
			attDaoLigneCommande.setAccessible(true);
			attDaoLigneCommande.set(busPanier, mockLigneCommande);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}


}

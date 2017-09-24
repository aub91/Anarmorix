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
	/*private IDaoLigneCommande dao = (IDaoLigneCommande) CreateProxyEJB.getProxy(
            "Anarmorix_EAR-1.0/Anarmorix_Data_Impl-1.0/DaoLigneCommande!fr.afcepf.anarmorix.data.api.IDaoLigneCommande");
	 */
	/**
	 * La classe contenant la méthode à tester.
	 */
	private IBusinessPanier busPanier = new BusinessPanier();
	/**
	 * La taille de liste de ligne de commande attendue.
	 */
	private static final int TAILLE_LIST = 12;
	/**
	 * Test Nominal.
	 * @throws AnarmorixException non attendue.
	 */


	private Commande com = new Commande();

	@Test
	public void testAfficherLigneCommandePanier() throws AnarmorixException{
		com.setId(1);

		List<LigneCommande> ligneCommandes = busPanier.rechercher(com);

		System.out.println(" test = " + ligneCommandes.listIterator());
		Assert.assertNotNull(ligneCommandes);
		Assert.assertEquals(TAILLE_LIST, ligneCommandes.size());	
	}
	/* --> Default Constructor <--*/
	public TestAfficherLigneCommandePanier() {
		IDaoLigneCommande mockLigneCommande = new DaoLigneCommande() {
			@Override
			public List<LigneCommande> rechercher(Commande commande) throws AnarmorixException {
				List<LigneCommande> liste = new ArrayList<>();
				for (int i = 0; i < TAILLE_LIST;i++) {
					LigneCommande lc = new LigneCommande(i, null, null, null, null, null, null, null, null, null, null, null);
					liste.add(lc);
				}
				return liste;
			};
		};
		try {
			Class<?> clazz = busPanier.getClass();
			Field attDaoLigneCommande = clazz.getDeclaredField("daoLigneCommande");
			attDaoLigneCommande.setAccessible(true);
			attDaoLigneCommande.set(busPanier, mockLigneCommande);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}


}

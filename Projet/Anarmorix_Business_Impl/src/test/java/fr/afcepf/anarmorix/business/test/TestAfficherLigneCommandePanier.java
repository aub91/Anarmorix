package fr.afcepf.anarmorix.business.test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import fr.afcepf.anarmorix.business.api.IBusinessPanier;
import fr.afcepf.anarmorix.business.impl.BusinessPanier;
import fr.afcepf.anarmorix.data.api.IDaoLigneCommande;
import fr.afcepf.anarmorix.data.impl.DaoLigneCommande;
import fr.afcepf.anarmorix.entity.Commande;
import fr.afcepf.anarmorix.entity.LigneCommande;
import fr.afcepf.anarmorix.exception.AnarmorixException;

public class TestAfficherLigneCommandePanier {
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
	private Commande com = new Commande();
	@Test
	public void testNominalLigneCom() throws AnarmorixException{
		com.setId(1);
		List<LigneCommande> mesLignes = busPanier.rechercher(com);
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

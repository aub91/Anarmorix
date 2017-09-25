package fr.afcepf.anarmorix.controller;

import java.util.ArrayList;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;

import javax.faces.bean.ManagedBean;

import javax.faces.bean.ViewScoped;

import fr.afcepf.anarmorix.business.api.IBusinessConsommateur;

import fr.afcepf.anarmorix.entity.Client;
import fr.afcepf.anarmorix.entity.Commande;

import fr.afcepf.anarmorix.entity.LigneCommande;




@ManagedBean(name="mbProduit")
@ViewScoped

public class ProduitManagedBean {
	private List<LigneCommande> liste = new ArrayList<>();
	//private Client client= new Client();
	//private List<ProduitVue> produitVue = new ArrayList<>();
	private Commande cmde = new Commande();

	

	@EJB
	private IBusinessConsommateur bu;
	
	
	
	
	

	@PostConstruct
	public void ajouterProduits() {
		
		//Image img = new Image(1,"resources/img/carotte.jpg",null,null,null);
		//Image img2 = new Image(1,"resources/img/chou_fleur.jpg",null,null,null);
		//Image img3 = new Image(1,"resources/img/betterave.jpg",null,null,null);
		
		//TypeProduit type = new TypeProduit(1,"fruit",null,null,null,img);
		//Produit P1= new Produit(1,type,new Date(01/01/2015),15.5,25.32,img,null);
		
		//Produit P2= new Produit(2,type,new Date(01/01/2015),15.5,25.32,img2,null);
		//Produit P3= new Produit(3,type,new Date(01/01/2015),15.5,25.32,img3,null);
		//liste.add(P1);
		//liste.add(P2);
		//liste.add(P3);
		try {
		
		cmde.setId(1);
		
	
		liste=bu.afficherLigneCommande(cmde);
		
		System.out.println(liste.size());

		} catch (Exception e) {
			
			e.printStackTrace();
		}
	
	}
//	public void affciher() throws AnarmorixException {
	//	lgcmd=bu.afficherLigneCommande(cmde);
	//}






	public Commande getCmde() {
		return cmde;
	}


	public void setCmde(Commande cmde) {
		this.cmde = cmde;
	}


	public IBusinessConsommateur getBu() {
		return bu;
	}


	public void setBu(IBusinessConsommateur bu) {
		this.bu = bu;
	}





	public List<LigneCommande> getListe() {
		return liste;
	}





	public void setListe(List<LigneCommande> liste) {
		this.liste = liste;
	}








}

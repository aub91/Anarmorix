package fr.afcepf.anarmorix.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import fr.afcepf.anarmorix.entity.Image;
import fr.afcepf.anarmorix.entity.Produit;
import fr.afcepf.anarmorix.entity.TypeProduit;

@ViewScoped
@ManagedBean(name="mbProduit")
public class ProduitManagedBean {
	private List<Produit> liste = new ArrayList<>();
	private List<ProduitVue> produitVue = new ArrayList<>();

	

	

	@PostConstruct
	public void ajouterProduits() {
		
		Image img = new Image(1,"resources/img/carotte.jpg",null,null,null);
		Image img2 = new Image(1,"resources/img/chou_fleur.jpg",null,null,null);
		Image img3 = new Image(1,"resources/img/betterave.jpg",null,null,null);
		
		TypeProduit type = new TypeProduit(1,"fruit",null,null,null,img);
		Produit P1= new Produit(1,type,new Date(01/01/2015),15.5,25.32,img,null);
		
		Produit P2= new Produit(2,type,new Date(01/01/2015),15.5,25.32,img2,null);
		Produit P3= new Produit(3,type,new Date(01/01/2015),15.5,25.32,img3,null);
		liste.add(P1);
		liste.add(P2);
		liste.add(P3);
		for(Produit produit:liste) {
			produitVue.add(new ProduitVue(produit));	
		}
	}


	public List<Produit> getListe() {
		return liste;
	}


	public void setListe(List<Produit> liste) {
		this.liste = liste;
	}


	public List<ProduitVue> getProduitVue() {
		return produitVue;
	}


	public void setProduitVue(List<ProduitVue> produitVue) {
		this.produitVue = produitVue;
	}






}

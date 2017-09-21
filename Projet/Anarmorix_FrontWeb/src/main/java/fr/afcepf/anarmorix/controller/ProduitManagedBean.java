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

	TypeProduit type = new TypeProduit();

	

	@PostConstruct
	public void ajouterProduits() {
		
		Image img = new Image(1,"carotte.jpg",null,null,null);
		Produit P1= new Produit(1,type,new Date(01/01/2015),15.5,25.32,img,null);
		
		Produit P2= new Produit(2,type,new Date(01/01/2015),15.5,25.32,img,null);
		Produit P3= new Produit(3,type,new Date(01/01/2015),15.5,25.32,img,null);
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


	public TypeProduit getType() {
		return type;
	}


	public void setType(TypeProduit type) {
		this.type = type;
	}




}

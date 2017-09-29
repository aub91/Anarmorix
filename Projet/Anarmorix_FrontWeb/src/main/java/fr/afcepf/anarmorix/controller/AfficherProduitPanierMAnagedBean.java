package fr.afcepf.anarmorix.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import fr.afcepf.anarmorix.business.api.IBusinessPanier;
import fr.afcepf.anarmorix.entity.Commande;
import fr.afcepf.anarmorix.entity.LigneCommande;
import fr.afcepf.anarmorix.entity.Produit;
import fr.afcepf.anarmorix.entity.Statut;
import fr.afcepf.anarmorix.exception.AnarmorixException;

@ManagedBean(name = "mbLigneProduitPanier")
@ViewScoped
public class AfficherProduitPanierMAnagedBean {
    @EJB
    private IBusinessPanier busPanier;
    Produit produits = new Produit();
    List<Produit> listeProduits = new ArrayList<Produit>();
    Commande com = new Commande();
    public Commande getCom() {
		return com;
	}
    public void setCom(Commande com) {
		this.com = com;
	}
    

	public AfficherProduitPanierMAnagedBean() {
	}
	
    public Produit getProduits() {
		return produits;
	}

	public void setProduits(Produit produits) {
		this.produits = produits;
	}


	public List<Produit> getListeProduits() {
		return listeProduits;
	}

	public void setListeProduits(List<Produit> listeProduits) {
		this.listeProduits = listeProduits;
	}

	@PostConstruct
    public void init() {
    	
    	Produit produit1 = new Produit();
    	produit1.setId(251); 
    	produit1.setPrixUnitaire(1.06);
    	produit1.setQuantiteEnStock(2.01);
    	listeProduits.add(produit1);
    	Produit produit2 = new Produit();
    	produit2.setId(252);
    	produit2.setPrixUnitaire(2.0);
    	produit2.setQuantiteEnStock(25.0);
    	listeProduits.add(produit2);
    	Produit produit3 = new Produit();
    	produit3.setId(20);
    	produit3.setPrixUnitaire(2.0);
    	produit3.setQuantiteEnStock(2.0);
    	listeProduits.add(produit3);  	
    }

	public IBusinessPanier getBusPanier() {
		return busPanier;
	}

	public void setBusPanier(IBusinessPanier busPanier) {
		this.busPanier = busPanier;
	}
	
}

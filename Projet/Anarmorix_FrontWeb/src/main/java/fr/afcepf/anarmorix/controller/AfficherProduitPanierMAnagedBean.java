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
import fr.afcepf.anarmorix.exception.AnarmorixException;

@ManagedBean(name ="mbLigneProduitPanier")
@ViewScoped
public class AfficherProduitPanierMAnagedBean {
	@EJB
	private IBusinessPanier busPanier;
	Produit produits = new Produit();
	List<Produit> listeProduits = new ArrayList<Produit>();
	
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
    public void init() throws AnarmorixException {
    	
    	Produit produit1 = new Produit();
    	produit1.setId(251); 
    	produit1.setPrixUnitaire(110.71);
    	produit1.setQuantiteEnStock(210.11);
    	listeProduits.add(produit1);
    	
    }

	public IBusinessPanier getBusPanier() {
		return busPanier;
	}

	public void setBusPanier(IBusinessPanier busPanier) {
		this.busPanier = busPanier;
	}
	
}

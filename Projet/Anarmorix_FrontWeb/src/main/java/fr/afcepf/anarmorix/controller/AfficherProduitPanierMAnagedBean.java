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
	Commande commande = new Commande();
	List<LigneCommande> ligneproduits = new ArrayList<LigneCommande>();
	public AfficherProduitPanierMAnagedBean() {
	}
    @PostConstruct
    public void init() throws AnarmorixException {
        ligneproduits = busPanier.rechercher(commande);
    }
    
    
    
    public List<LigneCommande> getProduits() {
        return ligneproduits;
    }

    public void setProduits(List<LigneCommande> paramLigneProduits) {
    	ligneproduits = paramLigneProduits;
    }
	

}

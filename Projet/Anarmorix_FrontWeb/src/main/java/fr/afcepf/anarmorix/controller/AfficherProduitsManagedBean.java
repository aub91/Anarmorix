package fr.afcepf.anarmorix.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import fr.afcepf.anarmorix.business.api.IBusinessClient;
import fr.afcepf.anarmorix.entity.Image;
import fr.afcepf.anarmorix.entity.Produit;
import fr.afcepf.anarmorix.exception.AnarmorixException;

@ManagedBean(name = "mbAfficheProduits")
@ViewScoped
public class AfficherProduitsManagedBean {
    
    @EJB
    private IBusinessClient businessCLient;
    List<Produit> produits =  new ArrayList<>();
    
    public AfficherProduitsManagedBean() {
    }
    
    @PostConstruct
    public void init() throws AnarmorixException {
      //  produits = businessCLient.choisirCategorieProduit();
    }
    
    
    
    public List<Produit> getProduits() {
        return produits;
    }

    public void setProduits(List<Produit> paramProduits) {
        produits = paramProduits;
    }

}

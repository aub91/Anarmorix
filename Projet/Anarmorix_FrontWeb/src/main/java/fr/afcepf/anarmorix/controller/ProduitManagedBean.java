package fr.afcepf.anarmorix.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.ejb.Stateless;

import fr.afcepf.anarmorix.entity.Produit;
import fr.afcepf.anarmorix.entity.TypeProduit;

@Stateless
@ManagedBean("mbProduit")
public class ProduitManagedBean {
	private List<Produit> liste;
	   private List<ProduitVue> produitVue;
	   
	   TypeProduit type = new TypeProduit();
		
		Produit P1= new Produit(1,type,new Date(01/01/2015),15.5,25.32,null,null);
		Produit P2= new Produit(2,type,new Date(01/01/2015),15.5,25.32,null,null);
		Produit P3= new Produit(3,type,new Date(01/01/2015),15.5,25.32,null,null);
	
	public void afficheProduits() {	
		  for(Produit produit:liste) {
			  produitVue.add(new ProduitVue(produit));
	        }
	        
		
	}

}

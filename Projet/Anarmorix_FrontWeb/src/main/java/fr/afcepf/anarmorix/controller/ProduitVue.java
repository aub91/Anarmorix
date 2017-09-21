package fr.afcepf.anarmorix.controller;

import fr.afcepf.anarmorix.entity.Produit;

public class ProduitVue {
	private Produit prodt ;
	

	public ProduitVue() {
		super();
	}

	public ProduitVue(Produit prodt) {
		
		this.prodt = prodt;
	}

	public Produit getProdt() {
		return prodt;
	}

	public void setProdt(Produit prodt) {
		this.prodt = prodt;
	}
	

}

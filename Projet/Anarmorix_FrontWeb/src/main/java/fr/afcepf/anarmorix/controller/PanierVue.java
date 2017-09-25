package fr.afcepf.anarmorix.controller;

import fr.afcepf.anarmorix.entity.Produit;

public class PanierVue {

	private Produit prodt ;

	

	public PanierVue() {
		super();
	}

	public PanierVue(Produit prodt) {
		
		this.prodt = prodt;
	}

	public Produit getProdt() {
		return prodt;
	}

	public void setProdt(Produit prodt) {
		this.prodt = prodt;
	}


	
	

}
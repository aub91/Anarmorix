package fr.afcepf.anarmorix.controller;

import fr.afcepf.anarmorix.entity.LigneCommande;

public class PanierVue {

	private LigneCommande lgnCom ;

	

	public PanierVue() {
		super();
	}

	public PanierVue(LigneCommande lgnCom) {
		
		this.lgnCom = lgnCom;
	}

	public LigneCommande getlgnCom() {
		return lgnCom;
	}

	public void setLgnCom(LigneCommande lgnCom) {
		this.lgnCom = lgnCom;
	}


	
	

}
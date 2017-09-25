package fr.afcepf.anarmorix.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import fr.afcepf.anarmorix.business.api.IBusinessPointRelais;
import fr.afcepf.anarmorix.entity.Client;
import fr.afcepf.anarmorix.entity.Commande;



@ViewScoped
@ManagedBean(name="mbPR")
public class ManagedBeanPointRelais {
	

	private IBusinessPointRelais bu;
	
	private Client  client = new Client();
	private List<Commande> liste = new ArrayList<>() ;
	private Commande cmd = new Commande();
	
public void ajouterCommandes() {
		
		
		try {
		cmd.setId(1);
		liste=bu.afficherCommande(client);
		
			System.out.println(liste.size());
		} catch (Exception e) {
			
			e.printStackTrace();
		}
}

public List<Commande> getListe() {
	return liste;
}

public void setListe(List<Commande> liste) {
	this.liste = liste;
}

public IBusinessPointRelais getBu() {
	return bu;
}

public void setBu(IBusinessPointRelais bu) {
	this.bu = bu;
}






}
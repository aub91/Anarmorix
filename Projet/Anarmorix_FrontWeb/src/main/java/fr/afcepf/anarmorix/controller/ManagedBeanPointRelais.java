package fr.afcepf.anarmorix.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import fr.afcepf.anarmorix.business.api.IBusinessPointRelais;
import fr.afcepf.anarmorix.entity.Client;
import fr.afcepf.anarmorix.entity.Commande;

@ViewScoped
@ManagedBean(name = "mbPR")
public class ManagedBeanPointRelais {
	
	
	private int compteur=0;
	@EJB
	private IBusinessPointRelais bu;
	
	private Client client = new Client();
	private List<Commande> liste = new ArrayList<>();
	

	@PostConstruct
	public void ajouterCommandes() {
		
		try {
			client.setId(1);
			liste = bu.afficherCommande(client);
			for(Commande commande:liste) {
				
				compteur=compteur+1;
			}
			
		} catch (Exception e) {

			e.printStackTrace();
		}
		
	}
	
	

	

	public int getCompteur() {
		return compteur;
	}





	public void setCompteur(int compteur) {
		this.compteur = compteur;
	}





	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
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
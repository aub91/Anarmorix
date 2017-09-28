package fr.afcepf.anarmorix.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;



import fr.afcepf.anarmorix.business.api.IBusinessConsommateur;


import fr.afcepf.anarmorix.entity.Commande;

import fr.afcepf.anarmorix.entity.LigneCommande;
import fr.afcepf.anarmorix.entity.Statut;
import fr.afcepf.anarmorix.exception.AnarmorixException;




@ManagedBean(name="mbProduit")
@SessionScoped

public class ProduitManagedBean {
	
	private List<LigneCommande> liste = new ArrayList<>();
	//private Client client= new Client();
	//private List<ProduitVue> produitVue = new ArrayList<>();
	private Commande cmde = new Commande();
	
	private LigneCommande ligne= new LigneCommande();
	private String statue;

	@EJB
	private IBusinessConsommateur bu;
	
	// methode de mise a jours de la commande
	public void miseajourCommande(Integer id) {
		try {
			for (LigneCommande ligneCommande : liste) {
					if(ligneCommande.getCommande().getId()==id) {
					ligneCommande.getCommande().setStatut(cmde.getStatut());
					bu.mettreAJourCommande(ligneCommande.getCommande());
				}
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// methode de mise a jour de la ligne de commande
	public void miseAjour(Integer id) {
		try {
			for (LigneCommande ligneCommande : liste) {
				if(ligneCommande.getId() == id) {
					System.out.println(ligneCommande.getQuantiteCommandee());
					bu.mettreAJourLC(ligneCommande);
									
				}
				
			}
			/*for(Commande commande:listeCommande) {
				if(commande.getId()==id) {
					System.out.println(commande.getStatut());
					bu.mettreAJourCommande(commande);
				}
				
			}
		*/
					
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@PostConstruct
	public void ajouterProduits() {
		
		//Image img = new Image(1,"resources/img/carotte.jpg",null,null,null);
		//Image img2 = new Image(1,"resources/img/chou_fleur.jpg",null,null,null);
		//Image img3 = new Image(1,"resources/img/betterave.jpg",null,null,null);
		
		//TypeProduit type = new TypeProduit(1,"fruit",null,null,null,img);
		//Produit P1= new Produit(1,type,new Date(01/01/2015),15.5,25.32,img,null);
		
		//Produit P2= new Produit(2,type,new Date(01/01/2015),15.5,25.32,img2,null);
		//Produit P3= new Produit(3,type,new Date(01/01/2015),15.5,25.32,img3,null);
		//liste.add(P1);
		//liste.add(P2);
		//liste.add(P3);
		try {
		
		cmde.setId(1);
		cmde.setClient(bu.afficherClient(cmde));

		liste=bu.afficherLigneCommande(cmde);
		
		
		
		
	
		

		} catch (Exception e) {
			
			e.printStackTrace();
		}
	
	}
	


	 
	 
	public Commande getCmde() {
		return cmde;
	}


	public void setCmde(Commande cmde) {
		this.cmde = cmde;
	}


	public IBusinessConsommateur getBu() {
		return bu;
	}


	public void setBu(IBusinessConsommateur bu) {
		this.bu = bu;
	}





	public List<LigneCommande> getListe() {
		return liste;
	}





	public void setListe(List<LigneCommande> liste) {
		this.liste = liste;
	}

	public LigneCommande getLigne() {
		return ligne;
	}

	public void setLigne(LigneCommande ligne) {
		this.ligne = ligne;
	}

	public String getStatue() {
		return statue;
	}

	public void setStatue(String statue) {
		//System.out.println(statue);
		switch (statue) {
		case "1":
			cmde.setStatut(Statut.CREEE);
			break;
		case "2":
			cmde.setStatut(Statut.EN_COURS_DE_PREPARATION);
			break;
			
		case "3":
			cmde.setStatut(Statut.EN_COURS_DE_LIVRAISON);
			break;
		case "4":
			cmde.setStatut(Statut.EN_ATTENTE_DE_RETRAIT);
			break;
		case "5":
			cmde.setStatut(Statut.TERMINEE);
			break;
		
			

		default:
			break;
		}
		this.statue = statue;
	}

	








}

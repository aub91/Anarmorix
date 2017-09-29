package fr.afcepf.anarmorix.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import fr.afcepf.anarmorix.business.api.IBusinessConsommateur;
import fr.afcepf.anarmorix.business.api.IBusinessProducteur;
import fr.afcepf.anarmorix.entity.Commande;
import fr.afcepf.anarmorix.entity.Exploitation;
import fr.afcepf.anarmorix.entity.LigneCommande;
import fr.afcepf.anarmorix.entity.Producteur;
import fr.afcepf.anarmorix.entity.Statut;
import fr.afcepf.anarmorix.exception.AnarmorixException;



/**
 * Managed Bean pour la préparation de commande.
 * @author Aubin
 *
 */
@ManagedBean(name = "mbProduit")
@ViewScoped
public class ProduitManagedBean {
    /**
     * Liste des commandes de l'exploitation.
     */
    private List<Commande> listeCommande = new ArrayList<>();
    /**
     * {@link ConnexionCommandeManagedBean}.
     */
    @ManagedProperty (value = "#{mbConnexion}")
    private ConnexionCommandeManagedBean cnxMb;
    /**
     * {@link Exploitation}.
     */
    private Producteur selectedProducteur;

	private LigneCommande ligne= new LigneCommande();
	private String statut;
	/**
	 * {@link IBusinessConsommateur}.
	 */
	@EJB
	private IBusinessConsommateur bu;
	/**
     * {@link IBusinessProducteur}.
     */
    @EJB
    private IBusinessProducteur busProd;

	// methode de mise a jours de la commande
	public void miseajourCommande(Commande paramCommande) {
		try {
		    changerStatut(statut, paramCommande);
		    bu.mettreAJourCommande(paramCommande);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	// methode de mise a jour de la ligne de commande
//	public void miseAjour(Integer id) {
//		try {
//			for (LigneCommande ligneCommande : liste) {
//				if (ligneCommande.getId() == id) {
//					System.out.println(ligneCommande.getQuantiteCommandee());
//					bu.mettreAJourLC(ligneCommande);
//				}
//			}
//			/*for(Commande commande:listeCommande) {
//				if(commande.getId()==id) {
//					System.out.println(commande.getStatut());
//					bu.mettreAJourCommande(commande);
//				}
//				
//			}
//		*/
//					
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//	}
	/**
	 * Méthode lancée à l'initiation.
	 */
	@PostConstruct
	public void chercherCommandes() {
		selectedProducteur = (Producteur) cnxMb.getConnectedAdh();
		try {
            listeCommande = busProd.rechercherCommandes(selectedProducteur);
        } catch (AnarmorixException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}


	public IBusinessConsommateur getBu() {
		return bu;
	}


	public void setBu(IBusinessConsommateur bu) {
		this.bu = bu;
	}

	public LigneCommande getLigne() {
		return ligne;
	}

	public void setLigne(LigneCommande ligne) {
		this.ligne = ligne;
	}

	/**
	 * Méthode pour set le statut d'une commande.
	 * @param paramStatut le statut à set
	 */
	public void changerStatut(String paramStatut, Commande paramCommande) {
		switch (paramStatut) {
		case "1":
			paramCommande.setStatut(Statut.CREEE);
			break;
		case "2":
		    paramCommande.setStatut(Statut.EN_COURS_DE_PREPARATION);
			break;
		case "3":
		    paramCommande.setStatut(Statut.EN_COURS_DE_LIVRAISON);
			break;
		case "4":
		    paramCommande.setStatut(Statut.EN_ATTENTE_DE_RETRAIT);
			break;
		case "5":
		    paramCommande.setStatut(Statut.TERMINEE);
			break;
		default:
			break;
		}
	}

    /**
     * @return the listeCommande
     */
    public List<Commande> getListeCommande() {
        return listeCommande;
    }

    /**
     * @param paramListeCommande the listeCommande to set
     */
    public void setListeCommande(List<Commande> paramListeCommande) {
        listeCommande = paramListeCommande;
    }

    /**
     * @return the cnxMb
     */
    public ConnexionCommandeManagedBean getCnxMb() {
        return cnxMb;
    }

    /**
     * @param paramCnxMb the cnxMb to set
     */
    public void setCnxMb(ConnexionCommandeManagedBean paramCnxMb) {
        cnxMb = paramCnxMb;
    }

    /**
     * @return the selectedProducteur
     */
    public Producteur getSelectedProducteur() {
        return selectedProducteur;
    }

    /**
     * @param paramSelectedProducteur the selectedProducteur to set
     */
    public void setSelectedProducteur(Producteur paramSelectedProducteur) {
        selectedProducteur = paramSelectedProducteur;
    }

    /**
     * @return the statut
     */
    public String getStatut() {
        return statut;
    }
}

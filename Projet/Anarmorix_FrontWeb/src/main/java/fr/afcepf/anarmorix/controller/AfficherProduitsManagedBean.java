package fr.afcepf.anarmorix.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import fr.afcepf.anarmorix.business.api.IBusinessClient;
import fr.afcepf.anarmorix.entity.Categorie;
import fr.afcepf.anarmorix.entity.Produit;
import fr.afcepf.anarmorix.exception.AnarmorixException;

@ManagedBean(name = "mbAfficheProduits")
@ViewScoped
public class AfficherProduitsManagedBean {
    
    @EJB
    private IBusinessClient businessCLient;
    List<Produit> produits =  new ArrayList<>();
    List<Categorie> categories =  new ArrayList<>();
    List<Categorie> categoriesPrimaires =  new ArrayList<>();
    List<Categorie> categoriesSecondaires =  new ArrayList<>();
    List<Categorie> categoriesTertiaires =  new ArrayList<>();
    List<Categorie> categoriesFilles =  new ArrayList<>();
    String libelleCategorie;
    Integer idCategorieMere;

    public AfficherProduitsManagedBean() {
    }
    
    @PostConstruct
    public void init(){
        try {
            produits = businessCLient.recupererTousLesProduits();
            categories = businessCLient.recupererToutesLesCategories();
            categoriesPrimaires = businessCLient.recupererCategoriesPrimaires();
            categoriesSecondaires = businessCLient.recupererCategoriesSecondaires();
            categoriesTertiaires = businessCLient.recupererCategoriesTertiaires();
        } catch (Exception e) {
           e.printStackTrace();
        }
    }
    
    public  List<Categorie> recupererCategorieFilles(Integer idCategorieMere) throws AnarmorixException {
        return businessCLient.recupererCategoriesFilles(idCategorieMere);
    }

    public  List<Produit> recupererProduitsFiltres() throws AnarmorixException {
    	if(libelleCategorie == null ) libelleCategorie = "Fraise";
    	return businessCLient.recupererLesProduitsParCategorie(libelleCategorie);
    }
    

    public String getLibelleCategorie() {
		return libelleCategorie;
	}

	public void setLibelleCategorie(String libelleCategorie) {
		this.libelleCategorie = libelleCategorie;
	}

	public List<Categorie> getCategoriesTertiaires() {
        return categoriesTertiaires;
    }

    public void setCategoriesTertiaires(List<Categorie> paramCategoriesTertiaires) {
        categoriesTertiaires = paramCategoriesTertiaires;
    }

    public List<Categorie> getCategoriesSecondaires() {
        return categoriesSecondaires;
    }

    public void setCategoriesSecondaires(List<Categorie> paramCategoriesSecondaires) {
        categoriesSecondaires = paramCategoriesSecondaires;
    }

    public List<Categorie> getCategoriesPrimaires() {
        return categoriesPrimaires;
    }

    public void setCategoriesPrimaires(List<Categorie> paramCategoriesPrimaires) {
        categoriesPrimaires = paramCategoriesPrimaires;
    }

    public List<Categorie> getCategories() {
        return categories;
    }

    public void setCategories(List<Categorie> paramCategories) {
        categories = paramCategories;
    }

    public List<Produit> getProduits() {
        return produits;
    }

    public void setProduits(List<Produit> paramProduits) {
        produits = paramProduits;
    }
    
    public List<Categorie> getCategoriesFilles() {
        return categoriesFilles;
    }

    public void setCategoriesFilles(List<Categorie> paramCategoriesFilles) {
        categoriesFilles = paramCategoriesFilles;
    }
    
    public Integer getIdCategorieMere() {
        return idCategorieMere;
    }

    public void setIdCategorieMere(Integer paramIdCategorieMere) {
        idCategorieMere = paramIdCategorieMere;
    }
}

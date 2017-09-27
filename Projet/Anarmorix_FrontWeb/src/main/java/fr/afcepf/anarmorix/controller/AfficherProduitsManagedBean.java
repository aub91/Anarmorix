package fr.afcepf.anarmorix.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import fr.afcepf.anarmorix.business.api.IBusinessClient;
import fr.afcepf.anarmorix.entity.Categorie;
import fr.afcepf.anarmorix.entity.PointRelais;
import fr.afcepf.anarmorix.entity.Produit;
import fr.afcepf.anarmorix.exception.AnarmorixException;

@ManagedBean(name = "mbAfficheProduits")
@SessionScoped
public class AfficherProduitsManagedBean {
    
    @EJB
    private IBusinessClient businessCLient;
    private List<Produit> produits =  new ArrayList<>();
    private List<Categorie> categories =  new ArrayList<>();
    private List<Categorie> categoriesPrimaires =  new ArrayList<>();
    private List<Categorie> categoriesSecondaires =  new ArrayList<>();
    private List<Categorie> categoriesTertiaires =  new ArrayList<>();
    private List<Categorie> categoriesFilles =  new ArrayList<>();
    private String libelleCategorie;
    private Integer idCategorieMere;
    private PointRelais selectedPointRelais;
    private List<Produit> listePdts;
    @ManagedProperty(value="#{mbMap}")
    private MapManagedBean mapMb;

    public AfficherProduitsManagedBean() {
    }
    
    @PostConstruct
    public void init(){
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String queryString = request.getQueryString();
        String[] tab = queryString.split("=");
        Integer idPointRelais = Integer.parseInt(tab[1]);
        for (PointRelais relais : mapMb.getListe()) {
            if(relais.getId() == idPointRelais){
                selectedPointRelais = relais;
            }
        }
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

    public void actualiserListe(Categorie cat)  throws AnarmorixException {
        //if(listePdts != null) listePdts.clear();
        //listePdts.clear();
        listePdts = businessCLient.recupererLesProduitsParCategorie(cat.getLibelle(), true);
        for (Produit pdt : listePdts) {
            System.out.println("id produit " + pdt.getId());
        }
    }

    public  List<Categorie> recupererCategorieFilles(Integer idCategorieMere) throws AnarmorixException {
        return businessCLient.recupererCategoriesFilles(idCategorieMere);
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

    public PointRelais getSelectedPointRelais() {
        return selectedPointRelais;
    }

    public void setSelectedPointRelais(PointRelais paramSelectedPointRelais) {
        selectedPointRelais = paramSelectedPointRelais;
    }

    public MapManagedBean getMapMb() {
        return mapMb;
    }

    public void setMapMb(MapManagedBean paramMapMb) {
        mapMb = paramMapMb;
    }

    public IBusinessClient getBusinessCLient() {
        return businessCLient;
    }

    public void setBusinessCLient(IBusinessClient paramBusinessCLient) {
        businessCLient = paramBusinessCLient;
    }

    public List<Produit> getListePdts() {
        return listePdts;
    }

    public void setListePdts(List<Produit> paramListePdts) {
        listePdts = paramListePdts;
    }
    
}

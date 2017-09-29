package fr.afcepf.anarmorix.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import fr.afcepf.anarmorix.business.api.IBusinessClient;
import fr.afcepf.anarmorix.entity.Categorie;
import fr.afcepf.anarmorix.entity.Client;
import fr.afcepf.anarmorix.entity.Commande;
import fr.afcepf.anarmorix.entity.LigneCommande;
import fr.afcepf.anarmorix.entity.PointRelais;
import fr.afcepf.anarmorix.entity.Produit;
import fr.afcepf.anarmorix.entity.Statut;
import fr.afcepf.anarmorix.entity.Tournee;
import fr.afcepf.anarmorix.exception.AnarmorixException;
/**
 * ManagedBean avec fonctionnalités du panier.
 * @author Aubin
 *
 */
@ManagedBean(name = "mbAfficheProduits")
@SessionScoped
public class AfficherProduitsManagedBean {
    /**
     * {@link IBusinessClient}.
     */
    @EJB
    private IBusinessClient businessCLient;
    /**
     * Liste de catégorie.
     */
    private List<Categorie> categories =  new ArrayList<>();
    /**
     * Liste de catégorie primaire.
     */
    private List<Categorie> categoriesPrimaires =  new ArrayList<>();
    /**
     * Liste de catégories secondaires.
     */
    private List<Categorie> categoriesSecondaires =  new ArrayList<>();
    /**
     * Liste de catégories tertiaires.
     */
    private List<Categorie> categoriesTertiaires =  new ArrayList<>();
    /**
     * Liste de catégories filles.
     */
    private List<Categorie> categoriesFilles =  new ArrayList<>();
    /**
     * Libelle de la catégorie.
     */
    private String libelleCategorie;
    /**
     * ID de la catégorie mère.
     */
    private Integer idCategorieMere;
    /**
     * Point-relais sélectionné.
     */
    private PointRelais selectedPointRelais;
    /**
     * Liste de produits.
     */
    private List<Produit> listePdts;
    /**
     * Liste de lignes de commandes.
     */
    private List<LigneCommande> ligneComandes =  new ArrayList<>();
    /**
     * Liste de lignes de commandes affichables.
     */
    private List<LigneCommande> ligneComandesAffichables =  new ArrayList<>();
    /**
     * Nombre de lignes de commandes ajoutées.
     */
    private Integer ligneComandesAjoutees;
    /**
     * Quantité ajouté.
     */
    private String quantiteAjoute;
    /**
     * Commande.
     */
    private Commande commande;
    /**
     * Liste des lignes de commande de la recette.
     */
    private List<LigneCommande> ligneCommandesRecette = new ArrayList<>();
    /**
     * {@link MapManagedBean}.
     */
    @ManagedProperty(value = "#{mbMap}")
    private MapManagedBean mapMb;
    /**
     * {@link ConnexionCommandeManagedBean}.
     */
    @ManagedProperty(value = "#{mbConnexion}")
    private ConnexionCommandeManagedBean cnxMb;
    /**
     * Default constructor.
     */
    public AfficherProduitsManagedBean() {
    }
    /**
     * Méthode d'initialisation.
     */
    @PostConstruct
    public void init() {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String queryString = request.getQueryString();
        String[] tab = queryString.split("=");
        Integer idPointRelais = Integer.parseInt(tab[1]);
        for (PointRelais relais : mapMb.getListe()) {
            if (relais.getId() == idPointRelais) {
                selectedPointRelais = relais;
            }
        }
        try {
            categories = businessCLient.recupererToutesLesCategories();
            //categoriesTertiaires = businessCLient.recupererCategoriesTertiaires();
            // categoriesSecondaires = businessCLient.recupererCategoriesSecondaires();
            //PRIMAIRES
            for (Categorie categorie : categories) {
                if (categorie.getCategorieMere() == null) {
                    categoriesPrimaires.add(categorie);
                }
            }

            //SECONDAIRES
            for (Categorie categorie : categories) {
                int nbParents = 0;
                Categorie categorieTemp = categorie.getCategorieMere();
                while (categorieTemp != null) {
                    categorieTemp = categorieTemp.getCategorieMere();
                    nbParents++;
                }
                if (nbParents == 1) {
                    categoriesSecondaires.add(categorie);
                }
            }

            //TERTIAIRES
            for (Categorie categorie : categories) {
                int nbParents = 0;
                Categorie categorieTemp = categorie.getCategorieMere();
                while (categorieTemp != null) {
                    categorieTemp = categorieTemp.getCategorieMere();
                    nbParents++;
                }
                if (nbParents == 2) {
                    categoriesTertiaires.add(categorie);
                }
            }

            //LIGNES COMMANDES AFFICHABLES
            listePdts = businessCLient.recupererTousLesProduits();
            for (Produit pdt : listePdts) {
               LigneCommande lgnCommandeTmp = new LigneCommande();
               lgnCommandeTmp.setProduit(pdt);
               ligneComandesAffichables.add(lgnCommandeTmp);

             //LIGNE COMMANDE RECETTE
               if (pdt.getType().getLibelle().equals("Filets de sole")) {
                   lgnCommandeTmp.setQuantiteCommandee(4.0);
                   ligneCommandesRecette.add(lgnCommandeTmp);
               }
               if (pdt.getType().getLibelle().equals("Asperge du Blayais")) {
                   lgnCommandeTmp.setQuantiteCommandee(2.0);
                   ligneCommandesRecette.add(lgnCommandeTmp);
               }
           }
        } catch (Exception e) {
           e.printStackTrace();
        }
    }
    /**
     * Méthode d'actualisation de la liste.
     * @param cat la catégorie sélectionnée
     * @throws AnarmorixException une exception
     */
    public void actualiserListe(Categorie cat)  throws AnarmorixException {
        listePdts = businessCLient.recupererLesProduitsParCategorie(cat.getLibelle(), true);
        ligneComandesAffichables = new ArrayList<>();
        for (Produit pdt : listePdts) {
//            System.out.println("id produit " + pdt.getId());
            LigneCommande lc = new LigneCommande();
            lc.setProduit(pdt);
            ligneComandesAffichables.add(lc);
        }
    }
    /**
     * Méthode d'ajout des produits de la recette au panier.
     * @return chemin de retour
     */
    public String ajouterRecetteAuPanier() {
//        System.out.println("TESSSTE" + ligneCommandesRecette.size());
        ligneComandes.addAll(ligneCommandesRecette);
        return "pageCatalogue.jsf";
    }
    /**
     * Méthode d'ajout des ligne de commande en base de données.
     * @return le chemin de redirection
     * @throws AnarmorixException une exception
     */
    public String ajouterLigneCommandeEnBase() {
      try {
        Client client = new Client();
        client.setId(1);
        Commande commandeCree = new Commande(null, new Date(), new Date(), null,
                selectedPointRelais, client, Statut.EN_ATTENTE_DE_PREPARATION);
        commandeCree.setLignesCommande(ligneComandes);
        commandeCree.setCodeValidation("12345");
        commandeCree = businessCLient.ajouterListeLigneCommande(commandeCree);
        ligneComandes.clear();
    } catch (AnarmorixException e) {
        e.printStackTrace();
    }
      return "pageConnexionCommande.jsf";

    }
    /**
     * Méthode d'ajout d'une ligne de commande.
     * @param ligneCommande une ligne de commande.
     */
    public void ajouterProduitLigneCommande(LigneCommande ligneCommande) {
        ligneComandes.add(ligneCommande);
    }
    /**
     * Méthode de récupération des catégories filles.
     * @param paramIdCategorieMere id de la catégorie mère
     * @return une lsite de catégorie
     * @throws AnarmorixException une exception
     */
    public  List<Categorie> recupererCategorieFilles(Integer idCategorieMere) throws AnarmorixException {
        categoriesFilles =  new ArrayList<>();
        for (Categorie categorie : categories) {
            if (categorie.getCategorieMere() != null) {
                if (categorie.getCategorieMere().getId() == idCategorieMere) {
                    categoriesFilles.add(categorie);
                }
            }
        }
        return categoriesFilles;
    }

    /**
     * @return the businessCLient
     */
    public IBusinessClient getBusinessCLient() {
        return businessCLient;
    }

    /**
     * @param paramBusinessCLient the businessCLient to set
     */
    public void setBusinessCLient(IBusinessClient paramBusinessCLient) {
        businessCLient = paramBusinessCLient;
    }

    /**
     * @return the categories
     */
    public List<Categorie> getCategories() {
        return categories;
    }

    /**
     * @param paramCategories the categories to set
     */
    public void setCategories(List<Categorie> paramCategories) {
        categories = paramCategories;
    }

    /**
     * @return the categoriesPrimaires
     */
    public List<Categorie> getCategoriesPrimaires() {
        return categoriesPrimaires;
    }

    /**
     * @param paramCategoriesPrimaires the categoriesPrimaires to set
     */
    public void setCategoriesPrimaires(List<Categorie> paramCategoriesPrimaires) {
        categoriesPrimaires = paramCategoriesPrimaires;
    }

    /**
     * @return the categoriesSecondaires
     */
    public List<Categorie> getCategoriesSecondaires() {
        return categoriesSecondaires;
    }

    /**
     * @param paramCategoriesSecondaires the categoriesSecondaires to set
     */
    public void setCategoriesSecondaires(List<Categorie> paramCategoriesSecondaires) {
        categoriesSecondaires = paramCategoriesSecondaires;
    }

    /**
     * @return the categoriesTertiaires
     */
    public List<Categorie> getCategoriesTertiaires() {
        return categoriesTertiaires;
    }

    /**
     * @param paramCategoriesTertiaires the categoriesTertiaires to set
     */
    public void setCategoriesTertiaires(List<Categorie> paramCategoriesTertiaires) {
        categoriesTertiaires = paramCategoriesTertiaires;
    }

    /**
     * @return the categoriesFilles
     */
    public List<Categorie> getCategoriesFilles() {
        return categoriesFilles;
    }

    /**
     * @param paramCategoriesFilles the categoriesFilles to set
     */
    public void setCategoriesFilles(List<Categorie> paramCategoriesFilles) {
        categoriesFilles = paramCategoriesFilles;
    }

    /**
     * @return the libelleCategorie
     */
    public String getLibelleCategorie() {
        return libelleCategorie;
    }

    /**
     * @param paramLibelleCategorie the libelleCategorie to set
     */
    public void setLibelleCategorie(String paramLibelleCategorie) {
        libelleCategorie = paramLibelleCategorie;
    }

    /**
     * @return the idCategorieMere
     */
    public Integer getIdCategorieMere() {
        return idCategorieMere;
    }

    /**
     * @param paramIdCategorieMere the idCategorieMere to set
     */
    public void setIdCategorieMere(Integer paramIdCategorieMere) {
        idCategorieMere = paramIdCategorieMere;
    }

    /**
     * @return the selectedPointRelais
     */
    public PointRelais getSelectedPointRelais() {
        return selectedPointRelais;
    }

    /**
     * @param paramSelectedPointRelais the selectedPointRelais to set
     */
    public void setSelectedPointRelais(PointRelais paramSelectedPointRelais) {
        selectedPointRelais = paramSelectedPointRelais;
    }

    /**
     * @return the listePdts
     */
    public List<Produit> getListePdts() {
        return listePdts;
    }

    /**
     * @param paramListePdts the listePdts to set
     */
    public void setListePdts(List<Produit> paramListePdts) {
        listePdts = paramListePdts;
    }

    /**
     * @return the ligneComandes
     */
    public List<LigneCommande> getLigneComandes() {
        return ligneComandes;
    }

    /**
     * @param paramLigneComandes the ligneComandes to set
     */
    public void setLigneComandes(List<LigneCommande> paramLigneComandes) {
        ligneComandes = paramLigneComandes;
    }

    /**
     * @return the ligneComandesAffichables
     */
    public List<LigneCommande> getLigneComandesAffichables() {
        return ligneComandesAffichables;
    }

    /**
     * @param paramLigneComandesAffichables the ligneComandesAffichables to set
     */
    public void setLigneComandesAffichables(List<LigneCommande> paramLigneComandesAffichables) {
        ligneComandesAffichables = paramLigneComandesAffichables;
    }

    /**
     * @return the quantiteAjoute
     */
    public String getQuantiteAjoute() {
        return quantiteAjoute;
    }

    /**
     * @param paramQuantiteAjoute the quantiteAjoute to set
     */
    public void setQuantiteAjoute(String paramQuantiteAjoute) {
        quantiteAjoute = paramQuantiteAjoute;
    }

    /**
     * @return the commande
     */
    public Commande getCommande() {
        return commande;
    }

    /**
     * @param paramCommande the commande to set
     */
    public void setCommande(Commande paramCommande) {
        commande = paramCommande;
    }

    /**
     * @return the ligneCommandesRecette
     */
    public List<LigneCommande> getLigneCommandesRecette() {
        return ligneCommandesRecette;
    }

    /**
     * @param paramLigneCommandesRecette the ligneCommandesRecette to set
     */
    public void setLigneCommandesRecette(List<LigneCommande> paramLigneCommandesRecette) {
        ligneCommandesRecette = paramLigneCommandesRecette;
    }

    /**
     * @return the mapMb
     */
    public MapManagedBean getMapMb() {
        return mapMb;
    }

    /**
     * @param paramMapMb the mapMb to set
     */
    public void setMapMb(MapManagedBean paramMapMb) {
        mapMb = paramMapMb;
    }
    /**
     * get taille ligneComandes.
     * @return taille de la liste
     */
    public Integer getLigneComandesAjoutees() {
        return ligneComandes.size();
    }
    /**
     * set taille ligneComandesAjoutees.
     * @param paramLigneComandesAjoutees the ligne commande to set
     */
    public void setLigneComandesAjoutees(Integer paramLigneComandesAjoutees) {
        ligneComandesAjoutees = ligneComandes.size();
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

}

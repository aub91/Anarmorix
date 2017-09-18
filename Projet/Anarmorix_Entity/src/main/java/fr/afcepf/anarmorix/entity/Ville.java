package fr.afcepf.anarmorix.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Entité représentant une ville.
 */
@Entity
@Table(name = "ville")
public class Ville implements Serializable {

    /**
     * Numéro pour sérialisation.
     */
    @Transient
    private static final long serialVersionUID = 1L;
    /**
     * Longueur moyenne d'une chaine de caractère.
     */
    @Transient
    private static final int LONGUEUR_MOYENNE = 50;
    /**
     * Code INSEE de la ville.
     */
    @Id
    @Column(name = "codeInsee")
    private String codeInsee;

    /**
     * Nom de la ville.
     */
    @Column(name = "nom", nullable = false, length = LONGUEUR_MOYENNE)
    private String nomVille;

    /**
     * Liste des adresses de la ville.
     */
    @OneToMany(mappedBy = "ville")
    private List<Adresse> adresses;

    /**
     * Liste des sociétés de livraisons domiciliées à cette adresse.
     */
    @ManyToMany
    @JoinTable(name = "ville_societeLivraison", joinColumns = @JoinColumn(name = "ville_codeInsee", referencedColumnName = "codeInsee"),
    inverseJoinColumns = @JoinColumn(name = "societeLivraison_id", referencedColumnName = "id"))
    private List<SocieteDeLivraison> societesDeLivraison;

    /**
     * Liste des codes postaux de la ville.
     */
    @ManyToMany(mappedBy = "villes")
    private List<CodePostal> codesPostaux;

    /**
     * @return the codeInsee
     */
    public String getCodeInsee() {
        return codeInsee;
    }


    /**
     * @param paramCodeInsee the codeInsee to set
     */
    public void setCodeInsee(String paramCodeInsee) {
        codeInsee = paramCodeInsee;
    }


    /**
     * @return the nomVille
     */
    public String getNomVille() {
        return nomVille;
    }


    /**
     * @param paramNomVille the nomVille to set
     */
    public void setNomVille(String paramNomVille) {
        nomVille = paramNomVille;
    }


    /**
     * @return the adresses
     */
    public List<Adresse> getAdresses() {
        return adresses;
    }


    /**
     * @param paramAdresses the adresses to set
     */
    public void setAdresses(List<Adresse> paramAdresses) {
        adresses = paramAdresses;
    }


    /**
     * @return the societesDeLivraison
     */
    public List<SocieteDeLivraison> getSocietesDeLivraison() {
        return societesDeLivraison;
    }


    /**
     * @param paramSocietesDeLivraison the societesDeLivraison to set
     */
    public void setSocietesDeLivraison(List<SocieteDeLivraison> paramSocietesDeLivraison) {
        societesDeLivraison = paramSocietesDeLivraison;
    }


    /**
     * @return the codesPostaux
     */
    public List<CodePostal> getCodesPostaux() {
        return codesPostaux;
    }


    /**
     * @param paramCodesPostaux the codesPostaux to set
     */
    public void setCodesPostaux(List<CodePostal> paramCodesPostaux) {
        codesPostaux = paramCodesPostaux;
    }


    /**
     * Default constructor.
     */
    public Ville() {
    }

    /**
     * Constructeur surchargé.
     * @param paramCodeInsee the codeInsee to set
     * @param paramNomVille the ville to set
     */
    public Ville(String paramCodeInsee, String paramNomVille) {
        super();
        codeInsee = paramCodeInsee;
        nomVille = paramNomVille;
    }

}
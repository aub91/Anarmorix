package fr.afcepf.anarmorix.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Entité représentant un code postal.
 */
@Entity
@Table(name = "codePostal")
public class CodePostal implements Serializable {

    /**
     * Numéro pour sérialisation.
     */
    @Transient
    private static final long serialVersionUID = 1L;
    /**
     * Petite longueur d'une chaine de caractère.
     */
    @Transient
    private static final int LONGUEUR_PETITE = 20;
    /**
     * Id du code postal.
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Intitulé du code postal.
     */
    @Column(name = "codePostal", nullable = false, length = LONGUEUR_PETITE)
    private String codePostal;
    /**
     * Liste des villes ayant ce code postal.
     */
    @ManyToMany
    @JoinTable(name = "codePostal_ville", joinColumns = @JoinColumn(name = "cp_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "ville_codeInsee", referencedColumnName = "codeInsee"))
    private List<Ville> villes;

    /**
     * Liste des adresses ayant ce code postal.
     */
    @OneToMany(mappedBy = "codePostal")
    private List<Adresse> adresses;
    /**
     * Default constructor.
     */
    public CodePostal() {
    }
    /**
     * Constructeur surchargé.
     * @param paramId the id to set
     * @param paramCodePostal the codePostgal to set
     */
    public CodePostal(Integer paramId, String paramCodePostal) {
        super();
        id = paramId;
        codePostal = paramCodePostal;
    }
    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }
    /**
     * @param paramId the id to set
     */
    public void setId(Integer paramId) {
        id = paramId;
    }
    /**
     * @return the codePostal
     */
    public String getCodePostal() {
        return codePostal;
    }
    /**
     * @param paramCodePostal the codePostal to set
     */
    public void setCodePostal(String paramCodePostal) {
        codePostal = paramCodePostal;
    }
    /**
     * @return the villes
     */
    public List<Ville> getVilles() {
        return villes;
    }
    /**
     * @param paramVilles the villes to set
     */
    public void setVilles(List<Ville> paramVilles) {
        villes = paramVilles;
    }

}
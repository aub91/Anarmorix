package fr.afcepf.anarmorix.entity;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

/**
 * Entité représentant le point relais.
 */
@Entity
@DiscriminatorValue("PointRelais")
public class PointRelais extends Commerce {

    /**
     * Numéro pour sérialisation.
     */
    @Transient
    private static final long serialVersionUID = 1L;


    /**
     * Liste des jours d'ouverture du point relais.
     */
    @OneToMany(mappedBy = "relais")
    private List<JourOuverture> joursOuverture;

    /**
     * Liste des employés du point relais.
     */
    @OneToMany(mappedBy = "relais")
    private List<Employe> employes;

    /**
     * Liste des commandes reçues au point relais.
     */
    @OneToMany(mappedBy = "relais")
    private List<Commande> commandes;

    /**
     * Default constructor.
     */
    public PointRelais() {
    }

    /**
     * @return the joursOuverture
     */
    public List<JourOuverture> getJoursOuverture() {
        return joursOuverture;
    }

    /**
     * @param paramJoursOuverture the joursOuverture to set
     */
    public void setJoursOuverture(List<JourOuverture> paramJoursOuverture) {
        joursOuverture = paramJoursOuverture;
    }

    /**
     * @return the employes
     */
    public List<Employe> getEmployes() {
        return employes;
    }

    /**
     * @param paramEmployes the employes to set
     */
    public void setEmployes(List<Employe> paramEmployes) {
        employes = paramEmployes;
    }

    /**
     * @return the commandes
     */
    public List<Commande> getCommandes() {
        return commandes;
    }

    /**
     * @param paramCommandes the commandes to set
     */
    public void setCommandes(List<Commande> paramCommandes) {
        commandes = paramCommandes;
    }
    
}
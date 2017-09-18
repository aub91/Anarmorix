package fr.afcepf.anarmorix.entity;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

/**
 * Entité représentant une société de livraison.
 */
@Entity
@DiscriminatorValue("SocieteDeLivraison")
public class SocieteDeLivraison extends Commerce {

    /**
     * Numéro pour sérialisation.
     */
    @Transient
    private static final long serialVersionUID = 1L;

    /**
     * Liste des livreurs de la société de livraison.
     */
    @OneToMany(mappedBy = "societe")
    private List<Livreur> livreurs;

    /**
     * Liste des villes livrées par la société de livraison.
     */
    @ManyToMany(mappedBy = "societesDeLivraison")
    private List<Ville> villesLivrees;

    /**
     * Default constructor.
     */
    public SocieteDeLivraison() {
    }

    /**
     * Constructeur surchargé.
     * @param paramId the id to set
     * @param paramNumSiren the numSiren to set
     * @param paramNumNic the numNic to set
     * @param paramCodeApe the codeApe to set
     * @param paramIban the iban to set
     * @param paramRaisonSociale the raisonSociale to set
     * @param paramAdresse the adresse to set
     * @param paramImagePrincipale the imagePrincipale to set
     */
    public SocieteDeLivraison(Integer paramId, String paramNumSiren, String paramNumNic, String paramCodeApe,
            String paramIban, String paramRaisonSociale, Adresse paramAdresse, Image paramImagePrincipale) {
        super(paramId, paramNumSiren, paramNumNic, paramCodeApe, paramIban, paramRaisonSociale, paramAdresse,
                paramImagePrincipale);
    }

}
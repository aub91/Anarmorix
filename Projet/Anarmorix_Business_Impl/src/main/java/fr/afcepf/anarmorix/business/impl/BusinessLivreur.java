package fr.afcepf.anarmorix.business.impl;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.afcepf.anarmorix.business.api.IBusinessLivreur;
import fr.afcepf.anarmorix.data.api.IDaoAdresse;
import fr.afcepf.anarmorix.data.api.IDaoCatalogue;
import fr.afcepf.anarmorix.data.api.IDaoCommerce;
import fr.afcepf.anarmorix.data.api.IDaoLigneCommande;
import fr.afcepf.anarmorix.data.api.IDaoProduit;
import fr.afcepf.anarmorix.data.api.IDaoTournee;
import fr.afcepf.anarmorix.entity.Catalogue;
import fr.afcepf.anarmorix.entity.Exploitation;
import fr.afcepf.anarmorix.entity.LigneCommande;
import fr.afcepf.anarmorix.entity.Livreur;
import fr.afcepf.anarmorix.entity.SocieteDeLivraison;
import fr.afcepf.anarmorix.entity.Tournee;
import fr.afcepf.anarmorix.exception.AnarmorixException;

/**
 * Classe implémentant les méthodes de {@link IBusinessLivreur}.
 */
@Remote(IBusinessLivreur.class)
@Stateless
public class BusinessLivreur implements IBusinessLivreur {
    /**
     * {@link IDaoTournee}.
     */
    @EJB
    private IDaoTournee daoTournee;
    /**
     * {@link IDaoLigneCommande}.
     */
    @EJB
    private IDaoLigneCommande daoLigneCommande;
    /**
     * {@link IDaoProduit}.
     */
    @EJB
    private IDaoProduit daoProduit;
    /**
     * {@link IDaoCatalogue}.
     */
    @EJB
    private IDaoCatalogue daoCatalogue;
    /**
     * {@link IDaoCommerce}.
     */
    @EJB
    private IDaoCommerce daoCommerce;
    /**
     * {@link IDaoAdresse}.
     */
    @EJB
    private IDaoAdresse daoAdresse;
    /**
     * Default constructor.
     */
    public BusinessLivreur() {

    }

    @Override
    public SocieteDeLivraison setTournees(SocieteDeLivraison paramSocieteDeLivraison) throws AnarmorixException {
        return daoTournee.rechercherBySocieteDeLivraison(paramSocieteDeLivraison);
    }

    @Override
    public Tournee setLignesCommandes(Tournee paramTournee) throws AnarmorixException {
        Tournee tournee = daoLigneCommande.rechercherByTournee(paramTournee);
        List<LigneCommande> liste = new ArrayList<>();
        for (LigneCommande ligne : tournee.getLignesCmd()) {
            LigneCommande ligneTmp = new LigneCommande();
            ligneTmp = daoProduit.rechercherByLigneCommande(ligne);
            ligneTmp.setProduit(daoCatalogue.rechercherByProduit(ligne.getProduit()));
            for (Catalogue catag : ligneTmp.getProduit().getCatalogues()) {
                catag = daoCommerce.rechercherExploitationByCatalogue(catag);
            }
            liste.add(ligneTmp);
        }
        tournee.setLignesCmd(liste);
        return tournee;
    }

    @Override
    public List<Exploitation> setExploitationAVisiter(Tournee paramTournee) throws AnarmorixException {
        Set<Exploitation> setRetour = new LinkedHashSet<>();
        for (LigneCommande ligne : paramTournee.getLignesCmd()) {
            setRetour.add(ligne.getProduit().getCatalogues().get(0).getExploitation());
        }
        List<Exploitation> retour = new ArrayList<>(setRetour);
        return retour;
    }

    @Override
    public Livreur alimenterLivreur(Livreur paramLivreur) throws AnarmorixException {
        Livreur retour = daoCommerce.rechercherSocieteByLivreur(paramLivreur);
        return retour;
    }

    @Override
    public LigneCommande mettreAJour(LigneCommande paramLigneCommande) throws AnarmorixException {
        return daoLigneCommande.mettreAJour(paramLigneCommande);
    }
}
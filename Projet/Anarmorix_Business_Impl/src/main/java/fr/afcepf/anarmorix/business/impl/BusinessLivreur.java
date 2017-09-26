package fr.afcepf.anarmorix.business.impl;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.afcepf.anarmorix.business.api.IBusinessLivreur;
import fr.afcepf.anarmorix.data.api.IDaoCatalogue;
import fr.afcepf.anarmorix.data.api.IDaoCommerce;
import fr.afcepf.anarmorix.data.api.IDaoLigneCommande;
import fr.afcepf.anarmorix.data.api.IDaoProduit;
import fr.afcepf.anarmorix.data.api.IDaoTournee;
import fr.afcepf.anarmorix.entity.Catalogue;
import fr.afcepf.anarmorix.entity.Exploitation;
import fr.afcepf.anarmorix.entity.LigneCommande;
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
        Tournee retour = daoLigneCommande.rechercherByTournee(paramTournee);
        for (LigneCommande ligne : retour.getLignesCmd()) {
            ligne = daoProduit.rechercherByLigneCommande(ligne);
            ligne.setProduit(daoCatalogue.rechercherByProduit(ligne.getProduit()));
            for (Catalogue catag : ligne.getProduit().getCatalogues()) {
                catag = daoCommerce.rechercherExploitationByCatalogue(catag);
            }
        }
        return retour;
    }

    @Override
    public Set<Exploitation> setExploitationAVisiter(Tournee paramTournee) throws AnarmorixException {
        Set<Exploitation> retour = new LinkedHashSet<>();
        for (LigneCommande ligne : paramTournee.getLignesCmd()) {
            retour.add(ligne.getProduit().getCatalogues().get(0).getExploitation());
        }
        return retour;
    }
}
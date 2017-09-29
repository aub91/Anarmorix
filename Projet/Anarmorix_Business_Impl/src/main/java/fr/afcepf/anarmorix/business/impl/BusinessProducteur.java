package fr.afcepf.anarmorix.business.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.afcepf.anarmorix.business.api.IBusinessProducteur;
import fr.afcepf.anarmorix.data.api.IDaoCatalogue;
import fr.afcepf.anarmorix.data.api.IDaoLigneCommande;
import fr.afcepf.anarmorix.data.api.IDaoProduit;
import fr.afcepf.anarmorix.entity.Commande;
import fr.afcepf.anarmorix.entity.LigneCommande;
import fr.afcepf.anarmorix.entity.Producteur;
import fr.afcepf.anarmorix.entity.Produit;
import fr.afcepf.anarmorix.exception.AnarmorixException;

/**
 * Implémentation de {@link IBusinessProducteur}.
 */
@Remote(IBusinessProducteur.class)
@Stateless
public class BusinessProducteur implements IBusinessProducteur {

    /**
     * Default constructor.
     */
    public BusinessProducteur() {
    }
    /**
     * {@link IDaoCatalogue}.
     */
    @EJB
    private IDaoCatalogue daoCatalogue;
    /**
     * {@link IDaoProduit}.
     */
    @EJB
    private IDaoProduit daoProduit;
    /**
     * {@link IDaoLigneCommande}.
     */
    @EJB
    private IDaoLigneCommande daoLigneCommande;

    @Override
    public List<Commande> rechercherCommandes(Producteur paramProducteur) throws AnarmorixException {
        List<Commande> liste = new ArrayList<>();
        List<LigneCommande> listeLignes = new ArrayList<>();
        paramProducteur.getExploitation().setCatalogues(daoCatalogue.rechercherByExploitation(paramProducteur.getExploitation()));
        paramProducteur.getExploitation().getCatalogues().set(0, daoProduit.rechercherByCatalogue(paramProducteur.getExploitation().getCatalogues().get(0)));
        for (Produit pdt : paramProducteur.getExploitation().getCatalogues().get(0).getProduits()) {
            pdt = daoLigneCommande.rechercherByProduit(pdt);
            for (LigneCommande ligneCommande : pdt.getLignesCmd()) {
                listeLignes.add(ligneCommande);
            }
        }
        for (LigneCommande ligneCommande : listeLignes) {
            boolean exist = false;
            for (Commande commande : liste) {
                if (commande.getId() == ligneCommande.getCommande().getId()) {
                    exist = true;
                }
            }
            if (!exist) {
                liste.add(ligneCommande.getCommande());
            }
        }
        return liste;
    }


}
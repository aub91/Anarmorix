package fr.afcepf.anarmorix.controller;


import java.util.ArrayList;
import java.util.List;

import fr.afcepf.anarmorix.entity.Commerce;
import fr.afcepf.anarmorix.entity.LigneCommande;
/**
 * Classe représentant un commerce et la liste de produits associés lors d'une tournée.
 * @author Aubin
 *
 */
public class CommerceVue {
    /**
     * {@link Commerce}.
     */
    private Commerce commerce;
    /**
     * Liste de lignes de commandes.
     */
    private List<LigneCommande> listeLigneCmd = new ArrayList<>();
    /**
     * @return the commerce
     */
    public Commerce getCommerce() {
        return commerce;
    }
    /**
     * @param paramCommerce the commerce to set
     */
    public void setCommerce(Commerce paramCommerce) {
        commerce = paramCommerce;
    }
    /**
     * @return the listeLigneCmd
     */
    public List<LigneCommande> getListeLigneCmd() {
        return listeLigneCmd;
    }
    /**
     * @param paramListeLigneCmd the listeLigneCmd to set
     */
    public void setListeLigneCmd(List<LigneCommande> paramListeLigneCmd) {
        listeLigneCmd = paramListeLigneCmd;
    }
}

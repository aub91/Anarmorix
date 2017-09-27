package fr.afcepf.anarmorix.entity;

public class LignePanier {
    
    private Produit produit;
    
    private Double quantite;

    /**
     * 
     */
    public LignePanier() {
    }

    /**
     * @param paramProduit
     * @param paramQuantite
     */
    public LignePanier(Produit paramProduit, Double paramQuantite) {
        produit = paramProduit;
        quantite = paramQuantite;
    }

    /**
     * @return the produit
     */
    public Produit getProduit() {
        return produit;
    }

    /**
     * @param paramProduit the produit to set
     */
    public void setProduit(Produit paramProduit) {
        produit = paramProduit;
    }

    /**
     * @return the quantite
     */
    public Double getQuantite() {
        return quantite;
    }

    /**
     * @param paramQuantite the quantite to set
     */
    public void setQuantite(Double paramQuantite) {
        quantite = paramQuantite;
    }

}

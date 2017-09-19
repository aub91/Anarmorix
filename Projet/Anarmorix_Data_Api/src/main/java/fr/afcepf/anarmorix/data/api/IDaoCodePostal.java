package fr.afcepf.anarmorix.data.api;

import java.util.List;

import fr.afcepf.anarmorix.entity.CodePostal;

/**
 * 
 */
public interface IDaoCodePostal {

    /**
     * @param cp 
     * @return
     */
    public List<CodePostal> rechercher(String cp);

    /**
     * @param codePoostal 
     * @return
     */
    public CodePostal ajouter(CodePostal codePoostal);

    /**
     * @param id 
     * @return
     */
    public Boolean supprimer(Integer id);

    /**
     * @param id 
     * @return
     */
    public CodePostal MettreAJour(Integer id);

}
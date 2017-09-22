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
    public List<CodePostal> rechercher(String cp) throws Exception;

    /**
     * @param codePoostal 
     * @return
     */
    public CodePostal ajouter(CodePostal codePoostal) throws Exception;

    /**
     * @param id 
     * @return
     */
    public Boolean supprimer(Integer id) throws Exception;

    /**
     * @param id 
     * @return
     */
    public CodePostal MettreAJour(Integer id) throws Exception;

}
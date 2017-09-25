package fr.afcepf.anarmorix.data.api;

import java.util.List;

import fr.afcepf.anarmorix.entity.SocieteDeLivraison;
import fr.afcepf.anarmorix.entity.Tournee;
import fr.afcepf.anarmorix.exception.AnarmorixException;

/**
 * Classe lié à la persistence de l'entité {@link Tournee}.
 */
public interface IDaoTournee {

    /**
     * @param paramSocieteDeLivraison une société de livraison
     * @return la liste des tournées de livraison de la société
     * @throws AnarmorixException une exception
     */
    List<Tournee> rechercherBySocieteDeLivraison(SocieteDeLivraison paramSocieteDeLivraison) throws AnarmorixException;

    /**
     * @param tournee
     * @return
     */
    Tournee ajouter(Tournee tournee);

    /**
     * @param id
     * @return
     */
    Boolean supprimer(Integer id);

    /**
     * @param id
     * @return
     */
    Tournee mettreAJour(Integer id);

}
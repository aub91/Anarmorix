package fr.afcepf.anarmorix.data.Api;

import fr.afcepf.anarmorix.entity.JourOuverture;
import fr.afcepf.anarmorix.entity.PointRelais;

/**
 * 
 */
public interface IDaoJourOuverture {

    /**
     * @param pointRelais 
     * @return
     */
    public JourOuverture recherche(PointRelais pointRelais);

}
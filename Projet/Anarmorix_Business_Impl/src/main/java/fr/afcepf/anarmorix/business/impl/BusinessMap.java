package fr.afcepf.anarmorix.business.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.afcepf.anarmorix.business.api.IBusinessMap;
import fr.afcepf.anarmorix.data.api.IDaoAdresse;
import fr.afcepf.anarmorix.data.api.IDaoCodePostal;
import fr.afcepf.anarmorix.data.api.IDaoHoraire;
import fr.afcepf.anarmorix.data.api.IDaoJourOuverture;
import fr.afcepf.anarmorix.data.api.IDaoPointRelais;
import fr.afcepf.anarmorix.data.api.IDaoVille;
import fr.afcepf.anarmorix.entity.Adresse;
import fr.afcepf.anarmorix.entity.JourOuverture;
import fr.afcepf.anarmorix.entity.PointRelais;
import fr.afcepf.anarmorix.exception.AnarmorixException;
import fr.afcepf.anarmorix.exception.AnarmorixExceptionEnum;
/**
 * Classe implémentant les méthodes de {@link IBusinessMap}.
 * @author Aubin
 *
 */
@Remote(IBusinessMap.class)
@Stateless
public class BusinessMap implements IBusinessMap {
    /**
     * Classe contenant la méthode à appeler pour getAllPointRelais.
     */
    @EJB
    private IDaoPointRelais daoPointRelais;
    /**
     * Classe contenant une méthode à appeler pour alimenterPointRelais.
     */
    @EJB
    private IDaoAdresse daoAdresse;
    /**
     * Classe contenant une méthode à appeler pour alimenterAdresse.
     */
    @EJB
    private IDaoVille daoVille;
    /**
     * Classe contenant une méthode à appeler pour alimenterAdresse.
     */
    @EJB
    private IDaoCodePostal daoCodepostal;
    /**
     * Classe contenant une méthode à appeler pour alimenterPointRelais.
     */
    @EJB
    private IDaoJourOuverture daoJourOuverture;
    /**
     * Classe contenant une méthode à appeler pour alimenterJourOuverture.
     */
    @EJB
    private IDaoHoraire daoHoraire;

    @Override
    public List<PointRelais> getAllPointRelais() throws AnarmorixException {
        List<PointRelais> liste = null;
        try {
            liste = daoPointRelais.getAll();
            for (PointRelais pr : liste) {
                alimenterPointRelais(pr);
                alimenterAdresse(pr.getAdresse());
                for (JourOuverture jourOuverture : pr.getJoursOuverture()) {
                    alimenterJourOuverture(jourOuverture);
                }
            }
        } catch (Exception e) {
            AnarmorixException exc = new AnarmorixException("", AnarmorixExceptionEnum.ERREUR_NON_IDENTIFIEE);
            throw exc;
        }
        return liste;
    }
    @Override
    public PointRelais alimenterPointRelais(PointRelais paramPointRelais) throws AnarmorixException {
        paramPointRelais = (PointRelais) daoAdresse.getByCommerce(paramPointRelais);
        paramPointRelais = daoJourOuverture.getAllByPointRelais(paramPointRelais);
        return paramPointRelais;
    }
    @Override
    public Adresse alimenterAdresse(Adresse paramAdresse) throws AnarmorixException {
        paramAdresse = daoCodepostal.getByAdress(paramAdresse);
        paramAdresse = daoVille.getByAdress(paramAdresse);
        return paramAdresse;
    }
    @Override
    public JourOuverture alimenterJourOuverture(JourOuverture paramJourOuverture) throws AnarmorixException {
        paramJourOuverture = daoHoraire.getHoraireByJourOuverture(paramJourOuverture);
        return paramJourOuverture;
    }
}

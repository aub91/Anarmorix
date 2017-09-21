package fr.afcepf.anarmorix.data.test;

import java.util.Date;

import org.junit.Test;

import fr.afcepf.anarmorix.data.api.IDaoLigneCommande;
import fr.afcepf.anarmorix.entity.Adherent;
import fr.afcepf.anarmorix.entity.Client;
import fr.afcepf.anarmorix.entity.Commande;
import fr.afcepf.anarmorix.entity.PointRelais;

/**
 * Test des méthodes du {@link DaoLigneCommande}.
 * @author Stagiaire
 *
 */
public class TestDaoLigneProduit {

    /**
     * Classe contenant les services à tester.
     */
    private IDaoLigneCommande dao = (IDaoLigneCommande) CreateProxyEJB.getProxy(
            "Anarmorix_EAR-1.0/Anarmorix_Data_Impl-1.0/DaoLigneCommande!fr.afcepf.anarmorix.data.api.IDaoLigneCommande");

    /**
     * ID d'une commande inexistante.
     */
    private static final int ID_INEXISTANT = -1;

    /**
     * Point relais entré dans les commandes test.
     */
    /*private static final PointRelais RELAIS = 
            new PointRelais(paramId, paramNumSiren, paramNumNic, paramCodeApe, paramIban, paramRaisonSociale, paramAdresse, paramImagePrincipale);
    */
    /**
     * Id du point relais entré dans les commandes test.
     */
    /*private static final Adherent CLIENT = 
            new Client( paramId, paramDateInscription, paramNom, paramPrenom, paramDateNaissance, paramAdresse, 
                        paramMail, paramTelephone1, paramTelephone2, paramUsername, paramPassword, paramImage);
    */
    /**
     * Commande pour le test du cas d'une commande inexistante.
     */
    //private Commande commandeInexistante = new Commande(ID_INEXISTANT, new Date(), null, null, ID_RELAIS, ID_CLIENT, null);
    /*
    @Test
    public void testEchecCommandeInexistante(){
        try {
            dao.rechercher(commandeInexistante);
        } catch (AnarmorixException e ) {
            
        }
    }
    */
}

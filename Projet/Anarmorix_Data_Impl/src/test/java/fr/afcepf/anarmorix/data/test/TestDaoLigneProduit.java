package fr.afcepf.anarmorix.data.test;

import java.util.Date;

import org.junit.Test;

import fr.afcepf.anarmorix.data.api.IDaoLigneCommande;
import fr.afcepf.anarmorix.entity.Adherent;
import fr.afcepf.anarmorix.entity.Adresse;
import fr.afcepf.anarmorix.entity.Client;
import fr.afcepf.anarmorix.entity.CodePostal;
import fr.afcepf.anarmorix.entity.Commande;
import fr.afcepf.anarmorix.entity.PointRelais;
import fr.afcepf.anarmorix.entity.Statut;
import fr.afcepf.anarmorix.entity.Ville;
import fr.afcepf.anarmorix.exception.AnarmorixException;

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
     * {@link CodePostal} du client.
     */
    private static final CodePostal CODEPOSTAL = new CodePostal(1, "22500");

    /**
     *
     */
    private static final Ville VILLE = new Ville("22162", "Paimpol");

    /**
     * ID d'une commande inexistante.
     */
    private static final Integer ID_INEXISTANT = -1;

    /**
     *  {@link Adresse} du {@link Client} utilisé pour les tests.
     */
    private static final Adresse ADRESSE = new Adresse(3, 15, null, "rue Becot", CODEPOSTAL,
                                            VILLE, "3.051375", "48.779062");

    /**
     * Point relais entré dans les commandes test.
     */
<<<<<<< HEAD
<<<<<<< HEAD
//    private static final PointRelais RELAIS = 
//            new PointRelais(paramId, paramNumSiren, paramNumNic, paramCodeApe, paramIban, paramRaisonSociale, paramAdresse, paramImagePrincipale);
//
//    /**
//     * Id du point relais entré dans les commandes test.
//     */
//    private static final Adherent CLIENT = 
//            new Client( paramId, paramDateInscription, paramNom, paramPrenom, paramDateNaissance, paramAdresse, 
//                        paramMail, paramTelephone1, paramTelephone2, paramUsername, paramPassword, paramImage);
//
//    /**
//     * Commande pour le test du cas d'une commande inexistante.
//     */
//    private Commande commandeInexistante = new Commande(ID_INEXISTANT, new Date(), null, null, ID_RELAIS, ID_CLIENT, null);
//    
//    @Test
//    public void testEchecCommandeInexistante(){
//        try {
//            dao.rechercher(commandeInexistante);
//        } catch (AnarmorixException e ) {
//            
//        }
//    }
=======
    /*private static final PointRelais RELAIS = 
            new PointRelais(paramId, paramNumSiren, paramNumNic, paramCodeApe, paramIban, paramRaisonSociale, paramAdresse, paramImagePrincipale);
    */
=======
    private static final PointRelais RELAIS = new PointRelais();

>>>>>>> eloi
    /**
     * Client entré dans les commandes test.
     */
<<<<<<< HEAD
    /*private static final Adherent CLIENT = 
            new Client( paramId, paramDateInscription, paramNom, paramPrenom, paramDateNaissance, paramAdresse, 
                        paramMail, paramTelephone1, paramTelephone2, paramUsername, paramPassword, paramImage);
    */
    /**
     * Commande pour le test du cas d'une commande inexistante.
     */
    //private Commande commandeInexistante = new Commande(ID_INEXISTANT, new Date(), null, null, ID_RELAIS, ID_CLIENT, null);
    /*
=======
    private static final Client CLIENT =  new Client(15, new Date(117, 9, 18) , "Scarlatti",
                                        "Gustave", new Date(117, 8, 17), ADRESSE,
                        "épanorthose@ovh.fr", "0666666666", null, "Wildcatgalileo", "aaa", null);

    /**
     * Commande pour le test du cas d'une commande inexistante.
     */
    private Commande commandeInexistante = new Commande(ID_INEXISTANT, new Date(), new Date(), null, RELAIS, CLIENT, Statut.EN_ATTENTE_DE_PREPARATION);

>>>>>>> eloi
    @Test
    public void testEchecCommandeInexistante(){
        try {
            dao.rechercher(commandeInexistante);
        } catch (AnarmorixException e) {
            
        }
    }
    */
>>>>>>> aubin
}

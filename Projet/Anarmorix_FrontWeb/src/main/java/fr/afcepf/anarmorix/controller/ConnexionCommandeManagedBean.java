package fr.afcepf.anarmorix.controller;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.afcepf.anarmorix.business.api.IBusinessConnexion;
import fr.afcepf.anarmorix.entity.Adherent;
import fr.afcepf.anarmorix.exception.AnarmorixException;

@ManagedBean(name = "mbConnexion")
@SessionScoped
public class ConnexionCommandeManagedBean implements Serializable{
    
    private static final long serialVerisonUID = 1L;
    
    @EJB
    private IBusinessConnexion buCnx;
    
    private Adherent connectedAdh;
    
    private String username;
    
    private String password;
    
    public String seConnecter(){
        String forward ="";
        try {
            connectedAdh = buCnx.seConnecter(username, password);
            forward = ""/*"/pagePaiement.xhml?faces-redirect=true"*/;
            return forward;
        } catch (AnarmorixException e) {
            forward = "/pagePanier.xhml?faces-redirect=true";
            return forward;
        }
    }

}

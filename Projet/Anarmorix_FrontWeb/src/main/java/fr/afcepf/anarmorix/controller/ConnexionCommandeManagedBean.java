package fr.afcepf.anarmorix.controller;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.afcepf.anarmorix.business.api.IBusinessConnexion;
import fr.afcepf.anarmorix.entity.Adherent;
import fr.afcepf.anarmorix.entity.Client;
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
    
    /**
     * @return the buCnx
     */
    public IBusinessConnexion getBuCnx() {
        return buCnx;
    }

    /**
     * @param paramBuCnx the buCnx to set
     */
    public void setBuCnx(IBusinessConnexion paramBuCnx) {
        buCnx = paramBuCnx;
    }

    /**
     * @return the connectedAdh
     */
    public Adherent getConnectedAdh() {
        return connectedAdh;
    }

    /**
     * @param paramConnectedAdh the connectedAdh to set
     */
    public void setConnectedAdh(Adherent paramConnectedAdh) {
        connectedAdh = paramConnectedAdh;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param paramUsername the username to set
     */
    public void setUsername(String paramUsername) {
        username = paramUsername;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param paramPassword the password to set
     */
    public void setPassword(String paramPassword) {
        password = paramPassword;
    }

    public String seConnecter(){
        String forward ="";
        try {
            connectedAdh = buCnx.seConnecter(username, password);
            if(connectedAdh != null && connectedAdh.getClass() == Client.class) {
                forward = ""/*"/pagePaiement.xhml?faces-redirect=true"*/;
            } else {
                forward = "/pagePanier.xhml?faces-redirect=true";
            }
            return forward;
        } catch (AnarmorixException e) {
            forward = "/pagePanier.xhml?faces-redirect=true";
            return forward;
        }
    }

}

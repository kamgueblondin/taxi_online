/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Utilisateur;
import Session.UtilisateurFacade;
import Session.UtilisateurFacadeLocal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Blondin
 */
@Named
@javax.faces.view.ViewScoped
public class ControllerUser implements Serializable {

    @EJB

    private UtilisateurFacadeLocal utilisateurfracade;
    private List<Utilisateur> listutilisateur = new ArrayList<Utilisateur>();
    private Utilisateur utilisateur;
    private String msg;
    private Utilisateur user;

    public ControllerUser() {
    }

    /*
     public String utilisateur(){
     listutilisateur.clear();
     listutilisateur.addAll(utilisateurfracade.findAll());
        
     return "utilisateur.xhtml?faces-redirect=true";
     }*/
    public List<Utilisateur> listUtilisateur() {
        listutilisateur.clear();
        listutilisateur.addAll(utilisateurfracade.findAll());
        utilisateur = new Utilisateur();
        return listutilisateur;
    }

    public void preparedAdd() {
        utilisateur = new Utilisateur();
    }

    public String saveUser() {
        try {
            utilisateurfracade.create(utilisateur);
        } catch (Exception e) {
            System.out.println("Erreur de save: " + e.getMessage());
        }
        listutilisateur.clear();
        listutilisateur.addAll(utilisateurfracade.findAll());
        return "utilisateur.xhtml?faces-redirect=true";
    }

    public int iduser() {
        return utilisateurfracade.findAll().size() + 1;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Utilisateur getUser() {
        return user;
    }

    public void setUser(Utilisateur user) {
        this.user = user;
    }
    
    public String modifUser(){
        try{
            utilisateurfracade.edit(utilisateur);
        }catch(Exception e){
            System.out.println("Erreur de modif : "+e.getMessage());
        }
        listutilisateur.clear();
        listutilisateur.addAll(utilisateurfracade.findAll());
        return "utilisateur.xhtml?faces-redirect=true";
    
    }
    
    public String supUser(){
        try{
            utilisateurfracade.remove(user);
        }catch(Exception e){
            System.out.println("Erreur de Suppréssion : "+e.getMessage());
        }
        listutilisateur.clear();
        listutilisateur.addAll(utilisateurfracade.findAll());
        return "utilisateur.xhtml?faces-redirect=true";
    
    }
    
    public String close(){
        return "utilisateur.xhtml?faces-redirect=true";
    }

    public List<Utilisateur> getListutilisateur() {
        return listutilisateur;
    }
    

    public void setListutilisateur(List<Utilisateur> listutilisateur) {
        this.listutilisateur = listutilisateur;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

}

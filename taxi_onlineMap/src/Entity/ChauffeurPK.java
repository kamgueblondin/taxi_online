/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Blondin
 */
@Embeddable
public class ChauffeurPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "idutilisateur")
    private int idutilisateur;
    @Basic(optional = false)
    @Column(name = "idchauffeur")
    private int idchauffeur;

    public ChauffeurPK() {
    }

    public ChauffeurPK(int idutilisateur, int idchauffeur) {
        this.idutilisateur = idutilisateur;
        this.idchauffeur = idchauffeur;
    }

    public int getIdutilisateur() {
        return idutilisateur;
    }

    public void setIdutilisateur(int idutilisateur) {
        this.idutilisateur = idutilisateur;
    }

    public int getIdchauffeur() {
        return idchauffeur;
    }

    public void setIdchauffeur(int idchauffeur) {
        this.idchauffeur = idchauffeur;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idutilisateur;
        hash += (int) idchauffeur;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ChauffeurPK)) {
            return false;
        }
        ChauffeurPK other = (ChauffeurPK) object;
        if (this.idutilisateur != other.idutilisateur) {
            return false;
        }
        if (this.idchauffeur != other.idchauffeur) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.ChauffeurPK[ idutilisateur=" + idutilisateur + ", idchauffeur=" + idchauffeur + " ]";
    }
    
}

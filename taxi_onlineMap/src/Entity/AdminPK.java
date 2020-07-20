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
public class AdminPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "idutilisateur")
    private int idutilisateur;
    @Basic(optional = false)
    @Column(name = "idadmin")
    private int idadmin;

    public AdminPK() {
    }

    public AdminPK(int idutilisateur, int idadmin) {
        this.idutilisateur = idutilisateur;
        this.idadmin = idadmin;
    }

    public int getIdutilisateur() {
        return idutilisateur;
    }

    public void setIdutilisateur(int idutilisateur) {
        this.idutilisateur = idutilisateur;
    }

    public int getIdadmin() {
        return idadmin;
    }

    public void setIdadmin(int idadmin) {
        this.idadmin = idadmin;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idutilisateur;
        hash += (int) idadmin;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdminPK)) {
            return false;
        }
        AdminPK other = (AdminPK) object;
        if (this.idutilisateur != other.idutilisateur) {
            return false;
        }
        if (this.idadmin != other.idadmin) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.AdminPK[ idutilisateur=" + idutilisateur + ", idadmin=" + idadmin + " ]";
    }
    
}

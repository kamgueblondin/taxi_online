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
public class ClientPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "idutilisateur")
    private int idutilisateur;
    @Basic(optional = false)
    @Column(name = "idclient")
    private int idclient;

    public ClientPK() {
    }

    public ClientPK(int idutilisateur, int idclient) {
        this.idutilisateur = idutilisateur;
        this.idclient = idclient;
    }

    public int getIdutilisateur() {
        return idutilisateur;
    }

    public void setIdutilisateur(int idutilisateur) {
        this.idutilisateur = idutilisateur;
    }

    public int getIdclient() {
        return idclient;
    }

    public void setIdclient(int idclient) {
        this.idclient = idclient;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idutilisateur;
        hash += (int) idclient;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClientPK)) {
            return false;
        }
        ClientPK other = (ClientPK) object;
        if (this.idutilisateur != other.idutilisateur) {
            return false;
        }
        if (this.idclient != other.idclient) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.ClientPK[ idutilisateur=" + idutilisateur + ", idclient=" + idclient + " ]";
    }
    
}

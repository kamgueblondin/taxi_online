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
public class ProprietairePK implements Serializable {
    @Basic(optional = false)
    @Column(name = "idutilisateur")
    private int idutilisateur;
    @Basic(optional = false)
    @Column(name = "idproprietaire")
    private int idproprietaire;

    public ProprietairePK() {
    }

    public ProprietairePK(int idutilisateur, int idproprietaire) {
        this.idutilisateur = idutilisateur;
        this.idproprietaire = idproprietaire;
    }

    public int getIdutilisateur() {
        return idutilisateur;
    }

    public void setIdutilisateur(int idutilisateur) {
        this.idutilisateur = idutilisateur;
    }

    public int getIdproprietaire() {
        return idproprietaire;
    }

    public void setIdproprietaire(int idproprietaire) {
        this.idproprietaire = idproprietaire;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idutilisateur;
        hash += (int) idproprietaire;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProprietairePK)) {
            return false;
        }
        ProprietairePK other = (ProprietairePK) object;
        if (this.idutilisateur != other.idutilisateur) {
            return false;
        }
        if (this.idproprietaire != other.idproprietaire) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.ProprietairePK[ idutilisateur=" + idutilisateur + ", idproprietaire=" + idproprietaire + " ]";
    }
    
}

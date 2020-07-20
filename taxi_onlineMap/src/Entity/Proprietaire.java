/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Blondin
 */
@Entity
@Table(name = "proprietaire")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proprietaire.findAll", query = "SELECT p FROM Proprietaire p"),
    @NamedQuery(name = "Proprietaire.findByIdutilisateur", query = "SELECT p FROM Proprietaire p WHERE p.proprietairePK.idutilisateur = :idutilisateur"),
    @NamedQuery(name = "Proprietaire.findByIdproprietaire", query = "SELECT p FROM Proprietaire p WHERE p.proprietairePK.idproprietaire = :idproprietaire")})
public class Proprietaire implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProprietairePK proprietairePK;
    @JoinColumns({
        @JoinColumn(name = "adm_idutilisateur", referencedColumnName = "idutilisateur"),
        @JoinColumn(name = "idadmin", referencedColumnName = "idadmin")})
    @ManyToOne(optional = false)
    private Admin admin;
    @JoinColumn(name = "idutilisateur", referencedColumnName = "idutilisateur", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Utilisateur utilisateur;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "proprietaire")
    private Collection<Taxi> taxiCollection;

    public Proprietaire() {
    }

    public Proprietaire(ProprietairePK proprietairePK) {
        this.proprietairePK = proprietairePK;
    }

    public Proprietaire(int idutilisateur, int idproprietaire) {
        this.proprietairePK = new ProprietairePK(idutilisateur, idproprietaire);
    }

    public ProprietairePK getProprietairePK() {
        return proprietairePK;
    }

    public void setProprietairePK(ProprietairePK proprietairePK) {
        this.proprietairePK = proprietairePK;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    @XmlTransient
    public Collection<Taxi> getTaxiCollection() {
        return taxiCollection;
    }

    public void setTaxiCollection(Collection<Taxi> taxiCollection) {
        this.taxiCollection = taxiCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (proprietairePK != null ? proprietairePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proprietaire)) {
            return false;
        }
        Proprietaire other = (Proprietaire) object;
        if ((this.proprietairePK == null && other.proprietairePK != null) || (this.proprietairePK != null && !this.proprietairePK.equals(other.proprietairePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Proprietaire[ proprietairePK=" + proprietairePK + " ]";
    }
    
}

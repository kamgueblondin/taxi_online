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
@Table(name = "admin")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Admin.findAll", query = "SELECT a FROM Admin a"),
    @NamedQuery(name = "Admin.findByIdutilisateur", query = "SELECT a FROM Admin a WHERE a.adminPK.idutilisateur = :idutilisateur"),
    @NamedQuery(name = "Admin.findByIdadmin", query = "SELECT a FROM Admin a WHERE a.adminPK.idadmin = :idadmin")})
public class Admin implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AdminPK adminPK;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "admin")
    private Collection<Proprietaire> proprietaireCollection;
    @JoinColumn(name = "idutilisateur", referencedColumnName = "idutilisateur", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Utilisateur utilisateur;

    public Admin() {
    }

    public Admin(AdminPK adminPK) {
        this.adminPK = adminPK;
    }

    public Admin(int idutilisateur, int idadmin) {
        this.adminPK = new AdminPK(idutilisateur, idadmin);
    }

    public AdminPK getAdminPK() {
        return adminPK;
    }

    public void setAdminPK(AdminPK adminPK) {
        this.adminPK = adminPK;
    }

    @XmlTransient
    public Collection<Proprietaire> getProprietaireCollection() {
        return proprietaireCollection;
    }

    public void setProprietaireCollection(Collection<Proprietaire> proprietaireCollection) {
        this.proprietaireCollection = proprietaireCollection;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adminPK != null ? adminPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Admin)) {
            return false;
        }
        Admin other = (Admin) object;
        if ((this.adminPK == null && other.adminPK != null) || (this.adminPK != null && !this.adminPK.equals(other.adminPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Admin[ adminPK=" + adminPK + " ]";
    }
    
}

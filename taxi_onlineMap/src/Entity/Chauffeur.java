/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
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
@Table(name = "chauffeur")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Chauffeur.findAll", query = "SELECT c FROM Chauffeur c"),
    @NamedQuery(name = "Chauffeur.findByIdutilisateur", query = "SELECT c FROM Chauffeur c WHERE c.chauffeurPK.idutilisateur = :idutilisateur"),
    @NamedQuery(name = "Chauffeur.findByIdchauffeur", query = "SELECT c FROM Chauffeur c WHERE c.chauffeurPK.idchauffeur = :idchauffeur"),
    @NamedQuery(name = "Chauffeur.findByPermis", query = "SELECT c FROM Chauffeur c WHERE c.permis = :permis"),
    @NamedQuery(name = "Chauffeur.findByCapacite", query = "SELECT c FROM Chauffeur c WHERE c.capacite = :capacite")})
public class Chauffeur implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ChauffeurPK chauffeurPK;
    @Column(name = "permis")
    private String permis;
    @Column(name = "capacite")
    private String capacite;
    @JoinColumn(name = "idutilisateur", referencedColumnName = "idutilisateur", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Utilisateur utilisateur;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "chauffeur")
    private Collection<Taxi> taxiCollection;

    public Chauffeur() {
    }

    public Chauffeur(ChauffeurPK chauffeurPK) {
        this.chauffeurPK = chauffeurPK;
    }

    public Chauffeur(int idutilisateur, int idchauffeur) {
        this.chauffeurPK = new ChauffeurPK(idutilisateur, idchauffeur);
    }

    public ChauffeurPK getChauffeurPK() {
        return chauffeurPK;
    }

    public void setChauffeurPK(ChauffeurPK chauffeurPK) {
        this.chauffeurPK = chauffeurPK;
    }

    public String getPermis() {
        return permis;
    }

    public void setPermis(String permis) {
        this.permis = permis;
    }

    public String getCapacite() {
        return capacite;
    }

    public void setCapacite(String capacite) {
        this.capacite = capacite;
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
        hash += (chauffeurPK != null ? chauffeurPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Chauffeur)) {
            return false;
        }
        Chauffeur other = (Chauffeur) object;
        if ((this.chauffeurPK == null && other.chauffeurPK != null) || (this.chauffeurPK != null && !this.chauffeurPK.equals(other.chauffeurPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Chauffeur[ chauffeurPK=" + chauffeurPK + " ]";
    }
    
}

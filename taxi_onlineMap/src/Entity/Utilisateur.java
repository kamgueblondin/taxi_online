/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "utilisateur")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Utilisateur.findAll", query = "SELECT u FROM Utilisateur u"),
    @NamedQuery(name = "Utilisateur.findByIdutilisateur", query = "SELECT u FROM Utilisateur u WHERE u.idutilisateur = :idutilisateur"),
    @NamedQuery(name = "Utilisateur.findByNom", query = "SELECT u FROM Utilisateur u WHERE u.nom = :nom"),
    @NamedQuery(name = "Utilisateur.findByPrenom", query = "SELECT u FROM Utilisateur u WHERE u.prenom = :prenom"),
    @NamedQuery(name = "Utilisateur.findByNumero", query = "SELECT u FROM Utilisateur u WHERE u.numero = :numero"),
    @NamedQuery(name = "Utilisateur.findByPassword", query = "SELECT u FROM Utilisateur u WHERE u.password = :password")})
public class Utilisateur implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idutilisateur")
    private Integer idutilisateur;
    @Column(name = "nom")
    private String nom;
    @Column(name = "prenom")
    private String prenom;
    @Column(name = "numero")
    private Integer numero;
    @Column(name = "password")
    private String password;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "utilisateur")
    private Collection<Proprietaire> proprietaireCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "utilisateur")
    private Collection<Chauffeur> chauffeurCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "utilisateur")
    private Collection<Admin> adminCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "utilisateur")
    private Collection<Client> clientCollection;

    public Utilisateur() {
    }

    public Utilisateur(Integer idutilisateur) {
        this.idutilisateur = idutilisateur;
    }

    public Integer getIdutilisateur() {
        return idutilisateur;
    }

    public void setIdutilisateur(Integer idutilisateur) {
        this.idutilisateur = idutilisateur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @XmlTransient
    public Collection<Proprietaire> getProprietaireCollection() {
        return proprietaireCollection;
    }

    public void setProprietaireCollection(Collection<Proprietaire> proprietaireCollection) {
        this.proprietaireCollection = proprietaireCollection;
    }

    @XmlTransient
    public Collection<Chauffeur> getChauffeurCollection() {
        return chauffeurCollection;
    }

    public void setChauffeurCollection(Collection<Chauffeur> chauffeurCollection) {
        this.chauffeurCollection = chauffeurCollection;
    }

    @XmlTransient
    public Collection<Admin> getAdminCollection() {
        return adminCollection;
    }

    public void setAdminCollection(Collection<Admin> adminCollection) {
        this.adminCollection = adminCollection;
    }

    @XmlTransient
    public Collection<Client> getClientCollection() {
        return clientCollection;
    }

    public void setClientCollection(Collection<Client> clientCollection) {
        this.clientCollection = clientCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idutilisateur != null ? idutilisateur.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Utilisateur)) {
            return false;
        }
        Utilisateur other = (Utilisateur) object;
        if ((this.idutilisateur == null && other.idutilisateur != null) || (this.idutilisateur != null && !this.idutilisateur.equals(other.idutilisateur))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Utilisateur[ idutilisateur=" + idutilisateur + " ]";
    }
    
}

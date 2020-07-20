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
@Table(name = "taxi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Taxi.findAll", query = "SELECT t FROM Taxi t"),
    @NamedQuery(name = "Taxi.findByIdtaxi", query = "SELECT t FROM Taxi t WHERE t.idtaxi = :idtaxi"),
    @NamedQuery(name = "Taxi.findByAssurance", query = "SELECT t FROM Taxi t WHERE t.assurance = :assurance"),
    @NamedQuery(name = "Taxi.findByNombreplace", query = "SELECT t FROM Taxi t WHERE t.nombreplace = :nombreplace"),
    @NamedQuery(name = "Taxi.findByClim", query = "SELECT t FROM Taxi t WHERE t.clim = :clim"),
    @NamedQuery(name = "Taxi.findByNumeroporte", query = "SELECT t FROM Taxi t WHERE t.numeroporte = :numeroporte")})
public class Taxi implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtaxi")
    private Integer idtaxi;
    @Column(name = "assurance")
    private String assurance;
    @Column(name = "nombreplace")
    private Integer nombreplace;
    @Column(name = "clim")
    private Boolean clim;
    @Column(name = "numeroporte")
    private Integer numeroporte;
    @JoinColumn(name = "idcar", referencedColumnName = "idcar")
    @ManyToOne(optional = false)
    private Car idcar;
    @JoinColumns({
        @JoinColumn(name = "idutilisateur", referencedColumnName = "idutilisateur"),
        @JoinColumn(name = "idchauffeur", referencedColumnName = "idchauffeur")})
    @ManyToOne(optional = false)
    private Chauffeur chauffeur;
    @JoinColumns({
        @JoinColumn(name = "pro_idutilisateur", referencedColumnName = "idutilisateur"),
        @JoinColumn(name = "idproprietaire", referencedColumnName = "idproprietaire")})
    @ManyToOne(optional = false)
    private Proprietaire proprietaire;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtaxi")
    private Collection<Reservation> reservationCollection;

    public Taxi() {
    }

    public Taxi(Integer idtaxi) {
        this.idtaxi = idtaxi;
    }

    public Integer getIdtaxi() {
        return idtaxi;
    }

    public void setIdtaxi(Integer idtaxi) {
        this.idtaxi = idtaxi;
    }

    public String getAssurance() {
        return assurance;
    }

    public void setAssurance(String assurance) {
        this.assurance = assurance;
    }

    public Integer getNombreplace() {
        return nombreplace;
    }

    public void setNombreplace(Integer nombreplace) {
        this.nombreplace = nombreplace;
    }

    public Boolean getClim() {
        return clim;
    }

    public void setClim(Boolean clim) {
        this.clim = clim;
    }

    public Integer getNumeroporte() {
        return numeroporte;
    }

    public void setNumeroporte(Integer numeroporte) {
        this.numeroporte = numeroporte;
    }

    public Car getIdcar() {
        return idcar;
    }

    public void setIdcar(Car idcar) {
        this.idcar = idcar;
    }

    public Chauffeur getChauffeur() {
        return chauffeur;
    }

    public void setChauffeur(Chauffeur chauffeur) {
        this.chauffeur = chauffeur;
    }

    public Proprietaire getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(Proprietaire proprietaire) {
        this.proprietaire = proprietaire;
    }

    @XmlTransient
    public Collection<Reservation> getReservationCollection() {
        return reservationCollection;
    }

    public void setReservationCollection(Collection<Reservation> reservationCollection) {
        this.reservationCollection = reservationCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtaxi != null ? idtaxi.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Taxi)) {
            return false;
        }
        Taxi other = (Taxi) object;
        if ((this.idtaxi == null && other.idtaxi != null) || (this.idtaxi != null && !this.idtaxi.equals(other.idtaxi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Taxi[ idtaxi=" + idtaxi + " ]";
    }
    
}

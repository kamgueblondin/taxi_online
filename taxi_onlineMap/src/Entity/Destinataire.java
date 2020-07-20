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
@Table(name = "destinataire")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Destinataire.findAll", query = "SELECT d FROM Destinataire d"),
    @NamedQuery(name = "Destinataire.findByIddestination", query = "SELECT d FROM Destinataire d WHERE d.iddestination = :iddestination"),
    @NamedQuery(name = "Destinataire.findByDesignation", query = "SELECT d FROM Destinataire d WHERE d.designation = :designation"),
    @NamedQuery(name = "Destinataire.findByReference", query = "SELECT d FROM Destinataire d WHERE d.reference = :reference"),
    @NamedQuery(name = "Destinataire.findByLongitude", query = "SELECT d FROM Destinataire d WHERE d.longitude = :longitude"),
    @NamedQuery(name = "Destinataire.findByLatitude", query = "SELECT d FROM Destinataire d WHERE d.latitude = :latitude")})
public class Destinataire implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iddestination")
    private Integer iddestination;
    @Column(name = "designation")
    private String designation;
    @Column(name = "reference")
    private String reference;
    @Column(name = "longitude")
    private String longitude;
    @Column(name = "latitude")
    private String latitude;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iddestination")
    private Collection<Reservation> reservationCollection;

    public Destinataire() {
    }

    public Destinataire(Integer iddestination) {
        this.iddestination = iddestination;
    }

    public Integer getIddestination() {
        return iddestination;
    }

    public void setIddestination(Integer iddestination) {
        this.iddestination = iddestination;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
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
        hash += (iddestination != null ? iddestination.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Destinataire)) {
            return false;
        }
        Destinataire other = (Destinataire) object;
        if ((this.iddestination == null && other.iddestination != null) || (this.iddestination != null && !this.iddestination.equals(other.iddestination))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Destinataire[ iddestination=" + iddestination + " ]";
    }
    
}

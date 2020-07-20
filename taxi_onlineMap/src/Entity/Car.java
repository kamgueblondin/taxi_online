/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Blondin
 */
@Entity
@Table(name = "car")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Car.findAll", query = "SELECT c FROM Car c"),
    @NamedQuery(name = "Car.findByIdcar", query = "SELECT c FROM Car c WHERE c.idcar = :idcar"),
    @NamedQuery(name = "Car.findByImmatriculation", query = "SELECT c FROM Car c WHERE c.immatriculation = :immatriculation"),
    @NamedQuery(name = "Car.findByMarque", query = "SELECT c FROM Car c WHERE c.marque = :marque"),
    @NamedQuery(name = "Car.findByPortiere", query = "SELECT c FROM Car c WHERE c.portiere = :portiere"),
    @NamedQuery(name = "Car.findByDateacquis", query = "SELECT c FROM Car c WHERE c.dateacquis = :dateacquis")})
public class Car implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcar")
    private Integer idcar;
    @Column(name = "immatriculation")
    private String immatriculation;
    @Column(name = "marque")
    private String marque;
    @Column(name = "portiere")
    private Integer portiere;
    @Column(name = "dateacquis")
    @Temporal(TemporalType.DATE)
    private Date dateacquis;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcar")
    private Collection<Taxi> taxiCollection;

    public Car() {
    }

    public Car(Integer idcar) {
        this.idcar = idcar;
    }

    public Integer getIdcar() {
        return idcar;
    }

    public void setIdcar(Integer idcar) {
        this.idcar = idcar;
    }

    public String getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public Integer getPortiere() {
        return portiere;
    }

    public void setPortiere(Integer portiere) {
        this.portiere = portiere;
    }

    public Date getDateacquis() {
        return dateacquis;
    }

    public void setDateacquis(Date dateacquis) {
        this.dateacquis = dateacquis;
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
        hash += (idcar != null ? idcar.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Car)) {
            return false;
        }
        Car other = (Car) object;
        if ((this.idcar == null && other.idcar != null) || (this.idcar != null && !this.idcar.equals(other.idcar))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Car[ idcar=" + idcar + " ]";
    }
    
}

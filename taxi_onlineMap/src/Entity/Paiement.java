/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Blondin
 */
@Entity
@Table(name = "paiement")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Paiement.findAll", query = "SELECT p FROM Paiement p"),
    @NamedQuery(name = "Paiement.findByIdpaiement", query = "SELECT p FROM Paiement p WHERE p.idpaiement = :idpaiement"),
    @NamedQuery(name = "Paiement.findByType", query = "SELECT p FROM Paiement p WHERE p.type = :type"),
    @NamedQuery(name = "Paiement.findByDate", query = "SELECT p FROM Paiement p WHERE p.date = :date"),
    @NamedQuery(name = "Paiement.findByRef", query = "SELECT p FROM Paiement p WHERE p.ref = :ref")})
public class Paiement implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpaiement")
    private Integer idpaiement;
    @Column(name = "type")
    private String type;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Column(name = "ref")
    private String ref;
    @JoinColumn(name = "idreservation", referencedColumnName = "idreservation")
    @ManyToOne(optional = false)
    private Reservation idreservation;

    public Paiement() {
    }

    public Paiement(Integer idpaiement) {
        this.idpaiement = idpaiement;
    }

    public Integer getIdpaiement() {
        return idpaiement;
    }

    public void setIdpaiement(Integer idpaiement) {
        this.idpaiement = idpaiement;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public Reservation getIdreservation() {
        return idreservation;
    }

    public void setIdreservation(Reservation idreservation) {
        this.idreservation = idreservation;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpaiement != null ? idpaiement.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paiement)) {
            return false;
        }
        Paiement other = (Paiement) object;
        if ((this.idpaiement == null && other.idpaiement != null) || (this.idpaiement != null && !this.idpaiement.equals(other.idpaiement))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Paiement[ idpaiement=" + idpaiement + " ]";
    }
    
}

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
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
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
@Table(name = "reservation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reservation.findAll", query = "SELECT r FROM Reservation r"),
    @NamedQuery(name = "Reservation.findByIdreservation", query = "SELECT r FROM Reservation r WHERE r.idreservation = :idreservation"),
    @NamedQuery(name = "Reservation.findByDatedebut", query = "SELECT r FROM Reservation r WHERE r.datedebut = :datedebut"),
    @NamedQuery(name = "Reservation.findByEtat", query = "SELECT r FROM Reservation r WHERE r.etat = :etat"),
    @NamedQuery(name = "Reservation.findByCode", query = "SELECT r FROM Reservation r WHERE r.code = :code"),
    @NamedQuery(name = "Reservation.findByMontant", query = "SELECT r FROM Reservation r WHERE r.montant = :montant")})
public class Reservation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idreservation")
    private Integer idreservation;
    @Column(name = "datedebut")
    @Temporal(TemporalType.DATE)
    private Date datedebut;
    @Column(name = "etat")
    private String etat;
    @Column(name = "code")
    private String code;
    @Column(name = "montant")
    private Integer montant;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idreservation")
    private Collection<Paiement> paiementCollection;
    @JoinColumns({
        @JoinColumn(name = "idutilisateur", referencedColumnName = "idutilisateur"),
        @JoinColumn(name = "idclient", referencedColumnName = "idclient")})
    @ManyToOne(optional = false)
    private Client client;
    @JoinColumn(name = "iddestination", referencedColumnName = "iddestination")
    @ManyToOne(optional = false)
    private Destinataire iddestination;
    @JoinColumn(name = "idtaxi", referencedColumnName = "idtaxi")
    @ManyToOne(optional = false)
    private Taxi idtaxi;

    public Reservation() {
    }

    public Reservation(Integer idreservation) {
        this.idreservation = idreservation;
    }

    public Integer getIdreservation() {
        return idreservation;
    }

    public void setIdreservation(Integer idreservation) {
        this.idreservation = idreservation;
    }

    public Date getDatedebut() {
        return datedebut;
    }

    public void setDatedebut(Date datedebut) {
        this.datedebut = datedebut;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getMontant() {
        return montant;
    }

    public void setMontant(Integer montant) {
        this.montant = montant;
    }

    @XmlTransient
    public Collection<Paiement> getPaiementCollection() {
        return paiementCollection;
    }

    public void setPaiementCollection(Collection<Paiement> paiementCollection) {
        this.paiementCollection = paiementCollection;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Destinataire getIddestination() {
        return iddestination;
    }

    public void setIddestination(Destinataire iddestination) {
        this.iddestination = iddestination;
    }

    public Taxi getIdtaxi() {
        return idtaxi;
    }

    public void setIdtaxi(Taxi idtaxi) {
        this.idtaxi = idtaxi;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idreservation != null ? idreservation.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reservation)) {
            return false;
        }
        Reservation other = (Reservation) object;
        if ((this.idreservation == null && other.idreservation != null) || (this.idreservation != null && !this.idreservation.equals(other.idreservation))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Reservation[ idreservation=" + idreservation + " ]";
    }
    
}

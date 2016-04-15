/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Edmond
 */
@Entity
@Table(name = "Adresa", catalog = "SpitaliDB", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Adresa.findAll", query = "SELECT a FROM Adresa a"),
    @NamedQuery(name = "Adresa.findById", query = "SELECT a FROM Adresa a WHERE a.id = :id"),
    @NamedQuery(name = "Adresa.findByQyteti", query = "SELECT a FROM Adresa a WHERE a.qyteti = :qyteti"),
    @NamedQuery(name = "Adresa.findByShteti", query = "SELECT a FROM Adresa a WHERE a.shteti = :shteti"),
    @NamedQuery(name = "Adresa.findByRuga", query = "SELECT a FROM Adresa a WHERE a.ruga = :ruga"),
    @NamedQuery(name = "Adresa.findByNumri", query = "SELECT a FROM Adresa a WHERE a.numri = :numri")})
public class Adresa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Integer id;
    @Column(name = "qyteti", length = 80)
    private String qyteti;
    @Column(name = "shteti", length = 80)
    private String shteti;
    @Column(name = "ruga", length = 80)
    private String ruga;
    @Column(name = "numri")
    private Integer numri;
    @JoinColumn(name = "Doktori_ID", referencedColumnName = "ID")
    @ManyToOne
    private Doktori doktoriID;
    @JoinColumn(name = "Farmacisti_ID", referencedColumnName = "ID")
    @ManyToOne
    private Farmacisti farmacistiID;
    @JoinColumn(name = "Motra_ID", referencedColumnName = "ID")
    @ManyToOne
    private Motra motraID;
    @JoinColumn(name = "Pacienti_ID", referencedColumnName = "ID")
    @ManyToOne
    private Pacienti pacientiID;
    @JoinColumn(name = "Puntori_ID", referencedColumnName = "ID")
    @ManyToOne
    private Puntori puntoriID;
    @JoinColumn(name = "Rescepsionisti_ID", referencedColumnName = "ID")
    @ManyToOne
    private Rescepsionisti rescepsionistiID;

    public Adresa() {
    }

    public Adresa(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQyteti() {
        return qyteti;
    }

    public void setQyteti(String qyteti) {
        this.qyteti = qyteti;
    }

    public String getShteti() {
        return shteti;
    }

    public void setShteti(String shteti) {
        this.shteti = shteti;
    }

    public String getRuga() {
        return ruga;
    }

    public void setRuga(String ruga) {
        this.ruga = ruga;
    }

    public Integer getNumri() {
        return numri;
    }

    public void setNumri(Integer numri) {
        this.numri = numri;
    }

    public Doktori getDoktoriID() {
        return doktoriID;
    }

    public void setDoktoriID(Doktori doktoriID) {
        this.doktoriID = doktoriID;
    }

    public Farmacisti getFarmacistiID() {
        return farmacistiID;
    }

    public void setFarmacistiID(Farmacisti farmacistiID) {
        this.farmacistiID = farmacistiID;
    }

    public Motra getMotraID() {
        return motraID;
    }

    public void setMotraID(Motra motraID) {
        this.motraID = motraID;
    }

    public Pacienti getPacientiID() {
        return pacientiID;
    }

    public void setPacientiID(Pacienti pacientiID) {
        this.pacientiID = pacientiID;
    }

    public Puntori getPuntoriID() {
        return puntoriID;
    }

    public void setPuntoriID(Puntori puntoriID) {
        this.puntoriID = puntoriID;
    }

    public Rescepsionisti getRescepsionistiID() {
        return rescepsionistiID;
    }

    public void setRescepsionistiID(Rescepsionisti rescepsionistiID) {
        this.rescepsionistiID = rescepsionistiID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Adresa)) {
            return false;
        }
        Adresa other = (Adresa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EJB.Adresa[ id=" + id + " ]";
    }
    
}

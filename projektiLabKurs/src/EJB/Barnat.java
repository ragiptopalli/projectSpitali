/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
 * @author Edmond
 */
@Entity
@Table(name = "Barnat", catalog = "SpitaliDB", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Barnat.findAll", query = "SELECT b FROM Barnat b"),
    @NamedQuery(name = "Barnat.findById", query = "SELECT b FROM Barnat b WHERE b.id = :id"),
    @NamedQuery(name = "Barnat.findByEmri", query = "SELECT b FROM Barnat b WHERE b.emri = :emri"),
    @NamedQuery(name = "Barnat.findByDataSkadimit", query = "SELECT b FROM Barnat b WHERE b.dataSkadimit = :dataSkadimit"),
    @NamedQuery(name = "Barnat.findByCmimi", query = "SELECT b FROM Barnat b WHERE b.cmimi = :cmimi"),
    @NamedQuery(name = "Barnat.findByPershkrimiKomponenteve", query = "SELECT b FROM Barnat b WHERE b.pershkrimiKomponenteve = :pershkrimiKomponenteve")})
public class Barnat implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Integer id;
    @Column(name = "emri", length = 70)
    private String emri;
    @Column(name = "data_skadimit")
    @Temporal(TemporalType.DATE)
    private Date dataSkadimit;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cmimi", precision = 53)
    private Double cmimi;
    @Column(name = "pershkrimi_komponenteve", length = 250)
    private String pershkrimiKomponenteve;
    @JoinColumn(name = "Farmacisti_ID", referencedColumnName = "ID")
    @ManyToOne
    private Farmacisti farmacistiID;
    @JoinColumn(name = "Fatura_ID", referencedColumnName = "ID")
    @ManyToOne
    private FaturaPacientit faturaID;

    public Barnat() {
    }

    public Barnat(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmri() {
        return emri;
    }

    public void setEmri(String emri) {
        this.emri = emri;
    }

    public Date getDataSkadimit() {
        return dataSkadimit;
    }

    public void setDataSkadimit(Date dataSkadimit) {
        this.dataSkadimit = dataSkadimit;
    }

    public Double getCmimi() {
        return cmimi;
    }

    public void setCmimi(Double cmimi) {
        this.cmimi = cmimi;
    }

    public String getPershkrimiKomponenteve() {
        return pershkrimiKomponenteve;
    }

    public void setPershkrimiKomponenteve(String pershkrimiKomponenteve) {
        this.pershkrimiKomponenteve = pershkrimiKomponenteve;
    }

    public Farmacisti getFarmacistiID() {
        return farmacistiID;
    }

    public void setFarmacistiID(Farmacisti farmacistiID) {
        this.farmacistiID = farmacistiID;
    }

    public FaturaPacientit getFaturaID() {
        return faturaID;
    }

    public void setFaturaID(FaturaPacientit faturaID) {
        this.faturaID = faturaID;
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
        if (!(object instanceof Barnat)) {
            return false;
        }
        Barnat other = (Barnat) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EJB.Barnat[ id=" + id + " ]";
    }
    
}

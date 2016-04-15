/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
 * @author Edmond
 */
@Entity
@Table(name = "Dhoma_Pacientit", catalog = "SpitaliDB", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DhomaPacientit.findAll", query = "SELECT d FROM DhomaPacientit d"),
    @NamedQuery(name = "DhomaPacientit.findById", query = "SELECT d FROM DhomaPacientit d WHERE d.id = :id"),
    @NamedQuery(name = "DhomaPacientit.findByDataPrej", query = "SELECT d FROM DhomaPacientit d WHERE d.dataPrej = :dataPrej"),
    @NamedQuery(name = "DhomaPacientit.findByDataDeri", query = "SELECT d FROM DhomaPacientit d WHERE d.dataDeri = :dataDeri")})
public class DhomaPacientit implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Integer id;
    @Column(name = "data_prej")
    @Temporal(TemporalType.DATE)
    private Date dataPrej;
    @Column(name = "data_deri")
    @Temporal(TemporalType.DATE)
    private Date dataDeri;
    @JoinColumn(name = "sektori_ID", referencedColumnName = "ID")
    @ManyToOne
    private Sektori sektoriID;
    @OneToMany(mappedBy = "iDdhoma")
    private Collection<Pacienti> pacientiCollection;

    public DhomaPacientit() {
    }

    public DhomaPacientit(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataPrej() {
        return dataPrej;
    }

    public void setDataPrej(Date dataPrej) {
        this.dataPrej = dataPrej;
    }

    public Date getDataDeri() {
        return dataDeri;
    }

    public void setDataDeri(Date dataDeri) {
        this.dataDeri = dataDeri;
    }

    public Sektori getSektoriID() {
        return sektoriID;
    }

    public void setSektoriID(Sektori sektoriID) {
        this.sektoriID = sektoriID;
    }

    @XmlTransient
    public Collection<Pacienti> getPacientiCollection() {
        return pacientiCollection;
    }

    public void setPacientiCollection(Collection<Pacienti> pacientiCollection) {
        this.pacientiCollection = pacientiCollection;
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
        if (!(object instanceof DhomaPacientit)) {
            return false;
        }
        DhomaPacientit other = (DhomaPacientit) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EJB.DhomaPacientit[ id=" + id + " ]";
    }
    
}

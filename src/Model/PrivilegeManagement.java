/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author abouf
 */
@Entity
@Table(name = "privilege_management")
@SecondaryTables( {
    @SecondaryTable(name = "privilege", pkJoinColumns = {
        @PrimaryKeyJoinColumn(name = "ID_Privilege", referencedColumnName = "ID_Privilege_FK") }),
    @SecondaryTable(name = "privilege", pkJoinColumns = {
        @PrimaryKeyJoinColumn(name = "ID_Privilege", referencedColumnName = "ID_Privilege_FK") }),    
})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrivilegeManagement.findAll", query = "SELECT p FROM PrivilegeManagement p")
    , @NamedQuery(name = "PrivilegeManagement.findByIDPrivilegeM", query = "SELECT p FROM PrivilegeManagement p WHERE p.iDPrivilegeM = :iDPrivilegeM")
    , @NamedQuery(name = "PrivilegeManagement.findByIDAdminFK", query = "SELECT p FROM PrivilegeManagement p WHERE p.iDAdminFK = :iDAdminFK")
    , @NamedQuery(name = "PrivilegeManagement.findByIDSPriviFK", query = "SELECT p FROM PrivilegeManagement p WHERE p.iDSPriviFK = :iDSPriviFK")
    , @NamedQuery(name = "PrivilegeManagement.findByDroit", query = "SELECT p FROM PrivilegeManagement p WHERE p.droit = :droit")})
public class PrivilegeManagement implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_Privilege_M")
    private Integer iDPrivilegeM;
    @Basic(optional = false)
    @Column(name = "ID_Admin_FK")
    private int iDAdminFK;
    @Basic(optional = false)
    @Column(name = "ID_SPrivi_FK")
    private int iDSPriviFK;

    public PrivilegeManagement() {
    }

    public PrivilegeManagement(Integer iDPrivilegeM) {
        this.iDPrivilegeM = iDPrivilegeM;
    }

    public PrivilegeManagement(Integer iDPrivilegeM, int iDAdminFK, int iDSPriviFK) {
        this.iDPrivilegeM = iDPrivilegeM;
        this.iDAdminFK = iDAdminFK;
        this.iDSPriviFK = iDSPriviFK;
    }

    public Integer getIDPrivilegeM() {
        return iDPrivilegeM;
    }

    public void setIDPrivilegeM(Integer iDPrivilegeM) {
        this.iDPrivilegeM = iDPrivilegeM;
    }

    public int getIDAdminFK() {
        return iDAdminFK;
    }

    public void setIDAdminFK(int iDAdminFK) {
        this.iDAdminFK = iDAdminFK;
    }

    public int getIDSPriviFK() {
        return iDSPriviFK;
    }

    public void setIDSPriviFK(int iDSPriviFK) {
        this.iDSPriviFK = iDSPriviFK;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDPrivilegeM != null ? iDPrivilegeM.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrivilegeManagement)) {
            return false;
        }
        PrivilegeManagement other = (PrivilegeManagement) object;
        if ((this.iDPrivilegeM == null && other.iDPrivilegeM != null) || (this.iDPrivilegeM != null && !this.iDPrivilegeM.equals(other.iDPrivilegeM))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.PrivilegeManagement[ iDPrivilegeM=" + iDPrivilegeM + " ]";
    }
    
}

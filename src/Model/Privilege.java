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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "sous_privilege")
@SecondaryTables( {
    @SecondaryTable(name = "privilege", pkJoinColumns = {
        @PrimaryKeyJoinColumn(name = "ID_Privilege", referencedColumnName = "ID_Privilege_FK") })
        
})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Privilege.findAll", query = "SELECT p FROM Privilege p")
    , @NamedQuery(name = "Privilege.findByIDSousPrivilege", query = "SELECT p FROM Privilege p WHERE p.iDSousPrivilege = :iDSousPrivilege")
    , @NamedQuery(name = "Privilege.findByTitreSPivefr", query = "SELECT p FROM Privilege p WHERE p.titreSPivefr = :titreSPivefr")
    , @NamedQuery(name = "Privilege.findByTitreSPivear", query = "SELECT p FROM Privilege p WHERE p.titreSPivear = :titreSPivear")
    , @NamedQuery(name = "Privilege.findByIDPrivilegeFK", query = "SELECT p FROM Privilege p WHERE p.iDPrivilegeFK = :iDPrivilegeFK")})
public class Privilege implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_Sous_Privilege")
    private Integer iDSousPrivilege;
    @Basic(optional = false)
    @Column(name = "Titre_SPive_fr")
    private String titreSPivefr;
    @Basic(optional = false)
    @Column(name = "Titre_SPive_ar")
    private String titreSPivear;
    @Basic(optional = false)
    @Column(name = "ID_Privilege_FK")
    private int iDPrivilegeFK;
    @Column(name="ID_Privilege", table="privilege")
    private int rootID;
    @Column(name="Titre_Priv_fr", table="privilege")
    private String rootTitlePrivilegeFr;
    @Column(name="Titre_Priv_ar", table="privilege")
    private String rootTitlePrivilegeAr;
    public Privilege() {
    }

    public Privilege(Integer iDSousPrivilege) {
        this.iDSousPrivilege = iDSousPrivilege;
    }

    public Privilege(Integer iDSousPrivilege, String titreSPivefr, String titreSPivear, int iDPrivilegeFK, int rootID, String rootTitlePrivilegeFr, String rootTitlePrivilegeAr) {
        this.iDSousPrivilege = iDSousPrivilege;
        this.titreSPivefr = titreSPivefr;
        this.titreSPivear = titreSPivear;
        this.iDPrivilegeFK = iDPrivilegeFK;
        this.rootID = rootID;
        this.rootTitlePrivilegeFr = rootTitlePrivilegeFr;
        this.rootTitlePrivilegeAr = rootTitlePrivilegeAr;
    }

    
    public Integer getIDSousPrivilege() {
        return iDSousPrivilege;
    }

    public void setIDSousPrivilege(Integer iDSousPrivilege) {
        this.iDSousPrivilege = iDSousPrivilege;
    }

    public String getTitreSPivefr() {
        return titreSPivefr;
    }

    public void setTitreSPivefr(String titreSPivefr) {
        this.titreSPivefr = titreSPivefr;
    }

    public String getTitreSPivear() {
        return titreSPivear;
    }

    public void setTitreSPivear(String titreSPivear) {
        this.titreSPivear = titreSPivear;
    }

  

    public Integer getiDSousPrivilege() {
        return iDSousPrivilege;
    }

    public void setiDSousPrivilege(Integer iDSousPrivilege) {
        this.iDSousPrivilege = iDSousPrivilege;
    }

    public int getiDPrivilegeFK() {
        return iDPrivilegeFK;
    }

    public void setiDPrivilegeFK(int iDPrivilegeFK) {
        this.iDPrivilegeFK = iDPrivilegeFK;
    }

    public int getRootID() {
        return rootID;
    }

    public void setRootID(int rootID) {
        this.rootID = rootID;
    }

    public String getRootTitlePrivilegeFr() {
        return rootTitlePrivilegeFr;
    }

    public void setRootTitlePrivilegeFr(String rootTitlePrivilegeFr) {
        this.rootTitlePrivilegeFr = rootTitlePrivilegeFr;
    }

    public String getRootTitlePrivilegeAr() {
        return rootTitlePrivilegeAr;
    }

    public void setRootTitlePrivilegeAr(String rootTitlePrivilegeAr) {
        this.rootTitlePrivilegeAr = rootTitlePrivilegeAr;
    }

    

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDSousPrivilege != null ? iDSousPrivilege.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Privilege)) {
            return false;
        }
        Privilege other = (Privilege) object;
        if ((this.iDSousPrivilege == null && other.iDSousPrivilege != null) || (this.iDSousPrivilege != null && !this.iDSousPrivilege.equals(other.iDSousPrivilege))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Privilege[ iDSousPrivilege=" + iDSousPrivilege + " ]";
    }
    
}

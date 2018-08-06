/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author abouf
 */
@Entity
@Table(name = "utilisateur")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Utilisateur.findAll", query = "SELECT u FROM Utilisateur u")
    , @NamedQuery(name = "Utilisateur.findByIDAdmin", query = "SELECT u FROM Utilisateur u WHERE u.iDAdmin = :iDAdmin")
    , @NamedQuery(name = "Utilisateur.findByNumInscription", query = "SELECT u FROM Utilisateur u WHERE u.numInscription = :numInscription")
    , @NamedQuery(name = "Utilisateur.findByDateInscription", query = "SELECT u FROM Utilisateur u WHERE u.dateInscription = :dateInscription")
    , @NamedQuery(name = "Utilisateur.findByNom", query = "SELECT u FROM Utilisateur u WHERE u.nom = :nom")
    , @NamedQuery(name = "Utilisateur.findByPrenom", query = "SELECT u FROM Utilisateur u WHERE u.prenom = :prenom")
    , @NamedQuery(name = "Utilisateur.findByNomAr", query = "SELECT u FROM Utilisateur u WHERE u.nomAr = :nomAr")
    , @NamedQuery(name = "Utilisateur.findByPrenomAr", query = "SELECT u FROM Utilisateur u WHERE u.prenomAr = :prenomAr")
    , @NamedQuery(name = "Utilisateur.findBySexe", query = "SELECT u FROM Utilisateur u WHERE u.sexe = :sexe")
    , @NamedQuery(name = "Utilisateur.findByLieuNaissance", query = "SELECT u FROM Utilisateur u WHERE u.lieuNaissance = :lieuNaissance")
    , @NamedQuery(name = "Utilisateur.findByDateDeNaissance", query = "SELECT u FROM Utilisateur u WHERE u.dateDeNaissance = :dateDeNaissance")
    , @NamedQuery(name = "Utilisateur.findByNationalite", query = "SELECT u FROM Utilisateur u WHERE u.nationalite = :nationalite")
    , @NamedQuery(name = "Utilisateur.findByAdresse", query = "SELECT u FROM Utilisateur u WHERE u.adresse = :adresse")
    , @NamedQuery(name = "Utilisateur.findByPhoto", query = "SELECT u FROM Utilisateur u WHERE u.photo = :photo")
    , @NamedQuery(name = "Utilisateur.findByEmail", query = "SELECT u FROM Utilisateur u WHERE u.email = :email")
    , @NamedQuery(name = "Utilisateur.findByPassword", query = "SELECT u FROM Utilisateur u WHERE u.password = :password")
    , @NamedQuery(name = "Utilisateur.findByRole", query = "SELECT u FROM Utilisateur u WHERE u.role = :role")
    , @NamedQuery(name = "Utilisateur.findByLastConnect", query = "SELECT u FROM Utilisateur u WHERE u.lastConnect = :lastConnect")})
public class Utilisateur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_Admin")
    private Integer iDAdmin;
    @Basic(optional = false)
    @Column(name = "Num_Inscription")
    private String numInscription;
    @Column(name = "Date_Inscription")
    @Temporal(TemporalType.DATE)
    private Date dateInscription;
    @Basic(optional = false)
    @Column(name = "Nom")
    private String nom;
    @Basic(optional = false)
    @Column(name = "Prenom")
    private String prenom;
    @Basic(optional = false)
    @Column(name = "NomAr")
    private String nomAr;
    @Basic(optional = false)
    @Column(name = "PrenomAr")
    private String prenomAr;
    @Basic(optional = false)
    @Column(name = "Sexe")
    private String sexe;
    @Basic(optional = false)
    @Column(name = "LieuNaissance")
    private String lieuNaissance;
    @Column(name = "DateDeNaissance")
    @Temporal(TemporalType.DATE)
    private Date dateDeNaissance;
    @Basic(optional = false)
    @Column(name = "Nationalite")
    private String nationalite;
    @Basic(optional = false)
    @Column(name = "Adresse")
    private String adresse;
    @Basic(optional = false)
    @Column(name = "Photo")
    private String photo;
    @Basic(optional = false)
    @Column(name = "Email")
    private String email;
    @Basic(optional = false)
    @Column(name = "Password")
    private String password;
    @Basic(optional = false)
    @Column(name = "Role")
    private String role;
    @Basic(optional = false)
    @Column(name = "Last_Connect")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastConnect;

    public Utilisateur() {
    }

    public Utilisateur(Integer iDAdmin) {
        this.iDAdmin = iDAdmin;
    }

    public Utilisateur(Integer iDAdmin, String numInscription, String nom, String prenom, String nomAr, String prenomAr, String sexe, String lieuNaissance, String nationalite, String adresse, String photo, String email, String password, String role, Date lastConnect) {
        this.iDAdmin = iDAdmin;
        this.numInscription = numInscription;
        this.nom = nom;
        this.prenom = prenom;
        this.nomAr = nomAr;
        this.prenomAr = prenomAr;
        this.sexe = sexe;
        this.lieuNaissance = lieuNaissance;
        this.nationalite = nationalite;
        this.adresse = adresse;
        this.photo = photo;
        this.email = email;
        this.password = password;
        this.role = role;
        this.lastConnect = lastConnect;
    }

    public Integer getIDAdmin() {
        return iDAdmin;
    }

    public void setIDAdmin(Integer iDAdmin) {
        this.iDAdmin = iDAdmin;
    }

    public String getNumInscription() {
        return numInscription;
    }

    public void setNumInscription(String numInscription) {
        this.numInscription = numInscription;
    }

    public Date getDateInscription() {
        return dateInscription;
    }

    public void setDateInscription(Date dateInscription) {
        this.dateInscription = dateInscription;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNomAr() {
        return nomAr;
    }

    public void setNomAr(String nomAr) {
        this.nomAr = nomAr;
    }

    public String getPrenomAr() {
        return prenomAr;
    }

    public void setPrenomAr(String prenomAr) {
        this.prenomAr = prenomAr;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getLieuNaissance() {
        return lieuNaissance;
    }

    public void setLieuNaissance(String lieuNaissance) {
        this.lieuNaissance = lieuNaissance;
    }

    public Date getDateDeNaissance() {
        return dateDeNaissance;
    }

    public void setDateDeNaissance(Date dateDeNaissance) {
        this.dateDeNaissance = dateDeNaissance;
    }

    public String getNationalite() {
        return nationalite;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Date getLastConnect() {
        return lastConnect;
    }

    public void setLastConnect(Date lastConnect) {
        this.lastConnect = lastConnect;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDAdmin != null ? iDAdmin.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Utilisateur)) {
            return false;
        }
        Utilisateur other = (Utilisateur) object;
        if ((this.iDAdmin == null && other.iDAdmin != null) || (this.iDAdmin != null && !this.iDAdmin.equals(other.iDAdmin))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Utilisateur[ iDAdmin=" + iDAdmin + " ]";
    }
    
}

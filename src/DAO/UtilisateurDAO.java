/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import JPAController.UtilisateurJpaController;
import JPAController.exceptions.NonexistentEntityException;
import Model.Utilisateur;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NamedQuery;
import javax.persistence.Persistence;

/**
 *
 * @author abouf
 */
public class UtilisateurDAO {
    private final UtilisateurJpaController utilisateurJpaController;
    private EntityManagerFactory emf; 
    
    
    public UtilisateurDAO() {
        emf = Persistence.createEntityManagerFactory("smsPU");
        utilisateurJpaController = new UtilisateurJpaController(emf);
    }
    
    public void addUtilisateur(Utilisateur utilisateur){
        utilisateurJpaController.create(utilisateur);
    }
    
    public void editUtilisateur(Utilisateur utilisateur) throws Exception{
        utilisateurJpaController.edit(utilisateur);
    }
    
    public void removeUtilsateur(int UtilisateurID) throws NonexistentEntityException{
        utilisateurJpaController.destroy(UtilisateurID);
    }
    
    public List<Utilisateur> getAllUtilisateur(){
        return utilisateurJpaController.findUtilisateurEntities();
    }
    
    public Utilisateur getUtilisateurById(int utilisateurID){
        return utilisateurJpaController.findUtilisateur(utilisateurID);
    }
    
    public Utilisateur getUtilisateurByLogin(String email, String password){
        return utilisateurJpaController.findUtilisateurByLogin(email, password);
    }
}

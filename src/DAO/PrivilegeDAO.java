/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import JPAController.PrivilegeJpaController;
import JPAController.exceptions.NonexistentEntityException;
import Model.Privilege;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author abouf
 */
public class PrivilegeDAO {
    private final PrivilegeJpaController privilegeJpaController;
    private EntityManagerFactory emf; 
    public PrivilegeDAO() {
        emf = Persistence.createEntityManagerFactory("smsPU");
        privilegeJpaController = new PrivilegeJpaController(emf);
    }
    public void addPrivilege(Privilege privilege){
        privilegeJpaController.create(privilege);
    }
    
    public void editPrivilege(Privilege Privilege) throws Exception{
        privilegeJpaController.edit(Privilege);
    }
    
    public void removePrivilege(int PrivilegeID) throws NonexistentEntityException{
        privilegeJpaController.destroy(PrivilegeID);
    }
    
    public List<Privilege> getAllPrivilege(){
        return privilegeJpaController.findPrivilegeEntities();
    }
    
    public Privilege getPrivilegeById(int PrivilegeID){
        return privilegeJpaController.findPrivilege(PrivilegeID);
    }
    
    public List<Privilege> getPrivilegeByRoot(int rootId){
       return privilegeJpaController.findPrivilegeByRoot(rootId);
    }
    
    
}

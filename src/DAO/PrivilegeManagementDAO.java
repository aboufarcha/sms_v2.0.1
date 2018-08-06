/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import JPAController.PrivilegeManagementJpaController;
import JPAController.exceptions.NonexistentEntityException;
import Model.PrivilegeManagement;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author abouf
 */
public class PrivilegeManagementDAO {
    private final PrivilegeManagementJpaController privilegeManagementJpaController;
    private EntityManagerFactory emf; 

    public PrivilegeManagementDAO() {
        emf = Persistence.createEntityManagerFactory("smsPU");
        privilegeManagementJpaController = new PrivilegeManagementJpaController(emf);
    }
    public void addPrivilegeManagement(PrivilegeManagement privilegeManagement){
        privilegeManagementJpaController.create(privilegeManagement);
    }
    
    public void editPrivilegeManagement(PrivilegeManagement privilegeManagement) throws Exception{
        privilegeManagementJpaController.edit(privilegeManagement);
    }
    
    public void removePrivilegeManagement(int privilegeManagementID) throws NonexistentEntityException{
        privilegeManagementJpaController.destroy(privilegeManagementID);
    }
    
    public List<PrivilegeManagement> getAllPrivilegeManagement(){
        return privilegeManagementJpaController.findPrivilegeManagementEntities();
    }
    
    public PrivilegeManagement getPrivilegeManagementById(int privilegeManagementID){
        return privilegeManagementJpaController.findPrivilegeManagement(privilegeManagementID);
    }
    
    
}

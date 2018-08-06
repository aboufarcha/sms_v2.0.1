/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import DAO.PrivilegeDAO;
import DAO.UtilisateurDAO;
import Model.Cryptographie;
import Model.Privilege;
import Model.Utilisateur;
import com.mysql.jdbc.Connection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.lang.model.SourceVersion;

/**
 *
 * @author abouf
 */
public class test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws NoSuchAlgorithmException, Exception{
           PrivilegeDAO PDAO = new PrivilegeDAO();
           LinkedList<Privilege> privileges = new LinkedList<>();
           privileges.addAll(PDAO.getAllPrivilege());
           Map<String, List<Privilege>> PrivilegesList = privileges.stream().collect(Collectors.groupingBy(Privilege::getRootTitlePrivilegeAr));
           int i;
           for (String root : PrivilegesList.keySet()) {
               i=0;
              System.out.println("root : " + root);
               while(i<PrivilegesList.get(root).size()){
                   System.out.println(PrivilegesList.get(root).get(i).getTitreSPivear());
                   i++;
               }
                
            }
           
    }
    
}

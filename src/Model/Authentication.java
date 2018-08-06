/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import DAO.UtilisateurDAO;
import com.mysql.jdbc.Connection;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author abouf
 */
public class Authentication {
    public static boolean IsConnected = false;
    public static String Role = "";
    public static Utilisateur admin;
    public static UtilisateurDAO UDAO ;
    public static LinkedList<Utilisateur> users;
    
    public static void Login(String EmailInput , String PasswordInput) {
            admin = UDAO.getUtilisateurByLogin(EmailInput, PasswordInput);
             if(admin !=null) {
                 Role = admin.getRole();
                 IsConnected = true;
                 System.out.println("GoOOd");
             }
    }
  
    public static void SavingPassword(){
        try {
            String tempDir = System.getProperty("java.io.tmpdir");
            File tempFile = new File(new File(tempDir), "userDetail.tmp");
            Process p;
	    p = Runtime.getRuntime().exec("attrib +h " + tempFile.getPath());
	    p.waitFor(); 
            if(tempFile.exists()){
                BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile,true));
                 System.out.println("Overwrite done!!");
            }else{ //This is first login 
                tempFile.createNewFile();
                BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile));
                bw.write(""+admin.getIDAdmin());
                bw.close();
                System.out.println("Done");
                //Write your logic to write data to the file 
            }

        } catch (Exception ex) {
            System.out.println("Error : "+ex.getMessage());
        }
    }
    
   public static void checkTempraryFile() {
        try{
            String str;
            String tempDir = System.getProperty("java.io.tmpdir");
            File tempFile = new File(new File(tempDir), "userDetail.tmp");
            if(tempFile.exists()){
                    BufferedReader br = new BufferedReader(new FileReader(tempFile));
                    if(br!=null){ 
                        
                        admin = UDAO.getUtilisateurById(Integer.parseInt(br.readLine()));
                         System.out.println("admin : "+admin.getNom());
                         IsConnected = true;
                    }else{
                      IsConnected = false;
                    }
                     br.close();
            }else{
                IsConnected = false;
            }
        }catch(Exception e){
          System.out.println("Error "+e.getMessage());
        }  
    }
    
   public static void removeTempFile(){
            String tempDir = System.getProperty("java.io.tmpdir");
            File tempFile = new File(new File(tempDir), "userDetail.tmp");
            tempFile.delete();
    }
}

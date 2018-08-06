/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import DAO.UtilisateurDAO;
import Model.Authentication;
import static Model.Authentication.UDAO;
import static Model.Authentication.checkTempraryFile;
import Model.Utilisateur;
import com.mysql.jdbc.Connection;
import java.io.IOException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author abouf
 */
public class Sms extends Application {
 
    @Override
    public void start(Stage primaryStage) {
       // Authentication.checkTempraryFile();
       UDAO = new UtilisateurDAO();
        LinkedList<Utilisateur> users = new LinkedList();
        users.addAll(UDAO.getAllUtilisateur());
        System.out.println("test here"+users.getFirst());
        Pane mainPane;
        try {
            checkTempraryFile();
            if(Authentication.IsConnected){
                mainPane = (Pane) FXMLLoader.load(Sms.class.getResource("Dashboard.fxml"));
            }else{
                mainPane = (Pane) FXMLLoader.load(Sms.class.getResource("Login.fxml"));
            }
            primaryStage.initStyle(StageStyle.UNDECORATED);
            primaryStage.setScene(new Scene(mainPane));
            primaryStage.show();
        } catch (Exception ex) {
            Logger.getLogger(Sms.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

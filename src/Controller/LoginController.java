/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.UtilisateurDAO;
import Model.Authentication;
import static Model.Authentication.SavingPassword;
import static Model.Authentication.UDAO;
import Model.Utilisateur;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author abouf
 */
public class LoginController implements Initializable {

    @FXML
    private JFXTextField JFXEmailInput;
    @FXML
    private JFXPasswordField JFXPWDInput;
    @FXML
    private JFXCheckBox CheckBoxSavingLogin;
    @FXML
    private JFXButton ButtonCancel;
    @FXML
    private JFXButton ButtonLogin;
    private Scene homePageScene;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        
    }    

    @FXML
    private void closeButton(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void loginButton(ActionEvent event) {
       try{
        String Email = JFXEmailInput.getText();
        String Password = JFXPWDInput.getText();
        Authentication.Login(Email, Password);
        if(Authentication.IsConnected){
              if(CheckBoxSavingLogin.isSelected()){
                  SavingPassword();
              }
            Parent homePage = FXMLLoader.load(getClass().getResource("/View/Dashboard.fxml"));
            homePageScene = new Scene(homePage);
            Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            appStage.close();
            appStage.setScene(homePageScene);
            appStage.show();      
             
        }
       }catch(Exception e){
       
       }
        
    }
    
}

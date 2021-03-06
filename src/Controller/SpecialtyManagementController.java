/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Authentication;
import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author abouf
 */
public class SpecialtyManagementController implements Initializable {

    @FXML
    private JFXButton backToDashboardButton;
    private Scene Scene;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void closeWindowButton(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void minimizeWindowButton(ActionEvent event) {
       ((Stage)((Button)event.getSource()).getScene().getWindow()).setIconified(true);
    }

    @FXML
     private void logOutButton(ActionEvent event) {
         try{
            Authentication.IsConnected=false;
            Authentication.removeTempFile();
            Authentication.admin = null;
            Parent loginPage = FXMLLoader.load(getClass().getResource("/View/Login.fxml"));
            Scene = new Scene(loginPage);
            Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            appStage.close();
            appStage.setScene(Scene);
            appStage.show();   
        }catch(Exception e){
        }
    }

    @FXML
    private void goToBackButton(ActionEvent event) {
         try{
            Parent HomePage;
            if(event.getSource() == backToDashboardButton)
                    HomePage = FXMLLoader.load(getClass().getResource("/View/Dashboard.fxml"));
            else
                HomePage = FXMLLoader.load(getClass().getResource("/View/SpecialtyManagement.fxml"));
            Scene = new Scene(HomePage);
            Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            appStage.close();
            appStage.setScene(Scene);
            appStage.show();   
        }catch(Exception e){
        
        }
    }
    
    @FXML
    private void addSpecialtyButton(MouseEvent event){
      try{
            Parent Page = FXMLLoader.load(getClass().getResource("/View/AddSpecialty.fxml"));
            Scene = new Scene(Page);
            Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            appStage.close();
            appStage.setScene(Scene);
            appStage.show();   
        }catch(Exception e){
            System.out.println("Error est : "+e.getMessage());
        }
    
    }
    
    @FXML 
    private void addCycleButton(MouseEvent event){
       try{
            Parent Page = FXMLLoader.load(getClass().getResource("/View/AddLevel.fxml"));
            Scene = new Scene(Page);
            Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            appStage.close();
            appStage.setScene(Scene);
            appStage.show();   
        }catch(Exception e){
            System.out.println("Error est : "+e.getMessage());
        }
    }
    
    @FXML 
    private void specialtiesListButton(MouseEvent event){
       try{
            Parent Page = FXMLLoader.load(getClass().getResource("/View/SpecialtyList.fxml"));
            Scene = new Scene(Page);
            Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            appStage.close();
            appStage.setScene(Scene);
            appStage.show();   
        }catch(Exception e){
            System.out.println("Error est : "+e.getMessage());
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Authentication;
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
public class AdminDashboardController implements Initializable {

    public Scene Scene;

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
    private void studentManagementButton(MouseEvent event) {
        try{
            Parent Page = FXMLLoader.load(getClass().getResource("/View/StudentManagement.fxml"));
            Scene = new Scene(Page);
            Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            appStage.close();
            appStage.setScene(Scene);
            appStage.show();   
        }catch(Exception e){
        
        }
    }

    @FXML
    private void workerManagementButton(MouseEvent event) {
       try{
            Parent Page = FXMLLoader.load(getClass().getResource("/View/WorkerManagement.fxml"));
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
    private void agendaManagementButton(MouseEvent event) {
        try{
            Parent Page = FXMLLoader.load(getClass().getResource("/View/AgendaManagement.fxml"));
            Scene = new Scene(Page);
            Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            appStage.close();
            appStage.setScene(Scene);
            appStage.show();   
        }catch(Exception e){
        
        }
    }

    @FXML
    private void professeurManagementButton(MouseEvent event) {
        try{
            Parent Page = FXMLLoader.load(getClass().getResource("/View/ProfesseurManagement.fxml"));
            Scene = new Scene(Page);
            Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            appStage.close();
            appStage.setScene(Scene);
            appStage.show();   
        }catch(Exception e){
        
        }
    }

    @FXML
    private void specialtyManagementButton(MouseEvent event) {
       try{
            Parent Page = FXMLLoader.load(getClass().getResource("/View/SpecialtyManagement.fxml"));
            Scene = new Scene(Page);
            Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            appStage.close();
            appStage.setScene(Scene);
            appStage.show();   
        }catch(Exception e){
        
        }
    }
    
    @FXML
    private void privilegeManagementButton(MouseEvent event) {
       try{
            Parent Page = FXMLLoader.load(getClass().getResource("/View/PrivilegeManagement.fxml"));
            Scene = new Scene(Page);
            Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            appStage.close();
            appStage.setScene(Scene);
            appStage.show();   
        }catch(Exception e){
        
        }
    }
    
    @FXML
    private void classroomManagementButton(MouseEvent event) {
       try{
            Parent Page = FXMLLoader.load(getClass().getResource("/View/ClassroomManagement.fxml"));
            Scene = new Scene(Page);
            Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            appStage.close();
            appStage.setScene(Scene);
            appStage.show();   
        }catch(Exception e){
        
        }
    }

    @FXML
    private void statisticManagementButton(MouseEvent event) {
       try{
            Parent Page = FXMLLoader.load(getClass().getResource("/View/StatisticManagement.fxml"));
            Scene = new Scene(Page);
            Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            appStage.close();
            appStage.setScene(Scene);
            appStage.show();   
        }catch(Exception e){
        
        }
    }
    
    @FXML
    private void paymentManagementButton(MouseEvent event) {
       try{
            Parent Page = FXMLLoader.load(getClass().getResource("/View/PaymentManagement.fxml"));
            Scene = new Scene(Page);
            Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            appStage.close();
            appStage.setScene(Scene);
            appStage.show();   
        }catch(Exception e){
        
        }
    }
    
    @FXML
    private void settingsManagementButton(MouseEvent event) {
       try{
            Parent Page = FXMLLoader.load(getClass().getResource("/View/SettingsManagement.fxml"));
            Scene = new Scene(Page);
            Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            appStage.close();
            appStage.setScene(Scene);
            appStage.show();   
        }catch(Exception e){
        
        }
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
    
}

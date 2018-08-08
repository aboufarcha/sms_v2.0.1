/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Authentication;
import com.jfoenix.controls.JFXButton;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.imageio.ImageIO;

/**
 * FXML Controller class
 *
 * @author abouf
 */
public class StudentManagementController implements Initializable {

    
    
   
    @FXML
    private JFXButton backToDashboardButton;
    @FXML 
    private AnchorPane uploadImage;
    @FXML
    private ImageView ImageStudent;
    
     private Scene Scene;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO"/images/student.png"
       
        
        
    }    


    @FXML
    private void minimizeWindowButton(ActionEvent event) {
         ((Stage)((Button)event.getSource()).getScene().getWindow()).setIconified(true);
    }

    @FXML
    private void closeWindowButton(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void studentListButton(MouseEvent event) {
        try{
            Parent Page = FXMLLoader.load(getClass().getResource("/View/StudentList.fxml"));
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
    private void addStudentButton(MouseEvent event) {
         try{
            Parent Page = FXMLLoader.load(getClass().getResource("/View/AddStudent.fxml"));
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
    private void exportImportButton(MouseEvent event) {
        try{
            Stage stage = new Stage();
                Parent root = FXMLLoader.load(ProfesseurManagementController.class.getResource("/View/ExportImport.fxml"));
                stage.setScene(new Scene(root));
                stage.initStyle(StageStyle.UNDECORATED);
                stage.initModality(Modality.WINDOW_MODAL);
                stage.initOwner(
                    ((Node)event.getSource()).getScene().getWindow() );
                stage.show();
        }catch(Exception e){
            System.out.println("Error est : "+e.getMessage());
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

    @FXML
    private void goToBackButton(ActionEvent event) {
        try{
            Parent HomePage;
            if(event.getSource() == backToDashboardButton)
                    HomePage = FXMLLoader.load(getClass().getResource("/View/Dashboard.fxml"));
            else
                HomePage = FXMLLoader.load(getClass().getResource("/View/StudentManagement.fxml"));
            Scene = new Scene(HomePage);
            Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            appStage.close();
            appStage.setScene(Scene);
            appStage.show();   
        }catch(Exception e){
        
        }
    }

    @FXML
    private void closeModalWindowButton(ActionEvent event) {
        Stage stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    private void downloadButton(MouseEvent event) {
    }
    
    @FXML
    private void uploadButton(MouseEvent event){
        try{
            Stage stage = new Stage();
                Parent root = FXMLLoader.load(ProfesseurManagementController.class.getResource("/View/Import.fxml"));
                stage.setScene(new Scene(root));
                stage.initStyle(StageStyle.UNDECORATED);
                stage.initModality(Modality.WINDOW_MODAL);
                ((Stage)((AnchorPane)event.getSource()).getScene().getWindow()).close();
                stage.initOwner(
                    ((Node)event.getSource()).getScene().getWindow() );
                stage.show();
        }catch(Exception e){
            System.out.println("Error est : "+e.getMessage());
        }
    }
    
    @FXML
    private void goBackModalButton(ActionEvent event){
        try{
            Stage stage = new Stage();
                Parent root = FXMLLoader.load(ProfesseurManagementController.class.getResource("/View/ExportImport.fxml"));
                stage.setScene(new Scene(root));
                stage.initStyle(StageStyle.UNDECORATED);
                stage.initModality(Modality.WINDOW_MODAL);
                ((Stage)((Button)event.getSource()).getScene().getWindow()).close();
                stage.initOwner(
                    ((Node)event.getSource()).getScene().getWindow() );
                stage.show();
        }catch(Exception e){
            System.out.println("Error est : "+e.getMessage());
        }
    }
    
    @FXML 
    private void uploadImageButton(MouseEvent event){
        FileChooser fileChooser = new FileChooser();
                fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files",
                        "*.bmp", "*.png", "*.jpg", "*.gif"));
        File selectedFile = fileChooser.showOpenDialog(new Stage());
        if (selectedFile != null) {
            try{
              String imagepath = selectedFile.toURI().toURL().toString();
              System.out.println("file:"+imagepath);
              Image image = new Image(imagepath);
              ImageStudent.setImage(image);
             
               
            }catch(Exception e){
                System.out.println(" Error is : "+e);
            }
        }
    }
}


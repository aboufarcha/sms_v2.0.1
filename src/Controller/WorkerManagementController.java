/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.PrivilegeDAO;
import Model.Authentication;
import Model.Privilege;
import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.CheckBoxTreeItem;
import javafx.scene.control.cell.CheckBoxTreeCell;
import javafx.scene.control.TreeView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.controlsfx.control.CheckTreeView;

/**
 * FXML Controller class
 *
 * @author abouf
 */
public class WorkerManagementController implements Initializable {

    private Scene Scene;
    @FXML
    private JFXButton backToDashboardButton;
    
    @FXML
    private TreeView PrivilegesTreeView;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       
        PrivilegeDAO PDAO = new PrivilegeDAO();
        LinkedList<Privilege> privileges = new LinkedList<>();
        privileges.addAll(PDAO.getAllPrivilege());
        
           Map<String, List<Privilege>> PrivilegesList = privileges.stream().collect(Collectors.groupingBy(Privilege::getRootTitlePrivilegeAr));
           int i;
           
          
         /*  for (String root : PrivilegesList.keySet()) {
                CheckBoxTreeItem<String> PrivilegeItem = new CheckBoxTreeItem<String>(root);
                rootItem.getChildren().add(PrivilegeItem);
               i=0;
               while(i<PrivilegesList.get(root).size()){
                   CheckBoxTreeItem SousPrivilegeItem = new CheckBoxTreeItem(PrivilegesList.get(root).get(i).getTitreSPivear());
                   PrivilegeItem.getChildren().add(SousPrivilegeItem);
                   i++;
               }
            }*/
         
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
            if(event.getSource()==backToDashboardButton){
                HomePage = FXMLLoader.load(getClass().getResource("/View/Dashboard.fxml"));
            }else{
                HomePage = FXMLLoader.load(getClass().getResource("/View/WorkerManagement.fxml"));
            }
            Scene = new Scene(HomePage);
            Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            appStage.close();
            appStage.setScene(Scene);
            appStage.show();   
        }catch(Exception e){
        
        }
    }

    @FXML
    private void workerListButton(MouseEvent event) {
    }

    @FXML
    private void addWorkerButton(MouseEvent event) {
    }

    @FXML
    private void privilegeManagementButton(MouseEvent event) {
        try{
            Parent HomePage = FXMLLoader.load(getClass().getResource("/View/PrivilegeManagement.fxml"));
            Scene = new Scene(HomePage);
            Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            appStage.close();
            appStage.setScene(Scene);
            appStage.show();   
            CheckBoxTreeItem rootItem = new CheckBoxTreeItem("Droits");
           rootItem.setExpanded(true);
             CheckBoxTreeItem SousPrivilegeItem = new CheckBoxTreeItem("Hello");
           rootItem.getChildren().add(SousPrivilegeItem);
            this.PrivilegesTreeView = new TreeView(rootItem);
            System.out.println("hm here");
           this.PrivilegesTreeView.setCellFactory(CheckBoxTreeCell.forTreeView());
           this.PrivilegesTreeView.setRoot(rootItem);
        }catch(Exception e){
        
        }
    }

    
}

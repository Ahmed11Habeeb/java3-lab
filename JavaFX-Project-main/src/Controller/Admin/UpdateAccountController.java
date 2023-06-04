/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Admin;

import View.ViewManager;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Ahmed Habeeb
 */
public class UpdateAccountController implements Initializable {

    @FXML
    private TextField newCurrency;
    @FXML
    private TextField newBalance;
    @FXML
    private Button updateAccountBtn;
    @FXML
    private Button cancelBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void updateAccount(ActionEvent event) {
        
    }

    @FXML
    private void cancelupdate(ActionEvent event) {
        ViewManager.adminPage.changeSceneToAccountsManagment();
    }
    
}

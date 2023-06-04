
package Controller.Admin;

import Model.Account;
import Model.DB;
import View.ViewManager;
import com.mysql.cj.xdevapi.PreparableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class CreateAccountController {

    @FXML
    private TextField balance;
    
    @FXML
    private TextField currency;

    @FXML
    private TextField accountNumber;

    @FXML
    private TextField userID;

    @FXML
    private TextField createDate;
    
    @FXML
    void saveNewAccount(ActionEvent e)throws SQLException{
         
      Connection con=DB.getInstance().getConnection();
      
      Integer user_id=Integer.parseInt(userID.getText());
      PreparedStatement pre=con.prepareStatement("select * from users where id =?");
      pre.setInt(1, 1);
      ResultSet  rs=pre.executeQuery();
      //the account has username
      if(rs.getRow()==1){
          rs.next();
          
        String curr=currency.getText();
        Double bal=Double.parseDouble(balance.getText());
        Integer accountNum=Integer.parseInt(accountNumber.getText());
        
         Account account=new Account(accountNum,curr,bal,user_id);
         account.saveAccount(user_id, rs.getString("username"));
      }
        ViewManager.adminPage.changeSceneToAccountsManagment();
    }
    
    @FXML
    void cancelAccountCreation(ActionEvent e){
        ViewManager.adminPage.changeSceneToAccountsManagment();
    }

    
    //side bar
    @FXML
    private void showUsersManagmentPage(ActionEvent event) {
        ViewManager.adminPage.changeSceneToUsersManagment();
    }

    @FXML
    private void showAccountsPage(ActionEvent event) {
        ViewManager.adminPage.changeSceneToAccountsManagment();
    }

    @FXML
    private void showOperationsPage(ActionEvent event) {
    }
    
    
    
}

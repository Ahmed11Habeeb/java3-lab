/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Ahmed Habeeb
 */
public class Account {
    
    private Integer accountNumber;
    private Integer userID;
    private String currency;
    private Double balance;
    
    
    public Account(Integer accountNumber,String currency,Double balance,Integer userID){
        this.setAccountNumber(accountNumber);
        this.setCurrency(currency);
        this.setBalance(balance);
        this.setUserID(userID);
    }

    public Integer getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Integer accountNumber) {
        this.accountNumber = accountNumber;
    }

   

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }
    
    public void saveAccount(Integer userId,String userName) throws SQLException{
        Connection con=DB.getInstance().getConnection();
        PreparedStatement insert=con.prepareStatement("insert into accounts (user_id,account_number,"
               + "username,currency,balance) values(?,?,?,?,?)");
       insert.setInt(1, userId);
       insert.setInt(2,this.getAccountNumber());
       insert.setString(3, userName);
       insert.setString(4, this.getCurrency());
       insert.setDouble(5, this.getBalance());
       int result=insert.executeUpdate();
       
       if(result==1){
           //make alert
       }
    }
    
    public void updateAccount(String newCurrency,Double newBalance,Integer user_id) throws SQLException{
        Connection con=DB.getInstance().getConnection();
        PreparedStatement update=con.prepareStatement("update accounts set currency=? balance=? where user_id=?");
        update.setString(1, newCurrency);
        update.setDouble(2, newBalance);
        update.setInt(3, user_id);
        int alert=update.executeUpdate();
        
        if(alert==1){
            //print alert
        }
    }
    
    public void deleteAccount() throws SQLException{
        Connection con=DB.getInstance().getConnection();
        PreparedStatement delete=con.prepareStatement("delete from accounts where user_id=?");
        delete.setInt(1, this.userID);
        int alert=delete.executeUpdate();
        
        if(alert==1){
            //print alert
        }
    }
}

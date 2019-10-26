/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ZAX
 */
import java.sql.Connection;  
 import java.sql.DriverManager;  
 import java.sql.ResultSet;  
 import java.sql.Statement;  
import javax.swing.JOptionPane;

public class ConnectMSSQL {  
 Connection conn;
      public static Connection connectDB(){ 
         
         try {  
             Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
             Connection conn = DriverManager  
                     .getConnection(  
                             "jdbc:sqlserver://localhost:1433;databaseName=HumanResource_payroll;selectMethod=cursor",   "sa", "123456");  
   
             System.out.println("DATABASE NAME IS:"  
                     + conn.getMetaData().getDatabaseProductName());  
             Statement statement = conn.createStatement();  
             ResultSet resultSet = statement  
                     .executeQuery("SELECT FirstName FROM Customer");  
             while (resultSet.next()) {  
                 System.out.println("Customer NAME:"  
                         + resultSet.getString("FirstName"));  
             }  
         return conn;
         } catch (Exception e) {  
             e.printStackTrace();
             //JOptionPane.showMessageDialog(null, e);
            return null;
         }  
      }

 }
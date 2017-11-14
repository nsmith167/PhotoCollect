package Main;


import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author JoeSema
 */
public class Database {
    public static Connection connectDB(){
        try{
            Connection conn = null;
            Class.forName("com.mysql.jdbc.Driver");
            String host = "jdbc:mysql://127.0.0.1:3306/photo_collect";
            String user = "root";
            String pass = "Secure101";
            conn = DriverManager.getConnection(host, user, pass);
            JOptionPane.showMessageDialog(null, "Connection Established");
            return conn;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
}

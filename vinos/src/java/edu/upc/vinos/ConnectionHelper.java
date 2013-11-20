/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.vinos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 *
 * @author alumno
 */
public class ConnectionHelper {
    
    private String url;
    private static ConnectionHelper instance;
           
    private ConnectionHelper(){
        String driver = null;
        try{
            ResourceBundle bundle = ResourceBundle.getBundle("vinos");
            driver = bundle.getString("jdbc.driver");
            Class.forName(driver);
            url = "jdbc:mysql://localhost/wine?user=root&password=mysql";

        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    public static Connection getConnection() throws SQLException {
        
        if(instance == null){
            instance = new ConnectionHelper();
        }
        try{
            return DriverManager.getConnection(instance.url);
        }catch(SQLException ex){
            throw ex;
        }
    }
    
    public static void close(Connection connection){
        try{
            if(connection!=null){
                connection.close();
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
}

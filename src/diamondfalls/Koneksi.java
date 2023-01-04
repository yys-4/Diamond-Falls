/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package diamondfalls;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author DELL
 */
public class Koneksi {
    private static Connection cn;
    
    public static Connection getConnection() throws SQLException{
        String db = "jdbc:mysql://localhost:3306/gamepbo";
        String user = "root";
        String password = "";
        
        if (cn == null) {
            cn = DriverManager.getConnection(db, user, password);
            
        }
        
        return cn;
    }
}

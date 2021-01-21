
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    public static final String URL = "jdbc:mysql://localhost:3306/AbarrotesSQL?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    public static final String user = "root";
    public static final String password = "admin";
    
    
    public Connection getConnection() {
        Connection con = null;
        
        try {
            con = (Connection) DriverManager.getConnection(URL, user, password);
        } catch (SQLException ex) {
            System.err.println("Error"+ex);
        }
        return con;
    }
}

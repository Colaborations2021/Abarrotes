
package Controlador;

import Modelo.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;

public class consultasLogin extends Conexion {
    PreparedStatement ps;
    ResultSet rs;
    
    public boolean validarUsuario(String nombreUsuario, String contraseña, boolean administrador){
        ps = null;
        rs = null;
        boolean valido = false;
        boolean esAdministrador = false;
        Connection con = getConnection();
        
        try {
            ps = con.prepareStatement("Select (usuario,contraseña,administrador) from usuario");
            rs = ps.executeQuery();
            
            while(rs.next()){
                valido = (rs.getString("usuario").equals(nombreUsuario))&&(rs.getString("contraseña").equals(contraseña))&&(rs.getBoolean("administrador")==administrador);
                if(valido){
                    esAdministrador = (rs.getBoolean("administrador")==administrador);
                }else {
                    
                }
            }
        } catch (SQLException ex) {
            System.err.println("Error, "+ex);
            return false;
        }
        
    }
}

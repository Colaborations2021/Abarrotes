
package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;

public class consultasUsuario {
    
    public boolean iniciarSesion (Usuario usuario) {
        Conexion con = new Conexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        Connection conexion = con.getConnection();
        try {
            ps = conexion.prepareStatement("select idUsuario,nombre,telefono,usuario,contraseña,administrador from usuario where usuario=?");
            ps.setString(1, usuario.getNombreUsuario());
            
            if(rs.next()){
                if(usuario.getContraseña().equals(rs.getString("contraseña"))){
                    usuario.setIdUsuario(rs.getInt("idUsuario"));
                    usuario.setNombre(rs.getString("nombre"));
                    usuario.setAdministrador(rs.getBoolean("administrador"));
                    return true;
                }else {
                    return false;
                }
            }
            return false;
        } catch (SQLException ex) {
            System.err.println("Error, "+ex);
            return false;
        }  
    }
}

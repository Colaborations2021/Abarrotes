
package Controlador;

import Modelo.Conexion;
import Modelo.Producto;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class consultasInventario extends Conexion{
    PreparedStatement ps;
    
    public boolean insertar(Producto producto){
        Connection conexion = getConnection();
        
        try {
            ps = conexion.prepareStatement("insert into producto (precio,existencia,nombre,unidad,idCategoria) values (?,?,?,?,?)");
            ps.setDouble(1, producto.getPrecio());
            ps.setInt(2, producto.getExistencia());
            ps.setString(3, producto.getNombre());
            ps.setString(4, producto.getUnidad());
            ps.setInt(5, producto.getIdCategoria());
            
            int resultado = ps.executeUpdate();
            
            return resultado>0;
        } catch (SQLException ex) {
            System.err.println("Error, "+ex);
            return false;
        }finally{
            try {
                conexion.close();
            } catch (SQLException ex) {
                System.err.println("Error, "+ex);
            }
        }
    } 
}

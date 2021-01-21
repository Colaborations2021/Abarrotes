
package Controlador;

import Modelo.Conexion;
import Modelo.Producto;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.DefaultComboBoxModel;

public class consultasInventario extends Conexion{
    PreparedStatement ps;
    ResultSet rs;
    public DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel();
    
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
    public boolean eliminar(int id){
        Connection conexion = getConnection();
        
        try {
            ps = conexion.prepareStatement("delete from producto where idProducto=?");
            ps.setInt(1, id);
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
    
    public boolean actualizar(Producto producto){
        Connection conexion = getConnection();
        
        try {
            ps = conexion.prepareStatement("update producto set precio=?,existencia=?,nombre=?,unidad=?,idCategoria=? where idProducto=?");
            ps.setDouble(1,producto.getPrecio());
            ps.setInt(2,producto.getExistencia());
            ps.setString(3, producto.getNombre());
            ps.setString(4, producto.getUnidad());
            ps.setInt(5, producto.getIdCategoria());
            ps.setInt(6, producto.getIdProducto());
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
    
    public void llenarComboBox(){
        Producto producto = new Producto();
        ps =null;
        rs = null;
        Connection con = getConnection();
        try {
            ps = con.prepareStatement("select * from producto");
            rs = ps.executeQuery();
            
            while(rs.next()){
                producto.setIdProducto(rs.getInt("idProducto"));
                producto.setNombre(rs.getString("nombre"));
                producto.setExistencia(rs.getInt("existencia"));
                producto.setUnidad(rs.getString("unidad"));
                producto.setPrecio(rs.getDouble("precio"));
                producto.setIdCategoria(rs.getInt("idCategoria"));
                Vista.FrmInventario.modeloCombo.addElement(producto);
                producto = new Producto();
            }            
        } catch (SQLException ex) {
            System.err.println("Error, "+ex);
        }finally{
            try {
                con.close();
            } catch (SQLException ex) {
                System.err.println("Error, "+ex);
            }
        }
    }
}

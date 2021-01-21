
package Controlador;

import Modelo.Producto;
import Vista.FrmInventario;
import javax.swing.JOptionPane;

public class controladorInventario {
    
    
    public static void salir(){
        System.exit(0);
    }
    
    public static void agregar(){
        Producto producto = new Producto();
        FrmInventario vista = new FrmInventario();
        consultasInventario consulta = new consultasInventario();
        
        producto.setNombre(vista.getTxtArticulo().getText());
        producto.setPrecio(Double.parseDouble(vista.getTxtPrecio().getText()));
        producto.setUnidad(vista.getTextoUnidad().getText());
        producto.setExistencia(Integer.parseInt(vista.getTxtExistencia().getText()));
        producto.setIdCategoria(Integer.parseInt(vista.getTextoCategoria().getText()));
        
        
        if(consulta.insertar(producto)){
            JOptionPane.showMessageDialog(null,"Registro insertado correctamente");
            //limpiar();
        }else{
            JOptionPane.showMessageDialog(null,"Error al insertar registro");
        }
        
    }
}

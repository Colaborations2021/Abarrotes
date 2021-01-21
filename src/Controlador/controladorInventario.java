package Controlador;

import Modelo.Producto;
import javax.swing.JOptionPane;

public class controladorInventario {

    public static consultasInventario consulta = new consultasInventario();
    public static void salir() {
        System.exit(0);
    }

    public static void agregar() {
        Producto producto = new Producto();
        producto.setNombre(Vista.FrmInventario.getTxtArticulo().getText());
        producto.setPrecio(Double.parseDouble(Vista.FrmInventario.getTxtPrecio().getText()));
        producto.setUnidad(Vista.FrmInventario.getTextoUnidad().getText());
        producto.setExistencia(Integer.parseInt(Vista.FrmInventario.getTxtExistencia().getText()));
        producto.setIdCategoria(Integer.parseInt(Vista.FrmInventario.getTextoCategoria().getText()));

        if (consulta.insertar(producto)) {
            JOptionPane.showMessageDialog(null, "Registro insertado correctamente");
            //limpiar();
        } else {
            JOptionPane.showMessageDialog(null, "Error al insertar registro");
        }

    }

    public static void eliminarProducto() {
        if (Vista.FrmInventario.getTextoIdProducto().getText() != null) {
            int id = Integer.parseInt(Vista.FrmInventario.getTextoIdProducto().getText());
            if (consulta.eliminar(id)) {
                JOptionPane.showMessageDialog(null, "Registro Eliminado Correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar el registro");
            }
        }
    }

    public static void actualizarProducto() {
        Producto producto = new Producto();
        producto.setIdProducto(Integer.parseInt(Vista.FrmInventario.getTextoIdProducto().getText()));
        producto.setNombre(Vista.FrmInventario.getTxtArticulo().getText());
        producto.setExistencia(Integer.parseInt(Vista.FrmInventario.getTxtExistencia().getText()));
        producto.setUnidad(Vista.FrmInventario.getTextoUnidad().getText());
        producto.setPrecio(Double.parseDouble(Vista.FrmInventario.getTxtPrecio().getText()));
        producto.setIdCategoria(Integer.parseInt(Vista.FrmInventario.getTextoCategoria().getText()));
        if (consulta.actualizar(producto)) {
            JOptionPane.showMessageDialog(null, "Registro Eliminado Correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "Error al eliminar el registro");
        }
    }
}

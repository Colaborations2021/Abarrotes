
package Controlador;

import Modelo.Usuario;
import Modelo.cifrarContraseña;
import Modelo.consultasUsuario;
import Vista.FrmLogin;
import javax.swing.JOptionPane;

public class controladorFrLogin {
    
    
    public static void validarUsuario(){
        Usuario usuario = new Usuario();
        consultasUsuario consulta = new consultasUsuario();
        FrmLogin vista = new FrmLogin();
        
        String contraseña = new String(vista.getTextoContraseña().getPassword());
        
        if(vista.getTextoNombreUsuario().getText().equals("") || contraseña.equals("")){
            JOptionPane.showMessageDialog(null, "Rellene todos lo campos");
        }else {
            String nuevaContraseña = cifrarContraseña.md5(contraseña);
            
            usuario.setNombreUsuario(vista.getTextoNombreUsuario().getText());
            usuario.setContraseña(nuevaContraseña);
            
            if(consulta.iniciarSesion(usuario)){
                JOptionPane.showMessageDialog(null,"Inicio de sesion exitoso");
            }else{
                JOptionPane.showMessageDialog(null,"Datos incorrectos");
            }
        }
    }
}

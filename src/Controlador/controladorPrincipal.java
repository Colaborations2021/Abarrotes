package Controlador;

import Vista.FrmLogin;

public class controladorPrincipal {
    public static FrmLogin vista = new FrmLogin();
    public static consultasLogin consulta = new consultasLogin();
    public static void iniciar() {
        vista.setTitle("Abarrotes 'LA LIBERTAD'");
        vista.setSize(709, 500);
        vista.setResizable(false);
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
        
    }
    public static void Salir(){
        System.exit(0);
    }
    public static void ingresar(){
        if(consulta.validarUsuario(vista.getTextoNombreUsuario().getText(), vista, true))
    }
    
}

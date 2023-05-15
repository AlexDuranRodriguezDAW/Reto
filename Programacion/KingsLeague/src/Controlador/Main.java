package Controlador;

import Modelo.*;
import Vistas.VentanaInicioSesion;

import javax.swing.*;

public class Main {
    private static JFrame ventanaInicioSesion;
    private static Login usuarioActual;

    public static void main(String[] args) throws Exception {
        crearVentanaPrincipal();
    }

    public static void crearVentanaPrincipal() {
        ventanaInicioSesion = new JFrame("VentanaInicioSesion");
        ventanaInicioSesion.setContentPane(new VentanaInicioSesion().getVentanaInicioSesion());
        ventanaInicioSesion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventanaInicioSesion.pack();
        ventanaInicioSesion.setLocationRelativeTo(null);
        ventanaInicioSesion.setVisible(true);
    }

    public static void validarPassword(String usuario,String pass) throws Exception {
        Login lConsulta = new Login(usuario,pass);
        usuarioActual = TLogin.consultarUsuario(lConsulta);
        System.out.println("El usuario es " + usuarioActual.getUsuario() + " con pass " + usuarioActual.getContrasenya() + " y es tipo " + usuarioActual.getTipo());
        JOptionPane.showMessageDialog(null,"Esta seria la siguiente ventana");
    }
}

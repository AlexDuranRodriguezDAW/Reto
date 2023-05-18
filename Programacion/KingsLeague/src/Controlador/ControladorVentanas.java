package Controlador;

import Vistas.CrudAsistente.VentanaBorrarAsistente;
import Vistas.CrudAsistente.VentanaCrearAsistente;
import Vistas.CrudAsistente.VentanaModificarAsistente;
import Vistas.CrudDuenio.VentanaBorrarDuenio;
import Vistas.CrudDuenio.VentanaCrearDuenio;
import Vistas.CrudEntrenador.VentanaBorrarEntrenador;
import Vistas.CrudEntrenador.VentanaCrearEntrenador;
import Vistas.CrudEquipo.VentanaBorrarEquipo;
import Vistas.CrudEquipo.VentanaCrearEquipo;
import Vistas.CrudEquipo.VentanaModificarEquipo;
import Vistas.CrudJugador.VentanaBorrarJugador;
import Vistas.CrudJugador.VentanaCrearJugador;
import Vistas.CrudJugador.VentanaModificarJugador;
import Vistas.VentanaAdministrador;
import Vistas.VentanaInicioSesion;
import Vistas.VentanaPrincipal;
import Vistas.VentanaVerEquipo;

import javax.swing.*;

public class ControladorVentanas {

    public static JFrame ventanaInicioSesion;
    public static JFrame ventanaPrincipal;
    public static JFrame ventanaAdministrador;

    //Metodos relacionados con las ventanas
    public static void crearVentanaInicioSesion() {
        ventanaInicioSesion = new JFrame("VentanaInicioSesion");
        ventanaInicioSesion.setContentPane(new VentanaInicioSesion().getVentanaInicioSesion());
        ventanaInicioSesion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventanaInicioSesion.pack();
        ventanaInicioSesion.setLocationRelativeTo(null);
        ventanaInicioSesion.setVisible(true);
    }

    public static void crearVentanaPrincipal() {
        ventanaPrincipal = new JFrame("VentanaPrincipal");
        ventanaPrincipal.setContentPane(new VentanaPrincipal().getVentanaPrincipal());
        ventanaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventanaPrincipal.pack();
        ventanaPrincipal.setLocationRelativeTo(ventanaInicioSesion);
        ventanaPrincipal.setVisible(true);
    }

    public static void crearVentanaAdministrador() {
        ventanaAdministrador = new JFrame("VentanaAdministrador");
        ventanaAdministrador.setContentPane(new VentanaAdministrador().getpPrincipal());
        ventanaAdministrador.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventanaAdministrador.pack();
        ventanaAdministrador.setLocationRelativeTo(ventanaPrincipal);
        ventanaAdministrador.setVisible(true);
    }

    public static void crearVentanaVerEquipo() {
        JFrame frame = new JFrame("VentanaVerEquipo");
        frame.setContentPane(new VentanaVerEquipo().getVentanaVerEquipo());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(ventanaPrincipal);
        frame.setVisible(true);
    }

    public static void crearVentanaCrearEquipo() {
        VentanaCrearEquipo dialog = new VentanaCrearEquipo();
        dialog.pack();
        dialog.setLocationRelativeTo(ventanaAdministrador);
        dialog.setVisible(true);
    }

    public static void crearVentanaBorrarEquipo() {
        VentanaBorrarEquipo dialog = new VentanaBorrarEquipo();
        dialog.pack();
        dialog.setLocationRelativeTo(ventanaAdministrador);
        dialog.setVisible(true);
    }

    public static void crearVentanaModificarEquipo() {
        VentanaModificarEquipo dialog = new VentanaModificarEquipo();
        dialog.pack();
        dialog.setLocationRelativeTo(ventanaAdministrador);
        dialog.setVisible(true);
    }

    public static void crearVentanBorrarEntrenador() throws Exception {
        VentanaBorrarEntrenador dialog = new VentanaBorrarEntrenador();
        dialog.pack();
        dialog.setLocationRelativeTo(ventanaAdministrador);
        dialog.setVisible(true);
    }


    public static void crearVentanaBorrarAsitente() {
        VentanaBorrarAsistente dialog = new VentanaBorrarAsistente();
        dialog.pack();
        dialog.setLocationRelativeTo(ventanaAdministrador);
        dialog.setVisible(true);
    }

    public static void crearVentanaCrearAsistente() {
        VentanaCrearAsistente dialog = new VentanaCrearAsistente();
        dialog.pack();
        dialog.setLocationRelativeTo(ventanaAdministrador);
        dialog.setVisible(true);
    }

    public static void crearVentanaModificarAsistente() {
        VentanaModificarAsistente dialog = new VentanaModificarAsistente();
        dialog.pack();
        dialog.setLocationRelativeTo(ventanaAdministrador);
        dialog.setVisible(true);
    }

    public static void crearVentanaCrearEntrenador() {
        VentanaCrearEntrenador dialog = new VentanaCrearEntrenador();
        dialog.pack();
        dialog.setLocationRelativeTo(ventanaAdministrador);
        dialog.setVisible(true);
    }

    public static void crearVentanaCrearJugador(){
        JFrame frame = new JFrame("VentanaCrearJugador");
        frame.setContentPane(new VentanaCrearJugador().getVentanaCrearJugador());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(ventanaAdministrador);
        frame.setVisible(true);
    }

    public static void crearVentanaBorrarJugador(){
        JFrame frame = new JFrame("VentanaBorrarJugador");
        frame.setContentPane(new VentanaBorrarJugador().getVentanaBorrarJugador());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(ventanaAdministrador);
        frame.setVisible(true);
    }


    public static void crearVentanaModificarJuador () throws Exception {
        VentanaModificarJugador dialog = new VentanaModificarJugador();
        dialog.pack();
        dialog.setVisible(true);
    }

    public static void crearVentanaBorrarDuenio (){
        VentanaBorrarDuenio dialog = new VentanaBorrarDuenio();
        dialog.pack();
        dialog.setVisible(true);
    }

    public static void crearVentanaCrearDuenio(){
        VentanaCrearDuenio dialog = new VentanaCrearDuenio();
        dialog.pack();
        dialog.setVisible(true);
    }
}

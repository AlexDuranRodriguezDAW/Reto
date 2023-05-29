package Controlador;

import Vistas.*;
import Vistas.CrudAsistente.VentanaBorrarAsistente;
import Vistas.CrudAsistente.VentanaCrearAsistente;
import Vistas.CrudAsistente.VentanaModificarAsistente;
import Vistas.CrudEntrenador.VentanaModificarEntrenador;
import Vistas.CrudPropietario.VentanaBorrarPropietario;
import Vistas.CrudPropietario.VentanaCrearPropietario;
import Vistas.CrudPropietario.VentanaModificarPropietario;
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

/**
 * Esta clase se encarga de controlar todas las ventanas del programa.
 * Algunas ventanas estan en variables para poder usarlas para centrar otras ventanas en referencia a estas o para poder cerrarlas desde otras clases.
 * @author Grupo 3
 * @version 1.0
 * @since 23/05/2023
 */

public class ControladorVentanas {

    public static JFrame ventanaInicioSesion;
    public static JFrame ventanaPrincipal;
    public static JFrame ventanaAdministrador;
    public static JFrame ventanaCrearUsuario;
    public static JFrame ventanaVerEquipo;

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
        ventanaVerEquipo = new JFrame("VentanaVerEquipo");
        ventanaVerEquipo.setContentPane(new VentanaVerEquipo().getVentanaVerEquipo());
        ventanaVerEquipo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventanaVerEquipo.pack();
        ventanaVerEquipo.setLocationRelativeTo(ventanaPrincipal);
        ventanaVerEquipo.setVisible(true);
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

    public static void crearVentanBorrarEntrenador() {
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

    public static void crearVentanaCrearJugador() {
        VentanaCrearJugador dialog = new VentanaCrearJugador();
        dialog.pack();
        dialog.setLocationRelativeTo(ventanaAdministrador);
        dialog.setVisible(true);
    }

    public static void crearVentanaBorrarJugador() {
        VentanaBorrarJugador dialog = new VentanaBorrarJugador();
        dialog.pack();
        dialog.setLocationRelativeTo(ventanaAdministrador);
        dialog.setVisible(true);
    }


    public static void crearVentanaModificarJuador() {
        VentanaModificarJugador dialog = new VentanaModificarJugador();
        dialog.pack();
        dialog.setLocationRelativeTo(ventanaAdministrador);
        dialog.setVisible(true);
    }

    public static void crearVentanaBorrarPropietario() {
        VentanaBorrarPropietario dialog = new VentanaBorrarPropietario();
        dialog.pack();
        dialog.setLocationRelativeTo(ventanaAdministrador);
        dialog.setVisible(true);

    }

    public static void crearVentanaCrearPropietario() {
        VentanaCrearPropietario dialog = new VentanaCrearPropietario();
        dialog.pack();
        dialog.setLocationRelativeTo(ventanaAdministrador);
        dialog.setVisible(true);

    }

    public static void crearVentanaModificarPropietario() {

        VentanaModificarPropietario dialog = new VentanaModificarPropietario();
        dialog.pack();
        dialog.setLocationRelativeTo(ventanaAdministrador);
        dialog.setVisible(true);

    }

    public static void crearVentanaModificarEntrenador() {
        VentanaModificarEntrenador dialog = new VentanaModificarEntrenador();
        dialog.pack();
        dialog.setLocationRelativeTo(ventanaAdministrador);
        dialog.setVisible(true);
    }

    public static void crearVentanaCrearUsuario() {
        ventanaCrearUsuario = new JFrame("VentanaCrearUsuarios");
        ventanaCrearUsuario.setContentPane(new VentanaCrearUsuarios().getpCrearUsuario());
        ventanaCrearUsuario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventanaCrearUsuario.pack();
        ventanaCrearUsuario.setLocationRelativeTo(ventanaAdministrador);
        ventanaCrearUsuario.setVisible(true);
    }

    public static void crearVentanaVerClasificacion(){
        JFrame frame = new JFrame("VentanaVerClasificacion");
        frame.setContentPane(new VentanaVerClasificacion().getVentanaVerClasidficacion());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(ventanaPrincipal);
        frame.setVisible(true);
    }

    public static void crearVentanaAsignarResultados(){
        VentanaAsignarResultados dialog = new VentanaAsignarResultados();
        dialog.pack();
        dialog.setLocationRelativeTo(ventanaAdministrador);
        dialog.setVisible(true);
    }

}

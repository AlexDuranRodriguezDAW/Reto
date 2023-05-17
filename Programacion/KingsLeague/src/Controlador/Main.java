package Controlador;

import Modelo.*;
import Vistas.Crud.VentanaBorrarEquipo;
import Vistas.Crud.VentanaCrearEquipo;
import Vistas.Crud.VentanaModificarEquipo;
import Vistas.VentanaAdministrador;
import Vistas.VentanaInicioSesion;
import Vistas.VentanaPrincipal;
import Vistas.VentanaVerEquipo;

import javax.swing.*;
import java.util.ArrayList;

public class Main {
    private static JFrame ventanaInicioSesion;
    private static JFrame ventanaPrincipal;
    private static Login usuarioActual ;

    public static void main(String[] args) throws Exception {
        try {
            crearVentanaInicioSesion();
        } catch (Exception e) {
            throw new Exception("Error al crear ventana inicio de sesion");
        }
    }

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

    public static void crearVentanaVerEquipo() {
        JFrame frame = new JFrame("VentanaVerEquipo");
        frame.setContentPane(new VentanaVerEquipo().getVentanaVerEquipo());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(ventanaPrincipal);
        frame.setVisible(true);
    }

    public static void crearVentanaAdministrador() {
        JFrame frame = new JFrame("VentanaAdministrador");
        frame.setContentPane(new VentanaAdministrador().getpPrincipal());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(ventanaPrincipal);
        frame.setVisible(true);
    }

    public static void crearVentanaCrearEquipo() {
        VentanaCrearEquipo dialog = new VentanaCrearEquipo();
        dialog.pack();
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }

    public static void crearVentanaBorrarEquipo() {
        VentanaBorrarEquipo dialog = new VentanaBorrarEquipo();
        dialog.pack();
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }

    public static void crearVentanaModificarEquipo() {
        VentanaModificarEquipo dialog = new VentanaModificarEquipo();
        dialog.pack();
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }

    public static void validarPassword(String usuario, String pass) throws Exception {
        Login lConsulta = new Login(usuario, pass);
        usuarioActual = TLogin.consultarUsuario(lConsulta);
        System.out.println("El usuario es " + usuarioActual.getUsuario() + " con pass " + usuarioActual.getContrasenya() + " y es tipo " + usuarioActual.getTipo());
        ventanaInicioSesion.dispose();
        crearVentanaPrincipal();
    }

    //********************************************CRUD EQUIPOS*************************************************************************
    public static ArrayList<String> sacarEquipos() throws Exception {
        ArrayList<Equipo> lista = TEquipo.seleccionarEquipo();
        ArrayList<String> listaEquipos = new ArrayList<>();
        for (int i = 0; i < lista.size(); i++) {
            listaEquipos.add(lista.get(i).getNombreEquipo());
        }
        return listaEquipos;
    }

    public static String buscarPorNombre(int equipo) throws Exception {
        ArrayList<Equipo> lista = TEquipo.seleccionarEquipo();
        String resumenEquipo = "El equipo " + lista.get(equipo).getNombreEquipo() + " su presidente es " + lista.get(equipo).getPropietario()
                + " tiene un presupuesto de " + lista.get(equipo).getPresupuesto() + " y " + lista.get(equipo).getSponsor() + " es su sponsor";
        return resumenEquipo;
    }

    public static ArrayList<Propietario> getPropietarios() throws Exception {
        return TPropietario.consultarTodos();
    }

    public static int crearEquipo(String nombre, String sponsor, Propietario propietario) throws Exception {
        Equipo e1 = new Equipo(nombre, 200000000.0, sponsor, propietario);
        return TEquipo.crearEquipo(e1);
    }

    public static ArrayList<Equipo> getEquipos() throws Exception {
        return TEquipo.consultarTodos();
    }

    public static int borrarEquipo(String nombre) throws Exception {
        return TEquipo.borrarEquipo(nombre);
    }
}

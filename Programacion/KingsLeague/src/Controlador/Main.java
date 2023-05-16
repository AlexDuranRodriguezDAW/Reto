package Controlador;

import Modelo.*;
import Vistas.Crud.VentanaCrearEquipo;
import Vistas.VentanaAdministrador;
import Vistas.VentanaInicioSesion;
import Vistas.VentanaPrincipal;
import Vistas.VentanaVerEquipo;

import javax.swing.*;
import java.util.ArrayList;

public class Main {
    private static JFrame ventanaInicioSesion;
    private static JFrame ventanaPrincipal;
    private static Login usuarioActual;

    public static void main(String[] args) throws Exception {
        try{
            crearVentanaInicioSesion();
        }catch (Exception e){
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
        dialog.setLocationRelativeTo(ventanaPrincipal);
        dialog.setVisible(true);
    }

    public static void validarPassword(String usuario,String pass) throws Exception {
        Login lConsulta = new Login(usuario,pass);
        usuarioActual = TLogin.consultarUsuario(lConsulta);
        System.out.println("El usuario es " + usuarioActual.getUsuario() + " con pass " + usuarioActual.getContrasenya() + " y es tipo " + usuarioActual.getTipo());
        ventanaInicioSesion.dispose();
        crearVentanaPrincipal();
    }

//********************************************CRUD EQUIPOS*************************************************************************
    public static ArrayList<String> sacarEquipos() throws  Exception{
        ArrayList<Equipo> lista = TEquipo.seleccionarEquipo();

        ArrayList<String> listaEquipos = new ArrayList<>();


        for (int i = 0; i < lista.size(); i++) {
            listaEquipos.add(lista.get(i).getNombreEquipo());
        }
        return listaEquipos;
    }

    public static void buscarPorNombre(Object nombre){
        String nombreEquipo = (String) nombre;
    }

    public static void llenarComboBoxPropietarios(JComboBox comboBox) throws Exception{
        ArrayList <Propietario> propietarios = TPropietario.consultarTodos();
        for (Propietario propietario:propietarios){
            comboBox.addItem(propietario.getDni());
        }
    }
}

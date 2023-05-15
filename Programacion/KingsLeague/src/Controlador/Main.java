package Controlador;

import Modelo.*;
import Vistas.VentanaInicioSesion;
import Vistas.VentanaPrincipal;
import Vistas.VentanaVerEquipo;

import javax.swing.*;
import java.util.ArrayList;

public class Main {
    private static JFrame ventanaInicioSesion;
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

    public static void crearVentanaPrincipal(){
        JFrame frame = new JFrame("VentanaPrincipal");
        frame.setContentPane(new VentanaPrincipal().getVentanaPrincipal());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(ventanaInicioSesion);
        frame.setVisible(true);
    }

    public static void crearVentanaVerEquipo() throws Exception {
        JFrame frame = new JFrame("VentanaVerEquipo");
        frame.setContentPane(new VentanaVerEquipo().getVentanaVerEquipo());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
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
}

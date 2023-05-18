package Controlador;

import Modelo.*;
import Vistas.*;
import Vistas.CrudAsistente.VentanaBorrarAsistente;
import Vistas.CrudAsistente.VentanaCrearAsistente;
import Vistas.CrudAsistente.VentanaModificarAsistente;
import Vistas.CrudEntrenador.VentanaBorrarEntrenador;
import Vistas.CrudEntrenador.VentanaCrearEntrenador;
import Vistas.CrudEquipo.VentanaBorrarEquipo;
import Vistas.CrudEquipo.VentanaCrearEquipo;
import Vistas.CrudEquipo.VentanaModificarEquipo;

import javax.swing.*;
import java.util.ArrayList;

public class Main {
    private static JFrame ventanaInicioSesion;
    private static JFrame ventanaPrincipal;
    private static Login usuarioActual;

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

    public static void crearVentanaAdministrador() {
        JFrame frame = new JFrame("VentanaAdministrador");
        frame.setContentPane(new VentanaAdministrador().getpPrincipal());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(ventanaPrincipal);
        frame.setVisible(true);
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

    public static void crearVentanBorrarEntrenador() throws Exception {
        VentanaBorrarEntrenador dialog = new VentanaBorrarEntrenador();
        dialog.pack();
        dialog.setVisible(true);
    }


    public static void crearVentanaBorrarAsitente() {
        VentanaBorrarAsistente dialog = new VentanaBorrarAsistente();
        dialog.pack();
        dialog.setVisible(true);
    }

    public static void crearVentanaCrearAsistente() {
        VentanaCrearAsistente dialog = new VentanaCrearAsistente();
        dialog.pack();
        dialog.setVisible(true);
    }

    public static void crearVentanaModificarAsistente() {
        VentanaModificarAsistente dialog = new VentanaModificarAsistente();
        dialog.pack();
        dialog.setVisible(true);
    }

    public static void crearVentanaCrearEntrenador() {
        VentanaCrearEntrenador dialog = new VentanaCrearEntrenador();
        dialog.pack();
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

    public static ArrayList<Equipo> listaEquipos;
    public static ArrayList<Propietario> listaPropietarios;

    public static void llenarComboBoxEquipo(JComboBox comboBox) throws Exception {
        listaEquipos = TEquipo.consultarTodos();
        for (Equipo equipo : listaEquipos) {
            comboBox.addItem(equipo.getNombreEquipo());
        }
    }

    public static void llenarComboBoxPropietario(JComboBox comboBox) throws Exception {
        listaPropietarios = TPropietario.consultarTodos();
        for (Propietario propietario : listaPropietarios) {
            comboBox.addItem(propietario.getNombre() + " " + propietario.getApellidos());
        }
    }

    public static String buscarPorNombre(int equipo) throws Exception {
        ArrayList<Equipo> lista = TEquipo.consultarTodos();
        //Casteos para cambiar de DOUBLE clase a int para mostrarlo mejor
        double pres = lista.get(equipo).getPresupuesto();
        int presu = (int) pres;
        String resumenEquipo = "El equipo " + lista.get(equipo).getNombreEquipo() + " su presidente es " + lista.get(equipo).getPropietario().getNombre() + " " + lista.get(equipo).getPropietario().getApellidos()
                + " tiene un presupuesto de " + presu + " y " + lista.get(equipo).getSponsor() + " es su sponsor";
        return resumenEquipo;
    }

    public static int crearEquipo(String nombre, String sponsor, int indexPropietario) throws Exception {
        Equipo e1 = new Equipo(nombre, 200000000.0, sponsor, listaPropietarios.get(indexPropietario));
        return TEquipo.crearEquipo(e1);
    }

    public static int borrarEquipo(String nombre) throws Exception {
        return TEquipo.borrarEquipo(nombre);
    }

    public static int modificarEquipo(String nombre, String sponsor, double presupuesto) throws Exception {
        Equipo e1 = new Equipo(nombre, presupuesto, sponsor);
        return TEquipo.modificarEquipo(e1);
    }

    public static String getSponsorEquipo(int index) {
        return listaEquipos.get(index).getSponsor();
    }

    public static double getPresupuestoEquipo(int index) {
        return listaEquipos.get(index).getPresupuesto();
    }

//***********************************CRUD JUGADORES****************************************************************************


    public static ArrayList<Jugador> listaJugadores;

    public static ArrayList<String> sacarJugadores() throws Exception {
        listaJugadores = TJugador.seleccionarJugadores();

        ArrayList<String> lista = new ArrayList<>();

        for (int i = 0; i < listaJugadores.size(); i++) {
            lista.add(listaJugadores.get(i).getNombre() + " " + listaJugadores.get(i).getApellidos());
        }
        return lista;
    }

    public static void crearPersonaJugadorDraft(String dni, String nombre, String apellido, String posicion, int indexEquipo, String tipoJugador, String numDraft) throws Exception {

        //Jugador j = new Jugador(dni,apellido,nombre,posicion,tipoJugador,numDraft);

        //TJugador.crearJugador(j);

    }

    public static void crearPersonaJugadorWildCard(String dni, String nombre, String apellido, String posicion, int indexEquipo, String tipoJugador) throws Exception {

        //Jugador j = new Jugador(dni,apellido,nombre,posicion,tipoJugador,numDraft);

        // TJugador.crearJugador(j);

    }

    public static void borrarJugador(int numero) throws Exception {
        String nombre = listaJugadores.get(numero).getNombre();
        String apellido = listaJugadores.get(numero).getApellidos();
        TJugador.borrarJugador(nombre, apellido);
    }

    public static void modificarJugador() {

    }

//********************************************CRUD ENTRENADOS **********************************************************

    public static ArrayList<Entrenador> listaEntrenadores;

    public static ArrayList<String> sacarEntrenadores() throws Exception {
        listaEntrenadores = TEntrenador.seleccionarEntrenador();
        ArrayList<String> lista = new ArrayList<>();

        for (int i = 0; i < listaEntrenadores.size(); i++) {
            lista.add(listaEntrenadores.get(i).getNombre() + " " + listaEntrenadores.get(i).getApellidos());
        }
        return lista;
    }

    public static void crearEntrenador(String nombre, String apellido, String dni) throws Exception {

        Entrenador e = new Entrenador(nombre, apellido, dni);
        TEntrenador.crearPersonaEntrenador(e);
    }

    public static void borrarEntrenador(String nombre, String apellido) throws Exception {

        Entrenador e = new Entrenador(apellido, nombre);
        TPersona.borrarPersonaEntrenador(e);

    }


    public static void modificarEntrenador() {

    }

}

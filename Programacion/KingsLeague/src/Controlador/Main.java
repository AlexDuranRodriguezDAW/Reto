package Controlador;

import Modelo.*;

import javax.swing.*;
import java.util.ArrayList;

import static Controlador.ControladorVentanas.ventanaInicioSesion;


/**
 * Esta clase es el controlador principal del programa y el que se encarga de comunicar las vistas con las clases con la base de datos.
 * @author Grupo 3
 * @version 1.0
 * @since 23/05/2023
 */
public class Main {
    private static Login usuarioActual;
    private static ArrayList<Entrenador> listaEntrenadores;
    private static ArrayList<Equipo> listaEquipos;
    private static ArrayList<Propietario> listaPropietarios;
    private static ArrayList<Jugador> listaJugadores;
    private static ArrayList<Staff> listaAsistentes;


    public static void main(String[] args) throws Exception {
        try {
            ControladorVentanas.crearVentanaInicioSesion();

        } catch (Exception e) {
            throw new Exception("Error al crear ventana inicio de sesion");
        }
    }

    public static void validarPassword(String usuario, String pass) throws Exception {
        Login lConsulta = new Login(usuario, pass);
        usuarioActual = TLogin.consultarUsuario(lConsulta);
        System.out.println("El usuario es " + usuarioActual.getUsuario() + " con pass " + usuarioActual.getContrasenya() + " y es tipo " + usuarioActual.getTipo());
        ventanaInicioSesion.dispose();
        ControladorVentanas.crearVentanaPrincipal();
    }

//********************************************CRUD EQUIPOS**************************************************************


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

//*********************************************CRUD JUGADORES***********************************************************

    public static void llenarComboBoxJugador(JComboBox comboBox) throws Exception {
        listaJugadores = TJugador.consultarTodos();
        for (Jugador jugador : listaJugadores) {
            comboBox.addItem(jugador.getNombre() + " " + jugador.getApellidos());
        }
    }

    public static void crearPersonaJugador(String dni, String nombre, String apellido, String posicion, int indexEquipo, String tipoJugador, String numDraft, double sueldo, double clausula) throws Exception {
        Jugador j1;
        if (tipoJugador.equalsIgnoreCase("draft")) {
            j1 = new Jugador(dni, apellido, nombre, posicion, Jugador.TipoJugador.draft, numDraft);
        } else {
            j1 = new Jugador(dni, apellido, nombre, posicion, Jugador.TipoJugador.wildcard, numDraft);
        }
        TJugador.crearJugador(j1);
        asignarJugadorEquipo(dni, indexEquipo, sueldo, clausula);
    }

    public static void asignarJugadorEquipo(String dni, int indexEquipo, double sueldo, double clausula) throws Exception {
        Jugador j1 = new Jugador();
        j1.setDni(dni);
        Jugador jConsulta = new Jugador();
        jConsulta.setId(TPersona.buscarIdJugador(j1));
        Equipo eConsulta = listaEquipos.get(indexEquipo);
        ContratoJugador cj = new ContratoJugador(jConsulta, eConsulta, clausula, sueldo);
        TContratoJugador.crearContratoJugador(cj);
    }

    public static int borrarJugador(int numero) throws Exception {
        Jugador j1 = listaJugadores.get(numero);
        return TPersona.borrarPersonaJugadorf(j1);
    }

    public static void modificarJugador(int indexEquipo, int indexJugador, String clausula, String sueldo) throws Exception {
        Equipo equipo = listaEquipos.get(indexEquipo);
        Jugador jugador = listaJugadores.get(indexJugador);
        double clausulaD = Double.parseDouble(clausula);
        double sueldoD = Double.parseDouble(sueldo);
        ContratoJugador cj = new ContratoJugador(jugador, equipo, clausulaD, sueldoD);
        TContratoJugador.modificarJugador(cj);
    }

//********************************************CRUD ENTRENADORES ********************************************************

    public static void crearEntrenador(String nombre, String apellido, String dni, int i, String sueldo) throws Exception {

        String equipo = listaEquipos.get(i).getNombreEquipo();

        Entrenador e = new Entrenador(nombre, apellido, dni);
        TEntrenador.crearPersonaEntrenador(e, equipo, sueldo);
    }

    public static void borrarEntrenador(int indexEntrenador) throws Exception {


        String nombre = listaEntrenadores.get(indexEntrenador).getNombre();
        String apellido = listaEntrenadores.get(indexEntrenador).getApellidos();
        Entrenador e = new Entrenador(apellido, nombre);
        TPersona.borrarPersonaEntrenador(e);

    }

    public static void llenarComboBoxEntrenador(JComboBox comboBox) throws Exception {
        listaEntrenadores = TEntrenador.consultarTodos();
        for (Entrenador entrenador : listaEntrenadores) {
            comboBox.addItem(entrenador.getNombre() + " " + entrenador.getApellidos());
        }
    }

    public static void modificarEntrenador(int entrenador, int equipo, String sueldo) throws Exception {
        EntrenadorEquipo ee = new EntrenadorEquipo(listaEquipos.get(equipo), listaEntrenadores.get(entrenador), Double.parseDouble(sueldo));
        TEntrenadorEquipo.modificarEntrenadorEquipo(ee);
    }

//********************************************CRUD ASISTENTES***********************************************************

    public static void llenarComboBoxAsistente(JComboBox comboBox) throws Exception {
        listaAsistentes = TStaff.consultarTodos();
        for (Staff staff : listaAsistentes) {
            comboBox.addItem(staff.getNombre() + " " + staff.getApellidos());
        }
    }

    public static int crearAsistente(String dni, String nombre, String apellidos) throws Exception {
        Staff s1 = new Staff(dni, apellidos, nombre);
        return TStaff.crearPersonaStaff(s1);
    }

    public static void asignarAsistenteEquipo(String dni, int indexEquipo, double sueldo) throws Exception {
        Staff s1 = new Staff();
        s1.setDni(dni);
        Staff sConsulta = new Staff();
        sConsulta.setId(TPersona.buscarIdStaff(s1));
        Equipo eConsulta = listaEquipos.get(indexEquipo);
        StaffEquipo se = new StaffEquipo(eConsulta, sConsulta, sueldo);
        TStaffEquipo.crearPersonaStaffEquipo(se);
    }

    public static int borrarAsistente(int indexAsistente) throws Exception {
        return TPersona.borrarPersonaStaff(listaAsistentes.get(indexAsistente));
    }

    public static double getSueldo(int indexAsistente) throws Exception {
        return TStaffEquipo.getSueldoId(listaAsistentes.get(indexAsistente));
    }

    public static int modificarAsistente(int indexEquipo, int indexAsistente, double sueldo) throws Exception {
        StaffEquipo se = new StaffEquipo(listaEquipos.get(indexEquipo), listaAsistentes.get(indexAsistente), sueldo);
        return TStaffEquipo.modificarStaffEquipo(se);
    }


//************************************************CRUD DUEÑO************************************************************


    public static int borrarDuenio(int indexDuenio) throws Exception {
        return TPersona.borrarPersonaPropietario(listaPropietarios.get(indexDuenio));
    }

    public static void crearDuenio(String dni, String nombre, String apellido, int indexEquipo) throws Exception {
        String nombreEquipo = listaEquipos.get(indexEquipo).getNombreEquipo();
        Propietario p = new Propietario(dni, nombre, apellido);

        TPropietario.crearPropietario(p, nombreEquipo);

    }

    public static void modificarPropietario(String dni, String nombre, String apellido) throws Exception {
        Propietario p = new Propietario(dni, nombre, apellido);
        TPersona.modificarPropietario(p);

    }


//************************************************METODOS USUARIO*********************************************************

    public static String getUsuario() {
        String usuario = usuarioActual.getUsuario();
        return usuario;

    }

    public static String getTipoUsuario() {
        String tipo = String.valueOf(usuarioActual.getTipo());
        return tipo;
    }

    public static int crearUsuario(String usuario, String pass, Boolean admin) throws Exception {
        Login l1 = new Login(usuario, pass);
        if (!admin) {
            l1.setTipo(Login.tipo.usuario);
        } else {
            l1.setTipo(Login.tipo.admin);
        }
        return TLogin.insertar(l1);
    }

//**********************************************GENERAR PARTIDOS********************************************************

    public static void emparejarLigaRegular() throws Exception {
        TJornada.emparejarLigaRegular();
    }

    public static void emparejarPlayOff() throws Exception {
        TJornada.emparejarPlayOff();
    }

    public static String sacarClasificacion() throws Exception {
        ArrayList<Equipo> clasificacion = TJornada.sacarClasificacion();

        String clasifi = "1º" + clasificacion.get(1).getNombreEquipo()
                + "\n 2º " + clasificacion.get(2).getNombreEquipo()
                + "\n3º" + clasificacion.get(3).getNombreEquipo()
                + "\n4º" + clasificacion.get(4).getNombreEquipo()
                + "\n5º" + clasificacion.get(5).getNombreEquipo()
                + "\n6º" + clasificacion.get(6).getNombreEquipo()
                + "\n7º" + clasificacion.get(7).getNombreEquipo()
                + "\n8º" + clasificacion.get(8).getNombreEquipo()
                + "\n9º" + clasificacion.get(9).getNombreEquipo()
                + "\n10º" + clasificacion.get(10).getNombreEquipo()
                + "\n11º" + clasificacion.get(11).getNombreEquipo()
                + "\n12º" + clasificacion.get(12).getNombreEquipo();

        return clasifi;


    }
}

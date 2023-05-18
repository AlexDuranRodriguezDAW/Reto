package Controlador;

import Modelo.*;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;

import static Controlador.ControladorVentanas.ventanaInicioSesion;

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



    public static void llenarComboBoxJugador(JComboBox comboBox) throws Exception{
        listaJugadores = TJugador.seleccionarJugadores();
        for (int i = 0; i < listaJugadores.size(); i++) {
            comboBox.addItem(listaJugadores.get(i).getNombre() + " " + listaJugadores.get(i).getApellidos());
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


    public static ArrayList<String> sacarJugadores() throws Exception {
        listaJugadores = TJugador.seleccionarJugadores();

        ArrayList<String> lista = new ArrayList<>();

        for (int i = 0; i < listaJugadores.size(); i++) {
            lista.add(listaJugadores.get(i).getNombre() + " " + listaJugadores.get(i).getApellidos());
        }
        return lista;
    }

    public static void crearPersonaJugador(String dni, String nombre, String apellido, String posicion, int indexEquipo, String tipoJugador, String numDraft,double sueldo,double clausula) throws Exception {
        Jugador j1;
        if (tipoJugador.equalsIgnoreCase("draft")){
            j1 = new Jugador(dni,apellido,nombre,posicion, Jugador.TipoJugador.draft,numDraft);
        }else {
            j1 = new Jugador(dni,apellido,nombre,posicion, Jugador.TipoJugador.wildcard,numDraft);
        }
        TJugador.crearJugador(j1);
        asignarJugadorEquipo(dni,indexEquipo,sueldo,clausula);
    }

    public static void asignarJugadorEquipo(String dni, int indexEquipo, double sueldo,double clausula) throws Exception {
        Jugador j1 = new Jugador();
        j1.setDni(dni);
        Jugador jConsulta = new Jugador();
        jConsulta.setId(TPersona.buscarIdJugador(j1));
        Equipo eConsulta = listaEquipos.get(indexEquipo);
        ContratoJugador cj = new ContratoJugador(jConsulta,eConsulta,clausula,sueldo);
        TContratoJugador.crearContratoJugador(cj);
    }

    public static void borrarJugador(int numero) throws Exception {
        String nombre = listaJugadores.get(numero).getNombre();
        String apellido = listaJugadores.get(numero).getApellidos();
        TJugador.borrarJugador(nombre, apellido);
    }

    public static void modificarJugador(int indexEquipo, int indexJugador, String posicion, String clausula, String sueldo) {

        String equipo = listaEquipos.get(indexEquipo).getNombreEquipo();
        String jugadorNombre = listaJugadores.get(indexJugador).getNombre();
        String jugadorApellido = listaJugadores.get(indexJugador).getApellidos();
        Jugador jugador = new Jugador(jugadorApellido,jugadorNombre,posicion);
        TJugador.modificarJugador(jugador,clausula,sueldo,equipo);

    }

//********************************************CRUD ENTRENADORES ********************************************************


    public static ArrayList<String> sacarEntrenadores() throws Exception {
        listaEntrenadores = TEntrenador.seleccionarEntrenador();
        ArrayList<String> lista = new ArrayList<>();

        for (int i = 0; i < listaEntrenadores.size(); i++) {
            lista.add(listaEntrenadores.get(i).getNombre() + " " + listaEntrenadores.get(i).getApellidos());
        }
        return lista;
    }

    public static void crearEntrenador(String nombre, String apellido, String dni,int i,String sueldo) throws Exception {

        String equipo =listaEquipos.get(i).getNombreEquipo();

        Entrenador e = new Entrenador(nombre, apellido, dni);
        TEntrenador.crearPersonaEntrenador(e,equipo,sueldo);
    }

    public static void borrarEntrenador(int indexEntrenador) throws Exception {


        String nombre = listaEntrenadores.get(indexEntrenador).getNombre();
        String apellido = listaEntrenadores.get(indexEntrenador).getApellidos();
        Entrenador e = new Entrenador(apellido, nombre);
        TPersona.borrarPersonaEntrenador(e);

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

       return  TPersona.borrarPersonaPropietario(listaPropietarios.get(indexDuenio));

    }

    public static void crearDuenio(String dni, String nombre, String apellido, int indexEquipo) throws Exception {
        String nombreEquipo = listaEquipos.get(indexEquipo).getNombreEquipo();
        Propietario p = new Propietario(dni,nombre,apellido);

        TPropietario.crearPropietario(p,nombreEquipo);

    }



//************************************************SACAR USUARIO*********************************************************

    public static String getUsuario()
    {

        String usuario = usuarioActual.getUsuario();

        return usuario;

    }

//**********************************************GENERAR PARTIDOS********************************************************

    public static void emparejarLigaRegular() throws SQLException {
        TJornada.emparejarLigaRegular();
    }

    public static void emparejarPlayOff() throws SQLException {
        TJornada.emparejarPlayOff();
    }

}

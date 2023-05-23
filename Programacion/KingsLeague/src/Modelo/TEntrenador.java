package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Clase encargada de relacionar la clase Entranador con la base de datos
 * @author Grupo 3
 * @version 1.0
 * @since 23/05/2023
 * @see Entrenador
 */

public class TEntrenador {

    public static void crearPersonaEntrenador(Entrenador e, String equipo, String sueldo) throws Exception {
        BaseDatos.abrirConexion();
        TPersona.insertarEntrenador(e);
        String id = TPersona.buscarIdEntrenador(e);
        PreparedStatement ps = BaseDatos.getCon().prepareStatement("insert into entrenadores values(?)");
        ps.setString(1, id);
        int n = ps.executeUpdate();
        if (n == 0) {
            System.out.println("error");
        } else {
            insertarEquipoEntrenador(id, equipo, sueldo);
        }
        BaseDatos.cerrarConexion();
    }

    public static void insertarEquipoEntrenador(String id, String equipo, String sueldo) throws Exception {
        BaseDatos.abrirConexion();
        String idEquipo = TEquipo.buscarIDEquipo(equipo);

        PreparedStatement ps = BaseDatos.getCon().prepareStatement("insert into entrenadorEquipos (idEntrenador,idEquipo,sueldo,fechaInicio) values(?,?,?,?)");
        ps.setString(1, id);
        ps.setString(2, idEquipo);
        ps.setString(3, sueldo);
        ps.setString(4, String.valueOf(LocalDate.now()));

        int n = ps.executeUpdate();

        BaseDatos.cerrarConexion();

        if (n == 0) {
            System.out.println("error");
        }
    }

    /**
     * Metodo que mediante una consulta de dos tablas devuelve todos los datos de los entrenadores
     * @return Arraylist de la clase Entrenador que devuelve todos los entrenadores de la bdd
     * @throws Exception puede devolver Exception con la base de datos si esta vacio
     */
    public static ArrayList<Entrenador> consultarTodos() throws Exception {
        BaseDatos.abrirConexion();
        PreparedStatement ps = BaseDatos.getCon().prepareStatement("Select * from entrenadores e, personas x where e.id= x.id ");
        ResultSet rs = ps.executeQuery();
        ArrayList<Entrenador> entrenadores = new ArrayList<>();
        while (rs.next()) {
            Entrenador e1 = new Entrenador(rs.getString("id"), rs.getString("dni"),
                    rs.getString("nombre"), rs.getString("apellido"));
            entrenadores.add(e1);
        }
        return entrenadores;
    }

}

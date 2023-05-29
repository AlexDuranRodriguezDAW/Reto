package Modelo;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Clase encargada de relacionar la clase Jornada con la base de datos, esta clase tambien lanza procesos de la base de datos
 *
 * @author Grupo 3
 * @version 1.0
 * @see Jornada
 * @since 23/05/2023
 */

public class TJornada {

    public static void emparejarLigaRegular() throws SQLException {
        BaseDatos.abrirConexion();
        PreparedStatement ps1 = BaseDatos.getCon().prepareStatement("INSERT INTO SPLIT (FECHAINICIO, TIPO) VALUES (SYSDATE, 'abierto')");
        CallableStatement call1 = BaseDatos.getCon().prepareCall("{CALL DATOSCALENDARIO.EMPAREJARLIGAREGULAR()}");
        PreparedStatement ps2 = BaseDatos.getCon().prepareStatement("UPDATE SPLIT SET TIPO = 'cerrado' WHERE ID = (SELECT MAX(ID) FROM SPLIT)");
        ps1.executeUpdate();
        call1.executeUpdate();
        ps2.executeUpdate();
        BaseDatos.cerrarConexion();
    }

    public static void emparejarPlayOff() throws SQLException {
        BaseDatos.abrirConexion();
        CallableStatement call2 = BaseDatos.getCon().prepareCall("{CALL DATOSCALENDARIO.EMPAREJARPLAYOFF()}");
        call2.executeUpdate();
        BaseDatos.cerrarConexion();
    }

    public static ArrayList<Equipo> sacarClasificacion() throws SQLException {
        BaseDatos.abrirConexion();
        PreparedStatement preparedStatement = BaseDatos.getCon().prepareStatement("Select e.nombre" +
                "from partidos p, equipos e" +
                "where p.idEquipoGana = e.id\n" +
                "order by  p.idEquipoGana desc;");
        ResultSet rs = preparedStatement.executeQuery();
        ArrayList<Equipo> listaClasificacion = new ArrayList<>();
        Equipo e = new Equipo();
        while (rs.next()) {
            e.setNombreEquipo(rs.getString("nombre"));
            listaClasificacion.add(e);
        }
        BaseDatos.cerrarConexion();
        return listaClasificacion;
    }

    public static ArrayList<Jornada> getIdJornada() throws Exception {
        BaseDatos.abrirConexion();
        PreparedStatement ps = BaseDatos.getCon().prepareStatement("select id from jornadas where idsplit = (select max(id) from split)");
        ResultSet resultSet = ps.executeQuery();
        ArrayList<Jornada> jornadas = new ArrayList<>();
        while (resultSet.next()) {
            Jornada j1 = new Jornada();
            j1.setId(resultSet.getString("id"));
            jornadas.add(j1);
        }
        BaseDatos.cerrarConexion();
        return jornadas;
    }
}

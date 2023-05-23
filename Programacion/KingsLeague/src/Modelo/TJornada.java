package Modelo;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Clase encargada de relacionar la clase Jornada con la base de datos, esta clase tambien lanza procesos de la base de datos
 * @author Grupo 3
 * @version 1.0
 * @since 23/05/2023
 * @see Jornada
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
                "from jornadas j, equipos e" +
                "where j.idEquipoGana = e.id\n" +
                "order by  j.idEquipoGana desc;");
        ResultSet rs = preparedStatement.executeQuery();
        ArrayList<Equipo> listaClasificacion = new ArrayList<>();
        Equipo e = new Equipo();
        while (rs.next()) {
            e.getNombreEquipo();
            listaClasificacion.add(e);
        }
        BaseDatos.cerrarConexion();
        return listaClasificacion;
    }
}

package Modelo;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TJornada {

    public static void emparejarLigaRegular() throws SQLException {
        BaseDatos.abrirConexion();

        PreparedStatement ps1 = BaseDatos.getCon().prepareStatement("INSERT INTO SPLIT (FECHAINICIO, TIPO)" +
                                                                        "VALUES (SYSDATE, 'abierto')");

        CallableStatement call1 = BaseDatos.getCon().prepareCall("{CALL DATOSCALENDARIO.EMPAREJARLIGAREGULAR()}");

        PreparedStatement ps2 = BaseDatos.getCon().prepareStatement("UPDATE SPLIT " +
                                                                        "SET TIPO = 'cerrado'" +
                                                                        "WHERE ID = (SELECT MAX(ID) FROM SPLIT)");


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

}

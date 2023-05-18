package Modelo;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TJornada {

    public static void emparejarLigaRegular() throws SQLException {
        BaseDatos.abrirConexion();

        PreparedStatement ps = BaseDatos.getCon().prepareStatement("BEGIN" +
                                                                       "INSERT INTO SPLIT(FECHAINICIO,TIPO)" +
                                                                       "VALUES (SYSDATE,'abierto')" +
                                                                       "DATOSCALENDARIO.EMPAREJARLIGAREGULAR();" +
                                                                       "END ");
        ps.execute();

        BaseDatos.cerrarConexion();
    }

    public static void emparejarPlayOff() throws SQLException {
        BaseDatos.abrirConexion();

        PreparedStatement ps = BaseDatos.getCon().prepareStatement("BEGIN" +
                                                                       "DATOSCALENDARIO.EMPAREJARPlAYOFF();" +
                                                                       "END ");
        ps.execute();

        BaseDatos.cerrarConexion();
    }

}

package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDatos {

    private static Connection con;


    public static void abrirConexion() throws SQLException {
        try {
/*
            Class.forName("oracle.jdbc.OracleDriver");
            String url="jdbc:oracle:thin:@172.20.225.114:1521:orcl";
            String usuario="eqdaw03";
            String contrasenya="eqdaw03";

*/
            //Codigo para pruebas en la base de datos de local
            Class.forName("oracle.jdbc.OracleDriver");
            String url = "jdbc:oracle:thin:@10.100.11.196:1521:xe";
            String usuario = "alex";
            String contrasenya = "12345";

            con = DriverManager.getConnection(url, usuario, contrasenya);

        } catch (Exception e) {
            System.out.println("Problemas al abrir la base de datos " + e.getMessage());
        }
    }

    public static void cerrarConexion() {
        try {
            con.close();
        } catch (Exception e) {
            System.out.println("Problemas con la base de datos " + e.getClass());
        }
    }


    public static Connection getCon() {
        return con;
    }
}

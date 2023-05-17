package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDatos {

    private static Connection con;


    public static void abrirConexion() throws SQLException {
        try {

<<<<<<< Updated upstream

=======
>>>>>>> Stashed changes
            Class.forName("oracle.jdbc.OracleDriver");
            String url="jdbc:oracle:thin:@172.20.225.114:1521:orcl";
            String usuario="eqdaw03";
            String contrasenya="eqdaw03";
<<<<<<< Updated upstream

/*
=======
            /*
>>>>>>> Stashed changes
            //Codigo para pruebas en la base de datos de local
            Class.forName("oracle.jdbc.OracleDriver");
            String url = "jdbc:oracle:thin:@10.100.11.196:1521:xe";
            String usuario = "alex";
<<<<<<< Updated upstream
            String contrasenya = "12345";
*/
=======
            String contrasenya = "12345";ç

             */

>>>>>>> Stashed changes
            con = DriverManager.getConnection(url, usuario, contrasenya);

        } catch (Exception e) {

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

package Modelo;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TEntrenador {

    public static void insertar(Persona p) throws Exception {
        BaseDatos.abrirConexion();

        PreparedStatement ps = BaseDatos.getCon().prepareStatement("Insert into Entrenadores (id) values (?)");

        ps.setString(1, p.getDni());



        BaseDatos.cerrarConexion();
    }
}

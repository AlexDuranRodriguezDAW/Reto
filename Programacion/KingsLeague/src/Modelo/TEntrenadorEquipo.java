package Modelo;

import java.sql.PreparedStatement;

/**
 * Clase encargada de relacionar la clase EntrenadorEquipo con la base de datos
 * @author Grupo 3
 * @version 1.0
 * @since 23/05/2023
 * @see EntrenadorEquipo
 */

public class TEntrenadorEquipo {

    public static int modificarEntrenadorEquipo(EntrenadorEquipo ee) throws Exception {
        BaseDatos.abrirConexion();
        PreparedStatement preparedStatement = BaseDatos.getCon().prepareStatement("Update entrenadorequipos set equipo=? , sueldo = ? where identrenador = ?");
        preparedStatement.setString(1, ee.getEquipo().getId());
        preparedStatement.setDouble(2, ee.getSueldo());
        preparedStatement.setString(3, ee.getEntrenador().getId());
        int n = preparedStatement.executeUpdate();
        BaseDatos.cerrarConexion();
        return n;
    }

}

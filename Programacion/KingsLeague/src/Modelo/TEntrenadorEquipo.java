package Modelo;

import java.sql.PreparedStatement;

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

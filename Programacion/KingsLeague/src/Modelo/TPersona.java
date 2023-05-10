package Modelo;

import java.sql.PreparedStatement;

public class TPerdona {

    public static void crearPersona() throws  Exception{
        BaseDatos.abrirConexion();

        PreparedStatement ps = BaseDatos.getCon().prepareStatement("insert into Personas () values");

        BaseDatos.cerrarConexion();

    }

}

package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TPersona {

    public static void crearPersonaEntrenador() throws  Exception{
        BaseDatos.abrirConexion();

        PreparedStatement ps = BaseDatos.getCon().prepareStatement("insert into Personas (dni,nombre,apellido) values(?,?,?);");

        ps.setString(1,p.getDni());
        ps.setString(2,p.getNombre());
        ps.setString(3,p.getApellidos());

        BaseDatos.cerrarConexion();

    }

    //Funcion para sacar el ID que tenga la persona para luego insertarlo en ENTRNADOR/STAFF

    public static void buscarPersona() throws Exception{
        BaseDatos.abrirConexion();

        PreparedStatement ps =BaseDatos.getCon().prepareStatement("Select id from personas where dni = ?");
        ps.setString(1,p.getDni());
        ResultSet rs = ps.executeQuery();



        if (rs.next()){

        }


        BaseDatos.cerrarConexion();
    }

}

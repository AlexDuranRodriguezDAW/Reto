package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TEntrenador {

    public static void crearPersonaEntrenador(Entrenador e) throws  Exception{
        BaseDatos.abrirConexion();
        TPersona.insertarEntrenador(e);
        String id = TPersona.buscarIdEntrenador(e);
        PreparedStatement ps = BaseDatos.getCon().prepareStatement("insert into entrenadores values(?)");
        ps.setString(1,id);
        int n = ps.executeUpdate();
        if (n==0){
            System.out.println("error");
        }
        BaseDatos.cerrarConexion();

    }




}

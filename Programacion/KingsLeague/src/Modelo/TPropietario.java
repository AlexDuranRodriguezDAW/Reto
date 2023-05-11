package Modelo;

import java.sql.PreparedStatement;

public class TPropietario {

    public static void crearPersonaPropietario(Propietario propietario) throws  Exception{
        BaseDatos.abrirConexion();
        TPersona.insertarPropietario(propietario);
        String id = TPersona.buscarIdPropietario(propietario);
        PreparedStatement ps = BaseDatos.getCon().prepareStatement("insert into Duenyos values(?)");
        ps.setString(1,id);
        int n = ps.executeUpdate();
        if (n==0){
            System.out.println("error");
        }
        BaseDatos.cerrarConexion();

    }

}

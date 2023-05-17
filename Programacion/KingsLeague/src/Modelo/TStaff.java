package Modelo;

import java.sql.PreparedStatement;

public class TStaff {

    public static void crearPersonaStaff(Staff s) throws Exception {
        BaseDatos.abrirConexion();
        TPersona.insertarStaff(s);
        String id = TPersona.buscarIdStaff(s);
        PreparedStatement ps = BaseDatos.getCon().prepareStatement("insert into asistentes values (?)");
        ps.setString(1, id);
        int n = ps.executeUpdate();
        if (n == 0) {
            System.out.println("error");
        }
        BaseDatos.cerrarConexion();
    }


}

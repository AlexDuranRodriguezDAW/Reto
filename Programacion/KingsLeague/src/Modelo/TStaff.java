package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class TStaff {

    public static int crearPersonaStaff(Staff s) throws Exception {
        BaseDatos.abrirConexion();
        TPersona.insertarStaff(s);
        String id = TPersona.buscarIdStaff(s);
        PreparedStatement ps = BaseDatos.getCon().prepareStatement("insert into asistentes values (?)");
        ps.setString(1, id);
        int n = ps.executeUpdate();
        BaseDatos.cerrarConexion();
        return n;
    }

    public static ArrayList<Staff> consultarTodos() throws Exception {
        BaseDatos.abrirConexion();
        PreparedStatement ps = BaseDatos.getCon().prepareStatement("Select * from personas p, asistentes x where p.id= x.id ");
        ResultSet rs = ps.executeQuery();
        ArrayList<Staff> staffs = new ArrayList<>();
        while (rs.next()) {
            Staff s1 = new Staff(rs.getString("id"), rs.getString("dni"), rs.getString("apellido"), rs.getString("nombre"));
            staffs.add(s1);
        }
        BaseDatos.cerrarConexion();
        return staffs;
    }

}

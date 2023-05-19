package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class TPropietario {

    public static void crearPropietario(Propietario propietario, String nombreEquipo) throws Exception {
        BaseDatos.abrirConexion();
        TPersona.insertarPropietario(propietario);
        String id = TPersona.buscarIdPropietario(propietario);
        PreparedStatement ps = BaseDatos.getCon().prepareStatement("insert into Duenyos values(?)");
        ps.setString(1, id);
        int n = ps.executeUpdate();
        if (n == 0) {
            System.out.println("error");
        }
        BaseDatos.cerrarConexion();
    }

    //Esta funcion saca datos tanto como de personas como de dueños
    public static ArrayList<Propietario> consultarTodos() throws Exception {
        BaseDatos.abrirConexion();
        PreparedStatement ps = BaseDatos.getCon().prepareStatement("Select * from personas p, duenyos x where p.id= x.id ");
        ResultSet rs = ps.executeQuery();
        ArrayList <Propietario> propietarios = new ArrayList<>();
        while (rs.next()){
            Propietario p1 = new Propietario(rs.getString("id"),rs.getString("dni"),rs.getString("apellido"),rs.getString("nombre"));
            propietarios.add(p1);
        }
        BaseDatos.cerrarConexion();
        return propietarios;
    }

}

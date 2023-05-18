package Modelo;


import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;

public class TStaffEquipo {

    public static void crearPersonaStaffEquipo(StaffEquipo se) throws Exception {
        BaseDatos.abrirConexion();
        PreparedStatement ps = BaseDatos.getCon().prepareStatement("insert into asistenteequipos values (?,?,?,?,?)");
        ps.setString(1, se.getStaff().getId());
        ps.setString(2, se.getEquipo().getId());
        ps.setDouble(3, se.getSueldo());
        ps.setDate(4, Date.valueOf(LocalDate.now()));
        ps.setDate(5, Date.valueOf(LocalDate.now().plusYears(1)));
        int n = ps.executeUpdate();
        BaseDatos.cerrarConexion();
    }

    public static double getSueldoId(Staff s) throws Exception {
        BaseDatos.abrirConexion();
        PreparedStatement ps = BaseDatos.getCon().prepareStatement("select * from asistenteequipos where idasistente = ?");
        ps.setString(1, s.getId());
        ResultSet rs = ps.executeQuery();
        double sueldo = 0;
        if (rs.next()) {
            sueldo = rs.getDouble("sueldo");
        }
        return sueldo;
    }

    public static int modificarStaffEquipo(StaffEquipo se) throws Exception {
        BaseDatos.abrirConexion();
        PreparedStatement preparedStatement = BaseDatos.getCon().prepareStatement("Update asistenteequipos set sueldo=? , idequipo = ? where idasistente = ?");
        preparedStatement.setDouble(1, se.getSueldo());
        preparedStatement.setString(2, se.getEquipo().getId());
        preparedStatement.setString(3, se.getStaff().getId());
        int n = preparedStatement.executeUpdate();
        BaseDatos.cerrarConexion();
        return n;
    }

}

package Modelo;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.time.LocalDate;

public class TContratoJugador {

    public static void crearContratoJugador(ContratoJugador cj) throws Exception {
        BaseDatos.abrirConexion();
        PreparedStatement ps = BaseDatos.getCon().prepareStatement("insert into jugadoresequipos values (?,?,?,?,?,?)");
        ps.setString(1, cj.getJugador().getId());
        ps.setString(2, cj.getEquipo().getId());
        ps.setDouble(3, cj.getSueldo());
        ps.setDate(4, Date.valueOf(LocalDate.now()));
        ps.setDate(5, Date.valueOf(LocalDate.now().plusYears(1)));
        ps.setDouble(6, cj.getClausula());
        int n = ps.executeUpdate();
        BaseDatos.cerrarConexion();
    }
}

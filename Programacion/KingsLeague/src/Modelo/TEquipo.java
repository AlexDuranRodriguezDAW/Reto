package Modelo;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class TEquipo {

    public static int crearEquipo(Equipo e) throws Exception{

        BaseDatos.abrirConexion();

        PreparedStatement ps = BaseDatos.getCon().prepareStatement("Insert into Equipos (nombre,presupuesto,sponsor,idDuenyo) values (?,?,?,?)");
        ps.setString(1,e.getNombreEquipo());
        ps.setDouble(2,e.getPresupuesto());
        ps.setString(3,e.getSponsor());
        ps.setString(4,e.getPropietario().getId());
        int n = ps.executeUpdate();
        BaseDatos.cerrarConexion();
        return n;
    }

    public static int borrarEquipo(String equipo) throws  Exception{
        BaseDatos.abrirConexion();
        PreparedStatement ps = BaseDatos.getCon().prepareStatement("Delete from equipos where nombre = ?");
        ps.setString(1,equipo);
        int n = ps.executeUpdate();
        BaseDatos.cerrarConexion();
        return n;
    }

    public static int modificarEquipo(Equipo equipo) throws Exception{
        BaseDatos.abrirConexion();
        PreparedStatement preparedStatement = BaseDatos.getCon().prepareStatement("Update equipos set sponsor=? , presupuesto = ? where nombre = ?");
        preparedStatement.setString(1,equipo.getSponsor());
        preparedStatement.setDouble(2,equipo.getPresupuesto());
        preparedStatement.setString(3,equipo.getNombreEquipo());
        int n = preparedStatement.executeUpdate();
        BaseDatos.cerrarConexion();
        return n;
    }



    public static ArrayList<Equipo> consultarTodos () throws Exception{
        BaseDatos.abrirConexion();
        PreparedStatement ps = BaseDatos.getCon().prepareStatement("select * from equipos");
        ResultSet rs = ps.executeQuery();
        ArrayList <Equipo> equipos = new ArrayList<>();
        while (rs.next()){
            Equipo e1 = new Equipo(rs.getString("id"),rs.getString("nombre"),rs.getDouble("presupuesto"),rs.getString("sponsor"),TPersona.consultarPropietarioId(rs.getString("idduenyo")));
            equipos.add(e1);
        }
        return equipos;
    }

    public static String buscarIDEquipo(String nombreEquipo) throws Exception {

        BaseDatos.abrirConexion();
        PreparedStatement ps = BaseDatos.getCon().prepareStatement("select id from equipos where nombre = ?");
        ps.setString(1,nombreEquipo);
        ResultSet rs = ps.executeQuery();
        Equipo e = new Equipo();
        if (rs.next()){
            e.setId(rs.getString("id"));
        }

        return e.getId();
    }
}

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

    public static void borrarEquipo(String equipo) throws  Exception{
        BaseDatos.abrirConexion();

        PreparedStatement ps = BaseDatos.getCon().prepareStatement("Delete from equipos where nombre = ?");
        ps.setString(1,equipo);

        ps.executeUpdate();

        BaseDatos.cerrarConexion();
    }

    public static ArrayList<Equipo> seleccionarEquipo() throws  Exception{

        BaseDatos.abrirConexion();

        PreparedStatement ps = BaseDatos.getCon().prepareStatement("Select * from equipos");
        ResultSet rs = ps.executeQuery();

        ArrayList<Equipo> listaEquipos = new ArrayList<>();

        while (rs.next()){

            Equipo e = new Equipo();
            e.setNombreEquipo("nombre");
            e.setPresupuesto(Double.valueOf("presupuesto"));
            e.setSponsor("sponsor");

            //Como guardar el presidente

            listaEquipos.add(e);

        }


        BaseDatos.cerrarConexion();
        return listaEquipos;
    }

    public static void modificarEquipo(String sponsor, String nombre) throws Exception{

        BaseDatos.abrirConexion();

        PreparedStatement preparedStatement = BaseDatos.getCon().prepareStatement("Update equipos set sponsor=? where nombre = ?");

        preparedStatement.setString(1,sponsor);
        preparedStatement.setString(2,nombre);

        preparedStatement.executeUpdate();

        BaseDatos.cerrarConexion();



    }

}

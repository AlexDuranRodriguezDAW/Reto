package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TPersona {

//*********************************************ENTRENADOR***********************************************************************
    public static void insertarEntrenador(Entrenador e) throws Exception {

        BaseDatos.abrirConexion();

        PreparedStatement ps = BaseDatos.getCon().prepareStatement("insert into Personas (dni,nombre,apellido) values (?,?,?)");
        ps.setString(1,e.getDni());
        ps.setString(2, e.getNombre());
        ps.setString(3, e.getApellidos());
        int n = ps.executeUpdate();

        BaseDatos.cerrarConexion();

      /*
         if (n!=0){
            buscarId(e)}
       */



    }

    public static String buscarIdEntrenador(Entrenador e) throws  Exception {



        BaseDatos.abrirConexion();

        PreparedStatement preparedStatement = BaseDatos.getCon().prepareStatement("Select id from personas where dni = ?");

        preparedStatement.setString(1,e.getDni());

        ResultSet rs = preparedStatement.executeQuery();

        Entrenador entrenador = new Entrenador();

        if (rs.next()){
            entrenador.setId(rs.getString("id"));
        }

        BaseDatos.cerrarConexion();
        return entrenador.getId();
    }

    public static void borrarPersonaEntrenador(Entrenador e) throws  Exception{
        BaseDatos.abrirConexion();

        PreparedStatement ps = BaseDatos.getCon().prepareStatement("Delete from personas where dni = ?");
        ps.setString(1,e.getDni());

        ps.executeUpdate();

        BaseDatos.cerrarConexion();
    }

//*****************************************STAFF************************************************************************


    public static void insertarStaff(Staff s) throws Exception {

        BaseDatos.abrirConexion();

        PreparedStatement ps = BaseDatos.getCon().prepareStatement("insert into Personas (dni,nombre,apellido) values (?,?,?)");
        ps.setString(1,s.getDni());
        ps.setString(2,s.getNombre());
        ps.setString(3,s.getApellidos());
        int n = ps.executeUpdate();

        BaseDatos.cerrarConexion();

      /*
         if (n!=0){
            buscarId(e)}
       */



    }

    public static String buscarIdStaff(Staff s) throws  Exception {



        BaseDatos.abrirConexion();

        PreparedStatement preparedStatement = BaseDatos.getCon().prepareStatement("Select id from personas where dni = ?");

        preparedStatement.setString(1,s.getDni());

        ResultSet rs = preparedStatement.executeQuery();

        Staff staff = new Staff();

        if (rs.next()){
            staff.setId(rs.getString("id"));
        }

        BaseDatos.cerrarConexion();
        return staff.getId();
    }

    public static void borrarPersonaStaff(Staff s) throws  Exception{
        BaseDatos.abrirConexion();

        PreparedStatement ps = BaseDatos.getCon().prepareStatement("Delete from personas where dni = ?");
        ps.setString(1,s.getDni());

        ps.executeUpdate();

        BaseDatos.cerrarConexion();
    }



//******************************************JUGADOR****************************************************************************

    public static void insertarJugador(Jugador j) throws Exception {

        BaseDatos.abrirConexion();

        PreparedStatement ps = BaseDatos.getCon().prepareStatement("insert into Personas (dni,nombre,apellido) values (?,?,?)");
        ps.setString(1,j.getDni());
        ps.setString(2,j.getNombre());
        ps.setString(3,j.getApellidos());
        int n = ps.executeUpdate();

        BaseDatos.cerrarConexion();

      /*
         if (n!=0){
            buscarId(e)}
       */



    }

    public static String buscarIdJugador(Jugador j) throws  Exception {



        BaseDatos.abrirConexion();

        PreparedStatement preparedStatement = BaseDatos.getCon().prepareStatement("Select id from personas where dni = ?");

        preparedStatement.setString(1,j.getDni());

        ResultSet rs = preparedStatement.executeQuery();

        Jugador jugador = new Jugador();

        if (rs.next()){
            jugador.setId(rs.getString("id"));
        }

        BaseDatos.cerrarConexion();
        return jugador.getId();
    }



    public static void borrarPersonaJugadorf(Jugador j) throws  Exception{
        BaseDatos.abrirConexion();

        PreparedStatement ps = BaseDatos.getCon().prepareStatement("Delete from personas where dni = ?");
        ps.setString(1,j.getDni());

        ps.executeUpdate();

        BaseDatos.cerrarConexion();
    }



//*********************************************Duenyo***********************************************************************

    public static void insertarPropietario(Propietario propietario) throws Exception {

        BaseDatos.abrirConexion();

        PreparedStatement ps = BaseDatos.getCon().prepareStatement("insert into Personas (dni,nombre,apellido) values (?,?,?)");
        ps.setString(1,propietario.getDni());
        ps.setString(2,propietario.getNombre());
        ps.setString(3,propietario.getApellidos());
        int n = ps.executeUpdate();

        BaseDatos.cerrarConexion();

      /*
         if (n!=0){
            buscarId(e)}
       */



    }

    public static String buscarIdPropietario(Propietario propietario) throws  Exception {



        BaseDatos.abrirConexion();

        PreparedStatement preparedStatement = BaseDatos.getCon().prepareStatement("Select id from personas where dni = ?");

        preparedStatement.setString(1,propietario.getDni());

        ResultSet rs = preparedStatement.executeQuery();

        Propietario p = new Propietario();

        if (rs.next()){
            p.setId(rs.getString("id"));
        }

        BaseDatos.cerrarConexion();
        return p.getId();
    }



    public static void borrarPersonaPropietario(Propietario p) throws  Exception{
        BaseDatos.abrirConexion();

        PreparedStatement ps = BaseDatos.getCon().prepareStatement("Delete from personas where dni = ?");
        ps.setString(1,p.getDni());

        ps.executeUpdate();

        BaseDatos.cerrarConexion();
    }




}

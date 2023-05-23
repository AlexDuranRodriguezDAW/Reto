package Modelo;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Clase encargada de relacionar la clase Persona con la base de datos, se utiliza para crear sus clases hijas con los datos de estas consultas
 * @author Grupo 3
 * @version 1.3
 * @since 23/05/2023
 * @see Persona
 */

public class TPersona {

    /**
     * Metodo que comprueba si una persona existe en la base de datos mediante el dni y no crear duplicidad
     * @param dni Atributo DNI unico, pero no es la clave de la tabla
     * @return Devuelve un boolean dependiendo si es encuentra o no la persona en la bdd
     * @throws Exception Puede devolver exception
     */

    public static boolean existePersona(String dni) throws Exception {
        boolean existe = false;
        PreparedStatement ps = BaseDatos.getCon().prepareStatement("select * from Personas where dni = ?");
        ps.setString(1, dni);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            existe = true;
        }
        return existe;
    }

    //*********************************************ENTRENADOR***********************************************************************
    public static void insertarEntrenador(Entrenador e) throws Exception {
        if (existePersona(e.getDni())) {
            throw new Exception("No se pueden crear dos personas con el mismo dni");
        } else {
            PreparedStatement ps = BaseDatos.getCon().prepareStatement("insert into Personas (dni,nombre,apellido) values (?,?,?)");
            ps.setString(1, e.getDni());
            ps.setString(2, e.getNombre());
            ps.setString(3, e.getApellidos());
            int n = ps.executeUpdate();
        }
      /*
         if (n!=0){
            buscarId(e)}
       */
    }

    public static String buscarIdEntrenador(Entrenador e) throws Exception {
        PreparedStatement preparedStatement = BaseDatos.getCon().prepareStatement("select id from personas where dni = ?");
        preparedStatement.setString(1, e.getDni());
        ResultSet rs = preparedStatement.executeQuery();
        Entrenador entrenador = new Entrenador();
        if (rs.next()) {
            entrenador.setId(rs.getString("id"));
        }
        return entrenador.getId();
    }

    public static void borrarPersonaEntrenador(Entrenador e) throws Exception {
        BaseDatos.abrirConexion();
        PreparedStatement ps = BaseDatos.getCon().prepareStatement("delete from personas where dni = ?");
        ps.setString(1, e.getDni());
        ps.executeUpdate();
        BaseDatos.cerrarConexion();
    }

//*****************************************STAFF************************************************************************


    public static void insertarStaff(Staff s) throws Exception {
        if (existePersona(s.getDni())) {
            throw new Exception("No se pueden crear dos personas con el mismo dni");
        } else {
            PreparedStatement ps = BaseDatos.getCon().prepareStatement("insert into Personas (dni,nombre,apellido) values (?,?,?)");
            ps.setString(1, s.getDni());
            ps.setString(2, s.getNombre());
            ps.setString(3, s.getApellidos());
            int n = ps.executeUpdate();
        }
    }

    public static String buscarIdStaff(Staff s) throws Exception {
        BaseDatos.abrirConexion();
        PreparedStatement preparedStatement = BaseDatos.getCon().prepareStatement("select id from personas where dni = ?");
        preparedStatement.setString(1, s.getDni());
        ResultSet rs = preparedStatement.executeQuery();
        Staff staff = new Staff();
        if (rs.next()) {
            staff.setId(rs.getString("id"));
        }
        return staff.getId();
    }

    public static int borrarPersonaStaff(Staff s) throws Exception {
        BaseDatos.abrirConexion();
        PreparedStatement ps = BaseDatos.getCon().prepareStatement("delete from personas where dni = ?");
        ps.setString(1, s.getDni());
        int n = ps.executeUpdate();
        BaseDatos.cerrarConexion();
        return n;
    }


//******************************************JUGADOR****************************************************************************

    public static void insertarJugador(Jugador j) throws Exception {
        if (!existePersona(j.getDni())) {
            PreparedStatement ps = BaseDatos.getCon().prepareStatement("insert into Personas (dni,nombre,apellido) values (?,?,?)");
            ps.setString(1, j.getDni());
            ps.setString(2, j.getNombre());
            ps.setString(3, j.getApellidos());
            int n = ps.executeUpdate();
        } else {
            throw new Exception("No se pueden crear dos personas con el mismo dni");
        }
      /*
         if (n!=0){
            buscarId(e)}
       */


    }

    public static String buscarIdJugador(Jugador j) throws Exception {
        BaseDatos.abrirConexion();
        PreparedStatement preparedStatement = BaseDatos.getCon().prepareStatement("select id from personas where dni = ?");
        preparedStatement.setString(1, j.getDni());
        ResultSet rs = preparedStatement.executeQuery();
        Jugador jugador = new Jugador();
        if (rs.next()) {
            jugador.setId(rs.getString("id"));
        }
        return jugador.getId();
    }


    public static int borrarPersonaJugadorf(Jugador j) throws Exception {
        BaseDatos.abrirConexion();
        PreparedStatement ps = BaseDatos.getCon().prepareStatement("delete from personas where dni = ?");
        ps.setString(1, j.getDni());
        int n = ps.executeUpdate();
        BaseDatos.cerrarConexion();
        return n;
    }


//*********************************************Dueño***********************************************************************

    public static void insertarPropietario(Propietario propietario) throws Exception {
        if (!existePersona(propietario.getDni())) {
            PreparedStatement ps = BaseDatos.getCon().prepareStatement("insert into Personas (dni,nombre,apellido) values (?,?,?)");
            ps.setString(1, propietario.getDni());
            ps.setString(2, propietario.getNombre());
            ps.setString(3, propietario.getApellidos());
            int n = ps.executeUpdate();
        } else {
            throw new Exception("No se pueden crear dos personas con el mismo dni");
        }
      /*
         if (n!=0){
            buscarId(e)}
       */
    }

    public static String buscarIdPropietario(Propietario propietario) throws Exception {
        PreparedStatement preparedStatement = BaseDatos.getCon().prepareStatement("select id from personas where dni = ?");
        preparedStatement.setString(1, propietario.getDni());
        ResultSet rs = preparedStatement.executeQuery();
        Propietario p = new Propietario();
        if (rs.next()) {
            p.setId(rs.getString("id"));
        }
        return p.getId();
    }


    public static int borrarPersonaPropietario(Propietario p) throws Exception {
        BaseDatos.abrirConexion();
        PreparedStatement ps = BaseDatos.getCon().prepareStatement("delete from personas where dni = ?");
        ps.setString(1, p.getDni());
        int n = ps.executeUpdate();
        BaseDatos.cerrarConexion();
        return n;
    }

    public static Propietario consultarPropietarioId(String id) throws Exception {
        PreparedStatement ps = BaseDatos.getCon().prepareStatement("Select * from personas where id = ?");
        ps.setString(1, id);
        ResultSet rs = ps.executeQuery();
        Propietario p1 = null;
        if (rs.next()) {
            p1 = new Propietario(rs.getString("id"), rs.getString("dni"), rs.getString("apellido"), rs.getString("nombre"));
        }
        return p1;
    }

    public static void modificarPropietario(Propietario p) throws SQLException {
        BaseDatos.abrirConexion();

        PreparedStatement ps = BaseDatos.getCon().prepareStatement("Update personas" +
                "set dni = ?," +
                "nombre = ?," +
                "apellido = ?"
        );

        ps.setString(1, p.getDni());
        ps.setString(2, p.getNombre());
        ps.setString(3, p.getApellidos());

        ps.executeUpdate();


        BaseDatos.cerrarConexion();
    }

}

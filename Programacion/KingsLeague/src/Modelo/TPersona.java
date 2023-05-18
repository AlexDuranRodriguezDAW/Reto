package Modelo;



import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TPersona {

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
        if (!existePersona(j.getDni())){
            PreparedStatement ps = BaseDatos.getCon().prepareStatement("insert into Personas (dni,nombre,apellido) values (?,?,?)");
            ps.setString(1, j.getDni());
            ps.setString(2, j.getNombre());
            ps.setString(3, j.getApellidos());
            int n = ps.executeUpdate();
        }else {
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


    public static void borrarPersonaJugadorf(Jugador j) throws Exception {
        BaseDatos.abrirConexion();
        PreparedStatement ps = BaseDatos.getCon().prepareStatement("delete from personas where dni = ?");
        ps.setString(1, j.getDni());
        ps.executeUpdate();
        BaseDatos.cerrarConexion();
    }


//*********************************************Dueño***********************************************************************

    public static void insertarPropietario(Propietario propietario) throws Exception {
        if (!existePersona(propietario.getDni())){
            PreparedStatement ps = BaseDatos.getCon().prepareStatement("insert into Personas (dni,nombre,apellido) values (?,?,?)");
            ps.setString(1, propietario.getDni());
            ps.setString(2, propietario.getNombre());
            ps.setString(3, propietario.getApellidos());
            int n = ps.executeUpdate();
        }else {
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

    public static Propietario consultarPropietarioId (String id) throws Exception{
        PreparedStatement ps = BaseDatos.getCon().prepareStatement("Select * from personas where id = ?");
        ps.setString(1,id);
        ResultSet rs = ps.executeQuery();
        Propietario p1 = null;
        if (rs.next()){
            p1 = new Propietario(rs.getString("id"),rs.getString("dni"),rs.getString("apellido"),rs.getString("nombre"));
        }
        return p1;
    }
}

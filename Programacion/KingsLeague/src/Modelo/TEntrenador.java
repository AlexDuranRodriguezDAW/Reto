package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;

public class TEntrenador {

    public static void crearPersonaEntrenador(Entrenador e,String equipo,String sueldo) throws  Exception{
        BaseDatos.abrirConexion();
        TPersona.insertarEntrenador(e);
        String id = TPersona.buscarIdEntrenador(e);
        PreparedStatement ps = BaseDatos.getCon().prepareStatement("insert into entrenadores values(?)");
        ps.setString(1,id);
        int n = ps.executeUpdate();
        if (n==0){
            System.out.println("error");
        }else{
            insertarEquipoEntrenador(id,equipo,sueldo);
        }
        BaseDatos.cerrarConexion();
    }

    public static void insertarEquipoEntrenador(String id, String equipo, String sueldo) throws Exception{
        BaseDatos.abrirConexion();
        String idEquipo = TEquipo.buscarIDEquipo(equipo);

        PreparedStatement ps = BaseDatos.getCon().prepareStatement("insert into entrenadorEquipos (idEntrenador,idEquipo,sueldo,fechaInicio) values(?,?,?,?)");
        ps.setString(1,id);
        ps.setString(2,idEquipo);
        ps.setString(3,sueldo);
        ps.setString(4, String.valueOf(LocalDate.now()));

        int n = ps.executeUpdate();

        BaseDatos.cerrarConexion();

        if (n==0){
            System.out.println("error");
        }
    }

    public static ArrayList<Entrenador> seleccionarEntrenador() throws Exception{
        BaseDatos.abrirConexion();
        PreparedStatement ps = BaseDatos.getCon().prepareStatement("Select e.*,p.* from entrenador e , persona p " +
                                                                        "where e.id = p.id and e.id = (Select id " +
                                                                                                    "from persona) ");

        ResultSet rs = ps.executeQuery();

        ArrayList<Entrenador> lista = new ArrayList<>();
        Entrenador e = new Entrenador();

        if(rs.next()){
            e.setNombre(rs.getString("nombre"));
            e.setApellidos("apellido");
            e.setDni("dni");
            lista.add(e);
        }


        BaseDatos.cerrarConexion();

        return lista;

    }

    public static ArrayList<Entrenador> consultarTodos () throws Exception{
        BaseDatos.abrirConexion();
        PreparedStatement ps = BaseDatos.getCon().prepareStatement("Select * from entrenadores e, personas x where e.id= x.id ");
        ResultSet rs = ps.executeQuery();
        ArrayList <Entrenador> entrenadores = new ArrayList<>();
        while (rs.next()){
            Entrenador e1 = new Entrenador(rs.getString("id"),rs.getString("dni"),
                    rs.getString("nombre"),rs.getString("apellido"));
            entrenadores.add(e1);
        }
        return entrenadores;
    }

}

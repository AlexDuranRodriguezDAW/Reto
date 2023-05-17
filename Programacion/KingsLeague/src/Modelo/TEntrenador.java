package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class TEntrenador {

    public static void crearPersonaEntrenador(Entrenador e) throws  Exception{
        BaseDatos.abrirConexion();
        TPersona.insertarEntrenador(e);
        String id = TPersona.buscarIdEntrenador(e);
        PreparedStatement ps = BaseDatos.getCon().prepareStatement("insert into entrenadores values(?)");
        ps.setString(1,id);
        int n = ps.executeUpdate();
        if (n==0){
            System.out.println("error");
        }
        BaseDatos.cerrarConexion();
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
}

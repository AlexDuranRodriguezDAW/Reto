package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class TJugador {

    public static void crearJugador(Jugador j) throws  Exception{
        BaseDatos.abrirConexion();
        TPersona.insertarJugador(j);
        String id = TPersona.buscarIdJugador(j);
        PreparedStatement ps = BaseDatos.getCon().prepareStatement("insert into jugadores values(?,?,?,?)");
        ps.setString(1,id);
        ps.setString(2,j.getPosicion());
        ps.setString(3,j.getNumDraft());
        ps.setString(4,j.getTipo().toString());
        int n = ps.executeUpdate();
        if (n==0){
            System.out.println("error");
        }
        BaseDatos.cerrarConexion();

    }

    public static ArrayList<Jugador> seleccionarJugadores() throws Exception{
        BaseDatos.abrirConexion();

        PreparedStatement ps = BaseDatos.getCon().prepareStatement("Select j.*,p.* from jugadores j, personas p where j.id = p.id and id = (Select id from personas)");

        ResultSet rs = ps.executeQuery();
        ArrayList<Jugador> listaJugadores = new ArrayList<>();

        while (rs.next()){


            Jugador jugador = new Jugador();

            jugador.setNombre("nombre");
            jugador.setApellidos("apellido");
            jugador.setPosicion("podicion");
            jugador.setTipo(Jugador.TipoJugador.valueOf("tipo"));
            listaJugadores.add(jugador);
        }

        BaseDatos.cerrarConexion();

        return listaJugadores;
    }


}

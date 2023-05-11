package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class TJugador {

    public static void crearPersonaJugador(Jugador j) throws  Exception{
        BaseDatos.abrirConexion();
        TPersona.insertarJugador(j);
        String id = TPersona.buscarIdJugador(j);
        PreparedStatement ps = BaseDatos.getCon().prepareStatement("insert into jugadores values(?)");
        ps.setString(1,id);
        int n = ps.executeUpdate();
        if (n==0){
            System.out.println("error");
        }
        BaseDatos.cerrarConexion();

    }

    public static void seleccionarJugadores() throws Exception{
        BaseDatos.abrirConexion();

        PreparedStatement ps = BaseDatos.getCon().prepareStatement("Select * from jugadores " +
                "                                                       where id = (Select id " +
                "                                                                   from personas)");

        ResultSet rs = ps.executeQuery();
        ArrayList<Jugador> listaJugadores;

        while (rs.next()){
            listaJugadores = new ArrayList<>();
        }

        BaseDatos.cerrarConexion();
    }


}

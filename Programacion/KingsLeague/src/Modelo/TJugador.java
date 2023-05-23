package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class TJugador {

    public static int crearJugador(Jugador j) throws Exception {
        BaseDatos.abrirConexion();
        TPersona.insertarJugador(j);
        String id = TPersona.buscarIdJugador(j);
        PreparedStatement ps = BaseDatos.getCon().prepareStatement("insert into jugadores values(?,?,?,?)");
        ps.setString(1, id);
        ps.setString(2, j.getPosicion());
        ps.setString(3, j.getNumDraft());
        ps.setString(4, j.getTipo().toString());
        int n = ps.executeUpdate();
        BaseDatos.cerrarConexion();
        return n;
    }

    public static ArrayList<Jugador> consultarTodos() throws Exception {
        BaseDatos.abrirConexion();
        PreparedStatement ps = BaseDatos.getCon().prepareStatement("Select * from personas p, jugadores x where p.id= x.id ");
        ResultSet rs = ps.executeQuery();
        ArrayList<Jugador> jugadores = new ArrayList<>();
        while (rs.next()) {
            Jugador j1 = new Jugador();
            j1.setId(rs.getString("id"));
            j1.setDni(rs.getString("dni"));
            j1.setApellidos(rs.getString("apellido"));
            j1.setNombre(rs.getString("nombre"));
            j1.setPosicion(rs.getString("posicion"));
            if (rs.getString("tipo").equalsIgnoreCase("draft")) {
                j1.setTipo(Jugador.TipoJugador.draft);
                j1.setNumDraft(rs.getString("numdraft"));
            } else {
                j1.setTipo(Jugador.TipoJugador.wildcard);
            }
            jugadores.add(j1);
        }
        BaseDatos.cerrarConexion();
        return jugadores;
    }
}

package Modelo;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class TSplit {

    public static int insertar(Split split) throws Exception {
        BaseDatos.abrirConexion();
        //Todo validar que no se cree un split mientras otro esta en proceso
        PreparedStatement ps = BaseDatos.getCon().prepareStatement("insert into split (tipo,fechainicio,FECHAFIN) values (?,?,?)");
        ps.setString(1, split.getTipoSplit().toString());
        ps.setDate(2, Date.valueOf(split.getFechaInicio()));
        ps.setDate(3, Date.valueOf(split.getFechaFin()));
        int n = ps.executeUpdate();
        BaseDatos.cerrarConexion();
        return n;
    }

    public static ArrayList<Split> consultarTodos() throws Exception {
        BaseDatos.abrirConexion();
        PreparedStatement ps = BaseDatos.getCon().prepareStatement("select * from split ");
        ResultSet resultado = ps.executeQuery();
        ArrayList splits = new ArrayList();
        while (resultado.next()) {
            //Comprobar si el split abierto o cerrado
            if (resultado.getString(2).equalsIgnoreCase("abierto")) {
                splits.add(new Split(resultado.getString(1), resultado.getDate("3").toLocalDate(), resultado.getDate("4").toLocalDate(), Split.tipoSplit.abierto, null));
            } else {
                splits.add(new Split(resultado.getString(1), resultado.getDate("3").toLocalDate(), resultado.getDate("4").toLocalDate(), Split.tipoSplit.cerrado, null));
            }
        }
        return splits;
    }
}

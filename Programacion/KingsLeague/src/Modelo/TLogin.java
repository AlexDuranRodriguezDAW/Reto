package Modelo;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class TLogin {

    public static int insertar(Login l) throws Exception {
        BaseDatos.abrirConexion();
        int n;
        //Comprueba si el usuario existe, si este existe devuelve -1 y no lo inserta
        if (consultarUsuario(l) != null) {
            n = -1;
        } else {
            PreparedStatement ps = BaseDatos.getCon().prepareStatement("insert into login (tipo,usuario,contrasenya) values (?,?,?)");
            ps.setString(1, l.getTipo().toString());
            ps.setString(2, l.getUsuario());
            ps.setString(3, l.getContrasenya());
            n = ps.executeUpdate();
        }
        BaseDatos.cerrarConexion();
        return n;
    }

    public static int borrar(Login l) throws Exception {
        BaseDatos.abrirConexion();
        PreparedStatement ps = BaseDatos.getCon().prepareStatement("delete from login where usuario = ?");
        ps.setString(1, l.getUsuario());
        int n = ps.executeUpdate();
        BaseDatos.cerrarConexion();
        return n;
    }

    public static int actualizarContrasenya(Login l) throws Exception {
        BaseDatos.abrirConexion();
        PreparedStatement ps = BaseDatos.getCon().prepareStatement("update login set contrasenya = ? where usuario = ?");
        ps.setString(1, l.getContrasenya());
        ps.setString(2, l.getUsuario());
        int n = ps.executeUpdate();
        BaseDatos.cerrarConexion();
        return n;
    }

    public static Login consultarUsuario(Login l) throws Exception {
        BaseDatos.abrirConexion();
        PreparedStatement ps = BaseDatos.getCon().prepareStatement("select * from login where usuario = ?");
        ps.setString(1, l.getUsuario());
        ResultSet resultado = ps.executeQuery();
        Login usuarioConsultado = null;
        if (resultado.next()) {
            //Comprobar si el usuario es administrador o no para usar el enum list de la clase
            if (resultado.getString(2).equalsIgnoreCase("admin")) {
                usuarioConsultado = new Login(resultado.getString(1), Login.tipo.admin, resultado.getString(3), resultado.getString(4));
            } else {
                usuarioConsultado = new Login(resultado.getString(1), Login.tipo.usuario, resultado.getString(3), resultado.getString(4));
            }
        }
        return usuarioConsultado;
    }

    public static ArrayList<Login> consultarTodos() throws Exception {
        BaseDatos.abrirConexion();
        PreparedStatement ps = BaseDatos.getCon().prepareStatement("select * from login");
        ResultSet resultado = ps.executeQuery();
        ArrayList<Login> usuarios = new ArrayList<>();
        while (resultado.next()) {
            //Comprobar si el usuario es administrador o no para usar el enum list de la clase
            if (resultado.getString(2).equalsIgnoreCase("admin")) {
                usuarios.add(new Login(resultado.getString(1), Login.tipo.admin, resultado.getString(3), resultado.getString(4)));
            } else {
                usuarios.add(new Login(resultado.getString(1), Login.tipo.usuario, resultado.getString(3), resultado.getString(4)));
            }
        }
        return usuarios;
    }
}

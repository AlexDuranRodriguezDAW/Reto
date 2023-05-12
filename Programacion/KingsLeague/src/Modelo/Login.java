package Modelo;

public class Login {

    public enum tipo {
        admin, usuario
    }

    private String id;
    private tipo tipo;
    private String usuario;
    private String contrasenya;

    public Login() {
    }

    public Login(Login.tipo tipo, String usuario, String contrasenya) {
        this.tipo = tipo;
        this.usuario = usuario;
        this.contrasenya = contrasenya;
    }

    public Login(String id, Login.tipo tipo, String usuario, String contrasenya) {
        this.id = id;
        this.tipo = tipo;
        this.usuario = usuario;
        this.contrasenya = contrasenya;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Login.tipo getTipo() {
        return tipo;
    }

    public void setTipo(Login.tipo tipo) {
        this.tipo = tipo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenya() {
        return contrasenya;
    }

    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }
}

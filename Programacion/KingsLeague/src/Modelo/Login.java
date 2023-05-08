package Modelo;

public class Login {

    private int id;
    private String tipo;
    private String usuario;
    private String contrasenya;

    public Login() {
    }

    public Login(int id, String tipo, String usuario, String contrasenya) {
        this.id = id;
        this.tipo = tipo;
        this.usuario = usuario;
        this.contrasenya = contrasenya;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
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

package Modelo;

/**
 * Clase que se utiliza para crear los usuarios que podran utilizar el programa
 * @author Grupo 3
 * @version 1.0
 * @since 23/05/2023
 */

public class Login {

    /**
     * Clase enum que se utiliza para controlar que datos se introducen en el atributo tipo de la clase Login
     * @see Login
     */

    public enum tipo {
        admin, usuario
    }
    private String id;
    private tipo tipo;
    private String usuario;
    private String contrasenya;

    /**
     * Constructor por defecto solo con el usuario y contraseña
     * @param usuario Nombre del usuario
     * @param contrasenya Contraseña del usuario
     */

    public Login(String usuario, String contrasenya) {
        this.usuario = usuario;
        this.contrasenya = contrasenya;
    }

    /**
     * Constructor que se utiliza cuando se crea la clase con los datos de la base de datos
     * @param id Identificador autoincremental
     * @param tipo Atributo con la clase enum
     * @param usuario Nombre del usuario
     * @param contrasenya Contraseña del usuario
     */

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

package Modelo;

/**
 * Clase abstracta y padre de Entrenador,Staff,Jugador y Propietario, contiene todos los atributos y metodos que estas heredan
 * @author Grupo 3
 * @version 1.0
 * @since 23/05/2023
 */

public abstract class Persona {
    private String id;
    private String dni;
    private String apellidos;
    private String nombre;

    /**
     * Constructor vacio
     */
    public Persona() {
    }

    /**
     * Constructor sin identificar,se usa para que las clases hijas hereden este constructor con los atributos basicos
     * @param dni DNI unico
     * @param apellidos Apellidos de la persona
     * @param nombre Nombre de la persona
     */

    public Persona(String dni, String apellidos, String nombre) {
        this.dni = dni;
        this.apellidos = apellidos;
        this.nombre = nombre;
    }

    /**
     * Constructor completo que se utiliza cuando se cogen los datos de la bdd
     * @param id Identificador unico autoincremental
     * @param dni DNI unico
     * @param apellidos Apellidos de la persona
     * @param nombre Nombre de la persona
     */

    public Persona(String id, String dni, String apellidos, String nombre) {
        this.id = id;
        this.dni = dni;
        this.apellidos = apellidos;
        this.nombre = nombre;
    }

    /**
     * Constructor con solo nombre y apellidos, utilizada para mostrar informacion
     * @param apellidos Apellidos de la persona
     * @param nombre Nombre de la persona
     */
    public Persona(String apellidos, String nombre) {
        this.apellidos = apellidos;
        this.nombre = nombre;
    }

    /**
     * Constructor solo con el id, se utiliza cuando se obtiene este parametro de la bdd
     * @param id Identificar autoincremental y unico
     */
    public Persona(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

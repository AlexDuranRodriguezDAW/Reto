package Modelo;

public abstract class Persona {
    private String id;
    private String dni;
    private String apellidos;
    private String nombre;

    public Persona() {
    }

    public Persona(String dni, String apellidos, String nombre) {
        this.dni = dni;
        this.apellidos = apellidos;
        this.nombre = nombre;
    }

    public Persona(String id, String dni, String apellidos, String nombre) {
        this.id = id;
        this.dni = dni;
        this.apellidos = apellidos;
        this.nombre = nombre;
    }

    public Persona(String apellidos, String nombre) {
        this.apellidos = apellidos;
        this.nombre = nombre;
    }

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

package Modelo;

/**
 * Clase extendida de Persona, todos los metodos y constructores son heredados
 * @author Grupo 3
 * @version 1.0
 * @since 23/05/2023
 * @see Persona
 */
public class Entrenador extends Persona {

    /**
     * Constructor vacio utilizado para crear la clase y luego settear los atributos
     */
    public Entrenador() {
    }

    /**
     * Constructor que se utiliza cuando se crea con los datos de la base de datos
     * @param id Identificador autoincremental
     * @param dni DNI
     * @param apellidos Apellidos
     * @param nombre Nombre
     */
    public Entrenador(String id, String dni, String apellidos, String nombre) {
        super(id, dni, apellidos, nombre);
    }

    /**
     * Constructor que se utiliza para crear esta clase en la base de datos
     * @param dni DNI Unico
     * @param apellidos Apellidos
     * @param nombre Nombre
     */
    public Entrenador(String dni, String apellidos, String nombre) {
        super(dni, apellidos, nombre);
    }

    /**
     * Constructor que se utiliza para borrar Entrenadores en la base de datos
     * @param apellidos Apellidos
     * @param nombre Nombre
     */
    public Entrenador(String apellidos, String nombre) {
        super(apellidos, nombre);
    }


}

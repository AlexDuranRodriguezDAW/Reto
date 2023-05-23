package Modelo;

/**
 * Clase que representa al dueño de un club de la "Kings League", clase hija de Persona
 * Todos los constructores son heredados de la clase Padre
 * @author Grupo 3
 * @version 1.0
 * @since 23/05/2023
 * @see Persona
 */
public class Propietario extends Persona {
    public Propietario() {
    }

    public Propietario(String id, String dni, String apellidos, String nombre) {
        super(id, dni, apellidos, nombre);
    }

    public Propietario(String id) {
        super(id);
    }

    public Propietario(String dni, String nombre, String apellido) {

    }
}

package Modelo;


/**
 * Clase que representa a los entrenadores y ayudantes de toda la "Kings League"
 * Todos los constructores son heredados de la clase Padre (Persona)
 * @author Grupo 3
 * @version 1.0
 * @since 23/05/2023
 * @see Persona
 */
public class Staff extends Persona {
    public Staff() {
    }

    public Staff(String dni, String apellidos, String nombre) {
        super(dni, apellidos, nombre);
    }

    public Staff(String id, String dni, String apellidos, String nombre) {
        super(id, dni, apellidos, nombre);
    }
}

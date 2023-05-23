package Modelo;

/**
 * Clase que hereda atributos y metodos de Persona, se utiliza para representar a todos los jugadores de la "Kings League"
 * @author Grupo 3
 * @version 1.0
 * @since 23/05/2023
 * @see Persona
 */
public class Jugador extends Persona {

    /**
     * Clase tipo enum que se utiliza para controlar el dato que se introduce en el atributo TipoJugador
     */
    public enum TipoJugador {
        draft, wildcard
    }

    private String posicion;
    private TipoJugador tipo;
    private String numDraft;

    public Jugador(String jugadorApellido, String jugadorNombre, String posicicion) {

    }

    public Jugador(String id, String dni, String apellidos, String nombre, String posicion, TipoJugador tipo, String numDraft) {
        super(id, dni, apellidos, nombre);
        this.posicion = posicion;
        this.tipo = tipo;
        this.numDraft = numDraft;
    }

    public Jugador(String dni, String apellidos, String nombre, String posicion, TipoJugador tipo, String numDraft) {
        super(dni, apellidos, nombre);
        this.posicion = posicion;
        this.tipo = tipo;
        this.numDraft = numDraft;
    }

    public Jugador() {
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public String getNumDraft() {
        return numDraft;
    }

    public void setNumDraft(String numDraft) {
        this.numDraft = numDraft;
    }

    public TipoJugador getTipo() {
        return tipo;
    }

    public void setTipo(TipoJugador tipo) {
        this.tipo = tipo;
    }
}

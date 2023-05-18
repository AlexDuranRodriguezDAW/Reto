package Modelo;

public class Jugador extends Persona {

    public Jugador(String jugadorApellido, String jugadorNombre, String posicicion) {

    }

    public enum TipoJugador {
        draft, wildcard
    }

    private String posicion;
    private TipoJugador tipo;
    private String numDraft;

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

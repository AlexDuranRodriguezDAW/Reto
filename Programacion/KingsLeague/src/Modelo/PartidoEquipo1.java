package Modelo;

/**
 * Clase que representa un equipo concreto de los dos de un partido
 * Partido 1
 * @author Grupo 3
 * @version 1.0
 * @since 23/05/2023
 * @see Equipo
 * @see Partido
 */
public class PartidoEquipo1 {
    private int goles;
    private Equipo equipo1;
    private Partido partido;

    public PartidoEquipo1() {
    }

    public PartidoEquipo1(int goles, Equipo equipo1, Partido partido) {
        this.goles = goles;
        this.equipo1 = equipo1;
        this.partido = partido;
    }

    public int getGoles() {
        return goles;
    }

    public void setGoles(int goles) {
        this.goles = goles;
    }

    public Equipo getEquipo1() {
        return equipo1;
    }

    public void setEquipo1(Equipo equipo1) {
        this.equipo1 = equipo1;
    }

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }
}




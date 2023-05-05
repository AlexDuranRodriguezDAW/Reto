package Modelo;

public class PartidoEquipo1 {
    private int goles;
    private Equipo equipo;
    Partido partido;

    public PartidoEquipo1(int goles, Equipo equipo, Partido partido) {
        this.goles = goles;
        this.equipo = equipo;
        this.partido = partido;
    }

    public PartidoEquipo1() {
    }

    public int getGoles() {
        return goles;
    }

    public void setGoles(int goles) {
        this.goles = goles;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }
}




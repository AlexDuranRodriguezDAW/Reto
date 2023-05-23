package Modelo;

import java.time.LocalDate;

/**
 * Clase que se utiliza para la relacion de jugadores y equipos y toda la informacion (atributos) que depende de la relacion y no solo de una de las dos clases
 * @author Grupo 3
 * @version 1.0
 * @since 23/05/2023
 * @see Jugador
 * @see Equipo
 */

public class ContratoJugador {

    private Jugador jugador;
    private Equipo equipo;
    private double clausula;
    private double sueldo;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    /**
     * Constructor por defecto
     * @param jugador Clase jugador con todos sus atributos
     * @param equipo Clase Equipo con todos sus atributos
     * @param clausula Double, cantidad de clausula del jugador, tienen que ser unas cantidad ya estipuladas.
     * @param sueldo Double, cantidad de sueldo de esta relacion
     */

    public ContratoJugador(Jugador jugador, Equipo equipo, double clausula, double sueldo) {
        this.jugador = jugador;
        this.equipo = equipo;
        //Validar que la clausula sea una de las cantidades obligatorias
        if (clausula == 10000000 || clausula == 10500000 || clausula == 15000000 || clausula == 22500000) {
            this.clausula = clausula;
        }
        this.sueldo = sueldo;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public double getClausula() {
        return clausula;
    }

    public void setClausula(double clausula) {
        //Validar que la clausula sea una de las cantidades obligatorias
        if (clausula == 10000000 || clausula == 10500000 || clausula == 15000000 || clausula == 22500000) {
            this.clausula = clausula;
        }
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }
}

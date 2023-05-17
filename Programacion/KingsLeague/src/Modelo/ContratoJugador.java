package Modelo;

import java.time.LocalDate;

public class ContratoJugador {

    private Jugador jugador;
    private Equipo equipo;
    private double clausula;
    private double sueldo;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    public ContratoJugador() {
    }

    public ContratoJugador(Jugador jugador, Equipo equipo, double clausula, double sueldo, LocalDate fechaInicio, LocalDate fechaFin) {
        this.jugador = jugador;
        this.equipo = equipo;
        //Validar que la clausula sea una de las cantidades obligatorias
        if (clausula == 10 || clausula == 10.5 || clausula == 15 || clausula == 22.5) {
            this.clausula = clausula;
        }
        this.sueldo = sueldo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
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
        if (clausula == 10 || clausula == 10.5 || clausula == 15 || clausula == 22.5) {
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

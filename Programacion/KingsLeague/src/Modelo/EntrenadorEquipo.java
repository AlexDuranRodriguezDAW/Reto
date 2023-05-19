package Modelo;

import java.time.LocalDate;

public class EntrenadorEquipo {
    private Equipo equipo;
    private Entrenador entrenador;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private Double sueldo;

    public EntrenadorEquipo() {
    }

    public EntrenadorEquipo(Equipo equipo, Entrenador entrenador, LocalDate fechaInicio, LocalDate fechaFin, Double sueldo) {
        this.equipo = equipo;
        this.entrenador = entrenador;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.sueldo = sueldo;
    }

    public EntrenadorEquipo(Equipo equipo, Entrenador entrenador, Double sueldo) {
        this.equipo = equipo;
        this.entrenador = entrenador;
        this.sueldo = sueldo;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public Entrenador getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
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

    public Double getSueldo() {
        return sueldo;
    }

    public void setSueldo(Double sueldo) {
        this.sueldo = sueldo;
    }
}

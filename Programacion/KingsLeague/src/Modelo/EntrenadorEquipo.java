package Modelo;

import java.time.LocalDate;

/**
 * Clase que surge de la relacion de un entrenador con un equipo
 * @author Grupo 3
 * @version 1.0
 * @since 23/05/2023
 */

public class EntrenadorEquipo {
    private Equipo equipo;
    private Entrenador entrenador;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private Double sueldo;

    /**
     * Constructor por defecto
     * @param equipo Clase Equipo
     * @param entrenador Clase Entrenador
     * @param sueldo Double, sueldo de la relaciond de ambas clases
     */
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

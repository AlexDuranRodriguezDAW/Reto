package Modelo;

import java.time.LocalDate;

/**
 * Clase que representa la relacion entre los entrenadores, asistentes y el equipo al que pertecen
 * @author Grupo 3
 * @version 1.0
 * @since 23/05/2023
 * @see Staff
 * @see Equipo
 */

public class StaffEquipo {

    private Equipo equipo;
    private Staff staff;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private Double sueldo;

    /**
     * Constructor por defecto
     * @param equipo Clase Equipo
     * @param staff Clase Staff
     * @param sueldo Double, atributo que representa el sueldo de esta relación
     */

    public StaffEquipo(Equipo equipo, Staff staff, Double sueldo) {
        this.equipo = equipo;
        this.staff = staff;
        this.sueldo = sueldo;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
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

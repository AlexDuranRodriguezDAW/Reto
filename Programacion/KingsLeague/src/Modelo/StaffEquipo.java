package Modelo;

import java.time.LocalDate;

public class StaffEquipo {

    private Equipo equipo;
    private Staff staff;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private Double sueldo;

    public StaffEquipo() {
    }

    public StaffEquipo(Equipo equipo, Staff staff, LocalDate fechaInicio, LocalDate fechaFin, Double sueldo) {
        this.equipo = equipo;
        this.staff = staff;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
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

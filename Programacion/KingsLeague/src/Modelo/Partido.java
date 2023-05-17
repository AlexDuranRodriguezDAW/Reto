package Modelo;

import java.time.LocalDate;

public class Partido {
    private int id;
    private LocalDate hora;

    public Partido() {
    }

    public Partido(int id, LocalDate hora) {
        this.id = id;
        this.hora = hora;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getHora() {
        return hora;
    }

    public void setHora(LocalDate hora) {
        this.hora = hora;
    }
}

package Modelo;

import java.time.LocalDate;
import java.util.ArrayList;

public class Jornada {

    public enum tipoJornada {
        regular,playoff
    }
    private String id;
    private LocalDate fecha;
    private tipoJornada tipoJornada;
    private ArrayList <Partido> partidos;

    public Jornada() {
    }

    public Jornada(String id, LocalDate fecha, Jornada.tipoJornada tipoJornada) {
        this.id = id;
        this.fecha = fecha;
        this.tipoJornada = tipoJornada;
    }

    public Jornada(String id, LocalDate fecha, Jornada.tipoJornada tipoJornada, ArrayList<Partido> partidos) {
        this.id = id;
        this.fecha = fecha;
        this.tipoJornada = tipoJornada;
        this.partidos = partidos;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Jornada.tipoJornada getTipoJornada() {
        return tipoJornada;
    }

    public void setTipoJornada(Jornada.tipoJornada tipoJornada) {
        this.tipoJornada = tipoJornada;
    }

    public ArrayList<Partido> getPartidos() {
        return partidos;
    }

    public void setPartidos(ArrayList<Partido> partidos) {
        this.partidos = partidos;
    }

    //Metodo para añadir un partido individual al arraylist de la relacion
    public void setPartido(Partido partido) {
        this.partidos.add(partido);
    }
}

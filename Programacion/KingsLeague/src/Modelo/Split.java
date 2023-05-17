package Modelo;

import java.time.LocalDate;
import java.util.ArrayList;

public class Split {

    private String id;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private tipoSplit tipoSplit;
    private ArrayList<Jornada> listaJornada;

    public enum tipoSplit {
        abierto, cerrado
    }

    public Split() {
    }

    public Split(LocalDate fechaInicio, LocalDate fechaFin, Split.tipoSplit tipoSplit) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.tipoSplit = tipoSplit;
    }

    public Split(String id, LocalDate fechaInicio, LocalDate fechaFin, Split.tipoSplit tipoSplit, ArrayList<Jornada> listaJornada) {
        this.id = id;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.tipoSplit = tipoSplit;
        this.listaJornada = listaJornada;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Split.tipoSplit getTipoSplit() {
        return tipoSplit;
    }

    public void setTipoSplit(Split.tipoSplit tipoSplit) {
        this.tipoSplit = tipoSplit;
    }

    public ArrayList<Jornada> getListaJornada() {
        return listaJornada;
    }

    public void setListaJornada(ArrayList<Jornada> listaJornada) {
        this.listaJornada = listaJornada;
    }
}

package Modelo;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Clase que representa un split de la "Kings League", esta representa todos los partidos de una temporada
 * @author Grupo 3
 * @version 1.0
 * @since 23/05/2023
 * @see Jornada
 */

public class Split {

    private String id;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private tipoSplit tipoSplit;
    private ArrayList<Jornada> listaJornada;

    /**
     * Clase enum para validar que datos se introduce al atributo tipoSplit
     * @author Grupo 3
     * @version 1.0
     * @since 23/05/2023
     * @see Split
     */

    public enum tipoSplit {
        abierto, cerrado
    }

    /**
     * Constructor por defecto
     * @param id Identificar unico y autoincremental
     * @param fechaInicio LocalDate fecha de comienzo
     * @param fechaFin LocalDate, fecha de finalizacion
     * @param tipoSplit Clase tipo enum, solo dos opciones en el atributo
     * @param listaJornada Arraylist con las todas las Jornadas (Clase Jornada) que componen el split
     * @see Jornada
     */
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

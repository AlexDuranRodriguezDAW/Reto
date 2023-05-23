package Modelo;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Clase que representa a un conjunto de partidos de una semana
 * @author Grupo 3
 * @version 1.0
 * @since 23/05/2023
 * @see Partido
 */

public class Jornada {

    /**
     * Clase enum para solo permitir dos valores en el atributo tipoJornada
     */

    public enum tipoJornada {
        regular, playoff
    }

    private String id;
    private LocalDate fecha;
    private tipoJornada tipoJornada;
    private ArrayList<Partido> partidos;

    /**
     * Constructor vacio
     */
    public Jornada() {
    }

    /**
     * Constructor con todos los atributos, se utiliza cuando se crea la clase con los datos de la bdd
     * @param id Identificador autoincremental
     * @param fecha LocalDate
     * @param tipoJornada Atributo con clase tipo enum
     */
    public Jornada(String id, LocalDate fecha, Jornada.tipoJornada tipoJornada) {
        this.id = id;
        this.fecha = fecha;
        this.tipoJornada = tipoJornada;
    }

    /**
     * Constructor que cuenta con el arraylist de todos los partidos
     * @param id Identificador autoincremental
     * @param fecha LocalDate
     * @param tipoJornada Atributo con clase tipo enum
     * @param partidos Arraylist de la clase partido
     * @see Partido
     */
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

    /**
     * Metodo para introducir un partido individual en el Arraylist en la ultima posición
     * @param partido clase partido
     */
    public void setPartido(Partido partido) {
        this.partidos.add(partido);
    }
}

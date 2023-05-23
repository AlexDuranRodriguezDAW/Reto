package Modelo;

/**
 * Clase utilizada para hacer referencia a los equipos de la Kings League
 * @author Grupo 3
 * @version 1.0
 * @since 23/05/2023
 * @see Propietario
 */

public class Equipo {

    private String id;
    private String nombreEquipo;
    private Double presupuesto;
    private String sponsor;
    private Propietario propietario;

    /**
     * Constructor vacio, utilizado para crear la clase y luego introducir solo algunos atributos
     */
    public Equipo() {
    }

    /**
     * Constructor que se utiliza en la creacion de la clase con los datos de la bdd
     * @param id Identificador autoincremental
     * @param nombreEquipo Nombre del equipo, unico
     * @param presupuesto Double presupuesto del equipo
     * @param sponsor String patrocinador del equipo
     * @param propietario Clase Propietario, con todos los atributos, para relacionar quien es el dueño de ese equipo
     */
    public Equipo(String id, String nombreEquipo, Double presupuesto, String sponsor, Propietario propietario) {
        this.id = id;
        this.nombreEquipo = nombreEquipo;
        this.presupuesto = presupuesto;
        this.sponsor = sponsor;
        this.propietario = propietario;
    }

    /**
     * Constructor que se utiliza en la creacion de la clase para posteriormente crearla dentro de la bdd
     * @param nombreEquipo Nombre del equipo, unico
     * @param presupuesto Double presupuesto del equipo
     * @param sponsor String patrocinador del equipo
     * @param propietario Clase Propietario, con todos los atributos, para relacionar quien es el dueño de ese equipo
     */
    public Equipo(String nombreEquipo, Double presupuesto, String sponsor, Propietario propietario) {
        this.nombreEquipo = nombreEquipo;
        this.presupuesto = presupuesto;
        this.sponsor = sponsor;
        this.propietario = propietario;
    }

    /**
     * Constructor que se crea solo con los parametros que son modificables desde el programa a la base de datos
     * @param nombreEquipo Nombre del equipo, unico
     * @param presupuesto Double presupuesto del equipo
     * @param sponsor String patrocinador del equipo
     */
    public Equipo(String nombreEquipo, Double presupuesto, String sponsor) {
        this.nombreEquipo = nombreEquipo;
        this.presupuesto = presupuesto;
        this.sponsor = sponsor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public Double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(Double presupuesto) {
        this.presupuesto = presupuesto;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    public String getSponsor() {
        return sponsor;
    }

    public void setSponsor(String sponsor) {
        this.sponsor = sponsor;
    }
}

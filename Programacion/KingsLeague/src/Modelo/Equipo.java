package Modelo;

public class Equipo {

    private String id;
    private String nombreEquipo;
    private Double presupuesto;
    private String sponsor;
    private Propietario propietario;

    public Equipo() {
    }


    public Equipo(String id, String nombreEquipo, Double presupuesto, String sponsor, Propietario propietario) {
        this.id = id;
        this.nombreEquipo = nombreEquipo;
        this.presupuesto = presupuesto;
        this.sponsor = sponsor;
        this.propietario = propietario;
    }

    public Equipo(String nombreEquipo, Double presupuesto, String sponsor, Propietario propietario) {
        this.nombreEquipo = nombreEquipo;
        this.presupuesto = presupuesto;
        this.sponsor = sponsor;
        this.propietario = propietario;
    }

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

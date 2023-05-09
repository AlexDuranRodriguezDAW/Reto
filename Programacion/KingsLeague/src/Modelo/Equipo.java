package Modelo;

public class Equipo {

    private int idEquipo;
    private String nombreEquipo;
    private Double presupuesto;

    private Propietario propietario;

    public Equipo() {
    }

    public Equipo(int idEquipo, String nombreEquipo, Double presupuesto, Propietario propietario) {
        this.idEquipo = idEquipo;
        this.nombreEquipo = nombreEquipo;
        this.presupuesto = presupuesto;
        this.propietario = propietario;
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
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
}

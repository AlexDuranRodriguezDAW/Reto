package Modelo;

public class Equipo {

    private int idEquipo;
    private String nombreEquipo;
    private Double presupuesto;

    public Equipo(int idEquipo, String nombreEquipo, Double presupuesto) {
        this.idEquipo = idEquipo;
        this.nombreEquipo = nombreEquipo;
        this.presupuesto = presupuesto;
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
}

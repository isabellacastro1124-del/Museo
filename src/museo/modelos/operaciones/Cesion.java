package museo.modelos.operaciones;

import java.util.Date;

/**
 * Representa una cesión o préstamo de una obra de arte a un museo externo.
 */
public class Cesion {
    private MuseoExterno museoExterno;
    private double importe;
    private String periodoTiempo;
    private Date fechaInicio;
    private boolean activa;

    /**
     * Constructor de la clase Cesion.
     * 
     * @param museo El museo externo al que se cede la obra.
     * @param importe El importe monetario de la cesión.
     * @param periodo El periodo de tiempo de la cesión.
     */
    public Cesion(MuseoExterno museo, double importe, String periodo) {
        this.museoExterno = museo;
        this.importe = importe;
        this.periodoTiempo = periodo;
        this.fechaInicio = new Date(); // Asumimos que inicia al crearse la cesión
        this.activa = true;
    }

    // Getters y Setters
    public MuseoExterno getMuseoExterno() {
        return museoExterno;
    }

    public double getImporte() {
        return importe;
    }

    public String getPeriodoTiempo() {
        return periodoTiempo;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public boolean isActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }
}

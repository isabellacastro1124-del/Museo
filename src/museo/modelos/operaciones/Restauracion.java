package museo.modelos.operaciones;

import museo.modelos.obras.ObraArte;
import java.util.Date;

/**
 * Representa un proceso de restauración de una obra de arte.
 */
public class Restauracion {
    private ObraArte obra;
    private String tipo;
    private Date fechaInicio;
    private Date fechaFin;

    /**
     * Constructor de la clase Restauracion.
     * 
     * @param obra La obra de arte a restaurar.
     * @param tipo El tipo de restauración.
     * @param inicio La fecha de inicio de la restauración.
     */
    public Restauracion(ObraArte obra, String tipo, Date inicio) {
        this.obra = obra;
        this.tipo = tipo;
        this.fechaInicio = inicio;
    }

    /**
     * Finaliza el proceso de restauración estableciendo una fecha de fin.
     * 
     * @param fin La fecha de finalización.
     */
    public void finalizar(Date fin) {
        this.fechaFin = fin;
    }

    // Getters y Setters
    public Date getFechaInicio() {
        return fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public ObraArte getObra() {
        return obra;
    }

    public String getTipo() {
        return tipo;
    }
}

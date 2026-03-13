package museo.modelos.obras;

import museo.enums.EstadoObra;
import museo.interfaces.IValorable;
import java.util.Date;

public abstract class ObraArte implements IValorable {
    private String id;
    private String titulo;
    private String autor;
    private String periodo;
    private double valorEconomico;
    private Date fechaCreacion;
    private Date fechaEntrada;
    private EstadoObra estado;

    public ObraArte(String id, double valor) {
        this.id = id;
        this.valorEconomico = valor;
    }

    @Override
    public double obtenerValor() {
        return valorEconomico;
    }

    public boolean esAptaParaRestauracionPeriodica() {
        return estado != EstadoObra.EN_RESTAURACION && estado != EstadoObra.CEDIDA;
    }

    public void setEstado(EstadoObra estado) {
        this.estado = estado;
    }

    public String getId() { return id; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }
    public String getPeriodo() { return periodo; }
    public void setPeriodo(String periodo) { this.periodo = periodo; }
    public double getValorEconomico() { return valorEconomico; }
    public Date getFechaCreacion() { return fechaCreacion; }
    public void setFechaCreacion(Date fechaCreacion) { this.fechaCreacion = fechaCreacion; }
    public Date getFechaEntrada() { return fechaEntrada; }
    public void setFechaEntrada(Date fechaEntrada) { this.fechaEntrada = fechaEntrada; }
    public EstadoObra getEstado() { return estado; }
}

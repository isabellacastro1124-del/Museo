package museo.modelos.obras;

public class ObjetoOtro extends ObraArte {
    private String descripcion;

    public ObjetoOtro(String id, double valor, String desc) {
        super(id, valor);
        this.descripcion = desc;
    }

    public String getDescripcion() { return descripcion; }
}

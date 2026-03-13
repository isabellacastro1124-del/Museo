package museo.modelos.obras;

public class Escultura extends ObraArte {
    private String estilo;
    private String material;

    public Escultura(String id, double valor, String material) {
        super(id, valor);
        this.material = material;
    }

    public String getEstilo() { return estilo; }
    public void setEstilo(String estilo) { this.estilo = estilo; }
    public String getMaterial() { return material; }
}

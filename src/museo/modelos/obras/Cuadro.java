package museo.modelos.obras;

public class Cuadro extends ObraArte {
    private String estilo;
    private String tecnica;

    public Cuadro(String id, double valor, String tecnica) {
        super(id, valor);
        this.tecnica = tecnica;
    }

    public String getEstilo() { return estilo; }
    public void setEstilo(String estilo) { this.estilo = estilo; }
    public String getTecnica() { return tecnica; }
}

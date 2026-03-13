package museo.modelos.operaciones;

/**
 * Representa un museo externo con el que se pueden realizar cesiones.
 */
public class MuseoExterno {
    private String nombre;
    private String direccion;

    /**
     * Constructor de la clase MuseoExterno.
     * 
     * @param nombre El nombre del museo externo.
     */
    public MuseoExterno(String nombre) {
        this.nombre = nombre;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}

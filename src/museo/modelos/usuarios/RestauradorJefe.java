package museo.modelos.usuarios;

import museo.modelos.obras.ObraArte;
import museo.modelos.operaciones.Restauracion;
import java.util.Date;
import java.util.List;

public class RestauradorJefe extends Usuario {

    public RestauradorJefe(String username, String clave) {
        super(username, clave);
    }

    public void iniciarRestauracion(ObraArte obra, String tipo) {
    }

    public void finalizarRestauracion(Restauracion restauracion) {
        restauracion.finalizar(new Date());
    }

    public List<Restauracion> consultarHistorialRestauraciones(ObraArte obra) {
        return null;
    }
}

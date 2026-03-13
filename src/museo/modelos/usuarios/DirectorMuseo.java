package museo.modelos.usuarios;

import museo.interfaces.IValorable;
import museo.modelos.obras.ObraArte;
import museo.modelos.operaciones.MuseoExterno;
import java.util.List;

public class DirectorMuseo extends Usuario {

    public DirectorMuseo(String username, String clave) {
        super(username, clave);
    }

    public void gestionarCesion(ObraArte obra, MuseoExterno museo, String periodo, double importe) {
    }

    public double consultarValoracionTotal(List<IValorable> obras) {
        double total = 0;
        for (IValorable obra : obras) {
            total += obra.obtenerValor();
        }
        return total;
    }
}

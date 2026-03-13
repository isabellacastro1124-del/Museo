import museo.enums.EstadoObra;
import museo.modelos.obras.Cuadro;
import museo.modelos.obras.Escultura;
import museo.modelos.obras.ObjetoOtro;
import museo.modelos.obras.ObraArte;
import museo.modelos.operaciones.Cesion;
import museo.modelos.operaciones.MuseoExterno;
import museo.modelos.operaciones.Restauracion;
import museo.modelos.usuarios.DirectorMuseo;
import museo.modelos.usuarios.EncargadoCatalogo;
import museo.modelos.usuarios.RestauradorJefe;
import museo.modelos.usuarios.Visitante;
import museo.servicios.GestorProcesosAutomaticos;
import museo.interfaces.IValorable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Creamos tres tipos distintos de obra que hereden de ObraArte:
        // un cuadro, una escultura y un objeto genérico.
        // Cada uno tiene su propio constructor con los datos que lo diferencian
        // (técnica, material, descripción) y luego le seteamos el resto de atributos.
        Cuadro cuadro = new Cuadro("C001", 15000.0, "Óleo sobre lienzo");
        cuadro.setTitulo("La Noche Estrellada");
        cuadro.setAutor("Van Gogh");
        cuadro.setEstilo("Postimpresionismo");
        cuadro.setEstado(EstadoObra.EXPUESTA); // está en sala, visible para el público

        Escultura escultura = new Escultura("E001", 30000.0, "Mármol");
        escultura.setTitulo("El Pensador");
        escultura.setAutor("Rodin");
        escultura.setEstado(EstadoObra.EXPUESTA);

        // Esta vasija está dañada, por eso la marcamos con DANADA desde el inicio
        ObjetoOtro objeto = new ObjetoOtro("O001", 8000.0, "Vasija de cerámica precolombina");
        objeto.setTitulo("Vasija Muisca");
        objeto.setAutor("Desconocido");
        objeto.setEstado(EstadoObra.DANADA);

        // Mostramos las obras recién creadas con su valor económico
        System.out.println("=== OBRAS REGISTRADAS ===");
        System.out.println("Cuadro: " + cuadro.getTitulo() + " | Valor: $" + cuadro.obtenerValor());
        System.out.println("Escultura: " + escultura.getTitulo() + " | Valor: $" + escultura.obtenerValor());
        System.out.println("Objeto: " + objeto.getTitulo() + " | Valor: $" + objeto.obtenerValor());

        // Creamos una encargada de catálogo y probamos que el sistema de login funciona.
        // autenticar() viene de la interfaz IAutenticable que implementa Usuario.
        EncargadoCatalogo encargado = new EncargadoCatalogo("maria.lopez", "clave123");
        System.out.println("\n=== AUTENTICACIÓN ===");
        System.out.println("Encargado autenticado: " + encargado.autenticar("maria.lopez", "clave123")); // debe ser true
        System.out.println("Intento fallido: " + encargado.autenticar("maria.lopez", "incorrecta"));    // debe ser false

        // La encargada registra las obras nuevas en el catálogo y actualiza los datos de la dañada
        encargado.registrarObra(cuadro);
        encargado.registrarObra(escultura);
        encargado.actualizarDatosObra(objeto);
        System.out.println("Obras registradas y actualizadas por encargado.");

        // El restaurador jefe se encarga de gestionar los procesos de restauración.
        // Primero cambiamos el estado de la vasija a EN_RESTAURACION y creamos el proceso.
        RestauradorJefe restaurador = new RestauradorJefe("carlos.ruiz", "rest456");
        System.out.println("\n=== RESTAURACIÓN ===");

        objeto.setEstado(EstadoObra.EN_RESTAURACION);
        Restauracion restauracion = new Restauracion(objeto, "Limpieza y consolidación", new Date());
        System.out.println("Restauración iniciada para: " + objeto.getTitulo());

        // Verificamos el método esAptaParaRestauracionPeriodica():
        // el cuadro está EXPUESTA así que sí aplica, el objeto ya está EN_RESTAURACION así que no
        System.out.println("Apta para restauración periódica (cuadro): " + cuadro.esAptaParaRestauracionPeriodica());
        System.out.println("Apta para restauración periódica (objeto en restauración): " + objeto.esAptaParaRestauracionPeriodica());

        // finalizarRestauracion() internamente llama restauracion.finalizar(new Date()),
        // que registra la fecha en que terminó el proceso
        restaurador.finalizarRestauracion(restauracion);
        objeto.setEstado(EstadoObra.EXPUESTA); // ya restaurada, vuelve a sala
        System.out.println("Restauración finalizada. Fecha fin: " + restauracion.getFechaFin());

        // Simulamos que el director cede la escultura al Museo del Prado por 6 meses.
        // Primero creamos el museo externo, luego la cesión con su importe y periodo.
        MuseoExterno museoExterno = new MuseoExterno("Museo del Prado");
        museoExterno.setDireccion("Calle Ruiz de Alarcón, Madrid");

        DirectorMuseo director = new DirectorMuseo("juan.director", "dir789");
        System.out.println("\n=== CESIÓN ===");

        escultura.setEstado(EstadoObra.CEDIDA);
        Cesion cesion = new Cesion(museoExterno, 5000.0, "6 meses");
        System.out.println("Cesión activa: " + cesion.isActiva());
        System.out.println("Museo destino: " + cesion.getMuseoExterno().getNombre());
        System.out.println("Importe: $" + cesion.getImporte());
        System.out.println("Periodo: " + cesion.getPeriodoTiempo());

        // El director gestiona formalmente la cesión desde su rol
        director.gestionarCesion(escultura, museoExterno, "6 meses", 5000.0);
        System.out.println("Cesión gestionada por el director.");

        // El director también puede calcular cuánto vale en total el inventario completo.
        // Usamos la interfaz IValorable para que el método acepte cualquier tipo de obra.
        System.out.println("\n=== VALORACIÓN TOTAL ===");
        List<IValorable> obras = new ArrayList<>();
        obras.add(cuadro);
        obras.add(escultura);
        obras.add(objeto);
        double total = director.consultarValoracionTotal(obras);
        System.out.println("Valor total del inventario: $" + total); // 15000 + 30000 + 8000 = 53000

        // Un visitante puede consultar qué obras hay en una sala específica
        Visitante visitante = new Visitante();
        System.out.println("\n=== VISITANTE ===");
        visitante.consultarObrasPorSala("Sala 1");
        System.out.println("Consulta de obras por sala realizada.");

        // El gestor automático revisa diariamente todas las obras
        // para detectar cuáles necesitan pasar a restauración periódica
        GestorProcesosAutomaticos gestor = new GestorProcesosAutomaticos();
        List<ObraArte> todasLasObras = new ArrayList<>();
        todasLasObras.add(cuadro);
        todasLasObras.add(escultura);
        todasLasObras.add(objeto);
        gestor.ejecutarRevisionDiariaRestauracion(todasLasObras);
        System.out.println("\n=== REVISIÓN DIARIA ===");
        System.out.println("Revisión diaria de restauración ejecutada sobre " + todasLasObras.size() + " obras.");
    }
}

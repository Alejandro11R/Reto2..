package Reto;

// Clase que representa una emergencia de tipo accidente vehicular
// Hereda de Emergencia e implementa la interfaz Responder
public class Accidente extends Emergencia implements Responder {

    // Constructor que define el tipo, ubicación, gravedad y tiempo estimado de respuesta
    public Accidente(String ubicacion, Gravedad gravedad, int tiempoRespuesta) {
        super("Accidente", ubicacion, gravedad, tiempoRespuesta);
    }

    // Acción que realiza la ambulancia al atender la emergencia
    @Override
    public void atenderEmergencia() {
        System.out.println("🚑 Ambulancia en camino al accidente en " + getUbicacion());
    }

    // Evaluación del estado de los afectados por el accidente
    @Override
    public void evaluarEstado() {
        System.out.println("🔍 Revisando signos vitales de los involucrados");
    }
}


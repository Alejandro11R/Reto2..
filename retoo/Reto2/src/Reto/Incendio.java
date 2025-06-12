package Reto;

// Clase que representa una emergencia de tipo incendio
// Extiende de la clase abstracta Emergencia e implementa la interfaz Responder
public class Incendio extends Emergencia implements Responder {

    // Constructor que inicializa una emergencia de tipo Incendio
    public Incendio(String ubicacion, Gravedad gravedad, int tiempoRespuesta) {
        super("Incendio", ubicacion, gravedad, tiempoRespuesta);
    }

    // Acción realizada por los bomberos al atender la emergencia
    @Override
    public void atenderEmergencia() {
        System.out.println("🚒 Bomberos en camino al incendio en " + getUbicacion());
    }

    // Evaluación del estado de la estructura afectada por el incendio
    @Override
    public void evaluarEstado() {
        System.out.println("🔍 Evaluando estado de la estructura incendiada");
    }
}


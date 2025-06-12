package Reto;

// Clase que representa una emergencia de tipo robo
// Hereda de la clase abstracta Emergencia e implementa la interfaz Responder
public class Robo extends Emergencia implements Responder {

    // Constructor que define el tipo de emergencia como "Robo"
    public Robo(String ubicacion, Gravedad gravedad, int tiempoRespuesta) {
        super("Robo", ubicacion, gravedad, tiempoRespuesta);
    }

    // Acción inicial del servicio al atender la emergencia
    @Override
    public void atenderEmergencia() {
        System.out.println("👮 Policía en camino al robo en " + getUbicacion());
    }

    // Evaluación posterior a la intervención policial
    @Override
    public void evaluarEstado() {
        System.out.println("🔍 Revisando el estado de los afectados por el robo");
    }
}

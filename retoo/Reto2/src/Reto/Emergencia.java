package Reto;

// Clase abstracta que representa una emergencia genérica dentro del sistema
// Sirve como clase base para tipos específicos como Incendio, Robo y Accidente
public abstract class Emergencia {

    private final String tipo;              // Tipo de emergencia (ej. Incendio, Robo, Accidente)
    private final String ubicacion;         // Ubicación donde ocurre la emergencia
    private final Gravedad nivelGravedad;   // Nivel de gravedad de la emergencia (enum)
    private final int tiempoRespuesta;      // Tiempo estimado de respuesta (en minutos)

    // Constructor para inicializar los atributos comunes a todas las emergencias
    public Emergencia(String tipo, String ubicacion, Gravedad nivelGravedad, int tiempoRespuesta) {
        this.tipo = tipo;
        this.ubicacion = ubicacion;
        this.nivelGravedad = nivelGravedad;
        this.tiempoRespuesta = tiempoRespuesta;
    }

    // Getter para obtener el tipo de emergencia
    public String getTipo() { return tipo; }

    // Getter para obtener la ubicación
    public String getUbicacion() { return ubicacion; }

    // Getter para obtener el nivel de gravedad
    public Gravedad getNivelGravedad() { return nivelGravedad; }

    // Getter para obtener el tiempo estimado de respuesta
    public int getTiempoRespuesta() { return tiempoRespuesta; }

    // Representación en texto de la emergencia (para mostrar en consola)
    @Override
    public String toString() {
        return "Emergencia[tipo=" + tipo + ", ubicacion=" + ubicacion
                + ", gravedad=" + nivelGravedad + ", tiempoRsp=" + tiempoRespuesta + "]";
    }
}

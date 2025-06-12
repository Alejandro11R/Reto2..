package Reto;// Clase que implementa el patrón Factory Method para crear emergencias
// Según el tipo recibido, instancia una subclase concreta de Emergencia
public class EmergenciaFactory {

    // Método estático para crear emergencias dinámicamente según el tipo
    public static Emergencia crear(String tipo, String ubicacion, Gravedad gravedad, int tiempo) {
        switch(tipo.toLowerCase()) {
            case "incendio":
                // Crea una emergencia de tipo Incendio
                return new Incendio(ubicacion, gravedad, tiempo);
            case "robo":
                // Crea una emergencia de tipo Robo
                return new Robo(ubicacion, gravedad, tiempo);
            case "accidente":
                // Crea una emergencia de tipo Accidente
                return new Accidente(ubicacion, gravedad, tiempo);
            default:
                // Si el tipo no es válido, lanza una excepción
                throw new IllegalArgumentException("Tipo desconocido: " + tipo);
        }
    }
}

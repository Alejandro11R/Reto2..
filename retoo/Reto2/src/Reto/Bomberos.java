package Reto;
// Clase que representa al servicio de bomberos en el sistema de emergencias
// Implementa la interfaz ServicioEmergencia para integrarse con el CentroControl
public class Bomberos implements ServicioEmergencia {

    private String nombre;     // Nombre o identificador de la unidad
    private int camiones;      // Camiones disponibles para la atención
    private int personal;      // Cantidad de bomberos disponibles
    private int combustible;   // Cantidad de combustible disponible (litros)

    // Constructor: inicializa el servicio de bomberos con recursos disponibles
    public Bomberos(String nombre, int camiones, int personal, int combustible) {
        this.nombre = nombre;
        this.camiones = camiones;
        this.personal = personal;
        this.combustible = combustible;
    }

    // Determina si el servicio puede atender un incendio
    @Override
    public boolean puedeAtender(Emergencia e) {
        return e.getTipo().equalsIgnoreCase("Incendio")
            && camiones > 0 && personal >= 2 && combustible >= 50;
    }

    // Atiende un incendio si los recursos son suficientes
    @Override
    public void atender(Emergencia e) {
        if (puedeAtender(e)) {
            System.out.println("🔥 Bomberos atendiendo incendio en " + e.getUbicacion());
            camiones--;
            personal -= 2;
            combustible -= 50;
        } else {
            System.out.println("❌ Bomberos no pueden atender esta emergencia.");
        }
    }

    // Muestra el estado actual de la unidad de bomberos
    @Override
    public void mostrarEstado() {
        System.out.println("🚒 Estado Bomberos " + nombre + ": camiones=" + camiones
                + ", personal=" + personal + ", combustible=" + combustible);
    }
}



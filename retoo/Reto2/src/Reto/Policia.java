package Reto;

// Clase que representa al servicio de policía en el sistema de emergencias
// Implementa la interfaz ServicioEmergencia para su integración con el CentroControl
public class Policia implements ServicioEmergencia {

    private String nombre;        // Identificador de la unidad policial
    private int patrullas;        // Patrullas disponibles
    private int oficiales;        // Oficiales disponibles
    private int combustible;      // Combustible disponible en litros

    // Constructor que inicializa los recursos del servicio de policía
    public Policia(String nombre, int patrullas, int oficiales, int combustible) {
        this.nombre = nombre;
        this.patrullas = patrullas;
        this.oficiales = oficiales;
        this.combustible = combustible;
    }

    // Verifica si la policía puede atender una emergencia de tipo Robo
    @Override
    public boolean puedeAtender(Emergencia e) {
        return e.getTipo().equalsIgnoreCase("Robo")
            && patrullas > 0 && oficiales >= 1 && combustible >= 20;
    }

    // Atiende una emergencia si hay recursos suficientes, y los descuenta
    @Override
    public void atender(Emergencia e) {
        if (puedeAtender(e)) {
            System.out.println("👮 Policía atendiendo robo en " + e.getUbicacion());
            patrullas--;
            oficiales -= 1;
            combustible -= 20;
        } else {
            System.out.println("❌ Policía no puede atender esta emergencia.");
        }
    }

    // Muestra el estado actual del servicio de policía
    @Override
    public void mostrarEstado() {
        System.out.println("👮 Estado Policía " + nombre + ": patrullas=" + patrullas
                + ", oficiales=" + oficiales + ", combustible=" + combustible);
    }
}


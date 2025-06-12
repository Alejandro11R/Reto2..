package Reto;

// Clase que representa al servicio de ambulancia en el sistema de emergencias
// Implementa la interfaz ServicioEmergencia para integrarse con el CentroControl
public class Ambulancia implements ServicioEmergencia {

    private String nombre;        // Nombre o identificador de la unidad
    private int unidades;         // Cantidad de ambulancias disponibles
    private int paramedicos;      // Cantidad de paramédicos disponibles
    private int combustible;      // Cantidad de combustible en litros

    // Constructor: inicializa la ambulancia con sus recursos
    public Ambulancia(String nombre, int unidades, int paramedicos, int combustible) {
        this.nombre = nombre;
        this.unidades = unidades;
        this.paramedicos = paramedicos;
        this.combustible = combustible;
    }

    // Evalúa si la ambulancia tiene recursos suficientes para atender un accidente
    @Override
    public boolean puedeAtender(Emergencia e) {
        return e.getTipo().equalsIgnoreCase("Accidente")
            && unidades > 0 && paramedicos >= 2 && combustible >= 30;
    }

    // Atiende una emergencia de tipo accidente, consumiendo recursos
    @Override
    public void atender(Emergencia e) {
        if (puedeAtender(e)) {
            System.out.println("🚑 Ambulancia atendiendo accidente en " + e.getUbicacion());
            unidades--;
            paramedicos -= 2;
            combustible -= 30;
        } else {
            System.out.println("❌ Ambulancia no puede atender esta emergencia.");
        }
    }

    // Muestra el estado actual del servicio de ambulancia
    @Override
    public void mostrarEstado() {
        System.out.println("🚑 Estado Ambulancia " + nombre + ": unidades=" + unidades
                + ", paramedicos=" + paramedicos + ", combustible=" + combustible);
    }
}

package Reto;

import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.PriorityQueue;


public class CentroControl {
    // Instancia única del centro de control (Singleton)
    private static CentroControl instancia;

    // Lista de servicios registrados: bomberos, ambulancia, policía
    private List<ServicioEmergencia> servicios;

    // Cola priorizada de emergencias, ordenadas por gravedad (Strategy)
    private Queue<Emergencia> cola;

    // Constructor privado para Singleton
    private CentroControl() {
        servicios = new ArrayList<>();
        cola = new PriorityQueue<Emergencia>(new EstrategiaPrioridad());
    }

    // Método para acceder a la instancia única
    public static CentroControl getInstancia() {
        if (instancia == null) instancia = new CentroControl();
        return instancia;
    }

    // Registro de un nuevo servicio de emergencia
    public void registrarServicio(ServicioEmergencia s) {
        servicios.add(s);
    }

    // Registrar una nueva emergencia y notificar a los servicios
    public void nuevaEmergencia(Emergencia e) {
        cola.add(e);
        notificarServicios(e);
    }

    // Notificación a los servicios para que intenten atender la emergencia
    private void notificarServicios(Emergencia e) {
        for (ServicioEmergencia s : servicios) {
            if (s.puedeAtender(e)) s.atender(e);
        }
    }

    // Procesar emergencias pendientes una por una (si es necesario manualmente)
    public void procesar() {
        while (!cola.isEmpty()) {
            Emergencia e = cola.poll();
            System.out.println("Procesando: " + e);
        }
    }

    // Mostrar estado actual de todos los servicios (recursos disponibles)
    public void mostrarEstadoServicios() {
        for (ServicioEmergencia s : servicios) s.mostrarEstado();
    }

    // Obtener la lista de servicios (para acceso desde el sistema)
    public List<ServicioEmergencia> getServicios() {
        return servicios;
    }
}

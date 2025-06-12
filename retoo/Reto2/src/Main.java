import java.util.Scanner;


import Reto.CentroControl;
import Reto.Emergencia;
import Reto.EmergenciaFactory;
import Reto.Gravedad;
import Reto.Bomberos;
import Reto.Ambulancia;
import Reto.Policia;
import Reto.ServicioEmergencia;

// Clase principal del sistema de gestión de emergencias urbanas
// Controla el menú, registro de emergencias, estadísticas y estado de servicios
public class Main {
    public static void main(String[] args) {
        // Obtener instancia del Centro de Control (Singleton)
        CentroControl cc = CentroControl.getInstancia();

        // Crear y registrar servicios de emergencia
        Bomberos bomberos = new Bomberos("Central", 3, 6, 200);
        Ambulancia ambulancia = new Ambulancia("Central", 2, 4, 120);
        Policia policia = new Policia("Central", 2, 4, 100);

        cc.registrarServicio(bomberos);
        cc.registrarServicio(ambulancia);
        cc.registrarServicio(policia);

        // Variables para métricas de desempeño
        Scanner sc = new Scanner(System.in);
        int totalEmergencias = 0;
        int totalTiempoRespuesta = 0;
        int totalIncendios = 0, tiempoIncendios = 0;
        int totalRobos = 0, tiempoRobos = 0;
        int totalAccidentes = 0, tiempoAccidentes = 0;

        // Menú principal interactivo
        while (true) {
            System.out.println("\n=== Sistema de Emergencias ===");
            System.out.println("1. Registrar emergencia");
            System.out.println("2. Mostrar estado servicios");
            System.out.println("3. Procesar emergencias pendientes");
            System.out.println("4. Salir y mostrar resumen");
            System.out.print("Opción: ");
            int opt = sc.nextInt(); sc.nextLine();
            if (opt == 4) break;

            switch (opt) {
                case 1:
                    // Ingreso manual de datos de emergencia
                    System.out.print("Tipo (Incendio/Robo/Accidente): ");
                    String tipo = sc.nextLine();
                    System.out.print("Ubicación: ");
                    String ub = sc.nextLine();
                    System.out.print("Gravedad (BAJO/MEDIO/ALTO): ");
                    Gravedad grd = Gravedad.valueOf(sc.nextLine().toUpperCase());
                    System.out.print("Tiempo estimado respuesta: ");
                    int t = sc.nextInt(); sc.nextLine();

                    // Crear emergencia usando Factory
                    Emergencia e = EmergenciaFactory.crear(tipo, ub, grd, t);

                    // Verificar si puede ser atendida
                    boolean atendida = false;
                    for (ServicioEmergencia s : cc.getServicios()) {
                        if (s.puedeAtender(e)) {
                            s.atender(e);
                            atendida = true;
                            break;
                        }
                    }

                    // Si no puede ser atendida, mostrar aviso
                    if (!atendida) {
                        System.out.println("\n❗ No hay recursos suficientes para atender esta emergencia.");
                        System.out.print("¿Desea ver el estado de los servicios y reasignar recursos? (S/N): ");
                        String respuesta = sc.nextLine();
                        if (respuesta.equalsIgnoreCase("S")) {
                            cc.mostrarEstadoServicios();
                            System.out.println("⚠️ Aún no se ha implementado la reasignación manual de recursos, pero aquí verías el estado actual para decidir.");
                        } else {
                            System.out.println("🚨 Emergencia no atendida.");
                        }
                    } else {
                        // Actualizar métricas según tipo
                        totalEmergencias++;
                        totalTiempoRespuesta += t;
                        if (tipo.equalsIgnoreCase("Incendio")) {
                            totalIncendios++;
                            tiempoIncendios += t;
                        } else if (tipo.equalsIgnoreCase("Robo")) {
                            totalRobos++;
                            tiempoRobos += t;
                        } else if (tipo.equalsIgnoreCase("Accidente")) {
                            totalAccidentes++;
                            tiempoAccidentes += t;
                        }
                    }
                    break;

                case 2:
                    // Mostrar estado actual de los servicios
                    cc.mostrarEstadoServicios();
                    break;

                case 3:
                    // Procesar manualmente las emergencias pendientes en cola
                    cc.procesar();
                    break;

                default:
                    System.out.println("Opción inválida");
            }
        }

        sc.close();

        // Mostrar resumen final de desempeño
        System.out.println("\n=== Resumen de la Jornada ===");
        System.out.println("Emergencias atendidas: " + totalEmergencias);
        if (totalEmergencias > 0) {
            System.out.println("Tiempo promedio general: " + (totalTiempoRespuesta / totalEmergencias) + " minutos");
        }
        if (totalIncendios > 0) {
            System.out.println("\n🔥 Incendios atendidos: " + totalIncendios + " | Promedio: " + (tiempoIncendios / totalIncendios) + " min");
        }
        if (totalRobos > 0) {
            System.out.println("👮 Robos atendidos: " + totalRobos + " | Promedio: " + (tiempoRobos / totalRobos) + " min");
        }
        if (totalAccidentes > 0) {
            System.out.println("🚑 Accidentes atendidos: " + totalAccidentes + " | Promedio: " + (tiempoAccidentes / totalAccidentes) + " min");
        }

        // Mostrar estado final de los servicios
        System.out.println("\n=== Recursos disponibles al final ===");
        cc.mostrarEstadoServicios();

        System.out.println("\nAnálisis completo generado. Planifique la siguiente jornada según resultados.");
        System.out.println("Fin del programa.");
    }
}


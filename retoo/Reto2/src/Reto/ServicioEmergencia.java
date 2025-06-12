package Reto;

public interface ServicioEmergencia {
    boolean puedeAtender(Emergencia e);
    void atender(Emergencia e);
    void mostrarEstado();
}

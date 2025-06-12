package Reto;

import java.util.Comparator;

// Clase que implementa una estrategia de prioridad para emergencias
// Aplica el patrón Strategy usando Comparator para priorizar por gravedad


public class EstrategiaPrioridad implements Comparator<Emergencia> {

    // Compara dos emergencias según su nivel de gravedad
    // Emergencias con mayor gravedad (ALTO) tienen prioridad sobre MEDIO y BAJO
    @Override
    public int compare(Emergencia e1, Emergencia e2) {
        return e2.getNivelGravedad().ordinal() - e1.getNivelGravedad().ordinal();
    }
}

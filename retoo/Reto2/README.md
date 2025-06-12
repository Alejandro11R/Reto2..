# Sistema de Gestión de Emergencias Urbanas 🚨

Este proyecto simula el funcionamiento de un **centro de control urbano** que atiende distintas emergencias (como incendios, accidentes y robos) mediante servicios especializados: **Bomberos**, **Ambulancia** y **Policía**. Fue desarrollado como parte de un reto de programación orientada a objetos por **Hugo Alejandro Rodríguez Montenegro**, aplicando patrones de diseño y buenas prácticas en Java.

## 📌 Características del sistema

- Simulación realista de atención a emergencias con recursos limitados
- Menú interactivo por consola para registrar y procesar emergencias
- Servicios especializados con consumo progresivo de recursos (personal, vehículos y combustible)
- Registro de estadísticas y métricas de desempeño al final de la jornada
- Sistema de prioridad para atención automática según nivel de gravedad (ALTO, MEDIO, BAJO)
- Capacidad de mostrar estado actual de cada servicio
- Detección de falta de recursos y simulación de análisis manual para tomar decisiones

## 🧠 Patrones de diseño aplicados

- **Singleton**: El centro de control se maneja como una única instancia (`CentroControl`)
- **Factory Method**: Se crean instancias de emergencias dinámicamente con `EmergenciaFactory`
- **Strategy**: Se priorizan las emergencias mediante la clase `EstrategiaPrioridad`
- **Observer**: Los servicios registrados son notificados automáticamente cuando se registra una nueva emergencia

## ⚙️ Clases y estructura general

- `Emergencia` (abstracta): define atributos comunes a todas las emergencias
  - `Incendio`, `Accidente`, `Robo` (subclases)
- `ServicioEmergencia` (interfaz): implementada por `Bomberos`, `Ambulancia` y `Policía`
- `CentroControl`: gestiona la cola de emergencias, notifica servicios y controla los recursos
- `Main`: contiene el menú de interacción y el control del flujo de ejecución
- `Gravedad`: Enum para los niveles BAJO, MEDIO, ALTO
- `EstrategiaPrioridad`: estrategia para ordenar las emergencias por gravedad
- `EmergenciaFactory`: crea emergencias según el tipo indicado

## 🚀 Cómo ejecutar el sistema

### ✅ Requisitos:
- JDK 11 o superior

### ▶️ Ejecución manual:
1. Ubica todos los archivos `.java` dentro de una carpeta `Reto`
2. Abre terminal en el directorio raíz
3. Ejecuta:
```bash
javac Reto/*.java
java Reto.Main
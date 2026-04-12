// ============================================================
// VERSIÓN 2 — Bucle do-while + switch todo en main
// Conceptos practicados (respecto a v1):
//   - Bucle do-while: el menú se repite hasta elegir "Salir"
//   - switch con break: reemplaza la cadena de if/else if
//   - Variable boolean para validar prioridad (igual que v1)
// Diferencia con v4: toda la lógica sigue en main (sin métodos separados)
// ============================================================

import java.util.Scanner; // Scanner permite leer lo que el usuario escribe en consola

public class GestorDeTareas2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in); // Objeto para capturar la entrada del teclado
        int opcion;                               // Guarda la opción elegida en cada vuelta del bucle
        int totalPrioridad = 0;                  // Acumulador: suma de prioridades de las tareas creadas

        // do-while garantiza que el menú se muestre AL MENOS UNA VEZ.
        // El bloque se repite mientras el usuario no elija la opción 3 (Salir).
        do {
            // --- Mostramos el menú en cada iteración ---
            System.out.println("*** Gestor de Tareas ***");
            System.out.println("1. Añadir tarea");
            System.out.println("2. Ver tareas (Pendientes)");
            System.out.println("3. Salir");

            System.out.println("Elige una opción:");
            opcion = scanner.nextInt(); // Leemos la opción como número entero

            // Después de nextInt() queda un '\n' en el buffer; nextLine() lo descarta
            // para que la siguiente lectura de texto (nextLine) funcione correctamente
            scanner.nextLine(); // Limpiar el buffer

            // switch evalúa 'opcion' y ejecuta SOLO el bloque case que coincida
            switch (opcion) {

                case 1:
                    // --- Opción 1: Añadir tarea ---

                    System.out.println("Introduce el nombre de la tares: ");
                    String nombreTarea = scanner.nextLine(); // Lee texto con posibles espacios

                    System.out.println("Ingresa el nivel de prioridad (1-5)");
                    int prioridad = scanner.nextInt(); // Lee la prioridad como entero

                    // Evaluamos si la prioridad está dentro del rango permitido (1 a 5)
                    // El resultado es un booleano: true si es válida, false si no lo es
                    boolean isValid = prioridad >= 1 && prioridad <= 5;
                    System.out.println("Prioridad valida: " + isValid); // Mostramos el resultado del booleano

                    if (isValid) {
                        // Prioridad válida: acumulamos y confirmamos la tarea
                        totalPrioridad += prioridad; // Suma la prioridad al total acumulado
                        System.out.println("Tarea: '" + nombreTarea + "' con una prioridad de: " + prioridad + " creada.");
                        System.out.println("Suma total de la prioridad: " + totalPrioridad);
                    } else {
                        // Prioridad fuera de rango: rechazamos sin modificar el acumulador
                        System.out.println("Prioridad no válida");
                    }
                    break; // break evita que se sigan ejecutando los cases siguientes (fall-through)

                case 2:
                    // --- Opción 2: Ver tareas (no implementada aún) ---
                    System.out.println("La función (Ver Tareas) aún no esá implementada.");
                    break;

                case 3:
                    // --- Opción 3: Salir del programa ---
                    System.out.println("Hasta luego!");
                    break;

                default:
                    // default se activa cuando la opción no coincide con ningún case
                    System.out.println("Opción inválida. Por favor, elige una opción entre 1 y 3.");
                    break;
            }

        } while (opcion != 3); // Repetir el menú mientras no se elija "Salir"

        scanner.close(); // Liberamos el recurso Scanner al terminar
    }
}

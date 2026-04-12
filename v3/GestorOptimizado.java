// ============================================================
// VERSIÓN 3 — Switch expressions (Java 14+) y formato avanzado
// Conceptos nuevos respecto a versiones anteriores:
//   - switch con flechas (->): sintaxis moderna, sin break ni fall-through
//   - System.out.print vs println: print no añade salto de línea al final
//   - System.out.printf: formato de texto con marcadores (%s, %d, %b, %n)
//   - Método privado (private): solo accesible desde dentro de esta clase
//   - Modificador private vs public en métodos
// ============================================================

import java.util.Scanner; // Necesario para leer la entrada del usuario desde consola

public class GestorOptimizado {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in); // Objeto para leer lo que escribe el usuario
        int opcion;                               // Opción elegida en cada iteración del menú
        int totalPrioridad = 0;                  // Acumulador de prioridades de todas las tareas

        // Bucle do-while: muestra el menú y procesa la opción hasta que el usuario elija Salir
        do {
            imprimirMenu(); // Llamada al método privado que dibuja el menú con bordes

            // System.out.print (sin "ln") imprime sin salto de línea al final,
            // así el cursor queda en la misma línea que el "👉 Elige una opción:"
            System.out.print("👉 Elige una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpia el '\n' que queda en el buffer tras nextInt()

            // switch con flechas (->): sintaxis de Java 14+
            // Cada case es una "expresión", NO necesita break porque no hay fall-through
            switch (opcion) {

                case 1 -> {
                    // --- Opción 1: Añadir tarea ---

                    // System.out.print deja el cursor al final de la línea (sin salto)
                    System.out.print("📌 Nombre de la tarea: ");
                    String nombreTarea = scanner.nextLine(); // Lee el nombre con posibles espacios

                    System.out.print("⭐ Prioridad (1-5): ");
                    int prioridad = scanner.nextInt();
                    scanner.nextLine(); // Limpia el buffer después de leer el int

                    // Validamos si la prioridad está en el rango correcto
                    boolean isValid = prioridad >= 1 && prioridad <= 5;

                    // printf con marcadores de formato:
                    //   %b  → booleano (true / false)
                    //   %n  → salto de línea (equivale a \n, pero portable entre SO)
                    System.out.printf("✅ Prioridad válida: %b%n", isValid);

                    if (isValid) {
                        // Prioridad válida: la sumamos al acumulador
                        totalPrioridad += prioridad;
                    } else {
                        // Prioridad inválida: avisamos y asignamos 1 como valor por defecto
                        System.out.println("⚠️ Prioridad no válida. Se añadirá 1 por defecto.");
                        prioridad = 1; // Corregimos el valor a 1
                        totalPrioridad += prioridad; // También sumamos la prioridad corregida
                    }

                    // printf con marcadores de formato:
                    //   %s  → String (texto)
                    //   %d  → entero decimal (int, long)
                    //   %n  → salto de línea
                    System.out.printf("🆕 Tarea '%s' creada con prioridad %d%n", nombreTarea, prioridad);
                    System.out.printf("🔢 Suma total de prioridades: %d%n", totalPrioridad);
                }

                // Cases de una sola instrucción no necesitan llaves {}
                case 2 -> System.out.println("🕒 La función 'Ver Tareas' aún no está implementada.");

                case 3 -> System.out.println("👋 ¡Hasta luego!");

                default -> System.out.println("❌ Opción inválida. Por favor, elegí entre 1 y 3.");
            }

        } while (opcion != 3); // Repetimos hasta que el usuario elija "Salir"

        scanner.close(); // Liberamos el recurso Scanner al finalizar el programa
    }

    // -------------------------------------------------------
    // imprimirMenu()
    // Dibuja el menú con bordes de caracteres Unicode.
    // private: solo se puede llamar desde dentro de esta clase.
    // static:  no necesita una instancia del objeto para ejecutarse.
    // No recibe parámetros ni devuelve valor (void).
    // -------------------------------------------------------
    private static void imprimirMenu() {
        System.out.println("\n╔══════════════════════════════════╗");
        System.out.println("║      📋  GESTOR DE TAREAS        ║");
        System.out.println("╠══════════════════════════════════╣");
        System.out.println("║  [1] ➕ Añadir tarea             ║");
        System.out.println("║  [2] 📄 Ver tareas pendientes    ║");
        System.out.println("║  [3] 🚪 Salir                    ║");
        System.out.println("╚══════════════════════════════════╝");
    }
}

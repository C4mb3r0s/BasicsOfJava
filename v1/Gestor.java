// ============================================================
// VERSIÓN 1 — Prototipo inicial
// Conceptos practicados:
//   - Scanner para leer entrada del usuario
//   - Variables de tipo int, String, boolean
//   - Condicionales if / else if / else
//   - Operadores de comparación (>=, <=, ==)
//   - Operador de acumulación (+=)
// ============================================================

import java.util.Scanner; // Importamos Scanner para leer lo que el usuario escribe en consola

public class Gestor {

    public static void main(String[] args) {

        // Scanner nos permite leer lo que el usuario escribe en la consola
        Scanner scan = new Scanner(System.in);

        // Variable acumuladora: irá sumando las prioridades de cada tarea creada
        int totalPrioridad = 0;

        // Mostramos el menú de opciones disponibles
        System.out.println("*** Gestor de Tareas ***");
        System.out.println("1. Nueva tarea");
        System.out.println("2. Ver Tareas (Pendientes)");
        System.out.println("3. Salir");

        // Pedimos al usuario que elija una opción y la guardamos como entero
        System.out.println("Elige una opción: ");
        int opcion = scan.nextInt();

        // Después de leer un int con nextInt(), el salto de línea (\n) queda en el buffer.
        // nextLine() lo descarta para que la siguiente lectura de texto funcione correctamente.
        scan.nextLine();

        // Validamos que la opción esté dentro del rango permitido (1, 2 o 3)
        if (opcion >= 1 && opcion <= 3) {

            if (opcion == 1) {
                // --- Opción 1: Crear nueva tarea ---

                System.out.println("Ingresa el nombre de la terea: ");
                String nombreTarea = scan.nextLine(); // Leemos el nombre completo (puede tener espacios)

                System.out.println("Ingresa la prioridad de la terea (del 1 al 5");
                int prioridad = scan.nextInt(); // Leemos la prioridad como número entero

                // Verificamos que la prioridad esté entre 1 y 5; el resultado es true o false
                boolean esValida = prioridad >= 1 && prioridad <= 5;
                System.out.println("Prioridad valida: " + esValida); // Mostramos el booleano en consola

                if (esValida) {
                    // Si la prioridad es válida, la sumamos al total acumulado
                    totalPrioridad += prioridad; // equivale a: totalPrioridad = totalPrioridad + prioridad
                } else {
                    // Si la prioridad es inválida, avisamos y asignamos 1 como valor por defecto
                    System.out.println("Prioridad inválida. Debe ser un número entre 1 y 5.");
                    System.out.println("Se añadira 1 por defecto");
                    prioridad = 1; // Reemplazamos el valor inválido con 1
                    // Nota: aquí falta sumar al totalPrioridad tras corregir (bug de aprendizaje)
                }

                // Confirmamos al usuario que la tarea fue creada con su prioridad final
                System.out.println("Tarea '" + nombreTarea + "' con prioridad " + prioridad + " creada.");
                System.out.println("La suma total de la prioridad es: " + totalPrioridad);

            } else if (opcion == 2) {
                // --- Opción 2: Ver tareas pendientes (no implementada aún) ---
                System.out.println("La función (Ver Tareas) aun no está implementada");

            } else if (opcion == 3) {
                // --- Opción 3: Salir del programa ---
                System.out.println("Hasta luego!");
            }

        } else {
            // Si el usuario escribe un número fuera de 1-3, informamos y terminamos
            System.out.println("La opción que escogiste es invalida, se cerrará el programa, hasta pronto!");
        }

        // Cerramos el Scanner para liberar el recurso de entrada
        scan.close();
    }
}

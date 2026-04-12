// ============================================================
// VERSIÓN 4 — Refactorización con métodos estáticos
// Conceptos nuevos respecto a v1, v2 y v3:
//   - Métodos estáticos (static): separar la lógica en funciones reutilizables
//   - Bucle do-while: el menú se repite hasta que el usuario elige "Salir"
//   - switch con break: alternativa más limpia a múltiples if/else if
//   - Paso de parámetros y valor de retorno entre métodos
// ============================================================

import java.util.Scanner; // Necesario para leer la entrada del usuario desde consola

public class GestorDeTareas {

    // -------------------------------------------------------
    // MÉTODO PRINCIPAL — punto de entrada del programa
    // -------------------------------------------------------
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in); // Objeto para leer lo que escribe el usuario
        int opcion;                          // Almacena la opción elegida en cada iteración del menú
        int totalPrioridad = 0;             // Acumula la suma de prioridades de todas las tareas creadas

        // do-while: ejecuta el bloque AL MENOS UNA VEZ y luego repite mientras opcion != 3
        do {
            mostrarMenu();                                       // Imprime las opciones disponibles
            opcion = leerOpcion(sc);                             // Lee y devuelve la opción del usuario
            totalPrioridad = ejecutarOpcion(opcion, sc, totalPrioridad); // Procesa la opción elegida
        } while (opcion != 3); // Condición de salida: el usuario eligió "Salir"

        sc.close(); // Liberamos el recurso Scanner al terminar el programa
    }

    // -------------------------------------------------------
    // mostrarMenu()
    // Imprime en consola las tres opciones del menú.
    // No recibe parámetros ni devuelve ningún valor (void).
    // -------------------------------------------------------
    public static void mostrarMenu() {
        System.out.println("*** Gestor de Tareas ***");
        System.out.println("1. Nueva tarea");
        System.out.println("2. Ver Tareas (Pendientes)");
        System.out.println("3. Salir");
    }

    // -------------------------------------------------------
    // leerOpcion(Scanner sc)
    // Pide al usuario que escriba un número y lo devuelve.
    // Recibe: sc — el Scanner compartido con main
    // Devuelve: int — el número que escribió el usuario
    // -------------------------------------------------------
    public static int leerOpcion(Scanner sc) {
        System.out.println("Elige una opción");
        return sc.nextInt(); // Lee un entero y lo retorna directamente
    }

    // -------------------------------------------------------
    // ejecutarOpcion(int opcion, Scanner sc, int totalPrioridad)
    // Decide qué hacer según la opción elegida.
    // Recibe: opcion        — número elegido por el usuario
    //         sc            — Scanner para leer más datos si hace falta
    //         totalPrioridad — valor actual del acumulador de prioridades
    // Devuelve: int — el nuevo valor de totalPrioridad (puede haber cambiado)
    // -------------------------------------------------------
    public static int ejecutarOpcion(int opcion, Scanner sc, int totalPrioridad) {

        // Limpiamos el buffer: nextInt() deja el '\n' pendiente; nextLine() lo consume
        sc.nextLine();

        // switch evalúa 'opcion' y ejecuta solo el caso que coincida
        switch (opcion) {
            case 1:
                // Delegamos la lógica de agregar tarea a su propio método
                totalPrioridad = agregarTarea(sc, totalPrioridad);
                break; // break evita que se ejecuten los casos siguientes (fall-through)

            case 2:
                System.out.println("Esta opción esta en desarrollo");
                break;

            case 3:
                System.out.println("Hasta luego");
                break;

            default:
                // default se ejecuta si ningún case coincide (opción fuera de rango)
                System.out.println("Opción inválida, Intentá de nuevo");
        }

        return totalPrioridad; // Devolvemos el acumulador (actualizado o igual que antes)
    }

    // -------------------------------------------------------
    // agregarTarea(Scanner sc, int totalPrioridad)
    // Pide el nombre y la prioridad de una tarea nueva.
    // Solo suma la prioridad al total si está entre 1 y 5.
    // Recibe: sc            — Scanner para leer los datos de la tarea
    //         totalPrioridad — valor actual del acumulador
    // Devuelve: int — el acumulador actualizado con la nueva prioridad
    // -------------------------------------------------------
    public static int agregarTarea(Scanner sc, int totalPrioridad) {

        System.out.println("Ingresa el nombre de la tarea");
        String nombre = sc.nextLine(); // nextLine() lee texto con espacios hasta el Enter

        System.out.println("Ingresa la prioridad (1-5");
        int prioridad = sc.nextInt();
        sc.nextLine(); // Consumimos el '\n' sobrante después del nextInt()

        if (prioridad >= 1 && prioridad <= 5) {
            // Prioridad válida: la acumulamos y confirmamos la creación
            totalPrioridad += prioridad;
            System.out.println("Tarea: '" + nombre + "' con una prioridad de: " + prioridad + " creada.");
            System.out.println("Suma total de la prioridad: " + totalPrioridad);
        } else {
            // Prioridad fuera de rango: rechazamos sin modificar el total
            System.out.println("Prioridad no válida");
        }

        return totalPrioridad; // Retornamos el acumulador (modificado solo si la prioridad fue válida)
    }
}

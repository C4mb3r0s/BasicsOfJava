# Gestor de Tareas — Ejercicios de Java

Proyecto de aprendizaje progresivo del lenguaje Java. Cada carpeta contiene una versión del mismo programa —un gestor de tareas por consola— donde se introduce un nuevo conjunto de conceptos del lenguaje.

## Estructura del proyecto

```
GestorDeTareas/
├── v1/  Gestor.java           → Prototipo: variables, if/else, Scanner
├── v2/  GestorDeTareas2.java  → do-while + switch todo en main
├── v3/  GestorOptimizado.java → Switch expressions (Java 14+), printf, private
└── v4/  GestorDeTareas.java   → Métodos estáticos, do-while, switch clásico
```

---

## Versiones

### v1 — Prototipo (`Gestor.java`)

El punto de partida. Se ejecuta **una sola vez** (sin bucle) y usa únicamente `if / else if / else` para navegar el menú.

**Conceptos practicados:**
- `Scanner` para leer entrada del usuario
- Variables primitivas: `int`, `boolean`, `String`
- Condicionales `if / else if / else`
- Operadores de comparación (`>=`, `<=`, `==`) y acumulación (`+=`)
- Limpieza del buffer de entrada con `nextLine()` tras `nextInt()`

---

### v2 — do-while + switch en main (`GestorDeTareas2.java`)

Versión intermedia. Añade el bucle `do-while` y reemplaza los `if/else if` por un `switch`, pero mantiene **toda la lógica dentro de `main`**, sin extraer métodos.

**Conceptos nuevos:**
- Bucle `do-while`: garantiza al menos una ejecución del menú
- `switch` clásico con `break`
- Uso de `boolean` para almacenar el resultado de una validación
- Impresión del valor booleano directo en consola

---

### v3 — Switch moderno y printf (`GestorOptimizado.java`)

Versión más avanzada en cuanto a sintaxis. Introduce la forma moderna de Java y mejora la experiencia de usuario con un menú visual.

**Conceptos nuevos:**
- **Switch expressions con `->` (Java 14+):** sin `break`, sin fall-through
- `System.out.print` vs `System.out.println`
- `System.out.printf` con marcadores de formato: `%s`, `%d`, `%b`, `%n`
- Modificador de acceso `private` en métodos (vs `public`)
- Caracteres Unicode para construir bordes en consola

---

### v4 — Refactorización con métodos estáticos (`GestorDeTareas.java`)

La versión más estructurada. La lógica se divide en **4 métodos estáticos** independientes, aplicando el principio de responsabilidad única.

**Conceptos nuevos:**
- Métodos `static`: declaración, parámetros y valor de retorno
- Paso de valores entre métodos y devolución con `return`
- `switch` clásico con `break` dentro de un método propio
- Organización del código en funciones reutilizables (`mostrarMenu`, `leerOpcion`, `ejecutarOpcion`, `agregarTarea`)

---

## Cómo compilar y ejecutar

No se necesita Maven ni Gradle. Solo el JDK instalado.

```bash
# Compilar (desde la raíz del proyecto)
javac v1/Gestor.java
javac v2/GestorDeTareas2.java
javac v3/GestorOptimizado.java   # Requiere Java 14 o superior
javac v4/GestorDeTareas.java

# Ejecutar (desde la carpeta correspondiente)
java -cp v1 Gestor
java -cp v2 GestorDeTareas2
java -cp v3 GestorOptimizado
java -cp v4 GestorDeTareas
```

> **Nota:** La versión 3 usa switch expressions (`->`), disponibles a partir de **Java 14**. Las versiones 1, 2 y 4 funcionan con Java 5 o superior.

---

## Tabla comparativa

| Característica         | v1 Gestor | v2 GestorDeTareas2 | v3 GestorOptimizado | v4 GestorDeTareas |
|------------------------|:---------:|:------------------:|:-------------------:|:-----------------:|
| Bucle principal        | No        | `do-while`         | `do-while`          | `do-while`        |
| Flujo condicional      | `if/else` | `switch` clásico   | `switch` con `->`   | `switch` clásico  |
| Métodos separados      | No        | No                 | 1 método privado    | 4 métodos         |
| `printf`               | No        | No                 | Sí                  | No                |
| Corrección prioridad   | A 1 (sin sumar) | Rechaza      | A 1 y suma          | Rechaza           |
| Java mínimo requerido  | 5+        | 5+                 | **14+**             | 5+                |

---

## Requisitos

- **JDK 14+** para compilar y ejecutar la versión 3
- **JDK 5+** para las versiones 1, 2 y 4
- No requiere dependencias externas

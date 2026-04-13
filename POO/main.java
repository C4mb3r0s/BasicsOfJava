public class main {
  public static void main(String[] args) {
    // Creacion de nuevo conchoe con el constructor
    Coche miCoche = new Coche("Toyota", 2023);

    // 2. User getters para leer los datos
    System.out.println("Marca: " + miCoche.getMarca());
    System.out.println("Año: " + miCoche.getAnio());

    // 3. Usar setters para cambiar datos
    miCoche.setMarca("Ford");
    miCoche.setAnio(2024);

    // 4. Llamar metodo
    miCoche.arrancar();
  }
}

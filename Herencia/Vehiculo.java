public class Vehiculo {
  private String marca;
  private int anio;

  public Vehiculo(String marca, int anio) {
    this.marca = marca;
    this.anio = anio;
  }

  public void mostrarInfo() {
    System.out.println("Marca: " + marca + ", Año: " + anio);
  }
}

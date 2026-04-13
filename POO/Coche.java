public class Coche {
  // Atributos
  private String marca;
  private int anio;

  // constructor
  public Coche(String marca, int anio) {
    this.marca = marca;
    this.anio = anio;
  }

  // Setters
  public void setMarca(String marca) {
    this.marca = marca;
  }

  public void setAnio(int anio) {
    this.anio = anio;
  }

  // Getters
  public String getMarca() {
    return marca;
  }

  public int getAnio() {
    return anio;
  }

  public void arrancar() {
    System.out.println("El coche arrancó!");
  }
}

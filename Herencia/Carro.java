public class Carro extends Vehiculo {
  private int puertas;

  public Carro(String marca, int anio, int puertas) {
    super(marca, anio);
    this.puertas = puertas;
  }

  public void mostrarCantidadDePuertas() {
    System.out.println("Puertas: " + puertas);
  }
}

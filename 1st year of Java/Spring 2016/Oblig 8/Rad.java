public class Rad {

  private int radNR;
  private int radTeller;
  static int teller;

  // Konstruktoren til klassen Rad.
  public Rad(int radNR) {
    this.radNR = radNR;
    radTeller = teller++;
  }

  // Metode som skal returnere radnummeret.
  public int getRadNR() {
    return radNR;
  }

}

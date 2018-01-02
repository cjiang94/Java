public class Boks {

  private int boksNR;
  private int boksTeller;
  static int teller;

  // Konstruktoren til klassen Boks.
  public Boks(int boksNR) {
    this.boksNR = boksNR;
    boksTeller = teller++;
  }

  // Metode som returnerer boksnummeret.
  public int getBoksNR() {
    return boksNR;
  }
}

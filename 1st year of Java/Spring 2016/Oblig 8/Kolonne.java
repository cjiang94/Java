public class Kolonne {

  private int kolonneNR;
  private int kolonneID;
  static int teller = 0;

  // Konstruktoren til klassen Kolonne.
  public Kolonne(int kolonneNR) {
    this.kolonneNR = kolonneNR;
    kolonneID = teller++;
  }

  // Metode som returnerer kolonnenummeret.
  public int getKolonneNR() {
    return kolonneNR;
  }

}

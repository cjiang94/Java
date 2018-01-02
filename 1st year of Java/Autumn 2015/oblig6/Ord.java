// Lager en klasse kalt Ord.
public class Ord{

  // Lager private variabler som jeg setter som standard null og 1 inntil videre.
  private String tekst = null;
  private int teller = 1;
  // Lager konstruktor.
  public Ord (String tekst) {
    this.tekst = tekst;
  }

  // Lager toString-metode.
  public String toString() {
    return tekst;
  }

  // Lager en metode som returnerer antall forekomster av ordet vi soker paa.
  public int hentAntall() {
    return teller;
  }

  // En metode som oeker telleren med 1 hver gang vi kaller paa metoden.
  public void oekAntall() {
    teller++;
  }

}

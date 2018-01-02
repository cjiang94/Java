public class Resept {

  // private variable som holder paa ulike verdier.
  private int nummer;
  private static int teller = 0;
  private int reit;
  private Legemiddel medisin;
  private String legeNavn, pasientNavn, farge;

  // Konstruktoren til klassen Resept som tar inn forskjellige parametere naar man opprettet en ny resept.
  public Resept(Legemiddel medisin, String legeNavn, String pasientNavn, int reit, String farge) {
    this.medisin = medisin;
    this.legeNavn = legeNavn;
    this.pasientNavn = pasientNavn;
    this.reit = reit;
    this.farge = farge;

    // En teller som tikker hver gang man lager en ny resept.
    nummer = teller;
    teller++;
  }

  // En boolean metode for aa sjekke om resepten er gyldig eller ikke.
  public boolean gyldig() {
    if(reit > 0){
      return true;
    }
    return false;
  }

  // Testprogram som jeg lagde paa siden for aa sjekke om telleren og gyldig-metoden for resepten fungerer.
  public void brukResept() {
    if(gyldig()){
      reit --;
      System.out.println("Resepten har naa " + reit + " antall ganger igjen.");
    } else
      System.out.println("Resepten er ugyldig.");
  }

  // Testprogram som skulle skrive ut informasjon om resepten.
  public void info() {
    medisin.info();
    System.out.println("Reseptnr: " + nummer + ".");
    System.out.println("Lege: " + legeNavn + ".");
    System.out.println("Pasient: " + pasientNavn + ".");
    System.out.println("Resepten har antall " + reit + " ganger igjen.");
    System.out.println("Farge: " + farge + ("\n\n"));
  }
}

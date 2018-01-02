public class Resept {

  // private variable som holder paa ulike verdier.
  private static int teller = 0;
  private int reit, nummer, pasientTall, legeMiddelNr;
  private Legemiddel medisin = null;
  private String legeNavn, farge;

  // Konstruktoren til klassen Resept som tar inn forskjellige parametere naar man opprettet en ny resept.
  public Resept(Legemiddel medisin, String legeNavn, int pasientTall, int legeMiddelNr, int reit, String farge) {
    this.medisin = medisin;
    this.legeNavn = legeNavn;
    this.pasientTall = pasientTall;
    this.legeMiddelNr = legeMiddelNr;
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

  // Metode for aa returnere Legemiddel.
  public Legemiddel returnLegemiddel() {
    return medisin;
  }

  // Metode for aa sjekke om resepten er blaa.
  public boolean erReseptBlaa() {
    if(farge.equalsIgnoreCase("blaa")) {
      return true;
    } else {
      return false;
    }
  }

  // Metode som returnerer legens navn.
  public String legeToString() {
    return legeNavn;
  }

  // Metode for aa returnere reseptnummeret.
  public int returnNr() {
    return nummer;
  }


  // Testprogram som skulle skrive ut informasjon om resepten.
  public void info() {
    System.out.println("Reseptnr: " + nummer + ".");
    System.out.println("Legemiddel: " + medisin.toString() + ".");
    System.out.println("Lege: " + legeNavn + ".");
    System.out.println("Pasientnr: " + pasientTall + ".");
    System.out.println("Resepten har antall " + reit + " ganger igjen.");
    System.out.println("Farge: " + farge + ("\n\n"));
  }

  // Metode for aa skrive ut info til fil.
  public String nyInfo() {
    return nummer + ", " + farge + ", " + pasientTall + ", " + legeNavn + ", " + legeMiddelNr + ", " + reit;
  }
}

public class Pasient {

  // Diverse variable som holder paa verider til pasienten.
  private String navn, adresse;
  private long fNr;
  private int postNr, nummer;
  private YngsteForstReseptListe yngsteListe;
  // en static int teller som skal jobbe i bakgrunnen for hver gang vi opprettet en ny pasient og vare en lopende teller.
  private static int teller = 0;

  // Konstruktoren til klassen Pasient, som tar inn ulike parametere. Utforsket litt med "long", siden fodselsnummer er ganske lang.
  public Pasient(String navn, long fNr, String adresse, int postNr) {
    this.navn = navn;
    this.fNr = fNr;
    this.adresse = adresse;
    this.postNr = postNr;

    nummer = teller;
    teller++;
  }

  // Metode til aa returnere navnet til Pasienten.
  public String toString() {
    return navn;
  }

  // Metode som returnerer listen YngsteForstReseptListe.
  public YngsteForstReseptListe toListe() {
    return yngsteListe;
  }

  // Egenlagd testklasse for aa see om programmet fungerte.
  public void info(){
    System.out.println("Pasientnavn: " + navn + ".");
    System.out.println("Pasientnummer: " + nummer + ".");
    System.out.println("Fodselsnummer: " + fNr + ".");
    System.out.println("Adresse: " + adresse + ".");
    System.out.println("Postnummer: " + postNr + ".");
  }
}

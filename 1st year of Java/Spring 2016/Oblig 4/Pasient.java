public class Pasient {

  // Diverse variable som holder paa verider til pasienten.
  private String navn, adresse;
  private long fNr;
  private int pasientNr, postNr, nummer;
  /* Blitt forandret etter pblig 7
  En static int teller som skal jobbe i bakgrunnen for hver gang vi opprettet en ny pasient og vare en lopende teller.
  private static int teller = 0; */

  // Konstruktoren til klassen Pasient, som tar inn ulike parametere. Utforsket litt med "long", siden fodselsnummer er ganske lang.
  public Pasient(int pasientNr, String navn, long fNr, String adresse, int postNr) {
    this.pasientNr = pasientNr;
    this.navn = navn;
    this.fNr = fNr;
    this.adresse = adresse;
    this.postNr = postNr;

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

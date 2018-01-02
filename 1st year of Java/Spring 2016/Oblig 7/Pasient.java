import java.util.Iterator;   // Importerer iterator.

public class Pasient {

  // Diverse variable som holder paa verider til pasienten.
  private int nummer;
  private String navn, adresse, fNr, postNr;
  private YngsteForstReseptListe yngsteListe = new YngsteForstReseptListe();
  private Resept r;

  // en static int teller som skal jobbe i bakgrunnen for hver gang vi opprettet en ny pasient og vare en lopende teller.
  private static int teller = 0;

  // Konstruktoren til klassen Pasient, som tar inn ulike parametere. Utforsket litt med "long", siden fodselsnummer er ganske lang.
  public Pasient(String navn, String fNr, String adresse, String postNr) {
    this.navn = navn;
    this.fNr = fNr;
    this.adresse = adresse;
    this.postNr = postNr;

    nummer = teller;
    teller++;
  }

  public int returnNr() {
    return nummer;
  }

  // Metode til aa returnere navnet til Pasienten.
  public String toString() {
    return navn;
  }

  // Metode som returnerer listen YngsteForstReseptListe.
  public YngsteForstReseptListe returnYngsteListe() {
    return yngsteListe;
  }

  // Metode for aa legge til ny resept i yngsteListe.leggTil();
  public void nyResept(Resept r) {
    this.r=r;
    yngsteListe.leggTil(r);
  }

 // Metode for aa sjekke to personnummere med hverandre.
  public boolean samme(String fodselsnummer) {
    if(fNr.equals(fodselsnummer)){
      return true;
    }
    return false;
  }

  // Metode for aa returnere en resept for pasienten.
  public Resept returnResept() {
    return r;
  }

  // Metode for aa skrive ut alle blaa resepter til en person.
  public void skrivAlleBlaa() {
    Iterator<Resept> iter = yngsteListe.iterator();
    System.out.println(navn + " sine alle blaa resepter: ");

    while(iter.hasNext()) {
      Resept tR = iter.next();
      if(tR.erReseptBlaa()) {
        tR.info();
      }
     }
  }

  // Metode for aa hente en resept, og for aa bruke en resept.
  public void hentResepter(int a) {
    if(yngsteListe.finnResept(a) != null) {
      yngsteListe.finnResept(a).brukResept();
  }
  }

  // Metode for aa se om en person bor i Oslo.
  public boolean borIOslo() {
    int intPostNr = Integer.parseInt(postNr);
    if(intPostNr >= 1 && intPostNr <= 1295) {
      return true;
    } else {
      return false;
    }

  }

  // Metode for aa skrive ut resepter.
  public void skrivUtResepter() {
    Iterator<Resept> iter = yngsteListe.iterator();
    while(iter.hasNext()){
      iter.next().info();
    }
  }

  // Egenlagd testklasse for aa see om programmet fungerte.
  public void info(){
    System.out.println("\n\nPasientnummer: " + nummer + ".");
    System.out.println("Pasientnavn: " + navn + ".");
    System.out.println("Fodselsnummer: " + fNr + ".");
    System.out.println("Adresse: " + adresse + ".");
    System.out.println("Postnummer: " + postNr + ".\n\n");
  }

  // Metode for aa skrive ut info til fil.
  public String nyInfo() {
    return nummer + ", " + navn + ", " + fNr + ", " + adresse + ", " + postNr;

  }
}

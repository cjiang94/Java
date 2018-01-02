/* Dette er main klassen som skal sende inn en testFil.txt som en String inn til konstruktoren i klassen DVDAdministrasjon.
Den blir gjort om til et File-objekt inne i klassen DVDAdministrasjon. */
public class oblig7 {
  public static void main (String[] args) throws Exception {   /* Maatte haa med throws Exception fordi vi leser filen som en File
                                                                inne i DVDAdministrasjon. Faar ellers feilkode.*/

    System.out.println ("\n\n\n\nHei, og velkommen til DVD-utleie! OBS. Navn er case sensitiv!");
    new DVDAdministrasjon("dvdarkiv.txt"); // Sender inn testFil.txt inn til konstruktoren i DVDAdministrasjon.
  }
}

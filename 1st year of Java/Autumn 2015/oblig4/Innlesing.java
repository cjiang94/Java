// Importerer Scanner og File.
import java.util.Scanner;
import java.io.File;

public class Innlesing {
  public static void main(String[] args) throws Exception{

    // Oppgave 4.2 A)
    // Lar variabelen File bli kalt "winnie" og leser tekstfilen winnie.txt.
    File winnie = new File ("winnie.txt");
    // Bruker Scanner til aa lese winnie.
    Scanner in = new Scanner (winnie);

    // Oppgave 4.2 C) (Forandret oppgave B til aa inneholde oppgave C).
    // Printer ut tekst.
    System.out.println ("Vennligst skriv inn et ord du vil soke paa!");
    // Lager en ny Scanner kalt brukerTekst.
    Scanner brukerTekst = new Scanner (System.in);
    // Kaller det vi skriver inn, brukerTekst, for "data".
    String data = brukerTekst.nextLine();
    // Lager en teller paa 0.
    int teller = 0;

    // Lager en while-loop som looper saa lenge tekstfilen har en ny linje med tekst under.
    while (in.hasNextLine()) {
    // Lager en String-variabel som tar inn ordet brukeren tastet inn.
    String lesFraFil = in.nextLine();
      /* en boolean som gjor all tekst om til liten bokstaver og sjekker om den inneholder
      ordet som brukeren tastet inn. */
      if (lesFraFil.toLowerCase().contains(data.toLowerCase())) {
        // Hvis den inneholder ordet brukeren tastet inn, vil teller plusses med 1.
        teller++;
      }
    }
    // in.close(); For å avslutte å lese filen min Scanner.

    /* Printer ut tekst og resultat av hvor mange ganger while-loopen fant teksten
    brukeren tastet inn. */
    System.out.println ("Det finnes " + teller + " antall av ordet du sokte i teksten.");
  }
}

// Importerer Scanner for at bruker skal kunne skrive inn tekst de vil soke.
import java.util.Scanner;

public class Oblig6 {
  public static void main (String[] args) throws Exception {
    // Lager et nytt objekt av typen ordliste kalt scarlet.
    Ordliste scarlet = new Ordliste();
    // sender inn text.filen til metoden lesBok.
    scarlet.lesBok("scarlet.text");
    // Interaksjoner med brukeren hvor ulike metoder blir kalt paa for aa loose oppgavene.
    System.out.println("Sporsmaal a: Hvor mange ulike ord forekommer i boken?");
    System.out.println("Det er " + scarlet.antallOrd() + " ulike ord i teksten.");

    /* Kommentar til Oppgave b&c : Her tolket jeg oppgaven slik at bruker skulle soke et ord de ville finne selv.
    Jeg saa ikke for senere at oppgaven spurte om Holmes og elementary. Kunne eventuelt har forandret
    oppgaven slik at man sendte inn argumentet "Holmes" og "elementary" til finnOrd-metoden, men lot
    det staa som det er og heller lagt inn en kommentar. */
    Scanner in = new Scanner(System.in);
    System.out.println("Sporsmaal b: Hvilket ord vil du lete antall forekomster av? (Skriv gjerne Holmes)\n");
    // Her printer den ut bare forekomster av "Holmes" UTEN apostrof bak.
    System.out.println("Det er " + scarlet.antallForekomster(in.nextLine()) + " antall forekomster av ordet du sokte i teksten.\n");

    System.out.println("Sporsmaal c:Hvilket ord vil du lete antall forekomster av? (Skriv gjerne elementary)\n");
    System.out.println("Det er " + scarlet.antallForekomster(in.nextLine()) + " antall forekomster av ordet du sokte i teksten.\n");

    System.out.println("Sporsmaal d: Det ordet som dukker opp flest ganger i teksten er: " + scarlet.vanligste() + "\n");

    System.out.println("Sporsmaal d (frivillig): De ordene som dukker opp flest ganger i teksten er: ");
    // Lager en for-each som leser gjennom listen til alleVanligste-metoden og printer ut ALLE de ordene som forekommer flest ganger.
    for(Ord hvertOrd : scarlet.alleVanligste()) {
      System.out.println(hvertOrd);
    }

  }
}

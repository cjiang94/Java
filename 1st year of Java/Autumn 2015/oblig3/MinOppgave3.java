// Oppgave 3.5 : Lag en handleliste paa maks 10 varer som skal ramse opp varene paa en liste. Lag i tillegg en if-setning som gjor at bruker kan skrive exit og avslutte handlelisten sin.

// Importerer Scanner.
import java.util.Scanner;

// Lager en class kalt MinOppgave3.
public class MinOppgave3 {
  public static void main (String [] args) {
    // Printer ut laaaang tekst!
    System.out.println ("Hei, og velkommen til Handleliste-Appen! :D (Developed by CiOS) Dette er en APP som lar deg skrive ned en handleliste paa maks 10 varer og spytter ut alt for deg i en fin og ryddig liste etterpaa! (Avslutt listen din ved aa taste inn 'exit'. Vennligst skriv inn hva du vil kjope.");

    // Definerer Scanner som "in".
    Scanner in = new Scanner (System.in);
    // Lager en String-array som har 10 indekser.
    String [] varer = new String [10];
    // Lager en teller og setter den paa "0".
    int teller = 0;
    // Definerer en String kalt brukeVare, men ingen verdi er satt ennaa. **
    String brukeVare;

    // Spoer bruker sporsmaal.
    System.out.println ("Hva er varen du vil kjope?");
    // Lager en while-lokke som looper hvis teller er mindre enn varer.length (her 10).
    while (teller < varer.length){

      // Interaksjon med bruker, og dette er en variabel type String. **
      brukeVare = in.nextLine ();
      // Lager en if-setning som sier at hvis bruker skriver inn exit (ignorerer store bokstaver), saa skal teller = 11, altsaa avslutte while-lokken.
      if (brukeVare.equalsIgnoreCase ("exit")) {
        teller = 11;
      }
      /* Lager en else som sier at hvis brukeren ikke skriver "exit,", sa fortsetter gaar den ut av if-setningen og looper paa while igjen.
         Alt dette vil loope, helt til while-lokken slutter. */
      else {
        varer[teller] = brukeVare;
      }
    // Looper while-setningen og gir teller +1 indeksnr hver gang.
    teller++;

    }

    // Printer ut tekst.
    System.out.println ("Her kommer varene dine :)");
    // Setter teller lik 0 igjen.
    teller = 0;
    // Lager en while-lokke som printer ut tekst saa lenge teller er under varer.length (her 10).
    while (teller < varer.length) {
      // Her vil den printe ut alle varene vi har skrevet inn paa forhaand, fordi varer[teller] har naa faatt en verdi fra hva bruker skrev inn tidligere.
      System.out.println ("[" + teller + "]   " + varer[teller]);
      teller++;
    }

  }
}

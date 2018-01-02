/* Les inn filen RandomTall.txt og gjoer slik at bruker
kan soke paa et tall og deretter regnes summen av alle tallene ved bruk av en metode
som returnerer en verdi */

// Importerer Scanner og File.
import java.util.Scanner;
import java.io.File;

// Lager en public class kalt "MinOppgave4".
public class MinOppgave4 {
  // Har med "throws Exception", fordi jeg leser fra en fil.
  public static void main(String[] args) throws Exception {

  // Lar variabelen File lese filen "RandomTall.txt" og heter minFil.
  File minFil = new File ("RandomTall.txt");
  // Lar Scanner lese minFil.
  Scanner in = new Scanner (minFil);

  // Lager en ny Scanner for aa lese tall bruker taster inn.
  Scanner inputBruker = new Scanner (System.in);
  // Spor bruker om aa taste inn et tall.
  System.out.println ("Tast inn et tall du vil programmet skal soke og addere for deg!");
  // Kaller det brukeren taster inn for "brukerTall".
  int brukerTall = inputBruker.nextInt();

  // Lager en teller som settes paa 0.
  int teller = 0;
  // Lager en while-loop som looper saa lenge tekstfilen har en neste linje med tall.
  while (in.hasNextInt()) {
    /* Lager en boolean som er true hvis tallet i teksten er
    det samme som tallet brukeren tastet inn */
    if (in.nextInt() == (brukerTall)) {
    // Hvis det er samme tall, saa vil teller plusse med 1.
    teller++;
    }
  }

  /* Lar variabelen int hete sum. "sum" kaller paa metoden "sumAvTall"
  som tar inn parametere brukerTal og teller. */
  int sum = sumAvTall(brukerTall, teller);

  // Printer ut resultat.
  System.out.println ("Tekstfilen har " + teller + (" antall av nummeret du tastet inn.\n Summen er: " + sum));

  }
  /* En metode som regner ut summen av antall "brukerTall" * hvor mange ganger
  det oppstaar i teksten. Metoden tar inn variabler av int */
  public static int sumAvTall(int brukerTall, int antall) {
    // Returnerer summen.
    return brukerTall*antall;
  }
}

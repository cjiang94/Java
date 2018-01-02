// Oppgave 3.1 A & B
// Importerer Scanner.
import java.util.Scanner;

// Lager en class som heter SumTall.
public class SumTall{
  public static void main (String [] args) {

    // Definerer Scanner som "in".
    Scanner in = new Scanner (System.in);

    // Interaksjon med brukeren.
    System.out.println ("Vennligst skriv inn et tall!");
    int brukerTall= Integer.parseInt (in.nextLine ());

    // Lager en ny variabel som adderer alle tallene brukeren har skrevet inn.
    int sum = brukerTall;

    // Lager en lokke som looper hvis man skriver et tall over eller under 0.
    while (brukerTall > 0 || brukerTall < 0) {
      System.out.println ("Vennligst skriv inn et annet tall! (avslutt med '0')");
      brukerTall = Integer.parseInt (in.nextLine ());
      // Her summeres alle tallene (brukerTall) brukeren skriver inn og adderer det til "sum".
      sum = sum + brukerTall;

    }

    // Printer ut tekst.
    System.out.println ("Summen blir " + sum);

  }
}

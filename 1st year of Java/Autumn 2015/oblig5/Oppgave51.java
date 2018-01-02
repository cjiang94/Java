// Importerer Scanner.
import java.util.Scanner;

class Oppgave51 {
  public static void main(String[] args) {

    // Konstruerer en ny bil med tankstorrelse paa 500 og bensinforbruk paa 2 liter per km.
    Bil minBMW = new Bil(500,2);
    // Definerer Scanner lik "in".
    Scanner in = new Scanner (System.in);

    // Lager en boolean kalt "viCruiser" og sett den like true.
    boolean viCruiser = true;
    // Interaksjon med bruker.
    System.out.println ("\nGratulerer med ny bil! Bilen din har en makstank paa " + minBMW.hentMaxTank() + "liter og er ROSAFARGET!!");

    // Lager en while-lokke som looper saa lenge viCruiser = true.
    while (viCruiser){
      // Interaksjon med bruker.
      System.out.println ("\n\n\n\n");
      System.out.println ("\nKilometerstand: " + minBMW.hentKilometerstand() + "\nBensin: " + minBMW.hentBilTank() + " liter \nGjenvaerende kjoredistanse: " + minBMW.hentMaksDistanse() +  "km. \nMakstank: " + minBMW.hentMaxTank());
      System.out.println ("\n\nHva vil du gjore? \n 1. Kjore en tur? \n 2. Fylle paa bensin? \n 3. Avslutte turen?");
      int viCruiserInn = in.nextInt ();
      // En if-setning som spor hvor langt bruker vil kjore, hvis bruker taster 1.
      if (viCruiserInn == 1) {
        System.out.println ("\nHvor langt vil du kjore? :)");
        int brukerinput = in.nextInt ();
        minBMW.kjorTur(brukerinput);
      }
      // En else-if-setning som spor hvor mye bensin bruker vil fylle paa, hvis bruker taster 2.
      else if (viCruiserInn == 2) {
        System.out.println ("\nHvor mye vil du fylle paa?");
        int brukerFyllTank = in.nextInt ();
        minBMW.fyllTank(brukerFyllTank);

      }
      // En else-if-setning som avslutter turen ved aa sette viCruiser = false.
      else if (viCruiserInn == 3) {
        viCruiser = false;
        System.out.println ("\nVi sees neste gang! Beep beep!");
      }
      // en else-setning som gir deg feilmelding om du skriver noe annet enn 1,2,3.
      else {
        System.out.println ("\nKunne ikke tyde meldingen din.");
      }

    }

  }
}

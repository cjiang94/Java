// Oppgave 2.1 A/B

// Importerer Scanner.
import java.util.Scanner;

class Metoder {
  // Lager en metode kalt treGanger.
  static void hilsen() {
    Scanner in = new Scanner (System.in);
    // Interaksjon med bruker.
    System.out.println ("Hei, hva heter du?");
    String navn = in.nextLine ();

    System.out.println ("Hvor kommer du fra?");
    String bosted = in.nextLine ();

    System.out.println ("Hei, " + navn + "! Du kommer fra " + bosted);
  }

  // Bruker metoden 3 ganger.
  public static void main(String [] args) {
    hilsen();
    // Lager mellomrom i teksten.
    System.out.println ();
    hilsen();
    System.out.println ();
    hilsen();
  }

}

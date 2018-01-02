import java.util.Scanner;

class LikeVerdier {
  public static void main(String [] args) {

// Oppgave 1.4 A
    // Gir varablene c og d verdier.
    int c = 5;
    int d = 8;

// Oppgave 1.4 B
    // Sjekker om verdiene c og d er like.
    if (c ==(d)) {
      System.out.println ("c og d er like");
    }
    else {
      System.out.println ("c er ikke lik d");
    }

// Oppgave 1.4 C
    // Innfoerer Scanner for at brukeren kan skrive tall.
    Scanner in = new Scanner (System.in);

    // Gjoer slik at bruker kan skrive inn et foerste tall.
    System.out.println ("Skriv inn et tall");
    String bruker1 = in.nextLine ();
    int tall1 = Integer.parseInt (bruker1);

    // Gjoer slik at bruker kan skrive inn et annet tall.
    System.out.println ("Skriv inn et annet tall");
    String bruker2 = in.nextLine ();
    int tall2 = Integer.parseInt (bruker2);

    /* Hvis tall1 og tall2 er riktig vil den gi en type svar.
       Ellers gir den et annet svar. */
    if (tall1 ==(tall2)) {
      System.out.println ("Ditt foerste tall er lik ditt andre tall");
    }
    else {
      System.out.println ("Ditt foerste tall er ikke likt ditt andre tall");

    }
  }
}

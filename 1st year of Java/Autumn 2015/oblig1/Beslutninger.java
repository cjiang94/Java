import java.util.Scanner; // Dette importerer Scanner.

class Beslutninger {
  public static void main (String [] args) {

// Oppgave 1.2 A
    int alder = 14;  // Setter alderen "min" = 14.


// Oppgave 1.2 B
    if (alder>=18) {                        /* Hvis jeg er over eller lik 18 aar,
                                            saa vil den si "Du er myndig". */
      System.out.println ("Du er myndig");
    }
    else {
      System.out.println ("Du er ikke myndig");  /* Hvis ikke saa sier den
                                                    "Du er ikke myndig". */
    }


// Oppgave 1.2 C
    // Legger inn import java.util.Scanner; paa toppen.
    System.out.println ("Hvor gammel er du? :)");
    Scanner in = new Scanner (System.in);
    int dinAlder = in.nextInt ();

    if (dinAlder>=18) {                        /* Hvis jeg er over eller lik 18 aar,
                                            saa vil den si "Du er myndig". */
      System.out.println ("Du er myndig");
    }
    else {
      System.out.println ("Du er ikke myndig");  /* Hvis ikke saa sier den
                                                    "Du er ikke myndig". */
    }

  }
}

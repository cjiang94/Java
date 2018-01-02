// Importerer Scanner.
import java.util.Scanner;
class MinOppgave1 {
  public static void main (String [] args) {

    // Skriver inn introduksjon til teksten min og spoer om navnet til brukeren.
    System.out.println ("Hei, og velkommen til Christins Kinesiske Horoskop. Det kinesiske kalenderet har forskjellige dyr basert paa hvilket aar du er foedt! Foerst og fremst, hva heter du? :) ");

    // Definerer Scanner som "in".
    Scanner in = new Scanner (System.in);

    // Gjoer slik at bruker kan skrive inn navnet sitt.
    String navn = in.nextLine ();
    System.out.println ("Hei, " + navn + ("! Hvilket aar er du foedt i? :) (1985-1997)"));

    // Gjoer slik at bruker kan skrive inn foedtselsaar.
    int aar = in.nextInt ();

    // En tekstsamling av forskjellige dyreaar man kan bli foedt i.
    if (aar < 1985) {
    System.out.println ("Christins Kinesiske Horoskop kunne dessverre ikke tyde meldingen din. Vennligst tast inn et foedselsaar mellom 1985-1997.");
    }

    else if(aar == 1985) {
    System.out.println ("Gratulerer, du er foedt i okse-aaret! Oksen er: Aerlig, bestemt og ambisioes! :D");
    }

    else if (aar == 1986) {
    System.out.println ("Gratulerer, du er foedt i tiger-aaret! Tigeren er: Modig, eventyrlystig og selvstendig! :D");
    }

    else if (aar == 1987) {
    System.out.println ("Gratulerer, du er foedt i kanin-aaret! Kaninen er: Smart, elegant og taalmodig! :D");
    }

    else if (aar == 1988) {
    System.out.println ("Gratulerer, du er foedt i drage-aaret! Dragen er: Selvsikker, intelligent og entusiastisk! :D");
    }

    else if (aar == 1989) {
    System.out.println ("Gratulerer, du er foedt i slange-aaret! Slangen er: Vis, livlig og rolig! :D");
    }

    else if (aar == 1990) {
    System.out.println ("Gratulerer, du er foedt i heste-aaret! Hesten er: Aktiv, optimistisk og sentimental! :D");
    }

    else if (aar == 1991) {
    System.out.println ("Gratulerer, du er foedt i geite-aaret! Geiten er: Kreativ, omtenksom og aerlig! :D");
    }

    else if (aar == 1992) {
    System.out.println ("Gratulerer, du er foedt i ape-aaret! Apen er: Smart, optimistisk og eventyrlystig! :D");
    }

    else if (aar == 1993) {
    System.out.println ("Gratulerer, du er foedt i hane-aaret! Hanen er: Selvsikker, hardtarbeidende og modig! :D");
    }

    else if (aar == 1994) {
    System.out.println ("Gratulerer, du er foedt i hunde-aaret! Hunden er: Aerlig, forsiktig og lojal! :D");
    }

    else if (aar == 1995) {
    System.out.println ("Gratulerer, du er foedt i grise-aaret! Grisen er: Sjeneroes, ansvarsfull og moden! :D");
    }

    else if (aar == 1996) {
    System.out.println ("Gratulerer, du er foedt i rotte-aaret! Rotten er: Snill, smart og ressursfull! :D");
    }

    else if (aar == 1997) {
    System.out.println ("Gratulerer, du er foedt i okse-aaret! Oksen er: Aerlig, bestemt og ambisioes! :D");
    }

    else {
    System.out.println ("Christins Kinesiske Horoskop kunne dessverre ikke tyde meldingen din. Vennligst tast inn et foedselsaar mellom 1985-1997.");
    }
  }
}

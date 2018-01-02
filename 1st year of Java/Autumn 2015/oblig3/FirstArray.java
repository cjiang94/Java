// Oppgave 3.2.
// Importerer Scanner.
import java.util.Scanner;

// Lager en class kalt FirstArray.
public class FirstArray{
  public static void main (String [] args) {

    // Definerer Scanner som "in".
    Scanner in = new Scanner (System.in);

    // Oppgave 3.2 A
    int[] tall = {0,1,2,3};

    // Oppgave 3.2 B
    // Lager en ny array med 4 plasser.
    int array [] = new int [4];

    // Definerer lengden paa arrayen som "lengdeArray".
    int lengdeArray = array.length;
    /* Lager en variabel "teller1" som starter paa 0, som skal telle gangene
      for meg */
    int teller1 = 0;

    // Lager en while-lokke som looper saa lenge teller1 er under lengden paa arrayet (her: 4).
    while (teller1 < lengdeArray){
      // Her definerer vi at indeksen skal bli fylt med indeksnr. Altsaa 0=0, 1=1... etc.
      array[teller1] = teller1;
      // Looper while-setningen og gir teller +1 indeksnr hver gang.
      teller1++;

    }
    // Oppgave 3.2 C
    // Her definerer vi plass nr 0 og 3 til aa bli "1337".
    array[0] = 1337;
    array[3] = 1337;

    // lager en ny teller som starter paa 0.
    int teller2 = 0;
    // Lager en while-loop som looper saa lenge teller2 er mindre enn lengden paa arrayet (her: 4).
    while (teller2 < lengdeArray){
      // Printer ut tekst, og her vil det definere plass 0 og 3 som "1337".
      System.out.println ("Plass nr [" + teller2 + "] er " + array[teller2]);
      // Looper while-setningen og gir teller +1 indeksnr hver gang.
      teller2++;

    }

    // Oppgave 3.2 D & E
    // Lager en String-array med 5 indekser.
    String brukerNavn [] = new String [5];
    // Definerer lengden paa arrayen som "lengeNavn".
    int lengdeNavn = brukerNavn.length;
    // Setter navnTeller til aa starte paa 0.
    int navnTeller = 0;

    // Spor bruker om aa taste inn 5 navn.
    System.out.println("Skriv inn 5 navn!");
    // Lager en while-lokke som looper saa lenge navnTeller er under lengdeNavn (her: 5).
    while (navnTeller < lengdeNavn){
      // Interaksjon med bruker.
      brukerNavn[navnTeller] = in.nextLine();
      // Looper while-setningen og gir navnTeller +1 indeksnr hver gang.
      navnTeller++;
    }

    // Setter navnTeller paa 0 igjen.
    navnTeller = 0;
    // Looper saa lenge navnTeller er mindre enn lengdeNavn (her 5).
    while (navnTeller < lengdeNavn){
      // Printer ut tekst om hvilke navn bruker har skrevet inn og hvilken indeksplassering den har.
      System.out.println("Plass nr [" + navnTeller + "] har navnet " + brukerNavn[navnTeller]);
      // Looper while-setningen og gir navnTeller +1 indeksnr hver gang.
      navnTeller++;
    }

  }
}

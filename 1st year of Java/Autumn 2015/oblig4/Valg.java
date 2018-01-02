// Importerer Scanner og File.
import java.io.File;
import java.util.Scanner;

// Oppgave 4.4 A - Main metoden kalt "Valg".
public class Valg {
  public static void main(String[] args) throws Exception {

    // Lager en variabel for tekstfilen "stemmer.txt".
    File valgFil = new File ("stemmer.txt");
    // Lager en Scanner som leser tekstfilen vaar.
    Scanner in = new Scanner (valgFil);

    // Lager en array kalt "valgArray" paa 456 indekser.
    String valgArray[] = new String[456];

    // Oppgave 4.4 B
    // Lager en loop som looper og leser filen i putter det i array-en.
    for (int i=0; i < valgArray.length; i++) {
      valgArray[i] = in.nextLine();
    }


    // Oppgave 4.4 C
    // Lager en int-array paa 4 plasser.
    int telleStemmerArray[] = new int [4];

    // Lager en lokke som looper og teller hvor mange stemmer det er.
    for (int i=0; i < valgArray.length; i++) {
      // Hvis en stemme er Ap, vil array-en paa plass 0 plusse med 1.
      if (valgArray[i].equals ("Ap")) {
        telleStemmerArray[0]++;
      }
      // Hvis en stemme er KrF, vil array-en paa plass 1 plusse med 1.
      else if (valgArray[i].equals ("KrF")) {
        telleStemmerArray[1]++;
      }
      // Hvis en stemme er Sp, vil array-en paa plass 2 plusse med 1.
      else if (valgArray[i].equals ("Sp")) {
        telleStemmerArray[2]++;
      }
      // Hvis en stemme er H, vil array-en paa plass 3 plusse med 1.
      else if (valgArray[i].equals ("H")) {
        telleStemmerArray[3]++;
      }
    }

    // Lager array paa 4 indekser.
    String[] parti = {"Ap", "KrF", "Sp", "H"};

    // Lager en variabel som husker paa hvem som leder i valget + en variabel som "tar vare paa" prosenten til vinneren.
    int vinner = 5;
    double stemmergjsnitt = 0;

    // En for-lokke som looper saa lenge telleren er under lengden paa teksten (her: 456).
    for (int i=0; i<telleStemmerArray.length; i++){
      // Regner ut prosent for hvert parti.
      double gjSnitt = (double) telleStemmerArray[i] / valgArray.length * 100;
      // en boolean som setter inn lederpartiet og prosenten til partiet.
      if(gjSnitt > stemmergjsnitt) {
        vinner = i;
        stemmergjsnitt = gjSnitt;
      }
      // Skriver ut tekst.
      System.out.println ("Gjennomsnittet av "+ parti[i] +"s stemmer er:\n" + gjSnitt + "%.\n");
      }
      System.out.println("Vinneren av valget er partiet: " + parti[vinner]);

  }
}

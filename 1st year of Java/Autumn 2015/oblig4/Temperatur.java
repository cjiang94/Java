// Importerer Scanner og File, for aa bruker Scanner til aa lese filer med .txt
import java.util.Scanner;
import java.io.File;

// Lager en public class kalt temperatur.
public class Temperatur {
  // Legger til throws Exception pga fil-lesning.
  public static void main (String [] args) throws Exception {

    // Definerer temperatur.txt til minFil.
    File minFil = new File("temperatur.txt");
    // Lar Scanner lese minFil.
    Scanner in = new Scanner (minFil);

    // Lager en array paa 12 indekser. Og setter teller = 0.
    double array [] = new double [12];
    int teller = 0;

    // Lager en for-lokke som looper saa lenge teksten har en neste linje.
    while (in.hasNextLine ()) {
      // Fyller inn hver indeks med hver linje i teksten.
      array[teller] = Integer.parseInt (in.nextLine());
      // Lar teller plusse med 1 for hver gang loopen gaar.
      teller++;
    }

    /* for egne notater, ikke viktig. for (int teller2 = 0; teller2 < array.length; teller2++){
    System.out.println (array[teller2]);
  } */

    // Lager en variabel double kalt "gjennomsnitt" som kaller paa metoden "snittMetode".
    double gjennomsnitt = snittMetode (array);
    // Printer ut tekst.
    System.out.println ("Gjennomsnittet blir " + gjennomsnitt + (" grader celsius"));
  }

  // Metoden min kalt snittMetode.
  static double snittMetode (double [] nyArray) {
  // lager en double-variabel kalt sum.
  double sum = 0;
    // Lager en for-loop som adderer temperaturene.
    for (int teller=0; teller < nyArray.length; teller++){
    sum = sum + nyArray[teller];
  }
  // Her regner vi gjennomsnittet av temperaturene.
  sum = sum / nyArray.length;
  // Returnerer verdien i sum.
  return sum;

  }
}

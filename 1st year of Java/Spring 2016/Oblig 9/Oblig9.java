import java.util.*; // Importerer de pakkene som trengs til aa kjore programmet.
import java.io.*;

public class Oblig9 {

  // Diverse variable som skal brukes i koden.
  public static int antOrdFil;
  static int ordTeller = 0;
  static int antTraader;
  static int arrayTeller = 0;
  static int antOrdPerTraad;
  static int moduloRest;
  static int midlTilAlleOrdFil = 0;
  static String utFil;
  static String filnavn;
  static String[] alleOrdFil;
  static String[] midlAntOrdPerTraadArray;
  static Traad[] alleTraaderArray;


  public static void main(String[] args) throws Exception {

   // Lagrer alle argumentene fra terminalen inn i variabler.
  try {
    // Lagrer antall ord i filen.
    antTraader = Integer.parseInt(args[0]);
  } catch (Exception e) {
    System.out.println("Error: " + e.getMessage());
  }

  try {
    // Lagrer hvilken fil vi skal lese i fra.
    filnavn = args[1];
  } catch(Exception e) {
    System.out.println("Error: " + e.getMessage());
  }

  try {
    // Lagrer hvilken fil vi skal skrive til.
    utFil = args[2];
  } catch (Exception e) {
    System.out.println("Error: " + e.getMessage());
  }

  // Kaller paa lesfilMetoden som skal taa inn en fil og lese i fra den.
  lesFil(filnavn);

  // Regner ut hvor mange ord som er i rest naar vi har delt antall ord i fil  med antall traader.
  moduloRest = antOrdFil%antTraader;
  // Oppgir hvor mange antall ord det er per traad, utennom den siste traaden som skal ta vare paa de siste "modulo"-ordene.
  antOrdPerTraad = ((antOrdFil-moduloRest)/(antTraader-1));

  // En midlertidig ord-array som skal holde paa alle ordene per array.
  midlAntOrdPerTraadArray = new String[antOrdPerTraad];

  // Oppretter en ny monitor.
  BeggesMonitor nyMonitor = new BeggesMonitor(antTraader);

  // Deklarerer storrelsen paa alleTraaderArray. Denne holder paa alle traadene i en array.
  alleTraaderArray = new Traad[antTraader];

  /* Her leser vi inne hver linje i filen saa lenge det er under anatall ord per traad., og Lagrer
    det inne i midlAntOrdPerTraadArray. */
  for(int i = 0; i<(antTraader-1);i++) {
    for(int n=0; n<(antOrdPerTraad); n++) {
      midlAntOrdPerTraadArray[n] = alleOrdFil[midlTilAlleOrdFil];
      midlTilAlleOrdFil++;
    }

  // Oppretter en ny traad for hver gang vi har lest ferdig midlAntOrdPerTraadArray.
  Traad nyTraad = new Traad(antOrdPerTraad, nyMonitor);
  // Sender inn arrayet til en spesifikk traad til traad-klassen.
  nyTraad.setArrayPaaTraad(midlAntOrdPerTraadArray);
  // Oppdaterer og setter inn traaden i alleTraaderArray-et.
  alleTraaderArray[i]=nyTraad;

  }

  // Finner ut hvilken linje vi maa starta paa for aa starte aa lese inn til modulo-traaden.
  int sisteTraadStartTall=(alleOrdFil.length-(alleOrdFil.length-(antOrdPerTraad*(antTraader-1))));
  // Vi overskriver storrelsen til midlAntOrdPerTraadArray og setter den like stor som moduloResten.
  midlAntOrdPerTraadArray = new String[moduloRest];

  // Leser inne de siste ordene i hovedfilen, og setter dem inn i midlAntOrdPerTraadArray.
    for(int k = 0; k<moduloRest; k++) {
      midlAntOrdPerTraadArray[k] = alleOrdFil[sisteTraadStartTall+k];
    }

    // Oppretter den siste traaden hvor den inneholder moduloRest-antall ord.
    Traad nyTraadRest = new Traad(moduloRest, nyMonitor);
    // Sender med inn arrayet over ordene til den siste traaden.
    nyTraadRest.setArrayPaaTraad(midlAntOrdPerTraadArray);

    // Legger til den siste tradden inn i alleTraaderArray.
    alleTraaderArray[antTraader-1]=nyTraadRest;

    // Her kaller vi paa start(); som kaller paa run()-metoden for alle traader.
    for(int j = 0; j<alleTraaderArray.length; j++) {
      new Thread(alleTraaderArray[j]).start();
    }

    // System.out.println(Arrays.toString(nyMonitor.getArrayList().get(0)));
    try {
      skrivUtTilFil(utFil, nyMonitor.getArrayList().get(0));
    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
    }
} // Avslutter main-klassen.

// Metode for aa lese inn fil.
public static void lesFil(String filnavn) throws Exception {

  Scanner in = new Scanner(new File(filnavn));
  String linje;

  linje = in.nextLine();
  antOrdFil = Integer.parseInt(linje);
  alleOrdFil = new String[antOrdFil];

  while(in.hasNextLine()) {
    linje = in.nextLine();

    alleOrdFil[arrayTeller] = linje;
    arrayTeller ++;
    ordTeller++;
  }
} // Avslutter lesFil-metoden.

/* Metoden for aa skrive ut til fil. Tar inn et filnavn som skal skrives ut til, og en String-array som skal skrives ut.
Denne blir kalt paa inne i run(). */
public static void skrivUtTilFil(String filnavn, String[] x) throws IOException  {
  BufferedWriter bw = new BufferedWriter(new FileWriter(filnavn));
  for(int i = 0; i< x.length; i++) {
    bw.write(x[i]);
    bw.newLine();
  }
  bw.flush();
  bw.close();
}

} // Avslutter Oblig9-klassen.

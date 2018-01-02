import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Oblig10 {

  static Brett aktBrett = null;
  static int rad, kolonne;

  public static void main(String[] args) {

  boolean iMeny = true;
  String filNavn = "";

  // Interaksjon med bruker.
  while(iMeny){
    System.out.println("\n\n\nHva vil du gjore? :) \n1. Les inn fil.\n2. Skriv ut fil.\n3. Los brettet.\n4. Vis antall mulige losninger for dette brettet.\n5. Skriv ut losninger. \n6. Avslutt.");

    Scanner input = new Scanner(System.in);
    int brukerInput = input.nextInt();

    if(brukerInput == 1) {
      System.out.println("Hvilken fil vil du lese i fra?");
      input.nextLine();
      filNavn = input.nextLine();
      try{
          lesFil(filNavn);
          System.out.println("\nVellykket: Lest inn fil\n");
          continue;
      } catch(Exception e) {
        System.out.println("Error: " + e.getMessage()+ "\n\n");
        continue;
      }
    } else if (brukerInput == 2) {
        skrivUtBrett(aktBrett.getRuteArray());
        continue;
    } else if (brukerInput == 3) {
          try {
            aktBrett.finnAlleLosning();
            System.out.println("Brettet er lost!");
          } catch (Exception e){
              System.out.println("Error: " + e.getMessage() + "\n\n");
            }
    } else if(brukerInput == 4) {
            System.out.println("Det finnes: " + aktBrett.getSudokuBeholder().hentAntallLosninger() + " losninger paa dette brettet.");
    } else if( brukerInput == 5) {
      int teller = 1;
      for(Rute[] r : aktBrett.getSudokuBeholder().taUt()) {
        System.out.println("Losning " + teller + ":");
        skrivUtBrett(r);
        teller++;
      }

    } else if (brukerInput == 6) {
                iMeny = false;
              }
  } // Avslutter iMeny.

  } // Avslutter main-klassen.

  // Metod for aa lese inn filen man skriver i terminalen.
  public static void lesFil(String filnavn) throws Exception {

    Scanner in = new Scanner(new File(filnavn));

    String linje;
    int verdi;
    rad = 0;
    kolonne = 0;
    boolean lestBrett = false;
    int aktRad = 0;
    int charTeller = 0;

    // While-lokke som leser inn hver linje.
    while(in.hasNext()) {
      linje = in.nextLine();

      if(!lestBrett) {

        // Sjekker om ikke det blir lagd et for stort brett.
        rad = HjelpeMetoder.tegnTilVerdi(linje.charAt(0));
        charTeller++;
        linje = in.nextLine();
        kolonne = HjelpeMetoder.tegnTilVerdi(linje.charAt(0));
        charTeller++;
        if((rad*kolonne <= 64)) {
          aktBrett = new Brett(rad, kolonne);
          lestBrett = true;
        } else {
          throw new IllegalArgumentException("Radnummeret eller kolonnenummeret er enten under 0 eller over 64.");
        }

      } else {

        for(int i=0; i<linje.length(); i++) {
          // Sjekker om tall er innenfor 0 til rad*kolonne.
          if(HjelpeMetoder.tegnTilVerdi(linje.charAt(i)) <= rad*kolonne && HjelpeMetoder.tegnTilVerdi(linje.charAt(i)) >= 0) {
            verdi = HjelpeMetoder.tegnTilVerdi(linje.charAt(i));
            if (verdi != 0) {
            // Oppretter ny rute og putter inn verdien.
            Rute nyRute = new Rute(linje.charAt(i), aktBrett, aktBrett.getRadArray(aktRad), aktBrett.getKolonneArray(i), aktBrett.regnBoksNR(rad, kolonne, aktRad, i), true);
            aktBrett.setRute(nyRute);
            } else {
              // Oppretter en ny rute og putter in tom verdi. Sjekk 2. konstruktor i klassen Rute.
              Rute nyRute2 = new Rute(aktBrett, aktBrett.getRadArray(aktRad), aktBrett.getKolonneArray(i), aktBrett.regnBoksNR(rad, kolonne, aktRad, i));
              aktBrett.setRute(nyRute2);
            }
            charTeller++;
          } else {
            throw new IllegalArgumentException("Tall utenfor lovlig intervall.");
          }

      }
      aktRad++;
    }

    } // Avslutter while-lokken

      // Sjekker om antall tall i filen stemmer eller ikke.
      if(charTeller != ((rad*kolonne)*(rad*kolonne)+2)) {
        System.out.println(charTeller);
        System.out.println(((rad*kolonne)*(rad*kolonne)+2));
        throw new IllegalArgumentException("Antall tall stemmer ikke.");
      }

  } // Avslutter metoden lesFil.

    // Metode som skriver ut brettet.
    public static void skrivUtBrett(Rute[] ruteArray) {
      int radIBoksTeller = rad;
      int kolonneIBoksTeller = kolonne;
      int lengde = rad*kolonne;
      int radTeller = lengde;

      // Lager fin ramme.
      System.out.println();
      for(int a = 0; a < lengde*kolonne + rad - 1; a++) {
        System.out.print("*");
      }
      System.out.println();

      for(int i = 0; i < (lengde*lengde); i++) {

        // Sjekker om den skal hoppe til neste linje;
        if(radTeller == 0){
          radTeller = lengde;
          System.out.println();
          radIBoksTeller--;
          kolonneIBoksTeller = kolonne;
        }

        // Markerer skille med en |, og resettere tellerne.
        if(kolonneIBoksTeller == 0) {
          System.out.print("|");
          kolonneIBoksTeller = kolonne;
        }

        // Markerer skille med ---, og resetter tellerne.
        if(radIBoksTeller == 0) {
          for(int a = 0; a < lengde*3 + rad - 1; a++) {
            System.out.print("-");
          }
          radIBoksTeller = rad;
          System.out.println();
        }

        // Skriver . hvis verdien er 0
        if(ruteArray[i].getVerdi() == 0) {
          System.out.print(" . ");
        } else if(ruteArray[i].getLock()){
          // Ellers skriver den verdien.
          System.out.print("(" + ruteArray[i].getVerdi() + ")");
        } else {
          System.out.print(" " + ruteArray[i].getVerdi() + " ");
        }

        // Minuserer variablene saa alt synkroniseres og priner ut riktig.
        kolonneIBoksTeller--;
        radTeller--;
      }
      // Printer ut fin enderamme.
      System.out.println();
      for(int a = 0; a < lengde*kolonne + rad - 1; a++) {
        System.out.print("*");
      }
      System.out.println("\n");

    }

    /* Denne har jeg valgt aa ikke ta med, fordi ut ifra tolkningen av oppgaven, saa
    hadde allerede programmet mitt det denne metoden ba om. Det meste skjer inne i Brett-klassen
    og naar vi leser inn filen. Fra Oblig8.
    public void opprettDataStruktur() {}  */
} // Avslutter Oblig10.

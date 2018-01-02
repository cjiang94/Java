// Importerer Scanner.
import java.util.Scanner;

// Oppgave 2.5: Lag metoder som regner ut hvor mye penger du tar ut eller setter inn i banken.
class MinOppgave2 {
  // Lar variablen penger vaere 5000 kroner.
  static int penger = 5000;

  // Lager 2 metoder som legger inn og tar ut penger.
  // Metode 1 - Legge inn penger.
  static void deposit(double beloep) {

    System.out.println ("Naa har du " + (penger + beloep) + " kroner i banken! :D");
  }
  //Metode 2 - Ta ut penger.
  static void withdraw(double beloep) {
    if (beloep > penger){
      System.out.println ("Du har dessverre naadd ditt maksimale uttak. Proev igjen.");
    }
    else{
      System.out.println ("Naa har du " + (penger - beloep) + " kroner i banken! :D");
    }

  }

  // Starter programmet mitt.
  public static void main (String [] args){
  // Definerer Scanner som in.
  Scanner in = new Scanner (System.in);

  // Interaksjon med bruker.
  System.out.println ("Hei, og velkommen til IFI-banken! Du har naa " + penger + "kroner i banken! Oensker du aa sette inn penger, eller ta ut penger? S/T");

  String svar = in.nextLine();
  if (svar.equalsIgnoreCase ("S")) {
    System.out.println ("Hvor mye vil du legge inn? :)");
    // Kaller til Metode 1.
    double leggInnPenger = in.nextInt();
    deposit (leggInnPenger);
  }
  else if (svar.equalsIgnoreCase ("T")) {
    System.out.println ("Hvor mye vil du ta ut? :)");
    // Kaller til Metode 2.
    double taUtPenger = in.nextInt();
    withdraw (taUtPenger);
  }
  else{
    System.out.println ("IFI-banken kunne ikke tyde meldingen din. Vennligst ta ut kortet, og proev igjen.");
  }

  }
}

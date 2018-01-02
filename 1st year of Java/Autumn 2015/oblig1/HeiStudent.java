import java.util.Scanner; // Dette importerer Scanner .

class HeiStudent {
  public static void main(String [] args){

// Oppgave 1.1 A
    System.out.println ("Hei Student!"); // Skriver ut "Hei Student!"


// Oppgave 1.1 B
    String navn = "Christin"; // Lager en variabel som heter "Christin".
    System.out.println ("Hei " + navn); // Skriver ut "Hei Christin".


// Oppgave 1.1 C
    Scanner in= new Scanner (System.in); // Definerer Scanner som "in"
    System.out.println ("Hva heter du? :)"); /* Spør om navn så brukeren
                                                vet de skal skrive navnet sitt*/
    String navn2 = in.nextLine();
    System.out.println ("Hello " + navn2); /* Printer ut Hello + navnet bruker

                                              skriver inn */

// Oppgave 1.1 D
    int heltall = 3; // Gir en konstant til variabelen heltall
    int heltall2 = 8; // Gir en konstant til variabelen heltall 2

    System.out.println ("Her faar du et random tall! :D " + (heltall + heltall2));


// Oppgave 1.1 E
    System.out.println ("Skriv inn et heltall.");
    int tall = Integer.parseInt(in.nextLine());

    System.out.println ("Skriv inn et annet heltall.");
    int tall2 = Integer.parseInt(in.nextLine());

    System.out.println ("Summen blir da " + (tall + tall2));

  }
}

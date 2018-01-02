import java.util.Scanner;  // Dette importerer Scanner.

class Billettpris {
  public static void main (String [] args) {

    System.out.println ("Hvor gammel er du? :)"); /* Et spørsmål blir stilt i
                                                     terminalen */

    Scanner in = new Scanner (System.in);
    int alder = in.nextInt ();

    if (alder<12 || alder>67){
      System.out.println ("Billetten koster 25,-");
    }
    else {
      System.out.println ("Billetten koster 50,-");
    }
  }
}

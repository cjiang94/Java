// Importerer Scanner.
import java.util.Scanner;

class EnkelKalkulator{
  // Lager tre forskjellige metoder.
  static void sum (int tall1, int tall2){
    System.out.println (tall1 + tall2);

  }
  static void differanse (int tall1, int tall2){
    System.out.println (tall1 - tall2);
  }
  static void produkt (int tall1, int tall2){
    System.out.println (tall1 * tall2);
  }


  public static void main (String [] args){
  // Definerer Scanner som "in".
  Scanner in = new Scanner (System.in);

  // Interaksjon med bruker
  System.out.println ("Tast inn et tall");
  int tall1 = in.nextInt();
  System.out.println ("Tast inn et annet tall");
  int tall2 = in.nextInt();

  // Regner ut summen ved aa hente metode sum.
  System.out.println ();
  System.out.println ("Summen av tallene blir: ");
  sum(tall1, tall2);

  // Regner ut differansen ved aa hente metode differanse.
  System.out.println ();
  System.out.println ("Differansen av tallene blir: ");
  differanse(tall1, tall2);

  // Regner ut produktet ved aa hente metode produkt.
  System.out.println ();
  System.out.println ("Produktet av tallene blir: ");
  produkt(tall1, tall2);

  }

}

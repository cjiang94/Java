import java.util.Scanner;

public class TestOppgave62 {
  public static void main (String[] args) throws Exception {
    Ordliste test1 = new Ordliste();
    test1.lesBok("scarlet.text");
    System.out.println("Det er " + test1.antallOrd() + " antall forskjellige ord i teksten.");

    System.out.println("Hvilket ord vil du lete etter?");
    Scanner in = new Scanner(System.in);
    System.out.println("Ja, ordet " + test1.finnOrd(in.nextLine()) + " finnes i teksten.\n");

    System.out.println("Hvilket ord vil du lete antall forekomster av?\n");
    System.out.println("Det er " + test1.antallForekomster(in.nextLine()) + " antall forekomster at ordet du sokte i teksten.\n");

    System.out.println("Det ordet som dukker opp flest ganger i teksten er: " + test1.vanligste() + "\n");


    System.out.println("De ordene som dukker opp flest ganger i teksten er: ");
    for(Ord hvertOrd : test1.alleVanligste()) {
      System.out.println(hvertOrd);
    }
  }
}

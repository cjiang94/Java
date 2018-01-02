// Lag et program hvor du har et virtuelt kjaeledyr og skal passe paa det ved aa bruke klasse, objekter, metoder og lokker.
//Importerer Scanner.
import java.util.Scanner;

// Lager en public class.
public class MinOppgave5{
  public static void main(String[] args){
    // Definerer Scanner som "in".
    Scanner in = new Scanner (System.in);
    // Lager boolske utrykk.
    boolean lever = true;
    boolean spiller = true;

    // Mens spiller = true, saa skal alt innen while-lokken loope.
    while (spiller){
    // Interaksjon med bruker.
    System.out.println ("Hei, og velkommen til Tamaguchi-verdenen! Har skal du ta vare paa et virtuelt kjaeledyr! Hva vil du kalle kjaeledyret ditt? :)");
    String navn = in.nextLine();

    // Interaksjon med bruker samtidig lager et objekt av klassen min Kjaeledyr.
    System.out.println ("\n\n\n\n");
    Kjaeledyr tamaguchi = new Kjaeledyr (navn);
    System.out.println ("Gratulerer med nytt kjaeledyr!\n" + navn + " er kjempeglad for aa mote deg! Det er en hunn og er en edderkopp!");

    // Setter lever = true for at man senere kan lage et nytt kjaeledyr.
    lever = true;
    // Lager en ny while-lokke hvor man kan gjore ting med kjaeledyret.
    while(lever){
    System.out.println ("Vekt " + tamaguchi.getKilo() + "kg. \nEnergi: " + tamaguchi.getEnergy() + ". \n ");
    System.out.println ("Hva vil du gjore med " + navn + "? \n 1. Mate henne? \n 2. Trene? \n 3. Hvile? \n 4. Drepe henne, fordi du er redd edderkopper? D:");
    int hvaVilBruker = in.nextInt();
    // Er her fordi java glitcher med "entertasten" naar man taster inn en int.
    in.nextLine();

    // Lager boolske-utrykk for som varierer paa hvilke valg brukeren tar.
    if (hvaVilBruker == 1) {
      System.out.println ("Hvor mange kg med mat vil du mate edderkoppen din med? :)");
      int hvorMyeMat = in.nextInt();
      // Er her fordi java glitcher med "entertasten" naar man taster inn en int.
      in.nextLine();
      // Setter boolean "lever" = false gjennom metoden, og kjaeledyret dor.
      lever = tamaguchi.Food(hvorMyeMat);
    }

    // Hvis bruker velger 2, henter vi metoden tamaguchi.Train().
    else if (hvaVilBruker == 2) {
      tamaguchi.Train();
    }

    // Hvis bruker velger 3, henter vi metoden tamaguchi.Rest().
    else if (hvaVilBruker == 3) {
      tamaguchi.Rest();
    }

    // Hvis bruker velger 4, setter vi lever = false, og kjaeledyret dor.
    else if (hvaVilBruker == 4) {
      lever = false;
    }

    // En else-setning som gir deg feilmelding om du skriver noe annet enn 1,2,3,4.
    else {
      System.out.println ("Kunne ikke tyde meldingen din. Prov igjen.\n\n\n\n\n");
    }
  }

    // Setter et boolske-utrykk = true, som skal sporre bruker om man vil lage et nytt kjaeledyr
    boolean sporIgjen = true;

    // Lager en while-lokke som looper og spor om du vil lage et nytt kjaeledyr.
    while (sporIgjen) {
    System.out.println("Du har dessverre drept " + tamaguchi.getName() +"! Vil du lage en ny? Y/N");
    String spillIgjen = in.nextLine ();

    // Lager et nytt kjaeledyr og spiller = true, som gjor at man lager et nytt kjaeledyr.
    if (spillIgjen.equalsIgnoreCase ("Y") ) {
      spiller = true;
      // Dette stopper sporIgjen-lokken og hopper ut av while-lokken.
      sporIgjen = false;
    }

    // Spiller og sporIgjen = false, gjor at hele spillet avsluttes.
    else if (spillIgjen.equalsIgnoreCase ("N")) {
      System.out.println ("Takk for spillet, og bedre lykke neste gang!)");
      spiller = false;
      sporIgjen = false;
    }

    // Hindrer at bruker kan skrive noe annet enn Y eller N.
    else  {
      System.out.println ("Kunne ikke tyde meldingen din. Prov igjen.");
    }
  }

  }
}
}

// Oppgave 3.4
// Lager en class kalt NegativeTall.
public class NegativeTall {
  public static void main (String [] args) {

    // Legger inn variabler for 9 indekser.
    int[] heltall = {1, 4, 5, -2, -4, 6, 10, 3, -2};

    // Printer ut tekst og setter teller = 0 og negTall = 0.
    System.out.println("Her er tallrekken: 1, 4, 5, -2, -4, 6, 10, 3, -2");
    int teller = 0;
    int negTall = 0;

    /* Lager en while-lokke som looper om teller er mindre enn 9.
       Legger deretter inn en if-setning som bare teller tall under 0. */
    while(teller < 9) {
      if (heltall[teller] < 0) {
        System.out.println("Dette er tallene som er under 0: " + heltall[teller]);
        // Dette er for oppgave 3.4B hvor jeg erstatter de negative tallene med array-plassen (altsaa tellerplassen). **
        heltall[teller] = teller;
        // Denne looper if-setningen min saa lenge jeg fortsatt har negative tall.
        negTall++;
      }

    // Denne looper while-setningen min saa lenge teller er under 9.
    teller++;
    }

    // Printer ut tekst og sier hvor mange negative tall det er.
    System.out.println("Det er til sammen " + negTall + " negative tall");

    // Her setter jeg teller paa 0 igjen.
    teller = 0;
    // Lager en while-lokke som printer ut hele listen saa lenge telleren er under heltall.length. (her: 9. Dette kommer fra antal indekser vi har).
    // ** Vi definerte tidligere at negative tall (heltall[teller]) = teller, saa naar while-lokken naa moter paa et negativt tall, vil det blir erstattet med indeksnr.
    while (teller < heltall.length){
      System.out.println (heltall[teller]);
      // Denne looper while-setningen helt til teller kommer til 8-ende plass. (Starter aa telle fra 0).
      teller++;
    }
  }
}

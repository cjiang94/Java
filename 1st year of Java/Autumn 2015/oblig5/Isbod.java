// Lager en klasse kalt isbod.
public class Isbod {
  // Lager en string array paa 10 indekser.
  private String jobbPlass[] = new String [10];
  // Setter telleAntallAnsatte til aa starta paa 0.
  private int telleAntallAnsatte = 0;

  // Lager en metode som tar inn en string parameter.
  public void ansett(String navn){
    // Hvis telleAntallAnsatte er mindre enn lengden paa arrayen, saa setter vi inn en ansatt.
    if (telleAntallAnsatte < jobbPlass.length){
     jobbPlass[telleAntallAnsatte] = navn;
     telleAntallAnsatte++;
     System.out.println ("Ansetter: " + navn);
   }
   // Hvis arrayen er full, saa kommer en feilmelding om at det er fullt.
    else {
     System.out.println ("Du har ikke nok kapasitet til aa ansette flere.");
   }

  }

  // Lager en metode som sparker sistemann.
  public void giSistemannSparken(){
    // Hvis telleAntallAnsatte er over 0, saa sparker vi en ansatt og minuserer telleAntallAnsatte med 1.
    if (telleAntallAnsatte > 0) {
    System.out.println (jobbPlass[telleAntallAnsatte-1] + " har dessverre faatt sparken. \n");
    telleAntallAnsatte--;
    }
    // Hvis det ikke er flere ansatte aa sparke, saa faar man en feilmelding.
    else {
      System.out.println ("Du har ikke flere ansatte aa sparke! Du har vaert en daarlig sjef :C");
    }
  }

  // Lager en metode som printer hvor mange ansatte man har.
  public void printAlleAnsatte(){
    // Printer liste og ansattnavn.
    for (int i = 0; i < telleAntallAnsatte; i++){
    System.out.println ("Plass " + (i+1) + " jobber: " + jobbPlass[i]);
    }
    System.out.println("");
  }

}

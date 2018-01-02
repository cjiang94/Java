public class TestOppgave61{
  public static void main(String[] args){

  Ord nyTekst = new Ord ("Aloe");
  nyTekst.oekAntall();
  System.out.println(nyTekst);
  System.out.println("Antallet av ordet er: " + nyTekst.hentAntall());

  Ord nyTekst2 = new Ord ("Vera");
  System.out.println(nyTekst2);
  System.out.println("Antallet av ordet er: " + nyTekst2.hentAntall());
  }
}

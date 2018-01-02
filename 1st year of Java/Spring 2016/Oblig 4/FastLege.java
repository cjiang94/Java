// Klassen Fastlege skal vare subklasse til klassen Lege, og samtidig implementere interfacet KommuneAvtale.
public class FastLege extends Lege implements KommuneAvtale {

  // Privat variabel som holder paa avtalenummeret.
  private int avtNr;

  // Naar vi opprettet en fastlege, saa skal disse vare med et legenavn og en avtalenummer.
  public FastLege(String legeNavn, int avtNr) {
    super(legeNavn);
    this.avtNr = avtNr;
  }

  // Egenlagd test for aa see om programmet fungerer.
  public void info(String navn) {
    System.out.println ("Legenavn: " + legeNavn);
    System.out.println ("Er legenavnene lik: " + samme(navn));
    System.out.println ("AvtNr: " + avtNr + ("\n\n"));

  }

  // Implementerer metoden som ligger i interfacet KommuneAvtale. Denne metoden returnerer da avtalenummeret.
  public int returnAvtaleNr(){
    return avtNr;
  }
}

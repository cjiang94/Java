// Klassen Fastlege skal vare subklasse til klassen Lege, og samtidig implementere interfacet KommuneAvtale.
public class FastLege extends Lege implements KommuneAvtale {

  // Privat variabel som holder paa avtalenummeret.
  private String avtNr;

  // Naar vi opprettet en fastlege, saa skal disse vare med et legenavn og en avtalenummer.
  public FastLege(String legeNavn, String avtNr) {
    super(legeNavn);
    this.avtNr = avtNr;
  }

  // Egenlagd test for aa see om programmet fungerer.
  public String info() {
    return "Legenavn: " + legeNavn + "\nAvtNr: " + avtNr + ".\n\n";

  }

  // Metode for aa skrive ut informasjon til fil.
  public String nyInfo() {
    return legeNavn + ", " + avtNr;
  }

  // Implementerer metoden som ligger i interfacet KommuneAvtale. Denne metoden returnerer da avtalenummeret.
  public String returnAvtaleNr(){
    return avtNr;
  }
}

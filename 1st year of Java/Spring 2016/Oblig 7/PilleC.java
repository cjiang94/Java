public class PilleC extends Legemiddel implements Piller {  // Subklasse til Legemiddel og samtidig implementerer interfacet Piller

  // Private variable som holder paa informasjon om legemiddelet.
  private int antall;
  private double virkestoff;
  private String form, type;

  // Konstruktoren til klassen som tar inn ulike parametere.
  public PilleC(String navn, String form, String type, double pris, int antall, double virkestoff) {
    super(navn, pris);
    this.form = form;
    this.type = type;
    this.antall = antall;
    this.virkestoff = virkestoff;
  }

  // Metode som skal returnere antall piller i esken, hentet fra interfacet Piller.
  public int returnPiller() {
    return antall;
  }

  // Metode som skal returnere doseringen til en pille, hentet fra interfacet Piller.
  public double returnDosering() {
    return virkestoff;
  }

  // Egenlagd metode for aa sjekke om programmet kjorer riktig.
  public String info() {
    return "Legemiddelnummer: " + nummer + ".\nNavn: " + navn + ".\nForm: " + form +
    ".\nType: " + type + ".\nPris: " + pris + ",-.\nAntall: " + antall +
    "ml.\nVirkestoff: " + virkestoff + ".\n";
  }

  public String nyInfo() {
    return (nummer + ", " + navn + ", " + form + ", " + type + ", " + pris + ", " + antall + ", " + virkestoff);
  }
}

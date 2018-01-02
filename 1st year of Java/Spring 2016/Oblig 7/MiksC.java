public class MiksC extends Legemiddel implements Mikstur {  // Subklasse til Legemiddel og samtidig implementerer interfacet Mikstur

  private int mengde;
  private double virkestoff;
  private String form, type;

  // Konstruktoren til klassen som tar inn ulike parametere.
  public MiksC(String navn, String form, String type, double pris, int mengde, double virkestoff) {
    super(navn, pris);
    this.form = form;
    this.type = type;
    this.mengde = mengde;
    this.virkestoff = virkestoff;

  }

  // Metoden som skal returnere cm3 til miksturA, hentet fra interfacet Mikstur.
  public int returncm3() {
    return mengde;
  }

  // Metoden som skal returnere doseringen til miksturA, fra interfacet Mikstur.
  public double returnDosering() {
    return virkestoff;
  }

  // Egenlagd metode som skal sjekke om programmet fungerer.
  public String info() {
    return "Legemiddelnummer: " + nummer + ".\nNavn: " + navn + ".\nForm: " + form + "\nType: " + type +
    ".\nPris: " + pris + ",-.\nMengde: " + mengde + "ml.\nVirkestoff: " + virkestoff + ".\n";
  }

  public String nyInfo() {
    return nummer + ", " + navn + ", " + form + ", " + type + ", " + pris + ", " + mengde + ", " + virkestoff;

  }
}

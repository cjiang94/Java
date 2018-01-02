public class MiksB extends Legemiddel implements Mikstur {  // Subklasse til Legemiddel og samtidig implementerer interfacet Mikstur

  // Private variable som holder paa informasjon om legemiddelet.
  private int vanedannede;
  private int cm3;
  private double dose;

// Konstruktoren til klassen som tar inn ulike parametere.
  public MiksB(String navn, double pris, int vanedannede, int cm3, double dose) {
    super(navn, pris);
    this.vanedannede = vanedannede;
    this.cm3 = cm3;
    this.dose = dose;
  }

  // Metoden som skal returnere cm3 til miksturB, hentet fra interfacet Mikstur.
  public int returncm3() {
    return cm3;
  }

  // Metoden som skal returnere doseringen til miksturB, fra interfacet Mikstur.
  public double returnDosering() {
    return dose;
  }

  // Egenlagd metode som skal sjekke om programmet fungerer.
  public void info() {
    System.out.print("Navn: " + navn + ".\n");
    System.out.print("Legemiddelnr: " + nummer + ".\n");
    System.out.print("Pris: " + pris + ",-.\n");
    System.out.print("Vanedannede: " + vanedannede + ".\n");
    System.out.print("Cm3: " + returncm3() + "ml.\n");
    System.out.print("Virkestoff: " + returnDosering() + ".\n\n");

  }
}

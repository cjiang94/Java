public class PilleC extends Legemiddel implements Piller {  // Subklasse til Legemiddel og samtidig implementerer interfacet Piller

  // Private variable som holder paa informasjon om legemiddelet.
  private int antPiller;
  private double dose;

  // Konstruktoren til klassen som tar inn ulike parametere.
  public PilleC(String navn, double pris, int antPiller, double dose ){
    super(navn, pris);
    this.antPiller = antPiller;
    this.dose = dose;
  }

  // Metode som skal returnere antall piller i esken, hentet fra interfacet Piller.
  public int returnPiller() {
    return antPiller;
  }

  // Metode som skal returnere doseringen til en pille, hentet fra interfacet Piller.
  public double returnDosering() {
    return dose;
  }

  // Egenlagd metode for aa sjekke om programmet kjorer riktig.
  public void info() {
    System.out.print("Navn: " + navn + ".\n");
    System.out.print("Legemiddelnr: " + nummer + ".\n");
    System.out.print("Pris: " + pris + ",-.\n");
    System.out.print("Antall piller: " + returnPiller() + " stk.\n");
    System.out.print("Virkestoff: " + returnDosering() + ".\n\n");

  }

}

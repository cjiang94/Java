public class ELBil extends Bil{ // Subklasse av superklassen Bil.

  // privat variabel som holder paa int kilowatt.
  private int kW;

  // Konstruktoren til klassen ELBil.
  public ELBil(String regNr, int kW){
    super(regNr);
    this.kW = kW;
  }

  // En toString metode som returnerer en String som sier regNr og kW til bilen. regNr hentes fra superklassen Bil.
  public String toString() {
    return "\n\nEL-Bilen har registreringsnummer: " + regNr + "\nkW til EL-bilen er: " + kW;
  }
}

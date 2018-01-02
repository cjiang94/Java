public class PersonBil extends FossilBil{ // Subklasse av klassen Fossilbil.

  // en private variabel som holder paa en int av antall passasjerer.
  private int passasjerer;

  // Konstruktoren til Personbil.
  public PersonBil(String regNr, double utslipp, int passasjerer){
    super(regNr, utslipp);
    this.passasjerer = passasjerer;
  }

  // En toString som returnerer en String som sier regNr, utslippet og antall passasjerer paa bilen. regNr og utslipp hentes fra superklassen FossilBil (regNr fra superklassen til Fossilbil -> Bil)
  public String toString() {
    return "\n\nPersonbilen har registreringsnummer: " + regNr + "\nUtslipp : " + utslipp + " og har antall passasjerer: " + passasjerer;
  }
}

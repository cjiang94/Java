public class FossilBil extends Bil{ // Sobklasse av klassen Bil.

  // en protected variabel saa subklasser som lastebil og personbil kan lese variabelen, og holder paa utslippet til hver bil.
  protected double utslipp;

  // Konstruktoren til klassen FossilBil.
  public FossilBil(String regNr, double utslipp){
    super(regNr);
    this.utslipp = utslipp;
  }

  // En toString-metode som returnerer en String som sier regNr og utslippet til Fossilbilen. regNr hentes fra superklassen.
  public String toString() {
    return "\n\nFossilbilen har registreringsnummer " + regNr+ "\nog har som utslipp " + utslipp;
  }
}

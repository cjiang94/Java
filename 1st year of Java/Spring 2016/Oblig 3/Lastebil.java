public class Lastebil extends FossilBil{  // Subklasse av klassen Fossilbil.

  // En private variabel som holder paa double nyttevektne til lastebil.
  private double nyttevekt;

  // Konstruktoren til klassen Lastebil.
  public Lastebil(String regNr, double utslipp, double nyttevekt){
    super(regNr, utslipp);
    this.nyttevekt = nyttevekt;
  }

  // En toString-metode som returnerer en String som sier regNr til bilen, utslippet og nyttevekten. regNr og utslippet hentes fra superklassen FossilBil, (regNr fra klassen Bil).
  public String toString() {
    return "\n\nRegistreringsnummeret til lastebilen er: " + regNr + "\nUtslippet er: "+ utslipp + " og nyttevekten er: " + nyttevekt;
  }
}

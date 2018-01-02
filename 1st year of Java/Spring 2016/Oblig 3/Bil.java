public class Bil{

  // Lager en protected variabel av regNr, som subklasser kan lese.
  protected String regNr;

  // Konstruktoren til klassen Bil.
  public Bil(String regNr) {
    this.regNr = regNr;
  }

  // En toString metode som returnerer en String av regNr.
  public String toString() {
    return "\n\nDenne bilen har registreringnummer: " + regNr;
  }
}

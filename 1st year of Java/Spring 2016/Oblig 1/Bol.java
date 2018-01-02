public class Bol<T> {

  // Setter private varible som skal endres etterhvert som programmet gaar.
  private T resident = null;
  private boolean empty = true;

  /* Metode som skal flytte et nytt individ inn i et bol. Og setter private boolean empty = false.
    Hvis det allerede bor noen i bolet, saa skjer ingenting. */
  public boolean setResident(T resident) {
    if (this.resident == null) {
      this.resident = resident;
      empty = false;
      return true;

    }
    else {
      return false;
    }
  }

  // Metode som skal returnere individet som bor inne i bolet.
  public T getResident() {
    return resident;
  }

  // Metode som sjekker om det bor noen i bolet ved aa returnere boolean empty.
  public boolean isEmpty() {
    return empty; // returnerer true hvis bolet er tomt
  }
}

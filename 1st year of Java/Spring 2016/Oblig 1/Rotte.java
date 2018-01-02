public class Rotte {

  // Private variable som skal holde paa navnet ditt rotte, og boolean om den er skadet eller dod.
  private String ratName;
  private boolean alive = true;
  private boolean hurt = false;

  // Konstruktoren til Rotte.
  public Rotte (String name) {
    ratName = name;
  }

  // Metode som brukes naar en rotte blir angrepet. Metoden forandrer boolean-ene alive og hurt etter hvilken stadie rotten er i.
  public void ratAttack() {
    if (!hurt) {
      hurt = true;
      System.out.println ("The rat went from being healthy to being hurt.");
    }
    else {
      alive = false;
      System.out.println ("The rat went from being hurt to being dead.");
    }
  }

  // Metode som sjekker om rotten er i livet ved aa returnere boolean alive.
  public boolean isAlive() {
    return alive;
  }

  // Metode som returnerer navnet til rotten.
  public String toString() {
    return ratName;
  }
}

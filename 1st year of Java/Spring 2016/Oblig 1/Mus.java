public class Mus {

  // Private variable som holder paa musenavn og om den er i livet.
  private String mouseName;
  private boolean alive = true;

  // Konstruktoren for klassen Mus.
  public Mus (String name) {
    mouseName = name;
  }

  // Metode som brukes naar Mus blir angrepet, og forandrer boolean alive til false.
  public void mouseAttack() {
    if (alive) {
      alive = false;
      System.out.println ("The mouse " + mouseName + " was killed.");
    } else {
      System.out.println ("The mouse " + mouseName + " is already dead.");
    }
  }


  // Metode for aa sjekke om musen er i livet ved aa returnere boolean alive.
  public boolean isAlive() {
    return alive;
  }

  // Metode for aa returnere navnet til musen.
  public String toString() {
    return mouseName;
  }
}

class Katt {

  /* Private variable som holder paa et kattenavn, ulike bol for ulike type objekter
  og boolean for om det var vellykket drap paa mus/rotte. */
  private String catName;
  private Bol<Mus> mouseHouse;
  private Bol<Rotte> ratHouse;
  private boolean successKillMouse;
  private boolean successKillRat;

  // Konstruktor for aa lage et nytt Katt-objekt.
  public Katt (String name) {
    catName = name;
  }

  /* Metode som sender katten paa jakt.
    Katten vil forst sjekke om det finnes mus i musebolet, hvis ikke gaar den videre til rottebolet.
    Finner katten ingenting, saa skjer ingenting. */
  public void catHunt(Bol<Mus> mouseHouse, Bol<Rotte> ratHouse) {
    this.mouseHouse = mouseHouse;
    this.ratHouse = ratHouse;

    if (!mouseHouse.isEmpty() && mouseHouse.getResident().isAlive()) {
      successKillMouse = true;
      successKillRat = false;
      hunt(mouseHouse, ratHouse);
    }
    else if (!ratHouse.isEmpty() && ratHouse.getResident().isAlive()) {
      successKillMouse = false;
      successKillRat = true;
      hunt(mouseHouse, ratHouse);
    }
    else {
      successKillMouse = false;
      successKillRat = false;
      hunt(mouseHouse, ratHouse);
    }

  }

  // Metode som returnerer navnet til katten.
  public String toString() {
    return catName;
  }

  // Metode som skriver ut tekst hvis katten har funnet enten en mus eller rotte, og angriper den.
  public void hunt(Bol<Mus> mouseHouse, Bol<Rotte> ratHouse){

  if (successKillMouse) {
    System.out.println ("The cat " + catName + " attacked the mouse " + mouseHouse.getResident().toString());
    mouseHouse.getResident().mouseAttack();
  }
  else if (successKillRat) {
    System.out.println ("The cat " + catName + " attacked the rat " + ratHouse.getResident().toString());
    ratHouse.getResident().ratAttack();
  }
  else {
    System.out.println (catName + " did not find anything to hunt. The hunt is over.");
  }
}

} // quits class.

public class Oblig1 {
  public static void main(String [] args) {

    // Her oppretter vi to typer bol av typen Mus og Rotte.
    Bol<Mus> mouseHouse = new Bol<Mus>();
    Bol<Rotte> ratHouse = new Bol<Rotte>();

    // Oppretter en ny katt "Kattus" av typen Katt.
    Katt myCat = new Katt("Kattus");

    // Sender katten paa jakt.
    myCat.catHunt(mouseHouse, ratHouse);

    // Oppretter en ny rotte "Rottus" av type Rotte.
    Rotte myRat = new Rotte("Rottus");
    // Vi flytter Rottus inn i et nytt bol.
    if (ratHouse.setResident(myRat)) {
      System.out.println ("The rat " + myRat.toString() + " now has a new home!");
    }
    // Hvis bolet allerede har en rotte, saa vil ikke Rottus kunne flytte inn.
    else {
      System.out.println ("This house is already taken.");
    }

    // Vi sender Kattus paa jakt igjen.
    myCat.catHunt(mouseHouse, ratHouse);

    // Oppretter en ny mus "Musus" av typen Mus.
    Mus myMouse = new Mus ("Musus");
    // Vi flytter Musus inn i et nytt bol.
    if (mouseHouse.setResident(myMouse)) {
      System.out.println ("The mouse " + myMouse.toString() + " now has a new home!");
    }
    // Hvis bolet allerede er tatt, flyttes ikke Musus inn.
    else {
      System.out.println ("This house is already taken.");
    }

    // Oppretter en ny mus "Musur" av typen Mus.
    Mus myMouse2 = new Mus ("Musur");
    // Vi prover aa flytte Musur inn i bolet til Musus.
    if (mouseHouse.setResident(myMouse)) {
      System.out.println ("The mouse " + myMouse.toString() + " now has a new home!");
    }
    // Vi faar melding om at bolet allerede er tatt (det er Musur som bor der fra for av).
    else {
      System.out.println ("This house is already taken.");
    }

    // Vi sender katten paa jakt igjen, hvor den dreper Musus.
    myCat.catHunt(mouseHouse, ratHouse);
}
}

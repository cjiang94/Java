import java.util.Iterator;  // Importer iterator.
import java.lang.Iterable;

public class TestSortertEnkelListe {
  public static void main(String []args) {

    // Oppretter en ny liste som skal bestaa av Lege-objekter.
    SortertEnkelListe<Lege> nyListe = new SortertEnkelListe<Lege>();

    // Oppretter diverse nye lege-objekter.
    Lege lege1 = new Lege ("Thomas");
    Lege lege2 = new Lege ("Harald");
    Lege lege3 = new Lege ("Mikke");
    Lege lege4 = new Lege ("Minnie");

    // Legger lege-objektene inn i listen.
    nyListe.settInnMinsteForan(lege1);
    nyListe.settInnMinsteForan(lege2);
    nyListe.settInnMinsteForan(lege3);
    nyListe.settInnMinsteForan(lege4);

    // Oppretter en iterator paa listen.
    Iterator<Lege> iter = nyListe.iterator();

    // lokke som kjorer gjennom listen og skriver ut legens navn.
    while(iter.hasNext()) {
      System.out.println (iter.next().toString());
    }

  }
}

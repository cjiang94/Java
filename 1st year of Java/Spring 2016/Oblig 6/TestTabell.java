import java.util.Iterator;  // Importerer iterator.
import java.lang.Iterable;

public class TestTabell{
  public static void main (String []args) {

    // Oppretter ulike pasient-objekter.
    Pasient p1 = new Pasient ("Bjorn", 123456789, "Gate 1", 1111);
    Pasient p2 = new Pasient ("Tor", 55556789, "Gate 2", 1112);
    Pasient p3 = new Pasient ("Arne", 223456789, "Gate 3", 1113);

    // Oppretter et nytt array-tabell av Pasienter, hvor arrayet har storrelse 4.
    Tabell<Pasient> beholder = new Tabell<Pasient> (4);

    // Setter inn pasientene i arrayet.
    beholder.settInn(p1, 0);
    beholder.settInn(p2, 1);
    beholder.settInn(p3, 2);

    // Oppretter en ny iterator for arrayet.
    Iterator iter = beholder.iterator();

    // En while-lokke som skriver ut pasientenes navn.
    while (iter.hasNext()) {
      System.out.println(iter.next().toString());
    }

  }
}

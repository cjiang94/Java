import java.util.Iterator;  // Importerer iterator.
import java.lang.Iterable;

public class TestEldsteForstReseptListe {
  public static void main (String []args) {

      // Oppretter diverse lege-objekter.
      Resept r1 = new Resept(null, "Lege1", "Pasient 1", 3, "blaa");
      Resept r2 = new Resept(null, "Lege2", "Pasient 1", 5, "hvit");
      Resept r3 = new Resept(null, "Lege3", "Pasient 1", 1, "blaa");

      // Oppretter en ny liste.
      EldsteForstReseptListe liste = new EldsteForstReseptListe();

      // Legger lege-objektene inn i listen.
      liste.leggTil(r1);
      liste.leggTil(r2);
      liste.leggTil(r3);

      // Oppretter en ny iterator paa listen.
      Iterator iter = liste.iterator();

      // En while-lokke som skal skrive ut legens navn til resepten.
      while (iter.hasNext()) {
        Resept p = (Resept) iter.next();
        System.out.println (p.legeToString());

      }

    }

  }

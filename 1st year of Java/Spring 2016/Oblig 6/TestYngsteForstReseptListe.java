import java.util.Iterator;  // Importerer iterator.
import java.lang.Iterable;

public class TestYngsteForstReseptListe {
  public static void main (String []args) {

    // Oppretter 3 ulike resepter. Har ikke opprettet legemiddel, men brukte null.
    Resept r1 = new Resept(null, "Lege1", "Pasient 1", 3, "blaa");
    Resept r2 = new Resept(null, "Lege2", "Pasient 1", 5, "hvit");
    Resept r3 = new Resept(null, "Lege3", "Pasient 1", 1, "blaa");

    // Oppretter en pasient.
    Pasient p1 = new Pasient ("Pasient 1", 123456789, "Gate 1", 1111);

    // Oppretter en ny liste.
    YngsteForstReseptListe test = new YngsteForstReseptListe();

    // Legger reseptene inn i listen vår.
    test.leggTil(r1);
    test.leggTil(r2);
    test.leggTil(r3);

    // Oppretter en ny iterator.
    Iterator iter = test.iterator();

    // En while-lokke som skal loope gjennom og skrive ut.
    while (iter.hasNext()) {
      Resept p = (Resept) iter.next();
      System.out.println(p.legeToString());
    }

  }

}

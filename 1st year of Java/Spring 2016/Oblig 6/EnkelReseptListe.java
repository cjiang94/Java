import java.util.Iterator;  // Importerer iterator.
import java.lang.Iterable;

public abstract class EnkelReseptListe {  // Har abstrakt klasse, fordi vi har en abstrakt metode "leggTil".

  // Protected class, fordi denne klassen brukes i subklassene EldsteForstReseptListe og YngsteForstReseptListe.
  protected class Node {
    Resept data;
    Node neste = null;

    // Konstruktoren til den protectede klassen.
    public Node(Resept e) {
      data = e;
    }
  }

  // Diverse variable og pekere.
  Node foran = null;
  Node siste = null;

  // En abstrakt metode som skal senere brukes i subklassene EldsteForstReseptListe og YngsteForstReseptListe.
  public abstract void leggTil(Resept e);

  /*  En metode som skal returnere en resept hvis vi finner den i lenken via parameteren reseptNR.
      Hvis vi ikke finner resepten, skal den throw Exception og gi oss en feilmelding.
      (Litt usikker paa om dette fungerer riktig, men den kompilerte uten problem. Ville vaert greit med
      tilbakemelding paa denne metoden!)*/
  public Resept finnResept(int reseptNR) throws Exception {
    Node denne = foran;
  try{
    while(denne != null) {
      if(denne.data.toNR() == reseptNR) {
        return denne.data;
      }
      denne = denne.neste;
    }
  } catch(Exception e){
      System.out.println ("Throws Exception: Kunne ikke finne resepten.");
    }
    return null;
  }

  // Metode som returnerer iterator.
  public Iterator iterator() {
    return new MinIterator();
  }

  // Protected klasse for iterator, fordi den brukes i subklassene.
  protected class MinIterator implements Iterator {
    Node denne = foran;

    // Metode for aa sjekke om det finnes en neste node i lokken.
    public boolean hasNext() {
      return denne != null;
    }

    // Metode som sender iteratoren en node videre, og returnerer forrige nodes data.
    public Resept next() {
      Node temp = denne;
      denne = denne.neste;
      return temp.data;
    }

    // Metode som skal fjerne en node. (Brukes ikke)
    public void remove() {

    }

  }
}

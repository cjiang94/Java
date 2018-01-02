import java.util.Iterator;  // Importerer iterator.
import java.lang.Iterable;

public class Tabell<E> implements AbstraktTabell<E>{  // Klassen implementerer grensesnittet AbstraktTabell.

  // Deklarerer en array.
  private E[] array;

  // Konstruktoren til klassen Tabell.
  public Tabell(int storrelse) {
    array = (E[]) new Object[storrelse];
  }

  // Metode som setter inn et nytt objekt til en bestemt indeks. Returnerer boolean om vellykket eller ikke.
  public boolean settInn(E e, int indeks) {
    if(indeks<0 || indeks>array.length || array[indeks]!=null) {
      return false;
      }
    array[indeks] = e;
    return true;
  }

  // Metode som returnerer objektet paa indeksen vi sender inn som parameter indeks.
  public E finnObjekt(int indeks) {
    return array[indeks];
  }

  // Metode som returnerer en iterator.
  public Iterator iterator() {
    return new MinIterator();
  }

  // Privat klasse for iterator.
  private class MinIterator implements Iterator<E> {
    int i = 0;

    // Metode for aa sjekke om det finnes et neste objekt i arrayet.
    public boolean hasNext() {
      return array[i] != null;
    }

    // Metode som sender iteratoren en indeks videre, og returnerer forrige array-indeks sin data.
    public E next() {
      int temp = i;
      i++;
      return array[temp];
    }

    // Metode som skal fjerne en indeks sin data (Brukes ikke).
    public void remove() {

    }
  }

}

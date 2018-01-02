import java.util.Iterator;  // Importerer iterator.
import java.lang.Iterable;

// Grensesnitt-klassen som brukes av SortertEnkelListe.
public interface AbstraktSortertEnkelListe<E extends Comparable <E> & Lik> {

  // Metodene som skal brukes av klassen SortertEnkelListe.
  public void settInnMinsteForan(E e);

  public E finn(String s);

  public Iterator<E> iterator();

}

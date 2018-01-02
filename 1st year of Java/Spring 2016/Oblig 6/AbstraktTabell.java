import java.util.Iterator;  // importerer iterator (ikke sikkert det trengs aa brukes her, siden det er interface og ikke klasse)
import java.lang.Iterable;

// Grensesnitt-klassen som brukes av Tabell.
public interface AbstraktTabell<E>{

  // Metodene som skal brukes i klassen Tabell.
  public boolean settInn(E e, int indeks);

  public E finnObjekt(int indeks);

  public Iterator iterator();
}

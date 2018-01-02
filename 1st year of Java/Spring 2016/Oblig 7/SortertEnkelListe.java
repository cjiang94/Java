import java.util.Iterator;  // Importerer iterator.
import java.lang.Iterable;

public class SortertEnkelListe<E extends Comparable <E> & Lik> implements AbstraktSortertEnkelListe<E>, Iterable {

  // Privat klasse som oppretter objekter av type Node.
  private class Node{
    E data;
    Node neste = null;
    // Konstruktoren til klassen Node.
    public Node(E data){
      this.data = data;
    }
  }

  // Private variable som fungerer som pekere.
  private Node listeHode = null;
  private Node neste = null;

  // Metode som setter inn det minste elementet foran i listen.
  public void settInnMinsteForan(E data) {

    // Oppretter en ny temporary Node.
    Node temp = new Node(data);

    // Gaar inn i denne if-setningen om vi er ved starten av en helt ny lokke.
    if(listeHode == null) {
      listeHode = temp;
      return;
    }

    // Opprettere en node "denne" som skal "lese" seg gjennom lenken.
    Node denne = listeHode;

    // En if-setning som skal sette et objekt foran listeHode, hvis listeHode er storre enn det nye objektet vi setter inn.
    if(listeHode.data.compareTo(temp.data) > 0) {
      temp.neste = listeHode;
      listeHode = temp;
      return;
    }

    /* En while-lokke som kjorer gjennom hele lenken saa lenge det finnes et neste objekt.
      Vi setter bare inn det nye objektet om den finner et annet objekt storre enn seg selv,
      hvis ikke saa settes det nye objektet helt forrerst. */
    while(denne.neste != null) {
      if(denne.neste.data.compareTo(temp.data) > 0) {
        temp.neste = denne.neste;
        denne.neste = temp;
        return;
      }
      denne = denne.neste;
    }
    denne.neste = temp;

  }

  // Metode som skal finne og returnere dataen til en node vi soker med en parameter s.
  public E finn(String s) {
  Node denne = listeHode;
  while(denne != null) {
    if(denne.data.samme(s)) {
      return denne.data;
    }
    denne = denne.neste;
  }
  return null;
  }

  // metode som returnerer iterator.
  public Iterator<E> iterator() {
    return new MinIterator();
  }

  // Privat klasse for iterator.
  private class MinIterator implements Iterator<E> {
    private Node denne = listeHode;

    // Metode for aa sjekke om det finnes en neste node i lokken.
    public boolean hasNext() {
      return denne != null;
    }

    // Metode som sender iteratoren en node videre, og returnerer forrige nodes data.
    public E next() {
      Node temp = denne;
      denne = denne.neste;
      return temp.data;
    }

    // Metode som skal fjerne en node. (Brukes ikke)
    public void remove() {

    }

  }
}

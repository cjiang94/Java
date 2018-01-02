public class LenkeListe< E extends Comparable <E> > {   // Lager en Lenkeliste som skal vare generisk Comparable.

  private class Node implements Comparable <Node> { // Gjor slik at jeg comparer Noder istedenfor innholdet i noden.
    public int compareTo(Node n) {
      return data.compareTo(n.data);
    }

    // Diverse variable for den indre klassen Node.
    E data;
    Node neste = null;

    public Node (E s){   // Indre klassen Node.
      data = s;
    }
  }

  // Oppretter en Node kalt foran, og setter den til aa peke paa null;
  private Node foran = null;

  // Metode for aa sjekke om lenken/beholderen er tom.
  public boolean tom() {
    if (foran == null) {
      return true;
    }
    return false;
  }

  // Metode for aa lage en ny node, men innhold av type e.
  public void leggTil(E e) {
    Node temp = new Node(e);
    temp.neste = foran;
    foran = temp;
  }

  /* Finner den noden som har innholdet med minst verdi, og fjerner den fra lenken ved aa
    lenke forrigeNode, med denne.neste */
  public E fjernMinste() {
   Node minste = foran;
   Node denne = foran.neste;
   Node forrigeNode = foran;
   Node forrigeTeller = foran;

   // Gaar bare inn i while-lokken om vi ikke er ved enden av lenken.
   while (denne != null) {
   if (minste.compareTo(denne) >= 0) {
     minste = denne;
     forrigeNode = forrigeTeller;
   }
   denne = denne.neste;
   forrigeTeller = forrigeTeller.neste;
  }
    if (forrigeNode == foran) {
      foran = forrigeNode.neste;
      } else {
        forrigeNode.neste = minste.neste;
        }
  return minste.data;


  }

  // Sjekker om lenken inneholder det vi sender inn som parameter e.
  public boolean inneholder (E e) {
    Node denne = foran;
    while (denne.neste != null) {
      if (e.compareTo(denne.data) == 0) {
        return true;
      }
      denne = denne.neste;
    }
    return false;
  }

  // Metode som skriver ut alt i lenken.
  public void skrivUtAlle() {
    Node denne = foran;
    while (denne != null) {
      System.out.println (denne.data);
      denne = denne.neste;
    }
  }

}

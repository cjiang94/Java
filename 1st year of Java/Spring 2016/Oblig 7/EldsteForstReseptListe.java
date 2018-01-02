public class EldsteForstReseptListe extends EnkelReseptListe {  // Subklasse av EnkelReseptListe.

  // Metode for aa legge til en ny resept til lenken.
  public void leggTil(Resept e) {

    Node temp = new Node(e);
    Node denne = foran;

    if(foran == null) {
      foran = temp;
      siste = temp;
      return;
    }
    while(denne.neste != null) {
      denne = denne.neste;
    }
    denne.neste = temp;
    siste = temp;
  }
}

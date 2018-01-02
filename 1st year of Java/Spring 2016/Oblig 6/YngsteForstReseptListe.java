public class YngsteForstReseptListe extends EnkelReseptListe {  // Subklasse av EnkelReseptListe.

  //  Metode som skal legge til et nytt objekt til lenken.
  public void leggTil(Resept e) {

    Node temp = new Node(e);

    if(foran == null) {
      foran = temp;
      siste = temp;
      return;
    }

    temp.neste = foran;
    foran = temp;
  }
}

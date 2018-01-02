// Klassen Lege implementerer interfacet Lik.
public class Lege implements Lik, Comparable<Lege> {

  // En protected variabel som tar vare paa legenavnet.
  protected String legeNavn;
  protected EldsteForstReseptListe eldsteListe = new EldsteForstReseptListe();

  // Opprettet en ny lege.
  public Lege(String legeNavn){
  this.legeNavn = legeNavn;

  }

  // Sjekker om navnet vi sender inn tilsvarer navnet da vi opprettet en ny lege.
  public boolean samme(String sjekkNavn) {
    if(legeNavn.equals(sjekkNavn)){
      return true;
    }
    return false;
  }

  // Returnerer legenavnet.
  public String info() {
  return "Legenavn: " + legeNavn + ".\n\n";
  }

  // metode for aa skrive ut til fil.
  public String nyInfo() {
    return legeNavn + ", " + 0;
  }

  // Metode som returnerer legenavnet.
  public String toString() {
    return legeNavn;
  }

  public void nyResept(Resept r) {
    eldsteListe.leggTil(r);
  }

  // Metode som skal returnere listen EldsteForstReseptListe.
  public EldsteForstReseptListe returnEldsteListe() {
    return eldsteListe;
  }

  // en CompareTo-metode som skal sammenligne legenavnene.
  public int compareTo (Lege legen) {
    return this.legeNavn.compareTo(legen.legeNavn);
  }
}

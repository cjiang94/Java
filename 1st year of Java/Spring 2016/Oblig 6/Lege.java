// Klassen Lege implementerer interfacet Lik.
public class Lege implements Lik, Comparable<Lege> {

  // En protected variabel som tar vare paa legenavnet.
  protected String legeNavn;
  protected EldsteForstReseptListe eldsteListe;

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
  public void info() {
  System.out.println ("Legenavn: " + legeNavn);
  }

  // Metode som returnerer legenavnet.
  public String toString() {
    return legeNavn;
  }

  // Metode som skal returnere listen EldsteForstReseptListe.
  public EldsteForstReseptListe toListe() {
    return eldsteListe;
  }

  // en CompareTo-metode som skal sammenligne legenavnene.
  public int compareTo (Lege legen) {
    return this.legeNavn.compareTo(legen.legeNavn);
  }
}

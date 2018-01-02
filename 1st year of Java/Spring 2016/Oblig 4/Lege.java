// Klassen Lege implementerer interfacet Lik.
public class Lege implements Comparable<E>, Lik {

  // En protected variabel som tar vare paa legenavnet.
  protected String legeNavn;

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

  public String toString() {
    return legeNavn;
  }

  public int compareTo (Lege legen) {
    return this.legeNavn.compareTo(legen.legeNavn);
  }
}

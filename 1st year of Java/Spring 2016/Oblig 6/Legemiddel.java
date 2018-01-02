/* Opprettet en abstract klasse Legemiddel, siden vi ikke direkte lager et objekt av typen Legemiddel, og lar det staa som superklassen
  til subklassesn PillA, PilleB, PilleC, MiksA, MiksB og MiksC. */
public abstract class Legemiddel {

  /* Lager protected variable som holder paa verdier. Samtidig lager en private static teller som skal telle i
    bakgrunnen for hver gang vi opprettet et nytt legemiddel. */
  protected String navn;
  protected int nummer;
  protected double pris;
  private static int teller = 0;

  // Konstruktoren til klassen Legemiddel som tar enn parametre ved opprettelse.
  public Legemiddel (String navn, double pris){
    this.navn = navn;
    this.pris = pris;
    nummer = teller;
    teller++;
  }

  /* Denne klassen er bare her, siden vi ikke bruker en toString() i subklassene PillA, PilleB, PilleC, MiksA, MiksB og MiksC.
    Paa grunn av rekkefolgen programmet leser paa, saa vil den gaa opp til superklassen, Legemiddel, og hente informasjon som skal
    ned igjen til metoden info(). Derfor trenger vi ogsaa en metode info() her, ellers faar vi feilmelding. */
  public void info(){

  }
}

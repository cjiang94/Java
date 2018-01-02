// Importerer HashMap for senere bruk av lister for DVD-er en eier, laaner bort og laaner for tiden.
import java.util.HashMap;

public class Person { // Lager en klasse kalt Person.

  // Her har vi en oversikt over aller HashMapene som blir brukt i denne klassen og som ofte blir brukt i klassen DVDAdministrasjon.
  private String navn;
  private HashMap<String, DVD> dvdListe = new HashMap<String, DVD>(); // Liste over alle DVD-er en person eier.
  private HashMap<DVD, Person> laantBortListe = new HashMap<DVD, Person>(); // Liste over alle DVD-er en person laaner bort.
  private HashMap<DVD, Person> personLaanerListe = new HashMap<DVD, Person>();  // Liste over aller DVD-er en person laaner fra andre.
  private HashMap<String, DVD> dvdPersonLaaner = new HashMap<String, DVD>();  /* Ogsaa en liste over DVD-er en person laaner fra andre, men som har annerledes
                                                                                key og value. Gjorde det lettere aa hente DVD-en til metoden returnereDVD.*/

  public Person (String navn) { // konstruktoren for klassen som lager en ny Person hver gang man sender inn en parameter.
    this.navn = navn;
  }

  /* I denne metoden sjekker vi om personen eier DVD-en fra for. Hvis vi ikke finner tittelen som eier vil kjope inne i dvdListen til personen,
  saa lager vi et nytt objekt nyDVD av typen DVD ved aa bruke konstruktoren i klassen DVD. Vi setter til slutt den nylagde DVD-en inn i HashMapet dvdListe, med
  key-en tittelen til DVD-en (nyDVD.toString()), og selve DVD objektet selv (nyDVD). Denne metoden returnerer da enten null eller objektet DVD. */
  public DVD kjopDVD (String tittel) {
    if (dvdListe.containsKey (tittel)) {
        System.out.println(navn + " har allerede filmen fra for.");
        return null;
    }
    else {
    DVD nyDVD = new DVD(tittel);
    dvdListe.put (nyDVD.toString(), nyDVD);
    return nyDVD;
    }
  }

  /* Samtidig som en person laaner bort en film, er det nodvendig aa oppdatere listen for filmer som er laant (se metode laan). Vi tar inn parameterne av typen Person og DVD.
  Vi legger da argumentene inn i metoden laanBortListe med key-film (tittelen av typen DVD) og value-navn (personen som laaner bort av typen Person).
  Til slutt kaller vi paa metoden laan, og sender inne samme parametere. Den gjor akkurat det samme, bare oppdaterer sine egne lister. */
  public void laanerBort (Person navn, DVD film) {
   laantBortListe.put(film, navn);
   navn.laan(this, film);
  }

  /* Denne metoden gaar ut paa aa la en person laane DVD. Vi tar inn parameterne Person og DVD (fra metoden laanerBort), og legger dem til i personLaanerLister-HashMapet, med key av typen DVD,
  og value av typen Person. Samtidig legger vi den til dvdPersonLaaner-HashMapen, bare med key av typen String og value av typen DVD. */
  public void laan (Person navn, DVD film) {
    personLaanerListe.put(film, navn);
    dvdPersonLaaner.put(film.toString(), film);

  }


  public DVD kanLaaneBortDVD(String tittel) {
    if (dvdListe.containsKey(tittel)) {
      DVD dvd = dvdListe.get(tittel);
      if (!laantBortListe.containsKey(dvd)){
        return dvdListe.get (tittel);
      }
    }
    return null;

  }

  // Metode som returnerer HashMapen dvdListe. Dette gjor vi, fordi selve HashMapen er private og vi trenger aa bruke den utenfor denne klassen i DVDAdministrasjon.
  public HashMap<String, DVD> returnDVDListe() {
    return dvdListe;
  }

  // Metode som returnerer HashMapen laantBortListe. Dette gjor vi, fordi selve HashMapen er private og vi trenger aa bruke den utenfor denne klassen i DVDAdministrasjon.
  public HashMap<DVD, Person> returnLaantBortListe() {
    return laantBortListe;
  }

  // Metode som returnerer HashMapen personLaanerListe. Dette gjor vi, fordi selve HashMapen er private og vi trenger aa bruke den utenfor denne klassen i DVDAdministrasjon.
  public HashMap<DVD, Person> returnPersonLaanerListe() {
    return personLaanerListe;
  }

  public boolean returnereDVD(String dvd) {
    DVD laantDVD = dvdPersonLaaner.get(dvd);
      if (laantDVD == null) {
        return false;
      }
      else {
        personLaanerListe.get(laantDVD).slettLaaneListe(laantDVD);
        personLaanerListe.remove(laantDVD);
        return true;
      }
  }

  /* Inne i denne metoden gaar vi inn paa eieren av DVD-en sin laantBortListe, og fjerner DVD-en som er laant bort. Denne metoden blir bare kalt paa hvis laaneren forst bestemmer seg for aa returnere en
  DVD og vi trenger aa fjerne DVD-en fra begge listene (laantBortListe og personLaanerListe). */
  public void slettLaaneListe(DVD laantDVD) {
    laantBortListe.remove(laantDVD);
  }

  // Metode som returnerer navnet til personen vi har lagd i klassen ved aa kalle paa .toString().
  public String toString() {
  return navn;
  }
}

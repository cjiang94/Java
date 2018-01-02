import java.util.ArrayList; // Importerer ArrayList.

public class Rute {

  // Diverse verdier av forskjellige objekter.
  private int verdi;
  private Brett brett;
  private Rad rad;
  private Kolonne kolonne;
  private Boks boks;
  private int ruteID;
  private int[] aktuelleTallArray;
  private boolean lock;

  // static int teller for ruteID.
  static int teller = 0;

  // Konstruktor for klassen Rute.
  public Rute(char verdi, Brett brett, Rad rad, Kolonne kolonne, Boks boks, boolean lock) {
    this.verdi = HjelpeMetoder.tegnTilVerdi(verdi);
    this.brett = brett;
    this.rad = rad;
    this.kolonne = kolonne;
    this.boks = boks;
    this.lock = lock;
    ruteID = teller++;
  }

  // Konstruktor for klassen Rute naar det er tom verdi.
  public Rute(Brett brett, Rad rad, Kolonne kolonne, Boks boks) {
    this.verdi = 0;
    this.brett = brett;
    this.rad = rad;
    this.kolonne = kolonne;
    this.boks = boks;
    this.lock = false;
    ruteID = teller++;
  }

  // metode som returnerer verdien etter konverteringsmetoden.
  public char getVerdi() {
    return HjelpeMetoder.verdiTilTegn(verdi);
  }

  // Returnerer verdien til ruten i en int.
  public int getVerdiTall() {
    return verdi;
  }

  // Metoden for aa finne alle mulige tall.
   public int[] finnAlleMuligeTall() {

        /* Diverse Rute-arrays som skal gaa gjennom rad-,kolonne- og boks arrays for aa sjekke verdier.
        og en int-array som skal holde paa aktuelle tall. */
        Rute[] ruterFraRad = brett.getRuterFraRad(rad);
        Rute[] ruterFraKolonne = brett.getRuterFraKolonne(kolonne);
        Rute[] ruterFraBoks = brett.getRuterFraBoks(boks);

        ArrayList<Integer> tempArray = new ArrayList<Integer>();

        /* Metode som sjekker om ikke ruten allerede inneholder seg selv, eller 0, i raden.
          Hvis ikke aa sjekker vi om den ikke finnes i tempArray fra for. Hvis ikke adder vi den til tempArray.*/
        for(Rute r : ruterFraRad) {
          if(this == r || r.getVerdiTall() == 0) {
            continue;
          }
          if(!tempArray.contains(r.getVerdiTall())) {
            tempArray.add(r.getVerdiTall());
          }
        }

        /* Metode som sjekker om ikke ruten allerede inneholder seg selv, eller 0, i kolonnen.
          Hvis ikke aa sjekker vi om den ikke finnes i tempArray fra for. Hvis ikke adder vi den til tempArray.*/
        for(Rute r : ruterFraKolonne) {
          if(this == r || r.getVerdiTall() == 0) {
            continue;
          }
          if(!tempArray.contains(r.getVerdiTall())) {
            tempArray.add(r.getVerdiTall());
          }
        }
        /* Metode som sjekker om ikke ruten allerede inneholder seg selv, eller 0, i boksen.
          Hvis ikke aa sjekker vi om den ikke finnes i tempArray fra for. Hvis ikke adder vi den til tempArray.*/
        for(Rute r : ruterFraBoks) {
          if(this == r || r.getVerdiTall() == 0) {
            continue;
          }
          if(!tempArray.contains(r.getVerdiTall())) {
            tempArray.add(r.getVerdiTall());
          }
        }

        // Sjekker om det ikke finnes noen losninger. I saa fall returnerer vi bare 0.
        if(tempArray.size() == ruterFraRad.length) {
          int[] nyIntArray = new int[1];
          nyIntArray[0] = 0;
          return nyIntArray;
        }
        // Oppretter aktuelleTallArray ved aa ta total mulige tall - antall ulovlige tall.
        aktuelleTallArray = new int[ruterFraRad.length-tempArray.size()];

        int arrayTeller = 0;

        // Legger til alle aktuelle tall som kan skrives ut inn i arrayet aktuelleTallArray.
        for(int i = 1; i<=ruterFraRad.length; i++) {
          if(!tempArray.contains(i)) {
            aktuelleTallArray[arrayTeller] = i;
            arrayTeller++;
          }
        }

        return aktuelleTallArray;

      //}
  } // Avslutter finnAlleMuligeTall.

  public void fyllUtDenneRuteOgResten() {
    // Gir en peker til arrayet med alle losninger til en spesifikk rute som vi er i naa.
    int[] finnAlleMuligeTallArray = finnAlleMuligeTall();

    Rute nesteTommeRute = brett.hentNesteTommeRute(this);

    // Sjekker om ruten ikke har noen losning.
    if(finnAlleMuligeTallArray[0] == 0) {
      return;
      //return false;
    }

    // Sjekker alle mulige losninger til alle ruter.
    for(int i : finnAlleMuligeTallArray) {
      verdi = i;
      // Hvis vi har funnet en fullstendig losning, settes det inn i sudokubeholderen.
      if(nesteTommeRute == null) {
        // Lager ny kopi ved hjelp av hard copy.
        Rute[] nyRuteArray = new Rute[brett.getRuteArray().length];
        int teller = 0;
        for(Rute r : brett.getRuteArray()) {
          Rute nyRute = new Rute(r.getVerdi(), r.getBrett(), r.getRad(), r.getKolonne(), r.getBoks(), r.getLock());
          nyRuteArray[teller] = nyRute;
          teller++;
        }
        // Legger inn brettet i SudokuBeholder.
        brett.getSudokuBeholder().settInn(nyRuteArray);

      } else {
        // Ellers fyller vi ut neste tomme rute.
        nesteTommeRute.fyllUtDenneRuteOgResten();
      }

    }
    // Resetter verdien, så loopen fortsetter.
    verdi = 0;
    return;

  }

  // Metode for aa hente Rutens unike nummer.
  public int getRuteID() {
    return ruteID;
  }

  // Metode som returnerer raden ruten er i.
  public Rad getRad() {
    return rad;
  }

  // Metode som returnerer kolonnen ruten er i.
  public Kolonne getKolonne() {
    return kolonne;
  }

  // Metode som returnerer boksen ruten er i.
  public Boks getBoks() {
    return boks;
  }

  // Metode som returnerer brettet vi er i.
  public Brett getBrett() {
    return brett;
  }

  // Metode for aa returnere om verdien er locked eller ikke.
  public boolean getLock() {
    return lock;
  }

}

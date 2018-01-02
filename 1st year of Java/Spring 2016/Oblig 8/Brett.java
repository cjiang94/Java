public class Brett {

  // Diverse arrays til de forskjellige klassene.
  Rad[] radArray;
  Kolonne[] kolonneArray;
  Boks[] boksArray;
  Rute[] ruteArray;

  // en teller som holder paa hvilken RuteArray vi er i.
  private int ruteArrayTeller = 0;

  // Verdier til storrelse til sudoku-brettet (lengde og bredde).
  final int filRad;
  final int filKolonne;

  // Konstruktoren til klassen Brett.
  public Brett(int filRad, int filKolonne) {

    this.filRad = filRad;
    this.filKolonne = filKolonne;

    // Oppretter plasser til de forskjellige arrayene.
    radArray = new Rad[filRad*filKolonne];
    kolonneArray = new Kolonne[filRad*filKolonne];
    boksArray = new Boks[filRad*filKolonne];
    ruteArray = new Rute[(filRad*filKolonne)*(filRad*filKolonne)];

    // Oppretter nye Rad-, Kolonne-, Boks- og Ruteobjekter i de riktige arrayene.
    for(int i=0; i<radArray.length; i++) {
      radArray[i] = new Rad(i);
      kolonneArray[i] = new Kolonne(i);
      boksArray[i] = new Boks(i);
    }

  }

  // Metode som setter rute inn i ruteArrayet.
  public void setRute(Rute verdi) {
    ruteArray[ruteArrayTeller] = verdi;
    ruteArrayTeller++;
  }

  // Metode som henter RuteArrayet.
  public Rute[] getRuteArray() {
    return ruteArray;
  }

  // Metode som henter Ruten fra Rutearrayet.
  public Rute getRuteFraArray(int i) {
    return ruteArray[i];
  }

  // Metode som henter final variablen for lengde paa sudoku-brettet.
  public int getFilRad() {
    return filRad;
  }

  // Metode som henter final variablen for bredde paa sudoku-brettet.
  public int getFilKolonne() {
    return filKolonne;
  }

  // Metode som henter arialen av brettet.
  public int getBrettStorrelse() {
    return filRad*filKolonne;
  }

  // Metode som henter en Rad i Radarrayet.
  public Rad getRadArray(int i) {
    return radArray[i];
  }

  // Metode som henter en kolonne i Kolonnearrayet.
  public Kolonne getKolonneArray(int i) {
    return kolonneArray[i];
  }

  // Metode som henter en boks i Boksarrayet.
  public Boks getBoksArray(int i) {
    return boksArray[i];
  }

  // Metode som printer ut boksens nummer.
  public void printUtBoksVerdi() {
    for(int i = 0; i<=6; i++) {
      System.out.println(boksArray[i].getBoksNR());
    }
  }

  // Metode for aa regne ut hvilken boks i er i.
  public Boks regnBoksNR(int filRad, int filKolonne, int rad, int kolonne) {

    int boksTeller = 0;

    for(int i = 0; i<filKolonne; i++) {
      for(int j = 0; j<filRad;j++) {
        if((int)rad/filRad == i && (int)kolonne/filKolonne == j) {
          return boksArray[boksTeller];
        }
        boksTeller++;
      }
    }
    return null;

  } // Avslutter regnBoksNR-metoden

  // Metode for aa hente alle ruter fra en oppgitt rad inn til et nytt array.
  public Rute[] getRuterFraRad(Rad rad) {
    Rute[] rutefraRadArray = new Rute[filRad*filKolonne];
    int teller = 0;

    for(Rute r : ruteArray) {
      if(r.getRad() == rad) {
        rutefraRadArray[teller] = r;
        teller++;
      }
    }
    return rutefraRadArray;
  }

  // Metode for aa hente alle ruter i en oppgitt kolonne inn til et nytt array.
  public Rute[] getRuterFraKolonne(Kolonne kolonne) {
    Rute[] ruteArray = new Rute[filRad*filKolonne];
    int teller = 0;

    for(Rute r : this.ruteArray) {
      if(r.getKolonne() == kolonne) {
        ruteArray[teller] = r;
        teller++;
      }
    }
    return ruteArray;
  }

  // Metode for aa hente alle ruter fra en oppgitt boks inn til et nytt array.
  public Rute[] getRuterFraBoks(Boks boks) {
    Rute[] ruteArray = new Rute[filRad*filKolonne];
    int teller = 0;

    for(Rute r : this.ruteArray) {
      if(r.getBoks() == boks) {
        ruteArray[teller] = r;
        teller++;
      }
    }
    return ruteArray;
  }

}

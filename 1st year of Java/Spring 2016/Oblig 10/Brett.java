public class Brett {

  // Diverse arrays til de forskjellige klassene.
  Rad[] radArray;
  Kolonne[] kolonneArray;
  Boks[] boksArray;
  Rute[] ruteArray;
  Rute[] tomRuterArray;
  private SudokuBeholder sudokuBeholder = new SudokuBeholder();

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

  /* Metode som skal lage en tomRuteArray, for saa
    skal kalle paa finnAlleMuligeTall-metoden i Rute-klassen */
  public void finnAlleLosning() {
    int teller = 0;
      // Teller hvor mange tomme ruter det er i arrayet, for aa faa storrelsen paa tomRuterArray.
      for(Rute r : ruteArray) {
        if(r.getVerdiTall() == 0) {
          teller++;
        }
      }
      // Oppretter storrelsen paa tomRuterArray, og looper gjennom alle tomme ruter, og legger dem til i arrayet.
      tomRuterArray = new Rute[teller];
      teller = 0;
      for(int i = 0; i<ruteArray.length; i++) {
      }
      for(Rute tomRute : ruteArray) {
        if(tomRute.getVerdiTall() == 0) {
          tomRuterArray[teller] = tomRute;
          teller++;

        }
      }

      // Starter aa finne losning for 1. rute, og den kaller seg selv rekursivt i fyllUtDenneRuteOgResten-metoden.

       tomRuterArray[0].fyllUtDenneRuteOgResten();


  } // Avslutt finnAlleLosning.

  // Metode for aa hente neste tomme rute.
  public Rute hentNesteTommeRute(Rute rute) {
    int aktIndeks = 0;

    for(int i = 0; i<tomRuterArray.length; i++) {
      // If-setning for aa finne forste tomme rute.
      if(tomRuterArray[i].equals(rute)) {
        aktIndeks = i;
        break;
      }
    }
    // Sjekker om vi er ved slutten av tomRuterArray.
    if(aktIndeks >= tomRuterArray.length -1) {
      return null;
    }
  //  rute = tomRuterArray[aktIndeks];
    return tomRuterArray[aktIndeks + 1];
  }

  // Metode for aa hente tomRutearrayet.
  public Rute[] getTomRuterArray() {
    return tomRuterArray;
  }

  // Metode for aa hente SudokuBeholder.
  public SudokuBeholder getSudokuBeholder() {
    return sudokuBeholder;
  }

} // Avslutter klassen Brett.

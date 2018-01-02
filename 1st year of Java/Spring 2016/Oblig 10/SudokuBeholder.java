import java.util.ArrayList;  // Importerer Arraylist.

public class SudokuBeholder {

  // Bruker arraylist for å holde paa alle mulige losninger.
  ArrayList<Rute[]> losningsArray = new ArrayList<Rute[]>();
  // tellere for aa holde styr paa at vi ikke faar over 3500 losninger i arraylisten.
  int antLosninger = 0;
  int MAKS_ANTALL_I_BEHOLDER = 3500;

  // Metode for aa sette inn en losning.
  public void settInn(Rute[] losning) {
    // Legger bare til losninger saa lenge det er under 3500;
    if(antLosninger < MAKS_ANTALL_I_BEHOLDER) {
    losningsArray.add(losning);
    antLosninger++;
  } else {
    antLosninger++;
    }
  }


  // Metode for aa ta ut arraylisten med losninger.
  public ArrayList<Rute[]> taUt() {
    return losningsArray;

  }

  // Metode for aa se hvor mange losninger man har paa brettet.
  public int hentAntallLosninger() {
    return antLosninger;

  }

}

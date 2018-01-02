import java.util.*; // Importerer de ulike pakkene vi trenger.

// Monitor-klassen for traadene.
public class BeggesMonitor {

  // En final variabel som skal vise maksimum traader som har blitt tatt inn.
  private final int MAKS_TRAADER_TATT_INN;

  // Ulike variable som fungerer som tellere inne i monitoren.
  private int antallSendtInn = 0;
  private int antallArraysIMonitor = 0;
  private int antallSendtUt = 0;

  /* En midlertidig Array som skal holde paa ord til hver traad.
  Denne blir overskrevet hver gang vi starter paa en ny traad. */
  private String[] midlertidligArray;
  private String[] midlertidligArray2;

  // En arrayBeholder som skal holde paa alle traaders array.
  private ArrayList<String[]> arrayBeholder = new ArrayList<String[]>();

  // Konstruktoren til klassen hvor vi tar inn antall traader lagd som parameter.
  public BeggesMonitor(int antMaxTraader) {
    MAKS_TRAADER_TATT_INN = antMaxTraader;
  }

  // Metode for aa sjekke om vi er paa siste traad.
  public synchronized boolean sisteTraad(){
    if (antallSendtInn >= MAKS_TRAADER_TATT_INN){
      return true;
    } else {
      return false;
    }
  }

  // Metode for aa sette inn en array i monitoren. metodenavnet sier traad, men det er egentlig array vi setter inn.
  public synchronized void settInnTraad(String[] aktArray) {
      arrayBeholder.add(aktArray);
      // Tellere i monitoren blir oppdatert for hver gang vi setter inn en array.
      antallSendtInn++;
  }

  // Metode for aa ta ut en traad.
  public synchronized void taUtArray(String[] aktArray){
    midlertidligArray2 = new String[(aktArray.length + arrayBeholder.get(0).length)];

      /* For vi skal ta ut en traad, saa fletter vi det sammen med arrayet som selve traaden holder paa
        sammen med arrayet som ligger i plassering 0 i arrayBeholder. */
      midlertidligArray2 = flettingAvTraad(arrayBeholder.get(0), aktArray);
      arrayBeholder.remove(0);
      arrayBeholder.add(midlertidligArray2);
      antallSendtInn++;
  }

  // Her fletter vi to traader sammen, og returnerer en ny String-array som er flettet og sortert.
  public synchronized String[] flettingAvTraad(String[] array1, String[] array2){

    midlertidligArray=new String[array1.length + array2.length];
    int teller1 = 0;
    int teller2 = 0;
    int arrayTeller = 0;
    while(arrayTeller < midlertidligArray.length) {
    // Hvis forste ord er storre enn andre ord saa setter den forst i midlertidligArray.
      if(array1[teller1].compareTo (array2[teller2]) == 1) {
        if(array1[teller1] != null) {
        midlertidligArray[arrayTeller] = array1[teller1];
        teller1++;
        arrayTeller++;
      } else {
        midlertidligArray[arrayTeller] = array2[teller2];
        teller2++;
        arrayTeller++;
      }
        // Hvis andre ord er storre enn forste ord settes den forst i midlertidligArray.
      } else if (array1[teller1].compareTo (array2[teller2]) == -1) {
          if(array2[teller2] != null) {
          midlertidligArray[arrayTeller] = array2[teller2];
          teller2++;
          arrayTeller++;
          } else {
            midlertidligArray[arrayTeller] = array1[teller1];
            teller1++;
            arrayTeller++;
          }
          // Hvis den inner to ord som er like settes de etter hverandre i midlertidligArray.
        } else {
            midlertidligArray[arrayTeller] = array1[teller1];
            teller1++;
            arrayTeller++;
            midlertidligArray[arrayTeller] = array2[teller2];
            teller2++;
            arrayTeller++;
          }
    }
    // Returnerer til slutt en ny array som er flettet.
    return midlertidligArray;
  }

  // Metode for aa returnere alle String-arrays vi har i arrayBeholder.
  public ArrayList<String[]> getArrayList() {
    return arrayBeholder;
  }

}

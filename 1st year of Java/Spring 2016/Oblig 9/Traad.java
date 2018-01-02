import java.io.*; // Importerer de ulike pakkene vi trenger.
import java.util.*;

public class Traad implements Runnable {  // Maa implementere runnable for aa kunne bruke traader.

  // Diverse variabler som brukes i klassen.
  static String[] tempArray;
  static int traadTeller = 0;
  int traadID;
  int antOrdPaaEnTraad;
  BeggesMonitor nyMonitor;
  String[] aktArray;
  ArrayList<String> midlertideligArrayList = new ArrayList<String>();

    // Konstruktoren til klassen Traad som tar inn antall ord paa en traad, og monitoren.
    public Traad(int antOrdPaaEnTraad, BeggesMonitor nyMonitor) {
    this.antOrdPaaEnTraad = antOrdPaaEnTraad;
    this.nyMonitor = nyMonitor;
    aktArray = new String[antOrdPaaEnTraad];
    traadID = traadTeller;
    traadTeller++;
  }

  /* Denne metoden setter en spesifikk array med ord til én traad.
   Kunne satt denne inn sammen hos konstruktoren også, men valgte aa vaere en egen metode. */
  public void setArrayPaaTraad(String[] aktArray) {
    this.aktArray = aktArray;
  }

  /* Bruker ordet som ligger i midten, pivot, og sorterer alt mindre til venstre, og alt storre til hoyre.
    Repeteres ved aa velge en ny pivot paa hver sin side, helt til de enten er 0 eller 1 paa hver sin side av pivot.
    Det er forst da vi vet at alle pivot(ene) ligger paa riktig plassering. */
  public int deleOppArray(String[] aktArray, int left, int right) {

    int i=left;
    int j=right;
    String tmp;
    String pivot = aktArray[(left+right)/2];

    while (i <= j) {
      while (aktArray[i].compareTo(pivot)<0){
        i++;
      }
      while (aktArray[j].compareTo(pivot)>0){
        j--;
      }
      if (i <= j) {
        tmp = aktArray[i];
        aktArray[i] = aktArray[j];
        aktArray[j] = tmp;
        i++;
        j--;
        }
      }
    return i;
  }

  /* Vi valgte aa bruke quickSort for aa sortere arrayene. Denne metoden kaller paa
  og hovedsakelig sorterer i deleOppArray-metoden. */
  public void quickSort(String[] aktArray, int left, int right) {
    int index = deleOppArray(aktArray, left, right);
    if (left < index-1){
      quickSort(aktArray, left, index-1);
    }
    if (index < right){
      quickSort(aktArray, index, right);
    }
  }

  /* Dette er selve metoden som maa has naar vi implementeres Runnable.
    Det som staar i run er det som skal skje gjennom hele prosessen og som til slutt
    returnerer en ferdig sortert, og flettet, array som vi skal skrive ut til fil. */
  public void run() {

    quickSort(aktArray, 0, aktArray.length-1);

    String[] test = new String[aktArray.length];

    /* Tanken bak denne metoden er at en traad skal forst legge fra seg en array med ord.
    Deretter skal det loope med de andre traadenes array og flette alt sammen helt til vi har en
    fullstendig ferdig array. Men vi faar ikke til denne metoden i run. Det er det eneste vi sliter med til slutt.
    Det er mest sannsynlig feil i syntaksen naar vi skal flette traadene sammen. */
    while(!nyMonitor.sisteTraad()){
      if(nyMonitor.getArrayList().size() == 0) {
        nyMonitor.settInnTraad(aktArray);
      } else {
          nyMonitor.taUtArray(aktArray);
      }
      }
    }

  // Metode for aa faa tak i hver traads unike ID. Ikke brukt i obligen... :P
  public int getTraadID() {
    return traadID;
  }

  // Metode for aa faa tak i antall ord paa en traad.
  public int getAntOrdPaaEnTraad(){
    return antOrdPaaEnTraad;
  }

  // Metode for aa faa tak arrayet med ord til en spesifikk traad.
  public String[] getTraadArray(){
    return aktArray;
  }

  // Metode for a faa tak i ett spesifikk ord inne i ord-arrayet.
  public String getOrdPaaEnTraad(int i) {

    return aktArray[i];
  }

}

// Lager en class kalt Kalkulator.
public class Kalkulator {
  public static void main(String[] args) {

    // Regner ut summen ved aa sette inn 3 og 4 i metoden "addisjon".
    int addSvar = addisjon(3,4);
    System.out.println ("Summen blir " + addSvar);

    // Regner ut summen ved aa sette inn 5 og 2 i metoden "subtraksjon".
    int subSvar = subtraksjon (5,2);
    System.out.println ("Summen blir " + subSvar);

    // Regner ut kvotienten ved aa sette inn 10 og 3 i metoden "heltallsdivisjon".
    int helDivSvar = heltallsdivisjon (10,3);
    System.out.println ("Svaret blir " + helDivSvar);

    // Regner ut kvotienten ved aa sette inn tallene 10 og 3 i metoden "divisjon".
    double divSvar = divisjon (10,3);
    System.out.println ("Svaret blir " + divSvar);

  }
  // Oppgave 4.3 A - Metode for addisjon
  static int addisjon (int tall1, int tall2){
    int sum = tall1 + tall2;
    return sum;
  }

  // Oppgave 4.3 B - Metode for subtraksjon
  static int subtraksjon (int tall1, int tall2){
    int sum = tall1 - tall2;
    return sum;
  }

  // Oppgave 4.3 C - Metode for heltallsdivisjon
  static int heltallsdivisjon (int tall1, int tall2){
    int kvotient = tall1 / tall2;
    return kvotient;
  }

  // Oppgave 4.3 D - Metode for divisjon.
  static double divisjon (double tall1, double tall2){
    double kvotient = tall1 / tall2;
    return kvotient;
  }
}

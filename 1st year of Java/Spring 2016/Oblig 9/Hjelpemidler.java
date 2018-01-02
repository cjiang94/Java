import java.util.ArrayList;

public class Hjelpemidler {

public static ArrayList<Integer> deleligeTallBeholder = new ArrayList<Integer>();

/*  public static ArrayList<Integer> finnAlleDeleligeTall(int alleOrdFil) {

    for(int i = 1; i < alleOrdFil; i++) {
      if(alleOrdFil%i == 0) {
        deleligeTallBeholder.add(i);
        System.out.println("lagt til: " + i);
      }
    }
    return deleligeTallBeholder;
  }*/

  public static ArrayList<Integer> getArrayList() {
    return deleligeTallBeholder;
  }

  public static void printArrayList() {

    for(int i = 0; i<deleligeTallBeholder.size(); i++)
    System.out.println(i);
  }
}

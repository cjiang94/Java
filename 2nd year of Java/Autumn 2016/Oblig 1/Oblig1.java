import java.util.Scanner;
import java.io.File;
import java.util.HashMap;

public class Oblig1 {
  public static void main(String[] args) throws Exception{

    double totalSnitt = 0;
    boolean meny = true;
    NodeTre bTree = new NodeTre();
    File fil = new File("dictionary.txt");
    Scanner input = new Scanner(fil);

    // Lager forst roten i treet
    String data = input.nextLine();
    bTree.root = new Node(data);

    // Deretter setter inn alle andre ord i treet
    while(input.hasNextLine()) {
      data = input.nextLine();
      bTree.root.addNode(new Node(data));
    }


    System.out.println("\n\nLest inn filen: " + fil + "\n\n\n");

    // Fjerner busybody
    bTree.remove(bTree.root, "busybody");
    bTree.root.addNode(new Node("busybody"));

    Scanner in = new Scanner(System.in);
    Scanner forsteLinje = new Scanner(fil);
    String linje = forsteLinje.nextLine();
    Node node = new Node(linje);

    while(meny) {
      System.out.println("~~~~ Hvilket ord vil du soke etter? ~~~~ \n(Press q for aa avslutte)");
      String brukerTekst = in.nextLine();
      if(brukerTekst.equals("q")) {
        meny = false;
        System.out.println("\n\n===== STATISTIKK =====");
        System.out.println("Dybde paa treet er: " + (bTree.maxDybde(bTree.root)-1));
        bTree.breddeNode(bTree.root, 0);
        HashMap<Integer, Integer> map = bTree.getMap();
        System.out.println("Antall noder for hver dybde [Dybde-Antall node(r)]: " + map.entrySet());
        totalSnitt = bTree.snittDybde(bTree.root, 0);
        int antallNoder = bTree.getTotalNoder();
        System.out.println("Gjennomsnittsdybde paa treet er: " + totalSnitt/antallNoder);
        Node minst = bTree.finnMinste(bTree.root);
        System.out.println("Forste ord i listen er: " + minst.data);
        String storst = bTree.storstOrd(bTree.root);
        System.out.println("Siste ord i listen er: " + storst);
        break;
      } else {
        bTree.search(bTree.root, brukerTekst);
      }
    }
  }
}

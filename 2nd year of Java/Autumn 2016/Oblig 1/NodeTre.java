import java.util.HashMap;
import java.util.ArrayList;
// Naa har jeg tolket oppgaven slik at vi ikke skal ha duplikater av ord i listen, siden det skal vaere en ordbok. (Se linje 41)

public class NodeTre {

public Node root;
private int hoyde = 0;
int teller = 0;
int totalNoder = 0;
long duration = 0;
long startTime;
long endTime;
public char[] alfabetet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o',
'p','q','r','s','t','u','v','w','x','y','z'};
HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

  // ------------------------------------------------------------------------------------------

  // Metode som skal fjerne ordet vi sender inn som parameter
  public void remove(Node aktNode, String word) {

    if(aktNode == null) {
      return;
    }
    if(word.compareTo(aktNode.data) < 0) {
      remove(aktNode.left, word);
    } else if (word.compareTo(aktNode.data) > 0) {
      remove(aktNode.right, word);
    }
    else {
      // Aktnode er lovnode, og forelder skal peke paa null
      if(aktNode.left == null && aktNode.right == null) {

        // Sjekker forst om ikke aktNode er root.
        if(aktNode == root) {
          root = null;
          return;
        }

        if(aktNode.parent.left == aktNode) {
          aktNode.parent.left = null;
        } else {
          aktNode.parent.right = null;
        }
      }
      // Hvis aktNode sitt venstrebarn er null, og aktNode selv er enten hoyrebarn/venstrebarn av sin forelder
      else if(aktNode.left == null) {
        // Sjekker forst om ikke aktNode er root.
        if(aktNode == root) {
          root = aktNode.right;
        }

        if(aktNode.parent.right == aktNode) {
          aktNode.parent.right = aktNode.right;
          aktNode.right.parent = aktNode.parent;
        } else {
          aktNode.parent.left = aktNode.right;
          aktNode.right.parent = aktNode.parent;
        }
        // Hvis aktNode sitt hoyrebarn er null, og aktNode selv er enten hoyrebarn/venstrebarn av sin forelder
      } else if(aktNode.right == null) {
        // Sjekker forst om ikke aktNode er root.
        if(aktNode == root) {
          root = aktNode.left;
        }

        if(aktNode.parent.left == aktNode) {
          aktNode.parent.left = aktNode.left;
          aktNode.left.parent = aktNode.parent;
        } else {
          aktNode.parent.right = aktNode.left;
          aktNode.left.parent = aktNode.parent;
        }

      } else {
        Node minsteNode = finnMinste(aktNode.right); // lag metoden som returnerer minste node i hoyre siden
        aktNode.data = minsteNode.data;
        remove(aktNode.right, minsteNode.data);
      }


    }
  } // Slutt paa remove

  // ------------------------------------------------------------------------------------------
  // Metode som skal finne storste dybden paa treet
  public int maxDybde(Node rotNode) {
    if(rotNode == null) {
      return 0;
    } else {
      int leftDybde = maxDybde(rotNode.left);
      int rightDybde = maxDybde(rotNode.right);

      if(leftDybde > rightDybde) {
        return (leftDybde + 1);
      } else {
        return (rightDybde + 1);
      }
    }
  } // Slutt paa maxDybde

  // ------------------------------------------------------------------------------------------
  // Metode som skal returnere gjennomsnittsdybden i treet
  public int snittDybde(Node rotNode, int dybde) {

    if(rotNode == null) {
      return 0;
    }
    else {
      totalNoder++;
      rotNode.depth = dybde;
      return dybde + snittDybde(rotNode.left, dybde+1) + snittDybde(rotNode.right, dybde+1);
    }
  } // Slutt paa snittDybde

  // ------------------------------------------------------------------------------------------

  // Maa hente teller totalNoder for aa bruke i main
  public int getTotalNoder() {
    return totalNoder;
  }

  // ------------------------------------------------------------------------------------------
  // Metode som skal finne bredden paa hver dybde i treet
  public void breddeNode(Node rotNode, int dybde) {

    if(rotNode == null) {
      return;
    }
    if(map.containsKey(dybde)) {
      int teller = map.get(dybde);
      map.put(dybde, teller+1);
    } else {
      map.put(dybde, 1);
    }

    breddeNode(rotNode.left, dybde+1);
    breddeNode(rotNode.right, dybde+1);

  } // Slutt paa breddeNode

  // ------------------------------------------------------------------------------------------
  // Returnerer hashmapet mitt
  public HashMap<Integer, Integer> getMap() {
    return map;
  }

  // ------------------------------------------------------------------------------------------
  // Metode som skal finne minste/forste ord i listen
  public Node finnMinste(Node startNode) {
    Node resultat = startNode;
    if(startNode.left != null) {
      resultat = finnMinste(startNode.left);
    }
    return resultat;

  } // Slutt paa finnMinste

  // ------------------------------------------------------------------------------------------
  // Metode for aa finne storste/siste ord i listen
  public String storstOrd(Node rotNode) {
    Node aktNode = rotNode;

    while(aktNode.right != null) {
      aktNode = aktNode.right;
    }
    return (aktNode.data);

  } // Slutt paa storstOrd

  // ------------------------------------------------------------------------------------------
  // Hele search-metoden for aa lete gjennom treet og kalle de andre hjelpemetodene
  public void search(Node rotNode, String word) {
    word = word.toLowerCase();
    int teller = 0;

    // Kaller paa metoden similarOne
    if(!finn(rotNode, word)) {
      System.out.println("\n!!!!!! Ordet finnes ikke i ordlisten !!!!!!\n");
      System.out.println("Mente du: ");
      startTime = System.currentTimeMillis();
      String[] array1 = similarOne(word);
      if(array1 == null) {
        return;
      }
      for(int i = 0; i < array1.length; i++) {
        if(finn(rotNode, array1[i])) {
          teller++;
          System.out.println("\"" + array1[i] + "\"?\n");
        }
      }
    }
    // Kaller paa metoden oneReplaced
    if(!finn(rotNode, word)) {
      ArrayList<String> arraylist1 = oneReplaced(rotNode, word);
      if(arraylist1 == null) {
        return;
      }
      for(int j = 0; j <arraylist1.size(); j++) {
        if(finn(rotNode, arraylist1.get(j))) {
          teller++;
          System.out.println("\"" + arraylist1.get(j) + "\"?\n");
        }
      }
    }
    // Kaller paa metoden oneRemoved
    if(!finn(rotNode, word)) {
      ArrayList<String> arraylist2 = oneRemoved(rotNode, word);
      if(arraylist2 == null) {
        return;
      }
      for(int k = 0; k < arraylist2.size(); k++) {
        if(finn(rotNode, arraylist2.get(k))) {
          teller++;
          System.out.println("\"" + arraylist2.get(k) + "\"?\n");
        }
      }

    }
    // Kaller paa metoden oneAdded
    if(!finn(rotNode, word)) {
      ArrayList<String> arraylist3 = oneAdded(rotNode, word);
      if(arraylist3 == null) {
        return;
      }
      for(int m = 0; m < arraylist3.size(); m++) {
        if(finn(rotNode, arraylist3.get(m)));
        teller++;
        System.out.println("\"" + arraylist3.get(m) + "\"?\n");
      }
    endTime = System.currentTimeMillis();
    duration = (endTime - startTime);
      System.out.println("Antall losninger som ga et positivt svar: " + teller + "\n\n");
      System.out.println("Tiden det tok for soket (i millisekunder): " + duration + "\n\n");
    }
    else {
      System.out.println("Ordet '" + word + "' er blitt funnet i ordlisten\n");
    }

  } // Slutt paa search

  // ------------------------------------------------------------------------------------------
  // Metode finn, for aa finne et ord i treet, brukes i search-metoden
  public boolean finn(Node rotNode, String ord) {
    if(rotNode.data.compareTo(ord) > 0) {
      if(rotNode.left == null) {
        return false;
      }
      return finn(rotNode.left, ord);
    } else if (rotNode.data.compareTo(ord) < 0) {
      if(rotNode.right == null) {
        return false;
      }
      return finn(rotNode.right, ord);
    } else{
      return true;
    }

  } // Slutt paa finn

  // ------------------------------------------------------------------------------------------
  // Swap-funksjonen som brukes i similarOne til aa swappe to bokstaver
  public String swap(int a, int b, char[] word) {
    char tmp = word[a];
    word[a] = word[b];
    word[b] = tmp;

    return new String(word);

  } // Slutt paa swap

  // ------------------------------------------------------------------------------------------
  // Spell-checkmetode 1, som skal swappe to bokstaver i strengen
  public String[] similarOne(String word) {

    char[] word_array = word.toCharArray();
    char[] tmp;

    String[] words = new String[word_array.length-1];

    for(int i = 0; i < word_array.length-1; i++) {
      tmp = word_array.clone();
      words[i] = swap(i, i+1, tmp);
    }
    return words;

  } // Slutt paa similarOne

  // ------------------------------------------------------------------------------------------
  // Spell-checkmetode 2, som skal erstatte hver bokstav i strengen
  public ArrayList<String> oneReplaced(Node rotNode, String word) {
    char[] word_array = word.toCharArray();
    char[] tmp;

    ArrayList<String> words = new ArrayList<String>();

    for(int i = 0; i < word_array.length; i++) {
      for(int j = 0; j < 26; j++) {
        tmp = word_array.clone();
        tmp[i] = alfabetet[j];
        String tempString = new String(tmp);

        if(finn(rotNode, tempString) && !words.contains(tempString)) {
          words.add(tempString);
        }
      }
    }
    return words;

  } // Slutt paa oneReplaced

  // ------------------------------------------------------------------------------------------
  // Spell-checkmetode 3, som skal fjerne en bokstav i strengen
  public ArrayList<String> oneRemoved(Node rotNode, String word) {
    char[] word_array = word.toCharArray();
    char[] tmp;
    char[] nyArray = new char[(word_array.length+1)];
    nyArray[0] = '\0';
    ArrayList<String> words = new ArrayList<String>();

    for(int i = 0; i < word_array.length; i++) {
      nyArray[i+1] = word_array[i];
    }

    for(int j = 0; j < nyArray.length; j++) {
      tmp = nyArray.clone();
      for(int k = 0; k < j; k++) {
        char a = tmp[k];
        tmp[k] = tmp[k+1];
        tmp[k+1] = a;
      }

      for(int c = 0; c < 26; c++) {
        tmp[j] = alfabetet[c];
        String tempString = new String(tmp);
        if(finn(rotNode, tempString) && !words.contains(tempString)) {
          words.add(tempString);
        }
      }
    }
      return words;

    } // Slutt paa oneRemoved

  // ------------------------------------------------------------------------------------------
  // Spell-checkmetode 4, som skal legge til en bokstav i strengen.
  public ArrayList<String> oneAdded(Node rotNode, String word) {
    char[] word_array = word.toCharArray();
    char[] nyArray = new char[(word_array.length-1)];
    ArrayList<String> words = new ArrayList<String>();

    for(int i = 0; i < word_array.length; i++) {
      int teller = 0;
      for(int k = 0; k < word_array.length; k++) {
        if(k != i) {
          nyArray[teller] = word_array[k];
          teller++;
        }
      }
      String tempString = new String(nyArray);
      if(finn(rotNode, tempString) && !words.contains(tempString)) {
        words.add(tempString);
      }
    }
    return words;

  } // Slutt paa oneAdded

}

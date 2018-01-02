import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;

public class Oblig3 {
  public static void main(String[] args) throws Exception{

    if(args.length != 2) {
      System.out.println("Error: Invalid arguments. Usage: java Oblig3 <needle> <haystack>");
      return;
    }
    File new_needle = new File(args[0]);
    File new_haystack = new File(args[1]);

    Scanner needle_input = new Scanner(new_needle);
    Scanner haystack_input = new Scanner(new_haystack);

    String temp_needle = "";
    while(needle_input.hasNext()) {
      temp_needle += needle_input.nextLine();
    }

    String temp_haystack = "";
    while(haystack_input.hasNext()) {
      temp_haystack += haystack_input.nextLine();
    }

    if(temp_needle.equals("")) {
      System.out.println("Error: Needle-file is empty.");
      return;
    }

    if(temp_haystack.equals("")) {
      System.out.println("Error: Haystack-file is empty");
      return;
    }

    int needle_length = temp_needle.length();
    int haystack_length = temp_haystack.length();

    char[] needle = new char[needle_length];
    char[] haystack = new char[haystack_length];

    temp_needle.getChars(0, needle_length, needle, 0);
    temp_haystack.getChars(0, haystack_length, haystack, 0);

    boyer_moore_horspool(needle, haystack);

    }

  public static void boyer_moore_horspool(char[] needle, char[] haystack) {

    final int CHAR_MAX = 256;

    boolean found = false;

    if(needle.length > haystack.length) {
      System.out.println("Error: Needle is larger than the haystack");
      return;
    }

    int[] bad_char_shift = new int[CHAR_MAX];

    int offset = 0;
    int needle_index = 0;
    int last_cell = needle.length - 1;
    int max_offset = haystack.length - needle.length;

    String ss = new String(needle);
    ss = ss.substring(0, (needle.length-1));
    int wildCard = ss.lastIndexOf('_');

    if(wildCard != -1) {
      for (int i = 0; i < CHAR_MAX; i++) {
        bad_char_shift[i] = (needle.length-1) - wildCard;
      }
    } else {
      for(int i = 0; i < CHAR_MAX; i++) {
        bad_char_shift[i] = needle.length;
      }
    }

    for(int i = 0; i < last_cell; i++) {
      if((last_cell - i) < bad_char_shift[needle[i]]) {
        bad_char_shift[needle[i]] = last_cell - i;
      }
    }

    while (offset <= max_offset) {

      for(needle_index = last_cell; needle[needle_index] == haystack[needle_index+offset] || needle[needle_index] == '_'; needle_index--) {

          if(needle_index == 0) {
            System.out.println("A match is found at index: " + offset);
            for(int i = 0; i < needle.length; i++) {
              found = true;
              System.out.print(haystack[offset + i]);
            }
            System.out.println("\n");
            break;
          }
      }
      offset += bad_char_shift[haystack[offset + last_cell]];
    }

    if(!found) {
      System.out.println("No match was found...");
    }

  } // End of boyer_moore_horspool-method

}

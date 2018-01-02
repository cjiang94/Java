public class Oblig2TestHylle{
  public static void main(String[] args){

    // Trying to make 3 new books.
    Bok book = new Bok ("Fifty Shades of Grey", "Dora the Explorer");
    Bok book2 = new Bok ("Inferno", "Dan Brown");
    Bok book3 = new Bok ("Norwegian Wood", "Murakami");

    // Making a new shelf with 100 places to put things.
    Hylle<Bok> shelf = new Hylle<Bok>(100);

    // Testing method testNoSpace. I expect the boolean to return false.
    System.out.println("Testing if I can put a book in a non-existing place.\n");
    if (testNoSpace(shelf, book, 105)){
      System.out.println ("The test was not successfull\n\n\n");
    } else{
      System.out.println ("The test was successful, and you couldn't place a book in a non-existing place. \n\n\n");
    }

    // Testing method testPutGetFreeSpace. Expecting the boolean to return true.
    System.out.println("Testing putting in a book, removing it then checking if the place is free.\n");
    if (testPutGetFreeSpace(shelf, book, 20)){
      System.out.println("The test was successful, and you did put and then remove the book. The place is now free.\n\n\n");
    } else{
      System.out.println("The test was not successful.\n\n\n");
    }

    // Testing the method testPutTwoBooks. Expecting the boolean to return false.
    System.out.println("Testing putting two books on the same spot.\n");
    if (testPutTwoBooks(shelf, book, book2, 50)){
      System.out.println("The test was not successful\n\n\n");
    } else{
      System.out.println("The test was successful, and you couldn't put two books on the same spot.\n\n\n");
    }

    // Testing the method testBookFromNoSpace. Expecting the boolean to return false.
    System.out.println("Testing taking a non-existing book from a place.\n");
    if(testBookFromNoSpace(shelf, book, 8)){
      System.out.println("The test was not successful\n\n\n");
    } else{
      System.out.println("The test was successful, and you couldn't take a non-existing book from the shelf.\n\n\n");
    }
  }

  // Tests if placing a book on a non-existing place.
  public static boolean testNoSpace(Hylle<Bok> shelf, Bok book, int placement){
    if (shelf.put(book, placement)){
      return true;
    } else {
      return false;
    }

  }

  // Tests putting in a book, removing it and checking if the place is free.
  public static boolean testPutGetFreeSpace(Hylle<Bok> shelf, Bok book, int placement){
  shelf.put(book, placement);
  shelf.get(placement);
  if (shelf.freeSpace(placement)){
    return true;
    }else{
      return false;
    }
  }

  // Tests putting to books on the same place.
  public static boolean testPutTwoBooks(Hylle<Bok> shelf, Bok book, Bok book2, int placement){
  shelf.put(book, placement);
  if(shelf.put(book2, placement)){
    return true;
  } else{
    return false;
  }
  }

  // Testing if I can take a non-existing book from a place.
  public static boolean testBookFromNoSpace(Hylle<Bok> shelf, Bok book, int placement){
    if(shelf.get(placement)){
      return true;
    } else{
      return false;
    }
  }
}

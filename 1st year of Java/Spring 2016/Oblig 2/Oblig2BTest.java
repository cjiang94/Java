public class BokTest {
  public static void main (String [] args) {

    Bok book = new Bok ("Fifty Shades of Grey", "Dora the Explorer");
    book.LaaneBort(book, "Tom");
    book.TaTilbake(book);
    book.TaTilbake(book);
  }
}

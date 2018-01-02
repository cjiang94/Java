public class Bok implements TilUtLaan { // class book that implements TilUtLaan.

  // private variables for this class.
  private String laaner;
  private String tittel;
  private String forfatter;
  private boolean laantBort = false;
  private boolean levertTilbake;
  private Bok bok;

  // The constructor for the class Bok.
  public Bok (String tittel, String forfatter) {
    this.tittel = tittel;
    this.forfatter = forfatter;
  }

  // A method that lets you borrow a book.
  public void LaaneBort(Bok bok, String laaner) {
    this.bok = bok;
    this.laaner = laaner;
    if (!laantBort) {
    laantBort = true;
    System.out.println (laaner + " har naa laant boken " + this.toString());
    } else
    System.out.println ("Boken " + this.toString() + " er allerede laant bort.");
  }

  // A method that makes you take back the book that was borrowed.
  public void TaTilbake (Bok bok) {
    if (laantBort) {
    laantBort = false;
    System.out.println (laaner + " har naa levert tilbake boken " + this.toString());
    } else
    System.out.println ("Det er ingen bok aa levere tilbake.");
  }

  // A toString-method that returns that name of the book.
  public String toString(){
    return tittel;
  }

} // quits class Bok

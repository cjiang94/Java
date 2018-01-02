// Lager en klasse DVD som hovedsakelig staar for aa lage en DVD.
public class DVD{
  private String tittel;

  // konstruktoren for klassen hvor vi tar inn en parameter av typen String og lager et nytt objekt av typen DVD.
  public DVD(String tittel) {
    this.tittel = tittel;
  }

  // En toString-metode som skal returnere navnet paa DVD-en.
  public String toString() {
    return tittel;
  }
}

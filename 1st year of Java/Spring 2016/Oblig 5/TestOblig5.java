public class TestOblig5 {
  public static void main(String[] args) {

    LenkeListe<Integer> minLenkeListe = new LenkeListe<Integer>();

    minLenkeListe.leggTil(10);
    minLenkeListe.leggTil(3);
    minLenkeListe.leggTil(4);
    minLenkeListe.leggTil(8);
    minLenkeListe.leggTil(1);

    minLenkeListe.skrivUtAlle();

    if(minLenkeListe.tom()) {
      System.out.println ("Beholderen er tom.");
    } else {
        System.out.println ("Beholderen er ikke tom.");
    }


    System.out.println ("Du har naa fjernet tallet: " + minLenkeListe.fjernMinste());

    minLenkeListe.skrivUtAlle();

    System.out.println (minLenkeListe.inneholder(1));
    System.out.println (minLenkeListe.inneholder(8));

    LenkeListe<String> minLenkeListe2 = new LenkeListe<String>();

    minLenkeListe2.leggTil("Smart");
    minLenkeListe2.leggTil("Er");
    minLenkeListe2.leggTil("Tom");

    minLenkeListe2.skrivUtAlle();

    System.out.println ("Du har naa fjernet ordet: " + minLenkeListe2.fjernMinste());

    minLenkeListe2.skrivUtAlle();

    System.out.println (minLenkeListe2.inneholder("Er"));
    System.out.println (minLenkeListe2.inneholder("Tom"));
  }
}

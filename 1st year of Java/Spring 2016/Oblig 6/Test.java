public class Test {
  public static void main(String[] args) {

    Tabell test = new Tabell(5);
    test.SettInnObjekt("hei", 3);

    if(test.FinnObjekt(3) != null){
      System.out.println("Du har funnet objektet " + test.FinnObjekt(3));
    }
  }
}

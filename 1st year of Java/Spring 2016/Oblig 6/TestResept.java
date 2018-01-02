public class TestResept{
  public static void main(String[] args) {
    PilleA test = new PilleA("Paracet", 120.50, 12, 25, 40.50);
    PilleB test2 = new PilleB("Zopiclone", 150.90, 50, 10, 86.80);
    PilleC test3 = new PilleC("Hostetabeletter", 69.90, 18, 30.50);

    Resept testR = new Resept(test, "Ariel", "Christin", 2, "blaa");
    Resept testR2 = new Resept (test3, "Sigrid", "Ashwini", 5, "hvit");

    testR.brukResept();
    testR.brukResept();
    testR.brukResept();
    testR.brukResept();
    testR.info();

    testR2.brukResept();
    testR2.info();
  }
}

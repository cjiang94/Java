public class TestProgram{
  public static void main(String[] args){
    PilleA test = new PilleA("Paracet", 120.50, 12, 25, 40.50);
    PilleB test2 = new PilleB("Zopiclone", 150.90, 50, 10, 86.80);
    PilleC test3 = new PilleC("Hostetabeletter", 69.90, 18, 30.50);

    MiksA test4 = new MiksA("Pinex", 99.50, 35, 120, 87.50);
    MiksB test5 = new MiksB("Diazepam (flytende) ", 224.90, 70, 35, 68.90);
    MiksC test6 = new MiksC("Hostesaft", 40.0, 50, 12);

    test.info();
    test2.info();
    test3.info();
    test4.info();
    test5.info();
    test6.info();

    test.info();
  }
}

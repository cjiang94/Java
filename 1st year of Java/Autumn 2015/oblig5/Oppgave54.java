public class Oppgave54{
  public static void main(String[] args){
    // Lager et objekt av klassen min Isbod.
    Isbod jegErSjef = new Isbod();

    // Ansetter 6 personer.
    jegErSjef.ansett("Tom");
    jegErSjef.ansett("Emilie");
    jegErSjef.ansett("Julenissen");
    jegErSjef.ansett("Paaskeharen");
    jegErSjef.ansett("Geir Kjetil");
    jegErSjef.ansett("Rektor");

    // Sjekker at alle som er ansatt staar paa listen.
    jegErSjef.printAlleAnsatte();

    // Prover aa sparke en.
    jegErSjef.giSistemannSparken();

    // Sjekker at sistemann har blitt sparket.
    jegErSjef.printAlleAnsatte();

    // Prover aa ansette 10 personer.
    jegErSjef.ansett("Baymax");

    jegErSjef.ansett("Spider-Man");

    jegErSjef.ansett("Butt-Man");

    jegErSjef.ansett("Kakao");

    jegErSjef.ansett("Bunnpris-sjefen");

    // Prover aa ansette en 11. ansatt. Skal faa feilmelding i konsoll.
    jegErSjef.ansett("Panda");

    // Sjekker at listen bare inneholder 10 personer.
    jegErSjef.printAlleAnsatte();

    // Gir noen stakkarse sparken.
    jegErSjef.giSistemannSparken();

    jegErSjef.giSistemannSparken();

    jegErSjef.giSistemannSparken();
    // Printer ut hvilke ansatte jeg har forelopig.
    jegErSjef.printAlleAnsatte();

    // Prover aa gi alle sammen sparken.
    jegErSjef.giSistemannSparken();

    jegErSjef.giSistemannSparken();

    jegErSjef.giSistemannSparken();

    jegErSjef.giSistemannSparken();

    jegErSjef.giSistemannSparken();

    jegErSjef.giSistemannSparken();

    jegErSjef.giSistemannSparken();

    jegErSjef.giSistemannSparken();

    // Ser om det gaar an aa printe ut tom jobbliste.
    jegErSjef.printAlleAnsatte();

  }
}

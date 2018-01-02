// Importerer ArrayList, Scanner, og File for videre bruk i metodene mine.
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

// Lager en class kalt Ordliste.
public class Ordliste{

  // Lager en private ArrayList.
  private ArrayList<Ord> liste = new ArrayList<Ord>();

  /* Lager en public metode kalt lesBok som skal ta inn en string, filnavn, (i dette tilfellet et .text fil)
  og leses med File og Scanner. Deretter kaller vi paa metoden leggTilOrd og sender inn hver
  linje i teksten inn til metoden. */
  public void lesBok(String filnavn) throws Exception {
    File fil = new File (filnavn);
    Scanner in = new Scanner(fil);
    while (in.hasNextLine()) {
      leggTilOrd(in.nextLine());
    }
  }

  /* Her har vi en private metode kalt leggTilOrd som tar inn argumentet "ord" fra metoden lesBok.
  I denne metoden bruker vi en for-each lokke som bruker en boolean for aa sjekke om ikke ordet
  finnes i listen fra for. Hvis den finnes fra for av, saa skal vi oke antallet ved aa
  kalle paa oekAntall-metoden som ligger i Ord-klassen. Hvis ikke ordet finnes fra av (!finnes),
  saa skal vi legge til ordet i listen (liste.add) */
  private void leggTilOrd(String ord) {
    boolean found = false;
    for (Ord listeOrd : liste) {
      if (ord.equalsIgnoreCase(listeOrd.toString())) {
      listeOrd.oekAntall();
      found = true;
      /* break-er lokken, fordi det er unodvendig aa gaa gjennom resten av listen,
      siden ord av samme slag aldri blir lagt til. */
      break;
      }
    }
    if (!found) {
      /* Var nodt til aa lage en ny peker (nyOrd) til argumentet som ble sendt inn fra lesBok,
      fordi det ikke ville lese argumentet direkte. */
      Ord nyOrd = new Ord (ord);
      liste.add(nyOrd);
    }
  }

  /* Dette er en metode for aa finne et spesifikt ord i teksten. Jeg tolket oppgaven slik som at det
  skulle ta inn et ord fra brukeren. (Dette var for jeg leste hva oppgave 6.3 ville).
  finnOrd tar inn en tekst, som brukeren vil soke. Vi leser gjennom listen med en for-each lokke
  og hvis ordet finnes i teksten, saa returnerer vi ordet. Hvis programmet ikke finner ordet
  returnerer vi null. Tolker oppgaveteksten "faar vi null som svar" som at jeg staar fri
  til hvordan jeg skal vi tilbakemelding til bruker. Bruker null, istedenfor 0 */
  public Ord finnOrd(String tekst) {
    for(Ord letOrd : liste) {
      if (tekst.equalsIgnoreCase(letOrd.toString())) {
        return letOrd;
      }
    }
    return null;
  }

  /* Her returnerer vi storrelsen paa ArrayListen. Den vil da variere paa hvor stor teksten er. */
   public int antallOrd() {
    return liste.size();
  }

  //  finner og returnerer hvor mange ganger ordet "tekst" forekommer i ordlisten.
  public int antallForekomster(String tekst) {
    Ord funnetOrd = finnOrd(tekst);
    /* Her vil den returnere 0, hvis teksten vi soker etter er lik "null", altsaa
    at vi ikke finner sokerteksten i teksten. */
    if (funnetOrd == null) {
      return 0;
    }
    /* Hvis programmet finner ordet vi leter etter, saa vil den returnere
    antall av ordet ved aa hente metoden hentAntall, som har tatt vare paa
    antall forekomster av ordet i klassen Ord. */
    return funnetOrd.hentAntall();

  }
  /* finner og returnerer det ordet som forekommer oftest i boken. Det blir lagd en
  ny Ord-variabel som vi setter som null forelopig. Deretter gaar for-each lokken
  gjennom listen og vi lar den lese det forste ordet i listen og setter den som verdien til tellOrd.
  Deretter lager vi en if-setning som sjekker om vanligord (ordet vi leser gjennom listen via for-each lokken)
  har flere forekomster enn tellOrd. Denne vil loope saa lenge tellOrd-ordet har mindre forekomster enn vanligOrd-ordet. */
  public Ord vanligste() {
    Ord tellOrd = null;
    for (Ord vanligOrd : liste) {
      if (tellOrd == null) {
        tellOrd = vanligOrd;
      }
      if (vanligOrd.hentAntall() > tellOrd.hentAntall()){
        tellOrd = vanligOrd;
      }
    }
    // Tilslutt vil metoden returnere ordet som forekommer flest ganger i teksten.
    return tellOrd;
  }


  // finner og returnerer det eller de ordene som forekommer flest ganger i boken.
  public Ord[] alleVanligste() {
    // Lager en teller, Ord-Array, og Arrayliste.
    int teller = 0;
    Ord[] returnereOrd;
    ArrayList <Ord> alleOrd = new ArrayList<Ord>();

    /* Her gaar jeg gjennom teksten for aa finne antallet av ordet som forekommer flest ganger i teksten.
    Poenget var aa hente ut et antall som jeg skal sammenligne andre ord med og se om det er flere ord med samme forekomster. */
    for (Ord listeOrd : liste) {
    int antall = listeOrd.hentAntall();
      if (antall > teller) {
        teller = antall;
      }

    // Her henter vi andre ord som har like mange antall forekomster fra forrige for-lokke, og legger ordet til ArrayListen alleOrd.
    }
    for (Ord listeOrd : liste) {
      if (listeOrd.hentAntall() == teller) {
        alleOrd.add(listeOrd);
      }
    }
    /* Her lager vi en ny Ord-Array (ikke liste!) som er paa storrelsen med ArrayListens storrelse som vi fant
    ved aa lese gjennom teksten tidligere. */
    returnereOrd = new Ord[alleOrd.size()];
    /* Her legger vi inn alle ordene som dukker opp flest ganger i teksten og legger dem pent inn i en array.
    Dette skal ta returnere alle ordene med flest forekomster ut til main-metoden vaar. */
    for (int i=0; i<alleOrd.size(); i++) {
      returnereOrd[i] = alleOrd.get(i);
    }
    return returnereOrd;
  }
}

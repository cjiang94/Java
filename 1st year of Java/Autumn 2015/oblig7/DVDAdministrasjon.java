// importerer hele mappen .util og .io, for Scanner, HashMap, File og BufferedWriter.
import java.util.*;
import java.io.*;

public class DVDAdministrasjon {  // Lager klassen DVDAdministrasjon.

  HashMap<String, Person> navneliste = new HashMap<String, Person>(); // Lager en ny HashMap kalt navneliste, som tar inn key-String og value-Person, og skal holde orden paa alle personer vi har.
  File fil; // Deklarerer en ny fil av typen File, men lar den staa tom forelopig.

  /* Dette er konstruktoren til klassen DVDAdministrasjon, og som tar inn en parameter med typen String. Rett under lager vi en
  File av parameteren som vi sender inn fra main-klassen. Dette er delen som leser inn fra fil som blir spurt om i oppgaven. */
  public DVDAdministrasjon(String filNavn) throws Exception {

    fil = new File (filNavn);
    lesFil(fil);

    Scanner in = new Scanner(System.in); // Lager en Scanner som skal ta inn brukerinput senere.
    boolean laane = true; // Lager en boolean kalt laane, og setter den lik true, saa vi gaar inn i while-lokken.

    /* Her er det lagd en brukerdialog med kommandolokke som det ble spurt om i oppgaven. Den bestaar av valgene 1-7, hvor brukeren
    kan velge hva som skal gjores med vaar "virtuelle-DVD-laane-verden". */
    while (laane) {
      System.out.println ("Hva vil du gjore? :) \n\n 1. Lage ny person \n 2. Kjope DVD \n 3. Laane DVD \n 4. Vis hva en person eier og laaner \n 5. Vis totaloversikt \n 6. Returnere DVD \n 7. Avslutte");
      int brukerSvar = in.nextInt();
      in.nextLine();  // Noe glitch med java og nextInt(), saa maa ha denne ekstra linjen for at Scanner ikke skal hoppe over bruker-input.

      /* Hvis brukeren svarer 1 i kommandolokken, saa skal vi lage en ny person. Dette skjer ved av vi spor bruker om hvilken navn personen
      skal ha, og deretter lager vi et nytt objekt av typen Person. Dette skjer med konstruktoren i klassen Person. Til slutt
      legger vi til den nylagde personen inn i HashMap-listen vaar kalt "navneliste", med key-navnet til personen (person.toString), og value-objektet person av typen Person. */
      if (brukerSvar == 1) {
      System.out.println("Hva heter den nye personen?");
      String navn = in.nextLine();
      Person person = new Person (navn);
      System.out.println("Du har naa lagd en ny person kalt: " + person.toString());
      navneliste.put(person.toString(), person);
      }

      /* Hvis brukeren svarer 2 i kommandolokken, saa skal vi la en person kjope en ny DVD. Vi spor forst hvem som har kjopt DVD'en, og
      henter denne personen ut fra navnelisten. Hvis personen ikke finnes i navnelisten, faar vi melding om det. Hvis personen finnes, saa
      spor vi om hvilken film personen skal kjope. Deretter sender vi inn tittelen paa filmen inn til metoden kjopDVD. */
      else if (brukerSvar == 2) {
        System.out.println("Hvem har kjopt DVD-en?");
        String hvemKjoper = in.nextLine();
        Person person = navneliste.get(hvemKjoper);

        if (person == null) {
            System.out.println("Personen finnes ikke i registeret.");
        }
        else {
          System.out.println("Hva er tittelen paa filmen?");
          String tittel = in.nextLine();
          System.out.println (person + " har naa kjopt " + person.kjopDVD(tittel));

        }
      }

      /* Hvis brukeren svarer 3 i kommandolokken, saa skal vi laane DVD. Forst sjekker vi hvem som skal laane DVD, og hvis personen ikke finnes
      i registeret saa faar vi melding om det. Hvis personen som laaner finnes, spor vi videre hvem personen skal laane fra. Vi sjekker
      om eieren av filmen finnes eller ikke (vi faar melding om eieren ikke finnes). Deretter legger vi i tillegg inn slik laaneren ikke kan laane sine egne DVD-er.
      Til slutt spor vi hvilken DVD som skal bli laant. Tittelen som blir skrevet inn sendes inn i metoden kanLaaneBortDVD. Hvis metoden finner dvd-en og
      returnerer null, saa faar vi ikke laant DVD-en. Hvis den returnerer en DVD, saa skal eieren faa laane bort DVD-en som vi ser i LaanerBort-metoden.
      Da sendes altsaa DVD-en inn til metoden laanerBort med key-laaneren (personen som laaner), og value-dvdtittel. */
      else if (brukerSvar == 3) {
        System.out.println("Hvem skal laane DVD?");
        String hvemLaaner = in.nextLine();
        Person laaner = navneliste.get(hvemLaaner);

        if (laaner == null) {
          System.out.println("Personen som skal laane finnes ikke i registeret.");
        }
        else {
          System.out.println("Hvem skal " + laaner + " laane DVD fra?");
          String hvemEier = in.nextLine();
          Person eier = navneliste.get(hvemEier);
          if (eier == null) {
            System.out.println ("Personen som du vil laane DVD fra finnes ikke i registeret.");
          }
          else if (laaner == eier) {
            System.out.println ("Personen kan ikke laane DVD til seg selv.");
          }
          else {
            System.out.println ("Hvilken DVD vil " + laaner + " laane fra " + eier + "?");
            String tittel = in.nextLine();
            DVD dvd = eier.kanLaaneBortDVD(tittel); // Sjekk metoden kanLaaneBortDVD og kommentarer der for mer informasjon.
            if (dvd == null) {
              System.out.println (eier + " har dessverre ikke DVD-en tilgjengelig.");
            }
            else {
              eier.laanerBort(laaner, dvd); // Sjekk metoden laanerBort for kommentarer og mer informasjon.
              System.out.println (laaner + " har naa laant " + dvd + " fra " + eier);
            }
          }
        }
      }

      /* Hvis brukeren svarer 4 i kommandolokken, saa skal vi gi en oversikt over alle titler som en person eier, alt som er laant ut for tiden og
      og alt den spesifikke personen laaner. Forst spor vi om hvilken person vi onsker aa se listen over. Opppgaven sa ogsaa at man kan skrive "*",
      og dette vil vise totaloversikt for alle personer i navnelisten vaar. Hvis brukerinput er "*", bruker vi en for-each lokke som looper gjennom
      alle personer i navnelisten vaar, og printer ut listen ved aa sende inn parameteren person1 inn i metoden printerUtDVDListe (se metode).
      Hvis brukerinput er et navn, og personen finnes i listen, sender vi bare personen inn i printerUtDVDListe-metoden og henter hele
      eier,laaner bort og laaner-listen for den spesifikke personen. */
      else if (brukerSvar == 4) {
      System.out.println("Hvem vil du se DVD-liste over?");
      String person = in.nextLine();

        if (person.equals("*")) {

          for (Person person1 : navneliste.values()) {
            printerUtDVDListe(person1); // Sjekk metoden printerUtDVDListe for med informasjon og kommentarer.
          }

        }
        else {  // Printer ut en melding om vi ikke finner personen vi vil se listen over i navnelisten.

          Person person2 = navneliste.get(person);
          if (person2 == null) {
            System.out.println ("Personen du vil se DVD-liste over finnes ikke.");
          }
          else {
            printerUtDVDListe(person2);
          }

        }
      }

      /* Her tolket jeg oppgaven slik at den skulle gi en liste over eier, laaner bort og laaner til en person, og listen skulle vise
      antall og ikke titler(som i hvis man trykket paa 4 i brukerinput). Her lagde jeg ikke en metode som jeg gjorde i den over, men
      brukte heller kommandoen .size() for HashMap som returnerer en variabel av typen int. Den henter da antallet av key-values vi
      har i HashMapene som ligger i klassen Person. */
      else if (brukerSvar == 5){
        for (Person person : navneliste.values()) {
          int eierDVD = person.returnDVDListe().size(); // Henter ut antall key-values vi har i Hashmapen dvdListe i klassen Person.
          System.out.println (person + " eier " + eierDVD + " DVD-er.");

          int eierLaanerUt = person.returnLaantBortListe().size();
          System.out.println (person + " har laant bort " + eierLaanerUt + " DVD-er."); // Henter ut antall key-values vi har i Hashmapen laantBortListei klassen Person.

          int eierLaaner = person.returnPersonLaanerListe().size(); // Henter ut antall key-values vi har i Hashmapen dvdPersonLaaner i klassen Person.
          System.out.println (person + " har laant " + eierLaaner + " DVD-er.\n");
        }
      }


      /* Her skal vi returnere en laant dvd tilbake til eieren. Siden vi har HashMap-lister i klassen Person som holder orden paa hvilke
      DVD-er som er laantBort og som er laant, gjelder det aa fjerne en dvd, som skal returneres, fra begge listene.
      Forst spor vi hvilken person som har laant en DVD. Vi sjekker om personen finnes i navneregisteret vaart. Hvis ikke faar vi melding om det,
      og hvis personen finnes spor vi videre hvilken DVD personen har laant. Vi sjekker deretter om tittelen finnes i dvdPersonLaaner-Hashmapen i klassen Person.
      Hvis den ikke finnes, faar vi melding om at personen ikke har laant denne DVD-en. Hvis den finnes vil den bli slettet fra begge lister,
      ved bruk av metoden returnereDVD. */
      else if (brukerSvar == 6){
        System.out.println ("Hvem er det som har laant DVD?");
        String hvemLaante = in.nextLine();
        Person person = navneliste.get(hvemLaante);
          if (person == null) {
              System.out.println("Personen finnes ikke i registeret.");
          }
          else {
            System.out.println ("Hvilken DVD har " + person + " laant?");
            String laanteHvilkenDVD = in.nextLine();
            boolean returnert = person.returnereDVD(laanteHvilkenDVD);  // Sjekk metoden returnereDVD i klassen Person for mer informasjon.
              if (!returnert) {
                System.out.println (person + " har ikke laant denne DVD-en.");
              }
              else {
                System.out.println (person + " har naa levert tilbake " + laanteHvilkenDVD);
              }
          }

      }

      // Avslutter kommandolokken ved aa sette boolean laane = false, noe som gjor at vi gaar ut av hele while-lokken.
      else if (brukerSvar == 7){
      System.out.println("Hadet bra!");
      skrivFil();
      laane = false;
      }

      else {  // Hvis bruker skriver noe annet enn 1-7, saa faar vi en melding, og faller ikke ut av while-lokken.
      System.out.println ("Kunne ikke tyde meldingen din. Prov igjen.");
      }

      System.out.println ("\n\n\n\n");  // For ordens skyld saa lager jeg noen linjer saa det ser bedre ut.
    } // Avslutter while-lokken

  } // Avslutter DVDAdministrasjon-metoden.



  /* Dette er en metode som bruker hvis brukerinput var "4" i kommandolokken. Den tar inn en parameter av typen Person kalt person1. Vi bruker da
  en for-each lokke som skal printe ut listen over DVD-er som man eier, har laant bort og laante til personen vi sendte inn som parameter.
  Forst sjekker vi DVD-er som personen eier ved aa bruke kommandoen returnDVD-liste.values(). Vi bruker .values(), fordi den henter values, som
  ligger inne i Hashmapen dvdListe i klassen Person. Den henter da bare values, som ble satt til typen DVD fra HashMapen som blir returnert fra metoden returnDVDListe.
  Deretter bruker vi kommandoene .entrySet() for aa hente ut baade key og value fra HashMapene laantBortListe og personLaanerListe. Disse Hashmapene
  returneres ved bruk av metodene returnLaantBortListe og returnPersonLaanerListe. Da faar vi liste over personene som har laant bort og laant filmer, og hvilke DVD-er det gjelder. */
  public void printerUtDVDListe (Person person1) {
    System.out.println("\n" + person1 + " eier: ");
    for (DVD dvd : person1.returnDVDListe().values()) { // Les mer paa metoden returnDVDliste og HashMapen dvdListe i klassen Person for mer informasjon.
       System.out.println(dvd);
    }
    System.out.println("\n" + person1 + " har laant bort filmen(e): ");
    for (Map.Entry<DVD,Person> laanBort : person1.returnLaantBortListe().entrySet()) {  // Sjekk metoden returnLaantBortListe() i klassen Person for mer informasjon.
       System.out.println(laanBort.getKey() + " til " + laanBort.getValue());
    }
    System.out.println("\n" + person1 + " har laant filmen(e): ");
    for (Map.Entry<DVD,Person> laant : person1.returnPersonLaanerListe().entrySet()) {  // Sjekk metoden returnPersonLaanerListe() i klassen Person for mer informasjon.
       System.out.println(laant.getKey() + " av " + laant.getValue());
    }
  }

  /* Dette er metoden som blir brukt helt paa starten av denne klassen. Dens oppgave er aa lese .txt filen som ble sendt inn som argument fra main-klassen, og blir gjort
  om til en File helt overst i denne klassen. lesFil-metoden tar naa inn en parameter av typen File kalt fil.
  Vi lager flere booleans som gjor det enklere for oss aa lese linjene i tekstenfilen og skille mellom person, dvd og aa laane dvd. */
  private void lesFil (File fil) throws Exception { // Vi maa ha throws Exception, fordi vi jobber med File.
    Scanner in = new Scanner(fil);
    boolean lestFerdigPersoner = false;
    boolean navn = false;
    boolean film = false;
    boolean laaner = false;
    Person person = null;
    DVD dvd = null;

    /* Vi jobber inne i while-lokken saa lenge tekstfilen fortsatt har en nextLine. De forste linjene vi leser i teksten vil lage en ny Person for hver linje.
    Dette kommer av den siste else-setningen, fordi booleanene gjor at vi ikke gaar inn i noen av de andre if, elseif-setningen.
    Naar vi forst kommer til en bindestrek i teksten, gaar vi inn i den forste if-setningen. Der setter vi booleanen lestFerdigPersoner = true, navn = true,
    film = false og laaner = false. Saa lenge lestFerdigPersoner = true, jobber vi inne i den forste elseif-setningen.
    Vi er naa paa linjen som gir et navn, og deretter ser vi at navn = true, som gjor at vi gaar inn i denne if-setningen. I if-setningen henter vi denne personen fra navnelisten, og
    setter det inn for variabelen person av typen Person.
    Vi setter deretter navn = false og film = true, som betyr at naar vi gaar ut av elseif-setningen og looper while-lokken paa en ny linje, saa lar vi personen vi nettopp satte som varibel person
    kjope DVD-en som blir lest inn paa denne linjen(dette skjer i else if(film)). Hvis linjen starter med "*", gaar vi inn i if-setningen, og setter laaner = true, og film = false.Vi lagrer da String variabelen
    "linje" lik tittel fra subString(1), fordi vi ikke vil ha med "*" i tittelen. Vi gaar da ut av hele elseif-setningen, og looper while lokken paa ny linje.
    Denne gangen er laaner = true, og vi gaar inne paa denne elseif-setningen. Her inne vil vi da sende inn argumentene av hvem som laaner (Person) og tittelen (DVD) inn
    til metoden laanerBort(). Dette vil da bli lagt til i HashMapene i klassen Person for aa holde orden paa hvem som laaner bort og hvem som laaner.
    Til slutt lar vi film = true og laaner = false, for aa sjekke om det er flere filmer denne personen eier i .txt filen. */
    while (in.hasNextLine()) {
      String linje = in.nextLine();
      if (linje.equals("-")) {
        lestFerdigPersoner = true;
        navn = true;
        film = false;
        laaner = false;
      }
      else if (lestFerdigPersoner) {

        if (navn) {
          person = navneliste.get(linje);
          navn = false;
          film = true;
        }
        else if (film) {

          if (linje.charAt(0) == '*') {
            laaner = true;
            linje = linje.substring(1);
            film = false;
          }

          dvd = person.kjopDVD(linje);

        }
        else if (laaner) {
          person.laanerBort(navneliste.get(linje), dvd);
          laaner = false;
          film = true;
        }
      }
      else {
        Person person1 = new Person (linje);
        navneliste.put(person1.toString(), person1);
      }

    }
  } // Avslutter lesFil-metoden.

  /* Tilleggsoppgave. Here fikk jeg hjelp av en som kunne metoden for aa skrive inn i fil. Det vi gjor forst er aa skrive inn navnene som allerede
  finnes fra navneliste inn paa nytt med BufferedWriter. Naar det ikke finnes flere navn aa skrive inn fra navneliste, saa skriver vi inn en "-".
  Vi lager naa en ny HashMap liste som bestaar av HashMapen laantBortListe fra klassen Person (Maatte bruker en matode for aa hente listen, fordi selve HashMapen
  er private i klassen Person.) Etter aa ha hentet den ut, sjekkr vi om linjen vi leser naa er av typen DVD og om den finnes i listen laantBortListe. Hvis den finnes
  skriver vi "*" foran tittelen og legger til tittelen selv. Deretter bruker vi .get for aa hente valuen til key-en dvd og setter paa .toString().
  Dette gir da Personen som laaner DVD-en paa neste linje. Hvis laantBort-HashMapen ikke har dvd-en fra for av i laantBortListe, saa skriver vi bare tittelen paa DVD,
  som betyr det ikke er utlaant og naa er hos eieren. */
  private void skrivFil() throws Exception {
    BufferedWriter bw = new BufferedWriter(new FileWriter(fil));
    for (Person person : navneliste.values()) {
      bw.write(person.toString());
      bw.newLine();
    }

    for (Person person : navneliste.values()) {
      bw.write("-");
      bw.newLine();
      bw.write(person.toString());
      bw.newLine();
      HashMap<DVD, Person> laantBort = person.returnLaantBortListe();
      for (DVD dvd : person.returnDVDListe().values()) {
        if (laantBort.containsKey(dvd)) {
          bw.write("*" + dvd.toString());
          bw.newLine();
          bw.write(laantBort.get(dvd).toString());
          bw.newLine();
        }
        else {
        bw.write(dvd.toString());
        bw.newLine();
        }

      }

    }

    bw.flush();
    bw.close();
  } // Avslutter skrivFil-metoden.

} // Avslutter DVDAdministrasjon-klassen.

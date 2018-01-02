import java.io.*;   // Importerer .io og .util for Scanner, File og PrintWriter.
import java.util.*;

public class Oblig7 {

  // Ulike variable som holdes paa ulike verider.
  static Tabell pasientTabell = new Tabell(100);
  static Tabell legemiddelTabell = new Tabell(100);
  static SortertEnkelListe legeListe = new SortertEnkelListe();
  static EldsteForstReseptListe reseptene = new EldsteForstReseptListe();
  static int pasientTeller = 0;
  static int legemiddelTeller = 0;
  static int reseptTeller = 0;
  static int antVaneDanResepter = 0;
  static int antBorIOslo = 0;

  // Main-klassen
  public static void main(String[] args) throws Exception{

    boolean erISystem = true;

    String filNavn = "";

    while(erISystem) {

      // Menyen i terminalen.
      System.out.println("\n\n\n===========================================");
      System.out.println("Velkommen til oversikt over helsesystemet!");
      System.out.println("===========================================\n\n");
      System.out.println("Vennligst velg en kommando:\n");
      System.out.println("[1] Skriv ut alle pasienter, alle leger (sortert paa navn), alle legemidler og alle resepter.");
      System.out.println("[2] Opprette og legge inn et nytt legemiddel.");
      System.out.println("[3] Opprette og legge inn en ny lege.");
      System.out.println("[4] Opprette og legge inn en ny pasient.");
      System.out.println("[5] Opprette og legge inn en ny resept.");
      System.out.println("[6] Hente et legemiddel paa en resept.");
      System.out.println("[7] Skriv ut statistikk over resepter.");
      System.out.println("[8] Skriv ut statistikk over pasienter.");
      System.out.println("[9] Skriv ut statistikk over leger.");
      System.out.println("[10] Lese inn en fil.");
      System.out.println("[11] Skriv ut statistikk over medisinsk misbruk.");
      System.out.println("[12] Skriv til en fil og avslutt.");

      // Diverse variable som brukes for brukerens input.
      String brukerLegemiddelNavn, brukerLegemiddelForm, brukerType;
      int brukerAntallMengde;
      int brukerStyrke = 0;
      double brukerLegemiddelPris, brukerVirkestoff;

      Scanner in = new Scanner(System.in);
      int hvaVilBruker = in.nextInt();

      // Skriver ut alle pasienter, leger (sortert paa navn), legemidler og resepter.
      if(hvaVilBruker == 1) {
        skrivUtAlt();
        // Spor bruker om verdier til nytt legemiddel.
      } else if(hvaVilBruker == 2) {

        System.out.println("Hva heter legemiddelet?");
        // Maa ha denne linjen, fordi java glitcher paa terminal.
        in.nextLine();
        brukerLegemiddelNavn = in.nextLine();

        // interaksjon med bruker.
        System.out.println("Hvilken form har den? (mikstur/pille)");
        brukerLegemiddelForm = in.nextLine();
          if(brukerLegemiddelForm.equalsIgnoreCase("Pille")) {
          System.out.println("Hva er antallet paa pillene i flasken?");
          brukerAntallMengde = in.nextInt();
        } else if (brukerLegemiddelForm.equalsIgnoreCase("Mikstur")) {
          System.out.println("Hva er mengden paa miksturen i flasken?");
          brukerAntallMengde = in.nextInt();
        } else {
          System.out.println("Kunne ikke tolke meldingen.");
          continue;
        }

        System.out.println("Hvilken type er den? (a/b/c)");
        in.nextLine();
        brukerType = in.nextLine();
        if(brukerType.equalsIgnoreCase("a")) {
          } else if (brukerType.equalsIgnoreCase("b")) {
            } else if (brukerType.equalsIgnoreCase("c")) {
              } else {
              System.out.println ("Kunne ikke tolke meldingen.");
              continue;
              }

        System.out.println("Hva er prisen paa legemiddelet?");
        brukerLegemiddelPris = Double.parseDouble(in.nextLine());

        System.out.println("Hvor mye er virkestoffet?");
        brukerVirkestoff = Double.parseDouble(in.nextLine());

        if(brukerType.equalsIgnoreCase("a") || brukerType.equalsIgnoreCase("b")) {
        System.out.println("Hva er styrken paa den? (Gjelder bare a & b typer)");
        brukerStyrke = in.nextInt();
        }

        // Lager et legemiddel med alle verdiene vi har faatt inn tidligere.
        lagLegemiddel(brukerLegemiddelNavn, brukerLegemiddelForm, brukerType, brukerLegemiddelPris, brukerAntallMengde, brukerVirkestoff, brukerStyrke);

        // Spor bruker om informasjon om ny lege.
      } else if(hvaVilBruker == 3) {
        System.out.println("Hva heter legen?");
        in.nextLine();
        String legensNavn = in.nextLine();
        System.out.println("Hvis fastlege, oppgi avtalenummer. (Hvis ikke skriv 0)");
        String avtNummer = in.nextLine();

        // Oppretter en ny lege via metoden lagLege (se nede).
        lagLege(legensNavn, avtNummer);

        // Spor bruker om informasjon om ny pasient.
      } else if(hvaVilBruker == 4) {
        System.out.println ("Hva heter pasienten?");
          in.nextLine();
          String pasientNavn = in.nextLine();

        System.out.println("Hva er fodselsnummeret? (11 sifre)");
          String fNr = in.nextLine();

        System.out.println("Hva er adressen?");
          String pasientAdresse = in.nextLine();

        System.out.println("Hva er postnummeret?");
          String pasientPostNr = in.nextLine();

        // Oppretter og lager en ny pasient via metoden lagPasient.
        lagPasient(pasientNavn, fNr, pasientAdresse, pasientPostNr);

        // Spor bruker om informasjon til ny resept.
      } else if(hvaVilBruker == 5) {

        Iterator<Legemiddel> iter5 = legemiddelTabell.iterator();

        System.out.println("-----------------------------------");
        System.out.println("Oversikt over alle legemidler");
        System.out.println("-----------------------------------");
        while(iter5.hasNext()) {
        System.out.println(iter5.next().info());
        }

        System.out.println("Hvilket nummer har legemidlet ditt?");
        int nummer = in.nextInt();

        System.out.println("Hva heter legen til resepten?");
        in.nextLine();
        String legeNavn2 = in.nextLine();

        System.out.println("Hvilket nummer har pasienten?");
        int pasientTall2 = in.nextInt();

        System.out.println("Hvor mange ganger kan man bruke resepten?");
        in.nextLine();
        int tallReit = in.nextInt();

        System.out.println("Hvilken farge har resepten? (hvit/blaa)");
        in.nextLine();
        String reseptFarge = in.nextLine();

        // Oppretter en ny resept via metoden lagResept.
        lagResept(nummer, legeNavn2, pasientTall2, tallReit, reseptFarge);

        // Spor brukeren om hvilken legemiddel fra hvilken resept som skal brukes.
      } else if(hvaVilBruker == 6) {
        System.out.println("Hva er nummeret til pasienten som skal bruke resepten?");
        int nummer2 = in.nextInt();

        System.out.println("Hva er nummeret paa resepten som skal brukes?");
        int nummer3 = in.nextInt();

        Object o2 = pasientTabell.finnObjekt(nummer2);
        Pasient p2 = (Pasient) o2;
        p2.hentResepter(nummer3);

        // Skriver ut statistikk over vanedannede resepter. Og folk som bor i Oslo.
      } else if(hvaVilBruker == 7) {
        Iterator<Pasient> sjekkListe = pasientTabell.iterator();

        System.out.println("Antall vanedannede resepter: " + antVaneDanResepter);

        while(sjekkListe.hasNext()) {
        Pasient tempP = sjekkListe.next();
          if(tempP.borIOslo()) {
              if(tempP.returnResept().returnLegemiddel() instanceof MiksB) {
              antBorIOslo++;
            } else if (tempP.returnResept().returnLegemiddel() instanceof PilleB) {
                antBorIOslo++;
              }

          }
          }
          System.out.println("Antall som bor i Oslo: " + antBorIOslo);

        // Statistikk over pasienter.
      } else if(hvaVilBruker == 8) {
        System.out.println ("Vennligst skriv inn personnummeret til pasienten du vil se blaa resept over (sortert paa yngst forst).");
        int personnummer = in.nextInt();
        if(pasientTabell.finnObjekt(personnummer) == null) {
          System.out.println("Kunne ikke tyde meldingen.");
          continue;
        }

        Object o = pasientTabell.finnObjekt(personnummer);
        Pasient p = (Pasient) o;
        p.skrivAlleBlaa();

        // Statistikk over leger.
      } else if(hvaVilBruker == 9) {
        System.out.println("Hva heter legen du vil se resepter paa?");
        String legeNavn3 = in.nextLine();
        if(legeListe.finn(legeNavn3) != null) {
          /* Denne returnerer alle resepter, og ikke bare de som er av miksturer. Her tenkte jeg aa faa tak i lege-objektet og deretter hente
            reseptlisten, men den henter dessverre ikke.
          legeListe.finn(legeNavn3).returnEldsteListe(); */
        }
        // Bruker skriver inn hvilken fil de vil lese i fra.
      } else if(hvaVilBruker == 10) {
        System.out.println("Hvilken fil vil du lese i fra?");
        in.nextLine();
        filNavn = in.nextLine();
        lesFraFil(filNavn);

        // Statistikk over medisinsk misbruk.
      } else if(hvaVilBruker == 11) {

        // Har ikke greid aa skrive inn kode her :C

        // Bruker PrintWriter til aa skrive til fil.
      } else if(hvaVilBruker == 12) {
        if(filNavn.equals("")) {
          System.out.println("Du har ikke oppgitt noen filnavn.");
        } else {
          PrintWriter skrivUt = new PrintWriter(filNavn);

          skrivUt.println("# Personer, nr, navn, fnr, adresse, postnr)");

          Iterator<Pasient> iP = pasientTabell.iterator();
          while(iP.hasNext()) {
            skrivUt.println(iP.next().nyInfo());
          }

          skrivUt.println("");

          skrivUt.println("# Legemidler (nr, navn, form, type, pris, antall/mengde, virkestoff [, styrke])");

          Iterator<Legemiddel> lm = legemiddelTabell.iterator();
            while(lm.hasNext()){
            skrivUt.println(lm.next().nyInfo());
          }

          skrivUt.println("");

          skrivUt.println("# Leger (navn, avtalenr / 0 hvis ingen avtale)");
          Iterator<Lege> l = legeListe.iterator();
            while(l.hasNext()) {
            skrivUt.println(l.next().nyInfo());
          }

          skrivUt.println("");
          skrivUt.println("# Resepter (nr, hvit/blaa, persNummer, legeNavn, legemiddelNummer, reit)");
          Iterator<Resept> r = reseptene.iterator();
          while(r.hasNext()) {
            skrivUt.println(r.next().nyInfo());
          }

          skrivUt.println("");
          skrivUt.println("# Slutt");
          skrivUt.close();
        }
        erISystem = false;
      }


    } // Avslutter while(erISystem).
} // Avslutter main.
  public static void lagLegemiddel(String brukerLegemiddelNavn, String brukerLegemiddelForm, String brukerType, double brukerLegemiddelPris, int brukerAntallMengde, double brukerVirkestoff, int brukerStyrke) {
    if(brukerLegemiddelForm.equalsIgnoreCase("mikstur") && brukerType.equalsIgnoreCase("a")) {
      MiksA tempLM = new MiksA (brukerLegemiddelNavn, brukerLegemiddelForm, brukerType, brukerLegemiddelPris, brukerAntallMengde, brukerVirkestoff, brukerStyrke);
      legemiddelTabell.settInn(tempLM, legemiddelTeller);

    } else if (brukerLegemiddelForm.equalsIgnoreCase("mikstur") && brukerType.equalsIgnoreCase("b")) {
        MiksB tempLM = new MiksB(brukerLegemiddelNavn, brukerLegemiddelForm, brukerType, brukerLegemiddelPris, brukerAntallMengde, brukerVirkestoff, brukerStyrke);
        legemiddelTabell.settInn(tempLM, legemiddelTeller);

      } else if (brukerLegemiddelForm.equalsIgnoreCase("mikstur") && brukerType.equalsIgnoreCase("c")) {
            MiksC tempLM = new MiksC(brukerLegemiddelNavn, brukerLegemiddelForm, brukerType, brukerLegemiddelPris, brukerAntallMengde, brukerVirkestoff);
            legemiddelTabell.settInn(tempLM, legemiddelTeller);

          } else if (brukerLegemiddelForm.equalsIgnoreCase("pille") && brukerType.equalsIgnoreCase("a")) {
              PilleA tempLM = new PilleA(brukerLegemiddelNavn, brukerLegemiddelForm, brukerType, brukerLegemiddelPris, brukerAntallMengde, brukerVirkestoff, brukerStyrke);
              legemiddelTabell.settInn(tempLM, legemiddelTeller);

            } else if (brukerLegemiddelForm.equalsIgnoreCase("pille") && brukerType.equalsIgnoreCase("b")) {
              PilleB tempLM = new PilleB(brukerLegemiddelNavn, brukerLegemiddelForm, brukerType, brukerLegemiddelPris, brukerAntallMengde, brukerVirkestoff, brukerStyrke);
              legemiddelTabell.settInn(tempLM, legemiddelTeller);

            } else if (brukerLegemiddelForm.equalsIgnoreCase("pille") && brukerType.equalsIgnoreCase("c")) {
                  PilleC tempLM = new PilleC(brukerLegemiddelNavn, brukerLegemiddelForm, brukerType, brukerLegemiddelPris, brukerAntallMengde, brukerVirkestoff);
                  legemiddelTabell.settInn(tempLM, legemiddelTeller);
                  }

  } // Lukker lagLegemiddel.

    // Metode for aa lage ny lege.
    public static void lagLege(String legensNavn, String avtNummer) {
      if(!avtNummer.equals("0")) {
        FastLege fastLegen = new FastLege (legensNavn, avtNummer);
        legeListe.settInnMinsteForan(fastLegen);
      } else {
        Lege legen = new Lege(legensNavn);
        legeListe.settInnMinsteForan(legen);
        }
    }

    // Metode for aa lage ny pasient.
    public static void lagPasient(String pasientNavn, String fNr, String pasientAdresse, String pasientPostNr) {
      Pasient pasient = new Pasient (pasientNavn, fNr, pasientAdresse, pasientPostNr);
      pasientTabell.settInn(pasient, pasient.returnNr());
    }

    // Metode for aa lage ny resept.
    public static void lagResept(int legemiddelNr, String reseptLegeNavn, int pasientTall, int reit, String reseptFarge) {
      Legemiddel tempLegeM = (Legemiddel)legemiddelTabell.finnObjekt(legemiddelNr);
      Resept nyResepten = new Resept(tempLegeM, reseptLegeNavn, pasientTall, legemiddelNr, reit, reseptFarge);
    /*  Det kommer rare error naar disse to er med, fordi jeg ikke faar hentet objektene. Blant annet NullPointerException.
      legeListe.finn(reseptLegeNavn).nyResept(nyResepten);
      pasientTabell.finnObjekt(pasientTall).nyResept(nyResepten); */
      reseptene.leggTil(nyResepten);

      if(tempLegeM instanceof MiksB) {
        antVaneDanResepter++;
      } else if(tempLegeM instanceof PilleB) {
        antVaneDanResepter++;
      }
      System.out.println("Har laget resept.");
    }

  // Metode for aa lese fra fil.
  public static void lesFraFil(String filNavn) throws Exception {

    double legemiddelPris;
    String legemiddelNummer, pasientNavn, fNr, pasientAdresse, pasientPostNr, legemiddelNavn, legemiddelForm, legemiddelType, legeNavn, legeAvtaleNummer, reseptNavn, reseptFarge, reseptLegeNavn  = null;
    int pasientNummer, legemiddelAntallMengde, legemiddelVirkeStoff, legemiddelStyrke, reseptPersonNr, reseptLegemiddelNummer, reit;

          Scanner scanFil = new Scanner(new File(filNavn));
          String linje = null;

          while(scanFil.hasNext()) {
            linje = scanFil.nextLine();

            // Gjor at vi skipper linjen som start med #.
            if (linje.contains("#")) {
                linje = scanFil.nextLine();
            }

            // Leser inn pasienter.
            while (!linje.contains("#")) {

              if(linje.equals("")) {
                linje = scanFil.nextLine();
                break;
              }

              String[] pasientHolder = linje.split(",");

              for (int i=0; i<pasientHolder.length; i++) {
                pasientHolder[i] = pasientHolder[i].trim();
              }

              pasientNummer = Integer.parseInt(pasientHolder[0]);
              pasientNavn = pasientHolder[1];
              fNr = pasientHolder[2];
              pasientAdresse = pasientHolder[3];
              pasientPostNr = pasientHolder[4];

              Pasient pasient = new Pasient (pasientNavn, fNr, pasientAdresse, pasientPostNr);
              pasientTabell.settInn(pasient, pasient.returnNr());

              linje = scanFil.nextLine();

            }

            // Gjor at vi skipper linjen som start med #.
            if (linje.contains("#")) {
                linje = scanFil.nextLine();
            }

              // Legger inn legemidler.
              while(!linje.contains("#")) {

                if(linje.equals("")) {
                  linje = scanFil.nextLine();
                  break;
                }

                String[] legemiddelHolder = linje.split(",");

                for (int i=0; i<legemiddelHolder.length; i++) {
                  legemiddelHolder[i] = legemiddelHolder[i].trim();
                }

              legemiddelNummer = legemiddelHolder[0];
              legemiddelNavn = legemiddelHolder[1];
              legemiddelForm = legemiddelHolder[2];
              legemiddelType = legemiddelHolder[3];
              legemiddelPris = Double.parseDouble(legemiddelHolder[4]);
              legemiddelAntallMengde = Integer.parseInt(legemiddelHolder[5]);
              legemiddelVirkeStoff = Integer.parseInt(legemiddelHolder[6]);

              if(legemiddelForm.equals("mikstur") && legemiddelType.equals("a")) {
                legemiddelStyrke = Integer.parseInt(legemiddelHolder[7]);
                MiksA miksturA = new MiksA(legemiddelNavn, legemiddelForm, legemiddelType, legemiddelPris, legemiddelAntallMengde, legemiddelVirkeStoff, legemiddelStyrke);
                legemiddelTabell.settInn(miksturA, miksturA.returnNr());

              } else if (legemiddelForm.equals("mikstur") && legemiddelType.equals("b")) {
                  legemiddelStyrke = Integer.parseInt(legemiddelHolder[7]);
                  MiksB miksturB = new MiksB(legemiddelNavn, legemiddelForm, legemiddelType, legemiddelPris, legemiddelAntallMengde, legemiddelVirkeStoff, legemiddelStyrke);
                  legemiddelTabell.settInn(miksturB, miksturB.returnNr());

                } else if (legemiddelForm.equals("mikstur") && legemiddelType.equals("c")) {
                      MiksC miksturC = new MiksC(legemiddelNavn, legemiddelForm, legemiddelType, legemiddelPris, legemiddelAntallMengde, legemiddelVirkeStoff);
                      legemiddelTabell.settInn(miksturC, miksturC.returnNr());

                    } else if (legemiddelForm.equals("pille") && legemiddelType.equals("a")) {
                        legemiddelStyrke = Integer.parseInt(legemiddelHolder[7]);
                        PilleA pillerA = new PilleA(legemiddelNavn, legemiddelForm, legemiddelType, legemiddelPris, legemiddelAntallMengde, legemiddelVirkeStoff, legemiddelStyrke);
                        legemiddelTabell.settInn(pillerA, pillerA.returnNr());

                      } else if (legemiddelForm.equals("pille") && legemiddelType.equals("b")) {
                        legemiddelStyrke = Integer.parseInt(legemiddelHolder[7]);
                        PilleB pillerB = new PilleB(legemiddelNavn, legemiddelForm, legemiddelType, legemiddelPris, legemiddelAntallMengde, legemiddelVirkeStoff, legemiddelStyrke);
                        legemiddelTabell.settInn(pillerB, pillerB.returnNr());

                      } else if (legemiddelForm.equals("pille") && legemiddelType.equals("c")) {
                            PilleC pillerC = new PilleC(legemiddelNavn, legemiddelForm, legemiddelType, legemiddelPris, legemiddelAntallMengde, legemiddelVirkeStoff);
                            legemiddelTabell.settInn(pillerC, pillerC.returnNr());

                            }

              linje = scanFil.nextLine();

            } // Avslutter 2. while-lokke

              if (linje.contains("#")) {
                  linje = scanFil.nextLine();
              }

              // Legger inn leger.
              while(!linje.contains("#")) {

                if(linje.equals("")) {
                  linje = scanFil.nextLine();
                  break;
                }
                String [] legeHolder = linje.split(",");

                for (int i=0; i<legeHolder.length; i++) {
                  legeHolder[i] = legeHolder[i].trim();
                }

                legeNavn = legeHolder[0];
                legeAvtaleNummer = legeHolder[1];

                if(!legeAvtaleNummer.equals("0")) {
                  FastLege fastLegen = new FastLege (legeNavn, legeAvtaleNummer);
                  legeListe.settInnMinsteForan(fastLegen);
                } else {
                  Lege legen = new Lege(legeNavn);
                  legeListe.settInnMinsteForan(legen);
                  }

                  linje = scanFil.nextLine();

              } // Avslutter 3. while-lokke.


            if (linje.contains("#")) {
                linje = scanFil.nextLine();
            }

            // Legger inn resepter.
            while(!linje.contains("#")) {

              if(linje.equals("")) {
                linje = scanFil.nextLine();
                break;
              }

              String [] reseptHolder = linje.split(",");

              for (int i=0; i<reseptHolder.length; i++) {
                reseptHolder[i] = reseptHolder[i].trim();
              }

              reseptTeller = Integer.parseInt(reseptHolder[0]);
              reseptFarge = reseptHolder[1];
              reseptPersonNr = Integer.parseInt(reseptHolder[2]);
              reseptLegeNavn = reseptHolder[3];
              reseptLegemiddelNummer = Integer.parseInt(reseptHolder[4]);
              reit = Integer.parseInt(reseptHolder[5]);

              Legemiddel legemiddelet;

                if(pasientTabell.finnObjekt(reseptPersonNr) != null) {
                  pasientNavn = pasientTabell.finnObjekt(reseptPersonNr).toString();
                    if(legemiddelTabell.finnObjekt(reseptLegemiddelNummer) != null){
                      legemiddelet = (Legemiddel)legemiddelTabell.finnObjekt(reseptLegemiddelNummer);
                      if(legemiddelet instanceof MiksB) {
                        antVaneDanResepter++;
                      } else if (legemiddelet instanceof PilleB) {
                        antVaneDanResepter++;
                      }
                      Resept resepten = new Resept(legemiddelet, reseptLegeNavn, reseptPersonNr, reseptLegemiddelNummer, reit, reseptFarge);
                      Object o = pasientTabell.finnObjekt(reseptPersonNr);
                      Pasient p = (Pasient) o;
                      reseptene.leggTil(resepten);
                      p.nyResept(resepten);

                }
            }
            linje = scanFil.nextLine();
            }
             // Avslutter 4. while-lokke.
             if(linje.equals("")) {
               linje = scanFil.nextLine();
             }

             if(linje.equals("# Slutt")) {
            break;
            }
            } // Abslutter 1. while-lokke.


  } // Avslutter metoden lesFrafil.

  // Metode for aa skrive ut all informasjon.
  public static void skrivUtAlt() {

    // Skriver ut alle pasienter.
    Iterator<Pasient> iter = pasientTabell.iterator();

    System.out.println("-----------------------------------");
    System.out.println("Oversikt over alle pasienter");
    System.out.println("-----------------------------------");

    while(iter.hasNext()) {
    iter.next().info();
    }

    // Skriver ut legemidler.
    Iterator<Legemiddel> iter2 = legemiddelTabell.iterator();

    System.out.println("-----------------------------------");
    System.out.println("Oversikt over alle legemidler");
    System.out.println("-----------------------------------");
    while(iter2.hasNext()) {
    System.out.println(iter2.next().info());
    }

    // Skriver ut alle leger.
    Iterator<Lege> iter3 = legeListe.iterator();

    System.out.println("-----------------------------------");
    System.out.println("Oversikt over alle leger \n   (Sortert paa navn)");
    System.out.println("-----------------------------------");

    while(iter3.hasNext()) {
    System.out.println(iter3.next().info());
    }

    // Skriver ut alle resepter.   Denne fungerer ikke.
    Iterator<Pasient> iter4 = pasientTabell.iterator();

    System.out.println("-----------------------------------");
    System.out.println("Oversikt over alle resepter");
    System.out.println("-----------------------------------");

    while(iter4.hasNext()) {
    iter4.next().skrivUtResepter();
  }

} // Avslutter skrivUtAlt.

} // Avslutter Oblig 7.

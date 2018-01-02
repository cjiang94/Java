// importerer diverse pakker fra .util for senere bruk i programmet.
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class BilUtsalg {
  public static void main(String[] args) throws Exception{ // Bruker throws Exception fordi vi skal lese fra en fil.


    // Oppretter en Scanner som skal lese filen, og samtidig en ArrayList som skal ta inn objekter av typen Bil.
    Scanner in = new Scanner(System.in);
    ArrayList<Bil> biler = new ArrayList<Bil>();

    // Spor bruker hvilken fil de vil lese i fra, og tar inn filen fra terminal, og leser den med Scanner.
    System.out.println ("Hvilken fil vil du at systemet skal lese i fra?");
    File fil = new File(in.nextLine());
    Scanner aktFil = new Scanner(fil);

    //Oppretter en String-array som leser inn informasjon om bilene og lagrer det i hver sin array.
    String[] info;

    // Her leser vi linjene ved bruk av split og setter hver informasjon inn i hver sin egen array.
    while(aktFil.hasNextLine()) {
      String linje = aktFil.nextLine();
      info = linje.split(" ");
      // Alle biler har en "biltype" og "regNr", men det varierer paa om de har noe mer bak. Array'et vil selv legge til nye plasser om det trengs.
      String typeBil = info[0];
      String regNr = info[1];

      // ulike if, else-if setninger for hva slags type bil vi leser. Er det ekstra info om bilen, vil array'et automatisk lage ekstra plass, og det leses inn.
      if(typeBil.equalsIgnoreCase("Bil")) {
        biler.add(new Bil (regNr));
      } else if(typeBil.equalsIgnoreCase("El")){
        int kW = Integer.parseInt(info[2]);
        biler.add(new ELBil(regNr, kW));
        } else if(typeBil.equalsIgnoreCase("Fossil")){
          double utslipp = Double.parseDouble(info[2]);
          biler.add(new FossilBil(regNr, utslipp));
          } else if(typeBil.equalsIgnoreCase("Lastebil")){
            double utslipp = Double.parseDouble(info[2]);
            double nyttevekt = Double.parseDouble(info[3]);
            biler.add(new Lastebil(regNr, utslipp, nyttevekt));
            } else if(typeBil.equalsIgnoreCase("Personfossilbil")){
              double utslipp = Double.parseDouble(info[2]);
              int passasjer = Integer.parseInt(info[3]);
              biler.add(new PersonBil(regNr, utslipp, passasjer));
          }
      } // avslutter while-lokken

      // Skriver kun ut informasjonen for personbiler.
      for(Bil b : biler) {
        if(b instanceof PersonBil){
          System.out.print(b.toString());
        }
      }
  } // avslutter main-klassen
} // avslutter klassen

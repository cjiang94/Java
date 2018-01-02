// Lager en klasse kalt Kjaeledyr.
public class Kjaeledyr {

  // Lager private variabler.
  private final int maxEnergy = 100;
  private final int maxKilo = 120;
  private int startKilo = 60;
  private int startBody = 20;
  private String navn;
  private int kilo;
  private int energy;

  // Lager en konstruktor.
  public Kjaeledyr (String navn){
  this.navn = navn;
  energy = maxEnergy;
  kilo = startKilo;


  }
  // true = lever, false = dod. Lager en boolean som dreper kjaeledyret om den blir matet for mye.
  public boolean Food (int kilo) {
    this.kilo = kilo + this.kilo;
    // Lager en if-setning som dreper kjaeledyret.
    if (this.kilo > maxKilo){
      System.out.println ("\n\n\n\n");
      System.out.println (navn +" ble en veldig feit edderkopp og dode som en fettklump. Det var synd :(");
      return false;
    }

    // Lager en else-if-setning som skjer om kjaeledyret ikke har nok energy.
    else if (energy < 30) {
      System.out.println ("\n\n\n\n");
      System.out.println (navn + " orker ikke aa spise, prov aa hvil henne forst! :)");
      return true;
    }

    // Lager en else hvor kjaeledyret er fornoyd for aa ha blitt matet.
    else{
      System.out.println ("\n\n\n\n");
      System.out.println (navn + " smiler og er fornoyd! :)");
      energy = energy - 30;
      return true;
    }
  }

  // Lager en metode hvor kjaeledyret trener.
  public void Train () {
    // Kjaeledyret faar bare trent om energinivaaet er over 40.
    if (energy - 40 > 0 && kilo - 30 > 0) {
      System.out.println ("\n\n\n\n");
      System.out.println (navn + " har naa trent kneboy og er kjempefit, men meget sliten...");
      energy = energy - 40;
      kilo = kilo - 30;
    }

    // Hvis energinivaaet ikke er over 40, saa orker ikke kjaeledyret aa trene.
    else {
      System.out.println ("\n\n\n\n");
      System.out.println ("Beklager, men " + navn + " er for sliten og liten til aa trene. Prov aa hvil henne!");
    }
  }

  // Lager en metode hvor kjaeledyret hviler.
  public void Rest () {
    // Kjaeledyret hviler og energinivaaet plusses med 30.
    if (energy+30 < maxEnergy){
    energy = energy + 30;
    }

    // Kjaeledyret vil hvile fullt ut om det er mindre enn 30 for det er fullt energinivaa.
    else {
    energy = maxEnergy;
    }
  }

  // Lager en metode som returnerer kilo.
  public int getKilo() {
    return kilo;
  }

  // Lager en metode som returnerer energy.
  public int getEnergy() {
    return energy;
  }

  // Lager en metode som returnerer navn.
  public String getName() {
    return navn;
  }

}

// Lager en klasse kalt Bil.
public class Bil {

  // Lager private varianler som bare leses i klassen Bil.
  private int kilometerStand = 0;
  private double maxTank = 0;
  private double bilTank = 500;
  private int literPerKm = 0;

  // Konstruktor for aa lage bilen.
  public Bil (double maxTank, int literPerKm) {
    this.maxTank = maxTank;
    this.literPerKm = literPerKm;
  }

  // Lager en metode som heter "kjortTur".
  public void kjorTur (int km) {
    // En if-setning som sier at du ikke kan kjore om du ikke har nok bensin.
    if (bilTank < (literPerKm*km)) {
      System.out.println("\nDu har dessverre ikke nok bensin til aa kjore saa langt.");
    }

    // Ellers kjorer bilen og regner ut ny bensintank, samt plusser paa kilometerStand.
    else {
    bilTank = bilTank - (literPerKm*km);
    kilometerStand = kilometerStand + km;
    }

  }

  // Lager en metode som heter "fyllTank".
  public void fyllTank (double liter) {
    // En if-setning som ikke lar deg fylle paa bensin om du har nok bensin fra for av.
    if (liter>(maxTank-bilTank)) {
      System.out.println ("\nTanken din er ikke stor nok. Prov igjen.");
    }

    // Gir en tilbakemelding paa at det ikke gaar ann aa fylle paa negativ bensin.
    else if (liter < 0) {
      System.out.println ("\nDu kan ikke fylle paa negativ bensin. Prov igjen.");
    }

    // Her fyller man paa bensin og hvor mange liter man fyller paa blir lagt til i bilTank.
    else {
      bilTank = bilTank + liter;
    }

    }

  // Lager en metode kalt "hentMaksDistanse" som returnerer maksdistansen.
  public double hentMaksDistanse () {
    return bilTank/literPerKm;
  }

  // Lager en metode kalt "hentKilometerstand" som returnerer kilometerStand.
  public int hentKilometerstand () {
    return kilometerStand;
  }

  // Lager en metode kalt "hentBilTank" som returnerer bensin i bilen.
  public double hentBilTank () {
    return bilTank;
  }

  // Lager en metode kalt "hentMaxTank" som returnerer max bensintank paa bilen.
  public double hentMaxTank () {
    return maxTank;
  }

}

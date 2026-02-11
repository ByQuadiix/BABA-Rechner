package Backend.Einheiten;

public class Einheit {

    public String[] Einheiten;

    protected Double[] Faktoren;


    public String[] getEinheiten() {
        return Einheiten;
    }

    public Double[] getFaktoren() {
        return Faktoren;
    }

    public double rechnen(double input, int index_von, int index_zu) {

        double fVon = Faktoren[index_von];
        double fZu = Faktoren[index_zu];

        double referenz = input / fVon;    // in Meter umrechnen
        double ergebnis = referenz * fZu;  // von Meter in Ziel-Einheit

        System.out.println("DEBUG: " + input + " " + Einheiten[index_von] + " = " + ergebnis + " " + Einheiten[index_zu]);
        return ergebnis;

    }


}

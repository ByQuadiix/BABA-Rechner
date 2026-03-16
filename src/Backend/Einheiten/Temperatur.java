/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend.Einheiten;

/**
 *
 * @author ByQuadiix
 * Nutzt eine eigene Rechenmethode, weil Temperatur mit Offsets arbeitet.
 */
public class Temperatur extends Einheit {

    public Temperatur() {
        Einheiten = new String[]{
                "°C", "°F", "K", "°R"
        };

        // Dummy-Werte, da diese Klasse nicht mit Faktoren rechnet
        Faktoren = new Double[]{
                1.0, 1.0, 1.0, 1.0
        };
    }

    // Erst in Celsius umrechnen, dann in die Ziel-Einheit
    @Override
    public double rechnen(double input, int index_von, int index_zu) {
        double celsius = zuCelsius(input, index_von);
        double ergebnis = vonCelsius(celsius, index_zu);

        System.out.println("DEBUG: " + input + " " + Einheiten[index_von] +
                          " = " + ergebnis + " " + Einheiten[index_zu]);

        return ergebnis;
    }

    // Rechnet den Wert nach Celsius um
    private double zuCelsius(double wert, int index) {
        switch (index) {
            case 0:
                return wert;

            case 1:
                return (wert - 32.0) / 1.8;

            case 2:
                return wert - 273.15;

            case 3:
                return (wert - 491.67) / 1.8;

            default:
                System.out.println("FEHLER: Unbekannte Temperatur-Einheit!");
                return 0.0;
        }
    }

    // Rechnet von Celsius in die Ziel-Einheit um
    private double vonCelsius(double celsius, int index) {
        switch (index) {
            case 0:
                return celsius;

            case 1:
                return celsius * 1.8 + 32.0;

            case 2:
                return celsius + 273.15;

            case 3:
                return celsius * 1.8 + 491.67;

            default:
                System.out.println("FEHLER: Unbekannte Temperatur-Einheit!");
                return 0.0;
        }
    }
}



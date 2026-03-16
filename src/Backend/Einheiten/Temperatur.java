/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend.Einheiten;

/**
 *
 * @author ByQuadiix
 * ❌ NUTZT NICHT DIE STANDARD-RECHENMETHODE!
 *
 * Grund: Temperatur-Umrechnungen benötigen OFFSETS, nicht nur Faktoren!
 * Beispiel: °F = °C × 1.8 + 32  ← Das "+32" ist der Offset
 *
 * Deshalb: Eigene rechnen() Methode überschrieben!
 */
public class Temperatur extends Einheit {

    public Temperatur() {
        // Einheiten-Namen
        Einheiten = new String[]{
                "°C", "°F", "K", "°R"
        };

        // ACHTUNG: Faktoren werden hier NICHT für Umrechnung verwendet!
        // Sie sind nur Platzhalter, damit die Basis-Klasse nicht abstürzt
        Faktoren = new Double[]{
                1.0, 1.0, 1.0, 1.0  // Dummy-Werte
        };
    }

    /**
     * EIGENE RECHENMETHODE für Temperatur!
     * Überschreibt die Standard-Methode aus Einheit.java
     *
     * Strategie:
     * 1. Eingabe-Temperatur in Celsius umrechnen
     * 2. Von Celsius in die Ziel-Einheit umrechnen
     */
    @Override
    public double rechnen(double input, int index_von, int index_zu) {
        // Schritt 1: Eingabe in Celsius umrechnen
        double celsius = zuCelsius(input, index_von);

        // Schritt 2: Von Celsius in Zieleinheit
        double ergebnis = vonCelsius(celsius, index_zu);

        // Debug-Ausgabe
        System.out.println("DEBUG: " + input + " " + Einheiten[index_von] +
                          " = " + ergebnis + " " + Einheiten[index_zu]);

        return ergebnis;
    }

    /**
     * Rechnet eine Temperatur in Celsius um
     * @param wert Die Temperatur
     * @param index Index der Einheit (0=°C, 1=°F, 2=K, 3=°R)
     * @return Temperatur in Celsius
     */
    private double zuCelsius(double wert, int index) {
        switch (index) {
            case 0:  // °C → °C (keine Umrechnung)
                return wert;

            case 1:  // °F → °C
                // Formel: °C = (°F - 32) / 1.8
                return (wert - 32.0) / 1.8;

            case 2:  // K → °C
                // Formel: °C = K - 273.15
                return wert - 273.15;

            case 3:  // °R → °C (Rankine)
                // Formel: °C = (°R - 491.67) / 1.8
                return (wert - 491.67) / 1.8;

            default:
                System.out.println("FEHLER: Unbekannte Temperatur-Einheit!");
                return 0.0;
        }
    }

    /**
     * Rechnet von Celsius in eine andere Einheit um
     * @param celsius Temperatur in Celsius
     * @param index Index der Ziel-Einheit (0=°C, 1=°F, 2=K, 3=°R)
     * @return Temperatur in der Ziel-Einheit
     */
    private double vonCelsius(double celsius, int index) {
        switch (index) {
            case 0:  // °C → °C (keine Umrechnung)
                return celsius;

            case 1:  // °C → °F
                // Formel: °F = °C × 1.8 + 32
                return celsius * 1.8 + 32.0;

            case 2:  // °C → K
                // Formel: K = °C + 273.15
                return celsius + 273.15;

            case 3:  // °C → °R (Rankine)
                // Formel: °R = °C × 1.8 + 491.67
                return celsius * 1.8 + 491.67;

            default:
                System.out.println("FEHLER: Unbekannte Temperatur-Einheit!");
                return 0.0;
        }
    }
}

/*
 * ERKLÄRUNG DER TEMPERATUR-SKALEN:
 *
 * °C (Celsius):
 * - Gefrierpunkt Wasser: 0°C
 * - Siedepunkt Wasser: 100°C
 * - Basis: Metrisches System
 *
 * °F (Fahrenheit):
 * - Gefrierpunkt Wasser: 32°F
 * - Siedepunkt Wasser: 212°F
 * - Basis: US-System
 * - Umrechnung: °F = °C × 1.8 + 32
 *
 * K (Kelvin):
 * - Absoluter Nullpunkt: 0 K (= -273.15°C)
 * - Gefrierpunkt Wasser: 273.15 K
 * - Basis: Wissenschaft (SI-Einheit)
 * - Umrechnung: K = °C + 273.15
 *
 * °R (Rankine):
 * - Absoluter Nullpunkt: 0°R
 * - Gefrierpunkt Wasser: 491.67°R
 * - Basis: US-System (absolut)
 * - Umrechnung: °R = °F + 459.67 = °C × 1.8 + 491.67
 *
 * WARUM BRAUCHT MAN EINE EIGENE METHODE?
 *
 * Standard-Methode macht: ergebnis = (input / faktor_von) × faktor_zu
 * Das funktioniert nur für lineare Umrechnungen OHNE Offset!
 *
 * Temperatur hat aber Offsets:
 * °F = °C × 1.8 + 32  ← "+32" ist der Offset!
 *
 * Deshalb können wir nicht einfach Faktoren verwenden, sondern
 * müssen für jede Kombination die richtige Formel anwenden.
 */


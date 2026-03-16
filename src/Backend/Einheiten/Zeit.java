/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend.Einheiten;

/**
 *
 * @author ByQuadiix
 * ⚠️ ACHTUNG: Monate und Jahre variieren!
 * Hier vereinfacht:
 * - 1 Monat = 30 Tage (durchschnittlich)
 * - 1 Jahr = 365 Tage (ohne Schaltjahr)
 * ⚠️ BENÖTIGT EIGENE RECHENMETHODE für exakte Kalenderberechnungen
 * Hier aber: ✅ NUTZT STANDARD-RECHENMETHODE (vereinfacht)
 */
public class Zeit extends Einheit {

    public Zeit() {
        Einheiten = new String[]{
                "ns", "µs", "ms", "s", "min", "h",
                "d", "w", "Monat", "Jahr", "Jahrzehnt", "Jahrhundert", "Jahrtausend"
        };

        // Basis: 1 s (Sekunde)
        Faktoren = new Double[]{
                1000000000.0,       // ns (Nanosekunde)
                1000000.0,          // µs (Mikrosekunde)
                1000.0,             // ms (Millisekunde)
                1.0,                // s (Sekunde) - BASIS
                0.0166666667,       // min (Minute = 60 s)
                0.000277778,        // h (Stunde = 3600 s)
                0.0000115741,       // d (Tag = 86400 s)
                0.00000165344,      // w (Woche = 7 Tage)
                3.8052e-7,          // Monat (≈ 30 Tage, vereinfacht!)
                3.171e-8,           // Jahr (≈ 365 Tage, vereinfacht!)
                3.171e-9,           // Jahrzehnt (10 Jahre)
                3.171e-10,          // Jahrhundert (100 Jahre)
                3.171e-11,          // Jahrtausend (1000 Jahre)
        };
    }
}

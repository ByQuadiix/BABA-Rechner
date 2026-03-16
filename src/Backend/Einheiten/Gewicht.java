/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend.Einheiten;

/**
 *
 * @author ByQuadiix
 * ✅ NUTZT STANDARD-RECHENMETHODE (lineare Umrechnung)
 */
public class Gewicht extends Einheit {

    public Gewicht() {
        Einheiten = new String[]{
                "µg", "mg", "g", "kg", "t", "oz", "lb"
        };

        // Basis: 1 kg (Kilogramm)
        Faktoren = new Double[]{
                1000000000.0,       // µg (Mikrogramm)
                1000000.0,          // mg (Milligramm)
                1000.0,             // g (Gramm)
                1.0,                // kg (Kilogramm) - BASIS
                0.001,              // t (Tonne = 1000 kg)
                35.27396195,        // oz (Unze / Ounce)
                2.20462262,         // lb (Pfund / Pound)
        };
    }
}

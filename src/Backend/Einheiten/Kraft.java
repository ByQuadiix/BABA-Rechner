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
public class Kraft extends Einheit {

    public Kraft() {
        Einheiten = new String[]{
                "mN", "N", "kN", "MN", "kp", "lbf"
        };

        // Basis: 1 N (Newton)
        Faktoren = new Double[]{
                1000.0,             // mN (Millinewton)
                1.0,                // N (Newton) - BASIS
                0.001,              // kN (Kilonewton)
                0.000001,           // MN (Meganewton)
                0.101971621,        // kp (Kilopond / Kilogramm-Kraft)
                0.224808943,        // lbf (Pound-force)
        };
    }
}

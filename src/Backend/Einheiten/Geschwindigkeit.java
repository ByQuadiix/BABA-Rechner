/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend.Einheiten;
/**
 *
 * @author ByQuadiix
 * Hier vereinfacht mit Mach 1 = 343 m/s (20°C auf Meereshöhe)
 */
public class Geschwindigkeit extends Einheit {

    public Geschwindigkeit() {
        Einheiten = new String[]{
                "m/s", "km/h", "Knoten", "mph", "Mach"
        };

        // Basis: 1 m/s (Meter pro Sekunde)
        Faktoren = new Double[]{
                1.0,                // m/s (Meter pro Sekunde) - BASIS
                3.6,                // km/h (Kilometer pro Stunde)
                1.94384,            // Knoten (Seemeile pro Stunde)
                2.23694,            // mph (Meilen pro Stunde)
                0.00291545,         // Mach (vereinfacht: Mach 1 ≈ 343 m/s bei 20°C)
        };
    }
}


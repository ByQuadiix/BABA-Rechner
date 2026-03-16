/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend.Einheiten;

/**
 *
 * @author ByQuadiix

 * ⚠️ HINWEIS: Nm³ (Normkubikmeter) ist temperatur-/druckabhängig
 * Hier vereinfacht: Nm³ ≈ m³ bei Standardbedingungen
 * ✅ NUTZT STANDARD-RECHENMETHODE (vereinfacht)
 */
public class Volumen extends Einheit {

    public Volumen() {
        Einheiten = new String[]{
                "mm³", "cm³/ml", "dm³/L", "m³", "hl",
                "fl oz", "cup", "pt", "qt", "gal", "bbl"
        };

        // Basis: 1 m³ (Kubikmeter)
        Faktoren = new Double[]{
                1000000000.0,       // mm³ (Kubikmillimeter)
                1000000.0,          // cm³ / ml (Kubikzentimeter / Milliliter)
                1000.0,             // dm³ / L (Kubikdezimeter / Liter)
                1.0,                // m³ (Kubikmeter) - BASIS
                10.0,               // hl (Hektoliter = 100 Liter)
                33814.0227,         // fl oz (Fluid Ounce US)
                4226.75284,         // cup (Tasse US)
                2113.37642,         // pt (Pint US)
                1056.68821,         // qt (Quart US)
                264.172052,         // gal (Gallone US)
                6.28981077,         // bbl (Barrel Öl, 42 Gallonen)
        };
    }
}


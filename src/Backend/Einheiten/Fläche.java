/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend.Einheiten;

/**
 *
 * @author ByQuadiix
 */
public class Fläche extends Einheit {

    public Fläche() {
        Einheiten = new String[]{
                "mm²", "cm²", "dm²", "m²", "a", "ha", "km²",
                "sq in", "sq ft", "sq yd", "acre", "sq mi", "barn"
        };

        // Basis: 1 m² (Quadratmeter)
        Faktoren = new Double[]{
                1000000.0,          // mm² (Quadratmillimeter)
                10000.0,            // cm² (Quadratzentimeter)
                100.0,              // dm² (Quadratdezimeter)
                1.0,                // m² (Quadratmeter) - BASIS
                0.01,               // a (Ar = 100 m²)
                0.0001,             // ha (Hektar = 10.000 m²)
                0.000001,           // km² (Quadratkilometer)
                1550.0031,          // sq in (Square Inch)
                10.763910417,       // sq ft (Square Foot)
                1.19599005,         // sq yd (Square Yard)
                0.000247105,        // acre (Acker)
                3.861e-7,           // sq mi (Square Mile)
                1e28                // barn (Kernphysik, sehr klein: 10^-28 m²)
        };
    }
}

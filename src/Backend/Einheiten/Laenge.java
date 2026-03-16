/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend.Einheiten;

/**
 *
 * @author ByQuadiix
 */
public class Laenge extends Einheit {

    public Laenge() {
        Einheiten = new String[]{
                "µm", "mm", "cm", "zoll", "dm", "fuß", "yard", "m", "km", "meile", "seemeile", "lichtjahre", "parsec"
        };

        Faktoren = new Double[]{
                1000000.0,          // µm
                1000.0,             // mm
                100.0,              // cm
                39.3701,            // zoll
                10.0,               // dm
                3.28084,            // fuß
                1.093613888889,     // yard
                1.0,                // m (Basis)
                0.001,              // km
                0.000621371,        // meile
                0.000539957,        // seemeile
                1.057e-16,          // lichtjahre
                3.24078e-17         // parsec
        };
    }


}

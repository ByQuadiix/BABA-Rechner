/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend.Einheiten;

/**
 *
 * @author ByQuadiix
 */
public class Laenge {


    private String[] Einheiten = {"µm", "mm", "cm", "dm", "m", "km", "zoll", "fuß", "yard", "meile", "seemeile", "lichtjahre", "parsec"};
    private Double[] Faktoren = {1000000.0, 1000.0, 100.0, 10.0, 1.0, 0.001, 39.3701, 3.28084, 1.093613888889, 0.000621371, 0.000539957, 1.057e-16, 3.24078e-17};

    public String[] getEinheiten() {
        return Einheiten;
    }

    public Double[] getFaktoren() {
        return Faktoren;
    }

    public Laenge() {
    }

    private void rechnen(double input, int index_von, int index_zu){

        //============================= Umrechnung zu Referenz ==============================\\
        if(Faktoren[index_von] > 4){
            double referenz = input * Faktoren[index_von];
        } else if (Faktoren[index_von] < 4) {
            double referenz = input / Faktoren[index_von];
        } else {
            double referenz = input;
        }

        //===================== Umrechnung von Referenz zu Ziel ==============================\\
        if(index_zu > 4){
            double ergebnis = input / Faktoren[index_zu];
        } else if (index_zu < 4) {
            double ergebnis = input * Faktoren[index_zu];
        } else {
            double ergebnis = input;
        }


    }

    
}

package Backend;

import Backend.Einheiten.*;

public class Rechenlogik {
    private int Einheit1;
    private int Einheit2;
    private double Eingabe;
    static String temp_Einheit;


    public Rechenlogik() {
    }



    public double rechnen(double input, int index_von, int index_zu){
        double ergebnis = 0;
        System.out.println("DEBUG:");
        System.out.println(this.temp_Einheit);

        // Switch-Case für alle Einheiten
        switch (temp_Einheit){
            case "Länge":
                ergebnis = Laenge.rechnen(input, index_von, index_zu);
                break;
            case "Fläche":
                ergebnis = Flaeche.rechnen(input, index_von, index_zu);
                break;
            case "Geschwindigkeit":
                ergebnis = Geschwindigkeit.rechnen(input, index_von, index_zu);
                break;
            case "Gewicht":
                ergebnis = Gewicht.rechnen(input, index_von, index_zu);
                break;
            case "Kraft":
                ergebnis = Kraft.rechnen(input, index_von, index_zu);
                break;
            case "Volumen":
                ergebnis = Volumen.rechnen(input, index_von, index_zu);
                break;
            case "Zeit":
                ergebnis = Zeit.rechnen(input, index_von, index_zu);
                break;
            default:
                System.out.println("FEHLER: Unbekannte Einheit!");
                break;
        }

        return ergebnis;
    }




    //================================================= Einheiten ===============================================\\
    //============================= Objekte ===================================\\
    Laenge Laenge = new Laenge();
    Fläche Flaeche = new Fläche();
    Geschwindigkeit Geschwindigkeit = new Geschwindigkeit();
    Gewicht Gewicht = new Gewicht();
    Kraft Kraft = new Kraft();
    Volumen Volumen = new Volumen();
    Zeit Zeit = new Zeit();
    Temperatur TemperaturRechner = new Temperatur();  // ❌ Nutzt EIGENE Rechenmethode!





    //============================= Methoden ==============================\\
    public String[] getEinheiten(String Einheit){
        String[] Einheiten = null;
        this.temp_Einheit = Einheit;

        // Switch-Case für alle Einheiten
        switch (Einheit){
            case "Länge":
                Einheiten = Laenge.getEinheiten();
                break;
            case "Fläche":
                Einheiten = Flaeche.getEinheiten();
                break;
            case "Geschwindigkeit":
                Einheiten = Geschwindigkeit.getEinheiten();
                break;
            case "Gewicht":
                Einheiten = Gewicht.getEinheiten();
                break;
            case "Kraft":
                Einheiten = Kraft.getEinheiten();
                break;
            case "Volumen":
                Einheiten = Volumen.getEinheiten();
                break;
            case "Zeit":
                Einheiten = Zeit.getEinheiten();
                break;
            case "Temperatur":
                Einheiten = TemperaturRechner.getEinheiten();
                break;
            default:
                System.out.println("FEHLER: Unbekannte Einheit!");
                Einheiten = new String[]{"Fehler"};
                break;
        }

        for(int i = 0; i < Einheiten.length; i++){
            System.out.println(Einheiten[i]);
        }
        return Einheiten;
    }

}




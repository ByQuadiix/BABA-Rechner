package Backend;

import Backend.Einheiten.Laenge;

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
        switch (temp_Einheit){
            case "Länge":
                ergebnis = Laenge.rechnen(input, index_von, index_zu);
                break;
        }

        return ergebnis;
    }




    //================================================= Einheiten ===============================================\\
    //=============================Objekte===================================\\
    Laenge Laenge = new Laenge();





    //============================= Methoden ==============================\\
    public String[] getEinheiten(String Einheit){
        String[] Einheiten = null;
        this.temp_Einheit = Einheit;
        switch (Einheit){
            case "Länge":
                Einheiten = Laenge.getEinheiten();
                break;
        }

        for(int i = 0; i < Einheiten.length; i++){
            System.out.println(Einheiten[i]);
        }
        return Einheiten;
    }

}




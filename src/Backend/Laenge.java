/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

/**
 *
 * @author ByQuadiix
 */
public class Laenge {
private double[] Referenzwerte = {}; 
private double zahl1;

    public Laenge(double zahl1, double zahl2) {
        this.zahl1 = zahl1;
    }

    
    private double inputtoreferenz(double zahl, int eingabeindex){
        double temp_Ergebnis = zahl1 * eingabeindex;
        return temp_Ergebnis ;
    }

    
}





/*
Einheiten:
1. µm 1000000
2. mm 1000
3. cm 100
4. dm 10
5. m   Referenz 1
6. km 0,001

7. zoll 39,3701
8. fuß 3,28084
9. yard 1,093613888889
10. meile 0,000621371

11. seemeile 0,000539957

12. lichtjahre 1,057e-16
13. parsec 3,24078e-17
*/
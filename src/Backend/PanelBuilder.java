package Backend;

import javax.swing.*;
import java.awt.*;

public class PanelBuilder {
    private String Einheit;



Laenge Laenge = new Laenge();

    public String[] getEinheiten(String Einheit){
        String[] Einheiten = null;

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


    public JPanel BuildPanel(String[] Einheiten){
        JPanel Test = new JPanel();
        Test.setLayout(new GridLayout(3,1));
        JLabel ergebnis = new JLabel("Ergebnis");


        JPanel EinAusgabe = new JPanel();
        JLabel eingabe = new JLabel("Eingabe:");
        EinAusgabe.add(eingabe);
        JTextField input = new JTextField(10);
        EinAusgabe.add(input);

        JPanel Auswahl = new JPanel();
        Auswahl.setLayout(new GridLayout(1,4));
        JComboBox Einheit1 = new JComboBox(Einheiten);
        JLabel text = new JLabel("Umwandeln:");
        JComboBox Einheit2 = new JComboBox(Einheiten);
        JLabel zu = new JLabel("zu");
        Auswahl.add(text);
        Auswahl.add(Einheit1);
        Auswahl.add(zu);
        Auswahl.add(Einheit2);

        // Komponenten in Panel einfügen
        Test.add(ergebnis);
        Test.add(EinAusgabe);
        Test.add(Auswahl);

        return Test;
    }
}

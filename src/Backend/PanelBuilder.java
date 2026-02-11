package Backend;

import Backend.Einheiten.Laenge;

import javax.swing.*;
import java.awt.*;

public class PanelBuilder {
Rechenlogik Rechner = new Rechenlogik();



    public JPanel BuildPanel(String[] Einheiten){
        //============================= Panel Aufbau ==============================\\
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1));

            //============================= Überschrift ==============================\\
            JLabel Überschrift = new JLabel("Einheitenrechner");

            //============================= Ein- & Ausgabe mit Auswahl ==============================\\
            JPanel Rechner = new JPanel();
            Rechner.setLayout(new GridLayout(2, 1));

                //============================= Eingabe & Ausgabe ==============================\\
                JPanel EingabeUndAusgabe = new JPanel();
                EingabeUndAusgabe.setLayout(new GridLayout(3, 1));

                    //============================= Eingabe ==============================\\
                    JTextField Eingabe = new JTextField("0");

                    //============================= Umrechnen ==============================\\
                    JButton Umrechnen = new JButton("Umrechnen");

                    //============================= Ausgabe ==============================\\
                    JTextField Ausgabe = new JTextField("0");
                    Ausgabe.setEditable(false);


                Umrechnen.addActionListener(e -> {
                    System.out.println("Umrechnen gedrückt");
                    double input = 0;
                    input = Double.parseDouble(Eingabe.getText());
                    try {
                        
                    } catch (Exception ex) {
                        System.out.println("Bitte Punkt statt komma nutzen");
                    }
                    System.out.println("Input: " + input);
                });
                EingabeUndAusgabe.add(Eingabe);
                EingabeUndAusgabe.add(Umrechnen);
                EingabeUndAusgabe.add(Ausgabe);

                //============================= Auswahl ==============================\\
                JPanel Auswahl = new JPanel();
                Auswahl.setLayout(new GridLayout(1, 3));

                    //============================= Von ==============================\\
                    JComboBox<String> Von = new JComboBox<>(Einheiten);

                    //============================= Leeres Panel ==============================\\
                    JLabel zuText = new JLabel("zu");

                    //============================= Zu ==============================\\
                    JComboBox<String> Zu = new JComboBox<>(Einheiten);

                Auswahl.add(Von);
                Auswahl.add(zuText);
                Auswahl.add(Zu);

            Rechner.add(EingabeUndAusgabe);
            Rechner.add(Auswahl);

        panel.add(Überschrift);
        panel.add(Rechner);

        return panel;
    }


    private void rechnen(double input, int index_von, int index_zu){

    Rechner.rechnen(input, index_von, index_zu);
    }


}

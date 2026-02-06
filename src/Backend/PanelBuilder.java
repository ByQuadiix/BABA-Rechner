package Backend;

import Backend.Einheiten.Laenge;

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

    private void rechnen(){

    }


}

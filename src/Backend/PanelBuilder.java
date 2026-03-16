package Backend;

import javax.swing.*;
import java.awt.*;

public class PanelBuilder extends Rechenlogik {
Rechenlogik Rechner = new Rechenlogik();

    // ============================= Einfache Farben ==============================\\
    // Nur 2 Grundfarben: Hintergrund und Button-Farbe
    private final Color HINTERGRUND = new Color(230, 230, 250);  // Helles Lila
    private final Color BUTTON_FARBE = new Color(100, 100, 200); // Dunkles Lila


    public JPanel BuildPanel(String[] Einheiten){
        return BuildPanel(Einheiten, null);
    }

    public JPanel BuildPanel(String[] Einheiten, Runnable onBack){
        //============================= Hauptpanel (GridLayout = Gitter) ==============================\\
        // GridLayout teilt Panel in gleich große Bereiche auf
        // GridLayout(Zeilen, Spalten)
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1, 10, 10));  // 4 Zeilen, 1 Spalte, 10px Abstand
        panel.setBackground(HINTERGRUND);  // Hintergrundfarbe setzen

            //============================= Überschrift ==============================\\
            // Einfaches Label mit Text
            JLabel Ueberschrift = new JLabel("Einheitenrechner");
            Ueberschrift.setFont(new Font("Arial", Font.BOLD, 30));  // Schrift: Arial, fett, 30px
            Ueberschrift.setHorizontalAlignment(SwingConstants.CENTER);  // Text zentrieren

            //============================= Dropdown-Bereich ==============================\\
            // Panel für die beiden Dropdowns (Von -> Zu)
            JPanel Auswahl = new JPanel();
            Auswahl.setLayout(new GridLayout(1, 3, 10, 0));  // 1 Zeile, 3 Spalten
            Auswahl.setBackground(HINTERGRUND);

                //============================= Von Dropdown ==============================\\
                // ComboBox = Dropdown-Menü
                JComboBox<String> Von = new JComboBox<>(Einheiten);
                Von.setFont(new Font("Arial", Font.PLAIN, 18));  // Schrift setzen

                //============================= Pfeil ==============================\\
                // Label mit Pfeil zwischen den Dropdowns
                JLabel Pfeil = new JLabel("->", SwingConstants.CENTER);
                Pfeil.setFont(new Font("Arial", Font.BOLD, 20));

                //============================= Zu Dropdown ==============================\\
                JComboBox<String> Zu = new JComboBox<>(Einheiten);
                Zu.setFont(new Font("Arial", Font.PLAIN, 18));

            // Dropdowns zum Auswahl-Panel hinzufügen
            Auswahl.add(Von);
            Auswahl.add(Pfeil);
            Auswahl.add(Zu);

            //============================= Rechner-Bereich ==============================\\
            // Panel für Eingabe, Button und Ausgabe
            JPanel Rechner = new JPanel();
            Rechner.setLayout(new GridLayout(3, 1, 10, 10));  // 3 Zeilen, 10px Abstand
            Rechner.setBackground(HINTERGRUND);

                //============================= Eingabe-Feld ==============================\\
                // TextField = Eingabefeld für Text/Zahlen
                JTextField Eingabe = new JTextField("0");
                Eingabe.setFont(new Font("Arial", Font.PLAIN, 22));
                Eingabe.setHorizontalAlignment(JTextField.CENTER);  // Text mittig

                //============================= Umrechnen-Button ==============================\\
                // Button = Klickbarer Button
                JButton Umrechnen = new JButton("Umrechnen");
                Umrechnen.setFont(new Font("Arial", Font.BOLD, 20));
                Umrechnen.setBackground(BUTTON_FARBE);  // Button-Farbe
                Umrechnen.setForeground(Color.WHITE);   // Text-Farbe weiß

                //============================= Ausgabe-Feld ==============================\\
                // TextField für Ergebnis (nicht editierbar)
                JTextField Ausgabe = new JTextField("0");
                Ausgabe.setEditable(false);  // Nutzer kann nicht reinschreiben
                Ausgabe.setFont(new Font("Arial", Font.BOLD, 22));
                Ausgabe.setHorizontalAlignment(JTextField.CENTER);
                Ausgabe.setBackground(Color.LIGHT_GRAY);  // Grauer Hintergrund

            // Komponenten zum Rechner-Panel hinzufügen
            Rechner.add(Eingabe);
            Rechner.add(Umrechnen);
            Rechner.add(Ausgabe);

            JButton Zurueck = new JButton("Zurueck zum Hauptmenue");
            Zurueck.setFont(new Font("Arial", Font.BOLD, 16));
            Zurueck.setBackground(BUTTON_FARBE);
            Zurueck.setForeground(Color.WHITE);

        // Alle 3 Bereiche zum Hauptpanel hinzufügen
        panel.add(Ueberschrift);  // Zeile 1: Überschrift
        panel.add(Auswahl);       // Zeile 2: Dropdowns
        panel.add(Rechner);       // Zeile 3: Eingabe/Button/Ausgabe
        panel.add(Zurueck);       // Zeile 4: Zurueck-Button




        //================= Action Listener ===================\\
        Umrechnen.addActionListener(e -> {
            System.out.println("Umrechnen gedrückt");
            double input = 0;
            input = Double.parseDouble(Eingabe.getText());
            int index1 = Von.getSelectedIndex();
            int index2 = Zu.getSelectedIndex();


            Ausgabe.setText(Double.toString(rechnen(input,index1, index2 )));

            System.out.println("Input: " + input);
        });

        Zurueck.addActionListener(e -> {
            if (onBack != null) {
                onBack.run();
            }
        });



        return panel;
    }



//============================= Rechen Methode ==============================\\
public double rechnen(double input, int index_von, int index_zu){


        return Rechner.rechnen(input, index_von, index_zu);
    }


}

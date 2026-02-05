import javax.swing.*;
import java.awt.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
/**
 *
 * @author ByQuadiix
 */


public static JFrame window = new JFrame();

void main() {
    window.setDefaultCloseOperation(EXIT_ON_CLOSE);
    window.setSize(800, 600);
    window.setLocationRelativeTo(null);
    window.setLayout(new BorderLayout());


    //======================================FONTS============================================\\
    Font ueberschrift = new Font("Arial", Font.BOLD, 40);
    Font text = new Font("Sans Serif", Font.PLAIN, 25);


    // Hauptmenü //
    JPanel Hauptmenue = new JPanel();
    Hauptmenue.setLayout(new GridLayout(2, 1));

    JLabel titel = new JLabel("BABA Einheitenrechner");
    titel.setFont(ueberschrift);
    titel.setHorizontalAlignment(SwingConstants.CENTER);

    Hauptmenue.add(titel);


    JPanel Hauptmenue1 = new JPanel();
    Hauptmenue1.setLayout(new GridLayout(1, 3));
    Hauptmenue1.add(new JLabel("1"));
    Hauptmenue1.add(new JLabel("2"));
    Hauptmenue1.add(new JLabel("3"));

    Hauptmenue.add(Hauptmenue1);
    window.add(Hauptmenue);


    window.setVisible(true);

}


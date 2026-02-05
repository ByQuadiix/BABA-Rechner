import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
/**
 *
 * @author ByQuadiix
 */

public static JFrame window = new JFrame();

void main() {
    window.setDefaultCloseOperation(EXIT_ON_CLOSE);
    window.setSize(1000, 1000);
    window.setLocationRelativeTo(null);
    window.setLayout(new BorderLayout());

    //============================Universal Action Listener ==============================\\
    ActionListener BTNlistener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton source = (JButton) e.getSource();
            String text = source.getText();
            System.out.println(text);
            //JPanel newPanel = b.createTemplate(text);
            //update(newPanel);
        }

    };





    //======================================FONTS============================================\\
    Font ueberschrift = new Font("Arial", Font.BOLD, 40);
    Font text = new Font("Sans Serif", Font.PLAIN, 25);


    //======================================Hauptmenü=========================================\\
    JPanel mainMenu = new JPanel();
    mainMenu.setLayout(new GridLayout(3, 3));

    //=====Buttons=====\\
    JButton FlaecheBtn = new JButton();
    FlaecheBtn.setIcon(new ImageIcon("Assets/icon/area.png"));
    FlaecheBtn.setHorizontalAlignment(SwingConstants.CENTER);

    JButton GeschwindigkeitBtn = new JButton();
    GeschwindigkeitBtn.setIcon(new ImageIcon("Assets/icon/speed.png"));
    FlaecheBtn.setHorizontalAlignment(SwingConstants.CENTER);

    JButton GewichtBtn = new JButton();
    GewichtBtn.setHorizontalAlignment(SwingConstants.CENTER);
    GewichtBtn.setIcon(new ImageIcon("Assets/icon/weight.png"));

    JButton KraftBtn = new JButton();
    KraftBtn.setHorizontalAlignment(SwingConstants.CENTER);
    KraftBtn.setIcon(new ImageIcon("Assets/icon/force.png"));

    JButton LaengeBtn = new JButton();
    LaengeBtn.setHorizontalAlignment(SwingConstants.CENTER);
    LaengeBtn.setIcon(new ImageIcon("Assets/icon/length.png"));

    JButton VolumenBtn = new JButton();
    VolumenBtn.setHorizontalAlignment(SwingConstants.CENTER);
    VolumenBtn.setIcon(new ImageIcon("Assets/icon/volume.png"));

    JButton ZeitBtn = new JButton();
    ZeitBtn.setHorizontalAlignment(SwingConstants.CENTER);
    ZeitBtn.setIcon(new ImageIcon("Assets/icon/time.png"));

    mainMenu.add(FlaecheBtn);
    mainMenu.add(GeschwindigkeitBtn);
    mainMenu.add(GewichtBtn);
    mainMenu.add(KraftBtn);
    mainMenu.add(LaengeBtn);
    mainMenu.add(VolumenBtn);
    mainMenu.add(ZeitBtn);

    window.add(mainMenu);

    window.setVisible(true);

}

private static void update(JPanel newPanel) {
    SwingUtilities.invokeLater(() -> {
        window.getContentPane().removeAll();
        window.getContentPane().setLayout(new BorderLayout());
        window.getContentPane().add(newPanel, BorderLayout.CENTER);
        window.revalidate();
        window.repaint();
    });
}


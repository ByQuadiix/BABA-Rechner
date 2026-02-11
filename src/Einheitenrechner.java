import Backend.PanelBuilder;
import Backend.Rechenlogik;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author ByQuadiix
 */


// BABA = Berechnung Aller Basiseinheiten & Ableitungen


public static JFrame window = new JFrame();
private JFrame introFrame = new JFrame();
PanelBuilder Builder = new PanelBuilder();
Rechenlogik Rechenlogik = new Rechenlogik();


// KI generiert von ChatGPT, angepasst von ByQuadiix
private void switchtomain() {
    introFrame.dispose();
    window.setVisible(true);
}


void main() {
    window.setDefaultCloseOperation(EXIT_ON_CLOSE);
    window.setSize(1000, 1000);
    window.setLocationRelativeTo(null);
    window.setLayout(new BorderLayout());
    window.setResizable(false);


    //============================= Intro (KI generiert) ================================================\\
    JLabel Intro = new JLabel(new ImageIcon("Assets/intro(1).gif"));
    introFrame.add(Intro, BorderLayout.CENTER);
    introFrame.pack();
    introFrame.setLocationRelativeTo(null);
    introFrame.setVisible(true);
    Timer timer = new Timer(8000, e -> {
        switchtomain();
    });
    timer.setRepeats(false);
    timer.start();


    //============================Universal Action Listener ==============================\\
    ActionListener BTNlistener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton source = (JButton) e.getSource();
            String text = source.getName();
            System.out.println(text);
            JPanel newPanel = Builder.BuildPanel(Rechenlogik.getEinheiten(text));
            if (newPanel == null) {
                System.out.println("Fehler: Panel konnte nicht erstellt werden.");
                return;
            }

            update(newPanel);
        }

    };


    //======================================FONTS============================================\\
    Font ueberschrift = new Font("Arial", Font.BOLD, 40);
    Font text = new Font("Sans Serif", Font.PLAIN, 25);


    //======================================Title Panel=========================================\\
    JPanel Title = new JPanel();
    Title.setLayout(new BorderLayout());
    JLabel TitleTextPanel = new JLabel("Berechnung Aller Basiseinheiten & Ableitungen");
    TitleTextPanel.setHorizontalAlignment(SwingConstants.CENTER);
    TitleTextPanel.setFont(ueberschrift);
    Title.add(TitleTextPanel, BorderLayout.CENTER);


    //======================================Button Panel=========================================\\
    JPanel Buttons = new JPanel();
    Buttons.setLayout(new GridLayout(3, 3));

    //=====Buttons=====\\
    JButton FlaecheBtn = new JButton();
    FlaecheBtn.setName("Fläche");
    FlaecheBtn.setIcon(new ImageIcon("Assets/icon/area.png"));
    FlaecheBtn.setHorizontalAlignment(SwingConstants.CENTER);
    FlaecheBtn.addActionListener(BTNlistener);

    JButton GeschwindigkeitBtn = new JButton();
    GeschwindigkeitBtn.setName("Geschwindigkeit");
    GeschwindigkeitBtn.setIcon(new ImageIcon("Assets/icon/speed.png"));
    GeschwindigkeitBtn.setHorizontalAlignment(SwingConstants.CENTER);
    GeschwindigkeitBtn.addActionListener(BTNlistener);

    JButton GewichtBtn = new JButton();
    GewichtBtn.setName("Gewicht");
    GewichtBtn.setHorizontalAlignment(SwingConstants.CENTER);
    GewichtBtn.setIcon(new ImageIcon("Assets/icon/weight.png"));
    GewichtBtn.addActionListener(BTNlistener);

    JButton KraftBtn = new JButton();
    KraftBtn.setName("Kraft");
    KraftBtn.setHorizontalAlignment(SwingConstants.CENTER);
    KraftBtn.setIcon(new ImageIcon("Assets/icon/force.png"));
    KraftBtn.addActionListener(BTNlistener);

    JButton LaengeBtn = new JButton();
    LaengeBtn.setName("Länge");
    LaengeBtn.setHorizontalAlignment(SwingConstants.CENTER);
    LaengeBtn.setIcon(new ImageIcon("Assets/icon/length.png"));
    LaengeBtn.addActionListener(BTNlistener);

    JButton VolumenBtn = new JButton();
    VolumenBtn.setName("Volumen");
    VolumenBtn.setHorizontalAlignment(SwingConstants.CENTER);
    VolumenBtn.setIcon(new ImageIcon("Assets/icon/volume.png"));
    VolumenBtn.addActionListener(BTNlistener);

    JButton ZeitBtn = new JButton();
    ZeitBtn.setName("Zeit");
    ZeitBtn.setHorizontalAlignment(SwingConstants.CENTER);
    ZeitBtn.setIcon(new ImageIcon("Assets/icon/time.png"));
    ZeitBtn.addActionListener(BTNlistener);


    Buttons.add(FlaecheBtn);
    Buttons.add(GeschwindigkeitBtn);
    Buttons.add(GewichtBtn);
    Buttons.add(KraftBtn);
    Buttons.add(LaengeBtn);
    Buttons.add(VolumenBtn);
    Buttons.add(ZeitBtn);

    //======================================Menu Panel=========================================\\
    JPanel Menu = new JPanel();
    Menu.setLayout(new BorderLayout());
    Menu.add(Title, BorderLayout.NORTH);
    Menu.add(Buttons, BorderLayout.SOUTH);


    window.add(Menu);


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


package ejer05;

import javax.swing.*;
import java.awt.*;

public class Circulos extends JFrame {
    private final JPanel topPanel;

    public Circulos() throws HeadlessException {
        setLayout(new BorderLayout());
        setSize(500,600);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createLineBorder(Color.black, 1));

        // espacio para la hora
        topPanel = new JPanel(new BorderLayout());
        topPanel.setSize(getWidth(), 70);
        topPanel.add(new TimePanel());

        mainPanel.add(topPanel, BorderLayout.CENTER);
        mainPanel.add(new CirculosPanel(20), BorderLayout.CENTER);

        add(mainPanel);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void update() throws InterruptedException {
        while (true){
            Thread.sleep(980);
            topPanel.repaint();
        }
    }

    public static void main(String[] args) {
        try {
            new Circulos().update();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

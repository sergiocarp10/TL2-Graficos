package ejer04;

import javax.swing.*;
import java.awt.*;

public class Grilla extends JFrame {

    public Grilla() throws HeadlessException {
        setTitle("Grilla Dibujada");
        setSize(500, 500);

        setLayout(new BorderLayout());
        add(new GrillaPanel(20));

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Grilla();
    }
}

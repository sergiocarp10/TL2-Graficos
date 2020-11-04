package ejer04;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

public class GrillaPanel extends JPanel {
    private int span;

    public GrillaPanel(int span) {
        this.span = span;
        setBackground(Color.WHITE);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D) g.create();

        // Dibujar lineas verticales
        for (int i=span; i<getWidth(); i+=span){
            Line2D line2D = new Line2D.Double(i, 0,i ,getHeight());
            graphics2D.draw(line2D);
        }

        // Dibujar lineas horizontales
        for (int i=span; i<getHeight(); i+=span){
            Line2D line2D = new Line2D.Double(0, i, getWidth(), i);
            graphics2D.draw(line2D);
        }
    }
}

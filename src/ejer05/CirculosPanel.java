package ejer05;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class CirculosPanel extends JPanel {
    private final int span;

    public CirculosPanel(int span) {
        this.span = span;
        setBackground(Color.BLACK);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D) g.create();

        // atributos de la ventana
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2 + 30;

        // colores
        Color[] colors = new Color[]{Color.BLUE, Color.CYAN, Color.YELLOW, Color.RED, Color.GREEN};
        int colorIndex = 0;

        // dibujar circulos
        for (int i=getWidth() * 3/4; i > span; i-=span){
            Ellipse2D ellipse2D = new Ellipse2D.Float(centerX-i/2f, centerY-i/2f, i, i);
            graphics2D.setColor(colors[colorIndex++]);
            graphics2D.fill(ellipse2D);
            graphics2D.draw(ellipse2D);

            if (colorIndex == colors.length)
                colorIndex = 0;
        }
    }
}

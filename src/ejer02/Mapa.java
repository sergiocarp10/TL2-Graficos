package ejer02;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

public class Mapa extends JFrame {
    public static final int WIDTH = 500;
    public static final int HEIGHT = 576;
    public static final int CABALLITO_Y = 320;
    public static final int CABALLITO_X = WIDTH / 2 + 5;
    public static final int MADERO_X = WIDTH - 25;

    public Mapa(){
        ImagePanel panel = new ImagePanel("src/ejer02/buenos-aires.jpg");
        panel.validate();

        getContentPane().add(panel);
        super.setTitle("Mapa de Buenos Aires - Conectado");
        super.setSize(WIDTH+20,HEIGHT+20);
        super.setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        // LÍNEA
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.RED);
        g2.setStroke(new BasicStroke(7));
        Line2D lin = new Line2D.Float(CABALLITO_X, CABALLITO_Y, MADERO_X, CABALLITO_Y);
        g2.draw(lin);

        // CUADRADOS (PUNTOS)
        Graphics2D g3 = (Graphics2D) g;
        g3.setColor(Color.BLUE);
        g3.setStroke(new BasicStroke(7));
        Rectangle2D cuadrado1 = new Rectangle(CABALLITO_X-7, CABALLITO_Y-7, 14,14);
        Rectangle2D cuadrado2 = new Rectangle(MADERO_X-7, CABALLITO_Y-7, 14,14);
        g3.fill(cuadrado1);
        g3.fill(cuadrado2);
        g3.draw(cuadrado1);
        g3.draw(cuadrado2);

        // TEXTO CABALLITO
        Graphics2D g4 = (Graphics2D) g;
        g4.setColor(Color.RED);
        g4.setFont(new Font(Font.DIALOG, Font.BOLD, 12));
        g4.drawString("Caballito", CABALLITO_X-20,CABALLITO_Y + 25);

        // TEXTO MADERO
        Graphics2D g5 = (Graphics2D) g;
        g5.setColor(Color.RED);
        g5.setFont(new Font(Font.DIALOG, Font.BOLD, 12));
        g5.drawString("Puerto Madero", MADERO_X-60,CABALLITO_Y + 25);
    }

    public static void main(String[] args) {
        new Mapa();
    }


}

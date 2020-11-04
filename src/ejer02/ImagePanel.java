package ejer02;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImagePanel extends JPanel {
    private final String filePath;

    public ImagePanel(String filepath){
        this.filePath = filepath;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(cargarImagen(), 0, 0,null);
    }

    private BufferedImage cargarImagen(){
        File file = new File(filePath);
        try {
            return ImageIO.read(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}

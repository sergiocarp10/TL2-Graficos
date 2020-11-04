package ejer03;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class AnimPanel extends JPanel {
    private final String prefixPath, suffixPath;
    private final int max;
    private int i=0;

    public AnimPanel(String prefixPath, String suffixPath, int max){
        this.prefixPath = prefixPath;
        this.suffixPath = suffixPath;
        this.max = max;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(cargarImagen(), 25, 40,null);
    }

    private BufferedImage cargarImagen(){
        if (i == max) i = 1;
        else i++;

        String filePath = prefixPath + i + suffixPath;
        System.out.println("reading " + filePath);
        File file = new File(filePath);
        try {
            return ImageIO.read(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}

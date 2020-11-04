package ejer05;

import javax.swing.*;
import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TimePanel extends JPanel {

    public TimePanel() {
        setBackground(Color.BLACK);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D) g.create();

        // get hour
        Calendar calendar = Calendar.getInstance();
        DateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");
        String hora = dateFormat.format(calendar.getTime());

        graphics2D.setColor(Color.YELLOW);
        graphics2D.setFont(new Font(Font.DIALOG, Font.BOLD, 24));
        graphics2D.drawString("Hora actual: " + hora, getWidth()/4, getHeight()/2+30);
    }
}

package ejer03;

import javax.swing.*;

public class Duke extends JFrame {
    private static final String prefixPath = "res/Duke_en_accion/T";
    private static final String suffixPath = ".gif";

    public Duke(){
        AnimPanel panel = new AnimPanel(prefixPath, suffixPath, 17);
        panel.validate();

        getContentPane().add(panel);
        super.setResizable(false);
        super.setTitle("Duke en acción");
        super.setSize(200,200);
        super.setVisible(true);
    }

    public void iterate(){
        while (true){
            try {
                Thread.sleep(100);
                getContentPane().repaint();
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }

    public static void main(String[] args) {
        Duke duke = new Duke();
        duke.iterate();
    }
}

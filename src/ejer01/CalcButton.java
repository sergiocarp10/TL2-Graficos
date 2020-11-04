package ejer01;

import utils.RoundedBorder;

import javax.swing.*;
import java.awt.*;

public class CalcButton extends JButton {

    public CalcButton(String text) {
        super(text);

        setFont(new Font("Arial", Font.PLAIN, 20));
        setBorder(new RoundedBorder(10));
    }
}

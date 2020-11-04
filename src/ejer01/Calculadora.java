package ejer01;

import utils.RoundedBorder;

import javax.swing.*;
import java.awt.*;

public class Calculadora extends JFrame {

    public Calculadora(){
        super.setTitle("Calculadora");
        JPanel mainPanel = new JPanel(); // main panel
        mainPanel.setLayout(new BorderLayout(30,20));
        mainPanel.setBackground(Color.white);
        mainPanel.setBorder(BorderFactory.createLineBorder(Color.black, 1));

        // campo para ingresar numeros
        JPanel panelTexto = new JPanel(new BorderLayout());

        JTextField textField = new JTextField("0");
        textField.setHorizontalAlignment(SwingConstants.RIGHT);
        textField.setSize(400,20);
        textField.setFont(new Font("Arial", Font.PLAIN, 20));
        panelTexto.add(BorderLayout.NORTH, textField);
        mainPanel.add(panelTexto, BorderLayout.NORTH);

        // parte izquierda
        JPanel panelOeste = new JPanel(new GridLayout(5, 1,10,20));
        panelOeste.add(new JButton("M"));
        panelOeste.add(roundedRedButton("MC"));
        panelOeste.add(roundedRedButton("MR"));
        panelOeste.add(roundedRedButton("MS"));
        panelOeste.add(roundedRedButton("M+"));
        mainPanel.add(panelOeste, BorderLayout.WEST);

        // parte derecha
        JPanel panelEstePosta = new JPanel(new BorderLayout(5,10));

        JPanel panelEsteTop = new JPanel(new GridLayout(1,3,20,5));
        panelEsteTop.add(roundedRedButton("Retroceso"));
        panelEsteTop.add(roundedRedButton("CE"));
        panelEsteTop.add(roundedRedButton("C"));
        panelEstePosta.add(panelEsteTop, BorderLayout.NORTH);

        // parte interna (botones numeros y operaciones)
        JPanel panelEsteBelow = new JPanel(new GridLayout(4, 5,10,10));

        String[] textosInternos = new String[]{
            "7", "8", "9", "/", "sqrt", "4", "5", "6", "*", "%",
            "1", "2", "3", "-", "1/x", "0", "+/-", ",", "+", "="
        };

        JButton[] internos = new JButton[textosInternos.length];

        // setear textos y color por defecto
        for (int i=0; i<textosInternos.length; i++){
            internos[i] = new JButton(textosInternos[i]);
            internos[i].setFont(new Font("Arial", Font.PLAIN, 20));
            internos[i].setBorder(new RoundedBorder(10));
            internos[i].setForeground(Color.BLUE);
        }

        // cambiar colores
        for (int i=3; i<textosInternos.length; i+=5)
            internos[i].setForeground(Color.RED);
        internos[textosInternos.length-1].setForeground(Color.RED);

        for (JButton b : internos)
            panelEsteBelow.add(b);

        panelEstePosta.add(panelEsteBelow, BorderLayout.CENTER);
        mainPanel.add(panelEstePosta, BorderLayout.CENTER);

        // terminar
        super.setSize(480,400);
        super.add(mainPanel);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setVisible(true);                 //making the frame visible
    }

    public static void main(String[] args) {
        new Calculadora();
    }

    private JButton roundedRedButton(String text){
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.PLAIN, 20));
        button.setBorder(new RoundedBorder(10));
        button.setForeground(Color.RED);
        return button;
    }
}

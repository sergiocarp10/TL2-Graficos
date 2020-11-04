package ejer01;

import utils.RoundedBorder;

import javax.swing.*;
import java.awt.*;

public class Calculadora extends JFrame {
    private final JTextField textField;

    private StringBuilder firstInput;
    private StringBuilder secondInput;
    private char operator = ' ';
    private boolean isFirst = true;
    private boolean isShowingResult = false;

    public Calculadora(){
        super.setTitle("Calculadora");
        JPanel mainPanel = new JPanel(); // main panel
        mainPanel.setLayout(new BorderLayout(30,20));
        mainPanel.setBackground(Color.white);
        mainPanel.setBorder(BorderFactory.createLineBorder(Color.black, 1));

        // campo para ingresar numeros
        JPanel panelTexto = new JPanel(new BorderLayout());

        textField = new JTextField();
        textField.setHorizontalAlignment(SwingConstants.RIGHT);
        textField.setFont(new Font("Arial", Font.PLAIN, 40));
        textField.setEditable(false);
        panelTexto.add(BorderLayout.NORTH, textField);
        mainPanel.add(panelTexto, BorderLayout.NORTH);

        // preparamos para calculos
        restart();

        // seteamos los botones de números
        JButton[] numButtons = new JButton[10];
        for (int i = 0; i<10; i++) {
            numButtons[i] = new NumberButton(String.valueOf(i));
            setNumberListener(numButtons[i]);
        }

        // seteamos botones de operación
        JButton sumButton = new OperationButton("+");
        JButton subButton = new OperationButton("-");
        JButton mulButton = new OperationButton("*");
        JButton divButton = new OperationButton("/");
        JButton resultButton = new OperationButton("=");

        // seteamos sus escuchadores
        setOperatorListener(sumButton);
        setOperatorListener(subButton);
        setOperatorListener(mulButton);
        setOperatorListener(divButton);
        setResultListener(resultButton);



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
        JButton CE = roundedRedButton("CE");
        JButton C = roundedRedButton("C");

        CE.addActionListener(e -> restart());
        C.addActionListener(e -> restart());

        panelEsteTop.add(roundedRedButton("Retroceso"));
        panelEsteTop.add(CE);
        panelEsteTop.add(C);
        panelEstePosta.add(panelEsteTop, BorderLayout.NORTH);

        // parte interna (botones numeros y operaciones)
        JPanel panelEsteBelow = new JPanel(new GridLayout(4, 5,10,10));

        // añadir botones de numeros y operaciones
        panelEsteBelow.add(numButtons[7]);
        panelEsteBelow.add(numButtons[8]);
        panelEsteBelow.add(numButtons[9]);
        panelEsteBelow.add(divButton);
        panelEsteBelow.add(new NumberButton("sqrt"));
        panelEsteBelow.add(numButtons[4]);
        panelEsteBelow.add(numButtons[5]);
        panelEsteBelow.add(numButtons[6]);
        panelEsteBelow.add(mulButton);
        panelEsteBelow.add(new NumberButton("%"));
        panelEsteBelow.add(numButtons[1]);
        panelEsteBelow.add(numButtons[2]);
        panelEsteBelow.add(numButtons[3]);
        panelEsteBelow.add(subButton);
        panelEsteBelow.add(new NumberButton("1/x"));
        panelEsteBelow.add(numButtons[0]);
        panelEsteBelow.add(new NumberButton("+/-"));
        panelEsteBelow.add(new NumberButton(","));
        panelEsteBelow.add(sumButton);
        panelEsteBelow.add(resultButton);

        panelEstePosta.add(panelEsteBelow, BorderLayout.CENTER);
        mainPanel.add(panelEstePosta, BorderLayout.CENTER);

        // terminar
        super.setSize(480,400);
        super.add(mainPanel);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setVisible(true);
    }

    private void setNumberListener(JButton button){
        button.addActionListener(e -> {
            if (isShowingResult) restart();

            if (isFirst){
                firstInput.append(button.getText());
                textField.setText(firstInput.toString());
            } else {
                secondInput.append(button.getText());
                textField.setText(firstInput.toString() + ' ' + operator + ' ' + secondInput.toString());
            }
        });
    }

    private void setOperatorListener(JButton button){
        button.addActionListener(e -> {
            if (isShowingResult) return;

            if (operator == ' '){
                this.operator = button.getText().charAt(0);
                textField.setText(firstInput.toString() + ' ' + operator);
                isFirst = false;
            }
        });
    }

    private void setResultListener(JButton button){
        button.addActionListener(e -> {
            int firstNumber = Integer.parseInt(this.firstInput.toString());
            int secondNumber = Integer.parseInt(this.secondInput.toString());

            double result = switch (operator) {
                case '+' -> firstNumber + secondNumber;
                case '-' -> firstNumber - secondNumber;
                case '*' -> firstNumber * secondNumber;
                case '/' -> (double) firstNumber / secondNumber;
                default -> 0;
            };

            textField.setText(String.valueOf(result));
            isShowingResult = true;
        });
    }

    private void restart(){
        textField.setText("0");
        firstInput = new StringBuilder();
        secondInput = new StringBuilder();
        operator = ' ';
        isFirst = true;
        isShowingResult = false;
    }

    private JButton roundedRedButton(String text){
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.PLAIN, 20));
        button.setBorder(new RoundedBorder(10));
        button.setForeground(Color.RED);
        return button;
    }

    public static void main(String[] args) {
        new Calculadora();
    }
}

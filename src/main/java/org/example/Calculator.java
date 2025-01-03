package org.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Calculator extends JFrame implements ActionListener, CalculatorInterface {
    private JTextField display;
    private double firstDigit = 0;
    private double secondDigit = 0;
    private String operator = "";

    public Calculator() {
        //frame
        setTitle("Calculator");
        setSize(400, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        //display
        display = new JTextField();
        display.setEditable(false);
        display.setFont(new Font("Arial", Font.BOLD, 24));
        display.setPreferredSize(new Dimension(500, 100));
        add(display, BorderLayout.NORTH);

        //button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 4));

        //button labels
        String[] buttons = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "=", "+",
                "C"
        };
        //add buttons to panel
        for (String label : buttons) {
            JButton button = new JButton(label);
            button.setFont(new Font("Arial", Font.BOLD, 20));
            button.addActionListener(this);
            buttonPanel.add(button);
        }

        add(buttonPanel, BorderLayout.CENTER);

        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String input = e.getActionCommand();

        if (input.charAt(0) >= '0' && input.charAt(0) <= '9') {
            display.setText(display.getText() + input);
        } else if (input.equals("=")) {
            secondDigit = Double.parseDouble(display.getText());
            switch (operator) {
                case "+":
                    display.setText(String.valueOf(firstDigit + secondDigit));
                    break;
                case "-":
                    display.setText(String.valueOf(firstDigit - secondDigit));
                    break;
                case "*":
                    display.setText(String.valueOf(firstDigit * secondDigit));
                    break;
                case "/":
                    if (secondDigit != 0) {
                        display.setText(String.valueOf(firstDigit / secondDigit));
                    } else {
                        display.setText("Error");
                    }
                    break;
            }
        } else if (input.equals("C")) {
            display.setText("");
            firstDigit = 0;
            secondDigit = 0;
            operator = "";
        } else {
            if (!display.getText().isEmpty()) {
                firstDigit = Double.parseDouble(display.getText());
                operator = input;
                display.setText("");
            }

        }
    }


    @Override
    public void performAddition(double x, double y) {

        display.setText(String.valueOf(x + y));
    }

    @Override
    public void performSubtraction(double x, double y) {

        display.setText(String.valueOf(x - y));
    }

    @Override
    public void performMultiplication(double x, double y) {

        display.setText(String.valueOf(x * y));
    }

    @Override
    public void performDivision(double x, double y) {
        if (y != 0) {
            display.setText(String.valueOf(x / y));
        } else {
            display.setText("Error");
        }
    }
   // get the display text
    public String getDisplayText() {

        return display.getText();
    }

}
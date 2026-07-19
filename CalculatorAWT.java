import java.awt.*;
import java.awt.event.*;

public class CalculatorAWT extends Frame implements ActionListener {

    TextField display;

    double result = 0;
    char operator = '=';
    boolean start = true;

    CalculatorAWT() {

        setTitle("AWT Calculator");
        setSize(260, 320);
        setLayout(new BorderLayout(5, 5));

        display = new TextField("0");
        display.setFont(new Font("Arial", Font.BOLD, 20));
        display.setEditable(true);
        add(display, BorderLayout.NORTH);

        Panel panel = new Panel();
        panel.setLayout(new GridLayout(4, 4, 4, 4));

        String[] buttons = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "C", "0", "=", "+"
        };

        for (String text : buttons) {
            Button b = new Button(text);
            b.setFont(new Font("Arial", Font.BOLD, 16));
            b.addActionListener(this);
            panel.add(b);
        }

        add(panel, BorderLayout.CENTER);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        String cmd = e.getActionCommand();

        // Number buttons
        if (cmd.matches("[0-9]")) {

            if (start) {
                display.setText(cmd);
                start = false;
            } else {
                display.setText(display.getText() + cmd);
            }
        }

        // Clear button
        else if (cmd.equals("C")) {

            display.setText("0");
            result = 0;
            operator = '=';
            start = true;
        }

        // Equals button
        else if (cmd.equals("=")) {

            calculate(Double.parseDouble(display.getText()));
            operator = '=';
            display.setText(String.valueOf(result));
            start = true;
        }

        // Operator buttons
        else {

            calculate(Double.parseDouble(display.getText()));
            operator = cmd.charAt(0);
            start = true;
        }
    }

    public void calculate(double x) {

        switch (operator) {

            case '+':
                result += x;
                break;

            case '-':
                result -= x;
                break;

            case '*':
                result *= x;
                break;

            case '/':
                if (x == 0) {
                    display.setText("Error");
                    result = 0;
                    operator = '=';
                    start = true;
                    return;
                }
                result /= x;
                break;

            case '=':
                result = x;
                break;
        }

        display.setText(String.valueOf(result));
    }

    public static void main(String[] args) {
        new CalculatorAWT();
    }
}
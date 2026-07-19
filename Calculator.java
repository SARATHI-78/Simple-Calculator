import java.awt.*;
import java.awt.event.*;

public class Calculator extends Frame implements ActionListener {

    Label l1, l2, l3;
    TextField t1, t2;
    Button add, sub, mul, div, mod;

    Calculator() {

        setTitle("AWT Calculator");
        setSize(350, 250);
        setLayout(new FlowLayout());

        l1 = new Label("First Number:");
        t1 = new TextField(20);

        l2 = new Label("Second Number:");
        t2 = new TextField(20);

        add = new Button("+");
        sub = new Button("-");
        mul = new Button("*");
        div = new Button("/");
        mod = new Button("%");

        l3 = new Label("Result: ");

        add(l1);
        add(t1);

        add(l2);
        add(t2);

        add(add);
        add(sub);
        add(mul);
        add(div);
        add(mod);

        add(l3);

        add.addActionListener(this);
        sub.addActionListener(this);
        mul.addActionListener(this);
        div.addActionListener(this);
        mod.addActionListener(this);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        double num1 = Double.parseDouble(t1.getText());
        double num2 = Double.parseDouble(t2.getText());
        double result = 0;

        if (e.getSource() == add) {
            result = num1 + num2;
        } else if (e.getSource() == sub) {
            result = num1 - num2;
        } else if (e.getSource() == mul) {
            result = num1 * num2;
        } else if (e.getSource() == div) {
            if (num2 == 0) {
                l3.setText("Result: Cannot divide by zero");
                return;
            }
            result = num1 / num2;
        } else if (e.getSource() == mod) {
            if (num2 == 0) {
                l3.setText("Result: Cannot mod by zero");
                return;
            }
            result = num1 % num2;
        }

        l3.setText("Result: " + result);
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
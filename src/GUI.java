import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class GUI implements ActionListener {

    JFrame frame;
    JTextField textField1, textField2, textField3, textField4, textFieldRate, textError;
    JButton button;
    Font font = new Font("Monospaced", Font.PLAIN, 16);
    String rate;

    GUI(String rate) {
        this.rate = rate;
        frame = new JFrame("Currency Exchange Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 600);
        frame.setLayout(null);
        //funty
        textField1 = new JTextField();
        textField1.setBounds(100, 100, 150, 50);
        textField1.setFont(font);
        textField1.setHorizontalAlignment(JTextField.CENTER);
        textField1.addActionListener(e -> {
            if (!textField1.getText().equals("")) {
                textField2.setEditable(false);
            }
        });
        textField1.addActionListener(e -> {
            if (textField1.getText().equals("")) {
                textField2.setEditable(true);
            }
        });
        frame.getContentPane().add(textField1);
        //plny
        textField2 = new JTextField();
        textField2.setBounds(100, 170, 150, 50);
        textField2.setFont(font);
        textField2.setHorizontalAlignment(JTextField.CENTER);
        textField2.addActionListener(e -> {
            if (!textField2.getText().equals("")) {
                textField1.setEditable(false);
            }
        });
        textField2.addActionListener(e -> {
            if (textField2.getText().equals("")) {
                textField1.setEditable(true);
            }
        });
        frame.getContentPane().add(textField2);

        textField3 = new JTextField("GBP");
        textField3.setBounds(300, 110, 50, 30);
        textField3.setFont(font);
        textField3.setHorizontalAlignment(JTextField.CENTER);
        textField3.setEditable(false);
        frame.getContentPane().add(textField3);

        textField4 = new JTextField("PLN");
        textField4.setBounds(300, 180, 50, 30);
        textField4.setFont(font);
        textField4.setHorizontalAlignment(JTextField.CENTER);
        textField4.setEditable(false);
        frame.getContentPane().add(textField4);

        textFieldRate = new JTextField();
        textFieldRate.setBounds(100, 400, 250, 30);
        textFieldRate.setFont(font);
        textFieldRate.setHorizontalAlignment(JTextField.CENTER);
        textFieldRate.setText("1 GBP equals " + rate + " PLN");
        textFieldRate.setEditable(false);
        frame.getContentPane().add(textFieldRate);

        textError = new JTextField();
        textError.setBounds(100, 20, 300, 30);
        textError.setFont(font);
        textError.setHorizontalAlignment(JTextField.CENTER);
        textError.setEditable(false);
        textError.setForeground(Color.RED);
        frame.getContentPane().add(textError);

        button = new JButton("Calculate");
        button.setBounds(100, 290, 200, 70);
        button.addActionListener(this);
        frame.getContentPane().add(button);

        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            if (!textField1.getText().equals("")) {
                try {
                    double temp = Double.parseDouble(textField1.getText());
                    if ((Double) temp instanceof Double) {
                        double plnMoney = temp * Double.parseDouble(rate);
                        textField2.setText(String.valueOf(BigDecimal.valueOf(plnMoney).setScale(3, RoundingMode.HALF_DOWN)));
                        textError.setText("Calculation done");
                    }
                } catch (NumberFormatException error) {
                    textError.setText("WRONG DATA FORMAT");
                }
            }
            if (!textField2.getText().equals("")) {
                try {
                    double temp2 = Double.parseDouble(textField2.getText());
                    if ((Double) temp2 instanceof Double) {
                        double gbpMoney = temp2 / Double.parseDouble(rate);
                        textField1.setText(String.valueOf(BigDecimal.valueOf(gbpMoney).setScale(3, RoundingMode.HALF_DOWN)));
                        textError.setText("Calculation done");
                    }
                } catch (NumberFormatException error) {
                    textError.setText("WRONG DATA FORMAT");
                }

            }

        }
    }
}







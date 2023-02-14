import javax.swing.*;

public class GUI {

    JFrame frame;
    JTextField textField1, textField2;
    JPanel panel;
    JButton button;
    double num1, num2;
    String dir; //which way to exchange

    GUI(){
        frame = new JFrame("Currency Exchange Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,600);
        frame.setLayout(null);

        frame.setVisible(true);


    }

}

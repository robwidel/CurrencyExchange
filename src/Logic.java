import java.math.BigDecimal;
import java.math.RoundingMode;

public class Logic {


    public static void CalculateUponClick(GUI gui, Boolean poundToZloty) throws NumberFormatException{
        BigDecimal guiRate = new BigDecimal(gui.rate);

        if (!gui.textField1.getText().equals("")  && poundToZloty) {
            try {
                BigDecimal temp = new BigDecimal(gui.textField1.getText()).setScale(4, RoundingMode.HALF_DOWN);

                //double temp = Double.parseDouble(gui.textField1.getText());
                if(temp.doubleValue() < 0 ){
                    gui.textError.setText("NUMBER IS NEGATIVE");
                    gui.textField2.setText("0");
                }
                else if ( temp instanceof BigDecimal) {
                    //double plnMoney = temp * Double.parseDouble(gui.rate);

                    BigDecimal plnMoney = temp.multiply(guiRate).setScale(4, RoundingMode.HALF_UP);

                    gui.textField2.setText(plnMoney.toString());
                    gui.textError.setText("Calculation done");
                    //System.out.println(gui.textField2.getText());

                }
            } catch (NumberFormatException error) {
                gui.textError.setText("WRONG DATA FORMAT");
            }
        }
        if (!gui.textField2.getText().equals("") && !poundToZloty ) {
            try {
                BigDecimal temp2 = new BigDecimal(gui.textField2.getText()).setScale(4, RoundingMode.HALF_DOWN);
                //double temp2 = Double.parseDouble(gui.textField2.getText());
                if(temp2.doubleValue() < 0 ){
                    gui.textError.setText("NUMBER IS NEGATIVE");
                    gui.textField1.setText("0");
                }
                else if ( temp2 instanceof BigDecimal) {
                    //double gbpMoney = temp2 / Double.parseDouble(gui.rate);

                    BigDecimal gbpMoney = temp2.divide(guiRate, 4, RoundingMode.HALF_UP);

                    gui.textField1.setText(gbpMoney.toString());
                    gui.textError.setText("Calculation done");
                    //System.out.println(gui.textField1.getText());

                }
            } catch (NumberFormatException error) {
                gui.textError.setText("WRONG DATA FORMAT");
            }

        }

        try {
            if (!((Double) Double.parseDouble(gui.textField1.getText()) instanceof Double)) {
                gui.textField2.setText("");
                gui.textError.setText("WRONG DATA FORMAT");
            }
            if (!((Double) Double.parseDouble(gui.textField2.getText()) instanceof Double)) {
                gui.textField1.setText("");
                gui.textError.setText("WRONG DATA FORMAT");
            }
        } catch (NumberFormatException error) {
        gui.textError.setText("WRONG DATA FORMAT");
            gui.textField1.setText("");
            gui.textField2.setText("");
        }

        if (gui.textField1.getText().equals("") && !gui.textField2.getText().equals("")) {
            gui.textField2.setText("");
        }
        else if (gui.textField2.getText().isEmpty() && !gui.textField1.getText().equals("")) {
            gui.textField1.setText("");
        }

        if(gui.textField2.getText().isEmpty() && gui.textField2.getText().isEmpty()){
            gui.textError.setText("Enter some new numbers");
        }

    }

}





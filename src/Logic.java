import java.math.BigDecimal;
import java.math.RoundingMode;

public class Logic {


    public static void CalculateUponClick(GUI gui, Boolean poundToZloty){

        if (!gui.textField1.getText().equals("")  && poundToZloty==true) {
            try {
                double temp = Double.parseDouble(gui.textField1.getText());
                if ((Double) temp instanceof Double) {
                    double plnMoney = temp * Double.parseDouble(gui.rate);
                    gui.textField2.setText(String.valueOf(BigDecimal.valueOf(plnMoney).setScale(4, RoundingMode.HALF_DOWN)));
                    gui.textError.setText("Calculation done");
                }
            } catch (NumberFormatException error) {
                gui.textError.setText("WRONG DATA FORMAT");
            }
        }
        if (!gui.textField2.getText().equals("") && poundToZloty == false) {
            try {
                double temp2 = Double.parseDouble(gui.textField2.getText());
                if ((Double) temp2 instanceof Double) {
                    double gbpMoney = temp2 / Double.parseDouble(gui.rate);
                    gui.textField1.setText(String.valueOf(BigDecimal.valueOf(gbpMoney).setScale(4, RoundingMode.HALF_DOWN)));
                    gui.textError.setText("Calculation done");
                }
            } catch (NumberFormatException error) {
                gui.textError.setText("WRONG DATA FORMAT");
            }

        }

    }

}





import java.math.BigDecimal;
import java.math.RoundingMode;

public class Logic {


    public static String CalculateUponClick(GUI gui, Boolean poundToZloty){

        if (!gui.textField1.getText().equals("")  && poundToZloty==true) {
            try {
                double temp = Double.parseDouble(gui.textField1.getText());
                if(temp < 0 ){
                    gui.textError.setText("NUMBER IS NEGATIVE");
                    gui.textField2.setText("0");
                }
                else if ((Double) temp instanceof Double) {
                    double plnMoney = temp * Double.parseDouble(gui.rate);
                    gui.textField2.setText(String.valueOf(BigDecimal.valueOf(plnMoney).setScale(4, RoundingMode.HALF_DOWN)));
                    gui.textError.setText("Calculation done");
                    System.out.println(gui.textField2.getText());
                    return gui.textField2.getText();

                }
            } catch (NumberFormatException error) {
                gui.textError.setText("WRONG DATA FORMAT");
            }
        }
        if (!gui.textField2.getText().equals("") && poundToZloty == false) {
            try {

                double temp2 = Double.parseDouble(gui.textField2.getText());
                if(temp2 < 0 ){
                    gui.textError.setText("NUMBER IS NEGATIVE");
                    gui.textField1.setText("0");
                }
                else if ((Double) temp2 instanceof Double) {
                    double gbpMoney = temp2 / Double.parseDouble(gui.rate);
                    gui.textField1.setText(String.valueOf(BigDecimal.valueOf(gbpMoney).setScale(4, RoundingMode.HALF_DOWN)));
                    gui.textError.setText("Calculation done");
                    System.out.println(gui.textField1.getText());
                    return gui.textField1.getText();
                }
            } catch (NumberFormatException error) {
                gui.textError.setText("WRONG DATA FORMAT");
            }


        }
        if (gui.textField2.getText().equals("") || gui.textField1.getText().equals("")){
            gui.textField1.setText("");
            gui.textField2.setText("");
        }

    return "";}

}





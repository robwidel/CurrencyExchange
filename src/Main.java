public class Main {
    public static void main(String[] args) {
        String currentRate = GetCurrentRate.returnRate();

        GUI gui = new GUI();
        gui.fillRateTextField(currentRate);//value from webpage insert here
    }
}
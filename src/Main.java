public class Main {
    public static void main(String[] args) {
        String currentRate = GetCurrentRate.returnRate();

        new GUI(currentRate);

    }
}
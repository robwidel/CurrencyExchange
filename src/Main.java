import org.testng.Assert;
import org.testng.annotations.Test;

public class Main {

    public static void main(String[] args) {
        String currentRate = GetCurrentRate.getVal();
        GUI gui = new GUI(currentRate);

    }

    @Test
    public void exchangeValueTest(){
        Assert.assertEquals(GetCurrentRate.getVal(), "5.3520");
    }

 //   @Test
//    public void exchangeCalculationTest(){
//        Assert.assertEquals(Main.returnedValue2, "535.2000");
//    }
}
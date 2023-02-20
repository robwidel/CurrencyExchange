import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;


public class TEST {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "E:\\workspace\\driver_v1\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        WebDriver driver = new ChromeDriver(options);

        driver.get("http://api.nbp.pl/api/exchangerates/rates/a/gbp?format=xml");
        String val = driver.findElement(By.cssSelector(".folder  .folder > .opened > div:nth-of-type(3) > span:nth-of-type(2)")).getText();
        double number = Double.parseDouble(val);

        System.out.println("1 funt jest wart: " + val + " pln");
        BigDecimal poundToPln = new BigDecimal(number).setScale(10, RoundingMode.HALF_UP);
        BigDecimal plnToPound = new BigDecimal(1/number).setScale(10, RoundingMode.HALF_UP);


        System.out.println("Wybierz walute ktora masz: funt lub pln\n");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();

        if(choice.equals("pln")){
            System.out.println("Podaj ilosc wybranej waluty\n");
            BigDecimal num = new BigDecimal(scanner.nextLine());
            BigDecimal gbp = plnToPound.multiply(num).setScale(4, RoundingMode.HALF_UP);
            System.out.println("Tyle złotych daje "  + gbp + " funtów");
        }
        else if(choice.equals("gbp")) {
            System.out.println("Podaj ilosc wybranej waluty\n");
            BigDecimal num = new BigDecimal(scanner.nextLine());
            BigDecimal pln = poundToPln.multiply(num).setScale(4, RoundingMode.HALF_UP);
            System.out.println("Tyle funtow daje "  + pln + " zlotych");
        }
        else{
            System.out.println("Zle, wybierz poprawna walute");
        }






    }

}

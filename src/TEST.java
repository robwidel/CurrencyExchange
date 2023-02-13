import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TEST {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "E:\\workspace\\driver_v1\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("http://api.nbp.pl/api/exchangerates/rates/a/gbp?format=json");
        String text = driver.findElement(By.cssSelector("pre")).getText();

        System.out.println(text);


    }

}

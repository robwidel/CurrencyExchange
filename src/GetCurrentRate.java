import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class GetCurrentRate {
    private static String val;

    public static String getVal() {
        returnRate();
        return val;
    }

    private static void returnRate() {
        System.setProperty("webdriver.chrome.driver", "E:\\workspace\\driver_v1\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        WebDriver driver = new ChromeDriver(options);

        driver.get("http://api.nbp.pl/api/exchangerates/rates/a/gbp?format=xml");
        GetCurrentRate.val = driver.findElement(By.cssSelector(".folder  .folder > .opened > div:nth-of-type(3) > span:nth-of-type(2)")).getText();

    }
}

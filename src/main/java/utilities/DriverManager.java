package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class DriverManager {

    static WebDriver driver;

    public static WebDriver getDriver(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");

        return driver;
    }

}

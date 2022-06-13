import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;

public class ReservationPage {

    private WebDriver driver;
    private By titleText;
    private By passengersDrop;
    private By fromDrop;
    private By toDrop;

    public ReservationPage(WebDriver driver){
        this.driver=driver;
        titleText=By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/font");
        passengersDrop=By.name("passCount");
        fromDrop=By.name("fromPort");
        toDrop=By.name("toPort");
    }

    public void AssertPassengers(){
        Assert.assertTrue(driver.findElement(titleText).getText().contains("Use our Flight Finder to search"));
    }

    public void selectPassengers(int cant){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement quantityOfPassengers=wait.until(ExpectedConditions.presenceOfElementLocated(passengersDrop));
        Select selectPassengers = new Select(quantityOfPassengers);
        selectPassengers.selectByVisibleText(Integer.toString(cant));
    }

    public void selectFromPort(int index){
        Select selectFrom = new Select(driver.findElement(fromDrop));
        selectFrom.selectByIndex(index);
    }

    public void selectToPort(String city){
        Select selectTo = new Select(driver.findElement(toDrop));
        selectTo.selectByValue(city);
    }
}

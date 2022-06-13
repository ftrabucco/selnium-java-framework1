import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LogonPage {

    private WebDriver driver;
    @FindBy(xpath = "//h3")
    private WebElement tittleText;
    @FindBy(xpath = "//a[contains(text(),\"Flights\")]")
    private WebElement flightsLink;

    public LogonPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void assertLogonPage(){
        Assert.assertTrue(tittleText.getText().contains("Login Successfully"));
    }

    public void clickOnFlights(){
        flightsLink.click();
    }
}

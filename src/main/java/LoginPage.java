import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;


public class LoginPage {

    private  WebDriver driver;

    @FindBy(how=How.NAME,using = "submit")
    private WebElement login_btn;

    @FindBy(how = How.NAME,using = "userName")
    private WebElement user_field;

    @FindBy(how=How.NAME,using = "password")
    private WebElement password_field;

    @FindBy(how = How.TAG_NAME,using = "input")
    private List<WebElement> fields;

    public LoginPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void login(String user, String  password){
        user_field.sendKeys(user);
        password_field.sendKeys(password);
        login_btn.click();
        File myScreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(myScreenshot,new File("LOGIN "+ System.currentTimeMillis()+".png"));
        } catch (IOException e){
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void verifyFields(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //List<WebElement> loginFields= driver.findElements(fields);
        System.out.println(fields.size());
        Assert.assertEquals(fields.size(), 4);
    }
}

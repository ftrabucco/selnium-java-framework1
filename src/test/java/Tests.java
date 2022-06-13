import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.Helpers;
import utilities.ScreenShooter;
import utilities.WindowManager;

import java.util.ArrayList;

public class Tests {

    private WebDriver driver;
    private final String DRIVER_PATH="src/driver/chromedriver.exe";
    ArrayList<String>tabs;

    @BeforeMethod
    public void setup(){
        System.setProperty("webdriver.chrome.driver", DRIVER_PATH);
        driver=new ChromeDriver();
        //driver.manage().window().maximize();
        //driver.manage().window().fullscreen();
        //driver.manage().window().setSize(new Dimension(200,200));
        //driver.manage().window().setPosition(new Point(800,200));
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor)driver;
        String googleWindow = "window.open('https://www.google.com/')";
        javascriptExecutor.executeScript(googleWindow);
        tabs=new ArrayList<String>(driver.getWindowHandles());
        driver.navigate().to("https://demo.guru99.com/test/newtours/");
    }

    @Test(description = "Login correcto")
    public void test_one(){
        WindowManager.maximazeWindow(driver);
        driver.switchTo().window(tabs.get(1)).navigate().to("https://www.youtube.com/");
        driver.switchTo().window(tabs.get(0));
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("user@gmail.com","password123");
        Assert.assertTrue(true,"...");
    }

    @Test(description = "Login correcto y verificacion Logon Page")
    public void test_two(){
        //WindowManager.setWindowSize(driver,"fullscreen");
        LoginPage loginPage = new LoginPage(driver);
        LogonPage logonPage = new LogonPage(driver);
        Helpers helpers = new Helpers();
        helpers.sleepSeconds(2);
        loginPage.login("user@gmail.com","password123");
        logonPage.assertLogonPage();
    }

    @Test(description = "Verificar campos en Reservation Page")
    public void test_three(){
        WindowManager.setWindowSize(driver,800,800);
        LoginPage loginPage = new LoginPage(driver);
        ReservationPage reservationPage = new ReservationPage(driver);
        loginPage.login("user@gmail.com","password123");
        LogonPage logonPage = new LogonPage(driver);
        logonPage.clickOnFlights();
        reservationPage.AssertPassengers();
        reservationPage.selectPassengers(1);
        reservationPage.selectFromPort(2);
        reservationPage.selectToPort("London");
    }

    @Test(description = "Verificar cantidad de campos input en Login Page")
    public void test_four(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.verifyFields();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if(!result.isSuccess()){
            ScreenShooter.takeScreenshot("Error",driver);
        }
        driver.switchTo().window(tabs.get(0)).close();
        driver.switchTo().window(tabs.get(1)).close();
    }
}


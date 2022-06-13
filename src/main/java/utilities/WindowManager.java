package utilities;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

public class WindowManager {

    public static void maximazeWindow(WebDriver driver){
        driver.manage().window().maximize();
    }

    public static void setWindowSize(WebDriver driver, String size){
        if(size.equals("maximazed")){
            driver.manage().window().maximize();
        }
        if (size.equals("fullscreen")){
            driver.manage().window().fullscreen();
        }
    }

    public static void setWindowSize(WebDriver driver, int x, int y){
        driver.manage().window().setSize(new Dimension(x,y));
    }

}

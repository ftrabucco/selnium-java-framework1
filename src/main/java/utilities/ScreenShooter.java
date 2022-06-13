package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenShooter {

    public static void takeScreenshot(String screenshotName, WebDriver driver){
        File myScreenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(myScreenshot, new File(screenshotName+"_"+ System.currentTimeMillis()+".png"));
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}

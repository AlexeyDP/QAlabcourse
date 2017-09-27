package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelper {
    public  static WebElement WaitForVisible(WebDriver driver, By by, int timeOut){
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public  static void WaitForVisible(WebDriver driver, WebElement element, int timeOut){
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
         wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement WaitForClickable(WebDriver driver, By by){
        WebDriverWait wait = new WebDriverWait(driver, 3);
        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }


}

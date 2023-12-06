package fe.test.selenium;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static jdk.internal.net.http.common.Log.logError;


public class PageService extends BasePageObject {

    WebDriverWait wait;

    WebDriverWait shortWait;

    Actions actions;


    JavascriptExecutor jse;

    int secondsWait = 50;

    int secondsShortWait = 10;

    public PageService(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(secondsWait));
        shortWait = new WebDriverWait(driver, Duration.ofSeconds(secondsShortWait));
        actions = new Actions(driver);
        jse = (JavascriptExecutor) driver;
    }

    public void clickOnElement(WebElement element){
        logInfo("Click: " + element.toString());
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    private void logInfo(String s) {
        System.out.println(s);
    }

    public void sendKeysToElement(WebElement element, String string) {
        logInfo("I write:" + string + "in element: " + element.toString());
        wait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(string);
        if (string.equals(element.getText()) || string.equals(element.getAttribute("value"))) {
            logInfo("Insert true value");
        } else {
            logError("Verify your input");
        }
    }

    public boolean isElementVisible(WebElement element) {
        try {
            shortWait.until(ExpectedConditions.visibilityOf(element));
            logInfo("Element is visible = " + element);
            return true;
        } catch (Exception e) {
         logInfo("Element is not visible " + element);
         e.printStackTrace();
         return false;
        }
    }
}

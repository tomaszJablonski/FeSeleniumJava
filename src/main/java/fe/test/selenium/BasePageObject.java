package fe.test.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePageObject {

    protected WebDriver webDriver;

    protected WebDriverWait webDriverWait;

    public BasePageObject(WebDriver driver) {
        this.webDriver=driver;
        PageFactory.initElements(driver,this);
        this.webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }

}


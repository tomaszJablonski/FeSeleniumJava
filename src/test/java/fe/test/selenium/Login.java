package fe.test.selenium;

import fe.test.selenium.utils.Service;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Login {

    Service service;

    LoginPage loginPage;

    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() throws IllegalAccessException {
        service = new Service();
        driver = service.init();
        loginPage = new LoginPage(driver);
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }

    @Test(testName = "Login to app")
    public void loginToApp() throws Exception {
        loginPage.login(service.getLogin(), service.getPassword());
        Assert.assertTrue(loginPage.loginPageIsVisible());
    }
}

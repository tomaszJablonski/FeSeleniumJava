package fe.test.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePageObject{

    PageService pageService;
    public LoginPage(WebDriver driver) {
        super(driver);
        pageService = new PageService(driver);
    }

    //----------paths----------
    @FieldName(name = "Username")
    @FindBy(id = "user-name")
    public static WebElement usernameInput;

    @FieldName(name = "Password")
    @FindBy(id = "password")
    public static WebElement passwordInput;

    @FieldName(name = "Login Button")
    @FindBy(id = "login-button")
    public static WebElement loginButton;

    //----------methods----------

    public void loginInputFill(String login) throws Exception {
        pageService.sendKeysToElement(usernameInput, login);
    }

    public void passwordInputFill(String password) throws Exception {
        pageService.sendKeysToElement(passwordInput, password);
    }

    public void loginButtonClick() throws Exception {
        pageService.clickOnElement(loginButton);
    }


}

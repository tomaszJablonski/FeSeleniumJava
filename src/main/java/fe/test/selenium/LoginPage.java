package fe.test.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePageObject {

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

    @FieldName(name = "Visible site")
    @FindBy(css = ".header_secondary_container")
    public static WebElement visibleSite;

    //----------methods----------

    public void loginInputFill(String login) {
        pageService.sendKeysToElement(usernameInput, login);
    }

    public void passwordInputFill(String password) {
        pageService.sendKeysToElement(passwordInput, password);
    }

    public void loginButtonClick() {
        pageService.clickOnElement(loginButton);
    }

    public void login(String login, String password) throws Exception {
        loginInputFill(login);
        passwordInputFill(password);
        loginButtonClick();
    }

    //----------visible----------

    public boolean loginPageIsVisible() throws Exception {
        return pageService.isElementVisible(visibleSite);
    }

}

package fe.test.selenium.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.bidi.Connection;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class Service {

    Connection connection;

    @Getter
    public static String environment;

    public static String userRole;

    private static final String URL = "https://www.saucedemo.com/";

    private String url;
    @Getter
    private String login;
    @Getter
    private String password;

    public static class Environments {

        static final String ENV1 = "env1";
        static final String ENV2 = "env2";
        static final String ENV3 = "env3";

    }

    public Service() throws IllegalAccessException {
        environment = Environments.ENV1;
        setupEnv(environment);
    }

    public Service(String env) throws IllegalAccessException {
        environment = env;
        setupEnv(environment);
    }

    private void setupEnv(String environment) throws IllegalAccessException {
        switch (environment) {
            case "env1":
                System.out.println("You choose " + environment);
                this.url = URL;
                this.login = "standard_user";
                this.password = "secret_sauce";
                break;
            case "env2":
                System.out.println("You choose " + environment);
                this.url = URL;
                this.login = "problem_user";
                this.password = "secret_sauce";
                break;
            case "env3":
                System.out.println("You choose " + environment);
                this.url = URL;
                this.login = "performance_glitch_user";
                this.password = "secret_sauce";
                break;
            default:
                throw new IllegalAccessException("This env is does not exist");

        }
    }

    public WebDriver init(){
        WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.driver", "X:\\NAUKA TESTOWANIA\\FeSeleniumJava\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        driver.manage().window().maximize();
        driver.navigate().to(url);
        return driver;
    }

}

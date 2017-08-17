package cucumberTesting.pageObject;

import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class AbstractPage {

    protected WebDriver driver;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
    }

    public LandingPage navigateToYandex(){
        driver.get("https://www.yandex.ru");
        return new LandingPage(driver);
    }
}

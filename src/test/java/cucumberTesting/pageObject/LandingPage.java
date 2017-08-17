package cucumberTesting.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class LandingPage extends AbstractPage{


    public LandingPage(WebDriver driver) {
        super(driver);
    }

    public YandexMarketPage navigateToYandexMarket(String str){
        String xpathString = String.format("//a[contains(text(),'%s')]",str);
        WebElement marketButton = driver.findElement(By.xpath(xpathString));
        marketButton.click();
        return new YandexMarketPage(driver);
    }
}
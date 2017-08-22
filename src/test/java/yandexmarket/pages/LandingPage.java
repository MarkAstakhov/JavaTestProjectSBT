package yandexmarket.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

public class LandingPage extends AbstractPage{

    private static final long MAX_LOAD_TIME = 10;

    By yandexMarketButton;

    public LandingPage(WebDriver driver) {
        super(driver);
    }

    public YandexMarketPage navigateToYandexMarket(String str){

        /*
        wait = new WebDriverWait(driver, 10);
        yandexMarketButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathString)));
        yandexMarketButton.click();
        wait.until(ExpectedConditions.stalenessOf(yandexMarketButton));
        return new YandexMarketPage(driver);
        */


        yandexMarketButton = By.xpath(String.format("//a[contains(text(),'%s')]", str));
        try {
            clickAndCloseWhenReady(yandexMarketButton, MAX_LOAD_TIME);
        } catch (TimeoutException e) {
            System.out.println("section Маркет wasn't loaded during" + MAX_LOAD_TIME + " sec");
        }
        return new YandexMarketPage(driver);
    }
}
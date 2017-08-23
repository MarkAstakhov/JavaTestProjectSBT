package yandexmarket.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

public class LandingPage extends AbstractPage{


    By yandexMarketButton;

    public LandingPage(WebDriver driver) {
        super(driver);
    }

    public YandexMarketPage navigateToYandexMarket(String str){

        yandexMarketButton = By.xpath(String.format("//a[contains(text(),'%s')]", str));
        try {
            clickAndCloseWhenReady(yandexMarketButton);
        } catch (TimeoutException e) {
            throw e;
        }
        return new YandexMarketPage(driver);
    }
}
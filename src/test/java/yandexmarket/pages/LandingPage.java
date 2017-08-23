package yandexmarket.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import yandexmarket.steps.StepDefinitions;

public class LandingPage extends AbstractPage{

    private static final long MAX_LOAD_TIME = 10;

    By yandexMarketButton;

    public LandingPage(WebDriver driver) {
        super(driver);
    }

    public YandexMarketPage navigateToYandexMarket(String str){

        yandexMarketButton = By.xpath(String.format("//a[contains(text(),'%s')]", str));
        try {
            clickAndCloseWhenReady(yandexMarketButton, MAX_LOAD_TIME);
        } catch (TimeoutException e) {
            throw e;
            //System.out.println("section Маркет wasn't loaded during" + MAX_LOAD_TIME + " sec");

        }
        return new YandexMarketPage(driver);
    }
}
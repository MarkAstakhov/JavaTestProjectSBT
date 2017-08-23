package yandexmarket.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FilterPage extends AbstractPage {

    By lowerBoundPriceField = By.xpath("//*[@id='glf-pricefrom-var']");
    By upperBoundPriceField = By.xpath("//*[@id='glf-priceto-var']");
    By acceptFiltersButton = By.xpath("//a[contains(@class ,'show-filtered')]");
    By checkBoxOfManufacturer;

    public List<WebElement> listOfManufacturers;

    public FilterPage(WebDriver driver) {
        super(driver);
    }

    public FilterPage setLowerBoundPrice(int price) {

        try {
            WebElement textBox = getWhenVisible(lowerBoundPriceField);
            textBox.sendKeys(String.valueOf(price));
        } catch (TimeoutException e) {
            throw e;
        }
        return new FilterPage(driver);
    }

    public FilterPage setUpperBoundPrice(int price) {
        try {
            WebElement textBox = getWhenVisible(upperBoundPriceField);
            textBox.sendKeys(String.valueOf(price));
        } catch (TimeoutException e) {
            throw e;
        }
        return new FilterPage(driver);
    }

    public FilterPage setManufacturers(List<String> arg) {
        for (int i = 0; i < arg.size(); i++) {
            checkBoxOfManufacturer = By.xpath(String.format("//label[@class='checkbox__label' and contains(text(),'%s')]", arg.get(i)));
            try {
                clickCheckBoxWhenReady(checkBoxOfManufacturer);
            } catch (TimeoutException e) {
            }
        }
        return new FilterPage(driver);
    }

    public YandexMarketPage navigateToYandexMarketPage() {
        try {
            clickAndCloseWhenReady(acceptFiltersButton);
        } catch (TimeoutException e) {
            throw e;
        }
        return new YandexMarketPage(driver);
    }
}

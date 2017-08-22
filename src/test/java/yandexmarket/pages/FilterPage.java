package yandexmarket.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class FilterPage extends AbstractPage {

    private static final long MAX_LOAD_TIME = 10;

    By lowerBoundPriceField = By.xpath("//*[@id='glf-pricefrom-var']");
    By upperBoundPriceField = By.xpath("//*[@id='glf-priceto-var']");
    By acceptFiltersButton = By.xpath("//a[contains(@class ,'show-filtered')]");
    By checkBoxOfManufacturer;

    //By.xpath("//div[contains(@class ,'list-items')]//span[contains(@class ,'checkbox')]");

    public List<WebElement> listOfManufacturers;

    public FilterPage(WebDriver driver) {
        super(driver);
    }

    public FilterPage setLowerBoundPrice(int price) {

/*
        wait = new WebDriverWait(driver, 10);
        WebElement textBox = wait.until(ExpectedConditions.visibilityOfElementLocated(lowerBoundPriceField));
        */
        try {
            WebElement textBox = getWhenVisible(lowerBoundPriceField, MAX_LOAD_TIME);
            textBox.sendKeys(String.valueOf(price));
        } catch (TimeoutException e) {
            System.out.println("element Поле нижней границы цены wasn't loaded during" + MAX_LOAD_TIME + " sec");
        }
        return new FilterPage(driver);
    }

    public FilterPage setUpperBoundPrice(int price) {
        try {
            WebElement textBox = getWhenVisible(upperBoundPriceField, MAX_LOAD_TIME);
            textBox.sendKeys(String.valueOf(price));
        } catch (TimeoutException e) {
            System.out.println("element Поле верхней границы цены wasn't loaded during" + MAX_LOAD_TIME + " sec");
        }
        return new FilterPage(driver);
    }

    public FilterPage setManufacturers(List<String> arg) {
        for (int i = 0; i < arg.size(); i++) {
            checkBoxOfManufacturer = By.xpath(String.format("//label[@class='checkbox__label' and contains(text(),'%s')]", arg.get(i)));
            try {
                clickCheckBoxWhenReady(checkBoxOfManufacturer, 1);
            } catch (TimeoutException e) {
                System.out.println("element Производитель wasn't loaded during" + MAX_LOAD_TIME + " sec");
            }
        }
        return new FilterPage(driver);
    }

    public YandexMarketPage navigateToYandexMarketPage() {
        try {
            clickAndCloseWhenReady(acceptFiltersButton, MAX_LOAD_TIME);
        } catch (TimeoutException e) {
            System.out.println("element Применить фильтры wasn't loaded during" + MAX_LOAD_TIME + " sec");
        }
        return new YandexMarketPage(driver);
    }
}

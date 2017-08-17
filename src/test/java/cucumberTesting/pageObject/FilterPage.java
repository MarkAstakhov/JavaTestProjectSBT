package cucumberTesting.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.logging.Filter;

public class FilterPage extends AbstractPage {
    public FilterPage(WebDriver driver) {
        super(driver);
    }

    public FilterPage setLowerBoundPrice(int price){
        WebElement googleTextBox = driver.findElement(By.xpath("//*[@id='glf-pricefrom-var']"));
        googleTextBox.sendKeys(String.valueOf(price));
        return  new FilterPage(driver);
    }

    public FilterPage setUpperBoundPrice(int price){
        WebElement googleTextBox = driver.findElement(By.xpath("//*[@id='glf-priceto-var']"));
        googleTextBox.sendKeys(String.valueOf(price));
        return  new FilterPage(driver);
    }

    public FilterPage setManufacturers(List<String> arg){
        for (int i = 0; i < arg.size(); i++) {
            String xpathString = String.format("//label[@class='checkbox__label' and contains(text(),'%s')]", arg.get(i));
            WebElement checkBox = driver.findElement(By.xpath(xpathString));
            checkBox.click();
        }
        return new FilterPage(driver);
    }

    public YandexMarketPage navigateToYandexMarketPage(){
        WebElement acceptFiltersButton = driver.findElement(By.xpath("//a[contains(@class ,'show-filtered')]"));
        acceptFiltersButton.click();
        return new YandexMarketPage(driver);
    }
}

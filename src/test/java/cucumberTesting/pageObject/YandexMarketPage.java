package cucumberTesting.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class YandexMarketPage extends AbstractPage {

    public YandexMarketPage(WebDriver driver) {
        super(driver);
    }

    public YandexMarketPage navigateToSection(String str) {
        String xpathString = String.format("//a[contains(text(),'%s') and contains(@class ,'link topmenu')]", str);
        WebElement sectionButton = driver.findElement(By.xpath(xpathString));
        sectionButton.click();
        return new YandexMarketPage(driver);
    }

    public YandexMarketPage navigateToSubSection(String str) {
        String xpathString = String.format("//a[contains(text(),'%s') and contains(@class ,'link catalog')]", str);
        WebElement sectionButton = driver.findElement(By.xpath(xpathString));
        sectionButton.click();
        return new YandexMarketPage(driver);
    }

    public FilterPage navigateToFilterPage() {
        WebElement filterButton = driver.findElement(By.xpath("//a[contains(text(),'Перейти ко всем фильтрам')]"));
        filterButton.click();
        return new FilterPage(driver);
    }
}

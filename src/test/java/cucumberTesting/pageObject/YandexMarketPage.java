package cucumberTesting.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class YandexMarketPage extends AbstractPage {

    public List<WebElement> listOfElements;
    public String elementFromList;

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

    public int countElementsOnPage(){
        listOfElements = driver.findElements(By.xpath("//div[contains(@class ,'n-snippet-card')]"));
        return listOfElements.size();
    }

    public void getElementFromList(int number){
        elementFromList = listOfElements.get(number).getAttribute("textContent");
        WebElement searchField = driver.findElement(By.xpath("//*[@id='header-search']"));
        searchField.sendKeys(elementFromList);
    }

    public void setSearchField(){
        //WebElement searchField = driver.findElement(By.xpath("//*[@id='header-search']"));
        //searchField.sendKeys(elementFromList);
    }

    public ProductPage navigateToProductPage(){
        WebElement searchButton = driver.findElement(By.xpath("//button[contains(@class ,'button2')]"));
        searchButton.click();
        return new ProductPage(driver);
    }
}

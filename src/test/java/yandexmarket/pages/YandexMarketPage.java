package yandexmarket.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.TimeoutException;

import java.util.List;


public class YandexMarketPage extends AbstractPage {



    By sectionButton;
    By subsectionButton;
    By filterButton;
    By productBox = By.xpath("//div[contains(@class ,'n-snippet-card')]//span[contains(@class ,'header-text')]");
    By searchField = By.xpath("//*[@id='header-search']");
    By searchButton = By.xpath("//button[contains(@class ,'button2')]");


    public List<WebElement> listOfElements;
    public String elementFromList;

    public YandexMarketPage(WebDriver driver) {
        super(driver);
    }

    public YandexMarketPage navigateToSection(String str){
        sectionButton = By.xpath(String.format("//a[contains(text(),'%s') and contains(@class ,'link topmenu')]", str));
        try {
            clickAndCloseWhenReady(sectionButton);
        }catch (TimeoutException e){
            throw e;
        }
        return new YandexMarketPage(driver);
    }

    public YandexMarketPage navigateToSubSection(String str)throws TimeoutException{
        subsectionButton = By.xpath(String.format("//a[contains(text(),'%s') and contains(@class ,'link catalog')]", str));
        try {
            clickAndCloseWhenReady(subsectionButton);
        } catch (TimeoutException e) {
            throw e;
        }
        return new YandexMarketPage(driver);
    }

    public FilterPage navigateToFilterPage() throws TimeoutException{
        filterButton = By.xpath("//a[contains(text(),'Перейти ко всем фильтрам')]");
        try {
            clickAndCloseWhenReady(filterButton);
        } catch (TimeoutException e) {
            throw e;
        }
        return new FilterPage(driver);
    }

    public int countElementsOnPage() throws TimeoutException{
        try {
            listOfElements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productBox));
        } catch (TimeoutException e) {
            throw e;
        }
        return listOfElements.size();
    }

    public void getElementFromList(int number) {
        elementFromList = listOfElements.get(number - 1).getAttribute("textContent");

    }

    public void setSearchField() throws TimeoutException{
        try {
            WebElement textBox = getWhenVisible(searchField);
            textBox.sendKeys(elementFromList);
        } catch (TimeoutException e) {
            throw e;
        }
    }

    public ProductPage navigateToProductPage() throws TimeoutException{
        try {
            clickAndCloseWhenReady(searchButton);
        } catch (TimeoutException e) {
            throw e;
        }
        return new ProductPage(driver);


    }
}

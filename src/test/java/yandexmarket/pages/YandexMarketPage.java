package yandexmarket.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.TimeoutException;
import yandexmarket.steps.StepDefinitions;

import java.sql.Time;
import java.util.List;
import java.util.logging.Logger;

public class YandexMarketPage extends AbstractPage {

    private static final long MAX_LOAD_TIME = 10;

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
            clickAndCloseWhenReady(sectionButton, MAX_LOAD_TIME);
        }catch (TimeoutException e){
            throw e;
        }
            //log.info("section Компьютеры wasn't loaded during" + MAX_LOAD_TIME + " sec");
        return new YandexMarketPage(driver);
    }

    public YandexMarketPage navigateToSubSection(String str)throws TimeoutException{
        subsectionButton = By.xpath(String.format("//a[contains(text(),'%s') and contains(@class ,'link catalog')]", str));
        try {
            clickAndCloseWhenReady(subsectionButton, MAX_LOAD_TIME);
        } catch (TimeoutException e) {
            //log.info("section Ноутбуки wasn't loaded during" + MAX_LOAD_TIME + " sec");
            throw e;
        }
        return new YandexMarketPage(driver);
    }

    public FilterPage navigateToFilterPage() throws TimeoutException{
        filterButton = By.xpath("//a[contains(text(),'Перейти ко всем фильтрам')]");
        try {
            clickAndCloseWhenReady(filterButton, MAX_LOAD_TIME);
        } catch (TimeoutException e) {
            //log.info("element Перейти ко всем фильтрам wasn't loaded during" + MAX_LOAD_TIME + " sec");
            throw e;
        }
        return new FilterPage(driver);
    }

    public int countElementsOnPage() throws TimeoutException{
        try {
            WebDriverWait wait = new WebDriverWait(driver, MAX_LOAD_TIME);
            listOfElements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productBox));
        } catch (TimeoutException e) {
            //log.info("element Список товаров wasn't loaded during" + MAX_LOAD_TIME + " sec");
            throw e;
        }
        return listOfElements.size();
    }

    public void getElementFromList(int number) {
        elementFromList = listOfElements.get(number - 1).getAttribute("textContent");

    }

    public void setSearchField() throws TimeoutException{
        try {
            WebElement textBox = getWhenVisible(searchField, MAX_LOAD_TIME);
            textBox.sendKeys(elementFromList);
        } catch (TimeoutException e) {
            //log.info("element Поле поиска wasn't loaded during" + MAX_LOAD_TIME + " sec");
            throw e;
        }
    }

    public ProductPage navigateToProductPage() throws TimeoutException{
        try {
            clickAndCloseWhenReady(searchButton, MAX_LOAD_TIME);
        } catch (TimeoutException e) {
            //log.info("element Кнопка Найти wasn't loaded during" + MAX_LOAD_TIME + " sec");
            throw e;
        }
        return new ProductPage(driver);


    }
}

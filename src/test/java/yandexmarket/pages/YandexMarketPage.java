package yandexmarket.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.TimeoutException;

import java.util.List;

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

    public YandexMarketPage navigateToSection(String str) {
        sectionButton = By.xpath(String.format("//a[contains(text(),'%s') and contains(@class ,'link topmenu')]", str));
        try {
            clickAndCloseWhenReady(sectionButton, MAX_LOAD_TIME);
        } catch (TimeoutException e) {
            System.out.println("section Компьютеры wasn't loaded during" + MAX_LOAD_TIME + " sec");
        }
        /*
        wait = new WebDriverWait(driver, MAX_LOAD_TIME);
        try {
            WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(sectionButton));
            button.click();
            wait.until(ExpectedConditions.stalenessOf(button));
        }catch (TimeoutException e){
            System.out.println("element wasn't loaded during" + MAX_LOAD_TIME + " sec");
        }
        */
        return new YandexMarketPage(driver);
    }

    public YandexMarketPage navigateToSubSection(String str) {
        subsectionButton = By.xpath(String.format("//a[contains(text(),'%s') and contains(@class ,'link catalog')]", str));
        try {
            clickAndCloseWhenReady(subsectionButton, MAX_LOAD_TIME);
        } catch (TimeoutException e) {
            System.out.println("section Ноутбуки wasn't loaded during" + MAX_LOAD_TIME + " sec");
        }
        return new YandexMarketPage(driver);
    }

    public FilterPage navigateToFilterPage() {
        filterButton = By.xpath("//a[contains(text(),'Перейти ко всем фильтрам')]");
        try {
            clickAndCloseWhenReady(filterButton, MAX_LOAD_TIME);
        } catch (TimeoutException e) {
            System.out.println("element Перейти ко всем фильтрам wasn't loaded during" + MAX_LOAD_TIME + " sec");
        }
        return new FilterPage(driver);
    }

    public int countElementsOnPage() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, MAX_LOAD_TIME);
            listOfElements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productBox));
        } catch (TimeoutException e) {
            System.out.println("element Список товаров wasn't loaded during" + MAX_LOAD_TIME + " sec");
        }
        return listOfElements.size();
    }

    public void getElementFromList(int number) {
        elementFromList = listOfElements.get(number - 1).getAttribute("textContent");

    }

    public void setSearchField() {
        try {
            WebElement textBox = getWhenVisible(searchField, MAX_LOAD_TIME);
            textBox.sendKeys(elementFromList);
        } catch (TimeoutException e) {
            System.out.println("element Поле поиска wasn't loaded during" + MAX_LOAD_TIME + " sec");
        }
    }

    public ProductPage navigateToProductPage() {
        //WebElement searchButton = driver.findElement(By.xpath("//button[contains(@class ,'button2')]"));
        //searchButton.click();
        //wait.until(ExpectedConditions.stalenessOf(searchButton));
        //return new ProductPage(driver);
        //wait = new WebDriverWait(driver, MAX_WAIT_TIME_SEC);
        //WebElement searchButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(@class ,'button2')]")));
        //try {
        //searchButton.click();
        //throw new TimeoutException();
        //} catch (TimeoutException ignore){
        //}


        //wait = new WebDriverWait(driver, 10);
        //WebElement searchButton = driver.findElement(By.xpath("//button[contains(@class ,'button2')]"));
        //searchButton.click();
        //wait.until(ExpectedConditions.stalenessOf(searchButton));
        //return new ProductPage(driver);

        try {
            clickAndCloseWhenReady(searchButton, MAX_LOAD_TIME);
        } catch (TimeoutException e) {
            System.out.println("element Кнопка Найти wasn't loaded during" + MAX_LOAD_TIME + " sec");
        }
        return new ProductPage(driver);


    }
}

package yandexmarket.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractPage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
    }

    public LandingPage navigateToYandex(){
            driver.get("https://www.yandex.ru");
            return new LandingPage(driver);
    }

    public void clickAndCloseWhenReady(By locator, long timeout){
        wait = new WebDriverWait(driver, timeout);
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(locator));
        button.click();
        wait.until(ExpectedConditions.stalenessOf(button));
    }


    public void clickCheckBoxWhenReady(By locator, long timeout){
        wait = new WebDriverWait(driver, timeout);
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(locator));
        button.click();
        wait.until(ExpectedConditions.elementToBeSelected(button));
    }


    public WebElement getWhenVisible(By locator, long timeout) {

        wait = new WebDriverWait(driver, timeout);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return element;

    }
}
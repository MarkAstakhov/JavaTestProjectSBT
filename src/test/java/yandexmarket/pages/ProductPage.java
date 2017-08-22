package yandexmarket.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

public class ProductPage extends AbstractPage {

    private static final long MAX_LOAD_TIME = 10;

    By productName = By.xpath("//div[@class='n-title__text']");

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public String getProductName() {

        //WebDriverWait wait = new WebDriverWait(driver, 10);
        //WebElement nameOfProduct = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[1]/div[4]/div[1]/div[1]/div/div[1]/h1")));

        String string = null;
        try {
            string = getWhenVisible(productName, MAX_LOAD_TIME).getText();
        } catch (TimeoutException e) {
            System.out.println("element Имя товара wasn't loaded during" + MAX_LOAD_TIME + " sec");
        }
        return string;
    }


}

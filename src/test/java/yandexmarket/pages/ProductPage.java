package yandexmarket.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

public class ProductPage extends AbstractPage {

    By productName = By.xpath("//div[@class='n-title__text']");

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public String getProductName() {

        String string = null;
        try {
            string = getWhenVisible(productName).getText();
        } catch (TimeoutException e) {
            throw e;
        }
        return string;
    }


}

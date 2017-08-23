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

        String string = null;
        try {
            string = getWhenVisible(productName, MAX_LOAD_TIME).getText();
        } catch (TimeoutException e) {
            throw e;
            //System.out.println("element Имя товара wasn't loaded during" + MAX_LOAD_TIME + " sec");
        }
        return string;
    }


}

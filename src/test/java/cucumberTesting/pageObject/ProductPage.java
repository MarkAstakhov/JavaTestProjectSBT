package cucumberTesting.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage extends AbstractPage{
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public String getProductName(){
        WebElement nameOfProduct = driver.findElement(By.xpath("//*[@id='header-search']"));
        return nameOfProduct.getText();
    }

}

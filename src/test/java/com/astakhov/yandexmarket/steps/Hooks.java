package com.astakhov.yandexmarket.steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Hooks {

    static WebDriver driver;

    @Before(value = "@All")
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        capabilities.setCapability("pageLoadStrategy", "none");

        driver = new ChromeDriver(capabilities);
    }

    @After(value = "~@All")
    public void closeDriver() {
        driver.quit();
    }

}

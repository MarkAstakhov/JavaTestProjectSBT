package cucumberTesting.steps;

import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumberTesting.pageObject.FilterPage;
import cucumberTesting.pageObject.LandingPage;
import cucumberTesting.pageObject.ProductPage;
import cucumberTesting.pageObject.YandexMarketPage;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Time;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class MyStepdefs {

    WebDriver driver;
    LandingPage landingPage;
    YandexMarketPage yandexMarketPage;
    FilterPage filterPage;
    ProductPage productPage;

    @Before
    public void setup() {
        //System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\geckodriver-0.18\\geckodriver.exe");
        //DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        //capabilities.setCapability("marionette", true);
        //capabilities.setCapability(CapabilityType.PAGE_LOAD_STRATEGY, "normal");
        //driver = new FirefoxDriver(capabilities);


        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver-2.31\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        capabilities.setCapability("pageLoadStrategy", "none");



        driver = new ChromeDriver(capabilities);
        //driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

    }

    @Given("^I open the Firefox browser and expand to full screen$")
    public void iOpenTheFirefoxBrowserAndExpandToFullScreen(){
        driver.manage().window().maximize();
    }

    @And("^I open yandex\\.ru$")
    public void iOpenYandexRu(){
        landingPage = new LandingPage(driver);
        landingPage.navigateToYandex();

        }


    @When("^I select \"([^\"]*)\"\\(market\\.yandex\\.ru\\)$")
    public void iSelectTheSectionMarketYandexRu(String arg0) {
        yandexMarketPage = landingPage.navigateToYandexMarket(arg0);
    }

    @And("^I select the section \"([^\"]*)\"$")
    public void iSelectTheSubsection(String arg0) {
        yandexMarketPage.navigateToSection(arg0);
    }

    @And("^I select the subsection \"([^\"]*)\"$")
    public void iSelectTheSubsubsection(String arg0) {
        yandexMarketPage.navigateToSubSection(arg0);
    }

    @And("^I go to advanced search$")
    public void iGoToAdvancedSearch(){
            filterPage = yandexMarketPage.navigateToFilterPage();
    }

    @And("^I set the search parametr (\\d+) rubles$")
    public void iSetTheSearchParametrRubles(int arg0){
        filterPage.setUpperBoundPrice(arg0);
    }

    @And("^I choose the manufacturers (.*)$")
    public void iChooseTheManufacturersHPLenovo(List<String> arg){
        filterPage.setManufacturers(arg);
    }

    @And("^I click the Apply button$")
    public void iClickTheApplyButton(){
        yandexMarketPage = filterPage.navigateToYandexMarketPage();
    }

    @Then("^I check that the items on page (\\d+)$")
    public void iCheckThatTheItemsOnPage(int arg0){
        Assert.assertEquals(arg0, yandexMarketPage.countElementsOnPage());
    }

    @And("^I remember the item number (\\d+) from the list$")
    public void rememberTheItemNumberFromTheList(int arg0){
        yandexMarketPage.getElementFromList(arg0);
    }

    @And("^I enter the stored value in the search string$")
    public void iEnterTheStoredValueInTheSearchString(){
        yandexMarketPage.setSearchField();
    }

    @And("^I find and verify that the name of the product corresponds to the stored value$")
    public void iFindAndVerifyThatTheNameOfTheProductCorrespondsToTheStoredValue() {
        productPage = yandexMarketPage.navigateToProductPage();
        Assert.assertEquals(productPage.getProductName(), yandexMarketPage.elementFromList);
    }

    @And("^I close the browser$")
    public void iCloseTheBrowser(){
        //productPage.closeDriver();

    }

}

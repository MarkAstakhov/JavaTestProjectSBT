package cucumberTesting.steps;

import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumberTesting.pageObject.FilterPage;
import cucumberTesting.pageObject.LandingPage;
import cucumberTesting.pageObject.YandexMarketPage;
import org.apache.xpath.SourceTree;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import org.openqa.selenium.chrome.ChromeDriver;

public class MyStepdefs {

    WebDriver driver;
    LandingPage landingPage;
    YandexMarketPage yandexMarketPage;
    FilterPage filterPage;

    @Before
    public void setup() {
        //System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\geckodriver-0.18\\geckodriver.exe");
        //DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        //capabilities.setCapability("marionette", true);
        //driver = new FirefoxDriver(capabilities);
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver-2.31\\chromedriver.exe");
        driver = new ChromeDriver();
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
    public void iGoToAdvancedSearch() throws Throwable {
        filterPage = yandexMarketPage.navigateToFilterPage();
        throw new PendingException();
    }

    @And("^I set the search parametr (\\d+) rubles$")
    public void iSetTheSearchParametrRubles(int arg0) throws Throwable {
        System.out.println("ddfdf");
        throw new PendingException();
    }

    @And("^I choose the manufacturers HP and Lenovo$")
    public void iChooseTheManufacturersHPAndLenovo() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^I click the Apply button$")
    public void iClickTheApplyButton() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^I check that the items on page (\\d+)$")
    public void iCheckThatTheItemsOnPage(int arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^I remember the first item in the list$")
    public void iRememberTheFirstItemInTheList() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^I enter the stored value in the search string$")
    public void iEnterTheStoredValueInTheSearchString() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^I find and verify that the name of the product corresponds to the stored value$")
    public void iFindAndVerifyThatTheNameOfTheProductCorrespondsToTheStoredValue() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^I close the browser$")
    public void iCloseTheBrowser() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}

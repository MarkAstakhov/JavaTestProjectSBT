package yandexmarket.steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import yandexmarket.pages.FilterPage;
import yandexmarket.pages.LandingPage;
import yandexmarket.pages.ProductPage;
import yandexmarket.pages.YandexMarketPage;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;


public class StepDefinitions {

    WebDriver driver;
    LandingPage landingPage;
    YandexMarketPage yandexMarketPage;
    FilterPage filterPage;
    ProductPage productPage;

    public StepDefinitions() {
        driver = Hooks.driver;
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

    @And("^I set the search price parametr from (\\d+) rubles$")
    public void iSetTheSearchPriceParametrFrom(int arg0){
        filterPage.setLowerBoundPrice(arg0);
    }

    @And("^I set the search price parametr to (\\d+) rubles$")
    public void iSetTheSearchPriceParametrTo(int arg0){
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
}

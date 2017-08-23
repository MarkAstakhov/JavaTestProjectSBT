package yandexmarket.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.TimeoutException;
import ru.yandex.qatools.allure.annotations.Attachment;
import yandexmarket.pages.FilterPage;
import yandexmarket.pages.LandingPage;
import yandexmarket.pages.ProductPage;
import yandexmarket.pages.YandexMarketPage;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

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
    public void iSelectTheSectionMarketYandexRu(String arg0) throws TimeoutException{
        try{
        yandexMarketPage = landingPage.navigateToYandexMarket(arg0);
    }catch (TimeoutException e){
        ExceptionMessage("section Маркет wasn't loaded, change MAX_LOAD_TIME for page");
        throw e;
    }
    }

    @And("^I select the section \"([^\"]*)\"$")
    public void iSelectTheSubsection(String arg0) throws TimeoutException{
        try{
        yandexMarketPage.navigateToSection(arg0);
    }catch (TimeoutException e){
        ExceptionMessage("section Компьютеры wasn't loaded, change MAX_LOAD_TIME for page");
        throw e;
    }
    }

    @And("^I select the subsection \"([^\"]*)\"$")
    public void iSelectTheSubsubsection(String arg0) throws TimeoutException{
        try {
            yandexMarketPage.navigateToSubSection(arg0);
        }catch (TimeoutException e){
            ExceptionMessage("section Ноутбуки wasn't loaded, change MAX_LOAD_TIME for page");
            throw e;
        }
    }

    @And("^I go to advanced search$")
    public void iGoToAdvancedSearch()throws TimeoutException{
        try {
            filterPage = yandexMarketPage.navigateToFilterPage();
        }catch (TimeoutException e){
            ExceptionMessage("element Перейти ко всем фильтрам wasn't loaded, change MAX_LOAD_TIME for page");
            throw e;
        }
    }

    @And("^I set the search price parametr from (\\d+) rubles$")
    public void iSetTheSearchPriceParametrFrom(int arg0)throws TimeoutException{
        try{
        filterPage.setLowerBoundPrice(arg0);
    }catch (TimeoutException e){
        ExceptionMessage("element Поле нижней границы цены wasn't loaded, change MAX_LOAD_TIME for page");
        throw e;
    }
    }

    @And("^I set the search price parametr to (\\d+) rubles$")
    public void iSetTheSearchPriceParametrTo(int arg0)throws TimeoutException{
        try{
        filterPage.setUpperBoundPrice(arg0);
    }catch (TimeoutException e){
        ExceptionMessage("element Поле верхней границы цены wasn't loaded, change MAX_LOAD_TIME for page");
        throw e;
    }
    }

    @And("^I choose the manufacturers (.*)$")
    public void iChooseTheManufacturersHPLenovo(List<String> arg)throws TimeoutException{
        try{
        filterPage.setManufacturers(arg);
    }catch (TimeoutException e){
        ExceptionMessage("element Производители wasn't loaded, change MAX_LOAD_TIME for page");
        throw e;
    }
    }

    @And("^I click the Apply button$")
    public void iClickTheApplyButton()throws TimeoutException{
        try{
        yandexMarketPage = filterPage.navigateToYandexMarketPage();
    }catch (TimeoutException e){
        ExceptionMessage("element Применить фильтры wasn't loaded, change MAX_LOAD_TIME for page");
        throw e;
    }
    }

    @Then("^I check that the items on page (\\d+)$")
    public void iCheckThatTheItemsOnPage(int arg0)throws TimeoutException{
        try{
        Assert.assertEquals(arg0, yandexMarketPage.countElementsOnPage());
    }catch (TimeoutException e){
        ExceptionMessage("element Список товаров wasn't loaded, change MAX_LOAD_TIME for page");
        throw e;
    }
    }

    @And("^I remember the item number (\\d+) from the list$")
    public void rememberTheItemNumberFromTheList(int arg0)throws TimeoutException{
        yandexMarketPage.getElementFromList(arg0);
    }

    @And("^I enter the stored value in the search string$")
    public void iEnterTheStoredValueInTheSearchString()throws TimeoutException{
        try{
        yandexMarketPage.setSearchField();
    }catch (TimeoutException e){
        ExceptionMessage("element Поле поиска wasn't loaded, change MAX_LOAD_TIME for page");
        throw e;
    }
    }

    @And("^I find and verify that the name of the product corresponds to the stored value$")
    public void iFindAndVerifyThatTheNameOfTheProductCorrespondsToTheStoredValue() throws TimeoutException{
        try{
        productPage = yandexMarketPage.navigateToProductPage();
        Assert.assertEquals(productPage.getProductName(), yandexMarketPage.elementFromList);
    }catch (TimeoutException e){
        ExceptionMessage("element Имя товара wasn't loaded, change MAX_LOAD_TIME for page");
        throw e;
    }
    }

    @Attachment()
    private static String ExceptionMessage(String message) throws TimeoutException{
        return message;
    }
}

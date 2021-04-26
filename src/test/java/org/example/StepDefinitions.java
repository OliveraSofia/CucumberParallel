package org.example;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import parallel.WikipediaHomePage;

public class StepDefinitions {




    //To do: Update Steps Names to be (unicly identify) by feature

    //Testing with Several browsers:

    //To do Ordenar steps
    //make steps and featuress claan make the mos little posible
    // single place to manteniance
    //paralel
    //think as an user

    //Wikipedia Steps Definitions

    @Given("^User choose the \"([^\"]*)\" browser$")
    public void openPageOnBrowser(String browser) throws Exception {
        WikipediaHomePage.openBrowser(browser);

    }

    @When("^The Home page is load$")
    public void openMainPage(){
        WikipediaHomePage.openPage();
    }

    @Then("^Close the browser$")
    public void closeBrowser(){
        WikipediaHomePage.closeBrowser();

    }

    @When("^Language \"([^\"]*)\" is Selected$")
    public void selectLanguage(String language){
        WikipediaHomePage.initHashMap();
        WikipediaHomePage.selectLanguage(language);
    }

    // Under construction check on Home Page
    @Then("^The mine page is displayed on $")
    public void verifyPageLanguage(String language){
        WikipediaHomePage.verifyPageLanguage(language);
    }

    @When("^User clicks on access Link$")
    public void clickOnAccess(){
        WikipediaHomePage.goToLoguinPage();
    }

    //This step put together other steps to have reduced the steps on features
    @Given("^English user is on login Page$")
    public void loadLoguinENChrome() throws Exception {
        WikipediaHomePage.openBrowser("chrome");
        WikipediaHomePage.openPage();
        WikipediaHomePage.initHashMap();
        WikipediaHomePage.selectLanguage("English");
        WikipediaHomePage.goToLoguinPage();
    }

    @When("^User login with \"([^\"]*)\" and \"([^\"]*)\"$")
    public void loginPage(String username, String password){
        WikipediaHomePage.setLogin(username, password);
    }

    @And("^Click on submit button$")
    public void clickOnSubmitLogin(){
        WikipediaHomePage.clickOnSubmitLogin();
    }


}

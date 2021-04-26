package parallel;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.HashMap;

public class WikipediaHomePage {

    private static final String EN_LANGUAGE_TEXT = "English";
    private static final String ES_LANGUAGE_TEXT = "Español";
    private static final String JA_LANGUAGE_TEXT = "Japanese";
    private static final String DE_LANGUAGE_TEXT = "Deutsch";
    private static final String FR_LANGUAGE_TEXT = "French";
    private static final String ZH_LANGUAGE_TEXT = "Chinese";
    private static final String PL_LANGUAGE_TEXT = "Polski";
    private static final String RU_LANGUAGE_TEXT = "Russian";
    private static final String IT_LANGUAGE_TEXT = "Italian";
    private static final String PT_LANGUAGE_TEXT = "Portugues";


    @FindBy(xpath = "//*[@id='js-link-box-en']/strong")
    static WebElement engLink;

    @FindBy(xpath = "//*[@id='js-link-box-es']/strong")
    static WebElement spaLink;

    @FindBy(xpath = "//*[@id='js-link-box-ja']/strong")
    static WebElement japLink;

    @FindBy(xpath = "//*[@id='js-link-box-de']/strong")
    static WebElement deuLink;

    @FindBy(xpath = "//*[@id='js-link-box-fr']/strong")
    static WebElement franLink;

    @FindBy(xpath = "//*[@id='js-link-box-zh']/strong")
    static WebElement chiLink;

    @FindBy(xpath = "//*[@id='js-link-box-pl']/strong")
    static WebElement polLink;

    @FindBy(xpath = "//*[@id='js-link-box-ru']/strong")
    static WebElement ruLink;

    @FindBy(xpath = "//*[@id='js-link-box-it']/strong")
    static WebElement italLink;

    @FindBy(xpath = "//*[@id='js-link-box-pt']/strong")
    static WebElement portlLink;

    public static void initHashMap(){
        languageList();
    }

    public static void openBrowser(String browser) throws Exception {
        Driver.selectBrowser(browser);
    }

    public static void openPage(){
        Driver.openPage("wikipedia");
    }

    public static void closeBrowser(){
        Driver.quit();
    }

//To do: xlsx file with accounts and lenguages

    static HashMap<String, WebElement> languages = new HashMap<>();

    public static void languageList(){

        languages.put(EN_LANGUAGE_TEXT, engLink);
        languages.put(ES_LANGUAGE_TEXT, spaLink);
        languages.put(JA_LANGUAGE_TEXT, japLink);
        languages.put(DE_LANGUAGE_TEXT, deuLink);
        languages.put(FR_LANGUAGE_TEXT, franLink);
        languages.put(ZH_LANGUAGE_TEXT, chiLink);
        languages.put(PL_LANGUAGE_TEXT, polLink);
        languages.put(RU_LANGUAGE_TEXT, ruLink);
        languages.put(IT_LANGUAGE_TEXT, italLink);
        languages.put(PT_LANGUAGE_TEXT, portlLink);

    }

    @FindBy(xpath = "//@lang")
    static WebElement languagePage;

    public static void selectLanguage(String language){
        languages.get(language).click();
    }

    public static void verifyPageLanguage(String language){
        // To Do: Reserch language recognition (Apache Tika?)
    }

    @FindBy(xpath = "//*[@id='pt-login']")
    static WebElement accessButton;

    @FindBy(xpath = "//*[@id='wpName1']")
    static WebElement boxUsername;

    @FindBy(xpath = "//*[@id='wpPassword1']")
    static WebElement boxPassword;

    @FindBy(xpath = "//*[@id='wpLoginAttempt']")
    static WebElement loginButton;


    public static void setLogin(String valueUsername, String valuePassword){

        //To Do: take values from xlsx

        boxUsername.sendKeys(valueUsername);
        boxPassword.sendKeys(valuePassword);

    }

    public static void goToLoguinPage(){
        accessButton.click();
    }

    public static void clickOnSubmitLogin(){
        loginButton.click();
    }


}

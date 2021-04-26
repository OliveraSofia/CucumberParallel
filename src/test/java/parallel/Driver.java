package parallel;


import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import java.util.Properties;

public class Driver {

    private static Properties Properties;
    public static WebDriver driver;

    //main method Setup for amazon feature: detect the So and take browser from properties
    @BeforeClass
    public static void setup() throws Exception {


        Properties = Reader.readProperties("src/test/resources/test.properties");
        if(getBrowser().equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver", Properties.getProperty(getFirefoxOS()));
            driver = new FirefoxDriver();
        }
        else if(getBrowser().equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver", Properties.getProperty(getChromeOS()));
            driver = new ChromeDriver();
        }
/*
        else if(getBrowser().equalsIgnoreCase("edge")){

            System.setProperty("webdriver.edge.driver",Properties.getProperty(getOS()));
            driver = new EdgeDriver();
        }

 */
        else{
            throw new Exception("Please configure webdriver for " + getBrowser() + " in Init file.");
        }

  //      PageFactory.initElements(driver, AmazonHomePage.class);

    }
    //method to take binary file url from properties
    public static String getChromeOS() throws Exception {
        String OpSist = System.getProperty("os.name");
        String driverPath = "";

        if (OpSist.contains("Mac")) {

            System.out.print("Sistem name: " + OpSist);
            driverPath ="MacdriverPath";
        }
        else if (OpSist.contains("Windows"))
        {
            System.out.print("Sistem name: " + OpSist);
            driverPath ="WindowsdriverPath";
        }
        else {
            throw new Exception("Please configure webdriver for " + OpSist + " in Init file.");
        }

        System.out.print("driver: "+driverPath);
        return driverPath;

    }

    //method to take binary file url from properties
    public static String getFirefoxOS() throws Exception {
        String OpSist = System.getProperty("os.name");
        String driverPath = "";

        if (OpSist.contains("Mac")) {

            System.out.print("Sistem name: " + OpSist);
            driverPath ="MacfirefoxPath";
        }
        else if (OpSist.contains("Windows"))
        {
            System.out.print("Sistem name: " + OpSist);
            driverPath ="WindowsfirefoxPath";
        }
        else {
            throw new Exception("Please configure webdriver for " + OpSist + " in Init file.");
        }

        System.out.print("driver: "+driverPath);
        return driverPath;

    }
    //Method to amazon take browser string from properties
    public static String getBrowser(){
        String browser;
        browser = Properties.getProperty("browser");
        return browser;
    }

    public static void quit() {
        driver.quit();
    }
    //method used by both features to take url string from properties
    public static void openPage(String url){
        driver.get(Properties.getProperty(url));
    }
    //main method Setup for wikipedia feature: detect the SO and take browser from parameter
    public static void selectBrowser(String browser) throws Exception {

        Properties = Reader.readProperties("src/test/resources/test.properties");
        if(browser.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver", Properties.getProperty(getFirefoxOS()));
            driver = new FirefoxDriver();
        }
        else if(browser.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver", Properties.getProperty(getChromeOS()));
            driver = new ChromeDriver();
        }
/*
        else if(browser.equalsIgnoreCase("edge")){

            System.setProperty("webdriver.edge.driver",Properties.getProperty(getOS()));
            driver = new EdgeDriver();
        }

 */
        else{
            throw new Exception("Please configure webdriver for " + getBrowser() + " in Init file.");
        }

        PageFactory.initElements(driver, WikipediaHomePage.class);

    }

}

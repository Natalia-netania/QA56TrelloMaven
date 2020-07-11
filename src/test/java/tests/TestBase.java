package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
//import pages.HomePageHelper;
import org.testng.annotations.BeforeSuite;
import ru.stqa.selenium.SuiteConfiguration;
import ru.stqa.selenium.factory.WebDriverPool;
import ru.stqa.selenium.pages.*;

import java.io.IOException;
import java.net.URL;

public class TestBase {

    protected static URL gridHubUrl = null;
    protected static String baseUrl;
    protected static Capabilities capabilities;

    protected WebDriver driver;
    public static final String BOARD_TITLE = "QA Haifa56";
    public static final String LOGIN = "serg_ya@yahoo.com";
    public static final String PASSWORD = "Leto2020zara";
    HomePageHelper homePage;

    @BeforeSuite
    public void initTestSuite() throws IOException {
        SuiteConfiguration config = new SuiteConfiguration();
        baseUrl = config.getProperty("site.url");
        if (config.hasProperty("grid.url") && !"".equals(config.getProperty("grid.url"))) {
            gridHubUrl = new URL(config.getProperty("grid.url"));
        }
        capabilities = config.getCapabilities();
    }

    @BeforeMethod
    public void initWbDriver() {
        //---- Enter to the application ---
        //driver = new ChromeDriver();
        driver = WebDriverPool.DEFAULT.getDriver(gridHubUrl, capabilities);
        driver.get(baseUrl);
        homePage = PageFactory.initElements(driver, HomePageHelper.class);
        homePage.waitUntilPageIsLoaded();
        //waitUntilElemetIsClickable(By.linkText("Log In"),20);

    }

    @AfterMethod
    public void tearDownForTest(){
       driver.quit();
    }
    /*public void waitUntilElemetIsVisible(By locator, int time) {
        try {
            new WebDriverWait(driver,time).until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void waitUntilElemetIsClickable(By locator, int time) {
        try {
            new WebDriverWait(driver,time).until(ExpectedConditions.elementToBeClickable(locator));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void waitUntilAttributeValuesIs(By locator, String atribute, String value, int time) {
        try {
            new WebDriverWait(driver,time).until(ExpectedConditions.attributeToBe(locator, atribute, value ));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        WebDriverPool.DEFAULT.dismissAll();
    }
}

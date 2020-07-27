package tests;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
//import pages.HomePageHelper;
import org.testng.annotations.BeforeSuite;
import ru.stqa.selenium.SuiteConfiguration;
import ru.stqa.selenium.factory.WebDriverPool;
import ru.stqa.selenium.pages.*;
import util.LogLog4j;

import java.io.File;
import java.io.IOException;
import java.net.URL;
//import java.nio.file.Files;
//import java.nio.file.Files;
//import  com.google.common.io;

public class TestBase {

    protected static URL gridHubUrl = null;
    protected static String baseUrl;
    protected static Capabilities capabilities;

    protected EventFiringWebDriver driver;
    public static final String BOARD_TITLE = "QA Haifa56";
    public static final String LOGIN = "serg_ya@yahoo.com";
    public static final String PASSWORD = "Leto2020zara";
    HomePageHelper homePage;
    public static LogLog4j log4j = new LogLog4j();
    public static class MyListener extends AbstractWebDriverEventListener{

        @Override
        public void beforeFindBy(By by, WebElement element, WebDriver driver) {
            //System.out.println("Find element: " +by);
            log4j.info("Find element: " +by);
        }

        @Override
        public void afterFindBy(By by, WebElement element, WebDriver driver) {
            //System.out.println("Element " + by + "was find");
            log4j.info("Element: " +by + "was find");
        }

        @Override
        public void onException(Throwable throwable, WebDriver driver) {
           // System.out.println("Error: " + throwable);
            String screenName = "screen-" + System.currentTimeMillis() + ".png";
            log4j.info("-------------------------------------------------------");
            createShapshot(screenName, driver);
            log4j.error("Error: " + throwable + " See file " + screenName);
        }
      }

    public static void createShapshot(String name, WebDriver driver){
        File tmp =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File screen = new File(name);
        try {
            Files.copy(tmp,screen);
        } catch (IOException e) {
            e.printStackTrace();
        }
      //  return screen.getName();
    }



    @BeforeSuite(alwaysRun = true)
    public void initTestSuite() throws IOException {
        SuiteConfiguration config = new SuiteConfiguration();
        baseUrl = config.getProperty("site.url");
        if (config.hasProperty("grid.url") && !"".equals(config.getProperty("grid.url"))) {
            gridHubUrl = new URL(config.getProperty("grid.url"));
        }
        capabilities = config.getCapabilities();
    }

    @BeforeMethod(alwaysRun = true)
    public void initWbDriver() {
        //---- Enter to the application ---
        //driver = new ChromeDriver();
        driver = new EventFiringWebDriver(WebDriverPool.DEFAULT.getDriver(gridHubUrl, capabilities));
        driver.register(new MyListener());
        driver.get(baseUrl);
        homePage = PageFactory.initElements(driver, HomePageHelper.class);
        homePage.waitUntilPageIsLoaded();
        //waitUntilElemetIsClickable(By.linkText("Log In"),20);

    }

    @AfterMethod(alwaysRun = true)
    public void tearDownForTest(ITestResult result){
        if (result.getStatus() == ITestResult.FAILURE){
            String screenName = "screen-" + System.currentTimeMillis() + ".png";
            log4j.info("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            createShapshot(screenName, driver);
            log4j.error("Test failure,  " + "see file " + screenName);
            log4j.info("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        }

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

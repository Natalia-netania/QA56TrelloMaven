package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.selenium.pages.*;
import ru.stqa.selenium.pages.LoginPageHelper;
import util.DataProviders;


public class LoginTests extends TestBase {
    LoginPageHelper loginPage;
    BoardsPageHelper boardsPage;

    @BeforeMethod
    public void initTests(){

        loginPage = PageFactory.initElements(driver, LoginPageHelper.class);
        boardsPage = PageFactory.initElements(driver, BoardsPageHelper.class);
        loginPage.openLoginPage();

    }
        @Test(groups = {"smoke","regression", "login"})
        public void loginTestPositive()  {

           // loginPage.openLoginPage();
            log4j.startTestCase("loginTestPositive");
            log4j.info("Login/password were entering: " + LOGIN +"," + PASSWORD);
            loginPage.enterLoginAtlassianAndClicLogin(LOGIN)
            .enterPasswordAtlassionAndClickPassword(PASSWORD);
            log4j.info("Boards screen is loading");
            log4j.info("Wait until submit button is clickable");
            boardsPage.waitUntilPageIsLoaded();
            log4j.info("Test result verification (assert): Text on the boardIcon is 'Boards");
            Assert.assertEquals(boardsPage.getButtonBoardsText(),"Доски","Text on the boardIcon is not 'Доски'");

        }

    @Test(groups = {"smoke"},dataProviderClass =DataProviders.class,dataProvider = "dataProviderFirst")
        public void loginTestNegative1 (String login,String password, String message) throws InterruptedException {

        loginPage.enterLoginAndPassword(login)
                .enterPasswordNormal(password);
        Thread.sleep(2000);//я не понимаю почему работает только с задержкой, а с другими командами - не работает-internet tormoz
        //.waitLoginButtonIsClickable()
        loginPage.pressLoginButton()
        .waitErrorMessageLoginIncorrect();
          Assert.assertEquals(loginPage.getErrorMessageloginIncorrect(), message,
                "Error message is not correct");
        }

    @Test(dataProviderClass =DataProviders.class,dataProvider = "dataProviderSecond")
    public void loginTestNegative1DP2 (String login,String password, String message) throws InterruptedException {
        log4j.startTestCase("loginTestNegative1DP2: " + login + ", " +password + ", " + message);
        log4j.info("Login to system: " + login + ", " +password + ", " + message);
        loginPage.enterLoginAndPassword(login)
                .enterPasswordNormal(password);
        Thread.sleep(2000);//я не понимаю почему работает только с задержкой, а с другими командами - не работает - internet slow
        //.waitLoginButtonIsClickable()
        loginPage.pressLoginButton()
                .waitErrorMessageLoginIncorrect();
        Assert.assertEquals(loginPage.getErrorMessageloginIncorrect(), message,
                "Error message is not correct");
    }

        @Test(dataProviderClass = DataProviders.class, dataProvider = "DPnegativePasswordIncorrect")
        public void loginTestNegative2(String login, String password) {
             loginPage.loginAsAtlassian(login,password)
            .waitErrorMessagePasswordIncorrect();
            Assert.assertTrue(loginPage.getIncorrectPassswordMessage().contains("Incorrect email address and / or password."),
                    "There is no error message or the text of the message is not correct");
        }

    @Test(dataProviderClass =DataProviders.class,dataProvider = "dataProviderThird")
    public void loginTestNegative1DP3 (String login,String password) throws InterruptedException {

        loginPage.enterLoginAndPassword(login)
                .enterPasswordNormal(password);
        Thread.sleep(2000);//я не понимаю почему работает только с задержкой, а с другими командами - не работает
        //.waitLoginButtonIsClickable()
        loginPage.pressLoginButton()
                .waitErrorMessageLoginIncorrect();
        Assert.assertEquals(loginPage.getErrorMessageloginIncorrect(), "There isn't an account for this email",
                "Error message is not correct");
    }

    }

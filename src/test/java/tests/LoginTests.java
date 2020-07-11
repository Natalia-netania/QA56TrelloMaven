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
        @Test
        public void loginTestPositive()  {

           // loginPage.openLoginPage();
            loginPage.enterLoginAtlassianAndClicLogin(LOGIN)
            .enterPasswordAtlassionAndClickPassword(PASSWORD);
            boardsPage.waitUntilPageIsLoaded();
            Assert.assertEquals(boardsPage.getButtonBoardsText(),"Доски","Text on the boardIcon is not 'Доски'");

        }

    @Test(dataProviderClass =DataProviders.class,dataProvider = "dataProviderFirst")
        public void loginTestNegative1 (String login,String password, String message) throws InterruptedException {

        loginPage.enterLoginAndPassword(login)
                .enterPasswordNormal(password);
        Thread.sleep(2000);//я не понимаю почему работает только с задержкой, а с другими командами - не работает
        //.waitLoginButtonIsClickable()
        loginPage.pressLoginButton()
        .waitErrorMessageLoginIncorrect();
          Assert.assertEquals(loginPage.getErrorMessageloginIncorrect(), message,
                "Error message is not correct");
        }

        @Test
        public void loginTestNegative2() {
             loginPage.loginAsAtlassian(LOGIN,"123")
            .waitErrorMessagePasswordIncorrect();
            Assert.assertTrue(loginPage.getIncorrectPassswordMessage().contains("Incorrect email address and / or password."),
                    "There is no error message or the text of the message is not correct");
        }
    }

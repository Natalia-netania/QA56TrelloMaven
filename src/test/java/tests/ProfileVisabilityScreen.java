package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.selenium.pages.*;


import java.util.Objects;

public class ProfileVisabilityScreen extends TestBase {

    LoginPageHelper loginPage;
    BoardsPageHelper boardsPage;
    ProfileVisabilityScreenHelper profilePage;

    @BeforeMethod
    public void initTests() throws InterruptedException {

        //loginPage = new LoginPageHelper(driver);
       // boardsPage = new BoardsPageHelper(driver);
        loginPage = PageFactory.initElements(driver, LoginPageHelper.class);
        boardsPage = PageFactory.initElements(driver, BoardsPageHelper.class);
        //profilePage = new ProfileVisabilityScreenHelper(driver);
        profilePage = PageFactory.initElements(driver, ProfileVisabilityScreenHelper.class);
        loginPage.openLoginPage();
        loginPage.loginAsAtlassian(LOGIN, PASSWORD);
        boardsPage.waitUntilPageIsLoaded();
        Thread.sleep(5000);
        profilePage.waitUntilElementIsClickable();
        profilePage.clickMenuButton();
    }

    @Test
    public void comparisonLabelTextVerification() {
        log4j.startTestCase("comparisonLabelTextVerification");
        log4j.info("Login/password were entering: " + LOGIN +"," + PASSWORD);
        profilePage.waitUntilElementIsVisible();
        log4j.info("Get Name Button");
        profilePage.getNameButton();
        if(
                Objects.equals(profilePage.getNameButtonText(),profilePage.getNameButtonTitleText() )
        )
        {
            System.out.println("Profile labels match and equal " + profilePage.getNameButtonText());
        }
        Assert.assertEquals(profilePage.getNameButtonText(),"N","Error: Profile labels do not match");
    }

    @Test
    public void userNameVerification(){

        log4j.startTestCase("userNameVerification");

        profilePage.waitUntilElementIsClickable1();
        log4j.info("Wait until load Button User Menu");
        profilePage.loadButtonUserName();
        log4j.info("Wait until load Button User Menu title");
        profilePage.loadButtonUserNamePub();
        Assert.assertTrue(profilePage.getNameUserName().contains("natalia46615563")&&profilePage.getNameUserNamePub().equals("natalia46615563"));
    }

}

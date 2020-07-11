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
    public void initTests() {

        //loginPage = new LoginPageHelper(driver);
       // boardsPage = new BoardsPageHelper(driver);
        loginPage = PageFactory.initElements(driver, LoginPageHelper.class);
        boardsPage = PageFactory.initElements(driver, BoardsPageHelper.class);
        //profilePage = new ProfileVisabilityScreenHelper(driver);
        profilePage = PageFactory.initElements(driver, ProfileVisabilityScreenHelper.class);
        loginPage.openLoginPage();
        loginPage.loginAsAtlassian(LOGIN, PASSWORD);
        boardsPage.waitUntilPageIsLoaded();

        profilePage.waitUntilElementIsClickable();
        profilePage.clickMenuButton();
    }

    @Test
    public void comparisonLabelTextVerification() {
        profilePage.waitUntilElementIsVisible();
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

        profilePage.waitUntilElementIsClickable1();
        profilePage.loadButtonUserName();
        profilePage.loadButtonUserNamePub();
        Assert.assertTrue(profilePage.getNameUserName().contains("natalia46615563")&&profilePage.getNameUserNamePub().equals("natalia46615563"));
    }

}

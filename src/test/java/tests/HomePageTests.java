package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.selenium.pages.HomePageHelper;

public class HomePageTests extends TestBase{
    HomePageHelper homePage;

    @BeforeMethod(alwaysRun = true)
    public void initTests(){

        homePage = PageFactory.initElements(driver, HomePageHelper.class);
    }

   @Test(groups = {"regression"})
  //  @Test
    public void verifyFooterByCoordinates() throws InterruptedException {
     homePage.scrollDown(0,4000);
        Assert.assertEquals("About", homePage.getAboutFooter());

    }

    @Test
    public void verifyFooterToViewElement() throws InterruptedException {
        homePage.scrollDownToViewFooter();
        Assert.assertEquals("About", homePage.getAboutFooter());

    }
}

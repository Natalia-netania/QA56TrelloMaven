package ru.stqa.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HelpSectionPageHelper extends PageBase {

    @FindBy(xpath = "//div[@class='atlaskit-portal']/iframe")
    WebElement frameHelp;

    @FindBy(xpath = "//a[contains(text(),'Getting Started Guide')]")
    WebElement gettingStartedGuideMenu;

    public HelpSectionPageHelper(WebDriver driver) {
        super(driver);
    }

    public void waitUntilPageIsLoaded(){
        log4j.info("-- Class HelpSectionPageHelper, method waitUntilPageIsLoaded() was started");
        log4j.info("Wait until frame is load and swich to it");
     waitUntilFrameIsLoadedAndSwichToIt(frameHelp, 30);
      }

    public void  chooseGettingStartedGuide(){
        waitUntilElementIsClickable(gettingStartedGuideMenu, 15);
        gettingStartedGuideMenu.click();

    }

    public void chooseGettingStartedGuideMenu() {
        log4j.info("-- Class HelpSectionPageHelper, method chooseGettingStartedGuideMenu() was started");
        log4j.info("Wait until Start Guide Menu is cklicable");
        waitUntilElementIsClickable(gettingStartedGuideMenu,15);
        log4j.info("Start Guide Menu click");
        gettingStartedGuideMenu.click();
    }
}

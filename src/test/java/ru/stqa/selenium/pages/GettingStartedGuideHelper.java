package ru.stqa.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GettingStartedGuideHelper extends PageBase {

    @FindBy(xpath = "//a[@class = 'global-header-section-button'][contains(text(),'Go to Your Boards')]")
    WebElement goToYourBoardsUpperButton;

    public GettingStartedGuideHelper(WebDriver driver) {

        super(driver);
    }

    public void switchToNewWindowAndWaitPageLoading() {
        log4j.info("-- Class GettingStartedGuideHelper, method switchToNewWindowAndWaitPageLoading() was started");
        log4j.info("Wait until number 2 of Window");
        waitUntilNumberOfWindows(2, 30);
        String anotherHandle = getAnotherWindowHandle(driver.getWindowHandle());
        log4j.info("Switch to Window");
        switchToWindow(anotherHandle);
        log4j.info("Wait until element 'Go to Your Boards'is clickable");
        waitUntilElementIsClickable(goToYourBoardsUpperButton,20);

    }

}

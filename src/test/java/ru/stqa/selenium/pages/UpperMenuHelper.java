package ru.stqa.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UpperMenuHelper extends PageBase {

    @FindBy(xpath = "//button[@data-test-id = 'headed-member-menu-button']")
    //@FindBy(xpath = "//div[@class='_1FekJJAz6Hu32v']")
    WebElement upperRight;

    @FindBy(xpath = "//a[@data-test-id = 'headed-member-menu-button']")
    //@FindBy(xpath = "//span[contains(text(),'Действия')]")
    //@FindBy(xpath = "//div[@class='atlaskit-portal-container']")
    //div[@class='atlaskit-portal-container']
    WebElement profilevisabilityMenuItem;

    @FindBy(xpath = "(//span[contains(text(),'Действия')]/..)[2]")
    //@FindBy(xpath = "(//a/span[contains(text(),'Действия')]")
    //@FindBy(xpath = "//a[@class='_2jR0BZMM5cBReR']")
    WebElement activityMenuItem;
///
    @FindBy(xpath = "(//span[contains(text(),'Действия')]/..)[2]")
    WebElement activityMenuItemFromCurrentBoard;

    @FindBy(xpath = "//button/span[contains(text(),'Помощь')]")
    WebElement helpMenuItem;

    public UpperMenuHelper(WebDriver driver) {
        super(driver);
    }

    public void waitUntilPageIsLoaded() throws InterruptedException {
        waitUntilElementIsClickable(profilevisabilityMenuItem,20);
        waitUntilElementIsClickable(activityMenuItem,20);
        Thread.sleep(5000);
    }

    public void openProfileVisabilityScreen(){
        profilevisabilityMenuItem.click();
    }

    public void openMenuPage(){
        waitUntilElementIsClickable(upperRight,20);
        upperRight.click();
    }

    public void openActivityPage() {
        activityMenuItem.click();
    }

    public void openHelpMenu(){
        helpMenuItem.click();
    }

}

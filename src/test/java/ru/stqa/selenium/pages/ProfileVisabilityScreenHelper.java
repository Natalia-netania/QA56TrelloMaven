package ru.stqa.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfileVisabilityScreenHelper extends PageBase {

    @FindBy(xpath = "//button[@data-test-id='header-boards-menu-button']/span[2]")
    WebElement headBoardMenuButton;

    @FindBy(xpath = "//button[@data-test-id='header-member-menu-button']")
    WebElement menuButton;

    @FindBy(xpath = "//a[@data-test-id='header-member-menu-profile']")
    WebElement buttonMenu;

    @FindBy(xpath = "//span[@class='_24AWINHReYjNBf'][contains(text(),'N')]")
    //@FindBy(xpath = ".//span")
            WebElement boardMenuButton;

    @FindBy(xpath = "//a[@class='tabbed-pane-nav-item-button js-member-activity']")
    WebElement userMenuButton;

    @FindBy(xpath = "//span[contains(text(),'@')]")
    WebElement userName;

    @FindBy(xpath = "//input[@name='username']")
    WebElement userNamePub;

    public ProfileVisabilityScreenHelper(WebDriver driver){

        super(driver);
    }

    public void waitUntilElementIsClickable(){
        waitUntilElementIsClickable(headBoardMenuButton,40);
    }

    public void waitUntilElementIsClickable1(){

        log4j.info("-- Class ProfileVisabilityScreenHelper, method waitUntilElementIsClickable1() was started");
        //waitUntilElemetIsClickable(By.xpath("//a[@class='tabbed-pane-nav-item-button js-member-activity']"),50);
        log4j.info("Wait until User Menu Button is clickable");
        waitUntilElementIsClickable(userMenuButton,50);
    }

    public void clickMenuButton(){
        log4j.info("-- Class ProfileVisabilityScreenHelper, method clickMenuButton() was started");
       // WebElement menuButton = driver.findElement(By.xpath("//button[@data-test-id='header-member-menu-button']"));
        log4j.info("Click Menu Button N");
        menuButton.click();
        //driver.findElement(By.xpath("//a[@data-test-id='header-member-menu-profile']")).click();
        log4j.info("Click Menu Button 'Профиль и доступ'");
        buttonMenu.click();
    }

    public void getNameButton(){
        //WebElement menuButton = driver.findElement(By.xpath("//button[@data-test-id='header-member-menu-button']"));
        //System.out.println(driver.findElement(By.xpath("//span[@class='_24AWINHReYjNBf'][contains(text(),'N')]")).getText());
        System.out.println(boardMenuButton.getText());
    }

    public String getNameButtonText(){
        //WebElement boardIcon = driver.findElement(By
        //        .xpath("//button[@data-test-id='header-member-menu-button']"));
        //return boardIcon.getText();
        return menuButton.getText();
    }

    public void waitUntilElementIsVisible(){
        log4j.info("-- Class ProfileVisabilityScreenHelper, method waitUntilElementIsVisible() was started");
       // waitUntilElemetIsClickable(By.xpath("//button[@data-test-id='header-member-menu-button']"),40);
        log4j.info("Wait until Menu Button is visible");
        waitUntilElementIsVisible(menuButton,40);
    }

    public String getNameButtonTitleText(){
       // WebElement nameButtonTitle = driver.findElement(By.xpath("//span[@class='_24AWINHReYjNBf'][contains(text(),'N')]"));
       // return nameButtonTitle.getText();
        return boardMenuButton.getText();
    }

   // public void waitUntilElementIsClickable(){
        //waitUntilElemetIsClickable(By.xpath("//a[@class='tabbed-pane-nav-item-button js-member-activity']"),50);
   //     waitUntilElementIsClickable(userMenuButton,50);
   // }

    public  String getNameUserName(){
        //WebElement userName = driver.findElement(By.xpath("//span[contains(text(),'@')]"));
        return userName.getText();
    }

    public String getNameUserNamePub(){
       // WebElement userNamePub = driver.findElement(By.xpath("//input[@name='username']"));
        return userNamePub.getAttribute("value");
    }

    public void loadButtonUserName(){
        //WebElement userName = driver.findElement(By.xpath("//span[contains(text(),'@')]"));
        System.out.println("userName= "+ userName.getText());
        log4j.info("userName= "+ userName.getText());
    }

    public void loadButtonUserNamePub(){
       // WebElement userNamePub = driver.findElement(By.xpath("//input[@name='username']"));
        //System.out.println("userNamePub = " + userNamePub.getText());
        System.out.println("userNamePub = " + userNamePub.getAttribute("value"));
        log4j.info("userNamePub = " + userNamePub.getAttribute("value"));
    }

}

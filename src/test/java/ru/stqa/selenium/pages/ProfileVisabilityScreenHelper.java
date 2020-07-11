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
        //waitUntilElemetIsClickable(By.xpath("//a[@class='tabbed-pane-nav-item-button js-member-activity']"),50);
        waitUntilElementIsClickable(userMenuButton,50);
    }

    public void clickMenuButton(){
       // WebElement menuButton = driver.findElement(By.xpath("//button[@data-test-id='header-member-menu-button']"));
        menuButton.click();
        //driver.findElement(By.xpath("//a[@data-test-id='header-member-menu-profile']")).click();
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
       // waitUntilElemetIsClickable(By.xpath("//button[@data-test-id='header-member-menu-button']"),40);
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
    }

    public void loadButtonUserNamePub(){
       // WebElement userNamePub = driver.findElement(By.xpath("//input[@name='username']"));
        //System.out.println("userNamePub = " + userNamePub.getText());
        System.out.println("userNamePub = " + userNamePub.getAttribute("value"));
    }

}

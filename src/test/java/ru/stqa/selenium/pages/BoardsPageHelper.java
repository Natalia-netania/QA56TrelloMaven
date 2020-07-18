package ru.stqa.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BoardsPageHelper extends PageBase {

    @FindBy(xpath = "//button[@data-test-id='header-boards-menu-button']/span[2]")
    WebElement boardIcon;

    @FindBy(xpath = "//button[@data-test-id = 'header-member-menu-button']")
    WebElement upperRight;

    public BoardsPageHelper(WebDriver driver) {

        super(driver);
    }

    public void waitUntilPageIsLoaded(){

        waitUntilElementIsClickable(boardIcon, 40);
        waitUntilElementIsClickable(upperRight,40);
    }

    public String getButtonBoardsText(){
        return boardIcon.getText();
    }
}

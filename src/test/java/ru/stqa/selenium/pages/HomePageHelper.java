package ru.stqa.selenium.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageHelper extends PageBase {

    @FindBy(linkText = "Log In")
    WebElement logInIcon;

    @FindBy(xpath = "//a[contains(text(),'About')]")
    WebElement aboutFooter;

    public HomePageHelper(WebDriver driver) {

        super(driver);
    }

    public void waitUntilPageIsLoaded() {
       // waitUntilElemetIsClickable(By.linkText("Log In"),20);
        waitUntilElementIsClickable(logInIcon,20);
    }

    public String getAboutFooter() {
        return aboutFooter.getText();
    }

   // public void scrollDown(int x, int y) throws InterruptedException{
   //     JavascriptExecutor js = (JavascriptExecutor) driver;
   //     js.executeScript("window.scrollBy("+ x + "," + y +")");
    //    Thread.sleep(6000);

   // }

    public void scrollDownToViewFooter()
    {
        scrollDownToViewElement(aboutFooter);
    }

    private void scrollDownToViewElement(WebElement aboutFooter) {
    }

}

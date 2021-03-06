package ru.stqa.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageHelper extends PageBase {

    @FindBy(linkText = "Log In")
    WebElement logInIcon;

    @FindBy(id="login")
    WebElement loginButton;

    @FindBy(id="user")
    WebElement userField;

    @FindBy(id="login-submit")
    WebElement loinSubmitButton;

    @FindBy(id = "password")
    WebElement passwordField;

    @FindBy(xpath = "//div[@id='error']//p[@class='error-message']")
    //@FindBy(xpath = "(//*[@class= 'error-message'])[1]")
            WebElement noLoginError;
    ////div[@id='error']//p[@class='error-message']
    //(//*[@class= 'error-message'])[1]")


    @FindBy(xpath="(//*[@class= 'error-message'])[1]")
    WebElement loginError;

    @FindBy(css = "#error>p")
    WebElement noLoginNoPasswordError;

    //@FindBy(xpath = "//div[@id='login-error']/span")
    @FindBy(xpath = "//div[@id='login-error']")
    WebElement noPasswordError;

    public LoginPageHelper(WebDriver driver){

        super(driver);
    }

    public void openLoginPage()

    {
        //WebElement loginButton = driver.findElement(By.linkText("Log In"));
        //loginButton.click();
        logInIcon.click();
        //waitUntilElemetIsClickable(By.id("login"), 20);
        waitUntilElementIsClickable(loginButton, 10);
    }

    public LoginPageHelper enterLoginAtlassianAndClicLogin(String login){
        log4j.info("-- Class LoginPageHelper, method enterLoginAtlassianAndClickLogin() was started");
        log4j.info("User field filling, value " + login);
        //userField.click();
        //userField.sendKeys(login);
        fillField(userField,login);
        log4j.info("Wait until text on button is Log in with Atlassian");
        waitUntilAttributeValuesIs(loginButton,"value","Log in with Atlassian",10);
        //WebElement logButton = driver.findElement(By.id("login"));
       // logButton.click();
        log4j.info("Click on the login button");
        loginButton.click();
        log4j.info("Wait until submit button is clickable");
       // waitUntilElemetIsClickable(By.id("login-submit"),15);
        waitUntilElementIsClickable(loinSubmitButton,15);
        return this;

    }
    public LoginPageHelper enterPasswordAtlassionAndClickPassword(String password){
         log4j.info("---Class LoginPageHelper, method enterPasswordAtlassionAndClickPassword() was started");
         log4j.info("User field filling, value " + password);
     //passwordField.click();
     //passwordField.clear();
       // passwordField.sendKeys(password);
        fillField(passwordField,password);
        log4j.info("Submit button was clicked");
        loinSubmitButton.click();
        return this;
    }


    public void enterLoginAtlassianAndClickLogin(String login) {
        driver.findElement(By.id("user")).sendKeys(login);
        waitUntilAttributeValueIs(By.
                id("login"),"value","Log in with Atlassian",10);
        driver.findElement(By.id("login")).click();

        waitUntilElementIsClickable(By.id("login-submit"),15);
    }

    public void enterPasswordAtlassionAndClickLogin(String password) {
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-submit")).click();
    }

    public LoginPageHelper loginAsAtlassian(String login, String password){
        this.enterLoginAtlassianAndClicLogin(login);
        this.enterPasswordAtlassionAndClickPassword(password);
        return this;
    }

    public void waitUntilFieldPasswordIsVisible(){
        //passwordField.waitUntilElementIsVisible
        waitUntilElementIsVisible(passwordField,30);
    }
    public LoginPageHelper pressLoginButton() {
        log4j.info("-- Class LoginPageHelper, method pressLoginButton() was started");
        //driver.findElement(By.id("login")).click();
        loginButton.click();
        return this;
    }

    public void waitErrorMessage() {
        waitUntilElementIsVisible(By.cssSelector("#error>p"),10);
    }

    public String getErrorMessage(){
        WebElement errorMessage = driver.findElement(By.cssSelector("#error>p"));
        return errorMessage.getText();
    }

    public  LoginPageHelper enterLoginAndPassword(String login){
        log4j.info("-- Class LoginPageHelper, method enterLoginAndPassword( "+ login +" ) was started");
        //driver.findElement(By.id("user")).sendKeys(login);
        log4j.info("Login field filling, value " + login);
        userField.sendKeys(login);
        log4j.info(" Click 'Enter'");
        //passwordField.sendKeys("123");
        //driver.findElement(By.id("password")).sendKeys("123");
        return this;
    }

    public void clickLoginButtonNormal() {
        driver.findElement(By.id("login")).click();
    }

    public LoginPageHelper waitErrorMessageLoginIncorrect(){
      // waitUntilElementIsVisible(By.xpath("(//*[@class= 'error-message'])[1]"),50);
        //waitUntilElementIsVisible(loginError,50);
       waitUntilElementIsVisible(noLoginError,10);
      //  WebElement mist1Button = driver.findElement(By.xpath("(//*[@class= 'error-message'])[1]"));
        System.out.println("Error message1: " + noLoginError.getText());
       // System.out.println("Error message1: " + mist1Button.getText());
        return this;
    }

    public String getErrorMessageloginIncorrect() {
        //WebElement errorMessage = driver.findElement(By.xpath("(//*[@class= 'error-message'])[1]"));
       // return errorMessage.getText();
        return noLoginError.getText();
    }

    public LoginPageHelper waitLoginButtonIsClickable(){

        waitUntilElementIsClickable(loginButton,30);
        System.out.println("Login Button " + loginButton.getTagName());
        //waitUntilElementIsClickable(By.id("login"), 30);
        return this;
    }

    public LoginPageHelper waitErrorMessagePasswordIncorrect() {
        log4j.info("---Class LoginPageHelper, method waitErrorMessagePasswordIncorrect() was started");
        WebElement errorMessageIncorrectPassword;
        //waitUntilElementIsVisible(By.xpath("//div[@id='login-error']/span"),15);
        waitUntilElementIsVisible(noPasswordError,15);
        //System.out.println("Error message: " + driver.findElement(By.xpath("//div[@id='login-error']/span")).getText());
        System.out.println("Error message: " + noPasswordError.getText());
        return this;
    }

    public String getIncorrectPassswordMessage(){
       // WebElement errorMessageIncorrectPassword = driver.findElement(By.xpath("//div[@id='login-error']/span"));
       // return errorMessageIncorrectPassword.getText();
        return noPasswordError.getText();
    }

    public  LoginPageHelper enterPasswordNormal(String password) {
        //  log4j.info("---Class LoginPageHelper, method enterPasswordNormal() was started);
        fillField(passwordField,password);
        return this;
    }
}

package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage{
    @FindBy(id = "username")
    private WebElement userNameInput;
    @FindBy(id="password")
    private WebElement passwordInput;
    @FindBy(tagName = "button")
    private WebElement loginButton;
    @FindBy (css = "div.flash.error")
    private WebElement invalidLoginMassage;

    public LoginPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
        wait.until(ExpectedConditions.visibilityOf(userNameInput));
    }
    public LoginPage setUserName(String userName){
        setValue(userNameInput,userName);
        return this;
    }
    public LoginPage setPassword(String password){
        setValue(passwordInput,password);
        return this;
    }
    public SecurePage clickLoginButton(){
        loginButton.click();
        return new SecurePage(driver);
    }
    public LoginPage invalidLogin(){
        loginButton.click();
        return  new LoginPage(driver);
    }
    public String getInvalidLoginMassage(){
        return wait.until(ExpectedConditions.visibilityOf(invalidLoginMassage)).getText();
    }
}

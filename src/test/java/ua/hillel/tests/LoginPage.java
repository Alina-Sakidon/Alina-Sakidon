package ua.hillel.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPage extends Base {
    protected String cleanTextOfLogin;
    private WebDriver prepareLoginForm(){
        driver.get("https://the-internet.herokuapp.com/login");
        return driver;
    }
    private  void loginUser(String userName,String password){
        WebElement inputUserName = driver.findElement(By.xpath("//input[@type='text']"));
        inputUserName.clear();
        WebElement inputPassword = driver.findElement(By.xpath("//input[@type='password']"));
        inputPassword.clear();
        inputUserName.sendKeys(userName);
        inputPassword.sendKeys(password);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }
    private String getLoginMessage(){
        String textOfSuccessLogin = driver.findElement(By.cssSelector("#flash")).getText();
        String messageSymbol = driver.findElement(By.xpath("//a[contains(@class,'close')]")).getText();
        return cleanTextOfLogin = textOfSuccessLogin.replace("\n" + messageSymbol,"");
    }

    @Test(priority = 1)
    public void TestLoginValid(){
        prepareLoginForm();
        loginUser("tomsmith","SuperSecretPassword!");
        getLoginMessage();
        Assert.assertEquals(cleanTextOfLogin,"You logged into a secure area!");
    }

    @Test(priority = 5)
    public void TestInvalidPassword(){
       prepareLoginForm();
        loginUser("tomsmith","SuperSecretPassword!222");
        getLoginMessage();
        Assert.assertEquals(cleanTextOfLogin,"Your password is invalid!");
    }

    @Test(priority = 10)
    public void TestInvalidUserName(){
        prepareLoginForm();
        loginUser("tomsmith222","SuperSecretPassword!");
        getLoginMessage();
        Assert.assertEquals(cleanTextOfLogin,"Your username is invalid!");
    }
}

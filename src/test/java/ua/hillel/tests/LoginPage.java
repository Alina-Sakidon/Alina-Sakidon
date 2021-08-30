package ua.hillel.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPage extends Base {
    private void prepareLoginForm(){
        driver.get("https://the-internet.herokuapp.com/login");
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
        return driver.findElement(By.cssSelector("#flash")).getText();
    }

    @Test(priority = 1)
    public void TestLoginValid(){
        prepareLoginForm();
        loginUser("tomsmith","SuperSecretPassword!");
        Assert.assertTrue(getLoginMessage().contains("You logged into a secure area!"));
    }

    @Test(priority = 5)
    public void TestInvalidPassword(){
       prepareLoginForm();
        loginUser("tomsmith","SuperSecretPassword!222");
        Assert.assertTrue(getLoginMessage().contains("Your password is invalid!"));
    }

    @Test(priority = 10)
    public void TestInvalidUserName(){
        prepareLoginForm();
        loginUser("tomsmith222","SuperSecretPassword!");
        Assert.assertTrue(getLoginMessage().contains("Your username is invalid!"));
    }
}

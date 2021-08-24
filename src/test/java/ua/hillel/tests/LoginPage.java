package ua.hillel.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPage {
    private WebDriver prepareLoginForm(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/login");
        return driver;
    }
    @Test(priority = 1)
    public void TestLoginValid() throws InterruptedException {
        WebDriver driver=prepareLoginForm();
        WebElement userName=driver.findElement(By.xpath("//h4[@class='subheader']/em[1]"));
        WebElement inputUserName = driver.findElement(By.xpath("//input[@type='text']"));
        inputUserName.clear();
        WebElement password =driver.findElement(By.xpath("//h4[@class='subheader']/em[2]"));
        WebElement inputPassword = driver.findElement(By.xpath("//input[@type='password']"));
        inputPassword.clear();
        inputUserName.sendKeys(userName.getText());
        inputPassword.sendKeys(password.getText());
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(1000);
        String textOfSuccesLogin = driver.findElement(By.cssSelector("#flash")).getText();
        String messageSymbol = driver.findElement(By.xpath("//a[contains(@class,'close')]")).getText();
        String cleanTextOfLogin =textOfSuccesLogin.replace("\n" + messageSymbol,"");
        Assert.assertEquals(cleanTextOfLogin,"You logged into a secure area!");
        driver.quit();
    }

    @Test(priority = 5)
    public void TestInvalidPassword() throws InterruptedException {
        WebDriver driver=prepareLoginForm();
        WebElement userName=driver.findElement(By.xpath("//h4[@class='subheader']/em[1]"));
        WebElement inputUserName = driver.findElement(By.xpath("//input[@type='text']"));
        inputUserName.clear();
        WebElement password =driver.findElement(By.xpath("//h4[@class='subheader']/em[2]"));
        WebElement inputPassword = driver.findElement(By.xpath("//input[@type='password']"));
        inputPassword.clear();
        inputUserName.sendKeys(userName.getText());
        inputPassword.sendKeys(password.getText()+"5");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(1000);
        String textOfInvalidLogin = driver.findElement(By.cssSelector("#flash")).getText();
        String messageSymbol = driver.findElement(By.xpath("//a[contains(@class,'close')]")).getText();
        String cleanTextOfLogin = textOfInvalidLogin.replace("\n" + messageSymbol,"");
        Assert.assertEquals(cleanTextOfLogin,"Your password is invalid!");
        driver.quit();
    }
    @Test(priority = 10)
    public void TestInvalidUserName() throws InterruptedException {
        WebDriver driver=prepareLoginForm();
        WebElement userName=driver.findElement(By.xpath("//h4[@class='subheader']/em[1]"));
        WebElement inputUserName = driver.findElement(By.xpath("//input[@type='text']"));
        inputUserName.clear();
        WebElement password =driver.findElement(By.xpath("//h4[@class='subheader']/em[2]"));
        WebElement inputPassword = driver.findElement(By.xpath("//input[@type='password']"));
        inputPassword.clear();
        inputUserName.sendKeys(userName.getText()+"5");
        inputPassword.sendKeys(password.getText());
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(1000);
        String textOfInvalidLogin = driver.findElement(By.cssSelector("#flash")).getText();
        String messageSymbol = driver.findElement(By.xpath("//a[contains(@class,'close')]")).getText();
        String cleanTextOfLogin = textOfInvalidLogin.replace("\n" + messageSymbol,"");
        Assert.assertEquals(cleanTextOfLogin,"Your username is invalid!");
        driver.quit();
    }
}

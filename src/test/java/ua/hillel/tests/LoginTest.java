package ua.hillel.tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.SecurePage;

public class LoginTest extends Base {
    @Test(priority = 1)
    public void validLogin(){
        SecurePage securePage = openSite()
                .goToLoginPage()
                .setUserName("tomsmith")
                .setPassword("SuperSecretPassword!")
                .clickLoginButton();
        Assert.assertTrue(securePage.getMessageOfLogin().contains("You logged into a secure area!"), "Not logged");
        securePage.logout();
    }
    @Test(priority = 2)
    public  void invalidUseNameLogin(){
        LoginPage loginPage = openSite()
                .goToLoginPage()
                .setUserName("1111")
                .setPassword("SuperSecretPassword!")
                .invalidLogin();
        Assert.assertTrue(loginPage.getInvalidLoginMassage().contains("Your username is invalid!"));
    }
    @Test(priority = 3)
    public  void invalidPassword(){
        LoginPage loginPage = openSite()
                .goToLoginPage()
                .setUserName("tomsmith")
                .setPassword("111")
                .invalidLogin();
        Assert.assertTrue(loginPage.getInvalidLoginMassage().contains("Your password is invalid!"));
    }
}

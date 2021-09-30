package ua.hillel.tests.selenidTests;

import org.openqa.selenium.remote.RemoteWebDriver;
import pageObjects.Selenid.MainSelenidePage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.webdriver;

public class BaseSelenideTest {

    public MainSelenidePage openUrl(){
        open("https://the-internet.herokuapp.com/");
        
        return new MainSelenidePage();
    }
}

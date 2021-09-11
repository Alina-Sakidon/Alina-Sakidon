package ua.hillel.tests.selenidTests;

import pageObjects.Selenid.MainSelenidePage;

import static com.codeborne.selenide.Selenide.open;

public class BaseSelenideTest {

    public MainSelenidePage openUrl(){
        open("https://the-internet.herokuapp.com/");
        return new MainSelenidePage();
    }
}

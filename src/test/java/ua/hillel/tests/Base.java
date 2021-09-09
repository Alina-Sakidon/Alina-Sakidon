package ua.hillel.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pageObjects.MainPage;
import pageObjects.Singletone.DriverSingleton;

public class Base {
    protected WebDriver driver;
    public Actions actions;
    protected WebDriverWait wait;

    @BeforeClass
    public void beforeClass(){
        WebDriverManager.chromedriver().setup();
        this.driver= DriverSingleton.getDriver();
        wait = new WebDriverWait(driver,10);
        actions = new Actions(driver);
    }
    @AfterClass
    public void afterClass(){
        driver.quit();
    }

    public MainPage openSite(){
        driver.get("https://the-internet.herokuapp.com");
        return new MainPage (driver);
    }
}

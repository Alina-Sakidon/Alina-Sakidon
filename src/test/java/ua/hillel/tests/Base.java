package ua.hillel.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import lombok.SneakyThrows;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import pageObjects.MainPage;
import pageObjects.Singletone.DriverSingleton;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Base {
    protected WebDriver driver;
    public Actions actions;
    protected WebDriverWait wait;

    @BeforeClass
    public void beforeClass(){
        WebDriverManager.chromedriver().setup();
        DriverSingleton.createDriver();
        this.driver= DriverSingleton.getDriver();
        wait = new WebDriverWait(driver,10);
        actions = new Actions(driver);
    }
    @SneakyThrows
    @AfterMethod
    public void takeScreenshot(ITestResult result) {
        if (!result.isSuccess()){
            File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            saveScreenshot(Files.readAllBytes(screenshot.toPath()));
        }
    }
    @AfterClass
    public void afterClass(){
        driver.quit();
    }

    public MainPage openSite(){
        driver.get("https://the-internet.herokuapp.com");
        return new MainPage (driver);
    }
    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshot(byte[] screenShot) {
        return screenShot;
    }
}

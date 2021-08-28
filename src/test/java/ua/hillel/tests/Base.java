package ua.hillel.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Base {
    protected WebDriver driver;
    private Actions actions;

    @BeforeClass
    public void beforeClass(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        actions = new Actions(driver);
    }
    @AfterClass
    public void afterClass(){
        driver.quit();
    }
    public void sleep() throws InterruptedException {
        Thread.sleep(1000);
    }
}

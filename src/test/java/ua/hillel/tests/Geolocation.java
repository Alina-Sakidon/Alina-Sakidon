package ua.hillel.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Geolocation {
    @Test
    public void getGeolocation() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/geolocation");
        driver.findElement(By.xpath("//button[text()='Where am I?']")).click();
        Thread.sleep(1000);
        String latitude = driver.findElement(By.xpath("//*[@id='lat-value']")).getText();
        String longitude = driver.findElement(By.xpath("//*[@id='long-value']")).getText();
        System.out.println("latitude is "+latitude+" longitude is "+ longitude );
        driver.quit();
    }
}

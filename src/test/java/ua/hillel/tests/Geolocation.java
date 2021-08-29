package ua.hillel.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class Geolocation extends Base {
    @Test
    public void getGeolocation(){
        driver.get("https://the-internet.herokuapp.com/geolocation");
        driver.findElement(By.xpath("//button[text()='Where am I?']")).click();
        WebElement latitude = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#lat-value")));
        System.out.println("Latitude is "+ latitude.getText());
        WebElement longitude = wait.until((ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#long-value"))));
        System.out.println("Longitude is "+ longitude.getText());
    }
}

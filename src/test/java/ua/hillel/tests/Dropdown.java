package ua.hillel.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Dropdown extends Base{
    @Test
    public void dropdownActions() throws InterruptedException {
        driver.get("https://crossbrowsertesting.github.io/hover-menu.html");
        WebElement dropdown=driver.findElement(By.xpath("//li[@class='dropdown']"));
        dropdown.click();
        WebElement secondaryAction=driver.findElement(By.xpath("//li[@class='secondary-dropdown']"));
        Actions actions=new Actions(driver);
        sleep();
        actions.moveToElement(secondaryAction).perform();
        driver.findElement(By.xpath("//a[text()='Secondary Action']")).click();
        sleep();
        WebElement buttonSubmit = driver.findElement(By.xpath("//button[text()='Submit']"));
        actions.moveToElement(buttonSubmit).perform();
        sleep();
        WebElement resultOfDropped = driver.findElement(By.xpath("//h1[text()='Secondary Page']"));
        boolean isSecPageVisible = resultOfDropped.getText().contains("Secondary Page");
        Assert.assertTrue(isSecPageVisible);
    }
}

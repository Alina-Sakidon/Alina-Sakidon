package ua.hillel.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Dropdown extends Base{
    @Test
    public void dropdownActions(){
        driver.get("https://crossbrowsertesting.github.io/hover-menu.html");
        WebElement dropdown=driver.findElement(By.xpath("//li[@class='dropdown']"));
        dropdown.click();
        WebElement secondaryMenu =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='secondary-dropdown']")));
        actions.moveToElement(secondaryMenu).perform();
        driver.findElement(By.xpath("//a[text()='Secondary Action']")).click();
        WebElement buttonSubmit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Submit']")));
        actions.moveToElement(buttonSubmit).perform();
        WebElement resultOfDropped = driver.findElement(By.xpath("//h1[text()='Secondary Page']"));
        boolean isSecPageVisible = resultOfDropped.getText().contains("Secondary Page");
        Assert.assertTrue(isSecPageVisible);
    }
}

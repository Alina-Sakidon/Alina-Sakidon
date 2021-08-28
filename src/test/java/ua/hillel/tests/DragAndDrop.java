package ua.hillel.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DragAndDrop extends Base{
    @Test
    public void dragAndDrop(){
        // arrange
        driver.get("https://crossbrowsertesting.github.io/drag-and-drop.html");
        WebElement elementFrom = driver.findElement(By.xpath("//p[text()='Drag me to my target']"));
        WebElement elementTo = driver.findElement(By.xpath("//p[text()='Drop here']"));
        Actions actions = new Actions(driver);

        // act
        actions.dragAndDrop(elementFrom,elementTo).build().perform();

        // assert
        boolean isDroppedVisible = driver.findElement(By.xpath("//p[text()='Dropped!']")).isDisplayed();
        Assert.assertTrue(isDroppedVisible);
    }
}

package ua.hillel.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.List;

public class Hovers extends Base {
    String path = "//div[@class='example']/div";

    @Test
    public void getNameByHover() {
        driver.get("https://the-internet.herokuapp.com/hovers");
        Actions actions = new Actions(driver);
        List<WebElement> cont = driver.findElements(By.xpath(path));
        for (int i = 0; i < cont.size(); i++) {
            actions.moveToElement(cont.get(i)).perform();
            printName(String.format("[%1s]//h5", i + 1));
        }
    }
    private void printName(String loc){
        System.out.println(driver.findElement(By.xpath(path+loc)).getText());
    }
        /*WebElement firstIcon = driver.findElement(By.xpath("//div[@class='example']/div[1]"));
        actions.moveToElement(firstIcon).perform();
        System.out.println(driver.findElement(By.xpath("//div[@class='example']/div[1]//h5")).getText());

        WebElement secondIcon = driver.findElement(By.xpath("//div[@class='example']/div[2]"));
        actions.moveToElement(secondIcon).perform();
        System.out.println(driver.findElement(By.xpath("//div[@class='example']/div[2]//h5")).getText());

        WebElement thirdIcon = driver.findElement(By.xpath("//div[@class='example']/div[3]"));
        actions.moveToElement(thirdIcon).perform();
        System.out.println(driver.findElement(By.xpath("//div[@class='example']/div[3]//h5")).getText());
    }*/
}



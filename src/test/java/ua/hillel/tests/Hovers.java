package ua.hillel.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class Hovers extends Base {
    String path = "//div[@class='example']/div";

    @Test
    public void getNameByHover() {
        driver.get("https://the-internet.herokuapp.com/hovers");
        List<WebElement> cont = driver.findElements(By.xpath(path));
        int i = 1;
        for (WebElement userIcon :
                cont) {
            actions.moveToElement(userIcon).perform();
            printName(String.format("[%1s]//h5", i++));
        }
    }
    private void printName(String loc){
        System.out.println(driver.findElement(By.xpath(path+loc)).getText());
    }
}



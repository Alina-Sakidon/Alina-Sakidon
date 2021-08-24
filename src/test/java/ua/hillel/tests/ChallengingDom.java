package ua.hillel.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ChallengingDom {
    private void CheckButton(WebDriver driver, String xPathToButton) {
        int count=0;
        String textButtonAfterClick;
        String textButtonBeforeClick;
        do {
            WebElement button = driver.findElement(By.xpath(xPathToButton));
            textButtonBeforeClick = button.getText();
            System.out.println("button before " + textButtonBeforeClick);
            button.click();
            button = driver.findElement(By.xpath(xPathToButton));
            textButtonAfterClick = button.getText();
            System.out.println("button after " + textButtonAfterClick);
            System.out.println("step " + count);
            count++;
        }
        while (textButtonAfterClick.equals(textButtonBeforeClick) && count <= 3);
        Assert.assertNotEquals(textButtonAfterClick, textButtonBeforeClick);
    }
    @Test
    public void uiTest() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/challenging_dom");
        CheckButton(driver,"//div[@class='large-2 columns']/a[1]");
        Thread.sleep(1000);

        CheckButton(driver, "//div[@class='large-2 columns']/a[2]");
        Thread.sleep(1000);

        CheckButton(driver, "//div[@class='large-2 columns']/a[3]");
        Thread.sleep(1000);
        WebElement table=driver.findElement(By.tagName("table"));
        List<WebElement> columnSit=table.findElements(By.xpath(".//tr/td[4]"));
        for (WebElement element :
                columnSit) {
            System.out.println(element.getText());
        }
        driver.quit();
    }
}

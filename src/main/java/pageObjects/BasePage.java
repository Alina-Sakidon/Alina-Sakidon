package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.Singletone.DriverSingleton;

import java.util.HashMap;
import java.util.Map;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;

    protected BasePage (){
        this.driver = DriverSingleton.getDriver();
        wait = new WebDriverWait(driver,10);
        actions = new Actions(driver);
    }
    protected void setValue(WebElement element,String value){
        element.click();
        element.sendKeys(value);
    }
}

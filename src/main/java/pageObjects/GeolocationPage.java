package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GeolocationPage extends BasePage{
    @FindBy(xpath = "//button[text()='Where am I?']")
    private WebElement buttonWhereIAm;

    @FindBy(css = "#lat-value")
    private WebElement latitude;

    @FindBy(css = "#long-value")
    private WebElement longitude;

    public GeolocationPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    public String getLatitude(){
        return wait.until(ExpectedConditions.visibilityOf(latitude)).getText();
    }
    public String getLongitude(){
        return wait.until(ExpectedConditions.visibilityOf(longitude)).getText();
    }
    public GeolocationPage clickButtonWhereIAm(){
        buttonWhereIAm.click();
        return new GeolocationPage(driver);
    }

}

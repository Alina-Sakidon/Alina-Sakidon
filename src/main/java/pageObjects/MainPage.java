package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage{
    @FindBy(linkText = "Form Authentication")
    private WebElement loginLink;

    @FindBy (linkText = "Geolocation")
    private WebElement geolocationLink;

    @FindBy(linkText = "Challenging DOM")
    private WebElement challengingDomLink;

    @FindBy (linkText = "Hovers")
    private WebElement hoversLink;

    public  MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public  LoginPage   goToLoginPage(){
        loginLink.click();
        return new LoginPage(driver);
    }
    public GeolocationPage goToGeolocationPage(){
        geolocationLink.click();
        return new GeolocationPage(driver);
    }
    public ChallengingDomPage goToChallengingDom(){
        challengingDomLink.click();
        return new ChallengingDomPage(driver);
    }
    public HoversPage goToHovers(){
        hoversLink.click();
        return new HoversPage(driver);
    }
}

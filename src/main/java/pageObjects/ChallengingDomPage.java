package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ChallengingDomPage extends BasePage{
    @FindBy(xpath = "//table//tr/td[4]")
    private List<WebElement> columnSit;

    @FindBy(xpath ="//div[@class='large-2 columns']/a[1]")
    private WebElement button1;

    @FindBy(xpath ="//div[@class='large-2 columns']/a[2]")
    private WebElement button2;

    @FindBy(xpath ="//div[@class='large-2 columns']/a[3]")
    private WebElement button3;

    public ChallengingDomPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }
    public ChallengingDomPage clickButtons(){
        button1.click();
        button2.click();
        button3.click();
        return new ChallengingDomPage(driver);
    }

    public List<WebElement> getColumnSit() {
        for (WebElement element :
                columnSit) {
            System.out.println(element.getText());
        }
        return columnSit;
    }
}

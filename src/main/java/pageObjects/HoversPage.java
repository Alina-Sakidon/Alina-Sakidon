package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class HoversPage extends BasePage {
    @FindBy(xpath = "//div[@class='example']/div")
    List<WebElement> listOfIcons;

    public HoversPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public List<WebElement> getUserName() {
        for (WebElement userIcon :
                listOfIcons) {
            actions.moveToElement(userIcon).perform();
            String result = userIcon.getText().split("\n")[0];
            System.out.println(result);
        }
        return listOfIcons;
    }
}

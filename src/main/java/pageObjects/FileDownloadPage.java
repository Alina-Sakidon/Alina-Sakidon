package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FileDownloadPage extends BasePage{
    @FindBy(linkText = "some-file.txt")
    private WebElement linkFile;

    public FileDownloadPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    public FileDownloadPage downloadFile(){
        linkFile.click();
        return new FileDownloadPage(driver);
    }
}

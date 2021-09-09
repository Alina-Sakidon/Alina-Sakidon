package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;
import java.nio.file.Path;

public class UploadPage extends BasePage{
    @FindBy(id = "file-upload")
    private WebElement inputUpload;

    @FindBy(id = "file-submit")
    private WebElement uploadButton;

    @FindBy(xpath = ".//*[text()='File Uploaded!']")
    private WebElement successUploadMessage;

    public UploadPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public UploadPage uploadFile(Path path) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(inputUpload));
        inputUpload.sendKeys(path.toFile().getAbsolutePath());
        uploadButton.click();
        return new UploadPage(driver);
    }
    public String getSuccessUploadMessage(){
       return wait.until(ExpectedConditions.visibilityOf(successUploadMessage)).getText() ;
    }
}

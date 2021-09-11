package pageObjects.Selenid;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import java.io.File;
import java.nio.file.Path;
import static com.codeborne.selenide.Selenide.*;

public class UploadFilePageSelenid {
    private SelenideElement inputToUploadFile = $(By.id("file-upload"));
    private SelenideElement buttonToUpload = $(By.id("file-submit"));
    private SelenideElement successUploadMessage = $x(".//*[text()='File Uploaded!']");

    public UploadFilePageSelenid uploadFile(Path path) {
        inputToUploadFile.should(Condition.visible).uploadFile(new File(String.valueOf(path)));
        buttonToUpload.click();
        return new UploadFilePageSelenid();
    }
    public String getSuccessUploadMessage(){
        return successUploadMessage.should(Condition.visible).getText();
    }
}

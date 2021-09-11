package pageObjects.Selenid;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Selenide.$;

public class MainSelenidePage {
    private SelenideElement linkDynamicControls = $(By.linkText("Dynamic Controls"));
    private SelenideElement linkToDownloadPage = $(By.linkText("File Download"));
    private SelenideElement linkToUploadPage = $(By.linkText("File Upload"));

    public DynamicControlPage goToDynamicControlPage(){
        linkDynamicControls.shouldBe(Condition.visible).click();
        return new DynamicControlPage();
    }

    public DownloadPageSelenid goToDownloadPage(){
        linkToDownloadPage.should(Condition.visible).click();
        return new DownloadPageSelenid();
    }

    public UploadFilePageSelenid doToUploadPage(){
        linkToUploadPage.should(Condition.visible).click();
        return new UploadFilePageSelenid();
    }
}

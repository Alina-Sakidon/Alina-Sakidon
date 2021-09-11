package pageObjects.Selenid;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;

import static com.codeborne.selenide.Selenide.$;

public class DownloadPageSelenid extends MainSelenidePage{
    private SelenideElement linkToFile = $(By.linkText("some-file.txt"));
    public static Path lastDownloadPath;

    public DownloadPageSelenid downloadFile() throws FileNotFoundException {
       File downloadedFile = linkToFile.should(Condition.visible).download();
       lastDownloadPath = Path.of(downloadedFile.getAbsolutePath());
        return new DownloadPageSelenid();
    }
}


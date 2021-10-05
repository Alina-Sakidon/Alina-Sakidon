package ua.hillel.tests.FailedTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.Selenid.DownloadPageSelenid;
import pageObjects.Selenid.UploadFilePageSelenid;
import ua.hillel.tests.selenidTests.BaseSelenideTest;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;


public class DownloadAndUploadFile extends BaseSelenideTest {
    @Test
    public void downloadAndUpload() throws IOException{
        DownloadPageSelenid downloadPageSelenid = openUrl()
                .goToDownloadPage()
                .downloadFile();
        Path path1 = DownloadPageSelenid.lastDownloadPath;
        File fileToEdit = path1.toFile();
        while (true){
            if (!fileToEdit.exists()){
            }else {break;}
        }
        System.out.println("file has been downloaded");
        List<String> oldText = Files.readAllLines(path1);
        List<String> newText = new ArrayList<>();
        for (String line : oldText) {
            newText.add(0,line+ "world");
        }

        Files.write(path1,newText);
        UploadFilePageSelenid uploadFilePageSelenid=openUrl()
                .doToUploadPage()
                .uploadFile(fileToEdit);
        Assert.assertTrue(uploadFilePageSelenid.getSuccessUploadMessage().contains("File Uploaded!"));
        path1.toFile().deleteOnExit();
    }
}

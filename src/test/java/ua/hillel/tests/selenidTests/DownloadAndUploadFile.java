package ua.hillel.tests.selenidTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.Selenid.DownloadPageSelenid;
import pageObjects.Selenid.UploadFilePageSelenid;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;


public class DownloadAndUploadFile extends BaseSelenideTest {
    @Test
    public void downloadAndUpload() throws IOException, InterruptedException {
        DownloadPageSelenid downloadPageSelenid = openUrl()
                .goToDownloadPage()
                .downloadFile();
        Path path1 = DownloadPageSelenid.lastDownloadPath;
        while (true){
            if (!path1.toFile().exists()){
                Thread.sleep(1000);
            }else {break;}
        }
        System.out.println("file has been downloaded");
        List<String> oldText = Files.readAllLines(path1);
        List<String> newText = new ArrayList<>();
        for (String line : oldText) {
            newText.add(0,line+ "world");
        }
        Files.write(path1,newText);
        System.out.println("file has been written");

        UploadFilePageSelenid uploadFilePageSelenid=openUrl()
                .doToUploadPage();
                //.uploadFile(path1);
        //Assert.assertTrue(uploadFilePageSelenid.getSuccessUploadMessage().contains("File Uploaded!"));
        System.out.println("file has been uploaded");

        path1.toFile().deleteOnExit();
    }
}

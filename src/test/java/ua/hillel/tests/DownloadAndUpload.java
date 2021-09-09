package ua.hillel.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.FileDownloadPage;
import pageObjects.UploadPage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DownloadAndUpload extends Base{
    @Test
    public void downloadFile() throws InterruptedException, IOException {
        FileDownloadPage fileDownloadPage = openSite()
                .goToFileDownload()
                .downloadFile();

        Path path1 = Paths.get("target/"+"some-file.txt");
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

        UploadPage uploadPage = openSite()
                .goToUploadPage()
                .uploadFile(path1.toAbsolutePath());
        Assert.assertTrue(uploadPage.getSuccessUploadMessage().contains("File Uploaded!"));
        path1.toFile().deleteOnExit();
    }
}

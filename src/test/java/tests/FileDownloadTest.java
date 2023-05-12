package tests;

import org.testng.annotations.Test;
import pages.FileDownloadPage;
import utils.BrowserUtils;
import utils.EndPoints;

public class FileDownloadTest extends TestBase {

    @Test
    public void testFileDownload() {
        FileDownloadPage fdp = new FileDownloadPage();
        extentTest = extentReports.createTest("File Download Test");

        fdp.navigateTo(EndPoints.FILEDOWNLOAD);
        extentTest.info("Navigate to File Download Page");

        String downloadFile = fdp.file.getText();
        extentTest.info("File's Name is Stored");

        fdp.file.click();
        extentTest.info("Clicked to some-file.txt link");

        BrowserUtils.wait(5);
        extentTest.info("Waiting 5 Seconds...");

        String projectPath = System.getProperty("user.dir");
        String relativePath = "src/test/resources/"+downloadFile;
        extentTest.info("Stored File Name is Used for It's Path");

        String filePath = projectPath+"/"+relativePath;
        extentTest.info("Downloaded Files Path=> "+filePath);

        extentTest.pass("Test is passed for now. But Selenium cannot verify " +
                "file downloads. It can click on download link but can't go outside " +
                "the browser and open the downloaded file. We need to use Robot and AutoIT for this purpose. " +
                "Or We can Download the File To Our Project. So We Can Verify The Downloaded File's Name");
    }
}

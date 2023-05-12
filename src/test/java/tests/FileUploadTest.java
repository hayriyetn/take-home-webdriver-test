package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FileUploadPage;
import utils.EndPoints;

public class FileUploadTest extends TestBase {

    @Test
    public void testFileDownload() {
        FileUploadPage fup = new FileUploadPage();
        extentTest = extentReports.createTest("File Upload Test");

        fup.navigateTo(EndPoints.FILEUPLOAD);
        extentTest.info("Navigate to File Upload Page");

        fup.chooseFileLink.sendKeys("/Users/hayriyetan/desktop/hayrish/uploadFile.docx");
        extentTest.info("Uploading path is chosen and sent");

        fup.uploadButton.click();
        extentTest.info("Clicked to uploadButton");

        Assert.assertTrue(fup.uploadedMessage.isDisplayed());
        extentTest.info("Success Message is Displayed => "+fup.uploadedMessage.getText());

        Assert.assertTrue(fup.uploadedFileName.isDisplayed());
        extentTest.info("Uploaded File's Name is Displayed => "+fup.uploadedFileName.getText());

        extentTest.pass("File Upload Test is Successful");
    }
}

package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DynamicContentPage;
import utils.EndPoints;

public class DynamicContentTest extends TestBase {

    @Test
    public void testDynamicContent() {
        DynamicContentPage dc = new DynamicContentPage();
        extentTest = extentReports.createTest("Dynamic Content");

        dc.navigateTo(EndPoints.DYNAMICCONTENT);
        extentTest.info("Navigate Dynamic Content Page");

        String img1 = dc.img1.getAttribute("src");
        String img2 = dc.img2.getAttribute("src");
        String img3 = dc.img3.getAttribute("src");

        String text1 = dc.text1.getText();
        String text2 = dc.text2.getText();
        String text3 = dc.text3.getText();

        extentTest.info("Before Refresh");
        dc.driver.navigate().refresh();
        extentTest.info("After Refresh");

        String newImg1 = dc.img1.getAttribute("src");
        String newImg2 = dc.img2.getAttribute("src");
        String newImg3 = dc.img3.getAttribute("src");

        String newText1 = dc.text1.getText();
        String newText2 = dc.text2.getText();
        String newText3 = dc.text3.getText();

        Assert.assertNotEquals(newImg1, img1);
        Assert.assertNotEquals(newImg2, img2);
        extentTest.info("Image Assertions are Verified");

        Assert.assertNotEquals(newText1, text1);
        Assert.assertNotEquals(newText2, text2);
        Assert.assertNotEquals(newText3, text3);
        extentTest.info("Text Assertions are Verified");

        extentTest.pass("Dynamic Content Test is Successful");
    }
}

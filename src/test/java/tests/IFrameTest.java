package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.IFramePage;
import utils.BrowserUtils;
import utils.EndPoints;
public class IFrameTest extends TestBase {

    @Test
    public void testIFrame() {
        IFramePage ifp = new IFramePage();
        extentTest = extentReports.createTest("iFrame Test");

        ifp.navigateTo(EndPoints.IFRAME);
        extentTest.info("Navigate to iFrame Page");

        ifp.driver.switchTo().frame(ifp.targetFrame);
        String expectedText= "Your content goes here.";
        String actualText = ifp.inputArea.getText();

        ifp.inputArea.clear();
        extentTest.info("inputArea is Cleared");

        BrowserUtils.wait(2);

        ifp.inputArea.sendKeys("Hayrish");
        extentTest.info("'Hayrish' is Written to inputArea");

        Assert.assertEquals( ifp.inputArea.getText(),"Hayrish");
        extentTest.info("inputArea is Same As like Sent Keys => "+ifp.inputArea.getText());

        ifp.driver.switchTo().defaultContent();
        extentTest.info("iFrame Switched to Default Content");

        extentTest.pass("iFrame Test is Successful");
    }
}

package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DynamicLoadingPage;
import utils.BrowserUtils;
import utils.EndPoints;

public class DynamicLoadingTest extends TestBase {

    @Test
    public void testDynamicLoading() {
        DynamicLoadingPage dlp = new DynamicLoadingPage();
        extentTest = extentReports.createTest("Dynamic Loading");

        dlp.navigateTo(EndPoints.DYNAMICLODING);
        extentTest.info("Navigate Dynamic Loading Page");

        dlp.startButton.click();
        extentTest.info("Start Button is Clicked");

        BrowserUtils.waitForVisibility( dlp.finishText,10);
        extentTest.info("Explicit Wait is Initializing...");

        Assert.assertTrue(dlp.finishText.isDisplayed());
        extentTest.info("finishText is Displayed=> "+dlp.finishText.getText());

        extentTest.pass("Dynamic Loading Pages's Test is Successful");
    }
}

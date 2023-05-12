package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DynamicControlPage;
import utils.BrowserUtils;
import utils.EndPoints;

public class DynamicControlTest extends TestBase {

    @Test
    public void testDynamicControl() {
        DynamicControlPage dcp = new DynamicControlPage();
        extentTest = extentReports.createTest("Dynamic Control");

        dcp.navigateTo(EndPoints.DYNAMICCONTROLS);
        extentTest.info("Navigate Dynamic Control Page");

        Assert.assertTrue(dcp.checkBox.isDisplayed());
        extentTest.info("Assert That checkbox is Displayed");

        dcp.removeButton.click();
        extentTest.info("Explicit Wait is Initializing...");

        BrowserUtils.waitForVisibility( dcp.goneMessage, 5);
        extentTest.info("Info Message is Displayed => " + dcp.checkboxGone.getText());

        Assert.assertTrue(dcp.checkboxGone.isDisplayed());
        extentTest.info("goneMessage is Displayed => " + dcp.goneMessage.getText());

        dcp.addButton.click();
        BrowserUtils.waitForVisibility( dcp.backMessage, 5);

        Assert.assertTrue(dcp.checkBox.isDisplayed());
        extentTest.info("Checkbox is Displayed");

        dcp.enableDisableButton.click();
        extentTest.info("Enable Button Has Been Clicked");

        BrowserUtils.waitForVisibility( dcp.enableMessage, 15);
        extentTest.info("Explicit Wait is Initializing...");

        Assert.assertEquals(dcp.enableMessage.getText(), "It's enabled!");
        extentTest.info("Enable is Displayed => " + dcp.enableMessage.getText());

        dcp.enableDisableButton.click();
        extentTest.info("Disable Button Has Been Clicked");

        BrowserUtils.waitForVisibility( dcp.disableMessage, 15);
        extentTest.info("Explicit Wait is Initializing...");

        Assert.assertEquals(dcp.disableMessage.getText(), "It's disabled!");
        extentTest.info("Disable is Displayed => " + dcp.disableMessage.getText());

        extentTest.pass("Dynamic Control Test is Successful");
    }
}

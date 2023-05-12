package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContextMenuPage;
import utils.EndPoints;

public class ContextMenuTest extends TestBase {

    @Test
    public void testContextMenu(){
        ContextMenuPage cmp = new ContextMenuPage();
        extentTest = extentReports.createTest("Context Menu");

        cmp.navigateTo(EndPoints.CONTEXTMENU);
        extentTest.info("Navigate To Context Menu Page");

        cmp.rightClickOnHotSpot();
        extentTest.info("Right Click on Hotspot");

        String message = cmp.getAlertMessage();
        extentTest.info("AlertMessage is Appeared");

        Assert.assertEquals(message,"You selected a context menu");
        extentTest.info("Alert Menu Text is Verified");

        extentTest.pass("Context Menu Test is Successful ");
    }
}

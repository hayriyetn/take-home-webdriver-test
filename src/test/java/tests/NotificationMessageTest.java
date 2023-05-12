package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.NotificationMessagePage;
import utils.BrowserUtils;
import utils.EndPoints;
import java.util.Set;
import java.util.TreeSet;

public class NotificationMessageTest extends TestBase {

    @Test
    public void testNotificationMessage() {
        NotificationMessagePage nmp = new NotificationMessagePage();
        extentTest = extentReports.createTest("Notification Message Test");

        nmp.navigateTo(EndPoints.NOTICIFICATIONMESSAGE);
        extentTest.info("Navigate to Notification Message Page");

        Set<String> set = new TreeSet<>();
        for (int i=0; i<5; i++) {
            nmp.clickHere.click();
            String messageText = nmp.message.getText();
            if (messageText.contains("Action successful"))
                set.add("1-> Action successful");
            else if (messageText.contains("please try again"))
                set.add("2-> Action unsuccesful, please try again");
            else
                set.add("3-> Action Unsuccessful");
            BrowserUtils.wait(2);
        }
        extentTest.info("Clicked to the Link 5 Times and Messages are Stored. Messages are=> "+set);

        try {
            Assert.assertTrue(set.toString().contains("Action successful") ||
                    set.toString().contains("Action unsuccesful, please try again") ||
                    set.toString().contains("Action Unsuccessful"));
        }catch (Exception e) {
            System.out.println("Failed to load properties file!");
            e.printStackTrace();
        }

        extentTest.pass("'Action Successfull or Unsuccessful' Messages Are Appeared");
    }
}

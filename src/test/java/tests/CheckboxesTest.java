package tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckBoxPage;
import utils.EndPoints;

public class CheckboxesTest extends TestBase {

    @Test
    public void testCheckboxes() {
        CheckBoxPage cb = new CheckBoxPage();
        extentTest = extentReports.createTest("Checkboxes");

        cb.navigateTo(EndPoints.CHECKBOXES);
        extentTest.info("Navigate To Checkbox Page");

        int index = 1;
        for (WebElement checkbox : cb.checkboxes) {
            if (checkbox.isEnabled() && !checkbox.isSelected()) {
                checkbox.click();
                extentTest.info("Checkbox #" + index + " was not clicked");

                Assert.assertTrue(checkbox.isSelected());
                extentTest.info("Checkbox " + index + " is selected");
            } else {
                checkbox.click();
                extentTest.info("Checkbox #" + index + " was clicked");

                Assert.assertFalse(checkbox.isSelected());
                extentTest.info("Checkbox " + index + " is un-selected");
            }
            index++;
        }
        extentTest.pass("Checkbox Test is Successful");
    }
}

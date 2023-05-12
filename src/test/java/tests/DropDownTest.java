package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ISelect;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DropDownPage;
import utils.EndPoints;
import utils.Driver;

import java.util.List;

import static utils.Driver.driver;

public class DropDownTest extends TestBase {

    @Test
    public void testDropDown() {
        DropDownPage dd = new DropDownPage();
        extentTest = extentReports.createTest("Drop - Down");

        dd.navigateTo(EndPoints.DROPDOWN);
        extentTest.info("Navigate To Drop - Down Page");


        Select dropdown = new Select(dd.driver.findElement(By.id("dropdown")));
        WebElement option = dropdown.getFirstSelectedOption();
        if (option.isEnabled()) {
            dropdown.selectByVisibleText("Option Text");
        }

        Select dropDown = new Select(dd.dropdown);
        dropDown.selectByVisibleText("Option 1");

        WebElement selectedOption = dropdown.getFirstSelectedOption();
        String actualSelectedText = selectedOption.getText();
        String expectedSelectedText = "Option 1";

        Assert.assertEquals(actualSelectedText, expectedSelectedText, "Selected option doesn't match the expected value");
        extentTest.info("Options are selected ");

        extentTest.pass("Drop-Down Test is Successful ");
        }
      }



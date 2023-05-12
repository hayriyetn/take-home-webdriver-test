package tests;

import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.JSErrorPage;
import utils.EndPoints;

import java.util.List;
import java.util.logging.Level;

public class JSErrorTest extends TestBase {
    @Test
    public void testJSErrors() {
        JSErrorPage jsep = new JSErrorPage();
        extentTest = extentReports.createTest("JavaScript Error Test");

        jsep.navigateTo(EndPoints.JSERROR);
        extentTest.info("Navigate to JavaScript Error Page");

        LogEntries logEntries = jsep.driver.manage().logs().get(LogType.BROWSER);
        List<LogEntry> logs = logEntries.getAll();
        extentTest.info("Errors are Searching");

        String searchedError="";
        int index=1;
        for (LogEntry log : logs) {
            extentTest.info("The " + index + ". Error in the page is=> " + log);
            if (log.toString().contains("Cannot read properties of undefined (reading 'xyz')")) {
                searchedError = log.toString();
            }
            index++;
        }

        Assert.assertTrue(searchedError.contains("Cannot read properties of undefined (reading 'xyz')"));
        extentTest.info("The Error is Verified which Contains 'Cannot read property 'xyz' of undefined' ");

        extentTest.pass("JavaScript Error Test is Successful");
    }
}


package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.EndPoints;

public class LoginTest extends TestBase{
    @Test(priority = 1,description = "Verify success message")
    public void successLogin(){
        LoginPage loginPage = new LoginPage();
        extentTest = extentReports.createTest("Successful Login");

        loginPage.navigateTo(EndPoints.LOGIN);
        extentTest.info("Navigate to Login Page");

        loginPage.successfulLogin();
        extentTest.info("User Logged in ");

        String successMessage = loginPage.getSuccessMessage();
        Assert.assertEquals(successMessage,"Welcome to the Secure Area. When you are done click logout below.");
        extentTest.info("User Able to See Success Message");

        extentTest.pass("Successful Login");
    }

    @Test(priority = 2,description = "Verify failed message")
    public void invalidLogin(){
        LoginPage loginPage = new LoginPage();
        extentTest = extentReports.createTest("Unsuccessful Login");

        loginPage.navigateTo(EndPoints.LOGIN);
        extentTest.info("Navigate to Login Page");

        loginPage.invalidLogin();
        extentTest.info("User is Not Able To Login ");

        String invalidMessage = loginPage.getFailedMessage();
        Assert.assertTrue(invalidMessage.contains("Your username is invalid!"));
        extentTest.info("User See Failed Message");

        extentTest.pass("Unsuccessful Login");
    }
}

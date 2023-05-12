package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.ConfigurationReader;
public class LoginPage extends BasePage {
    @FindBy(id = "username")
    public WebElement username;
    @FindBy(id = "password")
    public WebElement password;
    @FindBy(tagName = "button")
    public WebElement button;

    @FindBy(tagName = "h4")
    public WebElement successMessage;

    @FindBy(xpath = "//*[contains(text(),'Your username is invalid!')]")
    public WebElement failedMessage;



    public void successfulLogin(){
        username.sendKeys(ConfigurationReader.getProperty("userName"));
        password.sendKeys(ConfigurationReader.getProperty("password"));
        button.click();
    }

    public String getSuccessMessage(){
        return successMessage.getText();
    }

    public void invalidLogin(){
        username.sendKeys(ConfigurationReader.getProperty("invalidUserName"));
        password.sendKeys(ConfigurationReader.getProperty("invalidPassword"));
        button.click();
    }

    public String getFailedMessage(){
        return failedMessage.getText();
    }


}
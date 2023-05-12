package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utils.ConfigurationReader;
import utils.Driver;

public abstract class BasePage {
    public WebDriver driver = Driver.get();

    public BasePage(){
        PageFactory.initElements(Driver.get(),this);
    }
    public void navigateTo(String page){
        String url = ConfigurationReader.getProperty("baseUrl")+page;
        driver.get(url);
    }

    public String getAlertMessage(){
        Alert alert     = Driver.get().switchTo().alert();
        String message  = alert.getText();
        driver.switchTo().alert();

        return message;
    }
}

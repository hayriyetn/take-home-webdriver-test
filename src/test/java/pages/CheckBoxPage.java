package pages;

import org.jsoup.Connection;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.ConfigurationReader;

import java.util.List;

public class CheckBoxPage extends BasePage {

    @FindBy(tagName = "input")
    public List<WebElement> checkboxes;


}

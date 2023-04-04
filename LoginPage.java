package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class LoginPage extends PageObjectPage {
    WebDriver driver;
    @FindBy(name = "email")
    public
    WebElement txbEmail;
    @FindBy(name = "password")
    public
    WebElement txbPassword;
    @FindBy(css = "button[class*=\"pill\"]")
    public
    WebElement btnLogin;
    By lcEmailError = By.cssSelector("#auth-block__login-form > div:nth-child(1) > div.mz-form-group__control-col > div > label");
    By lcPassError = By.cssSelector("#auth-block__login-form > div:nth-child(2) > div.mz-form-group__control-col > div > label");

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getErrorEmail() {
        WebElement txtError = this.getDynamicElement(lcEmailError);
        return txtError.getText();
    }

    public String getErrorPass() {
        WebElement txtError = this.getDynamicElement(lcPassError);
        return txtError.getText();
    }

    public boolean checkExisterrorEmail() {
        if (driver.findElements(lcEmailError).size() > 0) {
            return true;
        }
        return false;
    }

    public boolean checkExisterrorPass() {
        if (driver.findElements(lcPassError).size() > 0) {
            return true;
        }
        return false;
    }
}

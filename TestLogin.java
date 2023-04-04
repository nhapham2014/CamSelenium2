package vn.camautomation;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObject.HomePage;
import pageObject.LoginPage;

/**
 * Unit test for simple App.
 */
public class TestLogin {
    WebDriver driver;
    LoginPage LoginPage;
    HomePage HomePage;

    @Before
    public void setup() {
        this.driver = new ChromeDriver();
        driver.get("http://youngsante.testmaster.vn/#/");
        driver.manage().window().maximize();
        this.LoginPage = new LoginPage(this.driver);
        this.HomePage = new HomePage(this.driver);

    }

    @After
    public void close() {
        driver.quit();
    }

    @Test
    public void Test_ErrorLoginWhenFieldIsEmpty() {
        HomePage.btnSignin.click();
        LoginPage.txbEmail.clear();
        LoginPage.txbPassword.clear();
        LoginPage.btnLogin.click();
        Assert.assertEquals("Please enter Email or Phone Number", LoginPage.getErrorEmail());
        Assert.assertEquals("Please enter your password", LoginPage.getErrorPass());
    }

    @Test
    public void Test_ErrorLoginDisappearWhenInputValidData() throws InterruptedException {
        HomePage.btnSignin.click();
        LoginPage.txbEmail.clear();
        LoginPage.txbPassword.clear();
        LoginPage.btnLogin.click();
        LoginPage.txbEmail.sendKeys("nhapham@gmail.com");
        LoginPage.txbPassword.sendKeys("1234566");
        Assert.assertEquals(false, LoginPage.checkExisterrorEmail());
        Assert.assertEquals(false, LoginPage.checkExisterrorPass());

    }

}

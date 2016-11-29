import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by Andrii on 25.11.2016.
 */
public class DEV_Login_Logout {

    public WebDriver driver;

    @Test
    public void loginToDevEnv () {

        WebElement emailField = driver.findElement(By.xpath(".//*[@id=\"Email\"]"));
        emailField.clear();
        emailField.sendKeys("autotest1@mailinator.com");
        WebElement passwordField = driver.findElement(By.cssSelector("#Password"));
        passwordField.clear();
        passwordField.sendKeys("QQQ___999");
        WebElement loginButton = driver.findElement(By.cssSelector(".btn.btn-lg.btn-success.btn-block.login-button"));
        loginButton.click();

//        WebElement expectedUsername = driver.findElement(By.xpath("html/body/div[2]/div[1]/div[2]/div/div[2]/div/rp-dropdown-menu/rp-dropdown-title/text()[1]"));
//        Assert.assertEquals(expectedUsername.getText(), "autotest1@mailinator.com");
    }

    @BeforeMethod
    public void beforeMethod () {

        System.setProperty("webdriver.gecko.driver","C:\\DEV\\geckodriver-v0.11.1-win64\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get("https://run.replyapp-dev.net");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void afterMethod (){
        driver.quit();
    }

}

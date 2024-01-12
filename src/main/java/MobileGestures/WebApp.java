package MobileGestures;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class WebApp {
    static AppiumDriver<MobileElement> driver;
    @BeforeTest
    public static void webAppTest() throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("platformName","Android");
        dc.setCapability("deviceName","Android Emulator");
        dc.setCapability("automationName","UIAutomator2");
        dc.setCapability("browserName","Chrome");
        driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"),dc);
    }
    @Test
    public void runWebTest(){
driver.get("https://the-internet.herokuapp.com/login");
driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
MobileElement userName = driver.findElementById("username");
userName.sendKeys("tomsmith");
MobileElement password = driver.findElementById("password");
password.sendKeys("SuperSecretPassword!");
MobileElement login = driver.findElementByXPath("//form[@name=\"login\"]/button");
login.click();
//Assertion
WebElement alert = driver.findElementById("flash");
        WebDriverWait wait = new WebDriverWait(driver,16);
        wait.until(ExpectedConditions.visibilityOf(alert));
    }
}

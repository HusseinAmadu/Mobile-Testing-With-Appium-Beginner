package MobileGestures;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.WaitOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class ClipBoard {
    static AndroidDriver<MobileElement> driver;
    public AndroidTouchAction actions;
    @BeforeTest
    public void EmulatorStartUp() throws MalformedURLException {
        DesiredCapabilities dcc = new DesiredCapabilities();
        dcc.setCapability("platformName","Android");
        dcc.setCapability("deviceName","Android Emulator");
        dcc.setCapability("appPackage","io.selendroid.testapp");
        dcc.setCapability("appActivity","io.selendroid.testapp.HomeScreenActivity");
        //dcc.setCapability("app",System.getProperty("user.dir")+"/src/app/selendroid.apk");
        driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"),dcc);
    }
    @Test
    public void runTest(){
       actions = new AndroidTouchAction(driver);
       MobileElement continueButton = driver.findElementById("com.android.permissioncontroller:id/continue_button");
       waitAction(continueButton);
       continueButton.click();
       actions
               .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)));
       MobileElement alert = driver.findElementById("android:id/button1");
       waitAction(alert);
       alert.click();

       String text = "hello Tau";
       driver.setClipboardText(text);
        MobileElement nameTxt = driver.findElementByAccessibilityId("my_text_fieldCD");
        nameTxt.clear();
        nameTxt.sendKeys(driver.getClipboardText());
        Assert.assertEquals(text,nameTxt.getText());


    }
    public void waitAction(MobileElement mobileElement){
        WebDriverWait wait = new WebDriverWait(driver,16);
        wait.until(ExpectedConditions.visibilityOf(mobileElement));
    }
}

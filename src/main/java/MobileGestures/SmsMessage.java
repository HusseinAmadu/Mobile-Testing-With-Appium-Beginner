package MobileGestures;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class SmsMessage {
    static AndroidDriver<MobileElement> driver;
    public AndroidTouchAction actions;
    @BeforeTest
    public void EmulatorStartUp() throws MalformedURLException {
        DesiredCapabilities dcc = new DesiredCapabilities();
        dcc.setCapability("platformName","Android");
        dcc.setCapability("deviceName","Android Emulator");
        dcc.setCapability("appPackage","com.google.android.apps.messaging");
        dcc.setCapability("appActivity",".ui.ConversationListActivity");
        driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"),dcc);
    }
    @Test
    public void runTest(){
    driver.sendSMS("0303","This is joe");
    }
}

package org.example;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Emulator {
    static AppiumDriver<MobileElement> driver;
 public AndroidTouchAction actions;
    @BeforeClass
    public static void EmulatorStartUp() throws MalformedURLException {
        DesiredCapabilities dcc = new DesiredCapabilities();
        dcc.setCapability("platformName","Android");
        dcc.setCapability("deviceName","Android Emulator");
        dcc.setCapability("appPackage","io.appium.android.apis");
        dcc.setCapability("appActivity",".ApiDemos");
        driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"),dcc);
    }
    @Test
    public void ApiDemosLaunch(){
        actions = new AndroidTouchAction(driver);
        MobileElement clickContinue = driver.findElementById("com.android.permissioncontroller:id/continue_button");
        waitActions(clickContinue);
        clickContinue.click(); 
        MobileElement popUpAlert = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button[2]");
        waitActions(popUpAlert);
        popUpAlert.click();

        MobileElement Views = driver.findElementByAccessibilityId("Views");
        waitActions(Views);
        actions
                .tap(ElementOption.element(Views))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                .perform();

        MobileElement gallery = driver.findElementByAccessibilityId("Gallery");
        actions
                .press(ElementOption.element(gallery))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                .moveTo(PointOption.point(0,-700))
                .release()
                .perform();

    }
    public void waitActions(MobileElement mobileElement){
        WebDriverWait wait = new WebDriverWait(driver,16);
        wait.until(ExpectedConditions.visibilityOf(mobileElement));
    }

}

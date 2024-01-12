package org.example;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Hello world!
 *
 */
public class App 
{
    static AppiumDriver driver;
    @Test
 public static void AndroidStarUp() throws MalformedURLException {
     DesiredCapabilities dc = new DesiredCapabilities();
     dc.setCapability("platformName","Android");
     dc.setCapability("deviceName","Galaxy A32");
     dc.setCapability("platformVersion","13.0");
     //dc.setCapability("automationName","UiAutomator2");
     dc.setCapability("udid","RZ8RC12FFGK");
     dc.setCapability("app",System.getProperty("user.dir")+"/src/app/simple-file-manager-5-3-5.apk");
      // dc.setCapability("appPackage","io.appium.android.apis");
      // dc.setCapability("appActivity",".ApiDemos");
     driver = new AppiumDriver<>(new URL("http://localhost:4723/wd/hub"),dc);
 }
}

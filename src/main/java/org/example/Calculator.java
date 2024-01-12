package org.example;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Calculator {

    static AppiumDriver<MobileElement> driver;
    @BeforeTest
    public static void IniCalculator() throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("platformName","Android");
        dc.setCapability("deviceName","Android Emulator");
        dc.setCapability("appPackage","calculator.free.pro.plus.calc");
        dc.setCapability("appActivity","calculator.free.proplus.ui.CalculatorActivity");
        driver = new AppiumDriver<>(new URL("http://localhost:4723/wd/hub"),dc);
    }
    @Test
    public void PlusFunctions(){
        MobileElement two = driver.findElementById("calculator.free.pro.plus.calc:id/digit_2");
        two.click();
        MobileElement plus = driver.findElementByAccessibilityId("plus");
        plus.click();
        MobileElement seven = driver.findElementById("calculator.free.pro.plus.calc:id/digit_7");
        seven.click();
        MobileElement equals = driver.findElementByAccessibilityId("equals");
        equals.click();
        String rest = driver.findElementById("calculator.free.pro.plus.calc:id/formula").getText();
        Assert.assertEquals(rest,"9");

    }
}

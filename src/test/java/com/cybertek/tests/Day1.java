package com.cybertek.tests;

import io.appium.java_client.AppiumDriver;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Day1 {

    AppiumDriver<MobileElement> driver;

    @Test  //Junit ten
    public void test1() throws MalformedURLException, InterruptedException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        //we use android phone
//   1. Option     desiredCapabilities.setCapability("platformName","Android");
//   2.Option     desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
        //version of android
        desiredCapabilities.setCapability(MobileCapabilityType.VERSION,"8.0");
        //name of the device, if it is real device we need to pass UUID parameter
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_2");

        //either you specify app--> //path /to /app.apk
        //or if app is already installed, you need to specify appActivity and appPackage
        //this info you can find in the internet, at work - ask to developers

        // Set your application's package name. --> appPackage : standart package name
        desiredCapabilities.setCapability("appPackage", "com.android.calculator2");

        // Set your application's MainActivity i.e. the LAUNCHER activity name.     // class name of app
        desiredCapabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");   // Android uygiulamasina gore value degisiyor

/*       "http://localhost:4723/wd/hub")  --> address of the appium server . If we have the appium server on the same computer
//        just use local host
          4723 --> default port number
          Remote Path : /wd/hub
          we need to provide 2 parameters: URL of appium servers and desired capabilities
*/

        driver = new AppiumDriver<>(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);

        Thread.sleep(3000);


        //TEST 2+2 is returning 4
        MobileElement digit2 = driver.findElement(By.id("com.android.calculator2:id/digit_2"));
        //mobileBy child class of by
        MobileElement plus = driver.findElement(MobileBy.AccessibilityId("plus"));
        MobileElement equals = driver.findElement(MobileBy.AccessibilityId("equals"));
        MobileElement result = driver.findElement(By.id("com.android.calculator2:id/result"));


        digit2.click();
        plus.click();
        digit2.click();
        equals.click();

        //get the text of mobile element of result
        String resultText = result.getText();

      //Junit  -> expected, actual
        Assert.assertEquals("4", resultText);
        Thread.sleep(3000);


        //verify 4 * 5 = 20

        MobileElement digit4 = driver.findElement(By.id("com.android.calculator2:id/digit_4"));
        MobileElement digit5 = driver.findElement(By.id("com.android.calculator2:id/digit_5"));
        MobileElement multiply = driver.findElementByAccessibilityId("multiply");


        digit4.click();
        multiply.click();
        digit5.click();
        equals.click();

        resultText = result.getText();
        //verify result is keeping 20
        Assert.assertEquals("20", resultText);


        //50-35 = 15
        MobileElement minus = driver.findElementByAccessibilityId("minus");

        getDigit(5).click();
        getDigit(0).click();
        minus.click();
        getDigit(3).click();
        getDigit(5).click();
        equals.click();

        resultText = result.getText();
        //verify result is keeping 15
        Assert.assertEquals(resultText, "15");

        //close the app at the end
        driver.closeApp();   // close mobile application

    }

    @Test
    public void test2() throws MalformedURLException, InterruptedException {

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,Platform.ANDROID);
        desiredCapabilities.setCapability(MobileCapabilityType.VERSION, "8.0");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_2");
//        desiredCapabilities.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir")+"\\etsy.apk");

        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        //to specify app for testing
        //it can be on your computer or somewhere in cloud

        desiredCapabilities.setCapability("app", "https://cybertek-appium.s3.amazonaws.com/etsy.apk");

        driver = new AppiumDriver<>(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);

        Thread.sleep(5000);

        MobileElement you = driver.findElement(MobileBy.xpath("//android.widget.FrameLayout[@content-desc=\"You tab, 4 of 5\"]/android.widget.ImageView"));

//        MobileElement you = driver.findElement(By.xpath("//android.widget.FrameLayout[@content-desc=\"You tab, 4 of 5\"]/android.widget.ImageView"));
        you.click();
        Thread.sleep(5000);

        MobileElement settings = driver.findElement(By.xpath("//*[@text='Settings']"));
        settings.click();
        Thread.sleep(2000);

        MobileElement checkbox = driver.findElement(By.id("com.etsy.android:id/settings_checkbox"));
        checkbox.click();
        Thread.sleep(4000);

        //verify after click the checkbox it is not selected
        Assert.assertFalse(driver.findElement(By.id("com.etsy.android:id/settings_checkbox")).isSelected());
        Thread.sleep(1000);

        driver.closeApp();
    }

    @Test
    public void realPhone() throws MalformedURLException, InterruptedException {

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,Platform.ANDROID);
        desiredCapabilities.setCapability(MobileCapabilityType.VERSION, "11.0");
        //we used real device, i get this UUID number from terminal with typing "adb devices"
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "LMG910EMW9299564b");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        //to specify app for testing
        //it can be on your computer or somewhere in cloud
        desiredCapabilities.setCapability("app", "https://cybertek-appium.s3.amazonaws.com/etsy.apk");

        driver = new AppiumDriver<>(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);

        Thread.sleep(5000);

        MobileElement you = driver.findElement(MobileBy.xpath("//android.widget.FrameLayout[@content-desc=\"You tab, 4 of 5\"]/android.widget.ImageView"));

//       MobileElement you = driver.findElement(By.xpath("//android.widget.FrameLayout[@content-desc=\"You tab, 4 of 5\"]/android.widget.ImageView"));
        you.click();
        Thread.sleep(2000);

        MobileElement settings = driver.findElement(By.xpath("//*[@text='Settings']"));
        settings.click();
        Thread.sleep(2000);

        MobileElement checkbox = driver.findElement(By.id("com.etsy.android:id/settings_checkbox"));
        checkbox.click();
        Thread.sleep(4000);

        //verify after click the checkbox it is not selected
        Assert.assertFalse(driver.findElement(By.id("com.etsy.android:id/settings_checkbox")).isSelected());
        Thread.sleep(1000);

        driver.closeApp();
    }

    //CREATE A METHOD THAT IS RETURNING MOBILE ELEMENT OF THE DIGIT THAT YOU PASS A PARAMETER

    public  MobileElement getDigit(int digit){
        return driver.findElement(By.id("com.android.calculator2:id/digit_"+ digit));
    }

}

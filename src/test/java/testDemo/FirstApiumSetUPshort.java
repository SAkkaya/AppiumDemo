package testDemo;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class FirstApiumSetUPshort {private AppiumDriver<MobileElement> driver;

    @Test
    public void test(){
        try {
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
            desiredCapabilities.setCapability(MobileCapabilityType.VERSION, "8.0");
//            desiredCapabilities.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir")+"\\etsy.apk");
            desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_2");
            desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 20000);

            desiredCapabilities.setCapability("app", "https://cybertek-appium.s3.amazonaws.com/etsy.apk");
            driver = new AppiumDriver<> (new URL ("http://0.0.0.0:4723/wd/hub"), desiredCapabilities);
                    Thread.sleep(3000);
            WebElement getStarted = driver.findElement(By.xpath("//*[@text='Get Started']"));
            getStarted.click();
            Thread.sleep(3000);
            driver.closeApp();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

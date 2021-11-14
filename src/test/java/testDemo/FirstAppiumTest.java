package testDemo;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class FirstAppiumTest {

    public AppiumDriver driver;


    @Test
    public void test1(){

        AppiumDriver driver = null;
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
//        desiredCapabilities.setCapability("deviceName", "Pixel_2");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_2");
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("version", "8.0");

        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");

        desiredCapabilities.setCapability("app", "https://cybertek-appium.s3.amazonaws.com/etsy.apk");
//        desiredCapabilities.setCapability("app", "https://cybertek-resumes.s3.amazonaws.com/appium
//                Etsy+Handmade+Vintage+Goods_v5.30.0_apkpure.com.apk");
//        desiredCapabilities.setCapability("adbExecTimeout", "20000");
        try {
            driver = new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), desiredCapabilities);  // default url to connect APPIUM API server
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}

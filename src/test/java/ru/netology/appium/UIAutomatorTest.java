package ru.netology.appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

public class UIAutomatorTest {

    private AndroidDriver driver;

    @BeforeEach
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("appium:deviceName", "Some name");
        desiredCapabilities.setCapability("appium:app", "D:\\Work\\android\\2.2 UI Automator\\sample\\app\\build\\intermediates\\apk\\debug\\app-debug.apk");
        desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
        desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
        desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
        desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);

        URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
    }

//    @Test
//    public void emptyTextTest() {
//        MobileElement el1 = (MobileElement) driver.findElementById("ru.netology.testing.uiautomator:id/userInput");
//        el1.click();
//        MobileElement el2 = (MobileElement) driver.findElementById("ru.netology.testing.uiautomator:id/buttonChange");
//        el2.click();
//        MobileElement result = (MobileElement) driver.findElementById("ru.netology.testing.uiautomator:id/textToBeChanged");
//        Assertions.assertEquals("Привет, UiAutomator!", result.getText());
//    }
//
//    @Test
//    public void openActivityTest() {
//        MobileElement el1 = (MobileElement) driver.findElementById("ru.netology.testing.uiautomator:id/userInput");
//        el1.click();
//        el1.sendKeys("student");
//        MobileElement el2 = (MobileElement) driver.findElementById("ru.netology.testing.uiautomator:id/buttonActivity");
//        el2.click();
//        MobileElement newPage = (MobileElement) driver.findElementById("ru.netology.testing.uiautomator:id/text");
//        Assertions.assertEquals("student", newPage.getText());
//    }

    @Test
    public void emptyTextTest(){
    UIAutomatorPage uiAutomatorPage = new UIAutomatorPage(driver);
    uiAutomatorPage.userInput.click();
    uiAutomatorPage.buttonChange.click();
    uiAutomatorPage.result.click();
    Assertions.assertEquals("Привет, UiAutomator!", uiAutomatorPage.result.getText());
    }

    @Test
    public void openActivityTest(){
        UIAutomatorPage uiAutomatorPage = new UIAutomatorPage(driver);
        uiAutomatorPage.userInput.sendKeys("student");
        uiAutomatorPage.buttonActivity.click();
        Assertions.assertEquals("student", uiAutomatorPage.text.getText());
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}


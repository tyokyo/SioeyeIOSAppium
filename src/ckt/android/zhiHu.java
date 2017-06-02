package ckt.android;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
 


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;
 
public class zhiHu {
    private  AndroidDriver  driver;
 
    @BeforeMethod(alwaysRun=true)
    public void setUp() throws Exception {
        // set up appium
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName","LS5501");
        capabilities.setCapability("platformVersion", "6.0.1");
        //if no need install don't add this
        capabilities.setCapability("app", "/Users/Qiang.Zhang/Desktop/software/apk/Sioeye2.0_APP_S11A_100-2.0.68.apk");
        capabilities.setCapability("appPackage", "cn.sioeye.sioeyeapp");
        //support Chinese 
        capabilities.setCapability("unicodeKeyboard" ,"True");
        capabilities.setCapability("resetKeyboard", "True");
        //no need sign
       // capabilities.setCapability("noSign", "false");
        //capabilities.setCapability("appActivity", ".main.MainActivity ");
        driver = new AndroidDriver(new URL("http://10.120.3.115:4724/wd/hub"), capabilities);
    }
 
    @AfterMethod(alwaysRun=true)
    public void tearDown() throws Exception {
        driver.quit();
    }
 
    @Test(groups={"ZHTest"})
    public void Login(){
        //find login button
        WebElement loginButton = driver.findElement(By.id("com.zhihu.android:id/login"));
        loginButton.click();
        
        //wait for 20s
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        
        //find login userName and password editText 
        List<WebElement> textFieldsList = driver.findElementsByClassName("android.widget.EditText");
        textFieldsList.get(0).sendKeys("seleniumcookies@126.com");
        textFieldsList.get(1).sendKeys("cookies123");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        
        //find ok button byName
        driver.findElementByName("OK").click();
        driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
        
        //find keyword 首页 and verify it is display
        Assert.assertTrue( driver.findElement(By.name("首页")).isDisplayed());
        
        
    }
}

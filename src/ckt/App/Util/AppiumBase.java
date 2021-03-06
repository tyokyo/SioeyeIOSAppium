package ckt.App.Util;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.http.NoHttpResponseException;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.log4testng.Logger;

import io.appium.java_client.HidesKeyboard;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class AppiumBase {
	public static IOSDriver<?> iosdriver;
	public static AndroidDriver<?>  androiddriver;
	public static String configPath = "properties/config.properties";
	public static String accountPath = "properties/account.properties";
	private static String udid;;
	private static String devicename ;
	private static String platformName ;
	private static String platformVersion;
	private static String bundleid;
	private static String app ;
	private static String noReset ;
	private static String sessionOverride ;
	private static String ipaddress ;
	private static DesiredCapabilities capabilities;
	private static String port ;
	private static int newCommandTimeout;
	static{
		devicename = Property.getValueByKey(configPath, "deviceName");
		platformName = Property.getValueByKey(configPath, "platformName");
		platformVersion = Property.getValueByKey(configPath, "platformVersion");
		bundleid = Property.getValueByKey(configPath, "bundleid");
		app = Property.getValueByKey(configPath, "app");
		noReset = Property.getValueByKey(configPath, "noReset");
		sessionOverride = Property.getValueByKey(configPath, "sessionOverride");
		ipaddress = Property.getValueByKey(configPath, "ipaddress");
		port = Property.getValueByKey(configPath, "port");
		newCommandTimeout=Integer.parseInt(Property.getValueByKey(configPath, "newCommandTimeout"));
		udid=Property.getValueByKey(configPath, "udid");
		Log.info("udid", udid);
		Log.info("Load the propertyies data for Appium configurations");
	}
	public static int getMaxRunCount(){
		return Integer.parseInt(Property.getValueByKey(configPath, "retryCount"));
	}
	public static void stopAppium(){
		if (androiddriver!=null) {
			androiddriver.quit();;
		}
		if (iosdriver!=null) {
			Log.info("quit ios driver");
			iosdriver.quit();;
		}
		log("stopAppium");
	}
	@SuppressWarnings("rawtypes")
	public static  void startAppium() {
		log("startAppium");
		int  TimeUnitSECONDS = Integer.parseInt(Property.getValueByKey(configPath, "TimeUnitSECONDS"));

		capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, devicename);
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion); 
		capabilities.setCapability(MobileCapabilityType.APP, app);
		if (udid==null) {
			//use simulator 
		}else {
			capabilities.setCapability(MobileCapabilityType.UDID, udid);
		}
		capabilities.setCapability(MobileCapabilityType.NO_RESET,Boolean.parseBoolean(noReset));
		capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, newCommandTimeout);
		//capabilities.setCapability("sessionOverride",Boolean.parseBoolean(sessionOverride));
		capabilities.setCapability("unicodeKeyboard",true);  
		capabilities.setCapability("resetKeyboard", true);  
		//capabilities.setCapability("webDriverAgentUrl", "http://localhost:8100");  
		capabilities.setCapability("automationName","XCUITest");
		//Accept all iOS alerts automatically if they pop up. Default is false.
		capabilities.setCapability("autoAcceptAlerts",true);
		capabilities.setCapability("networkConnectionEnabled",true);
		//https://macacajs.github.io/desired-caps
		//Dismiss all iOS alerts automatically if they pop up. Default is false.
		capabilities.setCapability("autoDismissAlerts",true);
		capabilities.setCapability("keepKeyChains",true);
		capabilities.setCapability("screenshotWaitTimeout",5);
		capabilities.setCapability("clearSystemFiles",true);
		//capabilities.setCapability("waitForAppScript",10);
		//capabilities.setCapability("native-instruments-lib",true);
		if ("IOS".equals(platformName.toUpperCase())) {
			try {
				capabilities.setCapability("bundleid", bundleid);//run on real device 
				boolean sessionNotCreateException = false;
				for (int i = 1; i < 5; i++) {
					if (!sessionNotCreateException) {
						log("start create session iteration-"+i);
						try {
							log("start create session");
							iosdriver = new IOSDriver(new URL(String.format("http://%s:%s/wd/hub",ipaddress,port)), capabilities);
							iosdriver.manage().timeouts().implicitlyWait(TimeUnitSECONDS,TimeUnit.SECONDS);
							log("start create session iteration-"+i +" success");
							sessionNotCreateException=true;
						} catch (SessionNotCreatedException e) {
							// TODO: handle exception
							log("start create session iteration-"+i +" failed");
							sessionNotCreateException=false;
						}
					}
				}
				Log.info("start ios driver");
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if ("ANDROID".equals(platformName.toUpperCase())) {
			try {
				androiddriver = new AndroidDriver(new URL(String.format("http://%s:%s/wd/hub"),ipaddress,port), capabilities);
				androiddriver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}else {
			Log.info("platformName config error.Must be IOS or Android");
		}
	}
	public static void log(String message){
		Log.info(message);
	}
}

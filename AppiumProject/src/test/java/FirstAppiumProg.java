import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class FirstAppiumProg {
	
	static AndroidDriver<MobileElement> driver ;
	
	
	public static void main(String[] args) throws InterruptedException, IOException {
		try {
			    
			driver = getAndroidDriver();
			System.out.println("dddddd");
			driver.quit();
		} catch (MalformedURLException e) {
			System.out.println("Exception in main(): "+e.getLocalizedMessage());
		}
		finally {
			driver.quit();
		}
	}
	
	public static AndroidDriver<MobileElement> getAndroidDriver() throws MalformedURLException {
		try {
			DesiredCapabilities cap = setCapabilities();
			driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
			driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
			return driver;
		} catch (MalformedURLException e) {
			System.out.println("Exception in getAndroidDriver():: "+e.getLocalizedMessage());
			return null;
		}
	}

	public static DesiredCapabilities setCapabilities() throws MalformedURLException {
		try {
			DesiredCapabilities cap = new DesiredCapabilities();
			// for emulator
//			cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
//			cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 5 API 28");
//			cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
//			cap.setCapability(MobileCapabilityType.BROWSER_NAME, "chrome");

			cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 5 API 30");
			cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
			cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
//          cap.setCapability(MobileCapabilityType.APP, "D:\\ApiDemos-debug.apk");
//          cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "io.appium.android.apis.ApiDemos");
//			cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "io.appium.android.apis");
			cap.setCapability(MobileCapabilityType.APP, "C:\\Users\\Admin\\Downloads\\General-Store.apk");
			cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.androidsample.generalstore.MainActivity");
			cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.androidsample.generalstore");
			cap.setCapability(MobileCapabilityType.NO_RESET, true);

			return cap;
		} catch (Exception e) {
			System.out.println("Exception in setCapabilities():: " + e.getLocalizedMessage());
			return null;
		}
	}

}

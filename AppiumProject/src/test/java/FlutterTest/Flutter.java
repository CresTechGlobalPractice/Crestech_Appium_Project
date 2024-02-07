package FlutterTest;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.testsigma.flutter.FlutterFinder;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;

public class Flutter {

	static AppiumDriver<RemoteWebElement> driver;
	String ProductTobuy = "";
	WebDriverWait wait = null;
	boolean storeClosed = false;
	private FlutterFinder find;
	MobileElement browseButton;

	@BeforeTest
	public void setDesiredCapabilities() throws MalformedURLException {

		try {

			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability("pCloudy_Username", "anupama.sharma@crestechsoftware.com");
			capabilities.setCapability("pCloudy_ApiKey", "99n85365pz7mw25sj3gcssxq");
			capabilities.setCapability("pCloudy_DurationInMinutes", 7);
			capabilities.setCapability("newCommandTimeout", 600);
			capabilities.setCapability("launchTimeout", 90000);
			capabilities.setCapability("pCloudy_DeviceFullName", "GOOGLE_Pixel6Pro_Android_13.0.0_49e1a");
		 //   capabilities.setCapability("pCloudy_DeviceFullName", "SAMSUNG_GalaxyS21Plus_Android_13.0.0_e2472");
			capabilities.setCapability("platformVersion", "13.0.0");
			capabilities.setCapability("platformName", "Android");
			capabilities.setCapability("automationName", "uiautomator2");
//			capabilities.setCapability("automationName", "Flutter");
			capabilities.setCapability("pCloudy_ApplicationName", "apprelease.apk");
			capabilities.setCapability("appPackage", "com.yas.app");
			capabilities.setCapability("appActivity", "com.yas.app.MainActivity");
			capabilities.setCapability("pCloudy_WildNet", "false");
			capabilities.setCapability("pCloudy_EnableVideo", "true");
			capabilities.setCapability("pCloudy_EnablePerformanceData", "false");
			capabilities.setCapability("pCloudy_EnableDeviceLogs", "false");
			capabilities.setCapability("autoGrantPermissions", "true");
			// capabilities.setCapability("pCloudy_DeviceFullName", "SM-A217F/DS");
//			capabilities.setCapability("platformVersion", "12.0.0");
			driver = new AndroidDriver<RemoteWebElement>(
					new URL("https://ind-west.pcloudy.com" + "/appiumcloud/wd/hub"), capabilities);
			// driver = new AndroidDriver<RemoteWebElement>(new
			// URL("http://127.0.0.1:4723/wd/hub"),capabilities);
			
			driver.manage().timeouts().implicitlyWait(15000, TimeUnit.MILLISECONDS);
			wait = new WebDriverWait(driver, 10);
			// return capabilities;
		} catch (Exception e) {
			System.out.println("Exception in setCapabilities():: " + e.getLocalizedMessage());
			// return null;
		}

	}

	@Test(priority = 1)
	public void FlutterGuest() throws InterruptedException, IOException {

		// For Stores Closed Section

		try {

			System.out.println("Here");
			TouchAction action = new TouchAction(driver);
			action.tap(new PointOption().withCoordinates(173, 659)).perform();
			Thread.sleep(10000);
			MobileElement browseButton = (MobileElement) driver.findElementByXPath("//*[@content-desc='OKAY']");
			browseButton.click();
			MobileElement skip = (MobileElement) driver.findElementByXPath("//*[@content-desc='Skip']");
			skip.click();
			MobileElement gu = (MobileElement) driver.findElementByXPath("//*[@content-desc='EXPLORE AS GUEST']");
			gu.click();
			Thread.sleep(2000);
			MobileElement re = (MobileElement) driver.findElementByXPath("//*[@content-desc='REMIND ME LATER']");
			re.click();
			MobileElement re1 = (MobileElement) driver.findElementByXPath("//*[@content-desc='REMIND ME LATER']");
			re1.click();
			Thread.sleep(4000);
		} catch (Exception e) {
			System.out.println("Exception in  " + e.getLocalizedMessage());
			// return null;
		}
	}

	@Test(priority = 2)
	public void verifyHomePage() throws InterruptedException {

		MobileElement sk = (MobileElement) driver.findElementByXPath("//*[@content-desc='Yas Guide']");
		sk.click();
		MobileElement sk1 = (MobileElement) driver.findElementByXPath("//*[@content-desc='Attractions']");
		sk1.click();
		Thread.sleep(2000);

	}

	@Test(priority = 3)
	public void verifyFilter() {
		MobileElement topAtt = (MobileElement) driver.findElementByXPath("//*[@content-desc='Top Attractions']");
		Assert.assertTrue(topAtt.isDisplayed(), "Top Attraction not displayed");
		topAtt.click();
		MobileElement hotels = (MobileElement) driver.findElementByXPath("//*[@content-desc='Hotels']");
		System.out.println("Hotel");
		Assert.assertTrue(hotels.isDisplayed(), "Hotels not displayed");
		MobileElement all = (MobileElement) driver.findElementByXPath("//*[@content-desc='All']");
		all.click();
		MobileElement done = (MobileElement) driver.findElementByXPath("//*[@content-desc='DONE']");
		done.click();
		MobileElement all1 = (MobileElement) driver.findElementByXPath("//*[@content-desc='All']");
		Assert.assertTrue(all1.isDisplayed(), "All filter  not displayed");
		System.out.println("Here2");
		System.out.println("end");
		driver.quit();

	}

}

//	@After
//	public void quitDriver() {
//		driver.quit();
//	}
//
//}

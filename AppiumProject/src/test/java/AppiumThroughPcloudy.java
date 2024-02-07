import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;

public class AppiumThroughPcloudy {

	static AppiumDriver<RemoteWebElement> driver;
	String ProductTobuy="";

//	public static void main(String[] args) throws InterruptedException, IOException {}

	@Test
	public void OpeningApp() throws InterruptedException, IOException {
		try {
			
			DesiredCapabilities androidCaps = setDesiredCapabilities();
			driver = new AndroidDriver<RemoteWebElement>(new URL("https://device.pcloudy.com" + "/appiumcloud/wd/hub"),
					androidCaps);
			driver.manage().timeouts().implicitlyWait(7000, TimeUnit.MILLISECONDS);
			
			//Thread.sleep(5000);
			
			
//			MobileElement OpenImage = (MobileElement) driver.findElementByXPath("(//android.view.ViewGroup[@content-desc='image'])[2]");
//			
//			if(OpenImage.isDisplayed())
//			{
//				MobileElement el2 = (MobileElement) driver.findElementByAccessibilityId("mainHeading  is currently closed.");
//				MobileElement el3 = (MobileElement) driver.findElementByXPath("//android.widget.Button[@content-desc='Browse Menu']");
//				
//				if(el2.isDisplayed())
//				{
//					el3.click();
//				}
//				MobileElement el1 = (MobileElement) driver.findElementByAccessibilityId("Start order");
//				el1.click();
//			}
//			else if(el2.isDisplayed())
//			{
//				el3.click();
//			}
//			
			
			
			MobileElement el7 = (MobileElement) driver.findElementByAccessibilityId("Change");
			el7.click();			
			
			MobileElement el8 = (MobileElement) driver.findElementByXPath("//android.widget.Button[@content-desc=\"edit order type\"]/android.widget.TextView");
			el8.click();
	
			
			MobileElement el9 = (MobileElement) driver.findElementByAccessibilityId("Dine In");
			el9.click();
			el9.click();
			
			MobileElement el17 = (MobileElement) driver.findElementByAccessibilityId("Search by State, City, or Zip, Entering text into the input field will trigger the suggestions of search");
			el17.click();
			el17.clear();
			
			el17.sendKeys("nadaun");
			el17.click();
			MobileElement el18 = (MobileElement) driver.findElementByXPath("(//android.widget.TextView[@content-desc=\"Nadaun, Himachal Pradesh, India\"])[1]");
			el18.click();
			
			MobileElement el20 = (MobileElement) driver.findElementByAccessibilityId("Order Now for Test Aloha location");
			el20.click();
			
//			MobileElement el2 = (MobileElement) driver.findElementByAccessibilityId("Delivery");
//			el2.click();
			Thread.sleep(2000);
			
			//MobileElement el1 = (MobileElement) driver.findElementByAccessibilityId("Dine-in");
			//el1.click();
			
			//MobileElement el22 = (MobileElement) driver.findElementByAccessibilityId("Add to cart Peri Peri Match Special");
			MobileElement el22 = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@content-desc,'Add to cart')]");
			el22.click();
			
			MobileElement el23 = (MobileElement) driver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"cart tab4 of 5\"]/android.view.ViewGroup/android.widget.TextView[2]");
			el23.click();
			
//			MobileElement el24 = (MobileElement) driver.findElementByXPath("//android.widget.Button[@content-desc=\"Peri Peri Match Specialfor₹428.58\"]/android.widget.TextView");
//			
//			System.out.println(el24.getText());
//			Assert.assertEquals(el24.getText(), "Peri Peri Match Special");
			
			
			//new TouchAction(driver).longPress(PointOption.point(592, 2150)).moveTo(PointOption.point(710, 470)).release().perform();
			//new TouchAction(driver).longPress(PointOption.point(592, 2150)).moveTo(PointOption.point(710, 470)).release().perform();
			MobileElement el26 = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@content-desc,'Checkout rupees')]/android.view.ViewGroup/android.widget.TextView[2]");
			el26.click();
			
//			MobileElement el25 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]");
//			el25.click();
			
			
			MobileElement el27 = (MobileElement) driver.findElementByXPath("(//android.widget.EditText[@content-desc=\", \"])[1]");
			el27.sendKeys("Abhishek");
			MobileElement el28 = (MobileElement) driver.findElementByAccessibilityId("error");
			el28.sendKeys("9999999999");
			MobileElement el29 = (MobileElement) driver.findElementByXPath("(//android.widget.EditText[@content-desc=\", \"])[2]");
			el29.sendKeys("abc@gmail.com");
			
			
			new TouchAction(driver).longPress(PointOption.point(592, 847)).moveTo(PointOption.point(710, 470)).release().perform();
			
			
			MobileElement el30 = (MobileElement) driver.findElementByXPath("//android.widget.Button[@content-desc=\"Add Payment Method\"]/android.view.ViewGroup/android.widget.TextView");
			el30.click();
			
			Thread.sleep(3000);
			
			new TouchAction(driver).longPress(PointOption.point(592, 1091)).moveTo(PointOption.point(710, 470)).release().perform();
			//driver.hideKeyboard();
			
			MobileElement el31 = (MobileElement) driver.findElementByXPath("//android.widget.RadioButton[@content-desc=\"Cash If you are ordering dine-in/takeaway order, walk to the ordering queue in the store to finish cash payment. not selected\"]/android.view.ViewGroup[1]");
			el31.click();
			MobileElement el32 = (MobileElement) driver.findElementByXPath("//android.widget.Button[@content-desc=\"Submit enabled\"]/android.view.ViewGroup/android.widget.TextView");
			el32.click();
			
			Thread.sleep(3000);
			
			new TouchAction(driver).longPress(PointOption.point(592, 1404)).moveTo(PointOption.point(710, 470)).release().perform();
			
			MobileElement el33 = (MobileElement) driver.findElementByAccessibilityId("Place Order for ₹449.99");
			el33.click();
			
			
			Thread.sleep(20000);
			
			
			MobileElement el34 = (MobileElement) driver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"image\"]/android.view.ViewGroup");
			el34.click();
//			MobileElement el35 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.TextView[1]");
//			System.out.println(el35.getText());
			
			Thread.sleep(10000);
			
			
			driver.quit();
			System.out.println("Working Fine now");
		} catch (MalformedURLException e) {
			System.out.println("Exception in main(): " + e.getLocalizedMessage());
		} finally {
			driver.quit();

		}
	}
	
	
	

	public static DesiredCapabilities setDesiredCapabilities() throws MalformedURLException {

		try {
//			DesiredCapabilities capabilities = new DesiredCapabilities();
//			capabilities.setCapability("pCloudy_Username", "abhishek.dwivedi@crestechsoftware.com");
//			capabilities.setCapability("pCloudy_ApiKey", "xrm3kfqx5vgqddzczb3jm83m");
//			capabilities.setCapability("pCloudy_DurationInMinutes", 20);
//			capabilities.setCapability("newCommandTimeout", 600);
//			capabilities.setCapability("launchTimeout", 90000);
//			capabilities.setCapability("pCloudy_DeviceFullName", "GOOGLE_Pixel7_Android_13.0.0_81870");
//			capabilities.setCapability("platformVersion", "13.0.0");
//			capabilities.setCapability("platformName", "Android");
//			capabilities.setCapability("automationName", "uiautomator2");
//			capabilities.setCapability("pCloudy_ApplicationName", "General-Store.apk");
//			capabilities.setCapability("appPackage", "com.androidsample.generalstore");
//			capabilities.setCapability("appActivity", "com.androidsample.generalstore.MainActivity");
//			capabilities.setCapability("pCloudy_WildNet", "false");
//			capabilities.setCapability("pCloudy_EnableVideo", "false");
//			capabilities.setCapability("pCloudy_EnablePerformanceData", "false");
//			capabilities.setCapability("pCloudy_EnableDeviceLogs", "false");
			// AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(new
			// URL("https://device.pcloudy.com/appiumcloud/wd/hub"), capabilities);

			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability("pCloudy_Username", "abhishek.dwivedi@crestechsoftware.com");
			capabilities.setCapability("pCloudy_ApiKey", "xrm3kfqx5vgqddzczb3jm83m");
			capabilities.setCapability("pCloudy_DurationInMinutes", 7);
			capabilities.setCapability("newCommandTimeout", 600);
			capabilities.setCapability("launchTimeout", 90000);
			capabilities.setCapability("pCloudy_DeviceFullName", "GOOGLE_Pixel7_Android_13.0.0_81870");
			capabilities.setCapability("platformVersion", "13.0.0");
			capabilities.setCapability("platformName", "Android");
			capabilities.setCapability("automationName", "uiautomator2");
			capabilities.setCapability("pCloudy_ApplicationName", "KFC_India.apk");
			capabilities.setCapability("appPackage", "com.yum.kfc");
			capabilities.setCapability("appActivity", "com.cognizantorderserv.kfcindiadroid.MainActivity");
			capabilities.setCapability("pCloudy_WildNet", "false");
			capabilities.setCapability("pCloudy_EnableVideo", "true");
			capabilities.setCapability("pCloudy_EnablePerformanceData", "false");
			capabilities.setCapability("pCloudy_EnableDeviceLogs", "false");
			capabilities.setCapability("autoGrantPermissions", "true");

			return capabilities;
		} catch (Exception e) {
			System.out.println("Exception in setCapabilities():: " + e.getLocalizedMessage());
			return null;
		}

	}

}

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;

public class AppiumThroughPcloudy_New {

	static AppiumDriver<RemoteWebElement> driver;
	String ProductTobuy = "";
	boolean storeClosed=false;

//	public static void main(String[] args) throws InterruptedException, IOException {}
	
	@BeforeMethod
	public void setDesiredCapabilities() throws MalformedURLException {

		try {

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
			
			driver = new AndroidDriver<RemoteWebElement>(new URL("https://device.pcloudy.com" + "/appiumcloud/wd/hub"),
					capabilities);
			driver.manage().timeouts().implicitlyWait(7000, TimeUnit.MILLISECONDS);


			//return capabilities;
		} catch (Exception e) {
			System.out.println("Exception in setCapabilities():: " + e.getLocalizedMessage());
			//return null;
		}

	}

	

	@Test
	public void MakeAnOrderWithoutLogin() throws InterruptedException, IOException {
		try {

			// For Stores Closed Section

			try {
				MobileElement OpenImage = (MobileElement) driver
						.findElementByXPath("(//android.view.ViewGroup[@content-desc='image'])[2]");
				if (OpenImage.isDisplayed()) {
					MobileElement mainHeding = (MobileElement) driver
							.findElementByAccessibilityId("mainHeading  is currently closed.");
					MobileElement browseButton = (MobileElement) driver
							.findElementByXPath("//android.widget.Button[@content-desc='Browse Menu']");

					if (mainHeding.isDisplayed()) {
						
						String mainHeadingisclosed=mainHeding.getText();
						//System.out.println(mainHeadingisclosed);
						browseButton.click();
						if(mainHeadingisclosed.contains("THERE ARE NO STORES OPEN"))
						{
							storeClosed=true;
							MobileElement startOrderBtn = (MobileElement) driver
									.findElementByXPath("//android.widget.Button[contains(@content-desc,'Start Order')]");
							startOrderBtn.click();
							//System.out.println(storeClosed);
						}
						//storeClosed=false;
						
					}
				}
			} catch (NoSuchElementException e) {
				// TODO: handle exception
			}

			
			if(storeClosed==false) {
			// Home Page and selecting Delivery Type and Location

			MobileElement changeButton = (MobileElement) driver.findElementByAccessibilityId("Change");
			changeButton.click();

			MobileElement editorderType = (MobileElement) driver.findElementByXPath(
					"//android.widget.Button[@content-desc=\"edit order type\"]");
			editorderType.click();
			
			}

	/*------------------------- Flow For Selecting Type and Location -------------- */		
			
			MobileElement xpath_DineIn = (MobileElement) driver.findElementByAccessibilityId("Dine In");
			xpath_DineIn.click();
			xpath_DineIn.click();

			//MobileElement select_Location = (MobileElement) driver.findElementByAccessibilityId(
				//	"Search by State, City, or Zip, Entering text into the input field will trigger the suggestions of search");
			MobileElement select_Location = (MobileElement) driver.findElementByXPath(
					"//android.widget.EditText[contains(@content-desc,'Entering text into the input field will trigger the suggestions')]");
												// change done for both closed and open store
			select_Location.click();
			select_Location.clear();
			select_Location.sendKeys("nadaun");
			select_Location.click();

			MobileElement location_Selector = (MobileElement) driver.findElementByXPath(
					"(//android.widget.TextView[@content-desc=\"Nadaun, Himachal Pradesh, India\"])[1]");
			location_Selector.click();

			MobileElement order_forLocation = (MobileElement) driver
					.findElementByAccessibilityId("Order Now for Test Aloha location");
			order_forLocation.click();
			
			
	/*------------------------- End Flow For Selecting Type and Location -------------- */

//			MobileElement el2 = (MobileElement) driver.findElementByAccessibilityId("Delivery");
//			el2.click();
			Thread.sleep(2000);

			// Selecting Product and Checkout

			MobileElement add_toCartButton = (MobileElement) driver
					.findElementByXPath("//android.widget.Button[contains(@content-desc,'Add to cart')]");
			add_toCartButton.click();

			MobileElement cart_Tab = (MobileElement) driver.findElementByXPath(
					"//android.view.ViewGroup[@content-desc=\"cart tab4 of 5\"]/android.view.ViewGroup/android.widget.TextView[2]");
			cart_Tab.click();

			MobileElement checkout_button = (MobileElement) driver.findElementByXPath(
					"//android.widget.Button[contains(@content-desc,'Checkout rupees')]");
			checkout_button.click();

			// Entering User Details and Selecting Payment Type

			MobileElement cust_name = (MobileElement) driver
					.findElementByXPath("(//android.widget.EditText[@content-desc=\", \"])[1]");
			cust_name.sendKeys("Abhishek");
			MobileElement cust_number = (MobileElement) driver.findElementByAccessibilityId("error");
			cust_number.sendKeys("9999999999");
			MobileElement cut_email = (MobileElement) driver
					.findElementByXPath("(//android.widget.EditText[@content-desc=\", \"])[2]");
			cut_email.sendKeys("abc@gmail.com");

			new TouchAction(driver).longPress(PointOption.point(592, 847)).moveTo(PointOption.point(710, 470)).release()
					.perform();

			MobileElement add_payment_type = (MobileElement) driver.findElementByXPath(
					"//android.widget.Button[@content-desc=\"Add Payment Method\"]");
			add_payment_type.click();

			Thread.sleep(3000);

			new TouchAction(driver).longPress(PointOption.point(592, 1091)).moveTo(PointOption.point(710, 470))
					.release().perform();
			// 

			MobileElement cash_option = (MobileElement) driver.findElementByXPath(
					"//android.widget.RadioButton[@content-desc=\"Cash If you are ordering dine-in/takeaway order, walk to the ordering queue in the store to finish cash payment. not selected\"]/android.view.ViewGroup[1]");
			cash_option.click();
			MobileElement payment_submit = (MobileElement) driver.findElementByXPath(
					"//android.widget.Button[@content-desc=\"Submit enabled\"]");
			payment_submit.click();

			Thread.sleep(3000);
			
			// Place Order

			new TouchAction(driver).longPress(PointOption.point(592, 1404)).moveTo(PointOption.point(710, 470))
					.release().perform();

			MobileElement place_Order = (MobileElement) driver
					.findElementByXPath("//android.widget.Button[contains(@content-desc,'Place Order')]");
			place_Order.click();

			Thread.sleep(20000);

			MobileElement el34 = (MobileElement) driver
					.findElementByXPath("//android.widget.Button[@content-desc='Close']");
			el34.click();
//			MobileElement el35 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.TextView[1]");
//			System.out.println(el35.getText());

			Thread.sleep(10000);

			driver.quit();
			System.out.println("Working Fine now");
		} catch (InterruptedException e) {
			System.out.println("Exception in main(): " + e.getLocalizedMessage());
		}
	}
	
	
	@AfterMethod
	public void quitDriver()
	{
		driver.quit();
	}
	

	
}

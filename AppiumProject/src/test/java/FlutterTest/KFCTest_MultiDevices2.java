package FlutterTest;
import java.io.IOException;

import org.apache.log4j.Logger;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.functions.ExpectedCondition;
import io.appium.java_client.touch.offset.PointOption;

public class KFCTest_MultiDevices2 {

	static AppiumDriver<RemoteWebElement> driver;
	String ProductTobuy = "";
	WebDriverWait wait = null;
	boolean storeClosed = false;
	
	Logger log = Logger.getLogger(KFCTest_MultiDevices2.class.getName());

	

	
	@Parameters({"pCloudy_DeviceFullName"})
	@BeforeMethod
	public void setDesiredCapabilities(String pCloudy_DeviceFullName) throws MalformedURLException {

		try {

			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability("pCloudy_Username", "abhishek.dwivedi@crestechsoftware.com");
			capabilities.setCapability("pCloudy_ApiKey", "xrm3kfqx5vgqddzczb3jm83m");
			capabilities.setCapability("pCloudy_DurationInMinutes", 7);
			capabilities.setCapability("newCommandTimeout", 600);
			capabilities.setCapability("launchTimeout", 90000);
			//capabilities.setCapability("pCloudy_DeviceManafacturer", deviceName);
			//capabilities.setCapability("pCloudy_DeviceVersion", "13.0.0");
			capabilities.setCapability("pCloudy_DeviceFullName", pCloudy_DeviceFullName);
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
			
			wait = new WebDriverWait(driver, 10);


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

						String mainHeadingisclosed = mainHeding.getText();
						// System.out.println(mainHeadingisclosed);
						browseButton.click();
						if (mainHeadingisclosed.contains("THERE ARE NO STORES OPEN")) {
							storeClosed = true;
							MobileElement startOrderBtn = (MobileElement) wait
									.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath(
											"//android.widget.Button[contains(@content-desc,'Start Order')]")));
							startOrderBtn.click();
							// System.out.println(storeClosed);
						}
						// storeClosed=false;

					}
				}
			} catch (NoSuchElementException e) {
				// exception
			}

			// Home Page and selecting Delivery Type and Location
			if (storeClosed == false) {
				
				checkWait("//android.widget.Button[@content-desc='Change']");				
				MobileElement changeButton = (MobileElement) driver
						.findElementByXPath("//android.widget.Button[@content-desc='Change']");
						
				changeButton.click();
				
				checkWait("//android.widget.Button[@content-desc='edit order type']");
				MobileElement editorderType = (MobileElement) driver
						.findElementByXPath("//android.widget.Button[@content-desc='edit order type']");
				editorderType.click();
			}

			/*------------------------- Flow For Selecting Type and Location ------------------- */

			MobileElement xpath_DineIn = (MobileElement) wait
					.until(ExpectedConditions.elementToBeClickable(driver.findElementByAccessibilityId("Dine In")));
			xpath_DineIn.click();

			MobileElement select_Location = (MobileElement) driver.findElementByXPath(
					"//android.widget.EditText[contains(@content-desc,'Entering text into the input field will trigger the suggestions')]");
			select_Location.click();
			select_Location.clear();
			select_Location.sendKeys("Nadaun, Himachal Pradesh, India");
			//select_Location.click();

			MobileElement location_Selector = (MobileElement) wait
					.until(ExpectedConditions.visibilityOf(driver.findElementByXPath(
							"(//android.widget.TextView[@content-desc=\"Nadaun, Himachal Pradesh, India\"])[1]")));
			location_Selector.click();

			MobileElement order_forLocation = (MobileElement) wait.until(ExpectedConditions
					.visibilityOf(driver.findElementByAccessibilityId("Order Now for Test Aloha location")));
			order_forLocation.click();

			/*------------------------- End of Flow For Selecting Type and Location -------------- */


			// Selecting Product and Checkout

			MobileElement add_toCartButton = (MobileElement) wait.until(ExpectedConditions.visibilityOf(
					driver.findElementByXPath("//android.widget.Button[contains(@content-desc,'Add to cart')]")));
			add_toCartButton.click();

			MobileElement cart_Tab = (MobileElement) driver.findElementByXPath(
					"//android.view.ViewGroup[@content-desc=\"cart tab4 of 5\"]/android.view.ViewGroup/android.widget.TextView[2]");
			cart_Tab.click();

			MobileElement checkout_button = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(
					driver.findElementByXPath("//android.widget.Button[contains(@content-desc,'Checkout rupees')]")));
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

			MobileElement add_payment_type = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(
					driver.findElementByXPath("//android.widget.Button[@content-desc=\"Add Payment Method\"]")));
			add_payment_type.click();

			Thread.sleep(3000);

			new TouchAction(driver).longPress(PointOption.point(592, 1091)).moveTo(PointOption.point(710, 470))
					.release().perform();
			//

			MobileElement cash_option = (MobileElement) wait
					.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath(
							"//android.widget.RadioButton[@content-desc=\"Cash If you are ordering dine-in/takeaway order, walk to the ordering queue in the store to finish cash payment. not selected\"]/android.view.ViewGroup[1]")));
			cash_option.click();
			MobileElement payment_submit = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(
					driver.findElementByXPath("//android.widget.Button[@content-desc=\"Submit enabled\"]")));
			payment_submit.click();

			Thread.sleep(3000);

			// Place Order

			new TouchAction(driver).longPress(PointOption.point(592, 1404)).moveTo(PointOption.point(710, 470))
					.release().perform();

			MobileElement place_Order = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(
					driver.findElementByXPath("//android.widget.Button[contains(@content-desc,'Place Order')]")));
			place_Order.click();

			Thread.sleep(20000);

			MobileElement el34 = (MobileElement) wait.until(ExpectedConditions
					.elementToBeClickable(driver.findElementByXPath("//android.widget.Button[@content-desc='Close']")));
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
		//driver.quit();
	}
	
	
	public boolean checkWait(String xpath) {
		// MobileElement Selector = null;

		try {
			// Selector = (MobileElement)
			wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath(xpath)));
		} catch (Exception e) {
			// TODO: handle exception
			log.debug("Element is not visible for xpath "+xpath);
			return false;
		}

		try {
			// Selector(MobileElement)
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath(xpath)));

		} catch (Exception e) {
			// TODO: handle exception
			log.error("Element is not clickable for xpath "+xpath);
			return false;
		}
		
		//log.error("Element is visible and clickable for xpath "+xpath);

		return true;

	}

	
}

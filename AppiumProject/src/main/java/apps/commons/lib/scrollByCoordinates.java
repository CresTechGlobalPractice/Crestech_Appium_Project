package apps.commons.lib;

import org.openqa.selenium.remote.RemoteWebElement;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;

public class scrollByCoordinates {
	
	AppiumDriver<RemoteWebElement> driver;
	
	@SuppressWarnings("rawtypes")
	public void Scroll(AppiumDriver<RemoteWebElement> driver,int fromX,int fromY,int toX,int toY)
	{
		new TouchAction(driver).longPress(PointOption.point(fromX, fromY)).moveTo(PointOption.point(toX, toY)).release()
		.perform();
	}

}

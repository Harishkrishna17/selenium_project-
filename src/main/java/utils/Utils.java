package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Utils {

	public static void hardWaitMilliSeconds(int milliSeconds) {
		try {
			TimeUnit.MILLISECONDS.sleep(milliSeconds);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void hardWaitSeconds(int seconds) {
		try {
			TimeUnit.SECONDS.sleep(seconds);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void hardWaitMinutes(int minutes) {
		try {
			TimeUnit.MINUTES.sleep(minutes);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// this method is being used in the ScreenShotOnFailure.class
	public static String createDateForFileName() {
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH-mm-ss");
		return dateFormat.format(date);
	}

	// method to get a certain value from a certain .properties file
	public static String getValueFromPropertiesFile(String value,
			String fileName) {
		Properties prop = new Properties();
		String selectedItem = null;

		try {
			FileInputStream fileInputStream = new FileInputStream(fileName);
			prop.load(fileInputStream);
			selectedItem = prop.getProperty(value);
			fileInputStream.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return selectedItem;
	}

	// method to select the needed browser
	public static DesiredCapabilities getBrowserInstance(String browserName) {
		switch (browserName) {
		case "firefox": {
			DesiredCapabilities capability = DesiredCapabilities.firefox();
			FirefoxProfile firefoxProfile = new FirefoxProfile();
			capability.setCapability(FirefoxDriver.PROFILE, firefoxProfile);
			return capability;
		}
		case "ie": {
			//System.setProperty("webdriver.ie.driver", "C:\\IEDriverServer.exe");
			DesiredCapabilities capability = DesiredCapabilities
					.internetExplorer();
			return capability;
		}
		case "chrome": {
			System.setProperty("webdriver.chrome.driver","D:\\java soft\\selenium\\chromedriver_win32\\chromedriver.exe");
			DesiredCapabilities capability = DesiredCapabilities.chrome();
			return capability;
		}
		default: {
			DesiredCapabilities capability = DesiredCapabilities.firefox();
			return capability;
		}
		}
	}

}

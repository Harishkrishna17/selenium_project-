package templates;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import pages.LoginPage;
import utils.Utils;

public class TestTemplate {

	private DesiredCapabilities capability;
	private ThreadLocal<RemoteWebDriver> threadDriver = null;
	protected LoginPage loginPage;

	// pass the test parameters to @BeforeClass()
	@Parameters({ "browser", "port", "ipAddress", "user", "environment" })
	@BeforeClass(alwaysRun = true)
	public synchronized void beforeTest(String browser, String port,
			String ipAddress, String user, String environment) throws Exception {

		threadDriver = new ThreadLocal<RemoteWebDriver>();
		// here we select which browser we want to use
		capability = Utils.getBrowserInstance(browser);
		// here we set the RemoteWebDriver to be able to use it in Selenium Grid
		threadDriver.set(new RemoteWebDriver(new URL("http://" + ipAddress
				+ ":" + port + "/wd/hub"), capability));
		// here we set the timeout using implicit wait for an element to be
		// found
		getRemoteWebDriver().manage().timeouts()
				.implicitlyWait(35, TimeUnit.SECONDS);
		// here we maximize the window
		getRemoteWebDriver().manage().window().maximize();
		// here we get the testing environment url from .properties file
		getRemoteWebDriver().get(
				Utils.getValueFromPropertiesFile(environment,
						"environment.properties"));
		// instantiate the loginPage and it's WebElements
		loginPage = new LoginPage(getRemoteWebDriver());
		// perform login
		loginPage.login(user);
	}

	@AfterClass(alwaysRun = true)
	public synchronized void afterSuite() throws Exception {
		getRemoteWebDriver().quit();
	}

	public WebDriver getRemoteWebDriver() {
		return threadDriver.get();
	}

}

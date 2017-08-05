package tests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import templates.TestTemplate;

@Listeners(JyperionListener.class)
public class LoginTest extends TestTemplate {

	// the simplest login test
	// login is done in the TestTemplate
	// it is displayed after successful login
	@Test
	public void isUserLoggedIn() {
		// we user Reporter.log() to add some information to our test report
		// generated at the end of tests
		// execution
		Reporter.log("Load testing page title: "
				+ getRemoteWebDriver().getTitle());
		// we user Assert.assertTrue() testNG method to assert a statement
		// if it fails - the test will be displayed as failed
		Assert.assertTrue(getRemoteWebDriver().getTitle()
				.equals("Find a Flight: Mercury Tours:"));
	}

}

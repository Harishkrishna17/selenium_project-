package tests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pages.BookFlightPage;
import pages.FlightConfirmationTestPage;
import templates.TestTemplate;

@Listeners(JyperionListener.class)
public class FlightBookedConfirmtion extends TestTemplate {
	private FlightConfirmationTestPage flightConfirmationTestPage;
	private BookFlightPage bookFlightPage;

	@Test(priority = 0)
	public void isUserLoggedIn() {
		Reporter.log("Sucessfull login: "
				+ getRemoteWebDriver().getTitle());
		Assert.assertTrue(getRemoteWebDriver().getTitle()
				.equals("Find a Flight: Mercury Tours:"));

	}

	// we use dependsOnMethods to structure our tests and to make sure that a
	// method
	// that had dependsOnMethods will be only executed if the method it depends
	// on did not fail,
	// otherwise the remaining tests that have dependencies will be skipped
	@Test(dependsOnMethods = { "isUserLoggedIn" }, priority = 1)
	public void isLoadTestTutorialDownloadable() {
		flightConfirmationTestPage = new FlightConfirmationTestPage(getRemoteWebDriver());
		bookFlightPage = new BookFlightPage(getRemoteWebDriver());
		bookFlightPage.bookFlight();
		Reporter.log("Flight Confirmation: "
				+ getRemoteWebDriver().getTitle());
		String message = flightConfirmationTestPage.getItineraryMessage(); 
		Assert.assertTrue(message
				.equals("Your itinerary has been booked!"));
	}

}

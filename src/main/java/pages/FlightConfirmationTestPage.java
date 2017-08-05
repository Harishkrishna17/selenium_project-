package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Utils;

public class FlightConfirmationTestPage extends PageBase {
	public FlightConfirmationTestPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//table/tbody/tr[3]/td/p/font/b/font[2]")
	private WebElement itineraryMessage;

	public String getItineraryMessage() {
		return itineraryMessage.getText();
	}
}

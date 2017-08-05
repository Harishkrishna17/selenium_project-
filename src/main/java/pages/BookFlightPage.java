package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Utils;


public class BookFlightPage extends PageBase {
	// LoginPage constructor that passes the WebDriver instance to
	// PageBase.class
	// and instantiates it's WebElements using PageFactory
	public BookFlightPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "passCount")
	private WebElement passengersSelectBox;

	@FindBy(name = "fromPort")
	private WebElement departureFromSelectBox;

	@FindBy(name = "toPort")
	private WebElement arrivalAtSelectBox;

	@FindBy(name = "fromMonth")
	private WebElement fromMonthSelectBox;

	@FindBy(name = "toMonth")
	private WebElement toMonthSelectBox;

	@FindBy(name = "airline")
	private WebElement airlineSelectBox;

	@FindBy(name = "findFlights")
	private WebElement findFlightsContinueButton;

	@FindBy(name = "reserveFlights")
	private WebElement reserveFlightsContinueButton;

	@FindBy(name = "buyFlights")
	private WebElement securePurchaseButton;

	@FindBy(name = "passFirst0")
	private WebElement passengerFirstName;
	
	@FindBy(name = "passLast0")
	private WebElement passengerLastName;
	
	@FindBy(name = "pass.0.meal")
	private WebElement passengerMealType;
	
	public void bookFlight() {

		String passengers = Utils.getValueFromPropertiesFile("passengers",
				"user.properties");
		String departurefrom = Utils.getValueFromPropertiesFile("departurefrom",
				"user.properties");
		String arrivalat = Utils.getValueFromPropertiesFile("arrivalat",
				"user.properties");
		String returnon = Utils.getValueFromPropertiesFile("returnon",
				"user.properties");
		String airlines = Utils.getValueFromPropertiesFile("airlines",
				"user.properties");
		String firstName = Utils.getValueFromPropertiesFile("Firstname",
				"user.properties");		
		String lastName = Utils.getValueFromPropertiesFile("Lastname",
				"user.properties");
		String mealType = Utils.getValueFromPropertiesFile("Meal",
				"user.properties");
		
		
		departureFromSelectBox.sendKeys(departurefrom);
		arrivalAtSelectBox.sendKeys(arrivalat);
		toMonthSelectBox.sendKeys(returnon);
		airlineSelectBox.sendKeys(airlines);	
		findFlightsContinueButton.click();
		reserveFlightsContinueButton.click();
		
		passengerFirstName.sendKeys(firstName);
		passengerLastName.sendKeys(lastName);
		passengerMealType.sendKeys(mealType);
		
		securePurchaseButton.click();
	}
}

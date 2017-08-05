package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Utils;

public class LoginPage extends PageBase {
	// LoginPage constructor that passes the WebDriver instance to
	// PageBase.class
	// and instantiates it's WebElements using PageFactory
	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "userName")
	private WebElement userNameInputField;

	@FindBy(name = "password")
	private WebElement passwordInputField;

	@FindBy(name = "login")
	private WebElement loginButton;


	public void login(String user) {

		String username = Utils.getValueFromPropertiesFile(user + "_login",
				"user.properties");
		String password = Utils.getValueFromPropertiesFile(user + "_password",
				"user.properties");
		userNameInputField.sendKeys(username);
		passwordInputField.sendKeys(password);
		loginButton.click();
	}
}

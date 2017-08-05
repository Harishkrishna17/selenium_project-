package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// each page extends this class that has some common methods and WebElements
public abstract class PageBase {

	protected WebDriver driver;

	public PageBase(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Logout")
	private WebElement logoutLink;

	public WebElement getLogoutLink() {
		return logoutLink;
	}

	public WebDriver getWebDriver() {
		return driver;
	}
}

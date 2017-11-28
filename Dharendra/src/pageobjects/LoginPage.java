package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * @doc Methods
	 * @name emailField
	 * @methodOf LoginPage
	 * @description Gets Email Field of Login Page
	 */
	@FindBy(id = "email")
	WebElement emailField;

	/**
	 * @doc Methods
	 * @name passwordField
	 * @methodOf LoginPage
	 * @description Gets Password Field of Login Page
	 */
	@FindBy(id = "pass")
	WebElement passwordField;

	/**
	 * @doc Methods
	 * @name loginButton
	 * @methodOf LoginPage
	 * @description Gets Login Button on Login Page
	 */
	@FindBy(id = "loginbutton")
	WebElement loginButton;

	/**
	 * @doc Methods
	 * @name login
	 * @methodOf LoginPage
	 * @description Login user with correct username and password
	 */
	public void login(String username, String password) {
		emailField.sendKeys(username);
		System.out.println("Entered Username: " + username);
		passwordField.sendKeys(password);
		System.out.println("Entered Password: " + password);
		loginButton.click();
		System.out.println("Clicked on Login button");
	}
}

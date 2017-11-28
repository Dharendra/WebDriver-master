package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import pageobjects.HomePage;
import pageobjects.LoginPage;

public class Testsexrecise {

	public static WebDriver driver;

	@Before
	public void SetUp() {
		FirefoxProfile profile = new FirefoxProfile();
		driver = new FirefoxDriver(profile);
	}

	/**
	 * 
	 * Created by: Dharendra
	 * 
	 * @version 1.0 <br>
	 *          Date Created: 11/28/2017. <br>
	 *          Test Case: Verify Hotel Details Page <br>
	 *          Priority High <br>
	 *          Status: Verified. <br>
	 *          Automated: Yes <br>
	 *          Execution Time: 20 Seconds <br>
	 *          Setup: none. <br>
	 *          <b>Steps:</b> <br>
	 *          Step 1: Go to facebook.com <br>
	 *          Step 2: Enter User name and PAssword <br>
	 *          Step 3: Post on Wall <br>
	 *          Step 4: Close Browser <br>
	 *          <b>Expected results:</b> <br>
	 * @exception None.
	 */

	String userName = ""; // username for facebook
	String password = ""; // password for facebook
	LoginPage login;
	HomePage home;
	Actions action;

	@Test
	public void facebookPost() {
		driver.get("https://www.facebook.com");
		login = new LoginPage(driver);
		home = new HomePage(driver);
		login.login(userName, password);
		home.postStatus("Hello World");
	}

	@Test
	public void review() {
		driver.get("https://wallethub.com/profile/test_insurance_company");
		WebElement about = driver.findElement(By.cssSelector(".wh-rating-choices-holder"));
		action = new Actions(driver);
		action.moveToElement(about).perform();
		driver.findElement(By.xpath("//*[@id='wh-body-inner']/div[2]/div[3]/div[1]/div/a[5]")).click();
		WebElement mySelectElement = driver.findElement(By.cssSelector("i.bf-icon-down-open"));
		Select dropdown = new Select(mySelectElement);
		dropdown.selectByIndex(2);
		driver.findElement(By.id("#review-content")).clear();
		driver.findElement(By.id("#review-content")).sendKeys("Tests1234");
		driver.findElement(By.xpath("//input[@value='Submit']"));

	}

	@After
	public void TearDown() {
		driver.quit();
	}
}

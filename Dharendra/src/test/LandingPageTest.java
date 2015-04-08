package test;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import pageobjects.LandingPage;
import pageobjects.DetailsPage;


public class LandingPageTest {
    
public static WebDriver driver;

@Before
public void SetUp() {
	
	FirefoxProfile profile = new FirefoxProfile(); 
	//Override Firefox Profile for iPhone User Agent
    profile.setPreference("general.useragent.override", "iPhone"); 
    driver = new FirefoxDriver(profile);
    
    // Reposition Firefox Windows for iPhone Screen Size 
    driver.manage().window().setSize(new Dimension(400,700));
}
/**
 * 
 * Created by: Dharendra
 * @version 1.0
 * <br>Date Created:  04/08/2015. 
 * <br>Test Case: Verify Hotels Returned on Landing Page
 * <br>Priority High
 * <br>Status: Verified.
 * <br>Automated: Yes
 * <br>Execution Time: 15 Seconds
 * <br>Setup: none.
 * <br><b>Steps:</b>
 *   <br>Step 1: Go to Landing Page
 *   <br>Step 2: Verify that Hotels are returned on Landing page
 *   <br>Step 3: Close Browser 
 * <br><b>Expected results:</b>
 * <br>
 * @exception None.
 */

    @Test
    public void hotelListTest() {
    	LandingPage lp = new LandingPage(driver);
    	assertTrue(driver.getTitle().contains("HotelTonight - San Diego"));
    	lp.hotelsArePresent();  
    }
    
	@After
	public void TearDown() {
		driver.quit();
	}
}

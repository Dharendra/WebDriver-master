package test;

import static org.junit.Assert.assertEquals;
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
import pageobjects.RegistrationPage;


public class RegistrationTest {
    
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
 * <br>Test Case: Verify Form is being Submitted 
 * <br>Priority High
 * <br>Status: Verified.
 * <br>Automated: Yes
 * <br>Execution Time: 30 Seconds
 * <br>Setup: none.
 * <br><b>Steps:</b>
 *   <br>Step 1: Go to Landing Page
 *   <br>Step 2: Tap on Any Hotel 
 *   <br>Step 3: Verify that Hotel Detail Page is present (Verify Page Title) 
 *   <br>Step 4: Tap on Book now
 *   <br>Step 5: Verify that Hotel Booking Page is present (Verify Page Title) 
 *   <br>Step 6: Enter the First Name, Last Name and Email address 
 *   <br>Step 7: Close Browser 
 * <br><b>Expected results:</b>
 * <br>
 * @exception None.
 */

    @Test
    public void registrationTest() {
    	LandingPage lp = new LandingPage(driver);
    	assertTrue(driver.getTitle().contains("HotelTonight - San Diego"));
  
    	DetailsPage dp = lp.navigation(5);
    	assertTrue(driver.getTitle().contains("HotelTonight - San Diego"));
    	RegistrationPage rp = dp.navigation();
    	assertTrue(driver.getTitle().contains("HotelTonight - San Diego"));
    	rp.firstName();
    	rp.lastName();
    	rp.enterEmail();
    	rp.book();	
        
    }
    
	@After
	public void TearDown() {
		driver.quit();
	}
}
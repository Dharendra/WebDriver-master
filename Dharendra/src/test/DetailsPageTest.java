package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import pageobjects.LandingPage;
import pageobjects.DetailsPage;


public class DetailsPageTest {
    
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
 * <br>Test Case: Verify Hotel Details Page 
 * <br>Priority High
 * <br>Status: Verified.
 * <br>Automated: Yes
 * <br>Execution Time: 20 Seconds
 * <br>Setup: none.
 * <br><b>Steps:</b>
 *   <br>Step 1: Go to Landing Page
 *   <br>Step 2: Get the Data (Hotel Name,Category,Price) for First Hotel on the List 
 *   <br>Step 3: Tap on First Hotel 
 *   <br>Step 4: Verify that Hotel Detail Page is present (Verify Page Title)
 *   <br>Step 5: Get Hotel Data (Hotel Name,Category,Price)
 *   <br>Step 6: Compare From Details Page to Landing page
 *   <br>Step 7: Verify that Other Elements like Why We Like It,Hotel Amenities,Room Details,Food Options,Need to Know are present
 *   <br>Step 8: Close Browser 
 * <br><b>Expected results:</b>
 * <br>
 * @exception None.
 */

    @Test
    public void verifyDataIsDisplayedTest() {
    	LandingPage lp = new LandingPage(driver);
    	assertTrue(driver.getTitle().contains("HotelTonight - San Diego"));
    	String S1 = lp.getHotelName();
    	String S2 = lp.getHotelPrice();
    	String S3 = lp.getHotelCategory();
    	DetailsPage dp = lp.navigation(0);
    	assertTrue(driver.getTitle().contains("HotelTonight - San Diego"));
    	assertEquals("Hotel Name Does not Match ",S1 ,dp.getHotelName());
    	assertEquals("Hotel Price Does not Match",S2 ,dp.getHotelPrice());
    	assertEquals("Hotel Categories Does not Match",S3 ,dp.getHotelCategory());
    	assertEquals("Why We Like It Text is not present ","Why We Like It" ,dp.getlikeIT());
    	assertEquals("Hotel Amenities Text is not present ","Hotel Amenities" ,dp.getAmenities());
    	assertEquals("Room Details Text is not present","Room Details" ,dp.getRoomDetails());
    	assertEquals("Food Options Text is not present","Food Options" ,dp.getfoodOptions());
    	assertEquals("Need to Know Text is not present","Need to Know" ,dp.getNeedToKnow());
        
    }
    
	@After
	public void TearDown() {
		driver.quit();
	}
}
